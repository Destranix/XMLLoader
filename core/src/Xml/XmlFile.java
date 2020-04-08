package Xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Xml.XmlTag.TagType;
import XmlSimpleTypes.XmlNCName;

/**
 * <p>This Class represents a XML-file.</p>
 * <p>It holds the actual filehandle and common data like configuration or the used loader. It's also used to retrieve the documents roots and its prolog.</p>
 *
 */
public class XmlFile {
	
	protected static final URI xs;
	protected static final URI xml;
	/**
	 * The default namespaceMap used by functions of this objects and of elements of this file.
	 */
	public static final Map<String, URI> DEFAULT_NAMESPACE_MAP = new HashMap<String, URI>();
	static{
		try{
			 xs = new URI("http://www.w3.org/2001/XMLSchema");
			 xml = new URI("https://www.w3.org/2001/XML");
		} catch (URISyntaxException e) {
			throw new AssertionError("URI not parsable", e);
		}
		
		DEFAULT_NAMESPACE_MAP.put("xs", xs);
		DEFAULT_NAMESPACE_MAP.put("xml", xml);
		
	}
	
	
	protected static Map<String, String> ENTITIES = new HashMap<String, String>();
	
	private final File targetFile;
	private final Queue<RandomAccessFile> readFiles = new ArrayDeque<RandomAccessFile>(1);
	private final Queue<RandomAccessFile> writeFiles = new ArrayDeque<RandomAccessFile>(0);
	private final Queue<RandomAccessFile> readWriteFiles = new ArrayDeque<RandomAccessFile>(0);
	private final Set<RandomAccessFile> assignedReadFiles = ConcurrentHashMap.newKeySet(1);
	private final Set<RandomAccessFile> assignedWriteFiles = ConcurrentHashMap.newKeySet(0);
	private final Set<RandomAccessFile> assignedReadWriteFiles = ConcurrentHashMap.newKeySet(0);
	
	protected Charset charset = StandardCharsets.UTF_8;
	
	/**
	 * <p>The XML-Declaration tag of this document.</p>
	 */
	public XmlTag prolog;
	protected XmlComplexType[] roots;
	
	protected boolean LOAD_SIMPLE_TYPE_VALUES;
	protected boolean EXACT_DOCTYPE_PATTERN;
	protected int GET_VALUES_FREE_DEPTH = 1;
	
	protected final Map<String, XmlType> idMap = new HashMap<String, XmlType>();
	
	/**
	 * <p>The loader, which is responsible for loading elements associated with this file</p>
	 */
	public XmlLoaderExtension loader;
	
	/**
	 * @param file The target file, which contains the XML-data
	 * @throws FileNotFoundException if the given file does not exist.(More specific: When {@link java.io.RandomAccessFile#RandomAccessFile(File file, String mode)} called with {@code file} as first and "r" as second parameter throws an FileNotFoundException.)
	 */
	public XmlFile(File file) throws FileNotFoundException {
		this.targetFile = file;
		this.readFiles.add(new RandomAccessFile(file, "r"));
	}
	
	/**
	 * This is equivalent to a call of {@link XmlFile#XmlFile(File file)} with {@code new File(filepath)} as parameter.
	 * 
	 * @param filepath The path to the target file
	 * @throws FileNotFoundException if the given file does not exist.(More specific: When {@link java.io.RandomAccessFile#RandomAccessFile(File file, String mode)} called with {@code file} as first and "r" as second parameter throws an FileNotFoundException.)
	 */
	public XmlFile(String filepath) throws FileNotFoundException {
		this(new File(filepath));
	}
	
	/**
	 * <p>Creates a copy of the given XmlFile object copying all of its fields.</p>
	 * <p><b>Note:</b> Be aware, that concurrent manipulations of the given file may cause unexpected results.</p>
	 * 
	 * @param file The XmlFile object, which's data should be copied.
	 * @throws FileNotFoundException if the given file does not exist.(More specific: When {@link java.io.RandomAccessFile#RandomAccessFile(File file, String mode)} called with {@code file} as first and "r" as second parameter throws an FileNotFoundException.)
	 */
	public XmlFile(XmlFile file) throws FileNotFoundException {
		this.targetFile = file.targetFile;
		this.readFiles.addAll(file.readFiles);
		this.writeFiles.addAll(file.writeFiles);
		this.readWriteFiles.addAll(file.readWriteFiles);
		this.assignedReadFiles.addAll(file.assignedReadFiles);
		this.assignedWriteFiles.addAll(file.assignedWriteFiles);
		this.assignedReadWriteFiles.addAll(file.assignedReadWriteFiles);
		this.charset = file.charset;
		this.prolog = file.prolog;
		this.roots = file.roots;
		this.LOAD_SIMPLE_TYPE_VALUES = file.LOAD_SIMPLE_TYPE_VALUES;
		this.EXACT_DOCTYPE_PATTERN = file.EXACT_DOCTYPE_PATTERN;
		this.GET_VALUES_FREE_DEPTH = file.GET_VALUES_FREE_DEPTH;
		this.idMap.putAll(file.idMap);
		this.loader = file.loader;
	}
	
	/**
	 * @return The URL of the {@code targetFile}
	 * @throws MalformedURLException If the URL of the {@code targetFile} is malformed
	 */
	public URL getFileURL() throws MalformedURLException {
		return targetFile.toURI().toURL();
	}
	
	/**
	 * <p>Sets the Value of the {@code LOAD_SIMPLE_TYPE_VALUES} field.</p>
	 * <p>If {@code LOAD_SIMPLE_TYPE_VALUES} is {@code true}, the values of simple types will be directly stored in local memory on indexing the file.</p>
	 * 
	 * @param value The value {@code LOAD_SIMPLE_TYPE_VALUES} should be set to.
	 */
	public void setLoadSimpleTypeValues(boolean value){
		this.LOAD_SIMPLE_TYPE_VALUES = value;
	}
	
	/**
	 * @return The value of the {@code LOAD_SIMPLE_TYPE_VALUES} field
	 * 
	 * @see #setLoadSimpleTypeValues(boolean value)
	 */
	public boolean getLoadSimpleTypeValues(){
		return this.LOAD_SIMPLE_TYPE_VALUES;
	}
	
	/**
	 * <p>Sets the Value of the {@code EXACT_DOCTYPE_PATTERN} field.</p>
	 * <p>If {@code EXACT_DOCTYPE_PATTERN} is {@code true}, the an exact pattern is used for DOCTYPE-Declarations when parsing parts of this file
	 * <br>
	 * Otherwise an approximative pattern is used.
	 * </p>
	 * <p><b>Note:</b> Setting this option to {@code true} may have a large impact on performance. Currently, it is not recommended to do this.</p>
	 * 
	 * @param value The value {@code EXACT_DOCTYPE_PATTERN} should be set to.
	 */
	public void setExactDoctypePattern(boolean value){
		this.EXACT_DOCTYPE_PATTERN = value;
	}
	
	/**
	 * @return The value of the {@code EXACT_DOCTYPE_PATTERN} field
	 * 
	 * @see #setExactDoctypePattern(boolean value)
	 */
	public boolean getExactDoctypePattern(){
		return this.EXACT_DOCTYPE_PATTERN;
	}
	
	/**
	 * <p>Sets the Value of the {@code GET_VALUES_FREE_DEPTH} field.</p>
	 * <p>The {@code GET_VALUES_FREE_DEPTH} option controls, if elements are freed after fetching values by path using such a method of {@linkplain XmlComplexType}.</p>
	 * <p>The default is 1</p>
	 * 
	 * @param value The value {@code GET_VALUES_FREE_DEPTH} should be set to.
	 * 
	 * @see XmlComplexType#freeElements(XmlType[] elements, int depth)
	 * @see XmlComplexType#getValuesByPath(XmlComplexType parent, String path, Object[] array, Class parentClass)
	 */
	public void setGetValuesFreeDepth(int value){
		this.GET_VALUES_FREE_DEPTH = value;
	}
	
	
	/**
	 * @return The value of the {@code GET_VALUES_FREE_DEPTH} field
	 * 
	 * @see #setGetValuesFreeDepth(int value)
	 */
	public int getGetValuesFreeDepth(){
		return this.GET_VALUES_FREE_DEPTH;
	}
	
	
	/**
	 * Sets the loader of this file.
	 * 
	 * @param loader The value of the loader to be set.
	 */
	public void setLoader(XmlLoaderExtension loader){
		this.loader = loader;
	}
	
	/**
	 * Loads the first root of this file and returns it.
	 * 
	 * @return The loaded, first root of this file.
	 * @throws IOException If an IOException was thrown by {@link XmlLoaderExtension#create(XmlType elem)}.
	 */
	public XmlComplexType getRoot() throws IOException {
		if(XmlComplexType.class.equals(roots[0].getClass())){
			roots[0] = (XmlComplexType) loader.create(roots[0]);
		}
		return roots[0];
	}
	
	/**
	 * Loads the first root of this file with the given qualified name and returns it.
	 * 
	 * @param type The qualified name of the root to be returned
	 * @return The first root of this file with the given qualified name or null, if no such node exists.
	 * @throws IOException If an IOException was thrown by {@link XmlLoaderExtension#create(XmlType elem)}.
	 */
	public final XmlComplexType getRoot(XmlQName type) throws IOException {
		for(int i=0;i<roots.length;++i){
			if(roots[i].qualifiedName.equals(type)){
				if(XmlComplexType.class.equals(roots[i].getClass())){
					roots[i] = (XmlComplexType) loader.create(roots[i]);
				}
				return roots[i];
			}
		}
		return null;
	}
	
	/**
	 * Loads all root of this file and returns them.
	 * 
	 * @return The loaded roots of this file.
	 * @throws IOException If an IOException was thrown by {@link XmlLoaderExtension#create(XmlType elem)}.
	 */
	public final XmlComplexType[] getRoots() throws IOException {
		for(int i=0;i<roots.length;++i){
			if(XmlComplexType.class.equals(roots[i].getClass())){
				roots[i] = (XmlComplexType) loader.create(roots[i]);
			}
		}
		return roots;
	}
	
	/**
	 * This is equivalent to a call of {@link #getFile(int mode)} with {@code 0} as parameter.
	 * 
	 * @return A RandomAccessFile targeting {@code targetFile} with the specified mode.
	 */
	public RandomAccessFile getFile(){
		return getFile(0);
	}
	
	/*mode: 0=read, 1=write, 2=readAndWrite
	 * 
	 */
	/**
	 * <p>This method returns a RandomAccessFile pointing to {@code targetFile}. Mode specifies the file mode for the RandomAccessFile.(See {@link java.io.RandomAccessFile#RandomAccessFile(File file, String mode)} for details)</p>
	 * <p>Files generated by this function are taken from internal collections. Therefor the following rules apply:</p>
	 * <ul>
	 * <li>The position of the underlying file-channel of the returned file may be set to any position.</li>
	 * <li>The returned object should be freed after use by a call of {@link #releaseFile(RandomAccessFile file)}.</li>
	 * </ul>
	 * 
	 * <p>This function is thread-safe</p>
	 * 
	 * @param mode The file mode of the returned file.(0=read, 1=write, 2=readAndWrite)
	 * @return A RandomAccessFile pointing to {@code targetFile} with the specified file mode
	 */
	public RandomAccessFile getFile(int mode){
		RandomAccessFile ret;
		switch(mode){
			case 0:
				synchronized(readFiles){
					if(readFiles.size() > 0){
						ret = readFiles.poll();
					}else{
						try {
							ret = new RandomAccessFile(targetFile, "r");
						} catch (FileNotFoundException e) {
							throw new AssertionError("Error should have occured in constructor!", e);
						}
					}
				}
				assignedReadFiles.add(ret);
				return ret;
			case 1:
				synchronized(writeFiles){
					if(writeFiles.size() > 0){
						ret = writeFiles.poll();
					}else{
						try {
							ret = new RandomAccessFile(targetFile, "w");
						} catch (FileNotFoundException e) {
							throw new AssertionError("Error should have occured in constructor!", e);
						}
					}
				}
				assignedWriteFiles.add(ret);
				return ret;
			case 2:
				synchronized(readWriteFiles){
					if(readWriteFiles.size() > 0){
						ret = readWriteFiles.poll();
					}else{
						try {
							ret = new RandomAccessFile(targetFile, "rw");
						} catch (FileNotFoundException e) {
							throw new AssertionError("Error should have occured in constructor!", e);
						}
					}
				}
				assignedReadWriteFiles.add(ret);
				return ret;
			default:
				throw new IllegalArgumentException("mode must be a vlaue between 0 and 2");
		}
	}
	
	/**
	 * <p>Releases a file handle previously returned by this object.</p>
	 * <p>If {@code file} is not a file handle previously returned by this object, an Exception is thrown.</p>
	 * 
	 * <p>This function is thread-safe</p>
	 * 
	 * @param file The file handle which should be released.
	 */
	public void releaseFile(RandomAccessFile file){
		if(assignedReadFiles.remove(file)){
			synchronized(readFiles){
				readFiles.add(file);
			}
		}else if(assignedWriteFiles.remove(file)){
			synchronized(writeFiles){
				writeFiles.add(file);
			}
		}else if(assignedReadWriteFiles.remove(file)){
			synchronized(readWriteFiles){
				readWriteFiles.add(file);
			}
		}else{
			throw new IllegalArgumentException("Given file not owned by this instance");
		}
	}
	
	/**
	 * Resolves a predefined entity.
	 * 
	 * @param name The name of the entity to be resolved.
	 * @return The normalized replace text of the entity with the given name or {@code null} if it does not exist
	 */
	public String resolveEntity(String name){
		return ENTITIES.get(name);
	}
	
	public void setKeyElement(String keyName, String keyValue, XmlType elem){
		if(!"ID".equals(keyName)){
			throw new XmlValidationException("An key with the given name has not been specified: "+keyName);
		}
		if(idMap.containsKey(keyValue)){
			throw new XmlValidationException("Duplicated id "+keyValue);
		}else{
			idMap.put(keyValue, elem);
		}
	}
	
	/**
	 * Returns the element associated with the given id.
	 * 
	 * @param keyValue The id, which should be used to retrieve the element
	 * @return The element associated with the given id or {@code null} if none exists.
	 */
	public XmlType getElementById(String keyValue){
		return getElementByKey("ID", keyValue);
	}
	
	/**
	 * <p>Returns the element associated with the given {@code keyValue} under the given {@code keyName}.</p>
	 * 
	 * @param keyName The name of the key. Only "ID" is allowed.
	 * @param keyValue The value, which should be used to retrieve the element
	 * @return The element associated with the given value or {@code null} if none exists.
	 */
	public XmlType getElementByKey(String keyName, String keyValue){
		if(!"ID".equals(keyName)){
			throw new XmlValidationException("An key with the given name has not been specified: "+keyName);
		}
		return idMap.get(keyValue);
	}
	
	/**
	 * This is equivalent to a call of {@link #index(String positiveIndexPath)} with {@code null} as parameter.
	 * 
	 * @throws IOException If an IOException was thrown by {@link #index(String positiveIndexPath)}.
	 */
	public void index() throws IOException {
		index(null);
	}
	
	/**
	 * This is equivalent to a call of {@link #index(String positiveIndexPath, String negativeIndexPath)} with {@code null} as last parameter.
	 * 
	 * @param positiveIndexPath The path of elements to be loaded
	 * @throws IOException If an IOException was thrown by {@link #index(String positiveIndexPath, String negativeIndexPath)}
	 */
	public void index(String positiveIndexPath) throws IOException {
		index(positiveIndexPath, null);
	}
	
	/**
	 * <p>This function indexes the file. This includes parsing the prolog, retrieving the charset and setting the roots of the file.</p>
	 * <p>{@code positiveIndexPath} and {@code negativeIndexPath} can be used to restrict the elements finaly stored in local memory. See {@link #indexSubtree(RandomAccessFile file, boolean indexChildrenContents, boolean loadTextElements, long finalPos, Map defaultNamespaceMap, Map childrenNameMap, String positiveIndexPath, String negativeIndexPath)} for details.</p>
	 * 
	 * @param positiveIndexPath The path of elements to be loaded
	 * @param negativeIndexPath The path of elements not to be loaded
	 * @throws IOException If an IOException occurred while reading the file
	 */
	public void index(String positiveIndexPath, String negativeIndexPath) throws IOException {
		RandomAccessFile file = getFile();
		file.seek(0);
		try{
			prolog = readXmlTag(file, -1);
		} catch (ParseException e) {
			throw new XmlValidationException("Could not parse file!", e);
		}
		if(prolog.type == TagType.META && "xml".equals(prolog.name)){	
			//long posSave = file.getChannel().position();//Position must be saved and restored cause attribute read manipulates it and readXmlTag expects it not to change
			XmlSimpleType encodingAttr = prolog.attributes.get("encoding");
			if(encodingAttr != null){
				if(encodingAttr.getClass().equals(XmlSimpleTypePlaceholder.class)){
					charset = Charset.forName((String) ((XmlSimpleTypePlaceholder) encodingAttr).getDataAsString());
				}else{
					charset = Charset.forName((String) encodingAttr.getValue());
				}
			}
			//file.seek(posSave);
		}else{
			prolog = new XmlTag(-1, -1, new HashMap<String, XmlSimpleType>(), "xml", "xml", TagType.META);
			file.seek(0);
		}
		List<XmlType> roots = indexSubtree(file, true, false, -1, DEFAULT_NAMESPACE_MAP, null, positiveIndexPath, negativeIndexPath);
		releaseFile(file);
		this.roots = new XmlComplexType[roots.size()];
		int index = 0;
		for(XmlType root : roots){
			if(XmlComplexType.class.isAssignableFrom(root.getClass())){
				this.roots[index] = (XmlComplexType) root;
			}else{
				throw new XmlValidationException("Illegal root: "+root);
			}
			index++;
		}
	}
	
	/**
	 * This is equivalent to a call of {@link #indexSubtree(RandomAccessFile file, boolean indexChildrenContents, boolean loadTextElements, long finalPos, Map defaultNamespaceMap, Map childrenNameMap, String positiveIndexPath)} with {@code false} as loadTextElements and {@code null} as last parameter.
	 * 
	 * @param file The file handle used to read the file
	 * @param indexChildrenContents Indicates, if contents of elements with depth {@literal >} 1 should be stored in local memory
	 * @param finalPos The final position, till to which the file should be parsed
	 * @param defaultNamespaceMap The default namespaceMap used.
	 * @param childrenNameMap The map used to retrieve the type of child elements.
	 * @return A list of all elements without parents, that could be parsed between the initial Position of {@code file} and {@code finalPos}
	 * @throws IOException If an IOException occurred while reading the file
	 */
	public List<XmlType> indexSubtree(RandomAccessFile file, boolean indexChildrenContents, long finalPos, Map<String, URI> defaultNamespaceMap, Map<XmlQName, XmlQName> childrenNameMap) throws IOException {
		return indexSubtree(file, indexChildrenContents, false, finalPos, defaultNamespaceMap, childrenNameMap, null);
	}
	
	/**
	 * This is equivalent to a call of {@link #indexSubtree(RandomAccessFile file, boolean indexChildrenContents, boolean loadTextElements, long finalPos, Map defaultNamespaceMap, Map childrenNameMap, String positiveIndexPath)} with {@code null} as last parameter.
	 * 
	 * @param file The file handle used to read the file
	 * @param indexChildrenContents Indicates, if contents of elements with depth {@literal >} 1 should be stored in local memory
	 * @param loadTextElements Indicates, if text nodes should be loaded.
	 * @param finalPos The final position, till to which the file should be parsed
	 * @param defaultNamespaceMap The default namespaceMap used.
	 * @param childrenNameMap The map used to retrieve the type of child elements.
	 * @return A list of all elements without parents, that could be parsed between the initial Position of {@code file} and {@code finalPos}
	 * @throws IOException If an IOException occurred while reading the file
	 */
	public List<XmlType> indexSubtree(RandomAccessFile file, boolean indexChildrenContents, boolean loadTextElements, long finalPos, Map<String, URI> defaultNamespaceMap, Map<XmlQName, XmlQName> childrenNameMap) throws IOException {
		return indexSubtree(file, indexChildrenContents, loadTextElements, finalPos, defaultNamespaceMap, childrenNameMap, null);
	}
	
	/**
	 * This is equivalent to a call of {@link #indexSubtree(RandomAccessFile file, boolean indexChildrenContents, boolean loadTextElements, long finalPos, Map defaultNamespaceMap, Map childrenNameMap, String positiveIndexPath, String negativeIndexPath)} with {@code false} as loadTextElements and {@code null} as last parameter.
	 * 
	 * @param file The file handle used to read the file
	 * @param indexChildrenContents Indicates, if contents of elements with depth {@literal >} 1 should be stored in local memory
	 * @param finalPos The final position, till to which the file should be parsed
	 * @param defaultNamespaceMap The default namespaceMap used.
	 * @param childrenNameMap The map used to retrieve the type of child elements.
	 * @param positiveIndexPath The path of elements to be loaded
	 * @return A list of all elements without parents, that could be parsed between the initial Position of {@code file} and {@code finalPos}
	 * @throws IOException If an IOException occurred while reading the file
	 */
	public List<XmlType> indexSubtree(RandomAccessFile file, boolean indexChildrenContents, long finalPos, Map<String, URI> defaultNamespaceMap, Map<XmlQName, XmlQName> childrenNameMap, String positiveIndexPath) throws IOException {
		return indexSubtree(file, indexChildrenContents, false, finalPos, defaultNamespaceMap, childrenNameMap, positiveIndexPath, null);
	}
	
	/**
	 * This is equivalent to a call of {@link #indexSubtree(RandomAccessFile file, boolean indexChildrenContents, boolean loadTextElements, long finalPos, Map defaultNamespaceMap, Map childrenNameMap, String positiveIndexPath, String negativeIndexPath)} with {@code null} as last parameter.
	 * 
	 * @param file The file handle used to read the file
	 * @param indexChildrenContents Indicates, if contents of elements with depth {@literal >} 1 should be stored in local memory
	 * @param loadTextElements Indicates, if text nodes should be loaded.
	 * @param finalPos The final position, till to which the file should be parsed
	 * @param defaultNamespaceMap The default namespaceMap used.
	 * @param childrenNameMap The map used to retrieve the type of child elements.
	 * @param positiveIndexPath The path of elements to be loaded
	 * @return A list of all elements without parents, that could be parsed between the initial Position of {@code file} and {@code finalPos}
	 * @throws IOException If an IOException occurred while reading the file
	 */
	public List<XmlType> indexSubtree(RandomAccessFile file, boolean indexChildrenContents, boolean loadTextElements, long finalPos, Map<String, URI> defaultNamespaceMap, Map<XmlQName, XmlQName> childrenNameMap, String positiveIndexPath) throws IOException {
		return indexSubtree(file, indexChildrenContents, loadTextElements, finalPos, defaultNamespaceMap, childrenNameMap, positiveIndexPath, null);
	}
	
	/**
	 * <p>Indexed the file starting from the initial position of {@code file}, terminating at {@code finalPos}.</p>
	 * <p>If {@code positiveIndexPath} or {@code negativeIndexPath} is not null, indexChildrenContents has no effect.</p>
	 * <p>All elements, thats path matches {@code positivePathPattern} and not matches {@code negativePathPattern} will be loaded to local storage</p>
	 * <p>A path matches {@code positiveIndexPath} if {@code positiveIndexPath} is null or one of its children or itself matches {@code positiveIndexPath}</p>
	 * <p>A path matches {@code negativeIndexPath} if {@code negativeIndexPath} is null or itself matches {@code negativeIndexPath}</p>
	 * <p>A path matches a index path the same way as it does in {@link XmlComplexType#getElementsByPath(XmlComplexType parent, String path, Class parentClass)}. Index pathes follow the same schema, but they must also satisfy the following restricted syntax:</p>
	 * <pre>
	 * path = normalPath ( '|' normalPath)*;
	 * normalPath = (node '/')* node?;
	 * node = identifier;
	 * identifier = ( '*' | qname) | '.'? | '::' axisName;
	 * qname = name | namespace | '{' \\s* namespace \\s* ',' \\s* name \\s* '}';
	 * axisName = 'descendant' | 'descendant-or-self';
	 * name = {@link XmlSimpleTypes.XmlNCName#NCNAME_PATTERN_STRING};
	 * namespace = (An URI (like xs:anyURI) with % replaced by '%25' and / replaced by '%2F")
	 * namespaceIdentifier = name;
	 * </pre>
	 * 
	 * @param file The file handle used to read the file
	 * @param indexChildrenContents Indicates, if contents of elements with depth {@literal >} 1 should be stored in local memory
	 * @param loadTextElements Indicates, if text nodes should be loaded.
	 * @param finalPos The final position, till to which the file should be parsed
	 * @param defaultNamespaceMap The default namespaceMap used.
	 * @param childrenNameMap The map used to retrieve the type of child elements.
	 * @param positiveIndexPath The path of elements to be loaded
	 * @param negativeIndexPath The path of elements not to be loaded
	 * @return A list of all elements without parents, that could be parsed between the initial Position of {@code file} and {@code finalPos}
	 * @throws IOException If an IOException occurred while reading the file
	 */
	public List<XmlType> indexSubtree(RandomAccessFile file, boolean indexChildrenContents, boolean loadTextElements, long finalPos, Map<String, URI> defaultNamespaceMap, Map<XmlQName, XmlQName> childrenNameMap, String positiveIndexPath, String negativeIndexPath) throws IOException {
		//Parse pathes
		Pattern positivePathPattern = pathToPathPattern(positiveIndexPath, false);
		Pattern negativePathPattern = pathToPathPattern(negativeIndexPath, true);
		
		XmlTag tmp;
		ArrayList<XmlTag> xmlTags = new ArrayList<XmlTag>();
		do {
			try {
				tmp = readXmlTag(file, finalPos);
			} catch (ParseException e) {
				throw new XmlValidationException("Could not parse file!", e);
			}
			if(tmp != null) {
				xmlTags.add(tmp);
			}
		}while(tmp != null);
		Stack<XmlTag> startTags = new Stack<XmlTag>();
		Stack<ArrayList<XmlType>> childXmlElements = new Stack<ArrayList<XmlType>>();
		Stack<Map<String, URI>> namespaceMaps = new Stack<Map<String, URI>>();
		namespaceMaps.push(defaultNamespaceMap);
		childXmlElements.push(new ArrayList<XmlType>());
		XmlType elem;
		URI namespace = null;
		Map<String, URI> namespaceMap = defaultNamespaceMap;
		XmlQName qualifiedName;
		XmlQName type;
		Class<? extends XmlType> typeClass;
		for(XmlTag xmlTag: xmlTags) {
			boolean isFilterable;
			switch(xmlTag.type) {
				case META:
					isFilterable = false;
					break;
				case COMMENT:
					isFilterable = false;
					break;
				case DOCTYPE:
					isFilterable = false;
					break;
				case TEXT:
					isFilterable = false;
					break;
				case START:
					isFilterable = true;
					namespaceMap = new HashMap<String, URI>();
					if(namespaceMaps.size() > 0){
						namespaceMap.putAll(namespaceMaps.peek());
					}
					for(String attr : xmlTag.attributes.keySet()){
						if(attr.startsWith("xmlns")){
							String value;
							if(xmlTag.attributes.get(attr).getClass().equals(XmlSimpleTypePlaceholder.class)){
								value = (((XmlSimpleTypePlaceholder) xmlTag.attributes.get(attr)).getDataAsString());
							}else{
								value = ((String) xmlTag.attributes.get(attr).getValue());
							}
							if(!attr.contains(":")){
								try {
									namespaceMap.put("", new URI(value));
								} catch (URISyntaxException e) {
									throw new XmlValidationException("Namespace URI is not valid!", e);
								}
							}else{
								String[] parts = attr.split(":");
								try {
									namespaceMap.put(parts[1], new URI(value));
								} catch (URISyntaxException e) {
									throw new XmlValidationException("Namespace URI is not valid!", e);
								}
							}
						}
					}
					namespace = namespaceMap.get(xmlTag.namespaceId);
					qualifiedName = new XmlQName(namespace, xmlTag.name);
					type = null;
					if(childrenNameMap != null){
						type = childrenNameMap.get(qualifiedName);
					}
					if(type == null){
						type = qualifiedName;
					}
					typeClass = loader.nameClassMap.get(type);
					if(typeClass != null && loader.supportedURIs.contains(type.namespace) && (Xml.XmlSimpleType.class.isAssignableFrom(typeClass))){
						//Nothing
					}else{
						namespaceMaps.push(namespaceMap);
						childXmlElements.push(new ArrayList<XmlType>());
					}
					break;
				case END:
					isFilterable = true;
					namespace = namespaceMaps.peek().get(xmlTag.namespaceId);
					break;
				case STARTEND:
					isFilterable = true;
					namespaceMap = new HashMap<String, URI>();
					if(namespaceMaps.size() > 0){
						namespaceMap.putAll(namespaceMaps.peek());
					}
					for(String attr : xmlTag.attributes.keySet()){
						if(attr.startsWith("xmlns")){
							String value;
							if(xmlTag.attributes.get(attr).getClass().equals(XmlSimpleTypePlaceholder.class)){
								value = (((XmlSimpleTypePlaceholder) xmlTag.attributes.get(attr)).getDataAsString());
							}else{
								value = ((String) xmlTag.attributes.get(attr).getValue());
							}
							if(!attr.contains(":")){
								try {
									namespaceMap.put("", new URI(value));
								} catch (URISyntaxException e) {
									throw new XmlValidationException("Namespace URI is not valid!", e);
								}
							}else{
								String[] parts = attr.split(":");
								try {
									namespaceMap.put(parts[1], new URI(value));
								} catch (URISyntaxException e) {
									throw new XmlValidationException("Namespace URI is not valid!", e);
								}
							}
						}
					}
					namespace = namespaceMap.get(xmlTag.namespaceId);
					break;
				default:
					throw new AssertionError("Illegal state!");
			}
			if(isFilterable && (positivePathPattern != null || negativePathPattern != null)){
				//BuildPathString
				StringBuilder pathStringBuilder = new StringBuilder();
				int index = namespaceMaps.size()-1;
				for(int i=startTags.size()-(xmlTag.type == TagType.END?2:1);i >= 0;--i){//Index is counted down!
					XmlTag startTag = startTags.elementAt(i);
					namespace = namespaceMaps.elementAt(index).get(startTag.namespaceId);
					pathStringBuilder.insert(0, "{"+namespace.toString().replaceAll("%", "%25").replaceAll("/", "%2F")+", "+startTag.name+"}/");
					index--;
				}
				pathStringBuilder.append("{"+namespace.toString().replaceAll("%", "%25").replaceAll("/", "%2F")+", "+xmlTag.name+"}/");
				if((positivePathPattern == null || positivePathPattern.matcher(pathStringBuilder).matches())
						&&(negativePathPattern == null || !negativePathPattern.matcher(pathStringBuilder).matches())){
						indexChildrenContents = true;
				}else{
						indexChildrenContents = false;
				}
			}
			switch(xmlTag.type) {
				case META:
					break;
				case COMMENT:
					break;
				case DOCTYPE:
					break;
				case START:
					startTags.push(xmlTag);
					break;
				case TEXT:
					if(loadTextElements){
						childXmlElements.peek().add(xmlTag.attributes.get(""));
					}
					break;
				case END:
					if(!((xmlTag.namespaceId+":"+xmlTag.name).equals(startTags.peek().namespaceId+":"+startTags.peek().name))) {
						throw new XmlValidationException("Could not parse file!", new ParseException("EndXmlTag does not match last startTag", (int)xmlTag.pos));
					}
					XmlTag startTag = startTags.pop();
					qualifiedName = new XmlQName(namespace, startTag.name);
					type = null;
					if(childrenNameMap != null){
						type = childrenNameMap.get(qualifiedName);
					}
					if(type == null){
						type = qualifiedName;
					}
					typeClass = loader.nameClassMap.get(type);
					if(typeClass != null && loader.supportedURIs.contains(type.namespace) && (Xml.XmlSimpleType.class.isAssignableFrom(typeClass))){
						elem = new XmlSimpleTypePlaceholder(this, startTag.name, null, qualifiedName, startTag.pos, xmlTag.pos-startTag.pos);
						if(LOAD_SIMPLE_TYPE_VALUES && indexChildrenContents){
							((XmlSimpleTypePlaceholder) elem).loadValue();
						}
						childXmlElements.peek().add(elem);
					}else{
						namespaceMap = namespaceMaps.pop();
						XmlType[] childrenArr = (XmlType[])childXmlElements.pop().toArray(new XmlType[0]);
						if(!indexChildrenContents){
							childrenArr = null;
						}
						elem = new XmlComplexType(this, startTag.name, qualifiedName, null, namespaceMap, startTag.attributes, childrenArr, startTag.pos, xmlTag.pos-startTag.pos);
						if(childrenArr != null){
							if(((XmlComplexType) elem).children.length == 1){
								((XmlComplexType) elem).children[0].setParent(((XmlComplexType) elem));
							}else{
								for(int i=0;i<((XmlComplexType) elem).children.length;++i){
									((XmlComplexType) elem).children[i].setParent(((XmlComplexType) elem), i);
								}
							}
						}
						for(Map.Entry<String, XmlSimpleType> entry: ((XmlComplexType) elem).attributes.entrySet()){
							entry.getValue().setParent(((XmlComplexType) elem));
						}
						childXmlElements.peek().add(elem);
					}
					break;
				case STARTEND:
					qualifiedName = new XmlQName(namespace, xmlTag.name);
					type = null;
					if(childrenNameMap != null){
						type = childrenNameMap.get(qualifiedName);
					}
					if(type == null){
						type = qualifiedName;
					}
					typeClass = loader.nameClassMap.get(type);
					if(typeClass != null && loader.supportedURIs.contains(type.namespace) && (XmlSimpleType.class.isAssignableFrom(typeClass))){
						elem = new XmlSimpleTypePlaceholder(this, xmlTag.name, null, qualifiedName, xmlTag.pos, xmlTag.pos, "");
						childXmlElements.peek().add(elem);
					}else{
						elem = new XmlComplexType(this, xmlTag.name, qualifiedName, null, namespaceMap, xmlTag.attributes, new XmlComplexType[0], xmlTag.pos, 0);
						childXmlElements.peek().add(elem);
					}
					break;
				default:
					throw new AssertionError("Illegal state!");
			}
		}
		List<XmlType> roots = childXmlElements.pop();
		//BuildPaths
		Queue<XmlType> queue = new ArrayDeque<XmlType>();
		queue.addAll(roots);
		return roots;
	}

	private XmlTag readXmlTag(RandomAccessFile file, long finalPos) throws IOException, ParseException {
		final String sChars = "\\u0020\\u0009\\u000D\\u000A";
		final String nameChars = "-.0-9:A-Z_a-z\\u00B7\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u037D\\u037F-\\u1FFF\\u200C-\\u200D\\u203F\\u2040\\u2070-\\u218F\\u2C00-\\u2FEF\\u3001-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFFD";
		final String s = "(?:["+sChars+"]+)";
		final String eq = "(?:"+s+"?="+s+"?)";
		final String name = "(?:[\\:A-Z_a-z\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u02FF\\u0370-\\u037D\\u037F-\\u1FFF\\u200C-\\u200D\\u2070-\\u218F\\u2C00-\\u2FEF\\u3001-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFFD][\\-\\.0-9\\:A-Z_a-z\\u00B7\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u037D\\u037F-\\u1FFF\\u200C-\\u200D\\u203F\\u2040\\u2070-\\u218F\\u2C00-\\u2FEF\\u3001-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFFD]*)";
		final String charRef = "(?:\\&#\\d+;|\\&#x[\\da-fA-F]+;)";
		final String pubidChar = "[\\u0020\\u000D\\u000Aa-zA-Z0-9\\Q-'()+,./:=?;!*#@$_%\\E]";
		final String externalId = "(?:(?:SYSTEM|PUBLIC"+s+"(?:\""+pubidChar+"*\"|\'"+pubidChar+"*\'))"+s+"(?:\"[^\"]*\"|\'[^\']*\'))";
		final String cp = "(?:[\\(\\)\\|\\,\\?\\*\\+"+sChars+nameChars+"]+[\\?\\*\\+]?)";
		final String choice = "(?:\\("+s+"?"+cp+"(?:"+s+"?\\|"+s+"?"+cp+")+"+s+"?\\))";
		final String seq = "(?:\\("+s+"?"+cp+"(?:"+s+"?\\,"+s+"?"+cp+")+"+s+"?\\))";
		final String nmtoken = "(?:["+nameChars+"]+)";
		final String attValue = "(?:\"(?:[^<\\&\"]|\\&"+name+";|"+charRef+")*\"|\'(?:[^<\\&\']|\\&"+name+";|"+charRef+")*\')";
		final String entityValue = "(?:"+attValue+"|(?:\"(?:%"+name+";)*\"|\'(?:%"+name+";)*\'))";
		final String entityDef = "(?:"+entityValue+"|(?:"+externalId+s+"NDATA"+s+name+"))";
		final String peDef = "(?:"+entityValue+"|"+externalId+")";
		final String xmlDecl = "(?:<\\Q?\\Exml"
				+ s+"version"+eq+"(?:\"\\d(?:\\.\\d|\\d)*\"|\'(?:\\.\\d|\\d)*\')"
				+ "(?:"+s+"encoding"+eq+"(?:\"(?:[A-Za-z][A-Za-z0-9\\._\\-]*)\"|\'(?:[A-Za-z][A-Za-z0-9\\._\\-]*)\'))?"
				+ "(?:\\u0020+standalone"+eq+"(?:\"(?:yes|no)\"|\'(?:yes|no)\'))?"
				+ s+"?\\Q?\\E>)";
		final String comment = "(?:<!\\Q--\\E"
				+ "(?:[\\-]?[^\\Q-\\E])*"
				+ "\\Q--\\E>)";
		final String pi = "(?:<\\Q?\\E"
				+ "(?:"+name+"(?<![xX][mM][lL]))"
				+ "(?:"+s+"(?:[^\\Q?\\E]|\\Q?\\E(?!\\Q>\\E))*)?"
				+ "\\Q?\\E>)";
		final String contentSpec = "(?:"
				+ "EMPTY|ANY|"
				+ "(?:\\("+s+"?#PCDATA(?:"+s+"?\\|"+s+"?"+name+")*"+s+"?\\)\\*)|"
				+ "(?:(?:"+choice+"|"+seq+")[\\?\\*\\+]?)"
				+ ")";
		final String attType = "(?:"
				+ "CDATA|ID|IDREF|IDREFS|ENTITY|ENTITIES|NMTOKEN|NMTOKENS|"
				+ "(?:NOTATION"+s+"\\("+s+"?"+name+"(?:"+s+"?\\|"+s+"?"+name+")*"+s+"?\\))|"
				+ "(?:\\("+s+"?"+nmtoken+"(?:"+s+"?\\|"+s+"?"+nmtoken+")*"+s+"?\\))"
				+ ")";
		final String defaultDecl = "(?:"
				+ "#REQUIRED|#IMPLIED|"
				+ "(?:(?:#FIXED"+s+")?"+attValue+")"
				+ ")";
		final String markupDecl = "(?:"
				+ "(?:<!ELEMENT"+s+name+s+contentSpec+s+"?>)|"
				+ "(?:<!ATTLIST"+s+name+"(?:"+s+name+s+attType+s+defaultDecl+")*"+s+"?>)|"
				+ "(?:<!ENTITY"+s+"(?:"+name+s+entityDef+"|%"+s+name+s+peDef+")"+s+"?>)|"
				+ "(?:<!NOTATION"+s+name+s+"(?:"+externalId+"|(?:PUBLIC+"+s+"(?:\""+pubidChar+"*\"|\'["+pubidChar+"&&[^\']]*\')))"+s+"?>)|"
				+ pi+"|"+comment
				+ ")";
		final String intSubset = "(?:(?:"
				+ s+"|(?:%"+name+";)|"
				+ markupDecl
				+ ")*)";
		final String doctype = "(?:<!DOCTYPE"+s+name
				+ "(?:"+s+externalId+")?"+s+"?"
				+ "(?:\\["+(EXACT_DOCTYPE_PATTERN?intSubset:".*")+"\\]"+s+"?)?"
				+ ">)";
		final String element = "(?:<(?:/)?"
				+ name+"(?:"+s+name+eq+attValue+")*"+s+"?"
				+ "(?:/)?>)";
		final String xmlDeclPatternString = "(?:<\\Q?\\Exml("
				+ s+"version"+eq+"(?:\"\\d(?:\\.\\d|\\d)*\"|\'(?:\\.\\d|\\d)*\')"
				+ "(?:"+s+"encoding"+eq+"(?:\"(?:[A-Za-z][A-Za-z0-9\\._\\-]*)\"|\'(?:[A-Za-z][A-Za-z0-9\\._\\-]*)\'))?"
				+ "(?:\\u0020+standalone"+eq+"(?:\"(?:yes|no)\"|\'(?:yes|no)\'))?"
				+ s+"?)\\Q?\\E>)";
		final String commentPatternString = "(?:<!\\Q--\\E"
				+ "((?:[\\-]?[^\\Q-\\E])*)"
				+ "\\Q--\\E>)";
		final String piPatternString = "(?:<\\Q?\\E"
				+ "("+name+"(?<![xX][mM][lL]))"
				+ "("+s+"(?:[^\\Q?\\E]|\\Q?\\E(?!\\Q>\\E))*)?"
				+ "\\Q?\\E>)";
		final String doctypePatternString = "(?:<!DOCTYPE("+s+name
				+ "(?:"+s+externalId+")?"+s+"?"
				+ "(?:\\["+intSubset+"\\]"+s+"?)?"
				+ ")>)";
		final String elementPatternString = "(?:<(/)?"
				+ "("+name+")((?:"+s+name+eq+attValue+")*)"+s+"?"
				+ "(/)?>)";
		final String tagPatternString = "(?:"
				+ "("+element+")|"
				+ "("+comment+")|"
				+ "("+pi+")|"
				+ "("+xmlDecl+")"
				+ "|("+doctype+")"
				+ ")";
		final Pattern tagPattern = Pattern.compile(tagPatternString, Pattern.DOTALL);
		final Pattern xmlDeclPattern = Pattern.compile(xmlDeclPatternString, Pattern.DOTALL);
		final Pattern commentPattern = Pattern.compile(commentPatternString, Pattern.DOTALL);
		final Pattern piPattern = Pattern.compile(piPatternString, Pattern.DOTALL);
		final Pattern doctypePattern = Pattern.compile(doctypePatternString, Pattern.DOTALL);
		final Pattern elementPattern = Pattern.compile(elementPatternString, Pattern.DOTALL);
		final Pattern attributePattern = Pattern.compile("(?:\\A|\\G)\\s*([^=\\s]+)(?:\\s*=\\s*(?:\"([^\"]*)\"|\'([^\']*)\'))?(?:\\s+|\\z)", Pattern.DOTALL);
		
		long readStartPos = file.getChannel().position();
		
		int readLength = 1024;
		if(finalPos > 0){
			long newReadLength = finalPos - readStartPos;
			if(newReadLength < 1024){
				readLength = (newReadLength < 0?0:(int)newReadLength);
			}
		}
		
		byte[] readBuffer = new byte[readLength];
		int xmlTagStart = -1;
		int readBytes = -1;
		StringBuilder tagStringBuilder = new StringBuilder();
		long readBytesTotal = 0;
		boolean foundMatch = false;
		Matcher tagMatcher = null;
		do{
			readBytes = file.read(readBuffer, 0, readLength);
			if(readBytes != -1){
				readBytesTotal += readBytes;
				String inputString = new String(readBuffer, 0, readBytes, charset);
				if(xmlTagStart == -1) {
					xmlTagStart = inputString.indexOf('<');
				}
				if(xmlTagStart != -1){
					tagStringBuilder.append(inputString);
					tagMatcher = tagPattern.matcher(tagStringBuilder);
					if(tagMatcher.find()){
						if(!tagStringBuilder.substring(0, tagMatcher.start(0)).contains("<")){
							foundMatch = true;
							break;
						}
					}
				}
			}
		}while((finalPos == -1 || file.getChannel().position() < finalPos) && readBytes != -1 && !foundMatch);
		
		if(xmlTagStart == -1) {
			if(readBytesTotal <= 0){
				return null;
			}
			Map<String, XmlSimpleType> tagMap = new HashMap<String, XmlSimpleType>();
			if(LOAD_SIMPLE_TYPE_VALUES && readBytes != -1){
				tagMap.put("", new XmlText(this, null, readStartPos, readBytesTotal, new String(readBuffer, 0, readBytes, charset)));
			}else{
				tagMap.put("", new XmlText(this, null, readStartPos, readBytesTotal));
			}
			return new XmlTag(readStartPos, readBytesTotal, tagMap, "xml", "TEXT", TagType.TEXT);
		}else if(!foundMatch){
			throw new ParseException("End of File occured while parsing XmlTag", (int)file.getChannel().position());
		}
		
		int xmlTagStartByte = tagStringBuilder.substring(0, xmlTagStart).toString().getBytes().length;
		
		if(xmlTagStart != 0){
			file.seek(readStartPos + xmlTagStartByte);
			Map<String, XmlSimpleType> tagMap = new HashMap<String, XmlSimpleType>();
			if(LOAD_SIMPLE_TYPE_VALUES){
				tagMap.put("", new XmlText(this, null, readStartPos, xmlTagStartByte, tagStringBuilder.substring(0, xmlTagStart)));
			}else{
				tagMap.put("", new XmlText(this, null, readStartPos, xmlTagStartByte));
			}
			return new XmlTag(readStartPos, xmlTagStartByte, tagMap, "xml", "TEXT", TagType.TEXT);
		}
		
		int xmlTagEndByte = tagStringBuilder.substring(0, tagMatcher.end(0)).toString().getBytes().length;
		
		int tagStringLengthBytes = tagStringBuilder.toString().getBytes().length;
		
		file.seek(readStartPos + (readBytesTotal-tagStringLengthBytes) + xmlTagEndByte);
		String xmlTagString = tagMatcher.group(0);
		
		long xmlTagPos = readStartPos + (readBytesTotal-tagStringLengthBytes) + xmlTagStartByte;
		
		TagType tagType;
		String attributeString;
		int attributesStart;
		String tagNamespaceId;
		String tagName;
		long contentPosStart;
		long contentLength;
		if(tagMatcher.group(1) != null){
			Matcher elementMatcher = elementPattern.matcher(tagMatcher.group(1));
			if(elementMatcher.matches()){
				attributeString = elementMatcher.group(3);
				attributesStart = elementMatcher.start(3);
				String nameWithId = elementMatcher.group(2);
				if(nameWithId.contains(":")){
					String[] tmp = nameWithId.split(":");
					tagNamespaceId = tmp[0];
					tagName = tmp[1];
				}else{
					tagNamespaceId = "";
					tagName = nameWithId;
				}
				contentLength = 0;
				if(elementMatcher.group(1) == null && elementMatcher.group(4) == null){
					tagType = TagType.START;
					contentPosStart = xmlTagPos + xmlTagString.length();
				}else if(elementMatcher.group(1) != null && elementMatcher.group(4) == null){
					tagType = TagType.END;
					contentPosStart = xmlTagPos;
				}else if(elementMatcher.group(1) == null && elementMatcher.group(4) != null){
					tagType = TagType.STARTEND;
					contentPosStart = xmlTagPos + xmlTagString.length();
				}else{
					throw new AssertionError("Reached unreachable state!");
				}
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}else if(tagMatcher.group(2) != null){
			tagType = TagType.COMMENT;
			tagNamespaceId = "xml";
			tagName = "COMMENT";
			attributeString = null;
			attributesStart = -1;
			Matcher commentMatcher = commentPattern.matcher(tagMatcher.group(2));
			if(commentMatcher.matches()){
				contentPosStart = xmlTagPos + commentMatcher.start(1);
				contentLength = (xmlTagPos + commentMatcher.end(1))-contentPosStart;
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}else if(tagMatcher.group(3) != null){
			tagType = TagType.META;
			tagNamespaceId = "xml";
			attributeString = null;
			attributesStart = -1;
			Matcher piMatcher = piPattern.matcher(tagMatcher.group(3));
			if(piMatcher.matches()){
				tagName = piMatcher.group(1);
				contentPosStart = xmlTagPos + piMatcher.start(2);
				contentLength = (xmlTagPos + piMatcher.end(2))-contentPosStart;
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}else if(tagMatcher.group(4) != null){
			tagType = TagType.META;
			tagNamespaceId = "xml";
			tagName = "xml";
			contentPosStart = xmlTagPos + xmlTagString.length();
			contentLength = 0;
			Matcher xmlDeclMatcher = xmlDeclPattern.matcher(tagMatcher.group(4));
			if(xmlDeclMatcher.matches()){
				attributeString = xmlDeclMatcher.group(1);
				attributesStart = xmlDeclMatcher.start(1);
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}else if(tagMatcher.group(5) != null){
			tagType = TagType.DOCTYPE;
			tagNamespaceId = "xml";
			tagName = "DOCTYPE";
			attributeString = null;
			attributesStart = -1;
			Matcher doctypeMatcher = doctypePattern.matcher(tagMatcher.group(5));
			if(doctypeMatcher.matches()){
				contentPosStart = xmlTagPos + doctypeMatcher.start(1);
				contentLength = (xmlTagPos + doctypeMatcher.end(1))-contentPosStart;
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}else {
			throw new AssertionError("Reached unreachable state!");
		}
		
		Map<String, XmlSimpleType> tagMap = new HashMap<String, XmlSimpleType>();
		if(attributeString != null){
			Matcher attributeMatcher = attributePattern.matcher(attributeString);
			while(attributeMatcher.find()) {
				int attributeStartByte = xmlTagString.substring(0, attributesStart).toString().getBytes().length;
				int attrValueStartByte;
				int attrValueEndByte;
				if(attributeMatcher.group(2) != null){
					attrValueStartByte = attributeString.substring(0, attributeMatcher.start(2)).toString().getBytes().length;
					attrValueEndByte = attributeString.substring(0, attributeMatcher.end(2)).toString().getBytes().length;
				}else if(attributeMatcher.group(3) != null){
					attrValueStartByte = attributeString.substring(0, attributeMatcher.start(3)).toString().getBytes().length;
					attrValueEndByte = attributeString.substring(0, attributeMatcher.end(3)).toString().getBytes().length;
				}else{
					attrValueStartByte = 0;
					attrValueEndByte = 0;
				}
				XmlSimpleType attr;
				if(LOAD_SIMPLE_TYPE_VALUES){
					if(attributeMatcher.group(2) == null){
						attr = new XmlSimpleTypePlaceholder(this, "@"+attributeMatcher.group(1), null, new XmlQName(null, "@"+attributeMatcher.group(1)), xmlTagPos + attributeStartByte + attrValueStartByte, attrValueEndByte-attrValueStartByte, (attributeMatcher.group(3)==null?"":attributeMatcher.group(3)));
					}else{
						attr = new XmlSimpleTypePlaceholder(this, "@"+attributeMatcher.group(1), null, new XmlQName(null, "@"+attributeMatcher.group(1)), xmlTagPos + attributeStartByte + attrValueStartByte, attrValueEndByte-attrValueStartByte, (attributeMatcher.group(2)==null?"":attributeMatcher.group(2)));
					}
				}else{
					attr = new XmlSimpleTypePlaceholder(this, "@"+attributeMatcher.group(1), null, new XmlQName(null, "@"+attributeMatcher.group(1)), xmlTagPos + attributeStartByte + attrValueStartByte, attrValueEndByte-attrValueStartByte);
				}
				tagMap.put(attributeMatcher.group(1), attr);
			}
		}
		return new XmlTag(contentPosStart, contentLength, tagMap, tagNamespaceId, tagName, tagType);
	}
	
	private static Pattern pathToPathPattern(String path, boolean isNegativePath){
		if(path == null || "".equals(path)){
			return null;
		}
		final String namePatternString = XmlNCName.NCNAME_PATTERN_STRING;
		final String uriPatternString = "(?:(?:[a-zA-Z][0-9a-zA-Z+\\\\-\\\\.]*:)?%2F{0,2}(?:%2F|[0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%])+)?(?:#(?:%2F|[0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%])+)?";
		final String namespacePatternString = uriPatternString;
		final String qNamePatternString ="(?:"+namePatternString+"|"+namespacePatternString+"|\\{\\s*"+namespacePatternString+"\\s*,\\s*"+namePatternString+"\\s*\\})";
		final String axisNamePatternString = "(?:descendant|descendant-or-self)";
		final String identifierPatternString = "(?:(?:(?:\\*|"+qNamePatternString+"))|[\\.]?|\\:\\:"+axisNamePatternString+")";
		final Pattern pathPattern = Pattern.compile("(?<=\\A|(?<=/))("+identifierPatternString+")(?:/+|\\z)");
		final Pattern qNamePattern = Pattern.compile("(?:("+namePatternString+")|("+namespacePatternString+")|(\\{\\s*"+namespacePatternString+"\\s*,\\s*"+namePatternString+"\\s*\\}))");
		final Pattern axisPattern = Pattern.compile("(?:\\:\\:("+axisNamePatternString+"))");
		
		StringBuilder pathPatternBuilder = new StringBuilder();
		String[] pathes = path.split("\\|");
		for(int k=0;k<pathes.length;++k){
			pathPatternBuilder.append("(?:");
			List<String> nodesList = new ArrayList<String>();
			Matcher pathMatcher = pathPattern.matcher(pathes[k]);
			while(pathMatcher.find()){
				nodesList.add(pathMatcher.group(1));
			}
			String[] nodes = nodesList.toArray(new String[0]);
			
			if(nodes.length == 0 && !"".equals(pathes[k])){
				throw new IllegalArgumentException("Given path wass invalid: "+pathes[k]);
			}
			int depth = 0;
			outerForLoop:
			for(int i=0;i<nodes.length;++i){
				switch(nodes[i]){
					case ""://Intended fallthrough
					case ".":
						break;
					default:
						depth++;
						if(!isNegativePath){
							pathPatternBuilder.append("(?:");
						}
						Matcher axisMatcher = axisPattern.matcher(nodes[i]);
						if(axisMatcher.matches()){
							switch(axisMatcher.group(1)){
							case "descendant-or-self":
								pathPatternBuilder.append("(?:[^/]+/)*");
								if(isNegativePath){
									break;
								}else{
									break outerForLoop;
								}
							case "descendant":
								pathPatternBuilder.append("(?:[^/]+/)+");
								if(isNegativePath){
									break;
								}else{
									break outerForLoop;
								}
							default:
								throw new AssertionError("Reached unreachable state!");
							}
						}else{
							if("*".equals(nodes[i])){
								pathPatternBuilder.append("\\{\\s*"+namespacePatternString+"\\s*,\\s*"+namePatternString+"\\s*\\}");
							}else{
								Matcher qNameMatcher = qNamePattern.matcher(nodes[i]);
								if(qNameMatcher.matches()){
									if(qNameMatcher.group(1) != null){
										pathPatternBuilder.append("\\{\\s*"+namespacePatternString+"\\s*,\\s*"+qNameMatcher.group(1)+"\\s*\\}");
									}else if(qNameMatcher.group(2) != null){
										pathPatternBuilder.append("\\{\\s*"+qNameMatcher.group(2)+"\\s*,\\s*"+qNameMatcher.group(1)+"\\s*\\}");
									}else{
										pathPatternBuilder.append(qNameMatcher.group(3));
									}
								}else{
									throw new AssertionError("Reached unreachable state!");
								}
							}
							pathPatternBuilder.append('/');
						}
				}
			}
			if(!isNegativePath){
				pathPatternBuilder.append(")?".repeat(depth));
			}
			pathPatternBuilder.append(")");
			if(k != pathes.length - 1){
				pathPatternBuilder.append('|');
			}
		}
		return Pattern.compile(pathPatternBuilder.toString());
	}
	
}

