package Xml;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class represents an extendable Loader for XML-files. It provides all basic methods necessary to load such files.
 *
 */
public abstract class XmlLoaderExtension {

	protected final Set<XmlLoaderExtension> extensions = new HashSet<XmlLoaderExtension>();
	protected final Set<URI> supportedURIs = new HashSet<URI>();
	protected final Map<XmlQName, Class<? extends XmlType>> nameClassMap = new HashMap<XmlQName, Class<? extends XmlType>>();
	protected final Map<XmlQName, String> selfrefferingGroupPatternMap = new HashMap<XmlQName, String>();

	
	protected ExecutorService execService;
	
	/**
	 * @param extensions A set of extensions, that should extend this loader
	 * @param execService An ExecutorService used for parallelization
	 * @param supportedURIs A set of URIs of namespaces supported by this loader.
	 * @param nameClassMap A map, that maps qualified names of types to their corresponding class.
	 * @param selfrefferingGroupPatternMap A map of patterns for groups, that refer to themself. See {@link XmlComplexType#matchChildPattern(String pattern, String childrenString)} for details.
	 */
	protected XmlLoaderExtension(Set<XmlLoaderExtension> extensions, ExecutorService execService, Set<URI> supportedURIs, Map<XmlQName, Class<? extends XmlType>> nameClassMap, Map<XmlQName, String> selfrefferingGroupPatternMap) {
		for(XmlLoaderExtension ext: extensions){
			extend(ext);
		}
		setThreadPool(execService);
		if(supportedURIs != null){
			this.supportedURIs.addAll(supportedURIs);
		}
		if(nameClassMap != null){
			this.nameClassMap.putAll(nameClassMap);
		}
		if(selfrefferingGroupPatternMap != null){
			this.selfrefferingGroupPatternMap.putAll(selfrefferingGroupPatternMap);
		}
	}
	
	/**
	 * @param extensions A set of extensions, that should extend this loader
	 * @param execService An ExecutorService used for parallelization
	 */
	public XmlLoaderExtension(Set<XmlLoaderExtension> extensions, ExecutorService execService) {
		this(extensions, execService, null, null, null);
	}
	
	/**
	 * @param extensions A set of extensions, that should extend this loader
	 */
	public XmlLoaderExtension(Set<XmlLoaderExtension> extensions) {
		this(extensions, null);
	}
	
	/**
	 * <p>Sets the ExecutorService for this loader and all its extensions, that had the same old ExecutorService(or no ExecutorService)</p>
	 * <p>Any old ExecutorService used by this loader will be shut down using the {@link java.util.concurrent.ExecutorService#shutdown()} method.</p>
	 * 
	 * @param execService The new ExecutorService used for parallelization
	 */
	public void setThreadPool(ExecutorService execService) {
		ExecutorService oldExecService = this.execService;
		this.execService = execService;
		for(XmlLoaderExtension extension : extensions){
			if(extension.execService == null || extension.execService.equals(oldExecService)){
				extension.setThreadPool(execService);
			}
		}
		if(oldExecService != null && !oldExecService.equals(execService)){
			oldExecService.shutdown();
		}
	}
	
	/**
	 * <p>Loads the given Element</p>
	 * <p>This will call a create method for all attributes and children of this element</p>
	 * 
	 * @param elem The element to be loaded
	 * @throws IOException If an IOException occurred during file operations
	 */
	public final void load(XmlComplexType elem) throws IOException {
		Queue<XmlComplexType> queue = new ArrayDeque<XmlComplexType>();
		XmlComplexType current = elem;
		do{
			Field field;
			Map<String, XmlQName> attributesNameMap;
			Map<XmlQName, XmlQName> childrenNameMap;
			try {
				field = current.getClass().getDeclaredField("ATTRIBUTES_NAME_MAP");
				field.setAccessible(true);
				@SuppressWarnings("unchecked")//All Subtypes should override that field.
				Map<String, XmlQName> tmp = ((Map<String, XmlQName>) field.get(null));
				attributesNameMap = tmp;
				
				field = current.getClass().getDeclaredField("CHILDREN_NAME_MAP");
				field.setAccessible(true);
				@SuppressWarnings("unchecked")//All Subtypes should override that field.
				Map<XmlQName, XmlQName> tmp2 = ((Map<XmlQName, XmlQName>) field.get(null));
				childrenNameMap = tmp2;
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				throw new AssertionError("Should not reach this state!", e);
			}
			for(Map.Entry<String, XmlSimpleType> entry : current.attributes.entrySet()){
				if(entry.getValue().getClass().equals(XmlSimpleTypePlaceholder.class)){
					XmlQName qualifiedName = attributesNameMap.get(entry.getKey());
					if(qualifiedName == null){
						qualifiedName = new XmlQName(null, entry.getKey());
					}
					XmlSimpleType newAttr = ((XmlSimpleTypePlaceholder) entry.getValue()).load(qualifiedName);
					newAttr.setQualifiedName(attributesNameMap.get(entry.getKey()));
					current.attributes.put(entry.getKey(), newAttr);
				}
			}
			if(current.children == null){
				current.loadChildren(true, current.getClass());
			}
			for(int i=0;i<current.children.length;++i){
				XmlQName type = childrenNameMap.get(current.children[i].qualifiedName);
				if(type == null){
					current.children[i] = create(current.children[i]);
				}else{
					current.children[i] = create(current.children[i], type);
				}
				if(current.children[i] instanceof XmlComplexType){
					queue.add((XmlComplexType) current.children[i]);
				}
			}
			current = queue.poll();
		}while(queue.size() > 0);
	}
	
	/**
	 * This is equivalent to a call of {@link #create(XmlType elem, XmlQName qualifiedName)} with {@code elem.qualifiedName} as last parameter.
	 * 
	 * @param elem The element to be created
	 * @return The created element
	 * @throws IOException If an IOException occurred during file operations
	 */
	public final XmlType create(XmlType elem) throws IOException {
		return create(elem, elem.qualifiedName);
	}
	
	/**
	 * <p>This method creates a element of a class determined by {@code qualifiedName} using {@code elem}.</p>
	 * <p>If {@code qualifiedName} is null or the type could not be associated with a class or the {@code qualifiedName.namespace} is not a supported namespace, null is returned.</p>
	 * <p>Otherwise, a constructor of the class is called using this element or this elements value as parameter.</p>
	 * 
	 * @param elem The element to be created
	 * @param qualifiedName The qualified name of the type of the element
	 * @return The created element
	 * @throws IOException If an IOException occurred during file operations
	 */
	public final XmlType create(XmlType elem, XmlQName qualifiedName) throws IOException {
		Class<? extends XmlType> typeClass = nameClassMap.get(qualifiedName);
		if(typeClass == null || qualifiedName == null || !supportedURIs.contains(qualifiedName.namespace)){
				return elem;
		}
		try{
			if(XmlSimpleType.class.isAssignableFrom(typeClass)){
				if(XmlSimpleType.class.isAssignableFrom(elem.getClass())){
					if(elem.getClass().equals(XmlSimpleTypePlaceholder.class)){
						return typeClass.getDeclaredConstructor(XmlSimpleType.class, String.class).newInstance(elem, ((XmlSimpleTypePlaceholder) elem).getDataAsString());
					}else if(elem.getClass().equals(typeClass)){
						return elem;
					}else{
						return typeClass.getDeclaredConstructor(XmlSimpleType.class, String.class).newInstance(elem, ((XmlSimpleType) elem).getValue().toString());
					}
				}else{
					XmlSimpleTypePlaceholder tmp;
					if(((XmlComplexType) elem).children != null && ((XmlComplexType) elem).children.length > 0 &&
						((XmlComplexType) elem).children[0] != null && XmlSimpleTypePlaceholder.class.isAssignableFrom(((XmlComplexType) elem).children[0].getClass())){
						tmp = (XmlSimpleTypePlaceholder) ((XmlComplexType) elem).children[0];
					}else{
						tmp = new XmlSimpleTypePlaceholder(elem.file, elem.path, elem.parent, elem.qualifiedName, elem.pos, elem.length);
					}
					return typeClass.getDeclaredConstructor(XmlSimpleType.class, String.class).newInstance(tmp, tmp.getDataAsString());
				}
			}else{
				return typeClass.getDeclaredConstructor(XmlComplexType.class).newInstance(elem);
			}
		}catch(NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException | SecurityException e){
			throw new AssertionError("Should not reach this state!", e);
		}
	}
	
	/**
	 * Returns a set of supported namespaces.
	 * 
	 * @return The set of supported namespaces
	 */
	public final Set<URI> getSupportedURIs(){
		return supportedURIs;
	}
	
	/**
	 * <p>Calls {@link #create(XmlType elem)} for every element of {@code elems} and returns the result.</p>
	 * <p>If {@code elems} is {@code null} or if {@code elems.length} is {@code 0}, {@code null} is returned</p>
	 * 
	 * <p>If the ExecutorService of this loaders is not {@code null}, the {@link #createParallel(XmlType[] elems)} method is called.</p>
	 * 
	 * @param elems The elements to be created
	 * @return The created elements
	 * @throws InterruptedException If an InterruptedException is thrown by {@link #createParallel(XmlType[] elems)}.
	 * @throws ExecutionException If an ExecutionException is thrown by {@link #createParallel(XmlType[] elems)}.
	 * @throws IOException If an IOException occurred during file operations
	 */
	public final XmlType[] create(XmlType[] elems) throws InterruptedException, ExecutionException, IOException {
		if(execService != null) {
			return createParallel(elems);
		}else {
			if(elems == null || elems.length == 0) {
				return null;
			}
			XmlType[] ret = new XmlType[elems.length];
			for(int i=0;i<elems.length;++i) {
				ret[i] = create(elems[i]);
			}
			return ret;
		}
	}
	
	/**
	 * This is equivalent to a call of {@link #createParallel(XmlType[] elems, ExecutorService execService)} with this loaders ExecutorService as last parameter.
	 * 
	 * @param elems The elements to be created
	 * @return The created elements
	 * @throws InterruptedException If an InterruptedException is thrown by {@link #createParallel(XmlType[] elems, ExecutorService execService)}.
	 * @throws ExecutionException If an ExecutionException is thrown by {@link #createParallel(XmlType[] elems, ExecutorService execService)}.
	 */
	public final XmlType[] createParallel(XmlType[] elems) throws InterruptedException, ExecutionException {
		return createParallel(elems, execService);
	}
	
	/**
	 * <p>Calls {@link #create(XmlType elem)} for every element(This is done in parallel) of {@code elems} and returns the result.</p>
	 * <p>If {@code elems} is {@code null} or if {@code elems.length} is {@code 0}, {@code null} is returned</p>
	 * 
	 * @param elems The elements to be created
	 * @param execService The ExecutorService used for parallelization.
	 * @return The created elements
	 * @throws InterruptedException If an InterruptedException is thrown in parallelization context
	 * @throws ExecutionException If an ExecutionException is thrown in parallelization context
	 */
	public final XmlType[] createParallel(XmlType[] elems, ExecutorService execService) throws InterruptedException, ExecutionException {
		if(elems == null || elems.length == 0) {
			return null;
		}
		XmlType[] ret = new XmlType[elems.length];
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<Void>> futures =  new ArrayList<Future<Void>>(elems.length);
		for(int i=0;i<elems.length;++i) {
			futures.add(execService.submit(new Callable<Void>() {
				@Override
				public Void call() throws IOException {
					int i = index.getAndIncrement();
					ret[i] = create(elems[i]);
					return null;
				}
			}));
		}
		for(Future<Void> future: futures) {
			future.get();
		}
		return ret;
	}
	
	/**
	 * <p>Calls {@link #load(XmlComplexType elem)} for every element of {@code elems}.</p>
	 * 
	 * <p>If the ExecutorService of this loaders is not {@code null}, the {@link #loadParallel(XmlComplexType[] elems)} method is called.</p>
	 * 
	 * @param elems The elements to be loaded
	 * @throws InterruptedException If an InterruptedException is thrown by {@link #loadParallel(XmlComplexType[] elems)}.
	 * @throws ExecutionException If an ExecutionException is thrown by {@link #loadParallel(XmlComplexType[] elems)}.
	 * @throws IOException If an IOException occurred during file operations
	 */
	public final void load(XmlComplexType[] elems) throws InterruptedException, ExecutionException, IOException {
		if(execService != null) {
			loadParallel(elems);
		}else {
			for(int i=0;i<elems.length;++i) {
				load(elems[i]);
			}
		}
	}
	
	/**
	 * This is equivalent to a call of {@link #loadParallel(XmlComplexType[] elems, ExecutorService execService)} with this loaders ExecutorService as last parameter.
	 * 
	 * @param elems The elements to be loaded
	 * @throws InterruptedException If an InterruptedException is thrown by {@link #loadParallel(XmlComplexType[] elems, ExecutorService execService)}.
	 * @throws ExecutionException If an ExecutionException is thrown by {@link #loadParallel(XmlComplexType[] elems, ExecutorService execService)}.
	 */
	public final void loadParallel(XmlComplexType[] elems) throws InterruptedException, ExecutionException {
		loadParallel(elems, execService);
	}
	
	/**
	 * <p>Calls {@link #load(XmlComplexType elem)} for every element(This is done in parallel) of {@code elems}.</p>
	 * 
	 * @param elems The elements to be loaded
	 * @param execService The ExecutorService used for parallelization.
	 * @throws InterruptedException If an InterruptedException is thrown in parallelization context
	 * @throws ExecutionException If an ExecutionException is thrown in parallelization context
	 */
	public final void loadParallel(XmlComplexType[] elems, ExecutorService execService) throws InterruptedException, ExecutionException {
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<Void>> futures =  new ArrayList<Future<Void>>(elems.length);
		for(int i=0;i<elems.length;++i) {
			futures.add(execService.submit(new Callable<Void>() {
				@Override
				public Void call() throws InterruptedException, ExecutionException, IOException {
					int i = index.getAndIncrement();
					load(elems[i]);
					return null;
				}
			}));
		}
		for(Future<Void> future: futures) {
			future.get();
		}
	}
	
	/*
	 * Adds extension to current extension set
	 * 
	 * Two extensions may not return both true on load(elem) for the same elem
	 * Two extensions may not return both not-null on create(elem) for the same elem
	 * The user must ensure, that this does not happen.
	 * An extension may return true/not-null for the same elem as it's parent(this). This will override the operation
	 * */
	/**
	 * <p>Adds the extension to this objects extension set. This also calls {@link #setThreadPool(ExecutorService execService)} on them with the current ExecutorService.</p>
	 * <p>All extensions of {@code ext} will be added to this objects extension set.</p>
	 * <p>All entries of {@code ext}s supportedURIs will be added in this objects supportedURIs.</p>
	 * <p>All entries of {@code ext}s nameClassMap will be put in this objects nameClassMap.(Overriding existing entries!).</p>
	 * <p>All entries of {@code ext}s selfrefferingGroupPatternMap will be put in this objects selfrefferingGroupPatternMap.(Overriding existing entries!).</p>
	 * 
	 * @param ext The extension to be added.
	 */
	public final void extend(XmlLoaderExtension ext) {
		ext.setThreadPool(execService);
		extensions.add(ext);
		if(ext.extensions != null){
			extensions.addAll(ext.extensions);
		}
		if(ext.getSupportedURIs() != null){
			supportedURIs.addAll(ext.getSupportedURIs());
		}
		if(ext.nameClassMap != null){
			nameClassMap.putAll(ext.nameClassMap);
		}
		if(ext.selfrefferingGroupPatternMap != null){
			selfrefferingGroupPatternMap.putAll(ext.selfrefferingGroupPatternMap);
		}
	}
	
	/**
	 * Returns the pattern of the selfreffering group associated with {@code qualifiedName}.
	 * 
	 * @param qualifiedName The qualified name, which refers to the selfreffering group.
	 * @return The pattern of the selfreffering group associated with {@code qualifiedName} or null, if none exists.
	 */
	public final String getSelfrefferingGroupPattern(XmlQName qualifiedName){
		return selfrefferingGroupPatternMap.get(qualifiedName);
	}
	
	/*
	@FunctionalInterface
	public interface ThrowingConsumer<T, E extends Throwable> {
	    void accept(T t) throws E;
	}
	
	static <T, E extends Throwable> Consumer<T> handlingConsumerWrapper(
			ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {

		return i -> {
			try {
				throwingConsumer.accept(i);
			} catch (Throwable ex) {
				try {
					E exCast = exceptionClass.cast(ex);
					System.err.println(
							"Exception occured : " + exCast.getMessage());
				} catch (ClassCastException ccEx) {
					throw new RuntimeException(ex);
				}
			}
		};
	}
	*/
}
