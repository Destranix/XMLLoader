package Xml;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

import XmlSimpleTypes.XmlID;
import XmlSimpleTypes.XmlNCName;

/**
 *
 * <p>This class is used for elements of complex types, elements with simple content or elements, where the type is not known</p>
 */
public class XmlComplexType extends XmlType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = ".*";
	protected static final Set<XmlQName> ALLOWED_CHILDREN_NAMES = new HashSet<XmlQName>();
	protected static final Map<XmlQName, XmlQName> CHILDREN_NAME_MAP = new HashMap<XmlQName, XmlQName>(0);
	protected static final Map<XmlQName, Integer> ALLOWED_CHILDREN_MIN_BOUNDS = new HashMap<XmlQName, Integer>(0);
	protected static final Map<XmlQName, Integer> ALLOWED_CHILDREN_MAX_BOUNDS = new HashMap<XmlQName, Integer>(0);
	protected static final Map<String, String> ATTRIBUTE_DEFAULT_VALUES = new HashMap<String, String>(0);
	protected static final Set<String> ALLOWED_ATTRIBUTES = new HashSet<String>(0);
	protected static final Set<String> REQUIRED_ATTRIBUTES = new HashSet<String>(0);
	protected static final Set<String> FORBIDDEN_ATTRIBUTES = new HashSet<String>(0);
	protected static final Map<String, XmlQName> ATTRIBUTES_NAME_MAP = new HashMap<String, XmlQName>(0);
	
	protected static final Map<String, Map<String, XmlType>> KEY_MAPS = new HashMap<String, Map<String, XmlType>>(0);
	protected static final Map<String, String> KEY_OWNER_PATH_MAP = new HashMap<String, String>(0);
	protected static final Map<String, String> KEY_VALUE_PATH_MAP = new HashMap<String, String>(0);
	
	protected static final URI xs;
	protected static final URI xml;
	
	static{
		try{
			 xs = new URI("http://www.w3.org/2001/XMLSchema");
			 xml = new URI("https://www.w3.org/2001/XML");
		} catch (URISyntaxException e) {
			throw new AssertionError("URI not parsable", e);
		}
	}
	
	protected final Map<String, XmlSimpleType> attributes;
	/**
	 * <p>The children of this element.</p>
	 */
	public XmlType[] children;
	
	protected final Map<String, URI> namespaceMap;
	
	/**
	 * @param file The file this element belongs to
	 * @param path The initial Path of this element
	 * @param qualifiedName The initial qualifiedName of this element. This may be changed to its type on creation
	 * @param parent The initial parent of this element
	 * @param namespaceMap A mapping of namespaceidentifiers to namespace-URIs
	 * @param attributes A Mapping of attribute name to Simple Type representing the value of the corresponding attribute
	 * @param children An array of children of this element
	 * @param pos The start-position of this element content in the target file this element file attribute refers to, if it exists
	 * @param length The length of the content
	 */
	public XmlComplexType(XmlFile file, String path, XmlQName qualifiedName, XmlComplexType parent, Map<String, URI> namespaceMap,
			Map<String, XmlSimpleType> attributes, XmlType[] children, long pos, long length) {
		super(file, path, qualifiedName, parent, pos, length);
		this.attributes = attributes;
		this.children = children;
		this.namespaceMap = namespaceMap;
	}
	
	/**
	 * @param elem The element, from which all needed attributes will be used from
	 * @param thisClass The class of the element to be created.
	 */
	protected XmlComplexType(XmlComplexType elem, Class<? extends XmlComplexType> thisClass){
		super(elem.file, elem.path, elem.qualifiedName, elem.parent, elem.pos, elem.length);
		Map<String, String> attributeDefaultValues;
		Map<XmlQName, Integer> allowedChildrenMinBounds;
		Map<XmlQName, Integer> allowedChildrenMaxBounds;
		Set<XmlQName> allowedChildrenNames;
		String allowedChildrenPattern;
		Set<String> allowedAttributes;
		Set<String> requiredAttributes;
		Set<String> forbiddenAttributes;
		Map<String, XmlQName> attributesNameMap;
		Map<String, String> keyOwnerPathMap;
		Map<String, String> keyValuePathMap;
		try {
			Field field = thisClass.getDeclaredField("ATTRIBUTE_DEFAULT_VALUES");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<String, String> tmp = ((Map<String, String>) field.get(null));
			attributeDefaultValues = tmp;
			
			field = thisClass.getDeclaredField("ALLOWED_CHILDREN_MIN_BOUNDS");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<XmlQName, Integer> tmp2 = ((Map<XmlQName, Integer>) field.get(null));
			allowedChildrenMinBounds = tmp2;
			
			field = thisClass.getDeclaredField("ALLOWED_CHILDREN_MAX_BOUNDS");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<XmlQName, Integer> tmp3 = ((Map<XmlQName, Integer>) field.get(null));
			allowedChildrenMaxBounds = tmp3;
			
			field = thisClass.getDeclaredField("ALLOWED_CHILDREN_PATTERN");
			field.setAccessible(true);
			allowedChildrenPattern = ((String) field.get(null));

			field = thisClass.getDeclaredField("ALLOWED_CHILDREN_NAMES");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Set<XmlQName> tmp4 = ((Set<XmlQName>) field.get(null));
			allowedChildrenNames = tmp4;
			
			field = thisClass.getDeclaredField("ALLOWED_ATTRIBUTES");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Set<String> tmp5 = ((Set<String>) field.get(null));
			allowedAttributes = tmp5;
			
			field = thisClass.getDeclaredField("REQUIRED_ATTRIBUTES");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Set<String> tmp6 = ((Set<String>) field.get(null));
			requiredAttributes = tmp6;
			
			field = thisClass.getDeclaredField("FORBIDDEN_ATTRIBUTES");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Set<String> tmp7 = ((Set<String>) field.get(null));
			forbiddenAttributes = tmp7;
			
			field = thisClass.getDeclaredField("ATTRIBUTES_NAME_MAP");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<String, XmlQName> tmp8 = ((Map<String, XmlQName>) field.get(null));
			attributesNameMap = tmp8;
			
			field = thisClass.getDeclaredField("KEY_OWNER_PATH_MAP");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<String, String> tmp9 = ((Map<String, String>) field.get(null));
			keyOwnerPathMap = tmp9;
			
			field = thisClass.getDeclaredField("KEY_VALUE_PATH_MAP");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<String, String> tmp10 = ((Map<String, String>) field.get(null));
			keyValuePathMap = tmp10;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("Should not reach this state!", e);
		}
		
		this.attributes = elem.attributes;
		if(elem.children == null){
				elem.loadChildren(false, thisClass);
		}
		this.children = elem.children;
		this.namespaceMap = elem.namespaceMap;
		for(int i=0;i<children.length;++i){
			children[i].setParent(this);
		}
		for(XmlSimpleType attribute : attributes.values()){
			attribute.setParent(this);
		}
		for(String key : attributeDefaultValues.keySet()){
			if(!attributes.containsKey(key)){
				XmlSimpleType attr = new XmlSimpleTypePlaceholder(this.file, this.path+"@"+key, this, null, 0, 0, attributeDefaultValues.get(key));
				attributes.put(key, attr);
			}
		}
		for(String name : requiredAttributes){
			if(!attributes.containsKey(name)){
				throw new XmlValidationException("Attribut \""+name+"\" required, but not provided: "+path);
			}
		}
		if(forbiddenAttributes.contains("##any") &&  attributes.size() > 0){
			throw new XmlValidationException("##Any attributes forbidden, but one provided: "+path);
		}
		if(forbiddenAttributes.contains("##other")){
			for(Map.Entry<String, XmlSimpleType> entry : attributes.entrySet()){
				XmlSimpleType attr = entry.getValue();
				XmlQName attrQualifiedName;
				if(attr.qualifiedName == null){
					attrQualifiedName = attributesNameMap.get(entry.getKey());
					if(attrQualifiedName == null){
						attrQualifiedName = new XmlQName(null, entry.getKey());
					}
				}else{
					attrQualifiedName = attr.qualifiedName;
				}
				if(((attrQualifiedName.namespace == null) && attrQualifiedName.namespace != this.qualifiedName.namespace) || !attrQualifiedName.namespace.equals(this.qualifiedName.namespace)){
					throw new XmlValidationException("##Other attributes forbidden, but provided: "+path);
				}
			}
		}
		if(forbiddenAttributes.contains("##targetNamespace")){
			for(Map.Entry<String, XmlSimpleType> entry : attributes.entrySet()){
				XmlSimpleType attr = entry.getValue();
				XmlQName attrQualifiedName;
				if(attr.qualifiedName == null){
					attrQualifiedName = attributesNameMap.get(entry.getKey());
					if(attrQualifiedName == null){
						attrQualifiedName = new XmlQName(null, entry.getKey());
					}
				}else{
					attrQualifiedName = attr.qualifiedName;
				}
				if(((attrQualifiedName.namespace == null) && attrQualifiedName.namespace == this.qualifiedName.namespace) || attrQualifiedName.namespace.equals(this.qualifiedName.namespace)){
					throw new XmlValidationException("##TargetNamespace attributes forbidden, but provided: "+path);
				}
			}
		}
		if(forbiddenAttributes.contains("##local")){
			for(Map.Entry<String, XmlSimpleType> entry : attributes.entrySet()){
				XmlSimpleType attr = entry.getValue();
				XmlQName attrQualifiedName;
				if(attr.qualifiedName == null){
					attrQualifiedName = attributesNameMap.get(entry.getKey());
					if(attrQualifiedName == null){
						attrQualifiedName = new XmlQName(null, entry.getKey());
					}
				}else{
					attrQualifiedName = attr.qualifiedName;
				}
				if(attrQualifiedName.namespace == null){
					throw new XmlValidationException("##Local attributes forbidden, but provided: "+path);
				}
			}
		}
		for(String name : forbiddenAttributes){
			if(attributes.containsKey(name)){
				throw new XmlValidationException("Attribute \""+name+"\" forbidden, but provided: "+path);
			}
		}
		for(Map.Entry<String, XmlSimpleType> entry : attributes.entrySet()){
			if(!entry.getKey().startsWith("xmlns")){
					String attrName = entry.getKey();
					XmlQName attrQualifiedName = resolveAttributeQName(attrName, this.namespaceMap);
				if(!(
						(allowedAttributes.contains("##any"))||
						(allowedAttributes.contains("##other") && (((attrQualifiedName.namespace == null) && attrQualifiedName.namespace != this.qualifiedName.namespace )|| !attrQualifiedName.namespace.equals(this.qualifiedName.namespace)))||
						(allowedAttributes.contains("##targetNamespace") && (attrQualifiedName.namespace == this.qualifiedName.namespace || attrQualifiedName.namespace.equals(this.qualifiedName.namespace)))
						)){
					if((allowedAttributes.size() > 0) &&
									(!allowedAttributes.contains(attrQualifiedName.name)||
									(attrQualifiedName.namespace != null && allowedAttributes.contains("##local"))
							)){
						throw new XmlValidationException("Attribute \""+entry.getKey()+"\" forbidden here: "+path);
					}
				}
			}
		}
		Map<XmlQName, Integer> childrenCountPerName = new HashMap<XmlQName, Integer>();
		StringBuilder childnameString = new StringBuilder();
		for(int i=0;i<children.length;++i){
			if(!XmlText.class.equals(children[i].getClass())){
				if(!(
						(allowedChildrenNames.contains(new XmlQName(null, "##any")))||
						(allowedChildrenNames.contains(new XmlQName(null, "##other")) && (((children[i].qualifiedName.namespace == null) && children[i].qualifiedName.namespace != this.qualifiedName.namespace )|| !children[i].qualifiedName.namespace.equals(this.qualifiedName.namespace)))||
						(allowedChildrenNames.contains(new XmlQName(null, "##targetNamespace")) && (children[i].qualifiedName.namespace == this.qualifiedName.namespace || children[i].qualifiedName.namespace.equals(this.qualifiedName.namespace)))
						)){
					if((allowedChildrenNames.size() > 0) &&
									(!allowedChildrenNames.contains(children[i].qualifiedName)||
									(children[i].qualifiedName.namespace != null && allowedChildrenNames.contains(new XmlQName(null, "##local")))
							)){
							throw new XmlValidationException("Element \""+children[i].qualifiedName.name+"\" from namespace \""+children[i].qualifiedName.namespace+"\" forbidden here: "+path);
					}
				}
				Queue<XmlQName> queue = new ArrayDeque<XmlQName>();
				XmlQName current;
				queue.add(children[i].qualifiedName);
				while(queue.size() > 0){
					current = queue.poll();
					childrenCountPerName.putIfAbsent(current, Integer.valueOf(0));
					childrenCountPerName.put(current, Integer.valueOf(childrenCountPerName.get(current).intValue()+1));
					Set<XmlQName> supertypes = current.getSupertypes();
					if(supertypes != null){
						queue.addAll(supertypes);
						queue.remove(current);
					}
				}
				childnameString.append(children[i].qualifiedName.name);
				childnameString.append(' ');
			}
		}
		if(!matchChildPattern(allowedChildrenPattern, childnameString.toString())){
			throw new XmlValidationException("Child constellation does not match pattern \""+allowedChildrenPattern+"\": "+path);
		}
		for(Map.Entry<XmlQName, Integer> entry: allowedChildrenMinBounds.entrySet()){
			if(entry.getValue().intValue() > 0){
				Integer tmp = childrenCountPerName.get(entry.getKey());
				if(tmp == null || tmp.intValue() < entry.getValue().intValue()){
					throw new XmlValidationException("Count of element \""+entry.getKey().name+"\" from namespace \""+entry.getKey().namespace.toString()+"\" to low. Should be at least "+entry.getValue().intValue()+", but was "+(tmp==null?0:tmp)+": "+path);
				}
			}
		}
		for(Map.Entry<XmlQName, Integer> entry: allowedChildrenMaxBounds.entrySet()){
			if(entry.getValue().intValue() > 0){
				Integer tmp = childrenCountPerName.get(entry.getKey());
				if(tmp != null && tmp.intValue() > entry.getValue().intValue()){
					throw new XmlValidationException("Count of element \""+entry.getKey().name+"\" from namespace \""+entry.getKey().namespace.toString()+"\" to high. Should be maximal "+entry.getValue().intValue()+", but was "+tmp+": "+path);
				}
			}
		}
		for(Map.Entry<String, String> entry : keyOwnerPathMap.entrySet()){
			String keyField = keyValuePathMap.get(entry.getKey());
			XmlComplexType[] parents;
			XmlType[] valueElements;
			try {
				XmlType[] tmp = getElementsByPath(this, entry.getValue(), thisClass);
				parents = new XmlComplexType[tmp.length];
				for(int i=0;i<tmp.length;++i){
					parents[i] = (XmlComplexType) tmp[i];
				}
				valueElements = createElementsByPath(this, keyField, thisClass);
			} catch (Exception e) {
				throw new XmlValidationException("An Exception occured while fetching elements", e);
			}
			if(valueElements.length != 1){
				throw new XmlValidationException("KeyField selected several or no field(s): "+keyField);
			}
			if(valueElements[0] == null){
				throw new XmlValidationException("KeyField must not be null: "+keyField);
			}
			Object value;
			try {
				value = getValue(valueElements[0]);
			} catch (IllegalArgumentException e) {
				throw new XmlValidationException("An Exception occured while fetching field value", e);
			}
			for(int i=0;i<parents.length;++i){
				parents[i].setKeyElement(entry.getKey(), value.toString(), this);
			}
		}
	}
	
	/**
	 * @param pattern A regular expression, which the {@code childrenString} must match. Values of type "{@literal \\<([^<>]*)\\>}" will be interpreted as references to groups, that may be replaced by this groups pattern.
	 * @param childrenString A string of names of children of this element separated by spaces.
	 * @return If the {@code childrenString} matches {@code pattern} with references to groups replaced by this groups pattern (recursively), this method returns {@code true}, otherwise {@code false};
	 */
	public boolean matchChildPattern(String pattern, String childrenString){
		String referencePatternString = "\\<([^<>]*)\\>";
		final Pattern groupReferencePattern = Pattern.compile(referencePatternString);
		try{
			Queue<String> valuesQueue = new ArrayDeque<String>();
			Queue<String> patternQueue = new ArrayDeque<String>();
			valuesQueue.add(childrenString);
			patternQueue.add(pattern);
			do{
				String currentPattern = patternQueue.poll();
				String currentValue = valuesQueue.poll();
				Matcher patternMatcher = Pattern.compile(currentPattern.replaceAll("\\(", "\\(\\?\\:").replaceAll(referencePatternString, "(.*)")).matcher(currentValue);
				if(patternMatcher.matches()){
					if(patternMatcher.groupCount() > 0){
						String[] patterns = new String[patternMatcher.groupCount()];
						Matcher groupMatcher = groupReferencePattern.matcher(currentPattern);
						int index = 0;
						while (groupMatcher.find()) {
							XmlQName groupName = XmlQName.parseQName(groupMatcher.group(1));
							String groupPattern = file.loader.getSelfrefferingGroupPattern(groupName);
							if(groupPattern == null){
								throw new AssertionError("Selfreffering group cannot be resolved: "+groupName);
							}
							patterns[index] = groupPattern;
							index++;
						}
						for(int i=1;i<patternMatcher.groupCount();++i){
							if(currentValue.equals(patternMatcher.group(i))){
								return false;//Value was not reduced during match, what would cause an endless loop if preceding.
							}
							if(!"".equals(patternMatcher.group(i))){
								valuesQueue.add(patternMatcher.group(i));
								patternQueue.add(patterns[i]);
							}
						}
					}
				}else{
					return false;
				}
			}while(valuesQueue.size() > 0);
			return true;
		}catch(PatternSyntaxException e){
			throw new AssertionError("Could not parse pattern: "+this.getClass(), e);
		}
	}
	
	protected static void addKeyPaths(Class<? extends XmlComplexType> refClass, String keyName, String selectorPath, String fieldPath){
		try {
			Field field = refClass.getDeclaredField("KEY_OWNER_PATH_MAP");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<String, String> keyOwnerPathMap = ((Map<String, String>) field.get(null));
			
			field = refClass.getDeclaredField("KEY_VALUE_PATH_MAP");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<String, String> keyValuePathMap = ((Map<String, String>) field.get(null));
			
			keyOwnerPathMap.put(keyName, selectorPath);
			keyValuePathMap.put(keyName, fieldPath);
		} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("Should not reach this state!", e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public static final  boolean isSimpleType(){
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public static final  boolean isComplexType(){
		return true;
	}
	
	/**
	 * @return This elements {@linkplain namespaceMap}
	 */
	public Map<String, URI> getNamespaceMap(){
		return namespaceMap;
	}
	
	/**
	 * <p>Frees the attribute specified by {@code name}. </p>
	 * <p>If an attribute with the given name exists, it will be replaced by an element of type {@link XmlSimpleTypePlaceholder}</p>
	 * <p>calling its constructor {@link XmlSimpleTypePlaceholder#XmlSimpleTypePlaceholder(XmlSimpleType attr)} with the given attribute.</p>
	 * 
	 * @param name Name of the attribute to be freed
	 */
	public final void freeAttribute(String name){
		name = name.split(":")[0];
		XmlSimpleType attr = attributes.get(name);
		if(attr != null){
			attributes.put(name, freeSimpleType(attr));
		}
	}
	
	/**
	 * <p>Frees the attribute specified by {@code attr}. </p>
	 * <p>If the given attribute is an attribute of this element, it will be replaced by an element of type {@link XmlSimpleTypePlaceholder}</p>
	 * <p>calling its constructor {@link XmlSimpleTypePlaceholder#XmlSimpleTypePlaceholder(XmlSimpleType attr)} with the given attribute.</p>
	 * 
	 * @param attr Name of the attribute to be freed
	 */
	public final void freeAttribute(XmlSimpleType attr){
		for(Map.Entry<String, XmlSimpleType> entry : attributes.entrySet()){
			if(entry.getValue().equals(attr)){
				attributes.put(entry.getKey(), freeSimpleType(attr));
				break;
			}
		}
	}
	
	/**
	 * <p>Frees the children specified by {@code elem}.</p>
	 * <p>If the given element is a child of this element and it's inheriting {@link XmlSimpleType}, then it will be replaced by an element of type {@link XmlSimpleTypePlaceholder} calling its constructor {@link XmlSimpleTypePlaceholder#XmlSimpleTypePlaceholder(XmlSimpleType attr)} with the given element.</p>
	 * <p>If the given element is a child of this element and it's inheriting {@code XmlComplexType}, then it is freed by calling {@link #free()} on it.</p>
	 * 
	 * @param elem The element to be freed
	 */
	public final void freeChild(XmlType elem){
		if(this.children == null){
			throw new IllegalStateException("Cannot free children when subtree isn't loaded.");
		}
		for(int i=0;i<children.length;++i){
			if(children[i].equals(elem)){
				if(XmlSimpleType.class.isAssignableFrom(elem.getClass())){
					children[i] = freeSimpleType((XmlSimpleType) elem);
				}else{
					((XmlComplexType) elem).free();
				}
			}
		}
	}
	
	protected final XmlSimpleTypePlaceholder freeSimpleType(XmlSimpleType elem){
		XmlSimpleTypePlaceholder newElem = new XmlSimpleTypePlaceholder(elem);
		return newElem;
	}
	
	/**
	 * <p>Frees this element by replacing all its attributes the same way as resulting from a call of {link #freeAttribute(String name)} with the attributes name and by setting {@link children} to {@code null}.</p>
	 */
	public final void free(){
		for(Map.Entry<String, XmlSimpleType> entry : attributes.entrySet()){
			attributes.put(entry.getKey(), freeSimpleType(entry.getValue()));
		}
		children = null;
	}
	
	protected final void loadChildren(boolean loadChildContents, Class<? extends XmlComplexType> thisClass){
		Field field;
		Set<XmlQName> allowedChildrenNames;
		try {
			field = thisClass.getDeclaredField("ALLOWED_CHILDREN_NAMES");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Set<XmlQName> tmp = ((Set<XmlQName>) field.get(null));
			allowedChildrenNames = tmp;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("Shpuld not reach this state!", e);
		}
		boolean textChildsAllowed = (allowedChildrenNames.contains(new XmlQName(null, "##any")) || allowedChildrenNames.contains(new XmlQName(xml, "TEXT")));
		loadChildren(loadChildContents, textChildsAllowed, thisClass);
	}
	
	protected final void loadChildren(boolean loadChildContents, boolean loadTextElements, Class<? extends XmlComplexType> thisClass){
		Field field;
		Map<XmlQName, XmlQName> childrenNameMap;
		try {
			field = thisClass.getDeclaredField("CHILDREN_NAME_MAP");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<XmlQName, XmlQName> tmp = ((Map<XmlQName, XmlQName>) field.get(null));
			childrenNameMap = tmp;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("Shpuld not reach this state!", e);
		}
		try{
			RandomAccessFile readFile = file.getFile(0);
			readFile.seek(this.pos);
			List<XmlType> childrenList = file.indexSubtree(readFile, loadChildContents, loadTextElements, this.pos+this.length, this.namespaceMap, childrenNameMap);
			this.children = childrenList.toArray(new XmlType[0]);
			file.releaseFile(readFile);
			for(int i=0;i<this.children.length;++i){
				this.children[i].setParent(this);
			}
		} catch (IOException e) {
			throw new XmlValidationException("Exception occured while parsing", e);
		}
	}
	
	/**
	 * <b>Note:</b> Calling this method inside a constructor of a class extending XmlComplexType might cause the result to be wrong. Use {@link #getAttribute(String name, Class thisClass)} instead.
	 * 
	 * @param name The name of the Attribute to be returned
	 * @return The Attribute specified by {@code name} or {@code null}if none exists.
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown while loading an XmlSimpleTypePlaceholder.
	 */
	public final XmlSimpleType getAttribute(String name) throws IOException{
		return getAttribute(name, this.getClass());
	}
	
	/**
	 * @param name The name of the Attribute to be returned
	 * @param thisClass The class, which should be used, to determine the type of the attribute being loaded
	 * @return The Attribute specified by {@code name} or {@code null}if none exists.
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown while loading an XmlSimpleTypePlaceholder.
	 */
	public final XmlSimpleType getAttribute(String name, Class<? extends XmlComplexType> thisClass) throws IOException {
		name = name.split(":")[0];
		XmlSimpleType attr = attributes.get(name);
		if(attr == null){
			return null;
		}
		if(!(XmlSimpleTypePlaceholder.class.isAssignableFrom(attr.getClass()))){
			return attr;
		}
		Field field;
		Map<String, XmlQName> attributesNameMap;
		try {
			field = thisClass.getDeclaredField("ATTRIBUTES_NAME_MAP");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//Is checked
			Map<String, XmlQName> tmp = ((Map<String, XmlQName>) field.get(null));
			attributesNameMap = tmp;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("Should not reach this state!", e);
		}
		
		XmlQName qualifiedName = attributesNameMap.get(name);
		if(qualifiedName == null){
			qualifiedName = new XmlQName(null, name);
		}
		XmlSimpleType newAttr = ((XmlSimpleTypePlaceholder) attr).load(qualifiedName);
		attributes.put(name, newAttr);
		newAttr.setQualifiedName(attributesNameMap.get(name));
		return newAttr;
	}
	
	protected final boolean setDefaultAttributeValue(String name, XmlSimpleType value){
		if(value != null && !attributes.containsKey(name)){
			attributes.put(name, value);
			return true;
		}
		return false;
	}
	
	protected void setKeyElement(String keyName, String keyValue, XmlType element){
		setKeyElement(this, keyName, keyValue, element);
	}
	
	protected final XmlType createChild(XmlType elem) throws IOException{
		Field field;
		Map<XmlQName, XmlQName> childrenNameMap;
		try {
			field = this.getClass().getDeclaredField("CHILDREN_NAME_MAP");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//All Subtypes should override that field.
			Map<XmlQName, XmlQName> tmp = ((Map<XmlQName, XmlQName>) field.get(null));
			childrenNameMap = tmp;
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("Should not reach this state!", e);
		}
		return createChild(elem, childrenNameMap.get(elem.qualifiedName));
	}
	
	protected final XmlType createChild(XmlType elem, XmlQName type) throws IOException{
		if(children == null){
			throw new AssertionError("Cannot create child. Children ar not loaded: "+path);
		}
		List<XmlType> childList = Arrays.asList(children);
		if(!childList.contains(elem)){
			throw new AssertionError("Cannot create child. Element is no child of this: "+path);
		}
		return createChildUnchecked(elem, childList.indexOf(elem), type);
	}
	
	protected final XmlType createChildUnchecked(XmlType elem, int index, XmlQName type) throws IOException {
		if(!(elem.getClass().equals(XmlComplexType.class) || XmlSimpleTypePlaceholder.class.isAssignableFrom(elem.getClass()))){
			return elem;
		}
		XmlType newElem = file.loader.create(elem, type);
		children[index] = newElem;
		return newElem;
	}
	
	protected final XmlType getChild(Map<XmlQName, XmlQName> typeMap) throws IOException {
		return getChild(typeMap, this.getClass());
	}
	
	protected final XmlType getChild(Map<XmlQName, XmlQName> typeMap, Class<? extends XmlComplexType> thisClass) throws IOException {
		if(typeMap == null){
			throw new IllegalArgumentException("Names must not be null: "+path);
		}
		if(children == null){
			loadChildren(false, thisClass);
		}
		for(int i=0;i<children.length;++i){
			if(typeMap.containsKey(children[i].qualifiedName)){
				return createChildUnchecked(children[i], i, typeMap.get(children[i].qualifiedName));
			}
		}
		return null;
	}
	
	protected final XmlType getChild(XmlQName name, XmlQName type, Class<? extends XmlComplexType> thisClass) throws IOException {
		return getChild(Map.of(name, type), thisClass);
	}
	
	protected final XmlType getChild(Set<XmlQName> types, Class<? extends XmlComplexType> thisClass) throws IOException {
		return getChild(types.stream().collect(Collectors.toMap(k -> k, e -> e)), thisClass);
	}
	
	protected final XmlType getChild(XmlQName type, Class<? extends XmlComplexType> thisClass) throws IOException {
		return getChild(type, type, thisClass);
	}
	
	protected final XmlType getChild(XmlQName name, XmlQName type) throws IOException {
		return getChild(Map.of(name, type));
	}
	
	protected final XmlType getChild(Set<XmlQName> types) throws IOException {
		return getChild(types.stream().collect(Collectors.toMap(k -> k, e -> e)));
	}
	
	protected final XmlType getChild(XmlQName type) throws IOException {
		return getChild(type, type);
	}
	
	protected final Object[] getChildren(Object[] array, Map<XmlQName, XmlQName> typeMap) throws IOException {
		return getChildren(array, typeMap, this.getClass());
	}
	
	protected final Object[] getChildren(Object[] array, Map<XmlQName, XmlQName> typeMap, Class<? extends XmlComplexType> thisClass) throws IOException {
		if(typeMap == null){
			throw new IllegalArgumentException("Names must not be null: "+path);
		}
		ArrayList<XmlType> ret = new ArrayList<XmlType>();
		if(children == null){
			loadChildren(false, thisClass);
		}
		for(int i=0;i<children.length;++i){
			if(typeMap.containsKey(children[i].qualifiedName)){
				ret.add(createChildUnchecked(children[i], i, typeMap.get(children[i].qualifiedName)));
			}
		}
		return ret.toArray(array);
	}
	
	protected final Object[] getChildren(Object[] array, XmlQName name, XmlQName type, Class<? extends XmlComplexType> thisClass) throws IOException {
		return getChildren(array, Map.of(name, type), thisClass);
	}
	
	protected final Object[] getChildren(Object[] array, Set<XmlQName> types, Class<? extends XmlComplexType> thisClass) throws IOException {
		return getChildren(array, types.stream().collect(Collectors.toMap(k -> k, e -> e)), thisClass);
	}
	
	protected final Object[] getChildren(Object[] array, XmlQName type, Class<? extends XmlComplexType> thisClass) throws IOException {
		return getChildren(array, type, type, thisClass);
	}
	
	protected final Object[] getChildren(Object[] array, XmlQName name, XmlQName type) throws IOException {
		return getChildren(array, Map.of(name, type));
	}
	
	protected final Object[] getChildren(Object[] array, Set<XmlQName> types) throws IOException {
		return getChildren(array, types.stream().collect(Collectors.toMap(k -> k, e -> e)));
	}
	
	protected final Object[] getChildren(Object[] array, XmlQName type) throws IOException {
		return getChildren(array, type, type);
	}
	
	
	/**
	 * <p>This is equivalent to calling {@link #getElementByKey(XmlComplexType type, String keyName, String keyValue)} with {@code this} as first parameter.</p>
	 * 
	 * @param keyName The name of the key as specified in the "name" attribute of the key in the schema, this element belongs to.
	 * @param keyValue  The value of the key
	 * @return The element, which is associated with this key or null, if none exists
	 */
	public XmlType getElementByKey(String keyName, String keyValue){
		return getElementByKey(this, keyName, keyValue);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, boolean[] array, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public boolean[] getValuesByPath(String path, boolean[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, this.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, boolean[] array, int[] length, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public boolean[] getValuesByPath(String path, boolean[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, length, this.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, boolean[] array, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public boolean[] getValuesByPathParallel(String path, boolean[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public boolean[] getValuesByPathParallel(String path, boolean[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, length, this.getClass(), execService);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, byte[] array, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public byte[] getValuesByPath(String path, byte[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, byte[] array, int[] length, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public byte[] getValuesByPath(String path, byte[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, length, this.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, byte[] array, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public byte[] getValuesByPathParallel(String path, byte[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public byte[] getValuesByPathParallel(String path, byte[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, length, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, short[] array, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public short[] getValuesByPath(String path, short[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, short[] array, int[] length, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public short[] getValuesByPath(String path, short[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, length, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, short[] array, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public short[] getValuesByPathParallel(String path, short[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public short[] getValuesByPathParallel(String path, short[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, length, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, int[] array, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public int[] getValuesByPath(String path, int[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, int[] array, int[] length, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public int[] getValuesByPath(String path, int[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, length, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, int[] array, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public int[] getValuesByPathParallel(String path, int[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public int[] getValuesByPathParallel(String path, int[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, length, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, long[] array, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public long[] getValuesByPath(String path, long[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, long[] array, int[] length, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public long[] getValuesByPath(String path, long[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, length, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, long[] array, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public long[] getValuesByPathParallel(String path, long[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public long[] getValuesByPathParallel(String path, long[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, length, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, float[] array, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public float[] getValuesByPath(String path, float[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, float[] array, int[] length, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public float[] getValuesByPath(String path, float[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, length, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, float[] array, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public float[] getValuesByPathParallel(String path, float[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public float[] getValuesByPathParallel(String path, float[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, length, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, double[] array, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public double[] getValuesByPath(String path, double[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, double[] array, int[] length, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public double[] getValuesByPath(String path, double[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, length, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, double[] array, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public double[] getValuesByPathParallel(String path, double[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public double[] getValuesByPathParallel(String path, double[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, length, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, char[] array, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public char[] getValuesByPath(String path, char[] array) throws InterruptedException, ExecutionException, IOException {
		return getValuesByPath(this, path, array, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, char[] array, int[] length, Class parentClass)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public char[] getValuesByPath(String path, char[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, length, this.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, char[] array, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public char[] getValuesByPathParallel(String path, char[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code this} as first and {@code this.getClass()} as last parameter.</p>
	 * 
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public char[] getValuesByPathParallel(String path, char[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, length, this.getClass(), execService);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType parent, String path, Object[] array, Class parentClass)} with {@code this} as first parameter.</p>
	 * 
	 * @param <T> Type of {@code array}
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValue(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, Object[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, Object[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public <T> T[] getValuesByPath(String path, T[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(this, path, array, this.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, Object[] array, Class parentClass, ExecutorService execService)} with {@code this} as first parameter.</p>
	 *
	 * @param <T> Type of {@code array}
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValue(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public <T> T[] getValuesByPathParallel(String path, T[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(this, path, array, this.getClass(), execService);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getElementsByPath(XmlComplexType type, String path)} with {@code this} as first parameter.</p>
	 * 
	 * @param path The path, that specifies which elements should be fetched
	 * @return The elements fetched
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public XmlType[] getElementsByPath(String path) throws InterruptedException, ExecutionException {
		return getElementsByPath(this, path);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getElementsByPathParallel(XmlComplexType type, String path, ExecutorService execService)} with {@code this} as first parameter.</p>
	 * 
	 * @param path The path, that specifies which elements should be fetched
	 * @return The elements fetched
	 * @param execService The execService used for parallelization.
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public XmlType[] getElementsByPathParallel(String path, ExecutorService execService) throws InterruptedException, ExecutionException{
		return getElementsByPathParallel(this, path, execService);
	}
	
	/**
	 * <p>Resolves the qualifiedName of an attribute.</p>
	 * 
	 * @param attrName The String, which should be resolved
	 * @param namespaceMap The namespaceMap, tah's used for resolving namespace identifiers
	 * @return The resolved qualified Name of the Attribute
	 */
	public static XmlQName resolveAttributeQName(String attrName, Map<String, URI> namespaceMap){
		if(attrName.contains(":")){
			String[] splitName = attrName.split(":");
			if(splitName.length == 2 && "xmlns".equals(splitName[0])){
				return new XmlQName(xs, "namespace");
			}else{
				return XmlQName.parseQName(attrName, namespaceMap);
			}
		}else{
			return new XmlQName(null, attrName);
		}
	}
	
	/**
	 * <p>This method is used to retrieve associated with a key as defined in a XML-schema using the {@literal <xs:key>-element}.</p>
	 * 
	 * @param parent The element, which defines the key.
	 * @param keyName The name of the key as specified in the "name" attribute of the key in the schema, this element belongs to.
	 * @param keyValue The value of the key
	 * @return The element, which is associated with this value under this key or null, if none exists
	 */
	public static XmlType getElementByKey(XmlComplexType parent, String keyName, String keyValue){
		Field field;
		Map<String, Map<String, XmlType>> keyMaps;
		try {
			field = parent.getClass().getDeclaredField("KEY_MAPS");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//All Subtypes should override that field.
			Map<String, Map<String, XmlType>> tmp = ((Map<String, Map<String, XmlType>>) field.get(null));
			keyMaps = tmp;
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("Should not reach this state!", e);
		}
		Map<String, XmlType> keyMap = keyMaps.get(keyName);
		if(keyMap == null){
			throw new IllegalArgumentException("An key with the given name has not been specified: "+keyName);
		}
		return keyMap.get(keyValue);
	}

	/**
	 * @param parent The element, which defines the key.
	 * @param keyName The name of the key as specified in the "name" attribute of the key in the schema, this element belongs to.
	 * @param keyValue The value of the key
	 * @param element The element, which should be associated with this value under this key
	 */
	public static void setKeyElement(XmlComplexType parent, String keyName, String keyValue, XmlType element){
		Field field;
		Map<String, Map<String, XmlType>> keyMaps;
		try {
			field = parent.getClass().getDeclaredField("KEY_MAPS");
			field.setAccessible(true);
			@SuppressWarnings("unchecked")//All Subtypes should override that field.
			Map<String, Map<String, XmlType>> tmp = ((Map<String, Map<String, XmlType>>) field.get(null));
			keyMaps = tmp;
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			throw new AssertionError("Should not reach this state!", e);
		}
		Map<String, XmlType> keyMap = keyMaps.get(keyName);
		if(keyMap == null){
			throw new XmlValidationException("An key with the given name has not been specified: "+keyName);
		}
		if(keyMap.containsKey(keyValue)){
			throw new XmlValidationException("Duplicated key \""+keyValue+"\" in Map \""+keyName+"\"");
		}else{
			keyMap.put(keyValue, element);
		}
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, boolean[] array, int[] length, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static boolean[] getValuesByPath(XmlComplexType parent, String path, boolean[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, length, parent.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, boolean[] array, int[] length, Class parentClass)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static boolean[] getValuesByPath(XmlComplexType parent, String path, boolean[] array, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parentClass);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, boolean[] array, int[] length, Class parentClass)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static boolean[] getValuesByPath(XmlComplexType parent, String path, boolean[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parent.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static boolean[] getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, length, parent.getClass(), execService);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static boolean[] getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parentClass, execService);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	* @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static boolean[] getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parent.getClass(), execService);
	}
	
	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValueBoolean(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static boolean[] getValuesByPath(XmlComplexType parent, String path, boolean[] array, int[] length, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, length, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			array = new boolean[elements.length];
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValueBoolean(elements[i]);
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}
	
	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValueBoolean(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueBoolean(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static boolean[] getValuesByPathParallel(XmlComplexType parent, String path, boolean[] array, int[] length, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final boolean value;
			
			public ValueWrapper(int index, boolean value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			array = new boolean[elements.length];
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValueBoolean(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, byte[] array, int[] length, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static byte[] getValuesByPath(XmlComplexType parent, String path, byte[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, length, parent.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, byte[] array, int[] length, Class parentClass)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static byte[] getValuesByPath(XmlComplexType parent, String path, byte[] array, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parentClass);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, byte[] array, int[] length, Class parentClass)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static byte[] getValuesByPath(XmlComplexType parent, String path, byte[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parent.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static byte[] getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, length, parent.getClass(), execService);
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static byte[] getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parentClass, execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	* @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static byte[] getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parent.getClass(), execService);
	}
	
	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValueByte(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static byte[] getValuesByPath(XmlComplexType parent, String path, byte[] array, int[] length, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, length, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			array = new byte[elements.length];
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValueByte(elements[i]);
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValueByte(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueByte(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static byte[] getValuesByPathParallel(XmlComplexType parent, String path, byte[] array, int[] length, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final byte value;
			
			public ValueWrapper(int index, byte value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			array = new byte[elements.length];
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValueByte(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, short[] array, int[] length, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static short[] getValuesByPath(XmlComplexType parent, String path, short[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, length, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, short[] array, int[] length, Class parentClass)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static short[] getValuesByPath(XmlComplexType parent, String path, short[] array, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parentClass);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, short[] array, int[] length, Class parentClass)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static short[] getValuesByPath(XmlComplexType parent, String path, short[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static short[] getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, length, parent.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static short[] getValuesByPathParallel(XmlComplexType parent, String path, short[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parentClass, execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static short[] getValuesByPathParallel(XmlComplexType parent, String path, short[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parent.getClass(), execService);
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValueShort(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static short[] getValuesByPath(XmlComplexType parent, String path, short[] array, int[] length, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, length, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			array = new short[elements.length];
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValueShort(elements[i]);
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValueShort(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueShort(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static short[] getValuesByPathParallel(XmlComplexType parent, String path, short[] array, int[] length, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final short value;
			
			public ValueWrapper(int index, short value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			array = new short[elements.length];
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValueShort(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, int[] array, int[] length, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static int[] getValuesByPath(XmlComplexType parent, String path, int[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, length, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, int[] array, int[] length, Class parentClass)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static int[] getValuesByPath(XmlComplexType parent, String path, int[] array, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parentClass);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, int[] array, int[] length, Class parentClass)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static int[] getValuesByPath(XmlComplexType parent, String path, int[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static int[] getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, length, parent.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static int[] getValuesByPathParallel(XmlComplexType parent, String path, int[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parentClass, execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static int[] getValuesByPathParallel(XmlComplexType parent, String path, int[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parent.getClass(), execService);
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValueInt(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static int[] getValuesByPath(XmlComplexType parent, String path, int[] array, int[] length, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, length, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			array = new int[elements.length];
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValueInt(elements[i]);
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValueInt(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueInt(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static int[] getValuesByPathParallel(XmlComplexType parent, String path, int[] array, int[] length, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final int value;
			
			public ValueWrapper(int index, int value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			array = new int[elements.length];
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValueInt(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, long[] array, int[] length, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static long[] getValuesByPath(XmlComplexType parent, String path, long[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, length, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, long[] array, int[] length, Class parentClass)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static long[] getValuesByPath(XmlComplexType parent, String path, long[] array, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parentClass);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, long[] array, int[] length, Class parentClass)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static long[] getValuesByPath(XmlComplexType parent, String path, long[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static long[] getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, length, parent.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static long[] getValuesByPathParallel(XmlComplexType parent, String path, long[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parentClass, execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static long[] getValuesByPathParallel(XmlComplexType parent, String path, long[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parent.getClass(), execService);
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValueLong(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static long[] getValuesByPath(XmlComplexType parent, String path, long[] array, int[] length, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, length, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			array = new long[elements.length];
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValueLong(elements[i]);
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValueLong(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueLong(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static long[] getValuesByPathParallel(XmlComplexType parent, String path, long[] array, int[] length, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final long value;
			
			public ValueWrapper(int index, long value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			array = new long[elements.length];
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValueLong(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, float[] array, int[] length, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static float[] getValuesByPath(XmlComplexType parent, String path, float[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, length, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, float[] array, int[] length, Class parentClass)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static float[] getValuesByPath(XmlComplexType parent, String path, float[] array, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parentClass);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, float[] array, int[] length, Class parentClass)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static float[] getValuesByPath(XmlComplexType parent, String path, float[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	  * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static float[] getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, length, parent.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static float[] getValuesByPathParallel(XmlComplexType parent, String path, float[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parentClass, execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static float[] getValuesByPathParallel(XmlComplexType parent, String path, float[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parent.getClass(), execService);
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValueFloat(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static float[] getValuesByPath(XmlComplexType parent, String path, float[] array, int[] length, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, length, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			array = new float[elements.length];
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValueFloat(elements[i]);
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValueFloat(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueFloat(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static float[] getValuesByPathParallel(XmlComplexType parent, String path, float[] array, int[] length, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final float value;
			
			public ValueWrapper(int index, float value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			array = new float[elements.length];
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValueFloat(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, double[] array, int[] length, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static double[] getValuesByPath(XmlComplexType parent, String path, double[] array, int[] length) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, length, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, double[] array, int[] length, Class parentClass)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static double[] getValuesByPath(XmlComplexType parent, String path, double[] array, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parentClass);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, double[] array, int[] length, Class parentClass)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static double[] getValuesByPath(XmlComplexType parent, String path, double[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, null, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static double[] getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, length, parent.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static double[] getValuesByPathParallel(XmlComplexType parent, String path, double[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parentClass, execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static double[] getValuesByPathParallel(XmlComplexType parent, String path, double[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parent.getClass(), execService);
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValueDouble(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static double[] getValuesByPath(XmlComplexType parent, String path, double[] array, int[] length, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, length, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			array = new double[elements.length];
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValueDouble(elements[i]);
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValueDouble(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueDouble(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static double[] getValuesByPathParallel(XmlComplexType parent, String path, double[] array, int[] length, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final double value;
			
			public ValueWrapper(int index, double value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			array = new double[elements.length];
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValueDouble(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, char[] array, int[] length, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static char[] getValuesByPath(XmlComplexType parent, String path, char[] array, int[] length) throws InterruptedException, ExecutionException, IOException {
		return getValuesByPath(parent, path, array, length, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, char[] array, int[] length, Class parentClass)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static char[] getValuesByPath(XmlComplexType parent, String path, char[] array, Class<? extends XmlComplexType> parentClass) throws InterruptedException, ExecutionException, IOException {
		return getValuesByPath(parent, path, array, null, parentClass);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, char[] array, int[] length, Class parentClass)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static char[] getValuesByPath(XmlComplexType parent, String path, char[] array) throws InterruptedException, ExecutionException, IOException {
		return getValuesByPath(parent, path, array, null, parent.getClass());
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static char[] getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, length, parent.getClass(), execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static char[] getValuesByPathParallel(XmlComplexType parent, String path, char[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parentClass, execService);
	}

	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} with {@code null} as {@code length} and {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static char[] getValuesByPathParallel(XmlComplexType parent, String path, char[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, null, parent.getClass(), execService);
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValueChar(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static char[] getValuesByPath(XmlComplexType parent, String path, char[] array, int[] length, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, length, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			array = new char[elements.length];
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValueChar(elements[i]);
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}

	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValueChar(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code array} is not big enough to store the values returned, a new array is created.</p>
	 * <p>If {@code array} is bigger, than the count of elements set by this function, only the beginning of the array is changed. All elements at index starting at {@code length[0]} inclusive will be unchanged.</p>
	 * 
	 * <p>If {@code length} is not null and {@code length.length > 0}, the first element of {@code length} is set to the count of values set by this function. </p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param length An array, which may be used to retrieve the count of values set by this function
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValueChar(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static char[] getValuesByPathParallel(XmlComplexType parent, String path, char[] array, int[] length, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final char value;
			
			public ValueWrapper(int index, char value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			array = new char[elements.length];
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValueChar(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		if(length != null && length.length > 0){
			length[0] = elements.length;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPath(XmlComplexType type, String path, Object[] array, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param <T> Type of {@code array}
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValue(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, Object[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, Object[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static <T> T[] getValuesByPath(XmlComplexType parent, String path, T[] array) throws IOException, InterruptedException, ExecutionException {
		return getValuesByPath(parent, path, array, parent.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getValuesByPathParallel(XmlComplexType type, String path, Object[] array, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param <T> Type of {@code array}
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValue(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static <T> T[] getValuesByPathParallel(XmlComplexType parent, String path, T[] array, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getValuesByPathParallel(parent, path, array, parent.getClass(), execService);
	}
	
	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that it calls the {@link #getValue(XmlType elem)} on each of this elements and stores the result in the result-array.</p>
	 * <p>After that, elements are freed using the {@link #freeElements(XmlType[] elements, int depth)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getValuesByPathParallel(XmlComplexType parent, String path, Object[] array, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 * 
	 * {@code array} and the return value are handled like a call to {@link java.util.Collection#toArray(Object[] a)} i.e.:
	 * <q>
	 * Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array. If the collection fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this collection.
	 *
	 * If this collection fits in the specified array with room to spare (i.e., the array has more elements than this collection), the element in the array immediately following the end of the collection is set to null. (This is useful in determining the length of this collection only if the caller knows that this collection does not contain any null elements.) 
	 * </q>
	 * <p>where {@code collection} is the set of values fetched by this method.</p>
	 * 
	 * @param <T> Type of {@code array}
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValue(XmlType elem)} function. 
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by {@link #createElementsByPath(XmlComplexType parent, String path, Class parentClass)}.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, Object[] array, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getValuesByPathParallel(XmlComplexType parent, String path, Object[] array, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static <T> T[] getValuesByPath(XmlComplexType parent, String path, T[] array, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getValuesByPathParallel(parent, path, array, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = createElementsByPath(parent, path, parentClass);
		if(array.length < elements.length){
			@SuppressWarnings("unchecked")//Is checked
			T[] tmp = (T[]) Array.newInstance(array.getClass().getComponentType(), elements.length);
			array = tmp;
		}else if(array.length > elements.length){
			array[elements.length] = null;
		}
		for(int i=0;i<elements.length;++i){
			array[i] = getValue(elements[i]);
		}
		freeElements(elements, parent.file.getGetValuesFreeDepth());
		return array;
	}
	
	/**
	 * <p>This method first creates and collects all elements specified by {@code path} using the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that it calls the {@link #getValue(XmlType elem)} on each of this elements and stores the result in the result-array.(This is parallelized by submitting jobs to {@code execService})</p>
	 * <p>After that, elements are freed using the {@link #freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService)} method with {@code parent.file.getGetValuesFreeDepth()} as last parameter.</p>
	 * 
	 * {@code array} and the return value are handled like a call to {@link java.util.Collection#toArray(Object[] a)} i.e.:
	 * <q>
	 * Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array. If the collection fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this collection.
	 *
	 * If this collection fits in the specified array with room to spare (i.e., the array has more elements than this collection), the element in the array immediately following the end of the collection is set to null. (This is useful in determining the length of this collection only if the caller knows that this collection does not contain any null elements.) 
	 * </q>
	 * <p>where {@code collection} is the set of values fetched by this method.</p>
	 * 
	 * @param <T> Type of {@code array}
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path used to specify the elements collected. This must only refer to elements with a "getValue"-Method, like elements of type {@code XmlSimpleType} or special elements of type {@code XmlComplexType}
	 * @param array The array, in which the values should be stored in.
	 * @param parentClass The class, which is used by {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return An array of elements filled with the values returned by the calls of the {@link #getValue(XmlType elem)} function. 
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static <T> T[] getValuesByPathParallel(XmlComplexType parent, String path, T[] array, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ValueWrapper{
			public final int index;
			public final T value;
			
			public ValueWrapper(int index, T value){
				this.index = index;
				this.value = value;
			}
		}
		
		XmlType[] elements = createElementsByPathParallel(parent, path, parentClass, execService);
		if(array.length < elements.length){
			@SuppressWarnings("unchecked")//Is checked
			T[] tmp = (T[]) Array.newInstance(array.getClass().getComponentType(), elements.length);
			array = tmp;
		}else if(array.length > elements.length){
			array[elements.length] = null;
		}
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ValueWrapper>> futures =  new ArrayList<Future<ValueWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ValueWrapper>() {
				@Override
				public ValueWrapper call() {
					int i = index.getAndIncrement();
					return new ValueWrapper(i, getValue(elements[i]));
				}
			}));
		}
		for(Future<ValueWrapper> future: futures) {
			ValueWrapper currentWrapper = future.get();
			array[currentWrapper.index] = currentWrapper.value;
		}
		freeElementsParallel(elements, parent.file.getGetValuesFreeDepth(), execService);
		return array;
	}
	
	/**
	 * <p>Calls {@link #getValue(XmlType elem)} on {@code element} and unwraps the result</p>
	 * 
	 * @param element The element, which's value should be fetched
	 * @return The unwrapped fetched value
	 */
	public static boolean getValueBoolean(XmlType element) {
		return ((Boolean) getValue(element)).booleanValue();
	}

	/**
	 * <p>Calls {@link #getValue(XmlType elem)} on {@code element} and unwraps the result</p>
	 * 
	 * @param element The element, which's value should be fetched
	 * @return The unwrapped fetched value
	 */
	public static byte getValueByte(XmlType element) {
		return ((Byte) getValue(element)).byteValue();
	}

	/**
	 * <p>Calls {@link #getValue(XmlType elem)} on {@code element} and unwraps the result</p>
	 * 
	 * @param element The element, which's value should be fetched
	 * @return The unwrapped fetched value
	 */
	public static short getValueShort(XmlType element) {
		return ((Short) getValue(element)).shortValue();
	}

	/**
	 * <p>Calls {@link #getValue(XmlType elem)} on {@code element} and unwraps the result</p>
	 * 
	 * @param element The element, which's value should be fetched
	 * @return The unwrapped fetched value
	 */
	public static int getValueInt(XmlType element) {
		return ((Integer) getValue(element)).intValue();
	}

	/**
	 * <p>Calls {@link #getValue(XmlType elem)} on {@code element} and unwraps the result</p>
	 * 
	 * @param element The element, which's value should be fetched
	 * @return The unwrapped fetched value
	 */
	public static long getValueLong(XmlType element) {
		return ((Long) getValue(element)).longValue();
	}

	/**
	 * <p>Calls {@link #getValue(XmlType elem)} on {@code element} and unwraps the result</p>
	 * 
	 * @param element The element, which's value should be fetched
	 * @return The unwrapped fetched value
	 */
	public static float getValueFloat(XmlType element) {
		return ((Float) getValue(element)).floatValue();
	}

	/**
	 * <p>Calls {@link #getValue(XmlType elem)} on {@code element} and unwraps the result</p>
	 * 
	 * @param element The element, which's value should be fetched
	 * @return The unwrapped fetched value
	 */
	public static double getValueDouble(XmlType element) {
		return ((Double) getValue(element)).doubleValue();
	}

	/**
	 * <p>Calls {@link #getValue(XmlType elem)} on {@code element} and unwraps the result</p>
	 * 
	 * @param element The element, which's value should be fetched
	 * @return The unwrapped fetched value
	 */
	public static char getValueChar(XmlType element) {
		return ((Character) getValue(element)).charValue();
	}
	
	/**
	 * <p>Fetches the value of the element by calling its "getValue"-method. If no such method exists, an Exception will be thrown.</p>
	 * 
	 * @param <T> Type of the value returned
	 * @param element The element, which's value should be fetched
	 * @return The fetched value
	 */
	public static <T> T getValue(XmlType element) {
		String getValueName = "getValue";//Values are wrapped on invoke anyway
		T currentValue;
		try {
			Method getValueMethod = element.getClass().getDeclaredMethod(getValueName);
			@SuppressWarnings("unchecked")//It is not checked. May throw an Exception if error occurs!
			T tmp = (T) getValueMethod.invoke(element);
			currentValue = tmp;
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("Path does reference elements, that do not have a Methode names \""+getValueName+"\"", e);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new AssertionError("Should not reach this state!", e);
		}
		
		return currentValue;
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getElementsByPath(XmlComplexType type, String path, Class parentClass)} with {@code parent.getClass()} as last parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path, that specifies which elements should be fetched
	 * @return The elements fetched
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static XmlType[] getElementsByPath(XmlComplexType parent, String path) throws InterruptedException, ExecutionException {
		return getElementsByPath(parent, path, parent.getClass());
	}
	
	/**
	 * <p>This is equivalent to calling {@link #getElementsByPathParallel(XmlComplexType type, String path, Class parentClass, ExecutorService execService)} with {@code parent.getClass()} as parentClass parameter.</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path, that specifies which elements should be fetched
	 * @return The elements fetched
	 * @param execService The execService used for parallelization.
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static XmlType[] getElementsByPathParallel(XmlComplexType parent, String path, ExecutorService execService) throws InterruptedException, ExecutionException {
		return getElementsByPathParallel(parent, path, parent.getClass(), execService);
	}
	
	/**
	 * <p>This method first retrieves the elements specified by {@code path} using the {@link #getElementsByPath(XmlComplexType parent, String path, Class parentClass)} method.</p>
	 * <p>After that, it creates those elements and all of their ancestors using the {@link #createChild(XmlType element)} and the {@link XmlLoaderExtension#create(XmlType element)} methods.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 *
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path, that specifies which elements should be created
	 * @param parentClass The class, which is used by {@link #getElementsByPath(XmlComplexType parent, String path, Class parentClass)}
	 * @return The created elements
	 * @throws IOException if an IOException was thrown by an underlying method, in this case, if one was thrown by one of the create functions.
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #createElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static XmlType[] createElementsByPath(XmlComplexType parent, String path, Class<? extends XmlComplexType> parentClass) throws IOException, InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return createElementsByPathParallel(parent, path, parentClass, parent.file.loader.execService);
		}
		
		XmlType[] elements = getElementsByPath(parent, path, parentClass);
		for(int i=0;i<elements.length;++i){
			if(XmlComplexType.class.equals(elements[i].getClass())){
				Stack<XmlComplexType> parentStack = new Stack<XmlComplexType>();
				XmlComplexType currentParent = elements[i].parent;
				if(currentParent != null){
					while(currentParent != null && XmlComplexType.class.equals(currentParent.getClass())){
						parentStack.push(currentParent);
						currentParent = currentParent.parent;
					}
					if(currentParent == null){
						currentParent = parentStack.pop();
						currentParent = (XmlComplexType) currentParent.file.loader.create(currentParent);
					}
					while(parentStack.size() > 0){
						currentParent = (XmlComplexType) currentParent.createChild(parentStack.pop());
					}
					elements[i] = currentParent.createChild(elements[i]);
				}else{
					elements[i] = elements[i].file.loader.create(elements[i]);
				}
			}
		}
		return elements;
	}
	
	/**
	 * <p>This method first retrieves the elements specified by {@code path} using the {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} method.</p>
	 * <p>After that, it creates those elements and all of their ancestors using the {@link #createChild(XmlType element)} and the {@link XmlLoaderExtension#create(XmlType element)} methods.(This is parallelized by submitting jobs to {@code execService})</p>
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path, that specifies which elements should be created
	 * @param parentClass The class, which is used by {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)}
	 * @param execService The execService used for parallelization.
	 * @return The created elements
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static XmlType[] createElementsByPathParallel(XmlComplexType parent, String path, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		class ElementWrapper{
			public final int index;
			public final XmlType element;
			
			public ElementWrapper(int index, XmlType element){
				this.index = index;
				this.element = element;
			}
		}
		
		XmlType[] elements = getElementsByPathParallel(parent, path, parentClass, execService);
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<ElementWrapper>> futures =  new ArrayList<Future<ElementWrapper>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<ElementWrapper>() {
				@Override
				public ElementWrapper call() throws IOException {
					int i = index.getAndIncrement();
					XmlType currentElement = null;
					if(XmlComplexType.class.equals(elements[i].getClass())){
						Stack<XmlComplexType> parentStack = new Stack<XmlComplexType>();
						XmlComplexType currentParent = elements[i].parent;
						if(currentParent != null){
							while(currentParent != null && XmlComplexType.class.equals(currentParent.getClass())){
								parentStack.push(currentParent);
								currentParent = currentParent.parent;
							}
							if(currentParent == null){
								currentParent = parentStack.pop();
								currentParent = (XmlComplexType) currentParent.file.loader.create(currentParent);
							}
							while(parentStack.size() > 0){
								currentParent = (XmlComplexType) currentParent.createChild(parentStack.pop());
							}
							currentElement = currentParent.createChild(elements[i]);
						}else{
							currentElement = elements[i].file.loader.create(elements[i]);
						}
					}
					if(currentElement == null){
						i = -1;
					}
					return new ElementWrapper(i, currentElement);
				}
			}));
		}
		for(Future<ElementWrapper> future: futures) {
			ElementWrapper currentWrapper = future.get();
			if(currentWrapper.index != -1){
				elements[currentWrapper.index] = currentWrapper.element;
			}
		}
		return elements;
	}
	
	/**
	 * <p>Frees elements depending on {@code depth}.</p>
	 * 
	 * <p>If {@code depth} is 0, no elements will be freed.</p>
	 * <p>if {@code depth} is greater than zero, ancestors of degree {@code depth} of each of {@code elements} will be freed, where  a {@code depth} of 1 means the elements themself.</p>
	 * <p>if {@code depth} is smaller than zero, the elements themself and all of their ancestors will be freed.</p>
	 * 
	 * @param elements The elements, relative to which freeing is evaluated
	 * @param depth The depth of freeing
	 */
	public static void freeElements(XmlType[] elements, int depth){
		for(int i=0;i<elements.length;++i){
			XmlType currentElement = elements[i];
			for(int j=0;(depth == -1?true:j<depth) && currentElement.parent != null;++j){
				currentElement = currentElement.parent;
			}
			if(XmlSimpleType.class.isAssignableFrom(currentElement.getClass())){
				if(currentElement.parent != null){
					currentElement.parent.freeAttribute((XmlSimpleType) currentElement);
					currentElement.parent.freeChild(currentElement);
				}
			}else{
				((XmlComplexType) currentElement).free();
			}
		}
	}
	
	
	/**
	 * <p>Frees elements depending on {@code depth}.</p>
	 * 
	 * <p>If {@code depth} is 0, no elements will be freed.</p>
	 * <p>if {@code depth} is greater than zero, ancestors of degree {@code depth} of each of {@code elements} will be freed, where  a {@code depth} of 1 means the elements themself.</p>
	 * <p>if {@code depth} is smaller than zero, the elements themself and all of their ancestors will be freed.</p>
	 * 
	 * @param elements The elements, relative to which freeing is evaluated
	 * @param depth The depth of freeing
	 * @param execService The execService used for parallelization.
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static void freeElementsParallel(XmlType[] elements, int depth, ExecutorService execService) throws InterruptedException, ExecutionException {
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<Void>> futures =  new ArrayList<Future<Void>>(elements.length);
		for(int i=0;i<elements.length;++i){
			futures.add(execService.submit(new Callable<Void>() {
				@Override
				public Void call(){
					XmlType currentElement = elements[index.getAndIncrement()];
					for(int j=0;(depth == -1?true:j<depth) && currentElement.parent != null;++j){
						currentElement = currentElement.parent;
					}
					if(XmlSimpleType.class.isAssignableFrom(currentElement.getClass())){
						if(currentElement.parent != null){
							currentElement.parent.freeAttribute((XmlSimpleType) currentElement);
							currentElement.parent.freeChild(currentElement);
						}
					}else{
						((XmlComplexType) currentElement).free();
					}
					return null;
				}
			}));
		}
		for(Future<Void> future: futures) {
			future.get();
		}
	}
	
	/**
	 * <p>Evaluates the path specified by {@code path} relatively to {@code parent} and returns the resulting elements.</p>
	 * 
	 * <p>If {@code file.loader.execService != null}, the {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} is called with {@code file.loader.execService} as last parameter.</p>
	 *
	 * {@code path} must follow the following Syntax:
	 * <pre>
	 * path = idPath | (normalPath ( '|' normalPath)*);
	 * idPath = '#' id;
	 * normalPath = (node '/')* node?;
	 * id = {@link XmlSimpleTypes.XmlID#ID_PATTERN_STRING};
	 * node = identifier | (identifier?predicate);
	 * identifier = '@'? ( '*' | qname) | '.'{0,2} | '::' axisName;
	 * predicate = '[' ( [0-9]+ | ':'? [^ ']' ]+ \\s* '=' \\s* [^ ']' ]+ ) ']';
	 * qname = name | namespace | '{' \\s* namespace \\s* ',' \\s* name \\s* '}' | namespaceIdentifier ':' ( '*' | name);
	 * axisName = 'ancestor' | 'ancestor-or-self' | 'descendant' | 'descendant-or-self';
	 * name = {@link XmlSimpleTypes.XmlNCName#NCNAME_PATTERN_STRING};
	 * namespace = (An URI (like xs:anyURI) with % replaced by '%25' and / replaced by '%2F")
	 * namespaceIdentifier = name;
	 * </pre>
	 * 
	 * <p>Semantic:</p>
	 * <ul>
	 * <li>All elements specified by idPath or normalPath will be returned. If several normalPathes exist, the union of those is returned.</li>
	 * <li>A idPath will return the element with the specified id if it exists. otherwise an exception will be thrown</li>
	 * <li>A normalPath will be evaluated node by node relatively to the root node. For each node, elements are first selected using the identifier and then restricted using the predicate. If no identifier is specified, all child elements of the current element will be selected. This is done for all elements resulting from the evaluation of the previous node({@code parent} for the first node). The result of the evaluation of the last node will be added to the result set</li>
	 * <li>The identifiers '.' and ''(empty identifier) refer to the current node itself. The identifier '..' refers to the parent of the current node. If none exists, an exception will be thrown.</li>
	 * <li>Identifiers starting with '::' refer to axes. 'ancestor' selects all ancestors, 'descendant' all descendants(Also attributes) of the current element. Same goes for 'ancestor-or-self' and 'descendant-or-self', but for those, the current element is selected also.</li>
	 * <li>Identifiers starting with '@' refer to attributes, all other identifiers not yet mentioned refer to the children of the current element(And also the empty identifier does, if a predicate was specified). '*' selects all children/attributes.</li>
	 * <li>If the identifier is a QName, elements will be selected by their qualifiedName.(The value of qualifiedName for children and the value of resolveAttributeName(attr) for attributes)</li>
	 * <li>Predicates, that are numbers, select the x element of the selected elements(index starting at 0), where x is the number specified by the predicate. If no such element exists, an exception is thrown.</li>
	 * <li>Otherwise the predicate consists of a set of name and value; if name starts with ':', then it must be either ':name' or ':type'</li>
	 * <li>If the name of the predicate is ':name' elements are selected by their name the same way as if the value would be a qname identifier. If the name of the predicate is ':type' the elements are selected by their type, which is retrieved from the corresponding type-mappings of the current element.</li>
	 * <li>Otherwise, name is interpreted as the name of a key and value is interpreted as the value of that key. In this case, only the element will be selected, that belongs to the value under the key using the {@link #getElementByKey(String keyName, String keyValue)} of the current element.
	 * </ul>
	 * 
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path, that specifies which elements should be fetched
	 * @param parentClass The class used to evaluate the type of children of {@code parent}
	 * @return The elements fetched
	 * @throws InterruptedException if {@code file.loader.execService != null} and {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} throws an InterruptedException.
	 * @throws ExecutionException if {@code file.loader.execService != null} and {@link #getElementsByPathParallel(XmlComplexType parent, String path, Class parentClass, ExecutorService execService)} throws an ExecutionException.
	 */
	public static XmlType[] getElementsByPath(XmlComplexType parent, String path, Class<? extends XmlComplexType> parentClass) throws InterruptedException, ExecutionException {
		if(parent.file.loader.execService != null){
			return getElementsByPathParallel(parent, path, parentClass, parent.file.loader.execService);
		}
		
		List<XmlType> retList = new ArrayList<XmlType>();
		String[] pathes = path.split("\\|");
		for(int k=0;k<pathes.length;++k){
			retList.addAll(getElementsByPathSinglePath(parent, pathes[k], parentClass));
		}
		Set<XmlType> allreadySeen = new HashSet<XmlType>();
		Iterator<XmlType> iter = retList.iterator();
		while(iter.hasNext()){
			XmlType element = iter.next();
			if(!allreadySeen.contains(element)){
				allreadySeen.add(element);
			}else{
				iter.remove();
			}
		}
		return retList.toArray(new XmlType[0]);
	}
	
	/**
	 * <p>Evaluates the path specified by {@code path} relatively to {@code parent} and returns the resulting elements.</p>
	 * 
	 * <p>The process might be parallelized using {@code execService}.</p>
	 * 
	 * {@code path} must follow the following Syntax:
	 * <pre>
	 * path = idPath | (normalPath ( '|' normalPath)*);
	 * idPath = '#' id;
	 * normalPath = (node '/')* node?;
	 * id = {@link XmlSimpleTypes.XmlID#ID_PATTERN_STRING};
	 * node = identifier | (identifier?predicate);
	 * identifier = '@'? ( '*' | qname) | '.'{0,2} | '::' axisName;
	 * predicate = '[' ( [0-9]+ | ':'? [^ ']' ]+ \\s* '=' \\s* [^ ']' ]+ ) ']';
	 * qname = name | namespace | '{' \\s* namespace \\s* ',' \\s* name \\s* '}' | namespaceIdentifier ':' ( '*' | name);
	 * axisName = 'ancestor' | 'ancestor-or-self' | 'descendant' | 'descendant-or-self';
	 * name = {@link XmlSimpleTypes.XmlNCName#NCNAME_PATTERN_STRING};
	 * namespace = (An URI (like xs:anyURI) with % replaced by '%25' and / replaced by '%2F")
	 * namespaceIdentifier = name;
	 * </pre>
	 * 
	 * <p>Semantic:</p>
	 * <ul>
	 * <li>All elements specified by idPath or normalPath will be returned. If several normalPathes exist, the union of those is returned.</li>
	 * <li>A idPath will return the element with the specified id if it exists. otherwise an exception will be thrown</li>
	 * <li>A normalPath will be evaluated node by node relatively to the root node. For each node, elements are first selected using the identifier and then restricted using the predicate. If no identifier is specified, all child elements of the current element will be selected. This is done for all elements resulting from the evaluation of the previous node({@code parent} for the first node). The result of the evaluation of the last node will be added to the result set</li>
	 * <li>The identifiers '.' and ''(empty identifier) refer to the current node itself. The identifier '..' refers to the parent of the current node. If none exists, an exception will be thrown.</li>
	 * <li>Identifiers starting with '::' refer to axes. 'ancestor' selects all ancestors, 'descendant' all descendants(Also attributes) of the current element. Same goes for 'ancestor-or-self' and 'descendant-or-self', but for those, the current element is selected also.</li>
	 * <li>Identifiers starting with '@' refer to attributes, all other identifiers not yet mentioned refer to the children of the current element(And also the empty identifier does, if a predicate was specified). '*' selects all children/attributes.</li>
	 * <li>If the identifier is a QName, elements will be selected by their qualifiedName.(The value of qualifiedName for children and the value of resolveAttributeName(attr) for attributes)</li>
	 * <li>Predicates, that are numbers, select the x element of the selected elements(index starting at 0), where x is the number specified by the predicate. If no such element exists, an exception is thrown.</li>
	 * <li>Otherwise the predicate consists of a set of name and value; if name starts with ':', then it must be either ':name' or ':type'</li>
	 * <li>If the name of the predicate is ':name' elements are selected by their name the same way as if the value would be a qname identifier. If the name of the predicate is ':type' the elements are selected by their type, which is retrieved from the corresponding type-mappings of the current element.</li>
	 * <li>Otherwise, name is interpreted as the name of a key and value is interpreted as the value of that key. In this case, only the element will be selected, that belongs to the value under the key using the {@link #getElementByKey(String keyName, String keyValue)} of the current element.
	 * </ul>
	 * 
	 * 
	 * @param parent The parent, relative to which the path should be evaluated
	 * @param path The path, that specifies which elements should be fetched
	 * @param parentClass The class used to evaluate the type of children of {@code parent}
	 * @return The elements fetched
	 * @param execService The execService used for parallelization.
	 * @throws InterruptedException if an InterruptedException was thrown in parallelization context
	 * @throws ExecutionException if an ExecutionException was thrown in parallelization context 
	 */
	public static XmlType[] getElementsByPathParallel(XmlComplexType parent, String path, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		List<XmlType> retList = new ArrayList<XmlType>();
		
		String[] pathes = path.split("\\|");
		AtomicInteger index = new AtomicInteger();
		ArrayList<Future<List<XmlType>>> futures =  new ArrayList<Future<List<XmlType>>>(pathes.length);
		for(int k=0;k<pathes.length;++k){
			futures.add(execService.submit(new Callable<List<XmlType>>() {
				@Override
				public List<XmlType> call() throws InterruptedException, ExecutionException {
					return getElementsByPathSinglePathParallel(parent, pathes[index.getAndIncrement()], parentClass, execService);
				}
			}));
		}
		for(Future<List<XmlType>> future: futures) {
			retList.addAll(future.get());
		}
		Set<XmlType> allreadySeen = new HashSet<XmlType>();
		Iterator<XmlType> iter = retList.iterator();
		while(iter.hasNext()){
			XmlType element = iter.next();
			if(!allreadySeen.contains(element)){
				allreadySeen.add(element);
			}else{
				iter.remove();
			}
		}
		return retList.toArray(new XmlType[0]);
	}
	
	private static List<XmlType> getElementsByPathSinglePath(XmlComplexType parent, String path, Class<? extends XmlComplexType> parentClass) {
		final String namePatternString = XmlNCName.NCNAME_PATTERN_STRING;
		final String idPatternString = XmlID.ID_PATTERN_STRING;
		final String namespaceIdentifierPatternString = namePatternString;
		final String uriPatternString = "(?:(?:[a-zA-Z][0-9a-zA-Z+\\\\-\\\\.]*:)?%2F{0,2}(?:%2F|[0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%])+)?(?:#(?:%2F|[0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%])+)?";
		final String namespacePatternString = uriPatternString;
		final String qNamePatternString ="(?:"+namePatternString+"|"+namespacePatternString+"|\\{\\s*"+namespacePatternString+"\\s*,\\s*"+namePatternString+"\\s*\\}|"+namespaceIdentifierPatternString+":(?:\\*|"+namePatternString+"))";
		final String predicatePatternString = "(?:\\[(?:\\d+|[:]?[^\\]]+\\s*=\\s*[^\\]]+)\\])";
		final String axisNamePatternString = "(?:ancestor|ancestor-or-self|descendant|descendant-or-self)";
		final String identifierPatternString = "(?:(?:@?(?:\\*|"+qNamePatternString+"))|[\\.]{0,2}|\\:\\:"+axisNamePatternString+")";
		//final String axisPatternString = "(?:\\:\\:"+axisNamePatternString+")";
		final String nodePatternString = "("+identifierPatternString+")|("+identifierPatternString+")?("+predicatePatternString+")";
		//final String idPathPatternString = "(?:#"+idPatternString+")";
		final Pattern pathPattern = Pattern.compile("(?<=\\A|(?<=/))("+nodePatternString+")(?:/+|\\z)");
		final Pattern idPathPattern = Pattern.compile("(?:#("+idPatternString+"))");
		
		Matcher idPathMatcher = idPathPattern.matcher(path);
		if(idPathMatcher.matches()){
			List<XmlType> tmp = new ArrayList<XmlType>();
			tmp.add(parent.file.getElementById(idPathMatcher.group(1)));
			return tmp;
		}
		List<String> nodesList = new ArrayList<String>();
		Matcher pathMatcher = pathPattern.matcher(path);
		while(pathMatcher.find()){
			nodesList.add(pathMatcher.group(1));
		}
		String[] nodes = nodesList.toArray(new String[0]);
		Queue<XmlType> rootQueue = new ArrayDeque<XmlType>();
		rootQueue.add(parent);
		
		if(nodes.length == 0 && !"".equals(path)){
			throw new IllegalArgumentException("Given path wass invalid: "+path);
		}
		
		for(int i=0;i<nodes.length;++i){
			Queue<XmlType> nextRootQueue = new ArrayDeque<XmlType>();
			Set<XmlType> allreadySeen = new HashSet<XmlType>();
			while(rootQueue.size() > 0){
				XmlType currentElement = rootQueue.poll();
				if(!allreadySeen.contains(currentElement)){
					allreadySeen.add(currentElement);
					Class<? extends XmlType> currentRootClass;
					if(parent.equals(currentElement)){
						currentRootClass = parentClass;
					}else{
						currentRootClass = currentElement.getClass();
					}
					nextRootQueue.addAll(getElementsByPathSingleElement(parent, parentClass, nodes[i], currentElement, currentRootClass));
				}
			}
			rootQueue = nextRootQueue;
		}
		return new ArrayList<XmlType>(rootQueue);
	}
	
	private static List<XmlType> getElementsByPathSinglePathParallel(XmlComplexType parent, String path, Class<? extends XmlComplexType> parentClass, ExecutorService execService) throws InterruptedException, ExecutionException {
		final String namePatternString = XmlNCName.NCNAME_PATTERN_STRING;
		final String idPatternString = XmlID.ID_PATTERN_STRING;
		final String namespaceIdentifierPatternString = namePatternString;
		final String uriPatternString = "(?:(?:[a-zA-Z][0-9a-zA-Z+\\\\-\\\\.]*:)?%2F{0,2}(?:%2F|[0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%])+)?(?:#(?:%2F|[0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%])+)?";
		final String namespacePatternString = uriPatternString;
		final String qNamePatternString ="(?:"+namePatternString+"|"+namespacePatternString+"|\\{\\s*"+namespacePatternString+"\\s*,\\s*"+namePatternString+"\\s*\\}|"+namespaceIdentifierPatternString+":(?:\\*|"+namePatternString+"))";
		final String predicatePatternString = "(?:\\[(?:\\d+|[:]?[^\\]]+\\s*=\\s*[^\\]]+)\\])";
		final String axisNamePatternString = "(?:ancestor|ancestor-or-self|descendant|descendant-or-self)";
		final String identifierPatternString = "(?:(?:@?(?:\\*|"+qNamePatternString+"))|[\\.]{0,2}|\\:\\:"+axisNamePatternString+")";
		//final String axisPatternString = "(?:\\:\\:"+axisNamePatternString+")";
		final String nodePatternString = "("+identifierPatternString+")|("+identifierPatternString+")?("+predicatePatternString+")";
		//final String idPathPatternString = "(?:#"+idPatternString+")";
		final Pattern pathPattern = Pattern.compile("(?<=\\A|(?<=/))("+nodePatternString+")(?:/+|\\z)");
		final Pattern idPathPattern = Pattern.compile("(?:#("+idPatternString+"))");
		
		Matcher idPathMatcher = idPathPattern.matcher(path);
		if(idPathMatcher.matches()){
			List<XmlType> tmp = new ArrayList<XmlType>();
			tmp.add(parent.file.getElementById(idPathMatcher.group(1)));
			return tmp;
		}
		List<String> nodesList = new ArrayList<String>();
		Matcher pathMatcher = pathPattern.matcher(path);
		while(pathMatcher.find()){
			nodesList.add(pathMatcher.group(1));
		}
		String[] nodes = nodesList.toArray(new String[0]);
		Queue<XmlType> rootQueue = new ArrayDeque<XmlType>();
		rootQueue.add(parent);
		
		if(nodes.length == 0 && !"".equals(path)){
			throw new IllegalArgumentException("Given path wass invalid: "+path);
		}
		
		for(int i=0;i<nodes.length;++i){
			String node = nodes[i];
			ArrayList<Future<List<XmlType>>> futures =  new ArrayList<Future<List<XmlType>>>(rootQueue.size());
			Queue<XmlType> nextRootQueue = new ArrayDeque<XmlType>();
			Set<XmlType> allreadySeen = new HashSet<XmlType>();
			while(rootQueue.size() > 0){
				XmlType currentElement = rootQueue.poll();
				if(!allreadySeen.contains(currentElement)){
					allreadySeen.add(currentElement);
					Class<? extends XmlType> currentRootClass;
					if(parent.equals(currentElement)){
						currentRootClass = parentClass;
					}else{
						currentRootClass = currentElement.getClass();
					}
					futures.add(execService.submit(new Callable<List<XmlType>>() {
						@Override
						public List<XmlType> call() {
							return getElementsByPathSingleElement(parent, parentClass, node, currentElement, currentRootClass);
						}
					}));
				}
			}
			for(Future<List<XmlType>> future: futures) {
				nextRootQueue.addAll(future.get());
			}
			rootQueue = nextRootQueue;
		}
		return new ArrayList<XmlType>(rootQueue);
	}
	
	private static List<XmlType> getElementsByPathSingleElement(XmlComplexType parent, Class<? extends XmlComplexType> parentClass, String node, XmlType currentElement, Class<? extends XmlType> currentRootClass) {
		final String namePatternString = XmlNCName.NCNAME_PATTERN_STRING;
		final String namespaceIdentifierPatternString = namePatternString;
		final String uriPatternString = "(?:(?:[a-zA-Z][0-9a-zA-Z+\\\\-\\\\.]*:)?%2F{0,2}(?:%2F|[0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%])+)?(?:#(?:%2F|[0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%])+)?";
		final String namespacePatternString = uriPatternString;
		final String qNamePatternString ="(?:"+namePatternString+"|"+namespacePatternString+"|\\{\\s*"+namespacePatternString+"\\s*,\\s*"+namePatternString+"\\s*\\}|"+namespaceIdentifierPatternString+":(?:\\*|"+namePatternString+"))";
		final String predicatePatternString = "(?:\\[(?:\\d+|[:]?[^\\]]+\\s*=\\s*[^\\]]+)\\])";
		final String axisNamePatternString = "(?:ancestor|ancestor-or-self|descendant|descendant-or-self)";
		final String identifierPatternString = "(?:(?:@?(?:\\*|"+qNamePatternString+"))|[\\.]{0,2}|\\:\\:"+axisNamePatternString+")";
		//final String axisPatternString = "(?:\\:\\:"+axisNamePatternString+")";
		final String nodePatternString = "("+identifierPatternString+")|("+identifierPatternString+")?("+predicatePatternString+")";
		final Pattern nodePattern = Pattern.compile(nodePatternString);
		final Pattern qNamePattern = Pattern.compile("(?:("+namePatternString+")|("+namespacePatternString+")|(\\{\\s*"+namespacePatternString+"\\s*,\\s*"+namePatternString+"\\s*\\})|("+namespaceIdentifierPatternString+":(?:\\*|"+namePatternString+")))");
		final Pattern predicatePattern = Pattern.compile("(?:\\[(?:(\\d+)|([:]?[^\\]]+)\\s*=\\s*([^\\]]+))\\])");
		final Pattern axisPattern = Pattern.compile("(?:\\:\\:("+axisNamePatternString+"))");
		
		List<XmlType> retList = new ArrayList<XmlType>();
		
		Matcher nodeMatcher = nodePattern.matcher(node);
		if(nodeMatcher.matches()){
			String identifierString;
			String predicateString;
			if(nodeMatcher.group(1) != null){
				identifierString = nodeMatcher.group(1);
				predicateString = null;
			}else{
				if(nodeMatcher.group(2) != null && !"".equals(nodeMatcher.group(2))){
					identifierString = nodeMatcher.group(2);
				}else{
					identifierString = "*";
				}
				predicateString = nodeMatcher.group(3);
			}

			List<XmlType> selectedElements = new ArrayList<XmlType>();
			switch(identifierString){
			case ""://Intended fallthrough
			case ".":
				selectedElements.add(currentElement);
				break;
			case "..":
				if(currentElement.parent == null){
					throw new IllegalArgumentException("Given path is not valid. Tried to access non-existing parent of: "+currentElement.path);
				}
				selectedElements.add(currentElement.parent);
				break;
			default:
				Matcher axisMatcher = axisPattern.matcher(identifierString);
				if(axisMatcher.matches()){
					switch(axisMatcher.group(1)){
					case "ancestor-or-self"://Intended fallthrough
						selectedElements.add(currentElement);
					case "ancestor":
						XmlType currentParent = currentElement.parent;
						while(currentParent != null){
							selectedElements.add(currentParent);
							currentParent = currentParent.parent;
						}
						break;
					case "descendant-or-self"://Intended fallthrough
						selectedElements.add(currentElement);
					case "descendant":
						Queue<XmlType> descendantQueue = new ArrayDeque<XmlType>();
						descendantQueue.add(currentElement);	
						while(descendantQueue.size() > 0){
							XmlType currentDescendant = descendantQueue.poll();
							Class<? extends XmlType> currentDescendantClass;
							if(parent.equals(currentDescendant)){
								currentDescendantClass = parentClass;
							}else{
								currentDescendantClass = currentDescendant.getClass();
							}		
							if(XmlComplexType.class.isAssignableFrom(currentDescendantClass)){
								if(((XmlComplexType) currentDescendant).children == null){
									@SuppressWarnings("unchecked")//Is checked
									Class<? extends XmlComplexType> complexTypeClass = (Class<? extends XmlComplexType>) currentDescendantClass;
									((XmlComplexType) currentDescendant).loadChildren(true, complexTypeClass);
								}
								for(int j=0;j<((XmlComplexType) currentDescendant).children.length;++j){
									selectedElements.add(((XmlComplexType) currentDescendant).children[j]);
									descendantQueue.add(((XmlComplexType) currentDescendant).children[j]);
								}
								selectedElements.addAll(((XmlComplexType) currentDescendant).attributes.values());
								descendantQueue.addAll(((XmlComplexType) currentDescendant).attributes.values());
							}
						}
						break;
					default:
						throw new AssertionError("Reached unreachable state!");
					}
				}else{
					if(!XmlComplexType.class.isAssignableFrom(currentRootClass)){
						return retList;//Skip elements, when the node cannot be applied on them
					}
					XmlComplexType currentRoot = (XmlComplexType) currentElement;
					List<Map.Entry<XmlQName, XmlType>> selectionMapEntryList = new ArrayList<Map.Entry<XmlQName, XmlType>>();
					if(identifierString.startsWith("@")){
						for(Map.Entry<String, XmlSimpleType> entry : currentRoot.attributes.entrySet()){
							Map.Entry<XmlQName, XmlType> mapEntry = new AbstractMap.SimpleEntry<XmlQName, XmlType>(resolveAttributeQName(entry.getKey(), currentRoot.namespaceMap), entry.getValue());
							selectionMapEntryList.add(mapEntry);
						}
						identifierString = identifierString.substring(1);
						if("".equals(identifierString)){
							identifierString = "*";
						}
					}else{
						if(currentRoot.children == null){
							@SuppressWarnings("unchecked")//Is checked
							Class<? extends XmlComplexType> complexTypeClass = (Class<? extends XmlComplexType>) currentRootClass;
							currentRoot.loadChildren(false, complexTypeClass);
						}
						for(int j=0;j<currentRoot.children.length;++j){
							Map.Entry<XmlQName, XmlType> mapEntry = new AbstractMap.SimpleEntry<XmlQName, XmlType>(currentRoot.children[j].qualifiedName, currentRoot.children[j]);
							selectionMapEntryList.add(mapEntry);
						}
					}
					XmlQName identifierQName = null;
					URI identifierNamespace = null;
					if("*".equals(identifierString)){
						identifierQName = null;
						identifierNamespace = null;
					}else{
						Matcher qNameMatcher = qNamePattern.matcher(identifierString);
						if(qNameMatcher.matches()){
							if(qNameMatcher.group(1) != null){
								identifierQName = new XmlQName(null, qNameMatcher.group(1));
								identifierNamespace = null;
							}else if(qNameMatcher.group(2) != null){
								identifierQName = null;
								try{
									identifierNamespace = new URI(qNameMatcher.group(2).replaceAll("%2F", "/").replaceAll("%25", "%"));
								} catch (URISyntaxException e) {
									throw new IllegalArgumentException("Given URI could not be parsed: "+qNameMatcher.group(2), e);
								}
							}else if(qNameMatcher.group(3) != null){
								identifierQName = XmlQName.parseQName(qNameMatcher.group(3).replaceAll("%2F", "/").replaceAll("%25", "%"));
								identifierNamespace = identifierQName.namespace;
							}else{
								String namePart;
								URI namespace;
								if(qNameMatcher.group(4).contains(":")){
									String[] valueParts = qNameMatcher.group(4).split(":");
									if(valueParts.length != 2){
										throw new IllegalArgumentException("Given value cannot be parsed as QName: "+qNameMatcher.group(4));
									}else{
										namePart = valueParts[1];
										namespace = currentRoot.namespaceMap.get(valueParts[0]);
									}
								}else{
									namePart = qNameMatcher.group(4);
									namespace = currentRoot.namespaceMap.get("");
								}
								if("*".equals(namePart)){
									identifierQName = null;
									identifierNamespace = namespace;
								}else{
									identifierQName = XmlQName.parseQName(qNameMatcher.group(4), currentRoot.namespaceMap);
									identifierNamespace = identifierQName.namespace;
								}
							}
						}else{
							throw new AssertionError("Reached unreachable state!");
						}
					}
					if(identifierQName != null){
						if(identifierQName.namespace == null){
							for(Map.Entry<XmlQName, XmlType> entry : selectionMapEntryList){
								if(identifierQName.name.equals(entry.getKey().name)){
									selectedElements.add(entry.getValue());
								}
							}
						}else{
							for(Map.Entry<XmlQName, XmlType> entry : selectionMapEntryList){
								if(identifierQName.equals(entry.getKey())){
									selectedElements.add(entry.getValue());
								}
							}
						}
					}else if(identifierNamespace != null){
						for(Map.Entry<XmlQName, XmlType> entry : selectionMapEntryList){
							if(identifierNamespace.equals(entry.getKey().namespace)){
								selectedElements.add(entry.getValue());
							}
						}
					}else{
						for(Map.Entry<XmlQName, XmlType> entry : selectionMapEntryList){
							selectedElements.add(entry.getValue());
						}
					}
				}
			}
			if(selectedElements.size() > 0){
				if(predicateString != null){
					Matcher predicateMatcher = predicatePattern.matcher(predicateString);
					if(predicateMatcher.matches()){
						XmlQName typeQName = null;
						URI typeNamespace = null;
						int elementIndex = -1;
						String keyName = null;
						String keyValue = null;
						if(predicateMatcher.group(1) != null){
							elementIndex = Integer.parseInt(predicateMatcher.group(1));
							if(elementIndex < 0){
								throw new IllegalArgumentException("Element index must be positive, but was: "+elementIndex);
							}
						}else{
							keyName = predicateMatcher.group(2);
							keyValue = predicateMatcher.group(3);
							if(":name".equals(keyName) || ":type".equals(keyName)){
								Matcher qNameMatcher = qNamePattern.matcher(keyValue);
								if(qNameMatcher.matches()){
									if(qNameMatcher.group(1) != null){
										typeQName = new XmlQName(null, qNameMatcher.group(1));
										typeNamespace = null;
									}else if(qNameMatcher.group(2) != null){
										typeQName = null;
										try {
											typeNamespace = new URI(qNameMatcher.group(2).replaceAll("%2F", "/").replaceAll("%25", "%"));
										} catch (URISyntaxException e) {
											throw new IllegalArgumentException("Given URI could not be parsed: "+qNameMatcher.group(2), e);
										}
									}else if(qNameMatcher.group(3) != null){
										typeQName = XmlQName.parseQName(qNameMatcher.group(3).replaceAll("%2F", "/").replaceAll("%25", "%"));
										typeNamespace = typeQName.namespace;
									}else{
										typeQName = null;
										typeNamespace = null;
									}
								}else{
									throw new IllegalArgumentException("Given QName was invalid: "+keyValue);
								}
							}
						}
						if(elementIndex >= 0){
							if(elementIndex < selectedElements.size()){
								retList.add(selectedElements.get(elementIndex));
							}else{
								throw new IllegalArgumentException("Element index must be smaller than selected Elements count: "+node);
							}
						}else{
							if(":name".equals(keyName) || ":type".equals(keyName)){
								for(XmlType element : selectedElements){
									XmlQName type = element.qualifiedName;
									if(":type".equals(keyName)){
										if(element.parent != null){
											Field field;
											Map<XmlQName, XmlQName> childrenNameMap;
											try {
												field = element.parent.getClass().getDeclaredField("CHILDREN_NAME_MAP");
												field.setAccessible(true);
												@SuppressWarnings("unchecked")//All Subtypes should override that field.
												Map<XmlQName, XmlQName> tmp = ((Map<XmlQName, XmlQName>) field.get(null));
												childrenNameMap = tmp;
											} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
												throw new AssertionError("Should not reach this state!", e);
											}
											if(XmlComplexType.class.isAssignableFrom(element.getClass())){
												XmlQName typeTmp = childrenNameMap.get(element.qualifiedName);
												if(typeTmp != null){
													type = typeTmp;
												}
											}
										}
									}
									if(typeQName != null){
										if(typeQName.namespace == null){
											if(typeQName.name.equals(type.name)){
												retList.add(element);
											}
										}else{
											if(typeQName.isSupertypeOf(type)){
												retList.add(element);
											}
										}
									}else if(typeNamespace != null){
										if(typeNamespace.equals(type.namespace)){
											retList.add(element);
										}
									}else {
										XmlType currentParent = element;
										while(!XmlComplexType.class.isAssignableFrom(currentParent.getClass()) && currentParent != null){
											currentParent = currentParent.parent;
										}
										Map<String, URI> namespaceMap;
										if(currentParent != null){
											namespaceMap = ((XmlComplexType) currentParent).namespaceMap;
										}else{
											namespaceMap = XmlFile.DEFAULT_NAMESPACE_MAP;
										}

										String namePart;
										URI namespace;
										if(keyValue.contains(":")){
											String[] valueParts = keyValue.split(":");
											if(valueParts.length != 2){
												throw new IllegalArgumentException("Given value cannot be parsed as QName: "+keyValue);
											}else{
												namePart = valueParts[1];
												namespace = namespaceMap.get(valueParts[0]);
											}
										}else{
											namePart = keyValue;
											namespace = namespaceMap.get("");
										}
										if("*".equals(namePart)){
											typeNamespace = namespace;
											if(typeNamespace.equals(type.namespace)){
												retList.add(element);
											}
										}else{
											typeQName = XmlQName.parseQName(keyValue, namespaceMap);
											if(typeQName.isSupertypeOf(type)){
												retList.add(element);
											}
										}
									}
								}
							}else{
								if(XmlComplexType.class.isAssignableFrom(currentRootClass)){
									retList.add(((XmlComplexType) currentElement).getElementByKey(keyName, keyValue));
								}else{
									throw new IllegalArgumentException("Cannot fetch key from simple type: "+node);
								}
							}
						}
					}else{
						throw new AssertionError("Reached unreachable state!");
					}
				}else{
					retList.addAll(selectedElements);
				}
			}
		}else{
			throw new IllegalArgumentException("Could not evaluate node of path: "+node);
		}
		return retList;
	}
	
	/**
	 * @return A tree, representing this elements descendants
	 */
	public String getInnerElementTreeAsString(){
		if(children == null){
			return "...";
		}
		StringBuilder out = new StringBuilder();
		Stack<XmlType> stack = new Stack<XmlType>();
		Stack<Boolean> isEndtags = new Stack<Boolean>();
		List<XmlType> childrenList = Arrays.asList(this.children);
		Collections.reverse(childrenList);
		stack.addAll(childrenList);
		isEndtags.add(Boolean.FALSE);
		XmlType current;
		boolean isEndtag;
		while(stack.size() > 0){
			current = stack.pop();
			isEndtag = isEndtags.pop().booleanValue();
			if(XmlComplexType.class.isAssignableFrom(current.getClass())){
				if(isEndtag){
					out.append(((XmlComplexType) current).endTagAsString());
				}else{
					if(((XmlComplexType) current).children == null){
						out.append(((XmlComplexType) current).startTagAsString());
						out.append("...");
						out.append(((XmlComplexType) current).endTagAsString());
					}else if(((XmlComplexType) current).children.length == 0){
							out.append(((XmlComplexType) current).startEndTagAsString());
					}else{
						stack.push(current);
						isEndtags.push(Boolean.TRUE);
						childrenList = Arrays.asList(((XmlComplexType) current).children);
						Collections.reverse(childrenList);
						stack.addAll(childrenList);
						for(int i=0;i<((XmlComplexType) current).children.length;++i){
							isEndtags.push(Boolean.FALSE);
						}
						out.append(((XmlComplexType) current).startTagAsString());
					}
				}
			}else{
				out.append(current.toString());
			}
		}
		return out.toString();
	}
	
	/**
	 * @return A tree, representing this element and its descendants
	 */
	public String getElementTreeAsString(){
		StringBuilder out = new StringBuilder();
		Stack<XmlType> stack = new Stack<XmlType>();
		Stack<Boolean> isEndtags = new Stack<Boolean>();
		stack.add(this);
		isEndtags.add(Boolean.FALSE);
		XmlType current;
		boolean isEndtag;
		while(stack.size() > 0){
			current = stack.pop();
			isEndtag = isEndtags.pop().booleanValue();
			if(XmlComplexType.class.isAssignableFrom(current.getClass())){
				if(isEndtag){
					out.append(((XmlComplexType) current).endTagAsString());
				}else{
					if(((XmlComplexType) current).children == null){
						out.append(((XmlComplexType) current).startTagAsString());
						out.append("...");
						out.append(((XmlComplexType) current).endTagAsString());
					}else if(((XmlComplexType) current).children.length == 0){
						out.append(((XmlComplexType) current).startEndTagAsString());
					}else{
						stack.push(current);
						isEndtags.push(Boolean.TRUE);
						List<XmlType> childrenList = Arrays.asList(((XmlComplexType) current).children);
						Collections.reverse(childrenList);
						stack.addAll(childrenList);
						for(int i=0;i<((XmlComplexType) current).children.length;++i){
							isEndtags.push(Boolean.FALSE);
						}
						out.append(((XmlComplexType) current).startTagAsString());
					}
				}
			}else{
				out.append(current.toString());
			}
		}
		return out.toString();
	}
	
	/**
	 * Prints a tree, representing this element and its descendants
	 */
	public void printElementTree() {
		Stack<XmlType> stack = new Stack<XmlType>();
		Stack<Boolean> isEndtags = new Stack<Boolean>();
		stack.add(this);
		isEndtags.add(Boolean.FALSE);
		XmlType current;
		boolean isEndtag;
		int depth = 0;
		while(stack.size() > 0){
			current = stack.pop();
			isEndtag = isEndtags.pop().booleanValue();
			if(XmlComplexType.class.isAssignableFrom(current.getClass())){
				if(isEndtag){
					depth--;
					System.out.println("\t".repeat(depth)+((XmlComplexType) current).endTagAsString());
				}else{
					if(((XmlComplexType) current).children == null){
						System.out.println("\t".repeat(depth)+((XmlComplexType) current).startTagAsString());
						System.out.println("\t".repeat(depth)+"...");
						System.out.println("\t".repeat(depth)+((XmlComplexType) current).endTagAsString());
					}else if(((XmlComplexType) current).children.length == 0){
						System.out.println("\t".repeat(depth)+((XmlComplexType) current).startEndTagAsString());
					}else{
						stack.push(current);
						isEndtags.push(Boolean.TRUE);
						List<XmlType> childrenList = Arrays.asList(((XmlComplexType) current).children);
						Collections.reverse(childrenList);
						stack.addAll(childrenList);
						for(int i=0;i<((XmlComplexType) current).children.length;++i){
							isEndtags.push(Boolean.FALSE);
						}
						System.out.println("\t".repeat(depth)+((XmlComplexType) current).startTagAsString());
						depth++;
					}
				}
			}else{
				System.out.println("\t".repeat(depth)+current.toString().trim().replaceAll("(\r(?!\\n)|(?<!\r)\n|\r\n)[ \t]*(?=[^ \t]|\\z)", "\r\n"+"\t".repeat(depth)));
			}
		}
	}
	
	/**
	 * @return  the representation of this element as start tag
	 */
	public String startTagAsString(){
		String startBrace, endBrace;
		startBrace="<";
		endBrace=">";
		StringBuilder b = new StringBuilder();
		b.append(startBrace);
		b.append(qualifiedName.name);
		for(Map.Entry<String, XmlSimpleType> entry: attributes.entrySet()) {
			b.append(" ");
			b.append(entry.getKey());
			b.append("=\"");
			b.append(entry.getValue().getValue());
			b.append("\" ");
		}
		b.append(endBrace);
		return b.toString();
	}
	
	/**
	 * @return The representation of this element as startend tag
	 */
	public String startEndTagAsString(){
		String startBrace, endBrace;
		startBrace="<";
		endBrace=">";
		StringBuilder b = new StringBuilder();
		b.append(startBrace);
		b.append(qualifiedName.name);
		for(Map.Entry<String, XmlSimpleType> entry: attributes.entrySet()) {
			b.append(" ");
			b.append(entry.getKey());
			b.append("=\"");
			b.append(entry.getValue().getValue());
			b.append("\" ");
		}
		b.append("/");
		b.append(endBrace);
		return b.toString();
	}
	
	/**
	 * @return The representation of this element as end tag
	 */
	public String endTagAsString(){
		String startBrace, endBrace;
		startBrace="<";
		endBrace=">";
		StringBuilder b = new StringBuilder();
		b.append(startBrace);
		b.append(qualifiedName.name);
		b.append("/");
		b.append(endBrace);
		return b.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return startTagAsString()+endTagAsString();
	}
	
}
