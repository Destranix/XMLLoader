import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.lang.model.SourceVersion;

import com.sun.codemodel.JCatchBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JDocComment;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JForLoop;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JPrimitiveType;
import com.sun.codemodel.JTryBlock;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import com.sun.codemodel.JWhileLoop;

import Util.ArrayBigList;
import Xml.XmlComplexType;
import Xml.XmlFile;
import Xml.XmlLoader;
import Xml.XmlLoaderSchema;
import Xml.XmlSchemaFile;
import Xml.XmlSimpleTypePlaceholder;
import Xml.XmlType;
import Xml.XmlValidationException;
import XmlComplexTypes.XmlAll;
import XmlComplexTypes.XmlAny;
import XmlComplexTypes.XmlAnyAttribute;
import XmlComplexTypes.XmlAssertion;
import XmlComplexTypes.XmlAttribute;
import XmlComplexTypes.XmlAttributeGroupRef;
import XmlComplexTypes.XmlComplexContent;
import XmlComplexTypes.XmlComplexRestriction;
import XmlComplexTypes.XmlExplicitGroup;
import XmlComplexTypes.XmlExtension;
import XmlComplexTypes.XmlFacet;
import XmlComplexTypes.XmlField;
import XmlComplexTypes.XmlGroupRef;
import XmlComplexTypes.XmlImport;
import XmlComplexTypes.XmlInclude;
import XmlComplexTypes.XmlKeybase;
import XmlComplexTypes.XmlKeyref;
import XmlComplexTypes.XmlList;
import XmlComplexTypes.XmlLocalComplexType;
import XmlComplexTypes.XmlLocalElement;
import XmlComplexTypes.XmlLocalSimpleType;
import XmlComplexTypes.XmlNamedAttributeGroup;
import XmlComplexTypes.XmlNamedGroup;
import XmlComplexTypes.XmlOverride;
import XmlComplexTypes.XmlRedefine;
import XmlComplexTypes.XmlRestriction;
import XmlComplexTypes.XmlSchema;
import XmlComplexTypes.XmlSelector;
import XmlComplexTypes.XmlSimpleContent;
import XmlComplexTypes.XmlSimpleExtension;
import XmlComplexTypes.XmlSimpleRestriction;
import XmlComplexTypes.XmlTopLevelAttribute;
import XmlComplexTypes.XmlTopLevelComplexType;
import XmlComplexTypes.XmlTopLevelElement;
import XmlComplexTypes.XmlTopLevelSimpleType;
import XmlComplexTypes.XmlUnion;
import XmlSimpleTypes.XmlAllNNI;
import XmlSimpleTypes.XmlAnyURI;
import XmlSimpleTypes.XmlID;
import XmlSimpleTypes.XmlListQName;
import XmlSimpleTypes.XmlNCName;
import XmlSimpleTypes.XmlNMTOKEN;
import XmlSimpleTypes.XmlNamespaceList;
import XmlSimpleTypes.XmlNonNegativeInteger;
import XmlSimpleTypes.XmlProcessContents;
import XmlSimpleTypes.XmlQName;
import XmlSimpleTypes.XmlString;
import XmlSimpleTypes.XmlToken;

public class XmlLoaderCreator {
	
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
	
	private static final GroupWrapper GROUP_CYCLE_INDICATOR = new GroupWrapper(null, null, null, null, null, null);
	
	private final JCodeModel codeModel = new JCodeModel();
	private final XmlSchema schema;
	private final XmlSchemaFile xmlFile;
	private final XmlLoaderSchema xmlLoader;
	private final URL rootSchemaLocation;
	private final Map<URL, XmlSchema> urlSchemaMap = new HashMap<URL, XmlSchema>();
	private final Map<URL, URL> locationRemap = new HashMap<URL, URL>();//TODO: Add possibility to add Location for Schema Files, Schemas and Folders for parsed Schemas.
	
	private final Map<Xml.XmlQName, String> typeClassNameMap = new HashMap<Xml.XmlQName, String>();
	private final Map<Xml.XmlQName, String> elementClassNameMap = new HashMap<Xml.XmlQName, String>();
	private final Map<Xml.XmlQName, JClass> simpleTypeClassMap = new HashMap<Xml.XmlQName, JClass>();
	private final Map<Xml.XmlQName, JClass> complexTypeClassMap = new HashMap<Xml.XmlQName, JClass>();
	private final Map<Xml.XmlQName, AttributeWrapper> attributeWrapperMap = new HashMap<Xml.XmlQName, AttributeWrapper>();
	private final Map<Xml.XmlQName, AttributeGroupWrapper> attributeGroupWrapperMap = new HashMap<Xml.XmlQName, AttributeGroupWrapper>();
	private final Map<Xml.XmlQName, AttributeGroupWrapper> complexTypeAttributeGroupWrapperMap = new HashMap<Xml.XmlQName, AttributeGroupWrapper>();
	private final Map<Xml.XmlQName, GroupWrapper> complexTypeGroupWrapperMap = new HashMap<Xml.XmlQName, GroupWrapper>();
	private final Map<Xml.XmlQName, ElementWrapper> elementWrapperMap = new HashMap<Xml.XmlQName, ElementWrapper>();
	private final Map<Xml.XmlQName, JDefinedClass> elementClassMap = new HashMap<Xml.XmlQName, JDefinedClass>();
	private final Map<Xml.XmlQName, Set<Xml.XmlQName>> elementSubstitutionGroupMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
	private final Map<Xml.XmlQName, GroupWrapper> groupWrapperMap = new HashMap<Xml.XmlQName, GroupWrapper>();
	private final Map<Xml.XmlQName, Map<String, URI>> typeNamespaceMap = new HashMap<Xml.XmlQName, Map<String, URI>>();
	private final Set<Xml.XmlQName> selfrefferingGroupsSet = new HashSet<Xml.XmlQName>();
	private final Set<Xml.XmlQName> simpleTypeImplemented = new HashSet<Xml.XmlQName>();
	private final Set<Xml.XmlQName> complexTypeImplemented = new HashSet<Xml.XmlQName>();
	private final Set<Xml.XmlQName> attributeImplemented = new HashSet<Xml.XmlQName>();
	private final Set<Xml.XmlQName> elementImplemented = new HashSet<Xml.XmlQName>();
	private final Set<Xml.XmlQName> groupImplemented = new HashSet<Xml.XmlQName>();
	private final Set<Xml.XmlQName> attributeGroupImplemented = new HashSet<Xml.XmlQName>();
	private final Set<Xml.XmlQName> oldTypes = new HashSet<Xml.XmlQName>();
	
	public XmlLoaderCreator(XmlSchema schema) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ParseException, InterruptedException, ExecutionException{
		this(schema, new XmlSchemaFile(schema.file));
	}
	
	private XmlLoaderCreator(XmlSchema schema, XmlSchemaFile xmlFile) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ParseException, InterruptedException, ExecutionException{
		this(schema, xmlFile, xmlFile.getFileURL());
	}
	
	private XmlLoaderCreator(XmlSchema schema, URL schemaLocation) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ParseException, InterruptedException, ExecutionException{
		this(schema, new XmlSchemaFile(schema.file), schemaLocation);
	}
	
	private XmlLoaderCreator(XmlSchema schema, XmlSchemaFile xmlFile, URL schemaLocation) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ParseException, InterruptedException, ExecutionException{
		this.schema = schema;
		this.xmlFile = xmlFile;
		xmlLoader = new XmlLoaderSchema(xmlFile);
		urlSchemaMap.put(schemaLocation, schema);
		rootSchemaLocation = schemaLocation;
		for(Map.Entry<Xml.XmlQName, Class<? extends XmlType>> entry : XmlLoaderSchema.getNameClassMap().entrySet()){
			Xml.XmlQName qualifiedName = entry.getKey();
			Class<? extends XmlType> typeClass = entry.getValue();
			if(typeClass != null){
				typeClassNameMap.put(qualifiedName, typeClass.getSimpleName());
				oldTypes.add(qualifiedName);
				if(Xml.XmlComplexType.class.isAssignableFrom(typeClass)){
					complexTypeClassMap.put(qualifiedName, codeModel.ref(typeClass));
				}else if(Xml.XmlSimpleType.class.isAssignableFrom(typeClass)){
					simpleTypeClassMap.put(qualifiedName, codeModel.ref(typeClass));
				}
			}
		}
	}
	
	public XmlLoaderCreator(File schemaFile) throws IOException, ParseException, URISyntaxException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, ExecutionException, NoSuchFieldException{
		this(loadFile(schemaFile));
	}
	
	public XmlLoaderCreator(URL schemaLocation) throws IOException, ParseException, URISyntaxException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, ExecutionException, NoSuchFieldException{
		this(loadFile(downloadFile(schemaLocation)), schemaLocation);
	}
	
	public void create(File targetDir, Xml.XmlQName rootQualifiedName, String prefix) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, ParseException, InterruptedException, ExecutionException, URISyntaxException, ClassNotFoundException{	
		Set<URI> importedNamespaces = new HashSet<URI>();
		
		/*Overrides form low level implicitly override overrides from deeper level(Due to queue-Ordering and Set.add, which does not override)
		 */
		Map<URL, Xml.XmlComplexType[]> overwrittenComponentsbyLocation = new HashMap<URL, Xml.XmlComplexType[]>();//Also contains redefined
		
		Map<URL, URI> locationNamespaceMap = new HashMap<URL, URI>();
		
		Map<URI, Set<XmlTopLevelSimpleType>> simpleTypes = new HashMap<URI, Set<XmlTopLevelSimpleType>>();
		Map<URI, Set<XmlTopLevelComplexType>> complexTypes = new HashMap<URI, Set<XmlTopLevelComplexType>>();
		Map<URI, Set<XmlNamedGroup>> groups = new HashMap<URI, Set<XmlNamedGroup>>();
		Map<URI, Set<XmlNamedAttributeGroup>> attributeGroups = new HashMap<URI, Set<XmlNamedAttributeGroup>>();
		Map<URI, Set<XmlTopLevelElement>> elements = new HashMap<URI, Set<XmlTopLevelElement>>();
		Map<URI, Set<XmlTopLevelAttribute>> attributes = new HashMap<URI, Set<XmlTopLevelAttribute>>();

		Set<URL> loadedLocations = new HashSet<URL>();
		Set<URI> usedNamespaces = new HashSet<URI>();
		usedNamespaces.add(xml);
		usedNamespaces.add(xs);
		Queue<XmlSchema> schemaQueue = new ArrayDeque<XmlSchema>();
		Queue<URL> schemaLocationQueue = new ArrayDeque<URL>();
		XmlSchema currentSchema;
		URI currentNamespace;
		URL currentLocation;
		schemaQueue.add(this.schema);
		schemaLocationQueue.add(this.rootSchemaLocation);
		while(schemaQueue.size() > 0){
			currentSchema = schemaQueue.poll();
			currentNamespace = ((XmlAnyURI) currentSchema.getAttribute("targetNamespace")).getValue();
			currentLocation = schemaLocationQueue.poll();
			locationNamespaceMap.put(currentLocation, currentNamespace);
			usedNamespaces.add(currentNamespace);
			if(!loadedLocations.contains(currentLocation)){
				
				Xml.XmlComplexType[] currentCompositions = currentSchema.getCompositions();
				for(int i=0;i<currentCompositions.length;++i){
					if(XmlInclude.class.equals(currentCompositions[i].getClass())){
						XmlInclude include = (XmlInclude) currentCompositions[i];
						URI schemaURI = ((XmlAnyURI) include.getAttribute("schemaLocation")).getValue();
						if(!schemaURI.isAbsolute()){
							schemaURI = currentLocation.toURI().resolve(".").resolve(schemaURI);
						}
						URL schemaLocation = schemaURI.toURL();
						if(locationRemap.get(schemaLocation) != null){
							schemaLocation = locationRemap.get(schemaLocation);
						}
						XmlSchema includedSchema = urlSchemaMap.get(schemaLocation);
						if(includedSchema == null){
							includedSchema = loadFile(downloadFile(schemaLocation));
							urlSchemaMap.put(schemaLocation, includedSchema);
						}
						schemaQueue.add(includedSchema);
						schemaLocationQueue.add(schemaLocation);
					}else if(XmlImport.class.equals(currentCompositions[i].getClass())){
						XmlImport importElem = (XmlImport) currentCompositions[i];
						
						XmlAnyURI schemaNamespaceAttr = (XmlAnyURI) importElem.getAttribute("namespace");
						XmlAnyURI schemaLocationAttr = (XmlAnyURI) importElem.getAttribute("schemaLocation");
						if(schemaNamespaceAttr != null || schemaLocationAttr != null){
							URL schemaLocation;
							if(schemaLocationAttr != null){
								URI schemaURI = schemaLocationAttr.getValue();
								if(!schemaURI.isAbsolute()){
									schemaURI = currentLocation.toURI().resolve(".").resolve(schemaURI);
								}
								schemaLocation = schemaURI.toURL();
							}else{
								for(Map.Entry<String, URI> entry : currentSchema.getNamespaceMap().entrySet()){
									if(schemaNamespaceAttr.getValue().equals(entry.getValue())){
										XmlString locationMapping = (XmlString) currentSchema.getAttribute(entry.getKey()+":schemaLocation");
										if(locationMapping == null){
											throw new AssertionError("Could not resolve imported namespace location: "+schemaNamespaceAttr.getValue());
										}else{
											String[] locationsStr = locationMapping.getValue().split("\\s+");
											for(int j=0;j<locationsStr.length;++j){
												if(locationsStr[j].endsWith(".xsd")){
													schemaLocation = new URL(locationsStr[j]);
													break;
												}
											}
											schemaLocation = new URL(locationsStr[locationsStr.length-1]);
										}
										break;
									}
								}
								throw new AssertionError("Could not resolve imported namespace location: "+schemaNamespaceAttr.getValue());
							}
							if(locationRemap.get(schemaLocation) != null){
								schemaLocation = locationRemap.get(schemaLocation);
							}
							
							XmlSchema includedSchema = urlSchemaMap.get(schemaLocation);
							if(includedSchema == null){
								includedSchema = loadFile(downloadFile(schemaLocation));
								urlSchemaMap.put(schemaLocation, includedSchema);
							}
							if(schemaNamespaceAttr != null){
								importedNamespaces.add(schemaNamespaceAttr.getValue());
							}
							schemaQueue.add(includedSchema);//TODO: Only load required Parts.
							schemaLocationQueue.add(schemaLocation);
						}
					}else if(XmlRedefine.class.equals(currentCompositions[i].getClass())){
						XmlRedefine redefine = (XmlRedefine) currentCompositions[i];
						XmlAnyURI schemaLocationAttr = (XmlAnyURI) redefine.getAttribute("schemaLocation");
						URI schemaURI = schemaLocationAttr.getValue();
						if(!schemaURI.isAbsolute()){
							schemaURI = currentLocation.toURI().resolve(".").resolve(schemaURI);
						}
						URL schemaLocation = schemaURI.toURL();
						Xml.XmlComplexType[] redefinedComponents = redefine.getRedefinables();
						if(overwrittenComponentsbyLocation.containsKey(schemaLocation)){
							Xml.XmlComplexType[] oldRedefinable = overwrittenComponentsbyLocation.get(schemaLocation);
							Xml.XmlComplexType[] newRedefinable = new Xml.XmlComplexType[redefinedComponents.length+oldRedefinable.length];
							System.arraycopy(oldRedefinable, 0, newRedefinable, 0, oldRedefinable.length);
							System.arraycopy(redefinedComponents, 0, newRedefinable, oldRedefinable.length, redefinedComponents.length);
							redefinedComponents = newRedefinable;
						}
						overwrittenComponentsbyLocation.put(schemaLocation, redefinedComponents);
					}else if(XmlOverride.class.equals(currentCompositions[i].getClass())){
						XmlOverride override = (XmlOverride) currentCompositions[i];
						XmlAnyURI schemaLocationAttr = (XmlAnyURI) override.getAttribute("schemaLocation");
						URI schemaURI = schemaLocationAttr.getValue();
						if(!schemaURI.isAbsolute()){
							schemaURI = currentLocation.toURI().resolve(".").resolve(schemaURI);
						}
						URL schemaLocation = schemaURI.toURL();
						Xml.XmlComplexType[] overwrittenComponents = override.getSchemaTops();
						if(overwrittenComponentsbyLocation.containsKey(schemaLocation)){
							Xml.XmlComplexType[] oldOverwritten = overwrittenComponentsbyLocation.get(schemaLocation);
							Xml.XmlComplexType[] newOverwritten = new Xml.XmlComplexType[overwrittenComponents.length+oldOverwritten.length];
							System.arraycopy(newOverwritten, 0, newOverwritten, 0, oldOverwritten.length);
							System.arraycopy(overwrittenComponents, 0, newOverwritten, oldOverwritten.length, oldOverwritten.length);
							overwrittenComponents = newOverwritten;
						}
						overwrittenComponentsbyLocation.put(schemaLocation, overwrittenComponents);
					}
				}
				currentCompositions = null;
				
				Xml.XmlComplexType[] currentSchemaTops = currentSchema.getSchemaTops();
				for(int i=0;i<currentSchemaTops.length;++i){
					if(XmlTopLevelSimpleType.class.equals(currentSchemaTops[i].getClass())){
						simpleTypes.putIfAbsent(currentNamespace, new HashSet<XmlTopLevelSimpleType>());
						simpleTypes.get(currentNamespace).add((XmlTopLevelSimpleType) currentSchemaTops[i]);
					}else if(XmlTopLevelComplexType.class.equals(currentSchemaTops[i].getClass())){
						complexTypes.putIfAbsent(currentNamespace, new HashSet<XmlTopLevelComplexType>());
						complexTypes.get(currentNamespace).add((XmlTopLevelComplexType) currentSchemaTops[i]);
					}else if(XmlNamedGroup.class.equals(currentSchemaTops[i].getClass())){
						groups.putIfAbsent(currentNamespace, new HashSet<XmlNamedGroup>());
						groups.get(currentNamespace).add((XmlNamedGroup) currentSchemaTops[i]);
					}else if(XmlNamedAttributeGroup.class.equals(currentSchemaTops[i].getClass())){
						attributeGroups.putIfAbsent(currentNamespace, new HashSet<XmlNamedAttributeGroup>());
						attributeGroups.get(currentNamespace).add((XmlNamedAttributeGroup) currentSchemaTops[i]);
					}else if(XmlTopLevelElement.class.equals(currentSchemaTops[i].getClass())){
						elements.putIfAbsent(currentNamespace, new HashSet<XmlTopLevelElement>());
						elements.get(currentNamespace).add((XmlTopLevelElement) currentSchemaTops[i]);
					}else if(XmlTopLevelAttribute.class.equals(currentSchemaTops[i].getClass())){
						attributes.putIfAbsent(currentNamespace, new HashSet<XmlTopLevelAttribute>());
						attributes.get(currentNamespace).add((XmlTopLevelAttribute) currentSchemaTops[i]);
					}
				}
				currentSchemaTops = null;
				
				loadedLocations.add(currentLocation);
			}
		}
		for(Map.Entry<URL, Xml.XmlComplexType[]> entry : overwrittenComponentsbyLocation.entrySet()){
			Xml.XmlComplexType[] currentSchemaTops = entry.getValue();
			URI namespace = locationNamespaceMap.get(entry.getKey());
			for(int i=0;i<currentSchemaTops.length;++i){
				XmlNCName nameAttr = (XmlNCName) currentSchemaTops[i].getAttribute("name");
				Xml.XmlQName qualifiedName = Xml.XmlQName.parseQName(nameAttr.getValue(), currentSchemaTops[i].getNamespaceMap());
				if(XmlTopLevelSimpleType.class.equals(currentSchemaTops[i].getClass())){
					simpleTypes.putIfAbsent(namespace, new HashSet<XmlTopLevelSimpleType>());
					for(Xml.XmlComplexType element : simpleTypes.get(namespace)){
						XmlNCName elementNameAttr = (XmlNCName) element.getAttribute("name");
						Xml.XmlQName elementQualifiedName = Xml.XmlQName.parseQName(elementNameAttr.getValue(), element.getNamespaceMap());
						if(qualifiedName.equals(elementQualifiedName)){
							simpleTypes.get(namespace).remove(element);
							break;
						}
					}
					simpleTypes.get(namespace).add((XmlTopLevelSimpleType) currentSchemaTops[i]);
				}else if(XmlTopLevelComplexType.class.equals(currentSchemaTops[i].getClass())){
					complexTypes.putIfAbsent(namespace, new HashSet<XmlTopLevelComplexType>());
					for(Xml.XmlComplexType element : complexTypes.get(namespace)){
						XmlNCName elementNameAttr = (XmlNCName) element.getAttribute("name");
						Xml.XmlQName elementQualifiedName = Xml.XmlQName.parseQName(elementNameAttr.getValue(), element.getNamespaceMap());
						if(qualifiedName.equals(elementQualifiedName)){
							complexTypes.get(namespace).remove(element);
							break;
						}
					}
					complexTypes.get(namespace).add((XmlTopLevelComplexType) currentSchemaTops[i]);
				}else if(XmlNamedGroup.class.equals(currentSchemaTops[i].getClass())){
					groups.putIfAbsent(namespace, new HashSet<XmlNamedGroup>());
					for(Xml.XmlComplexType element : groups.get(namespace)){
						XmlNCName elementNameAttr = (XmlNCName) element.getAttribute("name");
						Xml.XmlQName elementQualifiedName = Xml.XmlQName.parseQName(elementNameAttr.getValue(), element.getNamespaceMap());
						if(qualifiedName.equals(elementQualifiedName)){
							groups.get(namespace).remove(element);
							break;
						}
					}
					groups.get(namespace).add((XmlNamedGroup) currentSchemaTops[i]);
				}else if(XmlNamedAttributeGroup.class.equals(currentSchemaTops[i].getClass())){
					attributeGroups.putIfAbsent(namespace, new HashSet<XmlNamedAttributeGroup>());
					for(Xml.XmlComplexType element : attributeGroups.get(namespace)){
						XmlNCName elementNameAttr = (XmlNCName) element.getAttribute("name");
						Xml.XmlQName elementQualifiedName = Xml.XmlQName.parseQName(elementNameAttr.getValue(), element.getNamespaceMap());
						if(qualifiedName.equals(elementQualifiedName)){
							attributeGroups.get(namespace).remove(element);
							break;
						}
					}
					attributeGroups.get(namespace).add((XmlNamedAttributeGroup) currentSchemaTops[i]);
				}else if(XmlTopLevelElement.class.equals(currentSchemaTops[i].getClass())){
					elements.putIfAbsent(namespace, new HashSet<XmlTopLevelElement>());
					for(Xml.XmlComplexType element : elements.get(namespace)){
						XmlNCName elementNameAttr = (XmlNCName) element.getAttribute("name");
						Xml.XmlQName elementQualifiedName = Xml.XmlQName.parseQName(elementNameAttr.getValue(), element.getNamespaceMap());
						if(qualifiedName.equals(elementQualifiedName)){
							elements.get(namespace).remove(element);
							break;
						}
					}
					elements.get(namespace).add((XmlTopLevelElement) currentSchemaTops[i]);
				}else if(XmlTopLevelAttribute.class.equals(currentSchemaTops[i].getClass())){
					attributes.putIfAbsent(namespace, new HashSet<XmlTopLevelAttribute>());
					for(Xml.XmlComplexType element : attributes.get(namespace)){
						XmlNCName elementNameAttr = (XmlNCName) element.getAttribute("name");
						Xml.XmlQName elementQualifiedName = Xml.XmlQName.parseQName(elementNameAttr.getValue(), element.getNamespaceMap());
						if(qualifiedName.equals(elementQualifiedName)){
							attributes.get(namespace).remove(element);
							break;
						}
					}
					attributes.get(namespace).add((XmlTopLevelAttribute) currentSchemaTops[i]);
				}
			}
		}
		overwrittenComponentsbyLocation = null;
		
		//Build Files
		Set<Xml.XmlQName> typeVarietyIsListSet = new HashSet<Xml.XmlQName>();
		Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap = new HashMap<Xml.XmlQName, Xml.XmlQName>();
		Set<Xml.XmlQName> orderedIsPartialSet = new HashSet<Xml.XmlQName>();
		createSimpleTypes(simpleTypes, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
		createAttributes(attributes, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
		createAttributeGroups(attributeGroups, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
		Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap = new HashMap<Xml.XmlQName, XmlLocalComplexType>();
		Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap = new HashMap<Xml.XmlQName, XmlLocalSimpleType>();
		Set<Xml.XmlQName> usedElements = new HashSet<Xml.XmlQName>();
		usedElements.add(rootQualifiedName);
		createElementWrappers(elements, elementComplexTypesMap, elementSimpleTypesMap, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
		createGroups(groups, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
		createComplexTypes(complexTypes, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
		createElementTypes(elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
		typeVarietyIsListSet = null;
		atomicBaseTypeMap = null;
		orderedIsPartialSet = null;
		
		JClass fileClass = createFile(rootQualifiedName, prefix);
		createLoader(usedNamespaces, fileClass, prefix);

		codeModel.build(targetDir, System.out);
	}
	
	private JClass createFile(Xml.XmlQName rootQualifiedName, String prefix){
		JDefinedClass fileClass;
		try {
			fileClass = codeModel.rootPackage()._class(JMod.PUBLIC, prefix+"File");
		} catch (JClassAlreadyExistsException e) {
			throw new AssertionError("Reached unrechable state!", e);
		}

		fileClass._extends(XmlFile.class);
		
		JMethod constructorXmlFileMethod = fileClass.constructor(JMod.PUBLIC);
		constructorXmlFileMethod._throws(FileNotFoundException.class);
		JVar constructorXmlFileMethodFileVar = constructorXmlFileMethod.param(XmlFile.class, "file");
		constructorXmlFileMethod.body().invoke("super").arg(constructorXmlFileMethodFileVar);
		
		JMethod constructorFileMethod = fileClass.constructor(JMod.PUBLIC);
		constructorFileMethod._throws(FileNotFoundException.class);
		JVar constructorFileMethodFileVar = constructorFileMethod.param(File.class, "file");
		constructorFileMethod.body().invoke("super").arg(constructorFileMethodFileVar);

		JMethod constructorFilepathMethod = fileClass.constructor(JMod.PUBLIC);
		constructorFilepathMethod._throws(FileNotFoundException.class);
		JVar constructorFilepathMethodFilepathVar = constructorFilepathMethod.param(String.class, "filepath");
		constructorFilepathMethod.body().invoke("this").arg(JExpr._new(codeModel._ref(File.class)).arg(constructorFilepathMethodFilepathVar));
		
		ElementWrapper rootElementWrapper = elementWrapperMap.get(rootQualifiedName);
		if(rootElementWrapper == null){
			throw new IllegalArgumentException("Could not reolve root with given name: "+rootQualifiedName);
		}
		JClass rootClass = complexTypeClassMap.get(rootElementWrapper.type);
		
		JMethod getRootMethod = fileClass.method(JMod.PUBLIC, rootClass, "getRoot");
		getRootMethod._throws(IOException.class);
		getRootMethod.annotate(Override.class);
		JConditional getRootMethodIf = getRootMethod.body()._if(codeModel.ref(Xml.XmlComplexType.class).dotclass().invoke("equals").arg(((JExpression) JExpr.ref("roots").component(JExpr.lit(0))).invoke("getClass")));
		getRootMethodIf._then().assign(JExpr.ref("roots").component(JExpr.lit(0)), JExpr.cast(codeModel.ref(Xml.XmlComplexType.class), JExpr.ref("loader").invoke("create").arg(JExpr.ref("roots").component(JExpr.lit(0)))));
		getRootMethod.body()._return(JExpr.cast(rootClass, JExpr.ref("roots").component(JExpr.lit(0))));
		
		return fileClass;
	}
	
	private void createLoader(Set<URI> usedNamespaces, JClass fileClass, String prefix){
		JDefinedClass loaderClass;
		try {
			loaderClass = codeModel.rootPackage()._class(JMod.PUBLIC, prefix+"Loader");
		} catch (JClassAlreadyExistsException e) {
			throw new AssertionError("Reached unrechable state!", e);
		}
		
		loaderClass._extends(XmlLoader.class);
		
		JFieldVar nameClassMapVar = loaderClass.field(JMod.PROTECTED | JMod.FINAL | JMod.STATIC, codeModel.ref(Map.class).narrow(codeModel.ref(Xml.XmlQName.class), codeModel.ref(Class.class).narrow(codeModel.ref(XmlType.class).wildcard())), "NAME_CLASS_MAP", JExpr._new(codeModel.ref(HashMap.class).narrow(codeModel.ref(Xml.XmlQName.class), codeModel.ref(Class.class).narrow(codeModel.ref(XmlType.class).wildcard()))));
		JFieldVar supportedURIsVar = loaderClass.field(JMod.PUBLIC | JMod.FINAL | JMod.STATIC, codeModel.ref(Set.class).narrow(URI.class), "SUPPORTED_URIS", JExpr._new(codeModel.ref(HashSet.class).narrow(URI.class)));
		JFieldVar selfrefferingGroupPatternsVar = null;
		if(selfrefferingGroupsSet.size() > 0){
			selfrefferingGroupPatternsVar = loaderClass.field(JMod.PROTECTED | JMod.FINAL | JMod.STATIC, codeModel.ref(Map.class).narrow(codeModel.ref(Xml.XmlQName.class), codeModel.ref(String.class)), "SELFREFFERING_GROUP_PATTERNS", JExpr._new(codeModel.ref(HashMap.class).narrow(codeModel.ref(Xml.XmlQName.class), codeModel.ref(String.class))));	
		}
		
		JTryBlock initURITryBlock = null;
		if(usedNamespaces.size() > 0){
			initURITryBlock = loaderClass.init()._try();
			JCatchBlock catchBlock = initURITryBlock._catch(codeModel.ref(URISyntaxException.class));
			JVar exception = catchBlock.param("e");
			catchBlock.body()._throw(JExpr._new(codeModel.ref(AssertionError.class)).arg("URI not parsable").arg(exception));
		}
		
		Map<URI, JFieldVar> namespaceVarMap = new HashMap<URI, JFieldVar>(usedNamespaces.size());
		long index = 0;
		for(URI namespace : usedNamespaces){
			JFieldVar currentNamespaceVar = loaderClass.field(JMod.PROTECTED | JMod.FINAL | JMod.STATIC, URI.class, "namespaceURI"+index);
			namespaceVarMap.put(namespace, currentNamespaceVar);
			index++;
			initURITryBlock.body().assign(currentNamespaceVar, JExpr._new(codeModel._ref(URI.class)).arg(JExpr.lit(namespace.toString())));
			loaderClass.init().add(supportedURIsVar.invoke("add").arg(currentNamespaceVar));
		}
		
		for(Xml.XmlQName groupName : selfrefferingGroupsSet){
			GroupWrapper groupWrapper = groupWrapperMap.get(groupName);
			loaderClass.init().add(selfrefferingGroupPatternsVar.invoke("put").arg(JExpr._new(codeModel._ref(Xml.XmlQName.class)).arg(namespaceVarMap.get(groupName.namespace)).arg(JExpr.lit(groupName.name))).arg(JExpr.lit(groupWrapper.arrangementPattern)));
		}
		
		for(Map.Entry<Xml.XmlQName, JClass> entry : simpleTypeClassMap.entrySet()){
			Xml.XmlQName qualifiedName = entry.getKey();
			JClass typeClass = entry.getValue();
			loaderClass.init().add(nameClassMapVar.invoke("put").arg(JExpr._new(codeModel._ref(Xml.XmlQName.class)).arg(namespaceVarMap.get(qualifiedName.namespace)).arg(JExpr.lit(qualifiedName.name))).arg(typeClass.dotclass()));
		}
		for(Map.Entry<Xml.XmlQName, JClass> entry : complexTypeClassMap.entrySet()){
			Xml.XmlQName qualifiedName = entry.getKey();
			JClass typeClass = entry.getValue();
			loaderClass.init().add(nameClassMapVar.invoke("put").arg(JExpr._new(codeModel._ref(Xml.XmlQName.class)).arg(namespaceVarMap.get(qualifiedName.namespace)).arg(JExpr.lit(qualifiedName.name))).arg(typeClass.dotclass()));
		}
		//TODO: Add type hierachy and groups
		
		JFieldVar fileVar = loaderClass.field(JMod.PUBLIC | JMod.FINAL, fileClass, "file");
		JDocComment fileVarDoc = fileVar.javadoc();
		fileVarDoc.add("The ");
		fileVarDoc.add(fileClass);
		fileVarDoc.add(" used to create this loader");
		
		JMethod constructorFileMethod = loaderClass.constructor(JMod.PUBLIC);
		constructorFileMethod._throws(FileNotFoundException.class);
		JVar constructorFileMethodFileVar = constructorFileMethod.param(fileClass, "file");
		constructorFileMethod.body().invoke("this").arg(constructorFileMethodFileVar).arg(JExpr._null());
		
		JMethod constructorFileExecServiceMethod = loaderClass.constructor(JMod.PUBLIC);
		constructorFileExecServiceMethod._throws(FileNotFoundException.class);
		JVar constructorFileExecServiceMethodFileVar = constructorFileExecServiceMethod.param(fileClass, "file");
		JVar constructorFileExecServiceMethodExecServiceVar = constructorFileExecServiceMethod.param(ExecutorService.class, "execService");
		constructorFileExecServiceMethod.body().invoke("super").arg(constructorFileExecServiceMethodFileVar).arg(constructorFileExecServiceMethodExecServiceVar).arg(supportedURIsVar).arg(nameClassMapVar).arg((selfrefferingGroupPatternsVar==null?JExpr._null():selfrefferingGroupPatternsVar));
		constructorFileExecServiceMethod.body().assign(JExpr._this().ref(fileVar), constructorFileExecServiceMethodFileVar);
		constructorFileExecServiceMethod.body().invoke("extend").arg(JExpr._new(codeModel._ref(XmlLoaderSchema.class)).arg(JExpr._new(codeModel._ref(XmlSchemaFile.class)).arg(constructorFileExecServiceMethodFileVar)).arg(constructorFileExecServiceMethodExecServiceVar));
		
		JMethod getClassByQualifiedNameMethod = loaderClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.ref(Class.class).narrow(codeModel.ref(XmlType.class).wildcard()), "getClassByQualifiedName");
		JVar getClassByQualifiedNameMethodQualifiedNameVar = getClassByQualifiedNameMethod.param(Xml.XmlQName.class, "qualifiedName");
		getClassByQualifiedNameMethod.body()._return(nameClassMapVar.invoke("get").arg(getClassByQualifiedNameMethodQualifiedNameVar));
		
		JDocComment getClassByQualifiedNameMethodDoc = getClassByQualifiedNameMethod.javadoc();
		getClassByQualifiedNameMethodDoc.add("Returns the Class associated with {@code qualifiedName}.");
		getClassByQualifiedNameMethodDoc.addParam(getClassByQualifiedNameMethodQualifiedNameVar).add("The qualified name, used to retrieve the class.");
		getClassByQualifiedNameMethodDoc.addReturn().add("The class associated with {@code qualifiedName} or null, if none exists.");
		
		JMethod getNameClassMapMethod = loaderClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.ref(Map.class).narrow(codeModel.ref(Xml.XmlQName.class), codeModel.ref(Class.class).narrow(codeModel.ref(XmlType.class).wildcard())), "getNameClassMap");
		getNameClassMapMethod.body()._return(nameClassMapVar);
		
		JDocComment getNameClassMapMethodDoc = getNameClassMapMethod.javadoc();
		getNameClassMapMethodDoc.add("Returns the nameClassMap of this class.");
		getNameClassMapMethodDoc.addReturn().add("The nameClassMap of this class.");
	}
	
	private void createElementWrappers(Map<URI, Set<XmlTopLevelElement>> elements, Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap, Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ParseException, InterruptedException, ExecutionException, URISyntaxException, ClassNotFoundException{
		//TODO: Resolve Name conflicts
		
		Set<Xml.XmlQName> elementWrapperCreated = new HashSet<Xml.XmlQName>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> elementOwnSubstitutionGroupsMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		
		Map<Xml.XmlQName, XmlTopLevelElement> qualifiedNameElementMap = new HashMap<Xml.XmlQName, XmlTopLevelElement>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Map.Entry<URI, Set<XmlTopLevelElement>> entry : elements.entrySet()){
			Set<XmlTopLevelElement> elementsSet = entry.getValue();
			for(XmlTopLevelElement element : elementsSet){
				String name = ((XmlNCName) element.getAttribute("name")).getValue();
				Xml.XmlQName qualifiedName = new Xml.XmlQName(entry.getKey(), name);
				qualifiedNameElementMap.put(qualifiedName, element);
				
				XmlListQName substitutionGroupsAttr = (XmlListQName) element.getAttribute("substitutionGroup");
				if(substitutionGroupsAttr != null){
					for(String substitutionGroup: substitutionGroupsAttr.getValue()){
						Xml.XmlQName substitutionGroupName = Xml.XmlQName.parseQName(substitutionGroup, element.getNamespaceMap());
						parentDependantsMap.putIfAbsent(substitutionGroupName, new HashSet<Xml.XmlQName>());
						parentDependantsMap.get(substitutionGroupName).add(qualifiedName);
					}
				}
				
			}
		}
		Queue<Xml.XmlQName> elementsQueue = new ArrayDeque<Xml.XmlQName>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> dependenciesMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Xml.XmlQName parent : qualifiedNameElementMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				Set<Xml.XmlQName> dependants = entry.getValue();
				if(dependants.contains(parent)){
					dependenciesMap.get(parent).add(entry.getKey());
					isRoot = false;
				}
			}
			if(isRoot){
				elementsQueue.add(parent);
			}
		}
		for(Xml.XmlQName parent : parentDependantsMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				Set<Xml.XmlQName> dependants = entry.getValue();
				if(dependants.contains(parent)){
					dependenciesMap.get(parent).add(entry.getKey());
					isRoot = false;
				}
			}
			if(isRoot){
				elementsQueue.add(parent);
			}
		}

		while(elementsQueue.size() > 0){
			Xml.XmlQName current = elementsQueue.poll();
			boolean allImplemented = true;
			for(Xml.XmlQName dependency : dependenciesMap.get(current)){
				if(!elementWrapperCreated.contains(dependency)){
					allImplemented = false;
					break;
				}
			}
			if(allImplemented && !elementWrapperCreated.contains(current)){
				XmlTopLevelElement element = qualifiedNameElementMap.get(current);
				XmlListQName substitutionGroupsAttr = (XmlListQName) element.getAttribute("substitutionGroup");
				if(substitutionGroupsAttr != null){

					Queue<Xml.XmlQName> substitutionGroupQueue = new ArrayDeque<Xml.XmlQName>();
					for(String substitutionGroup: substitutionGroupsAttr.getValue()){
						substitutionGroupQueue.add(Xml.XmlQName.parseQName(substitutionGroup, element.getNamespaceMap()));
					}
					while(substitutionGroupQueue.size() > 0){
						Xml.XmlQName substitutionGroup = substitutionGroupQueue.poll();
						elementSubstitutionGroupMap.putIfAbsent(substitutionGroup, new HashSet<Xml.XmlQName>());
						elementSubstitutionGroupMap.get(substitutionGroup).add(current);

						elementOwnSubstitutionGroupsMap.putIfAbsent(current, new HashSet<Xml.XmlQName>());
						elementOwnSubstitutionGroupsMap.get(current).add(substitutionGroup);

						Set<Xml.XmlQName> currentSubstitutionGroups = elementOwnSubstitutionGroupsMap.get(substitutionGroup);
						if(currentSubstitutionGroups != null){
							substitutionGroupQueue.addAll(currentSubstitutionGroups);
						}
					}
				}
				createElementWrapper(current, element, element.getSimpleType(), element.getComplexType(), element.getIdentityConstraints(), elementComplexTypesMap, elementSimpleTypesMap, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
				elementWrapperCreated.add(current);
				if(parentDependantsMap.get(current) != null){
					elementsQueue.addAll(parentDependantsMap.get(current));
				}
			}
		}
		for(Xml.XmlQName current : qualifiedNameElementMap.keySet()){
			if(!elementWrapperCreated.contains(current)){
				throw new AssertionError("ElementWrapper has not been created: "+current);
			}
		}
	}
	
	private void createGroups(Map<URI, Set<XmlNamedGroup>> groups, Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap, Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap, Set<Xml.XmlQName> usedElements, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ParseException, InterruptedException, ExecutionException, URISyntaxException, ClassNotFoundException{
		//TODO: Resolve Name conflicts
		
		Map<Xml.XmlQName, XmlNamedGroup> qualifiedNameGroupMap = new HashMap<Xml.XmlQName, XmlNamedGroup>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Map.Entry<URI, Set<XmlNamedGroup>> entry : groups.entrySet()){
			Set<XmlNamedGroup> groupsSet = entry.getValue();
			for(XmlNamedGroup group : groupsSet){
				String name = ((XmlNCName) group.getAttribute("name")).getValue();
				Xml.XmlQName qualifiedName = new Xml.XmlQName(entry.getKey(), name);
				qualifiedNameGroupMap.put(qualifiedName, group);

				XmlExplicitGroup explicitGroup = group.getChoice();
				if(explicitGroup == null){
					explicitGroup = group.getSequence();
				}
				if(explicitGroup != null){
					addExplicitGroupDependants(qualifiedName, explicitGroup, parentDependantsMap);
				}
			}
		}
		//Find Loops and add Dummy to Map used later, so this is recognized.
		for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry: parentDependantsMap.entrySet()){
			Xml.XmlQName parent = entry.getKey();
			Queue<Xml.XmlQName> dependantsQueue = new ArrayDeque<Xml.XmlQName>();
			dependantsQueue.addAll(entry.getValue());
			while(dependantsQueue.size() > 0){
				Xml.XmlQName current = dependantsQueue.poll();
				
				if(parent.equals(current)){
					groupWrapperMap.put(parent, GROUP_CYCLE_INDICATOR);
					selfrefferingGroupsSet.add(parent);
					break;
				}
				
				if(parentDependantsMap.get(current) != null){
					dependantsQueue.addAll(parentDependantsMap.get(current));
				}
			}
		}
		
		Queue<Xml.XmlQName> groupsQueue = new ArrayDeque<Xml.XmlQName>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> dependenciesMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Xml.XmlQName parent : qualifiedNameGroupMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				Set<Xml.XmlQName> dependants = entry.getValue();
				if(dependants.contains(parent)){
					dependenciesMap.get(parent).add(entry.getKey());
					isRoot = false;
				}
			}
			if(isRoot){
				groupsQueue.add(parent);
			}
		}
		for(Xml.XmlQName parent : parentDependantsMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				Set<Xml.XmlQName> dependants = entry.getValue();
				if(dependants.contains(parent)){
					dependenciesMap.get(parent).add(entry.getKey());
					isRoot = false;
				}
			}
			if(isRoot){
				groupsQueue.add(parent);
			}
		}

		while(groupsQueue.size() > 0){
			Xml.XmlQName current = groupsQueue.poll();
			boolean allImplemented = true;
			for(Xml.XmlQName dependency : dependenciesMap.get(current)){
				if(!groupImplemented.contains(dependency)){
					allImplemented = false;
					break;
				}
			}
			if(allImplemented && !groupImplemented.contains(current)){
				XmlNamedGroup group = qualifiedNameGroupMap.get(current);
				if(group == null){
					GroupWrapper predefinedGroupWrapper = predefinedGroupWrapper(current);
					if(predefinedGroupWrapper == null){
						throw new RuntimeException("Could not resolve group name: "+current.toString());
					}else{
						groupImplemented.add(current);
						groupWrapperMap.put(current, predefinedGroupWrapper);
					}
				}else{
					createGroup(current, group, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
				}
				if(parentDependantsMap.get(current) != null){
					groupsQueue.addAll(parentDependantsMap.get(current));
				}
			}
		}
		for(Xml.XmlQName current : qualifiedNameGroupMap.keySet()){
			if(!groupImplemented.contains(current)){
				throw new AssertionError("Group has not been created: "+current);
			}
		}
	}
	
	private void createComplexTypes(Map<URI, Set<XmlTopLevelComplexType>> complexTypes, Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap, Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap, Set<Xml.XmlQName> usedElements, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ParseException, InterruptedException, ExecutionException, URISyntaxException, ClassNotFoundException{
		JPackage complexTypesPackage = codeModel.rootPackage().subPackage("ComplexTypes");
		//TODO: Resolve Name conflicts
		
		Set<Xml.XmlQName> allComplexTypesSet = new HashSet<Xml.XmlQName>();
		allComplexTypesSet.addAll(complexTypeClassMap.keySet());
		for(Map.Entry<URI, Set<XmlTopLevelComplexType>> entry : complexTypes.entrySet()){
			Set<XmlTopLevelComplexType> complexTypesSet = entry.getValue();
			for(XmlTopLevelComplexType complexType : complexTypesSet){
				String name = ((XmlNCName) complexType.getAttribute("name")).getValue();
				Xml.XmlQName qualifiedName = new Xml.XmlQName(entry.getKey(), name);
				allComplexTypesSet.add(qualifiedName);
			}
		}
		
		Map<Xml.XmlQName, XmlTopLevelComplexType> qualifiedNameComplexTypeMap = new HashMap<Xml.XmlQName, XmlTopLevelComplexType>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Map.Entry<URI, Set<XmlTopLevelComplexType>> entry : complexTypes.entrySet()){
			Set<XmlTopLevelComplexType> complexTypesSet = entry.getValue();
			for(XmlTopLevelComplexType complexType : complexTypesSet){
				String name = ((XmlNCName) complexType.getAttribute("name")).getValue();
				Xml.XmlQName qualifiedName = new Xml.XmlQName(entry.getKey(), name);
				qualifiedNameComplexTypeMap.put(qualifiedName, complexType);
				addComplexTypeDependants(qualifiedName, complexType.getComplexTypeModels(), allComplexTypesSet, parentDependantsMap);
			}
		}
		Queue<Xml.XmlQName> complexTypesQueue = new ArrayDeque<Xml.XmlQName>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> dependenciesMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Xml.XmlQName parent : qualifiedNameComplexTypeMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				if(allComplexTypesSet.contains(entry.getKey())){
					Set<Xml.XmlQName> dependants = entry.getValue();
					if(dependants.contains(parent)){
						dependenciesMap.get(parent).add(entry.getKey());
						isRoot = false;
					}
				}
			}
			if(isRoot){
				complexTypesQueue.add(parent);
			}
		}
		for(Xml.XmlQName parent : parentDependantsMap.keySet()){
			if(allComplexTypesSet.contains(parent)){
				boolean isRoot = true;
				dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
				for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
					if(allComplexTypesSet.contains(entry.getKey())){
						Set<Xml.XmlQName> dependants = entry.getValue();
						if(dependants.contains(parent)){
							dependenciesMap.get(parent).add(entry.getKey());
							isRoot = false;
						}
					}
				}
				if(isRoot){
					complexTypesQueue.add(parent);
				}
			}
		}

		while(complexTypesQueue.size() > 0){
			Xml.XmlQName current = complexTypesQueue.poll();
			boolean allImplemented = true;
			for(Xml.XmlQName dependency : dependenciesMap.get(current)){
				if(!dependency.equals(current) && !complexTypeImplemented.contains(dependency)){
					allImplemented = false;
					break;
				}
			}
			if(allImplemented && !complexTypeImplemented.contains(current)){
				XmlTopLevelComplexType complexType = qualifiedNameComplexTypeMap.get(current);
				if(complexType == null){
					Class<? extends XmlType> predefinedComplexTypesClass = XmlLoaderSchema.getClassByQualifiedName(current);
					if(predefinedComplexTypesClass == null || (!Xml.XmlComplexType.class.isAssignableFrom(predefinedComplexTypesClass) && !Xml.XmlSimpleType.class.isAssignableFrom(predefinedComplexTypesClass))){
						throw new RuntimeException("Could not resolve complexType name: "+current.toString());
					}else{
						
						complexTypeImplemented.add(current);
						typeClassNameMap.put(current, predefinedComplexTypesClass.getSimpleName());
						complexTypeClassMap.put(current, codeModel.ref(predefinedComplexTypesClass));
						if(Xml.XmlComplexType.class.isAssignableFrom(predefinedComplexTypesClass)){
							if((new Xml.XmlQName(xml, "anyType").equals(current))){
								ArrayBigList<String> tmp = new ArrayBigList<String>(1);
								tmp.add("##any");
								complexTypeAttributeGroupWrapperMap.put(current, new AttributeGroupWrapper(new AttributeWrapper[0], "lax", tmp));
							}else{
								Field field = predefinedComplexTypesClass.getDeclaredField("ALLOWED_ATTRIBUTES");
								field.setAccessible(true);
								@SuppressWarnings("unchecked")//Is checked
								Set<String> allowedAttributes = ((Set<String>) field.get(null));
								field = predefinedComplexTypesClass.getDeclaredField("ATTRIBUTES_NAME_MAP");
								field.setAccessible(true);
								@SuppressWarnings("unchecked")//Is checked
								Map<String, Xml.XmlQName> attributesNameMap = ((Map<String, Xml.XmlQName>) field.get(null));
								field = predefinedComplexTypesClass.getDeclaredField("ATTRIBUTE_DEFAULT_VALUES");
								field.setAccessible(true);
								@SuppressWarnings("unchecked")//Is checked
								Map<String, String> attributeDefaultValues = ((Map<String, String>) field.get(null));
								field = predefinedComplexTypesClass.getDeclaredField("REQUIRED_ATTRIBUTES");
								field.setAccessible(true);
								@SuppressWarnings("unchecked")//Is checked
								Set<String> requiredAttributes = ((Set<String>) field.get(null));
								field = predefinedComplexTypesClass.getDeclaredField("FORBIDDEN_ATTRIBUTES");
								field.setAccessible(true);
								@SuppressWarnings("unchecked")//Is checked
								Set<String> forbiddenAttributes = ((Set<String>) field.get(null));
								Set<String> specialAllowedAttributes = new HashSet<String>();
								Set<AttributeWrapper> attributes = new HashSet<AttributeWrapper>();
								for(String attr : allowedAttributes){
									if(attr.startsWith("##")){
										specialAllowedAttributes.add(attr);
									}else{
										attributes.add(new AttributeWrapper(
												attr,
												attributesNameMap.get(attr),
												attributeDefaultValues.get(attr),
												(requiredAttributes.contains(attr)?"required":(forbiddenAttributes.contains(attr)?"prohibited":"optional"))
												));
									}
								}
								ArrayBigList<String> anyAttributeNamespace = new ArrayBigList<String>(specialAllowedAttributes);
								complexTypeAttributeGroupWrapperMap.put(current, new AttributeGroupWrapper(attributes.toArray(new AttributeWrapper[0]), "lax", anyAttributeNamespace));
							}
						}
					}
				}else{
					XmlID id = (XmlID) complexType.getAttribute("id");
					String classname;
					if(id != null){
						classname = generateClassname(id.getValue(), complexTypesPackage);
					}else{
						classname = generateClassname(current.name, complexTypesPackage);
					}
					typeClassNameMap.put(current, classname);
					JDefinedClass typeClass = elementClassMap.get(current);
					if(typeClass == null){
						try {
							typeClass = complexTypesPackage._class(JMod.PUBLIC | JMod.FINAL, classname);
						} catch (JClassAlreadyExistsException e) {
							throw new AssertionError("Failed to generate unique Classname: "+classname, e);
						}
					}
					createComplexType(current, complexType, complexType.getComplexTypeModels(), typeClass, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
				}
				if(parentDependantsMap.get(current) != null){
					complexTypesQueue.addAll(parentDependantsMap.get(current));
				}
			}
		}
		for(Xml.XmlQName current : qualifiedNameComplexTypeMap.keySet()){
			if(!complexTypeImplemented.contains(current)){
				throw new AssertionError("ComplexType has not been created: "+current);
			}
		}
	}
	
	private void createElementTypes(Map<Xml.XmlQName, XmlLocalComplexType> complexTypes, Map<Xml.XmlQName, XmlLocalSimpleType> simpleTypes, Set<Xml.XmlQName> usedElements, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, ParseException, InterruptedException, ExecutionException, URISyntaxException, ClassNotFoundException{
		
		//TODO: Resolve Name conflicts
		
		Map<Xml.XmlQName, XmlLocalComplexType> currentComplexTypes = complexTypes;
		Map<Xml.XmlQName, XmlLocalSimpleType> currentSimpleTypes = simpleTypes;
		do{
			for(Map.Entry<Xml.XmlQName, XmlLocalSimpleType> entry : currentSimpleTypes.entrySet()){
				Xml.XmlQName qualifiedName = entry.getKey();
				XmlLocalSimpleType simpleType = entry.getValue();

				if(usedElements.contains(qualifiedName) && !elementImplemented.contains(qualifiedName)){
					JDefinedClass typeClass = elementClassMap.get(qualifiedName);

					createSimpleType(qualifiedName, simpleType, simpleType.getSimpleDerivation(), typeClass, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
					elementImplemented.add(qualifiedName);
				}
			}
			Map<Xml.XmlQName, XmlLocalComplexType> newComplexTypes = new HashMap<Xml.XmlQName, XmlLocalComplexType>();
			Map<Xml.XmlQName, XmlLocalSimpleType> newSimpleTypes = new HashMap<Xml.XmlQName, XmlLocalSimpleType>();
			for(Map.Entry<Xml.XmlQName, XmlLocalComplexType> entry : currentComplexTypes.entrySet()){
				Xml.XmlQName qualifiedName = entry.getKey();
				XmlLocalComplexType complexType = entry.getValue();

				if(usedElements.contains(qualifiedName) && !elementImplemented.contains(qualifiedName)){
					JDefinedClass typeClass = elementClassMap.get(qualifiedName);

					createComplexType(qualifiedName, complexType, complexType.getComplexTypeModels(), typeClass, newComplexTypes, newSimpleTypes, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
					elementImplemented.add(qualifiedName);
				}
			}
			currentComplexTypes = newComplexTypes;
			currentSimpleTypes = newSimpleTypes;
		}while(currentComplexTypes.size() > 0 || currentSimpleTypes.size() > 0);
		
		for(Map.Entry<Xml.XmlQName, ElementWrapper> entry : elementWrapperMap.entrySet()){
			if(usedElements.contains(entry.getKey())){
				JDefinedClass typeClass = elementClassMap.get(entry.getKey());
				ElementWrapper elementWrapper = entry.getValue();
					
				for(int i=0;i<elementWrapper.keyNames.length;++i){
					String keyName = elementWrapper.keyNames[i];
					String keySelector = elementWrapper.keySelectors[i];
					String keyField = elementWrapper.keyFields[i];
					
					String keySelectorPath = xpathToPath(keySelector);
					String keyFieldPath = xpathToPath(keyField);
					
					String reverseKeySelectorPath = reverseSelectorPath(keySelectorPath, entry.getKey());
					
					typeClass.init().add(typeClass.fields().get("KEY_MAPS").invoke("put").arg(JExpr.lit(keyName)).arg(JExpr._new(codeModel.ref(HashMap.class).narrow(String.class, XmlType.class))));
					
					JClass[] selectorElementClasses = getElementClassesByPath(entry.getKey(), keySelectorPath);
					for(int j=0;j<selectorElementClasses.length;++j){
						typeClass.init().invoke("addKeyPaths").arg(selectorElementClasses[j].dotclass()).arg(JExpr.lit(keyName)).arg(JExpr.lit(reverseKeySelectorPath)).arg(JExpr.lit(keyFieldPath));
					}
				}	
			}
		}
	}
	
	private void addComplexTypeDependants(Xml.XmlQName qualifiedName, Xml.XmlComplexType[] complexTypeModels, Set<Xml.XmlQName> complexTypes, Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException{
		if(complexTypeModels.length > 0){
			Xml.XmlComplexType complexTypeModel = complexTypeModels[0];
			Xml.XmlQName baseType = null;
			if(XmlSimpleContent.class.equals(complexTypeModel.getClass())){
				XmlSimpleContent simpleContent = (XmlSimpleContent) complexTypeModel;
	
				XmlSimpleRestriction restriction = simpleContent.getRestriction();
				XmlSimpleExtension extension = simpleContent.getExtension();
	
				if(restriction != null){
					baseType = Xml.XmlQName.parseQName(((XmlQName) restriction.getAttribute("base")).getValue(), simpleContent.getNamespaceMap());
				}else if(extension != null){
					baseType = Xml.XmlQName.parseQName(((XmlQName) extension.getAttribute("base")).getValue(), simpleContent.getNamespaceMap());
				}else{
					throw new AssertionError("Reached unreachable state!");
				}
			}else if(XmlComplexContent.class.equals(complexTypeModel.getClass())){
				XmlComplexContent complexContent = (XmlComplexContent) complexTypeModel;
	
				XmlComplexRestriction restriction = complexContent.getRestriction();
				XmlExtension extension = complexContent.getExtension();
				
				if(restriction != null){
					baseType = Xml.XmlQName.parseQName(((XmlQName) restriction.getAttribute("base")).getValue(), complexContent.getNamespaceMap());
					if(restriction.getTypeDefParticle() != null){
						//addComplexContentDependants(qualifiedName, restriction.getTypeDefParticle(), complexTypes, parentDependantsMap);
					}
				}else if(extension != null){
					baseType = Xml.XmlQName.parseQName(((XmlQName) extension.getAttribute("base")).getValue(), complexContent.getNamespaceMap());
					if(extension.getTypeDefParticle() != null){
						//addComplexContentDependants(qualifiedName, extension.getTypeDefParticle(), complexTypes, parentDependantsMap);
					}
				}else{
					throw new AssertionError("Reached unreachable state!");
				}
			}else{
				for(int i=0;i<complexTypeModels.length;++i){
					if(XmlGroupRef.class.equals(complexTypeModels[i].getClass())){
						baseType = new Xml.XmlQName(xs, "anyType");
						//addComplexContentDependants(qualifiedName, complexTypeModels[i], complexTypes, parentDependantsMap);
						break;
					}else if(XmlAll.class.equals(complexTypeModels[i].getClass())){
						baseType = new Xml.XmlQName(xs, "anyType");
						//addComplexContentDependants(qualifiedName, complexTypeModels[i], complexTypes, parentDependantsMap);
						break;
					}else if(XmlExplicitGroup.class.equals(complexTypeModels[i].getClass())){
						baseType = new Xml.XmlQName(xs, "anyType");
						//addComplexContentDependants(qualifiedName, complexTypeModels[i], complexTypes, parentDependantsMap);
						break;
					}
				}
			}
			if(baseType != null){
				if(complexTypes.contains(baseType)){
					parentDependantsMap.putIfAbsent(baseType, new HashSet<Xml.XmlQName>());
					parentDependantsMap.get(baseType).add(qualifiedName);
				}
			}
		}
	}
	
	private void addComplexContentDependants(Xml.XmlQName qualifiedName, Xml.XmlComplexType typeDefParticle, Set<Xml.XmlQName> complexTypes, Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException{
		if(typeDefParticle != null){
			if(XmlGroupRef.class.equals(typeDefParticle.getClass())){
				XmlGroupRef group = (XmlGroupRef) typeDefParticle;
				
				XmlQName refAttr = (XmlQName) group.getAttribute("ref");
				Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), group.getNamespaceMap());
				
				GroupWrapper localGroupWrapper = groupWrapperMap.get(ref);
				if(!GROUP_CYCLE_INDICATOR.equals(localGroupWrapper)){
					for(int i=0;i<localGroupWrapper.elementTypes.length;++i){
						if(complexTypes.contains(localGroupWrapper.elementTypes[i])){
							parentDependantsMap.putIfAbsent(localGroupWrapper.elementTypes[i], new HashSet<Xml.XmlQName>());
							parentDependantsMap.get(localGroupWrapper.elementTypes[i]).add(qualifiedName);
						}
					}
				}
			}else if(XmlAll.class.equals(typeDefParticle.getClass())){
				XmlAll all = (XmlAll) typeDefParticle;
				
				XmlLocalElement[] elements = all.getElements();
				for(int i=0;i<elements.length;++i){
					XmlLocalElement element = elements[i];
					
					XmlQName refAttr = (XmlQName) element.getAttribute("ref");
					if(refAttr != null){
						Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), element.getNamespaceMap());
						ElementWrapper referencedElementWrapper = elementWrapperMap.get(ref);
						if(referencedElementWrapper == null){
							throw new XmlValidationException("Referenced element name cannot be resolved: "+ref);
						}
						if(complexTypes.contains(referencedElementWrapper.type)){
							parentDependantsMap.putIfAbsent(referencedElementWrapper.type, new HashSet<Xml.XmlQName>());
							parentDependantsMap.get(referencedElementWrapper.type).add(qualifiedName);
						}
					}
					
					XmlQName typeAttr = (XmlQName) element.getAttribute("type");
					if(typeAttr != null){
						Xml.XmlQName elementType = Xml.XmlQName.parseQName(typeAttr.getValue(), element.getNamespaceMap());
						if(complexTypes.contains(elementType)){
							parentDependantsMap.putIfAbsent(elementType, new HashSet<Xml.XmlQName>());
							parentDependantsMap.get(elementType).add(qualifiedName);
						}
					}
				}
			}else if(XmlExplicitGroup.class.equals(typeDefParticle.getClass())){
				XmlExplicitGroup explicitGroup = (XmlExplicitGroup) typeDefParticle;
				addComplexContentExplicitGroupDependants(qualifiedName, explicitGroup, complexTypes, parentDependantsMap);
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}
	}
	
	private void addComplexContentExplicitGroupDependants(Xml.XmlQName qualifiedName, XmlExplicitGroup explicitGroup, Set<Xml.XmlQName> complexTypes, Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException{
		Xml.XmlComplexType[] particles = explicitGroup.getParticles();
		for(int i=0;i<particles.length;++i){
			if(XmlGroupRef.class.equals(particles[i].getClass())){
				XmlGroupRef groupRef = (XmlGroupRef) particles[i];
				
				XmlQName refAttr = (XmlQName) groupRef.getAttribute("ref");
				Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), groupRef.getNamespaceMap());
				
				GroupWrapper localGroupWrapper = groupWrapperMap.get(ref);
				if(!GROUP_CYCLE_INDICATOR.equals(localGroupWrapper)){
					for(int j=0;j<localGroupWrapper.elementTypes.length;++j){
						if(complexTypes.contains(localGroupWrapper.elementTypes[j])){
							parentDependantsMap.putIfAbsent(localGroupWrapper.elementTypes[j], new HashSet<Xml.XmlQName>());
							parentDependantsMap.get(localGroupWrapper.elementTypes[j]).add(qualifiedName);
						}
					}
				}
			}else if(XmlLocalElement.class.equals(particles[i].getClass())){
				XmlLocalElement element = (XmlLocalElement) particles[i];
				
				XmlQName refAttr = (XmlQName) element.getAttribute("ref");
				if(refAttr != null){
					Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), element.getNamespaceMap());
					ElementWrapper referencedElementWrapper = elementWrapperMap.get(ref);
					if(referencedElementWrapper == null){
						throw new XmlValidationException("Referenced element name cannot be resolved: "+ref);
					}
					if(!elementClassMap.containsKey(referencedElementWrapper.type)){
						parentDependantsMap.putIfAbsent(referencedElementWrapper.type, new HashSet<Xml.XmlQName>());
						parentDependantsMap.get(referencedElementWrapper.type).add(qualifiedName);
					}
				}
				
				XmlQName typeAttr = (XmlQName) element.getAttribute("type");
				if(typeAttr != null){
					Xml.XmlQName elementType = Xml.XmlQName.parseQName(typeAttr.getValue(), element.getNamespaceMap());
					if(complexTypes.contains(elementType)){
						parentDependantsMap.putIfAbsent(elementType, new HashSet<Xml.XmlQName>());
						parentDependantsMap.get(elementType).add(qualifiedName);
					}
				}
			}else if(XmlExplicitGroup.class.equals(particles[i].getClass())){
				XmlExplicitGroup localExplicitGroup = (XmlExplicitGroup) particles[i];
				addComplexContentExplicitGroupDependants(qualifiedName, localExplicitGroup, complexTypes, parentDependantsMap);
			}
		}
	}
	
	private void addExplicitGroupDependants(Xml.XmlQName qualifiedName, XmlExplicitGroup explicitGroup, Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException{
		Xml.XmlComplexType[] particles = explicitGroup.getParticles();
		for(int i=0;i<particles.length;++i){
			if(XmlGroupRef.class.equals(particles[i].getClass())){
				XmlGroupRef groupRef = (XmlGroupRef) particles[i];
				
				XmlQName refAttr = (XmlQName) groupRef.getAttribute("ref");
				Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), groupRef.getNamespaceMap());
				parentDependantsMap.putIfAbsent(ref, new HashSet<Xml.XmlQName>());
				parentDependantsMap.get(ref).add(qualifiedName);
			}else if(XmlExplicitGroup.class.equals(particles[i].getClass())){
				XmlExplicitGroup localExplicitGroup = (XmlExplicitGroup) particles[i];
				addExplicitGroupDependants(qualifiedName, localExplicitGroup, parentDependantsMap);
			}
		}
	}
	
	private void createGroup(Xml.XmlQName qualifiedName, XmlNamedGroup group, Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap, Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap, Set<Xml.XmlQName> usedElements, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, URISyntaxException, ParseException, ClassNotFoundException{
		if(!groupImplemented.contains(qualifiedName)){
			
			Set<Xml.XmlQName> elementNames = new HashSet<Xml.XmlQName>();
			Map<Xml.XmlQName, Xml.XmlQName> elementTypes = new HashMap<Xml.XmlQName, Xml.XmlQName>();
			String arrangementPattern = "";
			Map<Xml.XmlQName, BigInteger> minBounds = new HashMap<Xml.XmlQName, BigInteger>();
			Map<Xml.XmlQName, BigInteger> maxBounds = new HashMap<Xml.XmlQName, BigInteger>();
			ArrayBigList<String> anyNamespace = null;
			
			XmlNamedGroup.XmlAll all = group.getAll();
			if(all != null){
				XmlLocalElement[] elements = all.getElements();
				for(int i=0;i<elements.length;++i){
					XmlLocalElement element = elements[i];
					Xml.XmlQName elementName = null;
					Xml.XmlQName elementType = null;
					
					XmlQName refAttr = (XmlQName) element.getAttribute("ref");
					if(refAttr != null){
						Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), element.getNamespaceMap());
						ElementWrapper referencedElementWrapper = elementWrapperMap.get(ref);
						usedElements.add(ref);
						if(referencedElementWrapper == null){
							throw new XmlValidationException("Referenced element name cannot be resolved: "+ref);
						}
						elementName = ref;
						elementType = referencedElementWrapper.type;
					}
					
					XmlNCName nameAttr = (XmlNCName) element.getAttribute("name");
					if(nameAttr != null){
						elementName = new Xml.XmlQName(qualifiedName.namespace, nameAttr.getValue());
					}
					XmlQName typeAttr = (XmlQName) element.getAttribute("type");
					if(typeAttr != null){
						elementType = Xml.XmlQName.parseQName(typeAttr.getValue(), element.getNamespaceMap());
					}
					if(typeAttr == null && refAttr == null){
						if(element.getComplexType() == null && element.getSimpleType() == null){
							elementType = new Xml.XmlQName(xs, "anyType");
						}else{
							if(elementName == null){
								elementType = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/allElement"+i);
							}else{
								elementType = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/"+elementName.name);
							}
						}
					}
					
					if(refAttr == null){
						createElementWrapper(elementType, element, element.getSimpleType(), element.getComplexType(), element.getIdentityConstraints(), elementComplexTypesMap, elementSimpleTypesMap, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
						usedElements.add(elementType);
					}
					
					BigInteger minBound = ((XmlNonNegativeInteger) element.getAttribute("minOccurs")).getValue();
					BigInteger maxBound = ((XmlAllNNI) element.getAttribute("maxOccurs")).getValue();
					
					if(elementName == null){
						elementName = elementType;
					}
					if(!BigInteger.ZERO.equals(maxBound)){
						if(!elementNames.contains(elementName) || elementTypes.get(elementName).equals(elementType)){
							elementNames.add(elementName);
							elementTypes.put(elementName, elementType);
							arrangementPattern+="("+elementName.name+"[ ]+";
							BigInteger currentMinBound = minBounds.get(elementName);
							minBounds.put(elementName, minValue(currentMinBound, minBound));
							BigInteger currentMaxBound = maxBounds.get(elementName);
							maxBounds.put(elementName, maxValue(currentMaxBound, maxBound));
							
							if(refAttr != null){
								Set<Xml.XmlQName> substitutions = elementSubstitutionGroupMap.get(elementName);
								if(substitutions != null){
									for(Xml.XmlQName substitutionName : substitutions){
										ElementWrapper substitutionWrapper = elementWrapperMap.get(substitutionName);
										usedElements.add(substitutionName);
										elementNames.add(substitutionName);
										elementTypes.put(substitutionName, substitutionWrapper.type);
										arrangementPattern+="|"+substitutionName.name+"[ ]+";
										currentMinBound = minBounds.get(substitutionName);
										minBounds.put(elementName, minValue(currentMinBound, minBounds.get(elementName)));
										currentMaxBound = maxBounds.get(substitutionName);
										maxBounds.put(elementName, maxValue(currentMaxBound, maxBounds.get(elementName)));
									}
								}
							}
							if(minBound.equals(maxBound)){
								arrangementPattern += "){"+minBound.toString()+"}";
							}else{
								arrangementPattern += "){"+minBound.toString()+","+(BigInteger.ZERO.compareTo(maxBound) <= 0?maxBound.toString():"")+"}";
							}
						}else{
							throw new XmlValidationException("Group contains elements with same names but different types!");
						}
					}
				}
			}else{
				XmlExplicitGroup explicitGroup = group.getChoice();
				if(explicitGroup == null){
					explicitGroup = group.getSequence();
				}
				if(explicitGroup != null){
					String[] tmp = new String[]{arrangementPattern};
					createExplicitGroup(new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/group"), explicitGroup, elementNames, elementTypes, tmp, minBounds, maxBounds, anyNamespace, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
					arrangementPattern = tmp[0];
				}else{
					throw new AssertionError("Reached unreachable state!");
				}
			}
			
			Xml.XmlQName[] elementNamesArr = elementNames.toArray(new Xml.XmlQName[0]);
			Xml.XmlQName[] elementTypesArr = new Xml.XmlQName[elementNamesArr.length];
			BigInteger[] minBoundsArr = new BigInteger[elementNamesArr.length];
			BigInteger[] maxBoundsArr = new BigInteger[elementNamesArr.length];
			boolean cycle = GROUP_CYCLE_INDICATOR.equals(groupWrapperMap.get(qualifiedName));
			for(int i=0;i<elementNamesArr.length;++i){
				elementTypesArr[i] = elementTypes.get(elementNamesArr[i]);
				minBoundsArr[i] = minBounds.get(elementNamesArr[i]);
				if(cycle){
					maxBoundsArr[i] = new BigInteger("-1");
				}else{
					maxBoundsArr[i] = maxBounds.get(elementNamesArr[i]);
				}
			}
			
			if(cycle){
				if(!Pattern.matches(arrangementPattern.replaceAll("\\<[^<>]*\\>", "something"), "")){
					throw new XmlValidationException("Group, that refers itself, does not allow empty content. This means, it only matches infinite content: "+qualifiedName);
				}
			}
			
			
			groupWrapperMap.put(qualifiedName, new GroupWrapper(
					elementNamesArr,
					elementTypesArr,
					arrangementPattern,
					minBoundsArr,
					maxBoundsArr,
					anyNamespace
					));
			groupImplemented.add(qualifiedName);
		}
	}
	
	private void createExplicitGroup(Xml.XmlQName qualifiedName, XmlExplicitGroup explicitGroup, Set<Xml.XmlQName> elementNames, Map<Xml.XmlQName, Xml.XmlQName> elementTypes,
			String[] arrangementPatternArr, Map<Xml.XmlQName, BigInteger> minBounds, Map<Xml.XmlQName, BigInteger> maxBounds, ArrayBigList<String> anyNamespace, Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap, Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap, Set<Xml.XmlQName> usedElements, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException, InterruptedException, ExecutionException, URISyntaxException, NoSuchFieldException, ParseException, ClassNotFoundException{
		String separator;
		BigInteger groupMinBound = ((XmlNonNegativeInteger) explicitGroup.getAttribute("minOccurs")).getValue();
		BigInteger groupMaxBound = ((XmlAllNNI) explicitGroup.getAttribute("maxOccurs")).getValue();
		Xml.XmlComplexType[] particles = explicitGroup.getParticles();
		if((new Xml.XmlQName(xs, "choice")).equals(explicitGroup.qualifiedName)){
			separator = "|";
			if(particles.length > 1){
				groupMinBound = BigInteger.ZERO;
			}
		}else if((new Xml.XmlQName(xs, "sequence")).equals(explicitGroup.qualifiedName)){
			separator = "";
		}else{
			throw new AssertionError("Reached unreachable state!");
		}
		
		String arrangementPattern = arrangementPatternArr[0];
		
		for(int i=0;i<particles.length;++i){
			if(XmlLocalElement.class.equals(particles[i].getClass())){
				XmlLocalElement element = (XmlLocalElement) particles[i];
				Xml.XmlQName elementName = null;
				Xml.XmlQName elementType = null;

				XmlQName refAttr = (XmlQName) element.getAttribute("ref");
				if(refAttr != null){
					Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), element.getNamespaceMap());
					ElementWrapper referencedElementWrapper = elementWrapperMap.get(ref);
					usedElements.add(ref);
					if(referencedElementWrapper == null){
						throw new XmlValidationException("Referenced element name cannot be resolved: "+ref);
					}
					elementName = ref;
					elementType = referencedElementWrapper.type;
				}

				XmlNCName nameAttr = (XmlNCName) element.getAttribute("name");
				if(nameAttr != null){
					elementName = new Xml.XmlQName(qualifiedName.namespace, nameAttr.getValue());
				}
				XmlQName typeAttr = (XmlQName) element.getAttribute("type");
				if(typeAttr != null){
					elementType = Xml.XmlQName.parseQName(typeAttr.getValue(), element.getNamespaceMap());
				}

				if(typeAttr == null && refAttr == null){
					if(element.getComplexType() == null && element.getSimpleType() == null){
						elementType = new Xml.XmlQName(xs, "anyType");
					}else{
						if(elementName == null){
							elementType = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/element"+i);
						}else{
							elementType = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/"+elementName.name);
						}
					}
				}

				if(refAttr == null){
					createElementWrapper(elementType, element, element.getSimpleType(), element.getComplexType(), element.getIdentityConstraints(), elementComplexTypesMap, elementSimpleTypesMap, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
					usedElements.add(elementType);
				}

				BigInteger minBound = ((XmlNonNegativeInteger) element.getAttribute("minOccurs")).getValue();
				BigInteger maxBound = ((XmlAllNNI) element.getAttribute("maxOccurs")).getValue();

				if(elementName == null){
					elementName = elementType;
				}
				if(!BigInteger.ZERO.equals(maxBound)){
					if(!elementNames.contains(elementName) || elementTypes.get(elementName).equals(elementType)){
						elementNames.add(elementName);
						elementTypes.put(elementName, elementType);
						arrangementPattern+="("+elementName.name+"[ ]+";
						BigInteger currentMinBound = minBounds.get(elementName);
						minBounds.put(elementName, minValue(currentMinBound, minBound));
						BigInteger currentMaxBound = maxBounds.get(elementName);
						maxBounds.put(elementName, maxValue(currentMaxBound, maxBound));
						if(refAttr != null){
							Set<Xml.XmlQName> substitutions = elementSubstitutionGroupMap.get(elementName);
							if(substitutions != null){
								for(Xml.XmlQName substitutionName : substitutions){
									ElementWrapper substitutionWrapper = elementWrapperMap.get(substitutionName);
									usedElements.add(substitutionName);
									elementNames.add(substitutionName);
									elementTypes.put(substitutionName, substitutionWrapper.type);
									arrangementPattern+="|"+substitutionName.name+"[ ]+";
									currentMinBound = minBounds.get(substitutionName);
									minBounds.put(elementName, minValue(currentMinBound, minBounds.get(elementName)));
									currentMaxBound = maxBounds.get(substitutionName);
									maxBounds.put(elementName, maxValue(currentMaxBound, maxBounds.get(elementName)));
								}
							}
						}
						if(minBound.equals(maxBound)){
							arrangementPattern += "){"+minBound.toString()+"}";
						}else{
							arrangementPattern += "){"+minBound.toString()+","+(BigInteger.ZERO.compareTo(maxBound) <= 0?maxBound.toString():"")+"}";
						}
					}else{
						throw new XmlValidationException("Group contains elements with same names but different types!");
					}
				}
			}else if(XmlGroupRef.class.equals(particles[i].getClass())){
				XmlGroupRef groupRef = (XmlGroupRef) particles[i];

				XmlQName refAttr = (XmlQName) groupRef.getAttribute("ref");
				Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), groupRef.getNamespaceMap());

				BigInteger minBound = ((XmlNonNegativeInteger) groupRef.getAttribute("minOccurs")).getValue();
				BigInteger maxBound = ((XmlAllNNI) groupRef.getAttribute("maxOccurs")).getValue();

				/*Check cycle reference. If exists, than maxBound is set to unbounded for All elements. Pattern includes itself->Special marker for that and special Check method.
				 */

				GroupWrapper referencedGroup = groupWrapperMap.get(ref);
				if(GROUP_CYCLE_INDICATOR.equals(referencedGroup)){
					arrangementPattern += "(\\<"+ref+"\\>)";
				}else{
					arrangementPattern += "("+referencedGroup.arrangementPattern+")";
					for(int j=0;j<referencedGroup.elementNames.length;++j){
						if(!elementNames.contains(referencedGroup.elementNames[j]) || elementTypes.get(referencedGroup.elementNames[j]).equals(referencedGroup.elementTypes[j])){
							elementNames.add(referencedGroup.elementNames[j]);
							elementTypes.put(referencedGroup.elementNames[j], referencedGroup.elementTypes[j]);
							BigInteger currentMinBound = minBounds.get(referencedGroup.elementNames[j]);
							minBounds.put(referencedGroup.elementNames[j], minValue(currentMinBound, minBound));
							BigInteger currentMaxBound = maxBounds.get(referencedGroup.elementNames[j]);
							maxBounds.put(referencedGroup.elementNames[j], maxValue(currentMaxBound, maxBound));
						}else{
							throw new XmlValidationException("Group contains elements with same names but different types!");
						}
					}
					if(minBound.equals(maxBound)){
						arrangementPattern += "{"+minBound.toString()+"}";
					}else{
						arrangementPattern += "{"+minBound.toString()+","+(BigInteger.ZERO.compareTo(maxBound) <= 0?maxBound.toString():"")+"}";
					}
				}
			}else if(XmlExplicitGroup.class.equals(particles[i].getClass())){
				XmlExplicitGroup localExplicitGroup = (XmlExplicitGroup) particles[i];
				String[] tmp = new String[]{arrangementPattern};
				createExplicitGroup(new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/group"+i), localExplicitGroup, elementNames, elementTypes, tmp, minBounds, maxBounds, anyNamespace, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
				arrangementPattern = tmp[0];
			}else if(XmlAny.class.equals(particles[i].getClass())){
				XmlAny any = (XmlAny) particles[i];
				
				XmlNamespaceList namespaceAttr = (XmlNamespaceList) any.getAttribute("namespace");
				if(namespaceAttr != null){
					anyNamespace = intersectNamespaces(anyNamespace, namespaceAttr.getValue());
				}
				
				BigInteger minBound = ((XmlNonNegativeInteger) any.getAttribute("minOccurs")).getValue();
				BigInteger maxBound = ((XmlAllNNI) any.getAttribute("maxOccurs")).getValue();
				if(minBound.equals(maxBound)){
					arrangementPattern += "(\\.*){"+minBound.toString()+"}";
				}else{
					arrangementPattern += "(\\.*){"+minBound.toString()+","+(BigInteger.ZERO.compareTo(maxBound) <= 0?maxBound.toString():"")+"}";
				}
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
			if(i != particles.length-1){
				arrangementPattern += separator;
			}
		}
		arrangementPattern = "("+arrangementPattern+")";
		
		for(Xml.XmlQName elementName : elementNames){
			minBounds.put(elementName, groupMinBound.multiply(minBounds.get(elementName)));
			if(BigInteger.ZERO.compareTo(groupMaxBound) > 0 || BigInteger.ZERO.compareTo(maxBounds.get(elementName)) > 0){
				maxBounds.put(elementName, new BigInteger("-1"));
			}else{
				maxBounds.put(elementName, groupMaxBound.multiply(maxBounds.get(elementName)));
			}
		}
		
		if(groupMinBound.equals(groupMaxBound)){
			arrangementPattern += "{"+groupMinBound.toString()+"}";
		}else{
			arrangementPattern += "{"+groupMinBound.toString()+","+(BigInteger.ZERO.compareTo(groupMaxBound) <= 0?groupMaxBound.toString():"")+"}";
		}
		arrangementPatternArr[0] = arrangementPattern;
	}
	
	private void createElementWrapper(Xml.XmlQName qualifiedName, Xml.XmlComplexType element, XmlLocalSimpleType simpleType, XmlLocalComplexType complexType,  Xml.XmlComplexType[] identityConstraints, Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap, Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, ClassNotFoundException, URISyntaxException{
		JPackage simpleTypesPackage = codeModel.rootPackage().subPackage("SimpleTypes");
		JPackage complexTypesPackage = codeModel.rootPackage().subPackage("ComplexTypes");
		
		Xml.XmlQName type;
		XmlQName typeAttr = (XmlQName) element.getAttribute("type");
		if(typeAttr == null){
			type = qualifiedName;
		}else{
			type = Xml.XmlQName.parseQName(typeAttr.getValue(), element.getNamespaceMap());
		}
		if(simpleType != null){
			XmlID id = (XmlID) simpleType.getAttribute("id");
			if(id == null){
				id = (XmlID) simpleType.parent.getAttribute("id");
			}
			String classname;
			if(id != null){
				classname = generateClassname(id.getValue(), simpleTypesPackage);
			}else{
				classname = generateClassname(qualifiedName.name, simpleTypesPackage);
			}
			elementClassNameMap.put(qualifiedName, classname);
			JDefinedClass typeClass;
			try {
				typeClass = simpleTypesPackage._class(classname);
			} catch (JClassAlreadyExistsException e) {
				throw new AssertionError("Failed to generate unique Classname: "+classname, e);
			}
			elementClassMap.put(qualifiedName, typeClass);
			elementSimpleTypesMap.put(qualifiedName, simpleType);
		}else if(complexType != null){
			XmlID id = (XmlID) complexType.getAttribute("id");
			if(id == null){
				id = (XmlID) complexType.parent.getAttribute("id");
			}
			String classname;
			if(id != null){
				classname = generateClassname(id.getValue(), complexTypesPackage);
			}else{
				classname = generateClassname(qualifiedName.name, complexTypesPackage);
			}
			elementClassNameMap.put(qualifiedName, classname);
			JDefinedClass typeClass;
			try {
				typeClass = complexTypesPackage._class(JMod.PUBLIC | JMod.FINAL, classname);
			} catch (JClassAlreadyExistsException e) {
				throw new AssertionError("Failed to generate unique Classname: "+classname, e);
			}
			elementClassMap.put(qualifiedName, typeClass);
			elementComplexTypesMap.put(qualifiedName, complexType);
		}else if(typeAttr != null){
			if(!simpleTypeClassMap.containsKey(type) && !complexTypeClassMap.containsKey(type) && !elementClassMap.containsKey(type)){
				String classname = generateClassname(type.name, complexTypesPackage);
				elementClassNameMap.put(type, classname);
				JDefinedClass typeClass;
				try {
					typeClass = complexTypesPackage._class(JMod.PUBLIC | JMod.FINAL, classname);
				} catch (JClassAlreadyExistsException e) {
					throw new AssertionError("Failed to generate unique Classname: "+classname, e);
				}
				elementClassMap.put(type, typeClass);
			}
		}else{
			/*Note that the above allows for two levels of defaulting for unspecified type definitions. An <element> with no referenced or included type definition will correspond to an element declaration which has the same type definition as the head of its substitution group if it identifies one, otherwise the ·ur-type definition·. This has the important consequence that the minimum valid element declaration, that is, one with only a name attribute and no contents, is also (nearly) the most general, validating any combination of text and element content and allowing any attributes, and providing for recursive validation where possible.
			 */
			type = new Xml.XmlQName(xs, "anyType");
			if(XmlTopLevelElement.class.equals(element.getClass())){
				XmlListQName substitutionGroupsAttr = (XmlListQName) element.getAttribute("substitutionGroup");
				if(substitutionGroupsAttr != null){
					ArrayBigList<String> substitutionGroups = substitutionGroupsAttr.getValue();
					if(substitutionGroups.size().compareTo(BigInteger.ZERO) > 0){
						Xml.XmlQName substitutionGroupName = Xml.XmlQName.parseQName(substitutionGroups.get(0), element.getNamespaceMap());
						ElementWrapper substitutionGroupWrapper = elementWrapperMap.get(substitutionGroupName);
						if(substitutionGroupWrapper != null){
							type = substitutionGroupWrapper.type;
						}else{
							throw new XmlValidationException("Referenced substitutionGroup could not be resolved: "+substitutionGroupName);
						}
					}
				}
			}
		}
		
		Set<String> keyNames = new HashSet<String>();
		Map<String, String> keySelectors = new HashMap<String, String>();
		Map<String, String> keyFields = new HashMap<String, String>();
		for(int i=0;i<identityConstraints.length;++i){
			if(XmlKeybase.class.equals(identityConstraints[i].getClass())){
				XmlKeybase keybase = (XmlKeybase) identityConstraints[i];
				
				XmlNCName nameAttr = (XmlNCName) keybase.getAttribute("name");
				if(nameAttr != null){
					String keyName = nameAttr.getValue();
					keyNames.add(keyName);
					
					XmlSelector selector = keybase.getSelector();
					XmlField[] fields = keybase.getFields();
					if(selector == null || fields == null){
						throw new XmlValidationException("Element of type \"key\" must contain selector and fields!");
					}
					keySelectors.put(keyName, ((XmlToken) selector.getAttribute("xpath")).getValue());
					String keyField = "";
					for(int j=0;j<fields.length;++j){
						keyField += ((XmlToken) fields[j].getAttribute("xpath")).getValue()+"|";
					}
					keyField = keyField.substring(0, keyField.length()-1);
					keyFields.put(keyName, keyField);
				}
			}else if(XmlKeyref.class.equals(identityConstraints[i].getClass())){
				//Nothing
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}
		
		String[] keyNamesArr = keyNames.toArray(new String[0]);
		String[] keySelectorsArr = new String[keyNamesArr.length];
		String[] keyFieldsArr = new String[keyNamesArr.length];
		for(int i=0;i<keyNamesArr.length;++i){
			keySelectorsArr[i] = keySelectors.get(keyNamesArr[i]);
			keyFieldsArr[i] = keyFields.get(keyNamesArr[i]);
		}
		
		elementWrapperMap.put(qualifiedName, new ElementWrapper(type, keyNamesArr, keySelectorsArr, keyFieldsArr));
	}
	
	private void createAttributeGroups(Map<URI, Set<XmlNamedAttributeGroup>> attributeGroups, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException, ClassNotFoundException{
		
		//TODO: Resolve Name conflicts
		
		Map<Xml.XmlQName, XmlNamedAttributeGroup> qualifiedNameAttributeGroupMap = new HashMap<Xml.XmlQName, XmlNamedAttributeGroup>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Map.Entry<URI, Set<XmlNamedAttributeGroup>> entry : attributeGroups.entrySet()){
			Set<XmlNamedAttributeGroup> attributeGroupsSet = entry.getValue();
			for(XmlNamedAttributeGroup attributeGroup : attributeGroupsSet){
				String name = ((XmlNCName) attributeGroup.getAttribute("name")).getValue();
				Xml.XmlQName qualifiedName = new Xml.XmlQName(entry.getKey(), name);
				qualifiedNameAttributeGroupMap.put(qualifiedName, attributeGroup);
				
				Xml.XmlComplexType[] attrDecls = attributeGroup.getAttrDecls();
				for(int i=0;i<attrDecls.length;++i){
					if(XmlAttributeGroupRef.class.equals(attrDecls[i].getClass())){
						XmlAttributeGroupRef localAttributeGroup = (XmlAttributeGroupRef) attrDecls[i];
						
						XmlQName refAttr = (XmlQName) localAttributeGroup.getAttribute("ref");
						Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), localAttributeGroup.getNamespaceMap());
						parentDependantsMap.putIfAbsent(ref, new HashSet<Xml.XmlQName>());
						parentDependantsMap.get(ref).add(qualifiedName);
					}
				}
			}
		}
		Queue<Xml.XmlQName> attributeGroupsQueue = new ArrayDeque<Xml.XmlQName>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> dependenciesMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Xml.XmlQName parent : qualifiedNameAttributeGroupMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				Set<Xml.XmlQName> dependants = entry.getValue();
				if(dependants.contains(parent)){
					dependenciesMap.get(parent).add(entry.getKey());
					isRoot = false;
				}
			}
			if(isRoot){
				attributeGroupsQueue.add(parent);
			}
		}
		for(Xml.XmlQName parent : parentDependantsMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				Set<Xml.XmlQName> dependants = entry.getValue();
				if(dependants.contains(parent)){
					dependenciesMap.get(parent).add(entry.getKey());
					isRoot = false;
				}
			}
			if(isRoot){
				attributeGroupsQueue.add(parent);
			}
		}
		
		while(attributeGroupsQueue.size() > 0){
			Xml.XmlQName current = attributeGroupsQueue.poll();
			boolean allImplemented = true;
			for(Xml.XmlQName dependency : dependenciesMap.get(current)){
				if(!attributeGroupImplemented.contains(dependency)){
					allImplemented = false;
					break;
				}
			}
			if(allImplemented && !attributeGroupImplemented.contains(current)){
				XmlNamedAttributeGroup attributeGroup = qualifiedNameAttributeGroupMap.get(current);
				if(attributeGroup == null){
					AttributeGroupWrapper predefinedAttributeGroupWrapper = predefinedAttributeGroupWrapper(current);
					if(predefinedAttributeGroupWrapper == null){
						throw new RuntimeException("Could not resolve attributeGroup name: "+current.toString());
					}else{
						attributeGroupImplemented.add(current);
						attributeGroupWrapperMap.put(current, predefinedAttributeGroupWrapper);
					}
				}else{
					createAttributeGroup(current, attributeGroup.getAttrDecls(), typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
				}
				if(parentDependantsMap.get(current) != null){
					attributeGroupsQueue.addAll(parentDependantsMap.get(current));
				}
			}
		}
		for(Xml.XmlQName current : qualifiedNameAttributeGroupMap.keySet()){
			if(!attributeGroupImplemented.contains(current)){
				throw new AssertionError("AttributeGroup has not been created: "+current);
			}
		}
	}
	
	private void createAttributeGroup(Xml.XmlQName qualifiedName, Xml.XmlComplexType[] attrDecls, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, URISyntaxException, ParseException, ClassNotFoundException{
		if(!attributeGroupImplemented.contains(qualifiedName)){
			
			//Collect all Attributes, AttributeGroups and AnyAttributes from local and referenced
			Set<AttributeWrapper> attributesSet = new HashSet<AttributeWrapper>();
			String processContents = null;
			ArrayBigList<String> namespace = null;
			
			for(int i=0;i<attrDecls.length;++i){
				if(XmlAttribute.class.equals(attrDecls[i].getClass())){
					XmlAttribute attribute = (XmlAttribute) attrDecls[i];
					
					XmlQName refAttr = (XmlQName) attribute.getAttribute("ref");
					
					AttributeWrapper wrapper;
					if(refAttr == null){
						String name = ((XmlNCName) attribute.getAttribute("name")).getValue();
						Xml.XmlQName attributeQualifiedName = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/attribute"+i);
						createAttribute(attributeQualifiedName, attribute, (XmlQName) attribute.getAttribute("type"), attribute.getSimpleType(), name, (XmlString) attribute.getAttribute("default"), (XmlNMTOKEN) attribute.getAttribute("use"),
								typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
						
						wrapper = attributeWrapperMap.get(attributeQualifiedName);
					}else{
						Xml.XmlQName ref =  Xml.XmlQName.parseQName(refAttr.getValue(), attribute.getNamespaceMap());
						
						AttributeWrapper referencedAttribute = attributeWrapperMap.get(ref);
						if(referencedAttribute == null){
							throw new XmlValidationException("Could not resolve referenced attribute: "+ref.toString());
						}
						wrapper = referencedAttribute;
					}
					attributesSet.add(wrapper);
				}else if(XmlAttributeGroupRef.class.equals(attrDecls[i].getClass())){
					XmlAttributeGroupRef attributeGroupRef = (XmlAttributeGroupRef) attrDecls[i];
					
					Xml.XmlQName ref =  Xml.XmlQName.parseQName(((XmlQName) attributeGroupRef.getAttribute("ref")).getValue(), attributeGroupRef.getNamespaceMap());
					
					AttributeGroupWrapper referencedGroupWrapper = attributeGroupWrapperMap.get(ref);
					attributesSet.addAll(Arrays.asList(referencedGroupWrapper.attributes));
					if(processContents == null){
						processContents = referencedGroupWrapper.anyAttributeProcessContents;
					}
					namespace = intersectNamespaces(namespace, referencedGroupWrapper.anyAttributeNamespace);
				}else if(XmlAnyAttribute.class.equals(attrDecls[i].getClass())){
					XmlAnyAttribute anyAttribute = (XmlAnyAttribute) attrDecls[i];
					
					processContents = ((XmlProcessContents) anyAttribute.getAttribute("processContents")).getValue();
					XmlNamespaceList namespaceAttr = (XmlNamespaceList) anyAttribute.getAttribute("namespace");
					if(namespaceAttr != null){
						namespace = intersectNamespaces(namespace, namespaceAttr.getValue());
					}
				}else{
					throw new AssertionError("Reached unreachable state!");
				}
			}
			
			attributeGroupWrapperMap.put(qualifiedName, new AttributeGroupWrapper(attributesSet.toArray(new AttributeWrapper[0]), processContents, namespace));
			attributeGroupImplemented.add(qualifiedName);
		}
	}
	
	private void createAttributes(Map<URI, Set<XmlTopLevelAttribute>> attributes, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException, ClassNotFoundException{
		
		//TODO: Resolve Name conflicts
		
		for(Map.Entry<URI, Set<XmlTopLevelAttribute>> entry : attributes.entrySet()){
			Set<XmlTopLevelAttribute> attributesSet = entry.getValue();
			for(XmlTopLevelAttribute attribute : attributesSet){
				String name = ((XmlNCName) attribute.getAttribute("name")).getValue();
				Xml.XmlQName qualifiedName = new Xml.XmlQName(entry.getKey(), name);
				createAttribute(qualifiedName, attribute, (XmlQName) attribute.getAttribute("type"), attribute.getSimpleType(), name, (XmlString) attribute.getAttribute("default"), (XmlNMTOKEN) attribute.getAttribute("use"),
						typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
			}
		}
		setPredefinedAttributeWrappers(attributeImplemented, attributeWrapperMap);
		
	}
	
	private void createAttribute(Xml.XmlQName qualifiedName, Xml.XmlComplexType attribute, XmlQName typeAttr, XmlLocalSimpleType simpleType, String name, XmlString defaultValueAttr, XmlNMTOKEN useAttr,
			Set<Xml.XmlQName> typeVarietyIsListSet, Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, ClassNotFoundException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException{
		if(!attributeImplemented.contains(qualifiedName)){
			
			Xml.XmlQName type;
			if(typeAttr == null){
				
				type = new Xml.XmlQName(attribute.qualifiedName.namespace, attribute.qualifiedName.name+"/type");
				JDefinedClass typeClass = codeModel.anonymousClass(Xml.XmlSimpleType.class);
				createSimpleType(type, simpleType, simpleType.getSimpleDerivation(), typeClass, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
			}else{
				type = Xml.XmlQName.parseQName(typeAttr.getValue(), attribute.getNamespaceMap());
				JClass typeClass = simpleTypeClassMap.get(type);
				if(typeClass == null){
					throw new XmlValidationException("Attribute has unknown type!");
				}
			}
			attributeWrapperMap.put(qualifiedName, new AttributeWrapper(name, type, (defaultValueAttr==null?null:defaultValueAttr.getValue()), (useAttr==null?"optional":useAttr.getValue())));
			
			attributeImplemented.add(qualifiedName);
		}
	}
	
	private void createComplexType(Xml.XmlQName qualifiedName, Xml.XmlComplexType complexType, Xml.XmlComplexType[] complexTypeModels, JDefinedClass typeClass, Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap, Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap, Set<Xml.XmlQName> usedElements, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException, ClassNotFoundException{
		if(!complexTypeImplemented.contains(qualifiedName)){
			complexTypeClassMap.put(qualifiedName, typeClass);
			typeNamespaceMap.put(qualifiedName, complexType.getNamespaceMap());

			typeClass._extends(codeModel.ref(Xml.XmlComplexType.class));
			
			JFieldVar allowedChildrenPatternVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, String.class, "ALLOWED_CHILDREN_PATTERN");
			JFieldVar allowedChildrenNamesVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashSet.class).narrow(Xml.XmlQName.class), "ALLOWED_CHILDREN_NAMES", JExpr._new(codeModel.ref(HashSet.class).narrow(Xml.XmlQName.class)));
			JFieldVar childrenNameMapVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashMap.class).narrow(Xml.XmlQName.class, Xml.XmlQName.class), "CHILDREN_NAME_MAP", JExpr._new(codeModel.ref(HashMap.class).narrow(Xml.XmlQName.class, Xml.XmlQName.class)));
			JFieldVar allowedChildrenMinBoundVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashMap.class).narrow(Xml.XmlQName.class, Integer.class), "ALLOWED_CHILDREN_MIN_BOUNDS", JExpr._new(codeModel.ref(HashMap.class).narrow(Xml.XmlQName.class, Integer.class)));
			JFieldVar allowedChildrenMaxBoundVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashMap.class).narrow(Xml.XmlQName.class, Integer.class), "ALLOWED_CHILDREN_MAX_BOUNDS", JExpr._new(codeModel.ref(HashMap.class).narrow(Xml.XmlQName.class, Integer.class)));
			JFieldVar attributeDefaultValuesVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashMap.class).narrow(String.class, String.class), "ATTRIBUTE_DEFAULT_VALUES", JExpr._new(codeModel.ref(HashMap.class).narrow(String.class, String.class)));
			JFieldVar allowedAttributesVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashSet.class).narrow(String.class), "ALLOWED_ATTRIBUTES", JExpr._new(codeModel.ref(HashSet.class).narrow(String.class)));
			JFieldVar requiredAttributesVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashSet.class).narrow(String.class), "REQUIRED_ATTRIBUTES", JExpr._new(codeModel.ref(HashSet.class).narrow(String.class)));
			JFieldVar forbiddenAttributesVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashSet.class).narrow(String.class), "FORBIDDEN_ATTRIBUTES", JExpr._new(codeModel.ref(HashSet.class).narrow(String.class)));
			JFieldVar attributeNameMapVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashMap.class).narrow(String.class, Xml.XmlQName.class), "ATTRIBUTES_NAME_MAP", JExpr._new(codeModel.ref(HashMap.class).narrow(String.class, Xml.XmlQName.class)));
			
			JFieldVar keyMapsVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashMap.class).narrow(codeModel.ref(String.class), codeModel.ref(HashMap.class).narrow(String.class, XmlType.class)), "KEY_MAPS", JExpr._new(codeModel.ref(HashMap.class).narrow(codeModel.ref(String.class), codeModel.ref(HashMap.class).narrow(String.class, XmlType.class))));
			JFieldVar keyOwnerPathMapVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashMap.class).narrow(String.class, String.class), "KEY_OWNER_PATH_MAP", JExpr._new(codeModel.ref(HashMap.class).narrow(String.class, String.class)));
			JFieldVar keyValuePathMapVar = typeClass.field(JMod.PROTECTED | JMod.STATIC | JMod.FINAL, codeModel.ref(HashMap.class).narrow(String.class, String.class), "KEY_VALUE_PATH_MAP", JExpr._new(codeModel.ref(HashMap.class).narrow(String.class, String.class)));
			
			AttributeGroupWrapper newAttributeGroupWrapper;
			GroupWrapper newGroupWrapper = null;
			if(complexTypeModels.length > 0 && XmlSimpleContent.class.equals(complexTypeModels[0].getClass())){
				XmlSimpleContent simpleContent = (XmlSimpleContent) complexTypeModels[0];

				XmlSimpleRestriction restriction = simpleContent.getRestriction();
				XmlSimpleExtension extension = simpleContent.getExtension();

				JType contentValueTypeClass;
				JClass contentValueType;
				if(restriction != null){
					Xml.XmlQName baseType = Xml.XmlQName.parseQName(((XmlQName) restriction.getAttribute("base")).getValue(), complexType.getNamespaceMap());

					Xml.XmlQName attributeGroupQualifiedName = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/attributeGroup");
					createAttributeGroup(attributeGroupQualifiedName, restriction.getAttrDecls(), typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);

					AttributeGroupWrapper localAttributeGroupWrapper = attributeGroupWrapperMap.get(attributeGroupQualifiedName);
					AttributeGroupWrapper baseAttributeGroupWrapper = complexTypeAttributeGroupWrapperMap.get(baseType);


					if(baseAttributeGroupWrapper != null){
						List<AttributeWrapper> localAttributeList = Arrays.asList(localAttributeGroupWrapper.attributes);

						Set<AttributeWrapper> attributesSet = new HashSet<AttributeWrapper>();
						for(int j=0;j<baseAttributeGroupWrapper.attributes.length;++j){
							if("prohibited".equals(baseAttributeGroupWrapper.attributes[j].use)){
								attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
							}else{
								if(!localAttributeList.contains(baseAttributeGroupWrapper.attributes[j])){
									attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
								}
							}
						}
						for(int j=0;j<localAttributeGroupWrapper.attributes.length;++j){
							if(!attributesSet.contains(localAttributeGroupWrapper.attributes[j])){
								attributesSet.add(localAttributeGroupWrapper.attributes[j]);
							}
						}

						newAttributeGroupWrapper = new AttributeGroupWrapper(attributesSet.toArray(new AttributeWrapper[0]), localAttributeGroupWrapper.anyAttributeProcessContents, localAttributeGroupWrapper.anyAttributeNamespace);
					}else{
						newAttributeGroupWrapper = localAttributeGroupWrapper;
					}

					JDefinedClass contentTypeClass;
					try {
						contentTypeClass = typeClass._class(JMod.PUBLIC | JMod.STATIC, "SimpleTypeClass");
					} catch (JClassAlreadyExistsException e) {
						throw new AssertionError("Reached unreachable state!", e);
					}

					createSimpleType(qualifiedName, restriction, restriction, contentTypeClass, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);//Use own qualifiedName, so this simpleType is used when this complex type is used as base.

					contentValueType = simpleTypeClassMap.get(qualifiedName);
					if(JDefinedClass.class.isAssignableFrom(contentValueType.getClass())){
						contentValueTypeClass = ((JDefinedClass) contentValueType).fields().get("value").type();
					}else{
						Class<?> tmpClass = codeModelClassToJavaClass(contentValueType).getDeclaredField("value").getType();
						if(tmpClass.isPrimitive()){
							contentValueTypeClass = codeModel.ref(getPrimitiveWrapperType(tmpClass)).unboxify();
						}else{
							contentValueTypeClass = codeModel.ref(tmpClass);
						}
					}

				}else if(extension != null){
					Xml.XmlQName baseType = Xml.XmlQName.parseQName(((XmlQName) extension.getAttribute("base")).getValue(), complexType.getNamespaceMap());

					Xml.XmlQName attributeGroupQualifiedName = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/attributeGroup");
					createAttributeGroup(attributeGroupQualifiedName, extension.getAttrDecls(), typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);

					AttributeGroupWrapper localAttributeGroupWrapper = attributeGroupWrapperMap.get(attributeGroupQualifiedName);
					AttributeGroupWrapper baseAttributeGroupWrapper = complexTypeAttributeGroupWrapperMap.get(baseType);


					if(baseAttributeGroupWrapper != null){
						List<AttributeWrapper> localAttributeList = Arrays.asList(localAttributeGroupWrapper.attributes);

						Set<AttributeWrapper> attributesSet = new HashSet<AttributeWrapper>();
						for(int j=0;j<baseAttributeGroupWrapper.attributes.length;++j){
							if("prohibited".equals(baseAttributeGroupWrapper.attributes[j].use)){
								attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
							}else{
								if(!localAttributeList.contains(baseAttributeGroupWrapper.attributes[j])){
									attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
								}
							}
						}
						for(int j=0;j<localAttributeGroupWrapper.attributes.length;++j){
							if(!attributesSet.contains(localAttributeGroupWrapper.attributes[j])){
								attributesSet.add(localAttributeGroupWrapper.attributes[j]);
							}
						}

						newAttributeGroupWrapper = new AttributeGroupWrapper(attributesSet.toArray(new AttributeWrapper[0]), (localAttributeGroupWrapper.anyAttributeProcessContents == null?baseAttributeGroupWrapper.anyAttributeProcessContents:localAttributeGroupWrapper.anyAttributeProcessContents), intersectNamespaces(localAttributeGroupWrapper.anyAttributeNamespace, baseAttributeGroupWrapper.anyAttributeNamespace));
					}else{
						newAttributeGroupWrapper = localAttributeGroupWrapper;
					}
					
					if(typeVarietyIsListSet.contains(baseType)){
						typeVarietyIsListSet.add(qualifiedName);
					}

					contentValueType = simpleTypeClassMap.get(baseType);
					simpleTypeClassMap.put(qualifiedName, contentValueType);
					if(JDefinedClass.class.isAssignableFrom(contentValueType.getClass())){
						contentValueTypeClass = ((JDefinedClass) contentValueType).fields().get("value").type();
					}else{
						Class<?> tmpClass = codeModelClassToJavaClass(contentValueType).getDeclaredField("value").getType();
						if(tmpClass.isPrimitive()){
							contentValueTypeClass = codeModel.ref(getPrimitiveWrapperType(tmpClass)).unboxify();
						}else{
							contentValueTypeClass = codeModel.ref(tmpClass);
						}
					}

				}else{
					throw new AssertionError("Reached unreachable state!");
				}

				allowedChildrenPatternVar.init(JExpr.lit(".*"));
				
				//getValue-Method, which creates the first and only child and returns it's value.
				//if((XmlSimpleTypePlaceholder.class.isAssignableFrom(attr.getClass()))){
				//XmlSimpleType newChild = new contentTypeClass(children[0], ((XmlSimpleTypePlaceholder) children[0]).getDataAsString());
				//newAttr.setQualifiedName(this.qualifiedName);
				//children[0] = newChild;
				//}
				//return children[0].getValue();
				String getValueName = "getValue";
				if(contentValueTypeClass.isPrimitive()){
					getValueName = "getValuePrimitive";
				}
				JMethod getValueMethod = typeClass.method(JMod.PUBLIC, contentValueTypeClass, "getValue");
				getValueMethod._throws(IOException.class);
				getValueMethod._throws(ParseException.class);
				JConditional ifChildrenLoaded = getValueMethod.body()._if(JExpr._this().ref("children").eq(JExpr._null()));
				ifChildrenLoaded._then().invoke("loadChildren").arg(JExpr.lit(true)).arg(JExpr.lit(true)).arg(typeClass.dotclass());
				JConditional ifChildrenEmpty = getValueMethod.body()._if(JExpr._this().ref("children").ref("length").eq(JExpr.lit(0)));
				ifChildrenEmpty._then().assign(JExpr._this().ref("children"), JExpr.newArray(codeModel.ref(Xml.XmlType.class)).add(JExpr._new(codeModel.ref(Xml.XmlText.class)).arg(JExpr._this().ref("file")).arg(JExpr._this()).arg(JExpr._this().ref("pos")).arg(JExpr._this().ref("length"))));
				JConditional ifBlock = getValueMethod.body()._if(codeModel.ref(XmlSimpleTypePlaceholder.class).dotclass().invoke("isAssignableFrom").arg(JExpr.direct("children[0].getClass()")));
				JVar newChildVar = ifBlock._then().decl(contentValueType, "newChild", JExpr._new(contentValueType).arg(JExpr.cast(codeModel._ref(XmlSimpleTypePlaceholder.class), JExpr.direct("children[0]"))).arg(JExpr.direct("((XmlSimpleTypePlaceholder) children[0]).getDataAsString()")));
				ifBlock._then().add(newChildVar.invoke("setQualifiedName").arg(JExpr.direct("this.qualifiedName")));
				ifBlock._then().assign(JExpr.direct("children").component(JExpr.lit(0)), newChildVar);
				getValueMethod.body()._return(((JExpression)JExpr.cast(contentValueType, JExpr.direct("children[0]"))).invoke(getValueName));
			}else if(complexTypeModels.length > 0 && XmlComplexContent.class.equals(complexTypeModels[0].getClass())){
				XmlComplexContent complexContent = (XmlComplexContent) complexTypeModels[0];

				XmlComplexRestriction restriction = complexContent.getRestriction();
				XmlExtension extension = complexContent.getExtension();

				if(restriction != null){
					Xml.XmlQName baseType = Xml.XmlQName.parseQName(((XmlQName) restriction.getAttribute("base")).getValue(), complexType.getNamespaceMap());
					
					Xml.XmlQName attributeGroupQualifiedName = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/attributeGroup");
					createAttributeGroup(attributeGroupQualifiedName, restriction.getAttrDecls(), typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);

					AttributeGroupWrapper localAttributeGroupWrapper = attributeGroupWrapperMap.get(attributeGroupQualifiedName);
					AttributeGroupWrapper baseAttributeGroupWrapper = complexTypeAttributeGroupWrapperMap.get(baseType);


					if(baseAttributeGroupWrapper != null){
						List<AttributeWrapper> localAttributeList = Arrays.asList(localAttributeGroupWrapper.attributes);

						Set<AttributeWrapper> attributesSet = new HashSet<AttributeWrapper>();
						for(int j=0;j<baseAttributeGroupWrapper.attributes.length;++j){
							if("prohibited".equals(baseAttributeGroupWrapper.attributes[j].use)){
								attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
							}else{
								if(!localAttributeList.contains(baseAttributeGroupWrapper.attributes[j])){
									attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
								}
							}
						}
						for(int j=0;j<localAttributeGroupWrapper.attributes.length;++j){
							if(!attributesSet.contains(localAttributeGroupWrapper.attributes[j])){
								attributesSet.add(localAttributeGroupWrapper.attributes[j]);
							}
						}

						newAttributeGroupWrapper = new AttributeGroupWrapper(attributesSet.toArray(new AttributeWrapper[0]), localAttributeGroupWrapper.anyAttributeProcessContents, localAttributeGroupWrapper.anyAttributeNamespace);
					}else{
						newAttributeGroupWrapper = localAttributeGroupWrapper;
					}
					
					newGroupWrapper = createComplexContent(qualifiedName, restriction.getTypeDefParticle(), restriction.getAssertions(), true, baseType, typeClass, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
				}else if(extension != null){
					Xml.XmlQName baseType = Xml.XmlQName.parseQName(((XmlQName) extension.getAttribute("base")).getValue(), complexType.getNamespaceMap());
					
					Xml.XmlQName attributeGroupQualifiedName = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/attributeGroup");
					createAttributeGroup(attributeGroupQualifiedName, extension.getAttrDecls(), typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);

					AttributeGroupWrapper localAttributeGroupWrapper = attributeGroupWrapperMap.get(attributeGroupQualifiedName);
					AttributeGroupWrapper baseAttributeGroupWrapper = complexTypeAttributeGroupWrapperMap.get(baseType);


					if(baseAttributeGroupWrapper != null){
						List<AttributeWrapper> localAttributeList = Arrays.asList(localAttributeGroupWrapper.attributes);

						Set<AttributeWrapper> attributesSet = new HashSet<AttributeWrapper>();
						for(int j=0;j<baseAttributeGroupWrapper.attributes.length;++j){
							if("prohibited".equals(baseAttributeGroupWrapper.attributes[j].use)){
								attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
							}else{
								if(!localAttributeList.contains(baseAttributeGroupWrapper.attributes[j])){
									attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
								}
							}
						}
						for(int j=0;j<localAttributeGroupWrapper.attributes.length;++j){
							if(!attributesSet.contains(localAttributeGroupWrapper.attributes[j])){
								attributesSet.add(localAttributeGroupWrapper.attributes[j]);
							}
						}

						newAttributeGroupWrapper = new AttributeGroupWrapper(attributesSet.toArray(new AttributeWrapper[0]), (localAttributeGroupWrapper.anyAttributeProcessContents == null?baseAttributeGroupWrapper.anyAttributeProcessContents:localAttributeGroupWrapper.anyAttributeProcessContents), intersectNamespaces(localAttributeGroupWrapper.anyAttributeNamespace, baseAttributeGroupWrapper.anyAttributeNamespace));
					}else{
						newAttributeGroupWrapper = localAttributeGroupWrapper;
					}
					
					newGroupWrapper = createComplexContent(qualifiedName, extension.getTypeDefParticle(), extension.getAssertions(), false, baseType, typeClass, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);

				}else{
					throw new AssertionError("Reached unreachable state!");
				}
			}else{
				Xml.XmlQName baseType = new Xml.XmlQName(xs, "anyType");
				
				Xml.XmlComplexType typeDefParticle = null;
				Set<Xml.XmlComplexType> attrDecls = new HashSet<Xml.XmlComplexType>();
				Set<XmlAssertion> assertions = new HashSet<XmlAssertion>();
				
				for(int i=0;i<complexTypeModels.length;++i){
					if(XmlGroupRef.class.equals(complexTypeModels[i].getClass())){
						XmlGroupRef group = (XmlGroupRef) complexTypeModels[i];
						typeDefParticle = group;
					}else if(XmlAll.class.equals(complexTypeModels[i].getClass())){
						XmlAll all = (XmlAll) complexTypeModels[i];
						typeDefParticle = all;
					}else if(XmlExplicitGroup.class.equals(complexTypeModels[i].getClass())){
						XmlExplicitGroup explicitGroup = (XmlExplicitGroup) complexTypeModels[i];
						typeDefParticle = explicitGroup;
					}else if(XmlAttribute.class.equals(complexTypeModels[i].getClass())){
						XmlAttribute attribute = (XmlAttribute) complexTypeModels[i];
						attrDecls.add(attribute);
					}else if(XmlAttributeGroupRef.class.equals(complexTypeModels[i].getClass())){
						XmlAttributeGroupRef attributeGroup = (XmlAttributeGroupRef) complexTypeModels[i];
						attrDecls.add(attributeGroup);
					}else if(XmlAnyAttribute.class.equals(complexTypeModels[i].getClass())){
						XmlAnyAttribute anyAttribute = (XmlAnyAttribute) complexTypeModels[i];
						attrDecls.add(anyAttribute);
					}else if(XmlAssertion.class.equals(complexTypeModels[i].getClass())){
						XmlAssertion assertion = (XmlAssertion) complexTypeModels[i];
						assertions.add(assertion);
					}else{
						throw new AssertionError("Reached unreachable state!");
					}
				}
				
				Xml.XmlQName attributeGroupQualifiedName = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/attributeGroup");
				createAttributeGroup(attributeGroupQualifiedName, attrDecls.toArray(new Xml.XmlComplexType[0]), typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);

				AttributeGroupWrapper localAttributeGroupWrapper = attributeGroupWrapperMap.get(attributeGroupQualifiedName);
				AttributeGroupWrapper baseAttributeGroupWrapper = complexTypeAttributeGroupWrapperMap.get(baseType);

				if(baseAttributeGroupWrapper != null){
					List<AttributeWrapper> localAttributeList = Arrays.asList(localAttributeGroupWrapper.attributes);

					Set<AttributeWrapper> attributesSet = new HashSet<AttributeWrapper>();
					for(int j=0;j<baseAttributeGroupWrapper.attributes.length;++j){
						if("prohibited".equals(baseAttributeGroupWrapper.attributes[j].use)){
							attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
						}else{
							if(!localAttributeList.contains(baseAttributeGroupWrapper.attributes[j])){
								attributesSet.add(baseAttributeGroupWrapper.attributes[j]);
							}
						}
					}
					for(int j=0;j<localAttributeGroupWrapper.attributes.length;++j){
						if(!attributesSet.contains(localAttributeGroupWrapper.attributes[j])){
							attributesSet.add(localAttributeGroupWrapper.attributes[j]);
						}
					}

					newAttributeGroupWrapper = new AttributeGroupWrapper(attributesSet.toArray(new AttributeWrapper[0]), localAttributeGroupWrapper.anyAttributeProcessContents, localAttributeGroupWrapper.anyAttributeNamespace);
				}else{
					newAttributeGroupWrapper = localAttributeGroupWrapper;
				}
				
				newGroupWrapper = createComplexContent(qualifiedName, typeDefParticle, assertions.toArray(new XmlAssertion[0]), true, baseType, typeClass, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
			}
			complexTypeAttributeGroupWrapperMap.put(qualifiedName, newAttributeGroupWrapper);
			
			JTryBlock tryBlock = null;
			for(int j=0;j<newAttributeGroupWrapper.attributes.length;++j){
				if(!"prohibited".equals(newAttributeGroupWrapper.attributes[j].use)){
					typeClass.init().add(allowedAttributesVar.invoke("add").arg(newAttributeGroupWrapper.attributes[j].name));
					if(newAttributeGroupWrapper.attributes[j].defaultValue != null){
						typeClass.init().add(attributeDefaultValuesVar.invoke("put").arg(newAttributeGroupWrapper.attributes[j].name).arg(newAttributeGroupWrapper.attributes[j].defaultValue));
					}
					if("required".equals(newAttributeGroupWrapper.attributes[j].use)){
						typeClass.init().add(requiredAttributesVar.invoke("add").arg(newAttributeGroupWrapper.attributes[j].name));
					}
					if(tryBlock == null){
						tryBlock = typeClass.init()._try();
						JCatchBlock catchBlock = tryBlock._catch(codeModel.ref(URISyntaxException.class));
						JVar exception = catchBlock.param("e");
						catchBlock.body()._throw(JExpr._new(codeModel.ref(AssertionError.class)).arg("URI not parsable").arg(exception));
					}
					tryBlock.body().add(attributeNameMapVar.invoke("put").arg(newAttributeGroupWrapper.attributes[j].name).arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._new(codeModel.ref(URI.class)).arg(newAttributeGroupWrapper.attributes[j].type.namespace.toString())).arg(newAttributeGroupWrapper.attributes[j].type.name)));
				}else{
					typeClass.init().add(forbiddenAttributesVar.invoke("add").arg(newAttributeGroupWrapper.attributes[j].name));
				}
			}
			if(newAttributeGroupWrapper.anyAttributeNamespace != null){
				for(String namespace : newAttributeGroupWrapper.anyAttributeNamespace){
					typeClass.init().add(allowedAttributesVar.invoke("add").arg(namespace));//FIXME:Negative Namespaces?!!!
				}
			}
			
			JMethod constructorMethod = typeClass.constructor(JMod.PUBLIC);
			JVar constructorElemVar = constructorMethod.param(codeModel.ref(Xml.XmlComplexType.class), "elem");
			constructorMethod.body().invoke("super").arg(constructorElemVar).arg(typeClass.dotclass());
			
			if(newGroupWrapper != null){
				allowedChildrenPatternVar.init(JExpr.lit(newGroupWrapper.arrangementPattern));
				Set<String> usedNames = new HashSet<String>();
				for(int i=0;i<newGroupWrapper.elementNames.length;++i){
					JExpression nameNamespaceExpression;
					if(newGroupWrapper.elementNames[i].namespace == null){
						nameNamespaceExpression = JExpr._null();
					}else{
						nameNamespaceExpression = JExpr.lit(newGroupWrapper.elementNames[i].namespace.toString());
					}
					JExpression typeNamespaceExpression;
					if(newGroupWrapper.elementTypes[i].namespace == null){
						typeNamespaceExpression = JExpr._null();
					}else{
						typeNamespaceExpression = JExpr.lit(newGroupWrapper.elementTypes[i].namespace.toString());
					}
					if(tryBlock == null){
						tryBlock = typeClass.init()._try();
						JCatchBlock catchBlock = tryBlock._catch(codeModel.ref(URISyntaxException.class));
						JVar exception = catchBlock.param("e");
						catchBlock.body()._throw(JExpr._new(codeModel.ref(AssertionError.class)).arg("URI not parsable").arg(exception));
					}
					tryBlock.body().add(allowedChildrenNamesVar.invoke("add").arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._new(codeModel.ref(URI.class)).arg(nameNamespaceExpression)).arg(newGroupWrapper.elementNames[i].name)));
					if(!newGroupWrapper.elementNames[i].equals(newGroupWrapper.elementTypes[i])){
						tryBlock.body().add(childrenNameMapVar.invoke("put")
								.arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._new(codeModel.ref(URI.class)).arg(nameNamespaceExpression)).arg(newGroupWrapper.elementNames[i].name))
								.arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._new(codeModel.ref(URI.class)).arg(typeNamespaceExpression)).arg(newGroupWrapper.elementTypes[i].name)));
					}
					tryBlock.body().add(allowedChildrenMinBoundVar.invoke("put")
							.arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._new(codeModel.ref(URI.class)).arg(nameNamespaceExpression)).arg(newGroupWrapper.elementNames[i].name))
							//.arg(JExpr._new(codeModel.ref(BigInteger.class)).arg(JExpr.lit(localGroupWrapper.minBounds[i].toString()))));
							.arg(codeModel.ref(Integer.class).staticInvoke("valueOf").arg(JExpr.lit(newGroupWrapper.minBounds[i].toString()))));
					if(BigInteger.ZERO.compareTo(newGroupWrapper.maxBounds[i]) <= 0){
						tryBlock.body().add(allowedChildrenMaxBoundVar.invoke("put")
								.arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._new(codeModel.ref(URI.class)).arg(nameNamespaceExpression)).arg(newGroupWrapper.elementNames[i].name))
								//.arg(JExpr._new(codeModel.ref(BigInteger.class)).arg(JExpr.lit(localGroupWrapper.maxBounds[i].toString()))));
								.arg(codeModel.ref(Integer.class).staticInvoke("valueOf").arg(JExpr.lit(newGroupWrapper.maxBounds[i].toString()))));//TODO: Support BigInteger?
					}
					
					JInvocation getInvocation;
					JClass contentValueTypeClass;
					if(qualifiedName.equals(newGroupWrapper.elementTypes[i])){
						contentValueTypeClass = typeClass;
					}else{
						contentValueTypeClass = elementClassMap.get(newGroupWrapper.elementTypes[i]);
						if(contentValueTypeClass == null){
							contentValueTypeClass = complexTypeClassMap.get(newGroupWrapper.elementTypes[i]);
						}
						if(contentValueTypeClass == null){
							contentValueTypeClass = simpleTypeClassMap.get(newGroupWrapper.elementTypes[i]);
						}
						if(contentValueTypeClass == null){
							throw new AssertionError("Could not resolve referenced type: "+newGroupWrapper.elementTypes[i]);
						}
					}
					if(BigInteger.ONE.compareTo(newGroupWrapper.maxBounds[i]) < 0 || BigInteger.ZERO.compareTo(newGroupWrapper.maxBounds[i]) > 0){
						getInvocation = JExpr.invoke("getChildren").arg(JExpr.newArray(contentValueTypeClass, JExpr.lit(0)));
						contentValueTypeClass = contentValueTypeClass.array();
					}else{
						getInvocation = JExpr.invoke("getChild");
					}
					
					getInvocation.arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._new(codeModel.ref(URI.class)).arg(nameNamespaceExpression)).arg(newGroupWrapper.elementNames[i].name))
					.arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._new(codeModel.ref(URI.class)).arg(typeNamespaceExpression)).arg(newGroupWrapper.elementTypes[i].name))
					.arg(typeClass.dotclass());
					
					String variableName = generateVariableName(newGroupWrapper.elementNames[i].name, usedNames);
					
					JFieldVar variable = typeClass.field(JMod.PROTECTED, contentValueTypeClass, variableName);
					 
					String upperCaseName = variableName.substring(0, 1).toUpperCase()+variableName.substring(1);
					
					JMethod getMethod = typeClass.method(JMod.PUBLIC, contentValueTypeClass, "get"+upperCaseName);
					getMethod._throws(IOException.class);
					JConditional ifBlock = getMethod.body()._if(variable.eq(JExpr._null()));
					JTryBlock localTryBlock = ifBlock._then()._try();
					JCatchBlock localCatchBlock = localTryBlock._catch(codeModel.ref(URISyntaxException.class));
					JVar localException = localCatchBlock.param("e");
					localCatchBlock.body()._throw(JExpr._new(codeModel.ref(AssertionError.class)).arg("URI not parsable").arg(localException));
					localTryBlock.body().assign(variable, JExpr.cast(contentValueTypeClass, getInvocation));
					getMethod.body()._return(variable);
				}
				if(newGroupWrapper.anyNamespace != null){
					for(String namespace : newGroupWrapper.anyNamespace){
						if(namespace.startsWith("##")){
							typeClass.init().add(allowedChildrenNamesVar.invoke("add").arg(JExpr._new(codeModel.ref(Xml.XmlQName.class)).arg(JExpr._null()).arg(namespace)));
						}else{
							//TODO:
						}
					}
				}
			}
			
			complexTypeImplemented.add(qualifiedName);
		}
	}
	
	private GroupWrapper createComplexContent(Xml.XmlQName qualifiedName, Xml.XmlComplexType typeDefParticle, XmlAssertion[] assertions, boolean isRestricted, Xml.XmlQName baseType, JDefinedClass typeClass, Map<Xml.XmlQName, XmlLocalComplexType> elementComplexTypesMap, Map<Xml.XmlQName, XmlLocalSimpleType> elementSimpleTypesMap, Set<Xml.XmlQName> usedElements, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException, ClassNotFoundException{

		GroupWrapper newGroupWrapper;
		GroupWrapper localGroupWrapper = null;
		
		if(typeDefParticle != null){
			if(XmlGroupRef.class.equals(typeDefParticle.getClass())){
				XmlGroupRef group = (XmlGroupRef) typeDefParticle;
				
				XmlQName refAttr = (XmlQName) group.getAttribute("ref");
				Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), group.getNamespaceMap());
				
				localGroupWrapper = groupWrapperMap.get(ref);
				if(GROUP_CYCLE_INDICATOR.equals(localGroupWrapper)){
					localGroupWrapper = new GroupWrapper(new Xml.XmlQName[0], new Xml.XmlQName[0],  "(\\<"+ref+"\\>)", new BigInteger[0], new BigInteger[0], null);
				}
			}else if(XmlAll.class.equals(typeDefParticle.getClass())){
				XmlAll all = (XmlAll) typeDefParticle;
				
				Set<Xml.XmlQName> elementNames = new HashSet<Xml.XmlQName>();
				Map<Xml.XmlQName, Xml.XmlQName> elementTypes = new HashMap<Xml.XmlQName, Xml.XmlQName>();
				Map<Xml.XmlQName, BigInteger> minBounds = new HashMap<Xml.XmlQName, BigInteger>();
				Map<Xml.XmlQName, BigInteger> maxBounds = new HashMap<Xml.XmlQName, BigInteger>();
				String arrangementPattern = "";
				XmlLocalElement[] elements = all.getElements();
				for(int i=0;i<elements.length;++i){
					XmlLocalElement element = elements[i];
					Xml.XmlQName elementName = null;
					Xml.XmlQName elementType = null;
					
					XmlQName refAttr = (XmlQName) element.getAttribute("ref");
					if(refAttr != null){
						Xml.XmlQName ref = Xml.XmlQName.parseQName(refAttr.getValue(), element.getNamespaceMap());
						ElementWrapper referencedElementWrapper = elementWrapperMap.get(ref);
						usedElements.add(ref);
						if(referencedElementWrapper == null){
							throw new XmlValidationException("Referenced element name cannot be resolved: "+ref);
						}
						elementName = ref;
						elementType = referencedElementWrapper.type;
					}
					
					XmlNCName nameAttr = (XmlNCName) element.getAttribute("name");
					if(nameAttr != null){
						elementName = new Xml.XmlQName(qualifiedName.namespace, nameAttr.getValue());
					}
					XmlQName typeAttr = (XmlQName) element.getAttribute("type");
					if(typeAttr != null){
						elementType = Xml.XmlQName.parseQName(typeAttr.getValue(), element.getNamespaceMap());
					}
					if(typeAttr == null && refAttr == null){
						if(element.getComplexType() == null && element.getSimpleType() == null){
							elementType = new Xml.XmlQName(xs, "anyType");
						}else{
							if(elementName == null){
								elementType = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/allElement"+i);
							}else{
								elementType = new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/"+elementName.name);
							}
						}
					}
					
					if(refAttr == null){
						createElementWrapper(elementType, element, element.getSimpleType(), element.getComplexType(), element.getIdentityConstraints(), elementComplexTypesMap, elementSimpleTypesMap, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
						usedElements.add(elementType);
					}
					
					BigInteger minBound = ((XmlNonNegativeInteger) element.getAttribute("minOccurs")).getValue();
					BigInteger maxBound = ((XmlAllNNI) element.getAttribute("maxOccurs")).getValue();
					
					if(elementName == null){
						elementName = elementType;
					}
					if(!BigInteger.ZERO.equals(maxBound)){
						if(!elementNames.contains(elementName) || elementTypes.get(elementName).equals(elementType)){
							elementNames.add(elementName);
							elementTypes.put(elementName, elementType);
							arrangementPattern+="("+elementName.name+"[ ]+";
							BigInteger currentMinBound = minBounds.get(elementName);
							minBounds.put(elementName, minValue(currentMinBound, minBound));
							BigInteger currentMaxBound = maxBounds.get(elementName);
							maxBounds.put(elementName, maxValue(currentMaxBound, maxBound));
							if(refAttr != null){
								Set<Xml.XmlQName> substitutions = elementSubstitutionGroupMap.get(elementName);
								if(substitutions != null){
									for(Xml.XmlQName substitutionName : substitutions){
										ElementWrapper substitutionWrapper = elementWrapperMap.get(substitutionName);
										usedElements.add(substitutionName);
										elementNames.add(substitutionName);
										elementTypes.put(substitutionName, substitutionWrapper.type);
										arrangementPattern+="|"+substitutionName.name+"[ ]+";
										currentMinBound = minBounds.get(substitutionName);
										minBounds.put(elementName, minValue(currentMinBound, minBounds.get(elementName)));
										currentMaxBound = maxBounds.get(substitutionName);
										maxBounds.put(elementName, maxValue(currentMaxBound, maxBounds.get(elementName)));
									}
								}
							}
							if(minBound.equals(maxBound)){
								arrangementPattern += "){"+minBound.toString()+"}";
							}else{
								arrangementPattern += "){"+minBound.toString()+","+(BigInteger.ZERO.compareTo(maxBound) <= 0?maxBound.toString():"")+"}";
							}
						}else{
							throw new XmlValidationException("Group contains elements with same names but different types!");
						}
					}
				}
				
				Xml.XmlQName[] elementNamesArr = elementNames.toArray(new Xml.XmlQName[0]);
				Xml.XmlQName[] elementTypesArr = new Xml.XmlQName[elementNamesArr.length];
				BigInteger[] minBoundsArr = new BigInteger[elementNamesArr.length];
				BigInteger[] maxBoundsArr = new BigInteger[elementNamesArr.length];
				for(int i=0;i<elementNamesArr.length;++i){
					elementTypesArr[i] = elementTypes.get(elementNamesArr[i]);
					minBoundsArr[i] = minBounds.get(elementNamesArr[i]);
					maxBoundsArr[i] = maxBounds.get(elementNamesArr[i]);
				}
				
				
				localGroupWrapper = new GroupWrapper(
						elementNamesArr,
						elementTypesArr,
						arrangementPattern,
						minBoundsArr,
						maxBoundsArr,
						null
						);
			}else if(XmlExplicitGroup.class.equals(typeDefParticle.getClass())){
				XmlExplicitGroup explicitGroup = (XmlExplicitGroup) typeDefParticle;
				if(explicitGroup != null){
					Set<Xml.XmlQName> elementNames = new HashSet<Xml.XmlQName>();
					Map<Xml.XmlQName, Xml.XmlQName> elementTypes = new HashMap<Xml.XmlQName, Xml.XmlQName>();
					Map<Xml.XmlQName, BigInteger> minBounds = new HashMap<Xml.XmlQName, BigInteger>();
					Map<Xml.XmlQName, BigInteger> maxBounds = new HashMap<Xml.XmlQName, BigInteger>();
					String arrangementPattern = "";
					ArrayBigList<String> anyNamespace = null;
					
					String[] tmp = new String[]{arrangementPattern};
					createExplicitGroup(new Xml.XmlQName(qualifiedName.namespace, qualifiedName.name+"/group"), explicitGroup, elementNames, elementTypes, tmp, minBounds, maxBounds, anyNamespace, elementComplexTypesMap, elementSimpleTypesMap, usedElements, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
					arrangementPattern = tmp[0];
					
					Xml.XmlQName[] elementNamesArr = elementNames.toArray(new Xml.XmlQName[0]);
					Xml.XmlQName[] elementTypesArr = new Xml.XmlQName[elementNamesArr.length];
					BigInteger[] minBoundsArr = new BigInteger[elementNamesArr.length];
					BigInteger[] maxBoundsArr = new BigInteger[elementNamesArr.length];
					for(int i=0;i<elementNamesArr.length;++i){
						elementTypesArr[i] = elementTypes.get(elementNamesArr[i]);
						minBoundsArr[i] = minBounds.get(elementNamesArr[i]);
						maxBoundsArr[i] = maxBounds.get(elementNamesArr[i]);
					}
					
					
					localGroupWrapper = new GroupWrapper(
							elementNamesArr,
							elementTypesArr,
							arrangementPattern,
							minBoundsArr,
							maxBoundsArr,
							anyNamespace
							);
				}
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}else{
			localGroupWrapper = new GroupWrapper(new Xml.XmlQName[0], new Xml.XmlQName[0],  "()", new BigInteger[0], new BigInteger[0], null);
		}
		
		if(!isRestricted){
			GroupWrapper baseGroupWrapper = complexTypeGroupWrapperMap.get(baseType);
			List<Xml.XmlQName> elementNamesList = Arrays.asList(baseGroupWrapper.elementNames);
			List<Xml.XmlQName> elementTypesList = Arrays.asList(baseGroupWrapper.elementTypes);
			List<BigInteger> minBoundsList = Arrays.asList(baseGroupWrapper.minBounds);
			List<BigInteger> maxBoundsList = Arrays.asList(baseGroupWrapper.maxBounds);
			for(int i=0;i<localGroupWrapper.elementNames.length;++i){
				if(!elementNamesList.contains(localGroupWrapper.elementNames[i])){
					elementNamesList.add(localGroupWrapper.elementNames[i]);
					elementTypesList.add(localGroupWrapper.elementTypes[i]);
					minBoundsList.add(localGroupWrapper.minBounds[i]);
					maxBoundsList.add(localGroupWrapper.maxBounds[i]);
				}else{
					if(elementTypesList.get(i).equals(localGroupWrapper.elementTypes[i])){
						BigInteger currentMinBound = minBoundsList.get(i);
						if(currentMinBound.compareTo(localGroupWrapper.minBounds[i]) < 0){
							minBoundsList.set(i, localGroupWrapper.minBounds[i]);
						}
						BigInteger currentMaxBound = maxBoundsList.get(i);
						if(BigInteger.ZERO.compareTo(localGroupWrapper.maxBounds[i]) > 0){
							maxBoundsList.set(i, localGroupWrapper.maxBounds[i]);
						}else if(currentMaxBound != null){
							maxBoundsList.set(i, currentMaxBound.add(localGroupWrapper.maxBounds[i]));
						}
					}else{
						throw new XmlValidationException("Group contains elements with same names but different types!");
					}
				}
			}
			String arrangementPattern = "("+baseGroupWrapper.arrangementPattern+")(" + localGroupWrapper.arrangementPattern+")";
			ArrayBigList<String> anyNamespace = intersectNamespaces(baseGroupWrapper.anyNamespace, localGroupWrapper.anyNamespace);
			newGroupWrapper = new GroupWrapper(
					elementNamesList.toArray(new Xml.XmlQName[0]),
					elementTypesList.toArray(new Xml.XmlQName[0]),
					arrangementPattern,
					minBoundsList.toArray(new BigInteger[0]),
					maxBoundsList.toArray(new BigInteger[0]),
					anyNamespace
					);
		}else{
			newGroupWrapper = localGroupWrapper;
		}
		
		complexTypeGroupWrapperMap.put(qualifiedName, newGroupWrapper);
		
		return newGroupWrapper;
	}
	
	private void createSimpleTypes(Map<URI, Set<XmlTopLevelSimpleType>> simpleTypes, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException, ClassNotFoundException{
		JPackage simpleTypesPackage = codeModel.rootPackage().subPackage("SimpleTypes");
		
		//TODO: Resolve Name conflicts
		
		//Generate Dependencytree and Calc Variety
		Map<Xml.XmlQName, XmlTopLevelSimpleType> qualifiedNameSimpleTypeMap = new HashMap<Xml.XmlQName, XmlTopLevelSimpleType>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> parentDependantsMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Map.Entry<URI, Set<XmlTopLevelSimpleType>> entry : simpleTypes.entrySet()){
			Set<XmlTopLevelSimpleType> simpleTypesSet = entry.getValue();
			for(XmlTopLevelSimpleType simpleType : simpleTypesSet){
				String name = ((XmlNCName) simpleType.getAttribute("name")).getValue();
				Xml.XmlQName qualifiedName = new Xml.XmlQName(entry.getKey(), name);
				qualifiedNameSimpleTypeMap.put(qualifiedName, simpleType);
				
				Xml.XmlComplexType simpleDerivation = simpleType.getSimpleDerivation();
				if(XmlRestriction.class.equals(simpleDerivation.getClass())){
					XmlRestriction restriction = (XmlRestriction) simpleDerivation;
					XmlQName baseTypeAttr = (XmlQName) restriction.getAttribute("base");
					if(baseTypeAttr != null){
						Xml.XmlQName baseType = Xml.XmlQName.parseQName(baseTypeAttr.getValue(), simpleType.getNamespaceMap());
						parentDependantsMap.putIfAbsent(baseType, new HashSet<Xml.XmlQName>());
						parentDependantsMap.get(baseType).add(qualifiedName);
					}
				}else if(XmlList.class.equals(simpleDerivation.getClass())){
					XmlList list = (XmlList) simpleDerivation;
					XmlQName itemTypeAttr = (XmlQName) list.getAttribute("itemType");
					if(itemTypeAttr != null){
						Xml.XmlQName itemType = Xml.XmlQName.parseQName(itemTypeAttr.getValue(), simpleType.getNamespaceMap());
						parentDependantsMap.putIfAbsent(itemType, new HashSet<Xml.XmlQName>());
						parentDependantsMap.get(itemType).add(qualifiedName);
					}
				}else if(XmlUnion.class.equals(simpleDerivation.getClass())){
					XmlUnion union = (XmlUnion) simpleDerivation;
					XmlListQName memberTypes = (XmlListQName) union.getAttribute("memberTypes");
					if(memberTypes != null){
						for(String memberTypeString : memberTypes.getValue()){
							Xml.XmlQName memberType = Xml.XmlQName.parseQName(memberTypeString, simpleType.getNamespaceMap());
							parentDependantsMap.putIfAbsent(memberType, new HashSet<Xml.XmlQName>());
							parentDependantsMap.get(memberType).add(qualifiedName);
						}
					}
				}else{
					throw new AssertionError("Reached unreachable state!");
				}
			}
		}
		Queue<Xml.XmlQName> simpleTypesQueue = new ArrayDeque<Xml.XmlQName>();
		Map<Xml.XmlQName, Set<Xml.XmlQName>> dependenciesMap = new HashMap<Xml.XmlQName, Set<Xml.XmlQName>>();
		for(Xml.XmlQName parent : qualifiedNameSimpleTypeMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				Set<Xml.XmlQName> dependants = entry.getValue();
				if(dependants.contains(parent)){
					dependenciesMap.get(parent).add(entry.getKey());
					isRoot = false;
				}
			}
			if(isRoot){
				simpleTypesQueue.add(parent);
			}
		}
		for(Xml.XmlQName parent : parentDependantsMap.keySet()){
			boolean isRoot = true;
			dependenciesMap.putIfAbsent(parent, new HashSet<Xml.XmlQName>());
			for(Map.Entry<Xml.XmlQName, Set<Xml.XmlQName>> entry : parentDependantsMap.entrySet()){
				Set<Xml.XmlQName> dependants = entry.getValue();
				if(dependants.contains(parent)){
					dependenciesMap.get(parent).add(entry.getKey());
					isRoot = false;
				}
			}
			if(isRoot){
				simpleTypesQueue.add(parent);
			}
		}
		
		while(simpleTypesQueue.size() > 0){
			Xml.XmlQName current = simpleTypesQueue.poll();
			boolean allImplemented = true;
			for(Xml.XmlQName dependency : dependenciesMap.get(current)){
				if(!simpleTypeImplemented.contains(dependency)){
					allImplemented = false;
					break;
				}
			}
			if(allImplemented && !simpleTypeImplemented.contains(current)){
				XmlTopLevelSimpleType simpleType = qualifiedNameSimpleTypeMap.get(current);
				if(simpleType == null){
					Class<? extends XmlType> predefinedSimpleTypesClass = XmlLoaderSchema.getClassByQualifiedName(current);
					if(predefinedSimpleTypesClass == null || !Xml.XmlSimpleType.class.isAssignableFrom(predefinedSimpleTypesClass)){
						throw new RuntimeException("Could not resolve simpleType name: "+current.toString());
					}else{
						simpleTypeImplemented.add(current);
						typeClassNameMap.put(current, predefinedSimpleTypesClass.getSimpleName());
						simpleTypeClassMap.put(current, codeModel.ref(predefinedSimpleTypesClass));
						atomicBaseTypeMap.put(current, current);
						if(predefinedOrderedIsPartial(current)){
							orderedIsPartialSet.add(current);
						}
					}
				}else{
					XmlID id = (XmlID) simpleType.getAttribute("id");
					String classname;
					if(id != null){
						classname = generateClassname(id.getValue(), simpleTypesPackage);
					}else{
						classname = generateClassname(current.name, simpleTypesPackage);
					}
					typeClassNameMap.put(current, classname);
					JDefinedClass typeClass;
					try {
						typeClass = simpleTypesPackage._class(classname);
					} catch (JClassAlreadyExistsException e) {
						throw new AssertionError("Failed to generate unique Classname: "+classname, e);
					}
					createSimpleType(current, simpleType, simpleType.getSimpleDerivation(), typeClass, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
				}
				if(parentDependantsMap.get(current) != null){
					simpleTypesQueue.addAll(parentDependantsMap.get(current));
				}
			}
		}
		for(Xml.XmlQName current : qualifiedNameSimpleTypeMap.keySet()){
			if(!simpleTypeImplemented.contains(current)){
				throw new AssertionError("SimpleType has not been created: "+current);
			}
		}
	}
	
	private void createSimpleType(Xml.XmlQName qualifiedName, Xml.XmlComplexType simpleType, Xml.XmlComplexType simpleDerivation, JDefinedClass typeClass, Set<Xml.XmlQName> typeVarietyIsListSet,
			Map<Xml.XmlQName, Xml.XmlQName> atomicBaseTypeMap, Set<Xml.XmlQName> orderedIsPartialSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException, ClassNotFoundException{
		if(!simpleTypeImplemented.contains(qualifiedName)){

			simpleTypeClassMap.put(qualifiedName, typeClass);
			
			typeClass._extends(Xml.XmlSimpleType.class);

			if(XmlRestriction.class.equals(simpleDerivation.getClass())||XmlSimpleRestriction.class.equals(simpleDerivation.getClass())){
				Xml.XmlComplexType[] simpleRestrictionModels;
				if(XmlRestriction.class.equals(simpleDerivation.getClass())){
					simpleRestrictionModels = ((XmlRestriction) simpleDerivation).getSimpleRestrictionModels();	
				}else{
					simpleRestrictionModels = ((XmlSimpleRestriction) simpleDerivation).getSimpleRestrictionModels();	
				}
				XmlQName baseTypeAttr = (XmlQName) simpleDerivation.getAttribute("base");
				Xml.XmlQName baseType = null;
				if(baseTypeAttr != null){
					baseType = Xml.XmlQName.parseQName(baseTypeAttr.getValue(), simpleType.getNamespaceMap());
				}
				if(baseType != null && typeVarietyIsListSet.contains(baseType)){
					typeVarietyIsListSet.add(qualifiedName);
				}

				XmlLocalSimpleType localSimpleType = null;
				Set<XmlAssertion> assertions = new HashSet<XmlAssertion>();
				Set<XmlFacet> facets = new HashSet<XmlFacet>();

				for(int i=0;i<simpleRestrictionModels.length;++i){
					if(XmlLocalSimpleType.class.equals(simpleRestrictionModels[i].getClass())){
						localSimpleType = (XmlLocalSimpleType) simpleRestrictionModels[i];
					}else if(XmlAssertion.class.equals(simpleRestrictionModels[i].getClass())){
						assertions.add((XmlAssertion) simpleRestrictionModels[i]);
					}else if(XmlFacet.class.equals(simpleRestrictionModels[i].getClass())){
						facets.add((XmlFacet) simpleRestrictionModels[i]);
					}else{

					}
				}

				JClass baseTypeClassRef;
				JType baseValueType;
				Xml.XmlQName atomicBaseType;
				boolean orderedIsPartial;

				if(baseType == null){
					baseType = new Xml.XmlQName(simpleDerivation.qualifiedName.namespace, simpleDerivation.qualifiedName.name+"/restrictedType");
					JDefinedClass baseTypeClass = codeModel.anonymousClass(Xml.XmlSimpleType.class);
					createSimpleType(baseType, localSimpleType, localSimpleType.getSimpleDerivation(), baseTypeClass, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
					baseTypeClassRef = baseTypeClass;
					baseValueType = ((JDefinedClass) baseTypeClassRef).fields().get("value").type();
				}else{
					baseTypeClassRef = simpleTypeClassMap.get(baseType);
					if(JDefinedClass.class.isAssignableFrom(baseTypeClassRef.getClass())){
						baseValueType = ((JDefinedClass) baseTypeClassRef).fields().get("value").type();
					}else{
						Class<?> tmpClass = codeModelClassToJavaClass(baseTypeClassRef).getDeclaredField("value").getType();
						if(tmpClass.isPrimitive()){
							baseValueType = codeModel.ref(getPrimitiveWrapperType(tmpClass)).unboxify();
						}else{
							baseValueType = codeModel.ref(tmpClass);
						}
					}
				}
				
				JType baseValueTypeClass;
				if(baseValueType.isPrimitive()){
					baseValueTypeClass = codeModel.ref(getPrimitiveWrapperType(codeModelClassToJavaClass(baseValueType))).unboxify();
				}else{
					baseValueTypeClass = baseValueType;
				}

				atomicBaseType = atomicBaseTypeMap.get(baseType);
				atomicBaseTypeMap.put(qualifiedName, atomicBaseType);

				orderedIsPartial = orderedIsPartialSet.contains(baseType);
				if(orderedIsPartial){
					orderedIsPartialSet.add(qualifiedName);
				}

				JFieldVar valueField = typeClass.field(JMod.PROTECTED | JMod.FINAL, baseValueType, "value");

				JClass wrapperType = null;
				JPrimitiveType primitiveType = null;
				String parseAndCheckValueName = "parseAndCheckValue";
				String parseValueName = "parseValue";
				String checkValueBasedFacetsName = "checkValueBasedFacets";
				String getValueName = "getValue";
				if(baseValueType.isPrimitive()){
					wrapperType = codeModel.ref(getPrimitiveWrapperType(codeModelClassToJavaClass(baseValueType)));
					primitiveType = wrapperType.getPrimitiveType();
					
					JMethod getMethod = typeClass.method(JMod.PUBLIC, wrapperType, "getValue");
					getMethod.annotate(Override.class);
					getMethod.body()._return(wrapperType.staticInvoke("valueOf").arg(valueField));
					
					parseAndCheckValueName = "parseAndCheckValuePrimitive";
					parseValueName = "parseValuePrimitive";
					checkValueBasedFacetsName = "checkValueBasedFacetsPrimitive";
					getValueName = "getValuePrimitive";
				}
				
				JMethod getMethod = typeClass.method(JMod.PUBLIC, baseValueType, getValueName);
				if(!baseValueType.isPrimitive()){
					getMethod.annotate(Override.class);
				}
				getMethod.body()._return(valueField);

				JMethod constructorMethod = typeClass.constructor(JMod.PUBLIC);
				constructorMethod._throws(ParseException.class);
				JVar constructorAttrVar = constructorMethod.param(Xml.XmlSimpleType.class, "attr");
				JVar constructorValueVar = constructorMethod.param(String.class, "value");
				JInvocation constructorSuperInvocation = constructorMethod.body().invoke("super");
				constructorSuperInvocation.arg(constructorAttrVar);
				JInvocation constructorParseValueInvocation = typeClass.staticInvoke(parseAndCheckValueName);
				constructorParseValueInvocation.arg(constructorValueVar);
				constructorParseValueInvocation.arg(JExpr._this().ref("file"));
				constructorMethod.body().assign(JExpr._this().ref("value"), constructorParseValueInvocation);

				//Apply pre-lexical and lexical facets
				
				if(baseValueType.isPrimitive()){
					JMethod parseAndCheckMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, wrapperType, "parseAndCheckValue");
					parseAndCheckMethod._throws(ParseException.class);
					JVar parseAndCheckMethodValueVar = parseAndCheckMethod.param(String.class, "value");
					JVar parseAndCheckMethodFileVar = parseAndCheckMethod.param(XmlFile.class, "file");
					
					parseAndCheckMethod.body()._return(wrapperType.staticInvoke("valueOf").arg(JExpr.invoke("parseAndCheckValuePrimitive").arg(parseAndCheckMethodValueVar).arg(parseAndCheckMethodFileVar)));
				}
				//parseAndCheckValue Begin
				JMethod parseAndCheckMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, baseValueType, parseAndCheckValueName);
				parseAndCheckMethod._throws(ParseException.class);
				JVar parseAndCheckMethodValueVar = parseAndCheckMethod.param(String.class, "value");
				JVar parseAndCheckMethodFileVar = parseAndCheckMethod.param(XmlFile.class, "file");
				JVar parseAndCheckTmpVar = parseAndCheckMethod.body().decl(codeModel.ref(String.class), "tmp", typeClass.staticInvoke("applyLexicalFacets").arg(parseAndCheckMethodValueVar).arg(parseAndCheckMethodFileVar));
				//Parse value
				JVar parseAndCheckMethodRetVar;
				if(typeVarietyIsListSet.contains(qualifiedName)){
					parseAndCheckMethodRetVar = parseAndCheckMethod.body().decl(baseValueTypeClass, "ret", typeClass.staticInvoke(parseValueName).arg(parseAndCheckTmpVar).arg(parseAndCheckMethodFileVar));
				}else{
					parseAndCheckMethodRetVar = parseAndCheckMethod.body().decl(baseValueTypeClass, "ret", typeClass.staticInvoke(parseValueName).arg(parseAndCheckTmpVar));
				}
				//Check value-based facets
				parseAndCheckMethod.body().add(typeClass.staticInvoke(checkValueBasedFacetsName).arg(parseAndCheckMethodRetVar));

				//parseAndCheckValue End
				parseAndCheckMethod.body()._return(parseAndCheckMethodRetVar);
				
				if(baseValueType.isPrimitive()){
					JMethod parseMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, wrapperType, "parseValue");
					JVar parseMethodValueVar = parseMethod.param(String.class, "value");
					JVar parseMethodFileVar = null;
					if(typeVarietyIsListSet.contains(qualifiedName)){
						parseMethod._throws(ParseException.class);
						parseMethodFileVar = parseMethod.param(XmlFile.class, "file");
					}
					JVar parseMethodRetVar;
					if(baseType != null && typeVarietyIsListSet.contains(baseType)){
						parseMethodRetVar = parseMethod.body().decl(wrapperType, "ret", wrapperType.staticInvoke("valueOf").arg(JExpr.invoke("parseValuePrimitive").arg(parseMethodValueVar).arg(parseMethodFileVar)));
					}else{
						parseMethodRetVar = parseMethod.body().decl(wrapperType, "ret", wrapperType.staticInvoke("valueOf").arg(JExpr.invoke("parseValuePrimitive").arg(parseMethodValueVar)));
					}

					parseMethod.body()._return(parseMethodRetVar);
				}
				//parseValue Begin
				JMethod parseMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, baseValueType, parseValueName);
				JVar parseMethodValueVar = parseMethod.param(String.class, "value");
				JVar parseMethodFileVar = null;
				if(typeVarietyIsListSet.contains(qualifiedName)){
					parseMethod._throws(ParseException.class);
					parseMethodFileVar = parseMethod.param(XmlFile.class, "file");
				}
				JVar parseMethodRetVar;
				if(baseType != null && typeVarietyIsListSet.contains(baseType)){
					parseMethodRetVar = parseMethod.body().decl(baseValueTypeClass, "ret", JExpr.cast(baseValueTypeClass, baseTypeClassRef.staticInvoke(parseValueName).arg(parseMethodValueVar).arg(parseMethodFileVar)));
				}else{
					parseMethodRetVar = parseMethod.body().decl(baseValueTypeClass, "ret", JExpr.cast(baseValueTypeClass, baseTypeClassRef.staticInvoke(parseValueName).arg(parseMethodValueVar)));
				}

				//parseValue End
				parseMethod.body()._return(parseMethodRetVar);


				BigInteger minLength = BigInteger.valueOf(-1);
				BigInteger maxLength = BigInteger.valueOf(-1);
				Set<String> patterns = new HashSet<String>();
				Set<String> enumerations = new HashSet<String>();
				String whitespace = "preserve";
				String minExclusive = null;
				String maxExclusive = null;
				String minInclusive = null;
				String maxInclusive = null;
				long totalDigits = -1;
				long fractionDigits = -1;
				String explicitTimezone = null;
				for(XmlFacet facet : facets){
					String value = ((XmlSimpleTypePlaceholder) facet.getAttribute("value")).getDataAsString();
					if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "length"))){
						BigInteger length = new BigInteger(value);
						minLength = length;
						maxLength = length;
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "minLength"))){
						minLength = new BigInteger(value);
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "maxLength"))){
						maxLength = new BigInteger(value);
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "pattern"))){
						patterns.add(xmlRegexToJavaRegex(value));
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "enumeration"))){
						enumerations.add(value);
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "whiteSpace"))){
						whitespace = value;//TODO: Check if allowed for that parent
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "minInclusive"))){
						minInclusive = value;
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "maxInclusive"))){
						maxInclusive = value;
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "minExclusive"))){
						minExclusive = value;
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "maxExclusive"))){
						maxExclusive = value;
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "totalDigits"))){
						totalDigits = Long.parseLong(value);
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "fractionDigits"))){
						fractionDigits = Long.parseLong(value);
					}else if(facet.qualifiedName.equals(new Xml.XmlQName(xs, "explicitTimezone"))){
						explicitTimezone = value;
					}
				}

				String patternInitString = null;
				String currentPattern = null;
				String enumerationsPattern = null;

				if(patterns.size() > 0){
					StringBuilder patternBuilder = new StringBuilder();
					boolean first = true;
					for(String pattern : patterns){
						if(first){
							first = false;
						}else{
							patternBuilder.append('|');
						}
						patternBuilder.append(pattern);
					}
					currentPattern = patternBuilder.toString();
				}
				if(enumerations.size() > 0){
					StringBuilder patternBuilder = new StringBuilder();
					boolean first = true;
					for(String enumeration : enumerations){
						if(first){
							first = false;
						}else{
							patternBuilder.append('|');
						}
						patternBuilder.append(enumeration);
					}
					enumerationsPattern = patternBuilder.toString();
				}
				//Enumeration will be checked as lexical and maybe in parser.
				patternInitString = intersectRegex(enumerationsPattern, currentPattern);//Parent pattern and assertions are checked by call of base Types parseValue

				if(patternInitString != null){
					JExpression patternInitExpression = JExpr.direct("Pattern.compile(\""+patternInitString+"\")");
					JFieldVar patternField = typeClass.field(JMod.PRIVATE | JMod.STATIC | JMod.FINAL, Pattern.class, "RESTRICTION_PATTERN", patternInitExpression);
				}

				//applyLexicalFacets Begin
				JMethod applyLexicalFacetsMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.ref(String.class), "applyLexicalFacets");
				applyLexicalFacetsMethod._throws(ParseException.class);
				JVar applyLexicalFacetsMethodValueVar = applyLexicalFacetsMethod.param(String.class, "value");
				JVar applyLexicalFacetsMethodFileVar = applyLexicalFacetsMethod.param(XmlFile.class, "file");

				//Apply pre-lexical and lexical facets of base type
				JVar applyLexicalFacetsMethodTmpVar = applyLexicalFacetsMethod.body().decl(codeModel.ref(String.class), "tmp", baseTypeClassRef.staticInvoke("applyLexicalFacets").arg(applyLexicalFacetsMethodValueVar).arg(applyLexicalFacetsMethodFileVar));
				//Apply pre-lexical and lexical facets of own type
				JExpression applyLexicalFacetsMethodPreLexicalExpression = null;
				if("collapse".equals(whitespace)){
					applyLexicalFacetsMethodPreLexicalExpression = JExpr.direct("normalize(tmp, true, file).trim().replaceAll(\"[ ]+\", \" \")");
				}else if("replace".equals(whitespace)){
					applyLexicalFacetsMethodPreLexicalExpression = JExpr.direct("normalize(tmp, true, file)");
				}else if("preserve".equals(whitespace)){
					//Nothing
				}else{
					throw new AssertionError("Illegal value should have been detected while parsing: "+whitespace);
				}
				if(!"preserve".equals(whitespace)){
					applyLexicalFacetsMethod.body().assign(applyLexicalFacetsMethodTmpVar, applyLexicalFacetsMethodPreLexicalExpression);
				}
				if(patternInitString != null){
					JConditional parseIf = applyLexicalFacetsMethod.body()._if(JExpr.direct("!RESTRICTION_PATTERN.matcher(tmp).matches()"));
					parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value does not match restriction: ").plus(applyLexicalFacetsMethodValueVar)));
				}
				//applyLexicalFacets End
				applyLexicalFacetsMethod.body()._return(applyLexicalFacetsMethodTmpVar);
				
				if(baseValueType.isPrimitive()){
					JMethod checkValueBasedFacetsMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.VOID, "checkValueBasedFacets");
					JVar checkValueBasedFacetsMethodValueVar = checkValueBasedFacetsMethod.param(wrapperType, "value");
					checkValueBasedFacetsMethod.body().invoke("checkValueBasedFacetsPrimitive").arg(primitiveType.unwrap(checkValueBasedFacetsMethodValueVar));
				}
				
				//checkValueBasedFacets Begin
				JMethod checkValueBasedFacetsMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.VOID, checkValueBasedFacetsName);
				JVar checkValueBasedFacetsMethodValueVar = checkValueBasedFacetsMethod.param(baseValueType, "value");

				//Check parent value-based facets
				checkValueBasedFacetsMethod.body().add(baseTypeClassRef.staticInvoke("checkValueBasedFacets").arg(checkValueBasedFacetsMethodValueVar));
				//Check own value-based facets
				if(!minLength.equals(BigInteger.valueOf(-1))){
					if(derivedFromString(atomicBaseType) || derivedFromAnyURI(atomicBaseType)){
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("value.length < "+minLength.intValue()));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value not long enough. Length must be >= "+minLength+", but was ").plus(JExpr.direct("value.length()"))));
					}else if(derivedFromHexBinary(atomicBaseType)){
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("value.bitLength() < "+minLength.intValue()));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value not long enough. Length must be >= "+minLength+", but was ").plus(JExpr.direct("value.bitLength()"))));
					}else if(derivedFromBase64Binary(atomicBaseType)){
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("value.length < "+minLength.intValue()));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value not long enough. Length must be >= "+minLength+", but was ").plus(JExpr.direct("value.length"))));
					}else if(typeVarietyIsListSet.contains(qualifiedName)){
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(checkValueBasedFacetsMethodValueVar.invoke("size").invoke("compareTo").arg(JExpr._new(codeModel.ref(BigInteger.class)).arg(JExpr.lit(minLength.toString()))).lt(JExpr.lit(0)));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value not long enough. Length must be >= "+minLength+", but was ").plus(JExpr.direct("value.size()"))));
					}else{
						//Unknown atomic type
					}
				}
				if(!maxLength.equals(BigInteger.valueOf(-1))){
					if(derivedFromString(atomicBaseType) || derivedFromAnyURI(atomicBaseType)){
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("value.length() > "+maxLength.intValue()));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value too long. Length must be <= "+maxLength+", but was ").plus(JExpr.direct("value.length()"))));
					}else if(derivedFromHexBinary(atomicBaseType)){
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("value.bitLength() > "+maxLength.intValue()));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value too long. Length must be <= "+maxLength+", but was ").plus(JExpr.direct("value.bitLength()"))));
					}else if(derivedFromBase64Binary(atomicBaseType)){
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("value.length > "+maxLength.intValue()));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value too long. Length must be <= "+maxLength+", but was ").plus(JExpr.direct("value.length"))));
					}else if(typeVarietyIsListSet.contains(qualifiedName)){
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(checkValueBasedFacetsMethodValueVar.invoke("size").invoke("compareTo").arg(JExpr._new(codeModel.ref(BigInteger.class)).arg(JExpr.lit(maxLength.toString()))).gt(JExpr.lit(0)));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value too long. Length must be <= "+maxLength+", but was ").plus(JExpr.direct("value.size()"))));
					}else{
						//Unknown atomic type
					}
				}
				if(totalDigits != -1){
					if(derivedFromDecimal(atomicBaseType)){
						if((new Xml.XmlQName(xs, "decimal")).equals(atomicBaseType)){
							JVar parseTotalDigits = checkValueBasedFacetsMethod.body().decl(codeModel.INT, "totalDigits", JExpr.direct("value.signum() == 0 ? 0 : value.precision()"));
							JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("totalDigits > "+totalDigits));
							parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Too much totalDigits. Count must be <= "+totalDigits+", but was ").plus(parseTotalDigits)));
						}else if((new Xml.XmlQName(xs, "integer")).equals(atomicBaseType)||
								(new Xml.XmlQName(xs, "nonPositiveInteger")).equals(atomicBaseType)||
								(new Xml.XmlQName(xs, "nonNegativeInteger")).equals(atomicBaseType)||
								(new Xml.XmlQName(xs, "negativeInteger")).equals(atomicBaseType)||
								(new Xml.XmlQName(xs, "unsignedLong")).equals(atomicBaseType)||
								(new Xml.XmlQName(xs, "positiveInteger")).equals(atomicBaseType)){
							JVar parseTotalDigits = checkValueBasedFacetsMethod.body().decl(codeModel.INT, "totalDigits");
							JVar parseTmp = checkValueBasedFacetsMethod.body().decl(codeModel.ref(BigInteger.class), "tmp");
							JWhileLoop parseWhile = checkValueBasedFacetsMethod.body()._while(JExpr.direct("!BigInteger.ZERO.equals(tmp)"));
							parseWhile.body().assignPlus(parseTotalDigits, JExpr.lit(1));
							parseWhile.body().assign(parseTmp, parseTmp.invoke("divide").arg("BigInteger.TEN"));
							JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("totalDigits > "+totalDigits));
							parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Too much totalDigits. Count must be <= "+totalDigits+", but was ").plus(parseTotalDigits)));
						}else if((new Xml.XmlQName(xs, "long")).equals(atomicBaseType)||
								(new Xml.XmlQName(xs, "unsignedInt")).equals(atomicBaseType)){
							JVar parseTotalDigits = checkValueBasedFacetsMethod.body().decl(codeModel.INT, "totalDigits");
							JVar parseTmp = checkValueBasedFacetsMethod.body().decl(codeModel.LONG, "tmp");
							JWhileLoop parseWhile = checkValueBasedFacetsMethod.body()._while(JExpr.direct("tmp != 0"));
							parseWhile.body().assignPlus(parseTotalDigits, JExpr.lit(1));
							parseWhile.body().assign(parseTmp, parseTmp.div(JExpr.lit(10)));
							JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("totalDigits > "+totalDigits));
							parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Too much totalDigits. Count must be <= "+totalDigits+", but was ").plus(parseTotalDigits)));
						}else if((new Xml.XmlQName(xs, "int")).equals(atomicBaseType)||
								(new Xml.XmlQName(xs, "unsignedShort")).equals(atomicBaseType)){
							JVar parseTotalDigits = checkValueBasedFacetsMethod.body().decl(codeModel.INT, "totalDigits");
							JVar parseTmp = checkValueBasedFacetsMethod.body().decl(codeModel.INT, "tmp");
							JWhileLoop parseWhile = checkValueBasedFacetsMethod.body()._while(JExpr.direct("tmp != 0"));
							parseWhile.body().assignPlus(parseTotalDigits, JExpr.lit(1));
							parseWhile.body().assign(parseTmp, parseTmp.div(JExpr.lit(10)));
							JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("totalDigits > "+totalDigits));
							parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Too much totalDigits. Count must be <= "+totalDigits+", but was ").plus(parseTotalDigits)));
						}else if((new Xml.XmlQName(xs, "short")).equals(atomicBaseType)||
								(new Xml.XmlQName(xs, "unsignedByte")).equals(atomicBaseType)){
							JVar parseTotalDigits = checkValueBasedFacetsMethod.body().decl(codeModel.INT, "totalDigits");
							JVar parseTmp = checkValueBasedFacetsMethod.body().decl(codeModel.SHORT, "tmp");
							JWhileLoop parseWhile = checkValueBasedFacetsMethod.body()._while(JExpr.direct("tmp != 0"));
							parseWhile.body().assignPlus(parseTotalDigits, JExpr.lit(1));
							parseWhile.body().assign(parseTmp, parseTmp.div(JExpr.lit(10)));
							JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("totalDigits > "+totalDigits));
							parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Too much totalDigits. Count must be <= "+totalDigits+", but was ").plus(parseTotalDigits)));
						}else if((new Xml.XmlQName(xs, "byte")).equals(atomicBaseType)){
							JVar parseTotalDigits = checkValueBasedFacetsMethod.body().decl(codeModel.INT, "totalDigits");
							JVar parseTmp = checkValueBasedFacetsMethod.body().decl(codeModel.BYTE, "tmp");
							JWhileLoop parseWhile = checkValueBasedFacetsMethod.body()._while(JExpr.direct("tmp != 0"));
							parseWhile.body().assignPlus(parseTotalDigits, JExpr.lit(1));
							parseWhile.body().assign(parseTmp, parseTmp.div(JExpr.lit(10)));
							JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("totalDigits > "+totalDigits));
							parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Too much totalDigits. Count must be <= "+totalDigits+", but was ").plus(parseTotalDigits)));
						}else{
							//Unknown atomic type
						}
					}else{
						//Unknown atomic type
					}
				}
				if(fractionDigits != -1){
					if((new Xml.XmlQName(xs, "decimal")).equals(atomicBaseType)){
						JVar parseFractionDigits = checkValueBasedFacetsMethod.body().decl(codeModel.INT, "fractionDigits", JExpr.direct("value.signum() == 0 ? 0 : value.scale()"));
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("fractionDigits > "+fractionDigits));
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Too much fractionDigits. Count must be <= "+fractionDigits+", but was ").plus(parseFractionDigits)));
					}else{
						//Unknown atomic type
					}
				}
				if(explicitTimezone != null){
					if(derivedFromDateTime(atomicBaseType)||
							derivedFromTime(atomicBaseType)||
							derivedFromDate(atomicBaseType)||
							derivedFromGYearMonth(atomicBaseType)||
							derivedFromGYear(atomicBaseType)||
							derivedFromGMonthDay(atomicBaseType)||
							derivedFromGDay(atomicBaseType)||
							derivedFromGMonth(atomicBaseType)){
						if("required".equals(explicitTimezone)){
							JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("TemporalQueries.offset().queryFrom(value) == null"));
							parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Explicit timeZoneOffset required here, but not provided.")));
						}else if("prohibited".equals(explicitTimezone)){
							JConditional parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("TemporalQueries.offset().queryFrom(value) != null"));
							parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Explicit timeZoneOffset not allowed here.")));
						}else{
							//Optional
						}
					}else{
						//Unknown atomic type
					}
				}
				if(!orderedIsPartial && !typeVarietyIsListSet.contains(qualifiedName)){
					if(minInclusive != null){
						JConditional parseIf;
						if(baseValueType.isPrimitive()){
							JVar parseMinInclusive = checkValueBasedFacetsMethod.body().decl(JMod.FINAL, wrapperType, "minInclusive", typeClass.staticInvoke("parseValue").arg(minInclusive));
							parseIf = checkValueBasedFacetsMethod.body()._if(parseMinInclusive.invoke("compareTo").arg(wrapperType.staticInvoke("valueOf").arg(checkValueBasedFacetsMethodValueVar)).gt(JExpr.lit(0)));
						}else{
							JVar parseMinInclusive = checkValueBasedFacetsMethod.body().decl(JMod.FINAL, baseValueTypeClass, "minInclusive", typeClass.staticInvoke("parseValue").arg(minInclusive));
							parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("minInclusive.compareTo(value) > 0"));
						}
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value too low. Must be >= "+minInclusive+", but was ").plus(checkValueBasedFacetsMethodValueVar)));
					}else if(minExclusive != null){
						JConditional parseIf;
						if(baseValueType.isPrimitive()){
							JVar parseMinExclusive = checkValueBasedFacetsMethod.body().decl(JMod.FINAL, wrapperType, "minExclusive", typeClass.staticInvoke("parseValue").arg(minExclusive));
							parseIf = checkValueBasedFacetsMethod.body()._if(parseMinExclusive.invoke("compareTo").arg(wrapperType.staticInvoke("valueOf").arg(checkValueBasedFacetsMethodValueVar)).gte(JExpr.lit(0)));
						}else{
							JVar parseMinExclusive = checkValueBasedFacetsMethod.body().decl(JMod.FINAL, baseValueTypeClass, "minExclusive", typeClass.staticInvoke("parseValue").arg(minExclusive));
							parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("minExclusive.compareTo(value) >= 0"));
						}
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value too low. Must be > "+minExclusive+", but was ").plus(checkValueBasedFacetsMethodValueVar)));
					}
					if(maxInclusive != null){
						JConditional parseIf;
						if(baseValueType.isPrimitive()){
							JVar parseMaxInclusive = checkValueBasedFacetsMethod.body().decl(JMod.FINAL, wrapperType, "maxInclusive", typeClass.staticInvoke("parseValue").arg(maxInclusive));
							parseIf = checkValueBasedFacetsMethod.body()._if(parseMaxInclusive.invoke("compareTo").arg(wrapperType.staticInvoke("valueOf").arg(checkValueBasedFacetsMethodValueVar)).lt(JExpr.lit(0)));
						}else{
							JVar parseMaxInclusive = checkValueBasedFacetsMethod.body().decl(JMod.FINAL, baseValueTypeClass, "maxInclusive", typeClass.staticInvoke("parseValue").arg(maxInclusive));
							parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("maxInclusive.compareTo(value) < 0"));
						}
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value too low. Must be <= "+maxInclusive+", but was ").plus(checkValueBasedFacetsMethodValueVar)));
					}else if(maxExclusive != null){
						JConditional parseIf;
						if(baseValueType.isPrimitive()){
							JVar parseMaxExclusive = checkValueBasedFacetsMethod.body().decl(JMod.FINAL, wrapperType, "maxExclusive", typeClass.staticInvoke("parseValue").arg(maxExclusive));
							parseIf = checkValueBasedFacetsMethod.body()._if(parseMaxExclusive.invoke("compareTo").arg(wrapperType.staticInvoke("valueOf").arg(checkValueBasedFacetsMethodValueVar)).lte(JExpr.lit(0)));
						}else{
							JVar parseMaxExclusive = checkValueBasedFacetsMethod.body().decl(JMod.FINAL, baseValueTypeClass, "maxExclusive", typeClass.staticInvoke("parseValue").arg(maxExclusive));
							parseIf = checkValueBasedFacetsMethod.body()._if(JExpr.direct("maxExclusive.compareTo(value) <= 0"));
						}
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value too low. Must be < "+maxExclusive+", but was ").plus(checkValueBasedFacetsMethodValueVar)));
					}
				}
				for(XmlAssertion assertion : assertions){
					XmlString testAttribute = (XmlString) assertion.getAttribute("test");
					if(testAttribute != null){
						String test = testAttribute.getValue();


						JExpression parseExpression = parseXPathToJavaExpression(test);
						JConditional parseIf = checkValueBasedFacetsMethod.body()._if(parseExpression);
						parseIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value does not full-fill assertion: "+test)));
					}
				}

				//checkValueBasedFacets End


			}else if(XmlList.class.equals(simpleDerivation.getClass())){
				typeVarietyIsListSet.add(qualifiedName);

				XmlList list = (XmlList) simpleDerivation;

				JClass itemTypeClass;
				JType itemValueType;
				
				XmlQName itemTypeAttr = (XmlQName) list.getAttribute("itemType");
				Xml.XmlQName itemType;
				if(itemTypeAttr == null){
					itemType = new Xml.XmlQName(list.qualifiedName.namespace, list.qualifiedName.name+"/itemType");
					XmlLocalSimpleType localSimpleType = list.getSimpleType();
					itemTypeClass = codeModel.anonymousClass(Xml.XmlSimpleType.class);
					createSimpleType(itemType, localSimpleType, localSimpleType.getSimpleDerivation(), (JDefinedClass) itemTypeClass, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
					itemValueType = ((JDefinedClass) itemTypeClass).fields().get("value").type();
				}else{
					itemType = Xml.XmlQName.parseQName(itemTypeAttr.getValue(), simpleType.getNamespaceMap());
					itemTypeClass = simpleTypeClassMap.get(itemType);
					if(itemTypeClass == null){
						throw new AssertionError("SimpleType should allready been created");
					}
					if(JDefinedClass.class.isAssignableFrom(itemTypeClass.getClass())){
						itemValueType = ((JDefinedClass) itemTypeClass).fields().get("value").type();
					}else{
						Class<?> tmpClass = codeModelClassToJavaClass(itemTypeClass).getDeclaredField("value").getType();
						if(tmpClass.isPrimitive()){
							itemValueType = codeModel.ref(getPrimitiveWrapperType(tmpClass)).unboxify();
						}else{
							itemValueType = codeModel.ref(tmpClass);
						}
					}
				}
				
				if(isPrimitiveWrapper(codeModelClassToJavaClass(itemValueType))){
					itemValueType = codeModel.ref(getPrimitiveType(codeModelClassToJavaClass(itemValueType)));
				}
				
				JType itemValueTypeClass;
				if(itemValueType.isPrimitive()){
					itemValueTypeClass = codeModel.ref(getPrimitiveWrapperType(codeModelClassToJavaClass(itemValueType))).unboxify();
				}else{
					itemValueTypeClass = itemValueType;
				}
				
				JType itemValueListClass = codeModel.ref(ArrayBigList.class).narrow(itemValueTypeClass);

				if(typeVarietyIsListSet.contains(itemType)){
					throw new RuntimeException("Varity of itemType must not be list: "+itemType);
				}

				String patternInitString = "(.*(?:(?:[ ]+).*)*)";

				JExpression patternInitExpression = JExpr.direct("Pattern.compile(\""+patternInitString+"\")");
				JFieldVar patternField = typeClass.field(JMod.PRIVATE | JMod.STATIC | JMod.FINAL, Pattern.class, "RESTRICTION_PATTERN", patternInitExpression);

				JFieldVar valueField = typeClass.field(JMod.PROTECTED | JMod.FINAL, itemValueListClass, "value");

				JMethod getMethod = typeClass.method(JMod.PUBLIC, itemValueListClass, "getValue");
				getMethod.annotate(Override.class);
				getMethod.body()._return(valueField);

				JMethod constructorMethod = typeClass.constructor(JMod.PUBLIC);
				constructorMethod._throws(ParseException.class);
				JVar constructorAttrVar = constructorMethod.param(Xml.XmlSimpleType.class, "attr");
				JVar constructorValueVar = constructorMethod.param(String.class, "value");
				JInvocation constructorSuperInvocation = constructorMethod.body().invoke("super");
				constructorSuperInvocation.arg(constructorAttrVar);
				JInvocation constructorParseValueInvocation = typeClass.staticInvoke("parseAndCheckValue");
				constructorParseValueInvocation.arg(constructorValueVar);
				constructorParseValueInvocation.arg(JExpr._this().ref("file"));
				constructorMethod.body().assign(JExpr._this().ref("value"), constructorParseValueInvocation);

				//parseAndCheckValue Begin
				JMethod parseAndCheckMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, itemValueListClass, "parseAndCheckValue");
				parseAndCheckMethod._throws(ParseException.class);
				JVar parseAndCheckMethodValueVar = parseAndCheckMethod.param(String.class, "value");
				JVar parseAndCheckMethodFileVar = parseAndCheckMethod.param(XmlFile.class, "file");

				//Apply pre-lexical and lexical facets
				JVar parseAndCheckTmpVar = parseAndCheckMethod.body().decl(codeModel.ref(String.class), "tmp", typeClass.staticInvoke("applyLexicalFacets").arg(parseAndCheckMethodValueVar).arg(parseAndCheckMethodFileVar));
				//Parse value
				JVar parseAndCheckMethodRetVar = parseAndCheckMethod.body().decl(itemValueListClass, "ret", typeClass.staticInvoke("parseValue").arg(parseAndCheckTmpVar).arg(parseAndCheckMethodFileVar));
				//Check value-based facets
				parseAndCheckMethod.body().add(typeClass.staticInvoke("checkValueBasedFacets").arg(parseAndCheckMethodRetVar));

				//parseAndCheckValue End
				parseAndCheckMethod.body()._return(parseAndCheckMethodRetVar);

				//parseValue Begin
				JMethod parseMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, itemValueListClass, "parseValue");
				parseMethod._throws(ParseException.class);
				JVar parseMethodValueVar = parseMethod.param(String.class, "value");
				JVar parseMethodFileVar = parseMethod.param(XmlFile.class, "file");

				JVar parseMethodTmpSplitVar = parseMethod.body().decl(JMod.FINAL, codeModel.ref(Pattern.class), "splitPattern", JExpr.direct("Pattern.compile(\"([^ ]*)[ ]+\")"));
				JVar parseMethodRetVar = parseMethod.body().decl(itemValueListClass, "ret", JExpr._new(itemValueListClass));
				JVar parseMethodMatcherVar = parseMethod.body().decl(codeModel.ref(Matcher.class), "matcher", parseMethodTmpSplitVar.invoke("matcher").arg(parseMethodValueVar));
				JWhileLoop parseMethodWhileLoop = parseMethod.body()._while(parseMethodMatcherVar.invoke("find"));
				parseMethodWhileLoop.body().add(parseMethodRetVar.invoke("add").arg(itemTypeClass.staticInvoke("parseAndCheckValue").arg(parseMethodMatcherVar.invoke("group").arg(JExpr.lit(1))).arg(parseMethodFileVar)));
				
				//parseValue End
				parseMethod.body()._return(parseMethodRetVar);

				//applyLexicalFacets Begin
				JMethod applyLexicalFacetsMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.ref(String.class), "applyLexicalFacets");
				applyLexicalFacetsMethod._throws(ParseException.class);
				JVar applyLexicalFacetsMethodValueVar = applyLexicalFacetsMethod.param(String.class, "value");
				JVar applyLexicalFacetsMethodFileVar = applyLexicalFacetsMethod.param(XmlFile.class, "file");

				//Apply pre-lexical and lexical facets of own type
				JVar applyLexicalFacetsMethodTmpVar = applyLexicalFacetsMethod.body().decl(codeModel.ref(String.class), "tmp", JExpr.direct("normalize(value, true, file).trim().replaceAll(\"[ ]+\", \" \")"));

				JConditional applyLexicalFacetsMethodIf = applyLexicalFacetsMethod.body()._if(JExpr.direct("!RESTRICTION_PATTERN.matcher(tmp).matches()"));
				applyLexicalFacetsMethodIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value does not match restriction: ").plus(applyLexicalFacetsMethodValueVar)));
				//applyLexicalFacets End
				applyLexicalFacetsMethod.body()._return(applyLexicalFacetsMethodTmpVar);

				//checkValueBasedFacets Begin
				JMethod checkValueBasedFacetsMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.VOID, "checkValueBasedFacets");
				JVar checkValueBasedFacetsMethodValueVar = checkValueBasedFacetsMethod.param(itemValueListClass, "value");

				//Nothing

				//checkValueBasedFacets End

			}else if(XmlUnion.class.equals(simpleDerivation.getClass())){
				XmlUnion union = (XmlUnion) simpleDerivation;

				Set<JType> memberTypesValueClasses = new HashSet<JType>();
				Set<Xml.XmlQName> memberTypesSet = new HashSet<Xml.XmlQName>();
				boolean allMemberyHaveTypeVarietyList = true;
				XmlListQName memberTypes = (XmlListQName) union.getAttribute("memberTypes");
				if(memberTypes != null){
					for(String memberTypeString : memberTypes.getValue()){
						Xml.XmlQName memberType = Xml.XmlQName.parseQName(memberTypeString, simpleType.getNamespaceMap());
						JClass memberClass = simpleTypeClassMap.get(memberType);
						if(JDefinedClass.class.isAssignableFrom(memberClass.getClass())){
							memberTypesValueClasses.add(((JDefinedClass) memberClass).fields().get("value").type());
						}else{
							Class<?> tmpClass = codeModelClassToJavaClass(memberClass).getDeclaredField("value").getType();
							if(tmpClass.isPrimitive()){
								memberTypesValueClasses.add(codeModel.ref(getPrimitiveWrapperType(tmpClass)).unboxify());
							}else{
								memberTypesValueClasses.add(codeModel.ref(tmpClass));
							}
						}
						memberTypesSet.add(memberType);
						if(allMemberyHaveTypeVarietyList && !typeVarietyIsListSet.contains(memberType)){
							allMemberyHaveTypeVarietyList = false;
						}
					}
				}
				XmlLocalSimpleType[] localSimpleTypes = union.getSimpleTypes();
				if(localSimpleTypes != null){
					for(int i=0;i<localSimpleTypes.length;++i){
						Xml.XmlQName memberType = new Xml.XmlQName(union.qualifiedName.namespace, union.qualifiedName.name+"/memberType"+i);
						JDefinedClass memberTypeClass = codeModel.anonymousClass(Xml.XmlSimpleType.class);
						createSimpleType(memberType, localSimpleTypes[i], localSimpleTypes[i].getSimpleDerivation(), memberTypeClass, typeVarietyIsListSet, atomicBaseTypeMap, orderedIsPartialSet);
						memberTypesValueClasses.add(memberTypeClass.fields().get("value").type());
						memberTypesSet.add(memberType);
						if(allMemberyHaveTypeVarietyList && !typeVarietyIsListSet.contains(memberType)){
							allMemberyHaveTypeVarietyList = false;
						}
					}
				}

				boolean allMembersHaveSameClass = true;
				JType commonClass = memberTypesValueClasses.iterator().next();
				for(JType currentTypeClass : memberTypesValueClasses){
					if(!commonClass.equals(currentTypeClass)){
						allMembersHaveSameClass = false;
						break;
					}
				}
				boolean allMembersHaveSameAtomicBaseType = true;
				Xml.XmlQName commonAtomicBaseType = atomicBaseTypeMap.get(memberTypesSet.iterator().next());
				for(Xml.XmlQName currentMemberType : memberTypesSet){
					if(commonAtomicBaseType == null || !commonAtomicBaseType.equals(atomicBaseTypeMap.get(currentMemberType))){
						allMembersHaveSameAtomicBaseType = false;
						break;
					}
				}

				JType valueType;

				if(allMembersHaveSameClass){
					if(allMembersHaveSameAtomicBaseType){
						atomicBaseTypeMap.put(qualifiedName, commonAtomicBaseType);
						//parseValue of commonBasicType

					}else{

						//Parse value of any of the memberTypes

						orderedIsPartialSet.add(qualifiedName);
					}
					//Value of type commonClass
					valueType = commonClass;
					if(typeVarietyIsListSet.contains(memberTypesSet.iterator().next())){
						typeVarietyIsListSet.add(qualifiedName);
					}
				}else{
					orderedIsPartialSet.add(qualifiedName);
					if(allMembersHaveSameAtomicBaseType && allMemberyHaveTypeVarietyList){
						//Value of type String[]
						valueType = codeModel.ref(ArrayBigList.class).narrow(String.class);
						typeVarietyIsListSet.add(qualifiedName);
						//parseValue simple splits string
					}else{
						//Value of type String
						valueType = codeModel.ref(String.class);
						//Parse value simply returns string

					}
				}

				//parseAndCheck of all memberTypes. If none returns true, than throw exception

				//If values have same type and are not equal, throw exception
				//Otherwise use that value.

				//parseAndCheck of lowest Common subtype

				JFieldVar valueField = typeClass.field(JMod.PROTECTED | JMod.FINAL, valueType, "value");
				
				JClass wrapperType = null;
				JPrimitiveType primitiveType = null;
				String parseAndCheckValueName = "parseAndCheckValue";
				String parseValueName = "parseValue";
				String checkValueBasedFacetsName = "checkValueBasedFacets";
				String getValueName = "getValue";
				if(valueType.isPrimitive()){
					wrapperType = codeModel.ref(getPrimitiveWrapperType(codeModelClassToJavaClass(valueType)));
					primitiveType = wrapperType.getPrimitiveType();
					
					JMethod getMethod = typeClass.method(JMod.PUBLIC, wrapperType, "getValue");
					getMethod.annotate(Override.class);
					getMethod.body()._return(wrapperType.staticInvoke("valueOf").arg(valueField));
					
					parseAndCheckValueName = "parseAndCheckValuePrimitive";
					parseValueName = "parseValuePrimitive";
					checkValueBasedFacetsName = "checkValueBasedFacetsPrimitive";
					getValueName = "getValuePrimitive";
				}

				JMethod getMethod = typeClass.method(JMod.PUBLIC, valueType, getValueName);
				if(!valueType.isPrimitive()){
					getMethod.annotate(Override.class);
				}
				getMethod.body()._return(valueField);

				JMethod constructorMethod = typeClass.constructor(JMod.PUBLIC);
				constructorMethod._throws(ParseException.class);
				JVar constructorAttrVar = constructorMethod.param(Xml.XmlSimpleType.class, "attr");
				JVar constructorValueVar = constructorMethod.param(String.class, "value");
				JInvocation constructorSuperInvocation = constructorMethod.body().invoke("super");
				constructorSuperInvocation.arg(constructorAttrVar);
				JInvocation constructorParseValueInvocation = typeClass.staticInvoke(parseAndCheckValueName);
				constructorParseValueInvocation.arg(constructorValueVar);
				constructorParseValueInvocation.arg(JExpr._this().ref("file"));
				constructorMethod.body().assign(JExpr._this().ref("value"), constructorParseValueInvocation);

				if(valueType.isPrimitive()){
					JMethod parseAndCheckMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, wrapperType, "parseAndCheckValue");
					parseAndCheckMethod._throws(ParseException.class);
					JVar parseAndCheckMethodValueVar = parseAndCheckMethod.param(String.class, "value");
					JVar parseAndCheckMethodFileVar = parseAndCheckMethod.param(XmlFile.class, "file");
					
					parseAndCheckMethod.body()._return(wrapperType.staticInvoke("valueOf").arg(JExpr.invoke("parseAndCheckValuePrimitive").arg(parseAndCheckMethodValueVar).arg(parseAndCheckMethodFileVar)));
				}
				
				//parseAndCheckValue Begin
				JMethod parseAndCheckMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, valueType, "parseAndCheckValue");
				parseAndCheckMethod._throws(ParseException.class);
				JVar parseAndCheckMethodValueVar = parseAndCheckMethod.param(String.class, "value");
				JVar parseAndCheckMethodFileVar = parseAndCheckMethod.param(XmlFile.class, "file");

				//Call parseAndCheck for all member types. If one succeeds without error, appliy its lexical facets and parse the value with the local function
				JVar parseAndCheckTmpVar = parseAndCheckMethod.body().decl(codeModel.ref(String.class), "tmp", JExpr.direct("null"));
				JVar parseAndCheckCouldParseVar = parseAndCheckMethod.body().decl(codeModel.BOOLEAN, "couldParse", JExpr.lit(false));
				for(Xml.XmlQName currentMemberType : memberTypesSet){
					JConditional parseAndCheckMethodIf = parseAndCheckMethod.body()._if(JExpr.direct("!couldParse"));
					JTryBlock parseAndCheckMethodTry = parseAndCheckMethodIf._then()._try();
					parseAndCheckMethodTry.body().assign(parseAndCheckTmpVar, simpleTypeClassMap.get(currentMemberType).staticInvoke("applyLexicalFacets").arg(parseAndCheckMethodValueVar).arg(parseAndCheckMethodFileVar));
					parseAndCheckMethodTry.body().add(simpleTypeClassMap.get(currentMemberType).staticInvoke("checkValueBasedFacets").arg(simpleTypeClassMap.get(currentMemberType).staticInvoke("parseValue").arg(parseAndCheckTmpVar)));
					parseAndCheckMethodTry._catch(codeModel.ref(XmlValidationException.class));
				}


				JConditional parseAndCheckMethodIf = parseAndCheckMethod.body()._if(JExpr.direct("!couldParse"));
				parseAndCheckMethodIf._then()._throw(JExpr._new(codeModel.ref(XmlValidationException.class)).arg(JExpr.lit("Value could not be parsed: ").plus(parseAndCheckMethodValueVar)));

				//Parse value
				JVar parseAndCheckMethodRetVar;
				if(typeVarietyIsListSet.contains(qualifiedName)){
					parseAndCheckMethodRetVar = parseAndCheckMethod.body().decl(valueType, "ret", typeClass.staticInvoke(parseValueName).arg(parseAndCheckTmpVar).arg(parseAndCheckMethodFileVar));
				}else{
					parseAndCheckMethodRetVar = parseAndCheckMethod.body().decl(valueType, "ret", typeClass.staticInvoke(parseValueName).arg(parseAndCheckTmpVar));
				}

				//parseAndCheckValue End
				parseAndCheckMethod.body()._return(parseAndCheckMethodRetVar);

				if(valueType.isPrimitive()){
					JMethod parseMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, wrapperType, "parseValue");
					JVar parseMethodValueVar = parseMethod.param(String.class, "value");
					JVar parseMethodFileVar = null;
					if(typeVarietyIsListSet.contains(qualifiedName)){
						parseMethod._throws(ParseException.class);
						parseMethodFileVar = parseMethod.param(XmlFile.class, "file");
					}
					JVar parseMethodRetVar;
					boolean isList;
					if(allMembersHaveSameClass){
						if(allMembersHaveSameAtomicBaseType){
							//parseValue of commonBasicType
							if(typeVarietyIsListSet.contains(commonAtomicBaseType)){
								isList = true;
							}else{
								isList = false;
							}
						}else{
							//Parse value of any of the memberTypes
							if(typeVarietyIsListSet.contains(memberTypesSet.iterator().next())){
								isList = true;
							}else{
								isList = false;
							}
						}
					}else{
						if(allMembersHaveSameAtomicBaseType && allMemberyHaveTypeVarietyList){
							//parseValue simple splits string
							isList = true;
						}else{
							//Parse value simply returns string
							isList = false;
						}
					}
					if(isList){
						parseMethodRetVar = parseMethod.body().decl(wrapperType, "ret", wrapperType.staticInvoke("valueOf").arg(JExpr.invoke("parseValuePrimitive").arg(parseMethodValueVar).arg(parseMethodFileVar)));
					}else{
						parseMethodRetVar = parseMethod.body().decl(wrapperType, "ret", wrapperType.staticInvoke("valueOf").arg(JExpr.invoke("parseValuePrimitive").arg(parseMethodValueVar)));
					}

					parseMethod.body()._return(parseMethodRetVar);
				}
				
				//parseValue Begin
				JMethod parseMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, valueType, parseValueName);
				JVar parseMethodValueVar = parseMethod.param(String.class, "value");
				JVar parseMethodFileVar = null;
				if(typeVarietyIsListSet.contains(qualifiedName)){
					parseMethod._throws(ParseException.class);
					parseMethodFileVar = parseMethod.param(XmlFile.class, "file");
				}
				
				JVar parseMethodRetVar = parseMethod.body().decl(valueType, "ret");
				if(allMembersHaveSameClass){
					if(allMembersHaveSameAtomicBaseType){
						//parseValue of commonBasicType
						if(typeVarietyIsListSet.contains(commonAtomicBaseType)){
							parseMethod.body().assign(parseMethodRetVar, simpleTypeClassMap.get(commonAtomicBaseType).staticInvoke(parseValueName).arg(parseMethodValueVar).arg(parseMethodFileVar));
						}else{
							parseMethod.body().assign(parseMethodRetVar, simpleTypeClassMap.get(commonAtomicBaseType).staticInvoke(parseValueName).arg(parseMethodValueVar));
						}
					}else{
						//Parse value of any of the memberTypes
						if(typeVarietyIsListSet.contains(memberTypesSet.iterator().next())){
							parseMethod.body().assign(parseMethodRetVar, simpleTypeClassMap.get(memberTypesSet.iterator().next()).staticInvoke(parseValueName).arg(parseMethodValueVar).arg(parseMethodFileVar));
						}else{
							parseMethod.body().assign(parseMethodRetVar, simpleTypeClassMap.get(memberTypesSet.iterator().next()).staticInvoke(parseValueName).arg(parseMethodValueVar));
						}
					}
				}else{
					if(allMembersHaveSameAtomicBaseType && allMemberyHaveTypeVarietyList){
						//parseValue simple splits string
						parseMethod.body().assign(parseMethodRetVar, JExpr.direct("value.split(\"[ ]+\")"));
					}else{
						//Parse value simply returns string
						parseMethod.body().assign(parseMethodRetVar, parseMethodValueVar);
					}
				}

				//parseValue End
				parseMethod.body()._return(parseMethodRetVar);

				//applyLexicalFacets Begin
				JMethod applyLexicalFacetsMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.ref(String.class), "applyLexicalFacets");
				applyLexicalFacetsMethod._throws(ParseException.class);
				JVar applyLexicalFacetsMethodValueVar = applyLexicalFacetsMethod.param(String.class, "value");
				JVar applyLexicalFacetsMethodFileVar = applyLexicalFacetsMethod.param(XmlFile.class, "file");

				//Nothing. They cannot be applied, cause they might not be the same for all member types

				//applyLexicalFacets End
				applyLexicalFacetsMethod.body()._return(applyLexicalFacetsMethodValueVar);

				if(valueType.isPrimitive()){
					JMethod checkValueBasedFacetsMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.VOID, "checkValueBasedFacets");
					JVar checkValueBasedFacetsMethodValueVar = checkValueBasedFacetsMethod.param(wrapperType, "value");
					checkValueBasedFacetsMethod.body().invoke("checkValueBasedFacetsPrimitive").arg(primitiveType.unwrap(checkValueBasedFacetsMethodValueVar));
				}
				
				//checkValueBasedFacets Begin
				JMethod checkValueBasedFacetsMethod = typeClass.method(JMod.PUBLIC | JMod.STATIC, codeModel.VOID, checkValueBasedFacetsName);
				JVar checkValueBasedFacetsMethodValueVar = checkValueBasedFacetsMethod.param(valueType, "value");

				//Nothing. They cannot be checked, cause they might not be the same for all member types

				//checkValueBasedFacets End

			}else{
				throw new AssertionError("Reached unreachable state!");
			}

			simpleTypeImplemented.add(qualifiedName);
		}
	}
	
	public JExpression parseXPathToJavaExpression(String value){
		return JExpr.direct("XmlXPath.XmlXPathEvaluator.expressionEvaluatesToTrue("+value+", value");
	}
	
	private static Set<Class<?>> getAllAssignable(Class<?> currentClass){
		Set<Class<?>> assignable = new HashSet<Class<?>>();
		Queue<Class<?>> queue = new ArrayDeque<Class<?>>();
		queue.add(currentClass);
		while(queue.size() > 0){
			Class<?> current = queue.poll();
			assignable.add(current);
			queue.addAll(Arrays.asList(current.getInterfaces()));
			queue.add(current.getSuperclass());
		}
		return assignable;
	}
	
	private static String generateVariableName(String source, Set<String> usedNames){
		final Pattern firstCharPattern = Pattern.compile("\\A([^\\p{L}]).*");
		final Pattern generatePattern = Pattern.compile("(\\W.|_.)");
		String in = source;
		if(firstCharPattern.matcher(in).matches()){
			in = in.substring(1);
		}
		in = in.substring(0, 1).toLowerCase()+(in.length()>1?in.substring(1):"");
		StringBuffer ret = new StringBuffer();
		Matcher m = generatePattern.matcher(in);
		while (m.find()) {
		    m.appendReplacement(ret, m.group(1).toUpperCase());
		}
		m.appendTail(ret);
		String tmp = ret.toString().replaceAll("(\\W|_)", "");
		if(!SourceVersion.isName(tmp)){
			tmp += "Value";
		}
		long index = 0;
		while(usedNames.contains(tmp)){
			index++;
			tmp = tmp+index;
		}
		return tmp;
	}
	
	private static String generateClassname(String source, JPackage parentPackage){
		final Pattern generatePattern = Pattern.compile("((?<=\\A).|_.|/.|\\Q-\\E.|\\Q.\\E.)");
		StringBuffer ret = new StringBuffer();
		Matcher m = generatePattern.matcher(source);
		while (m.find()) {
		    m.appendReplacement(ret, m.group(1).toUpperCase());
		}
		m.appendTail(ret);
		String tmp = ret.toString().replaceAll("(_|/|\\Q-\\E|\\Q.\\E)", "");
		long index = 0;
		while(parentPackage.isDefined(tmp)){
			index++;
			tmp = tmp+index;
		}
		return tmp;
	}
	
	private static String intersectRegex(String reg1, String reg2){
		if(reg1 == null && reg2 == null){
			return null;
		}else if(reg1 == null || "".equals(reg1)){
			return reg2;
		}else if(reg2 == null || "".equals(reg2)){
			return reg1;
		}else{
			return "(?="+reg1+")"+reg2;
		}
	}
	/*XML-Regex-Definition(https://www.w3.org/TR/xmlschema11-2/#dt-regex):
	 * regExp = branch ('|' branch)*
	 *  branch = piece*
	 *   piece = atom quantifier?
	 *    quantifier = [?*+] | ('{' quantity '}'
	 *     quantity = quantRange | quantMin | QuantExact
	 *      quantRange = QuantExact ',' QuantExact
	 *      quantMin = QuantExact ','
	 *      QuantExact = [0-9]+
	 *    atom = NormalChar | charClass | ( '(' regExp ')' )
	 *     NormalChar = [^.\?*+{}()|#x5B#x5D]
	 *     charClass = SingleCharEsc | charClassEsc | charClassExpr | WildcardEsc
	 *      charClassExpr = '[' charGroup ']'
	 *       charGroup = ( posCharGroup | negCharGroup ) ( '-' charClassExpr )?
	 *        posCharGroup = ( charGroupPart )+
	 *        negCharGroup = '^' posCharGroup
	 *         charGroupPart = singleChar | charRange | charClassEsc
	 *          singleChar = SingleCharEsc | SingleCharNoEsc
	 *          charRange = singleChar '-' singleChar
	 *           SingleCharNoEsc = [^\#x5B#x5D]
	 *      charClassEsc = MultiCharEsc | catEsc | complEsc
	 *      SingleCharEsc = '\' [nrt\|.?*+(){}#x2D#x5B#x5D#x5E]
	 *       catEsc = '\p{' charProp '}'
	 *       complEsc = '\P{' charProp '}'
	 *        charProp = IsCategory | IsBlock
	 *         IsCategory = 'L' [ultmo]? | 'M' [nce]? | 'N' [dlo]? | 'P' [cdseifo]? | 'Z' [slp]? | 'S' [mcko]? | 'C' [cfon]?
	 *         IsBlock = 'Is' [a-zA-Z0-9#x2D]+
	 *       MultiCharEsc = '\' [sSiIcCdDwW]
	 *      WildcardEsc = '.'
	 * Note: As of this publication the Java regex library does not include Cn in its definition of C, so that definition cannot be used without modification in conformant implementations.
	 * ^^It does in Java 13.
	 * 
	 * 
	 */
	private static String xmlRegexToJavaRegex(String xmlRegex){
		String ret = xmlRegex;
		ret = ret.replaceAll("(?<=\\\\(?:p|P)\\{)(Is)(?=[a-zA-Z0-9#x2D]+\\})", "In");
		//Redefine Character classes
		ret = ret.replaceAll("(?<!\\\\)\\.", "[^\\\\u000A\\\\u000D]");
		ret = ret.replaceAll("\\\\s", "[\\\\u0020\\\\u0009\\\\u000A\\\\u000D]");
		ret = ret.replaceAll("\\\\S", "[^[\\\\u0020\\\\u0009\\\\u000A\\\\u000D]]");
		ret = ret.replaceAll("\\\\i", "(?:\\\\\\\\: | [A-Z] | _ | [a-z] | [\\\\u00C0-\\\\u00D6] | [\\\\u00D8-\\\\u00F6] | [\\\\u00F8-\\\\u02FF] | [\\\\u0370-\\\\u037D] | [\\\\u037F-\\\\u1FFF] | [\\\\u200C-\\\\u200D] | [\\\\u2070-\\\\u218F] | [\\\\u2C00-\\\\u2FEF] | [\\\\u3001-\\\\uD7FF] | [\\\\uF900-\\\\uFDCF] | [\\\\uFDF0-\\\\uFFFD] | [\\\\u10000-\\\\uEFFFF])");
		ret = ret.replaceAll("\\\\I", "[^\\\\\\\\: | [A-Z] | _ | [a-z] | [\\\\u00C0-\\\\u00D6] | [\\\\u00D8-\\\\u00F6] | [\\\\u00F8-\\\\u02FF] | [\\\\u0370-\\\\u037D] | [\\\\u037F-\\\\u1FFF] | [\\\\u200C-\\\\u200D] | [\\\\u2070-\\\\u218F] | [\\\\u2C00-\\\\u2FEF] | [\\\\u3001-\\\\uD7FF] | [\\\\uF900-\\\\uFDCF] | [\\\\uFDF0-\\\\uFFFD] | [\\\\u10000-\\\\uEFFFF]]");
		ret = ret.replaceAll("\\\\c", "(?:\\\\\\\\: | [A-Z] | _ | [a-z] | [\\\\u00C0-\\\\u00D6] | [\\\\u00D8-\\\\u00F6] | [\\\\u00F8-\\\\u02FF] | [\\\\u0370-\\\\u037D] | [\\\\u037F-\\\\u1FFF] | [\\\\u200C-\\\\u200D] | [\\\\u2070-\\\\u218F] | [\\\\u2C00-\\\\u2FEF] | [\\\\u3001-\\\\uD7FF] | [\\\\uF900-\\\\uFDCF] | [\\\\uFDF0-\\\\uFFFD] | [\\\\u10000-\\\\uEFFFF] | \\\\\\\\Q-\\\\\\\\E | \\\\\\\\. | [0-9] |\\\\u00B7 | [\\\\u0300-\\\\u036F] | [\\\\u203F-\\\\u2040])");
		ret = ret.replaceAll("\\\\C", "[^\\\\\\\\: | [A-Z] | _ | [a-z] | [\\\\u00C0-\\\\u00D6] | [\\\\u00D8-\\\\u00F6] | [\\\\u00F8-\\\\u02FF] | [\\\\u0370-\\\\u037D] | [\\\\u037F-\\\\u1FFF] | [\\\\u200C-\\\\u200D] | [\\\\u2070-\\\\u218F] | [\\\\u2C00-\\\\u2FEF] | [\\\\u3001-\\\\uD7FF] | [\\\\uF900-\\\\uFDCF] | [\\\\uFDF0-\\\\uFFFD] | [\\\\u10000-\\\\uEFFFF] | \\\\\\\\Q-\\\\\\\\E | \\\\\\\\. | [0-9] |\\\\u00B7 | [\\\\u0300-\\\\u036F] | [\\\\u203F-\\\\u2040]]");
		ret = ret.replaceAll("\\\\w", "(?:[\\\\u0000-\\\\u10FFFF]-[\\\\\\\\p{P}\\\\\\\\p{Z}\\\\\\\\p{C}])");
		ret = ret.replaceAll("\\\\W", "[^[\\\\u0000-\\\\u10FFFF]-[\\\\\\\\p{P}\\\\\\\\p{Z}\\\\\\\\p{C}]]");
		ret = ret.replaceAll("\\\\", "\\\\\\\\");
		return ret;
	}
	/* Selector = Path ( '|' Path)*
	 *  Path = ('.//')? ( Step '/' )* ( Step | '@' NameTest )
	 *   Step = '.' | NameTest
	 *    NameTest = QName | '*' | NCName ':' '*'
	 *     QName = PrefixedName | UnprefixedName
	 *     NCName = See Docu
	 *      PrefixedName = Prefix ':' LocalPart
	 *      UnprefixedName = LocalPart
	 *       Prefix = NCName
	 *       LocalPart = NCNAme
	 *
	 * token = '.' | '/' | '//' | '|' | '@' | NameTest
	 * whitespace = (#x20 | #x9 | #xD | #xA)+
	 * 
	 */
	private static String xpathToPath(String xpath){
		final String whitespacePatternString = "[\\u0020\\u0009\\u000A\\u000D]";
		final String ncNamePatternString = XmlNCName.NCNAME_PATTERN_STRING;
		final String qnamePatternString = "(?:(?:"+ncNamePatternString+"[:])?"+ncNamePatternString+")";
		final String nameTestPatternString = "(?:"+whitespacePatternString+"*(?:"+qnamePatternString+"|\\*|"+ncNamePatternString+"[:]\\*)"+whitespacePatternString+"*)";
		final String stepPatternString = "(?:"+whitespacePatternString+"*\\."+whitespacePatternString+"*|"+nameTestPatternString+")";
		final String pathPatternString = 
				"(?:"
					+ "("+whitespacePatternString+"*\\."+whitespacePatternString+"*//"+whitespacePatternString+"*)?"
					+ "((?:"+stepPatternString+whitespacePatternString+"*/"+whitespacePatternString+"*)*"
					+ "(?:"+stepPatternString+"|"+whitespacePatternString+"*@"+nameTestPatternString+"))"
				+ ")";
		final String selectorPatternString = "(?:"+pathPatternString+"(?:"+whitespacePatternString+"*\\|"+whitespacePatternString+"*"+pathPatternString+")*)";
		final Pattern selectorPattern = Pattern.compile(selectorPatternString);
		final Pattern pathPattern = Pattern.compile(pathPatternString);
		Matcher selectorMatcher = selectorPattern.matcher(xpath);
		if(!selectorMatcher.matches()){
			throw new XmlValidationException("Given invalid XPath: "+xpath);
		}
		/*
		String[] pathes = xpath.replaceAll(whitespacePatternString, "").split("\\|");
		StringBuilder resultBuilder = new StringBuilder();
		for(int i=0;i<pathes.length;++i){
			Matcher pathMatcher = pathPattern.matcher(pathes[i]);
			if(pathMatcher.matches()){
				String descendantOrSelfString = pathMatcher.group(1);
				String stepsString = pathMatcher.group(2);
				
				if(descendantOrSelfString != null){
					resultBuilder.append("::descendant-or-self/");
				}
				resultBuilder.append(stepsString);
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
			resultBuilder.append('|');
		}
		
		return resultBuilder.substring(0, resultBuilder.length()-1);
		*/
		return xpath.replaceAll(whitespacePatternString, "").replaceAll("\\.//", "::descendant-or-self/");
	}
	
	private static String reverseSelectorPath(String path, Xml.XmlQName rootQualifiedName){
		final String ncNamePatternString = XmlNCName.NCNAME_PATTERN_STRING;
		final String qnamePatternString = "(?:(?:"+ncNamePatternString+"[:])?"+ncNamePatternString+")";
		final String nameTestPatternString = "(?:(?:"+qnamePatternString+"|\\*|"+ncNamePatternString+"[:]\\*))";
		final String stepPatternString = "(?:\\.|"+nameTestPatternString+")";
		final String pathPatternString = 
				"(?:"
					+ "(::descendant-or-self/)?"
					+ "((?:"+stepPatternString+"/)*"
					+ "(?:"+stepPatternString+"|@"+nameTestPatternString+"))"
				+ ")";
		final String selectorPatternString = "(?:"+pathPatternString+"(?:\\|"+pathPatternString+")*)";
		final Pattern selectorPattern = Pattern.compile(selectorPatternString);
		final Pattern pathPattern = Pattern.compile(pathPatternString);
		Matcher selectorMatcher = selectorPattern.matcher(path);
		if(!selectorMatcher.matches()){
			throw new XmlValidationException("Given invalid Path: "+path);
		}
		String[] pathes = path.split("\\|");
		StringBuilder resultBuilder = new StringBuilder();
		for(int i=0;i<pathes.length;++i){
			Matcher pathMatcher = pathPattern.matcher(pathes[i]);
			if(pathMatcher.matches()){
				String descendantOrSelfString = pathMatcher.group(1);
				String stepsString = pathMatcher.group(2);
				
				String[] steps = stepsString.split("/");
				int forLoopStart;
				if(steps[steps.length-1].startsWith("@")){
					resultBuilder.append(".[:name="+steps[steps.length-1].substring(1)+"]/../");
					forLoopStart = steps.length-2;
				}else{
					forLoopStart = steps.length-1;
				}
				for(int j=forLoopStart;j>=0;j--){//Starting at the end of the array!
					if(!".".equals(steps[j])){
						resultBuilder.append(".[:name="+steps[j]+"]/../");
					}
				}
				if(descendantOrSelfString != null){
					resultBuilder.append("::ancestor-or-self/");
				}
				resultBuilder.append(".[:type={"+(rootQualifiedName.namespace == null?"null":rootQualifiedName.namespace.toString().replaceAll("%", "%25").replaceAll("/", "%2F"))+", "+rootQualifiedName.name+"}]");
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
			resultBuilder.append('|');
		}
		
		return resultBuilder.substring(0, resultBuilder.length()-1);
	}
	
	private JClass[] getElementClassesByPath(Xml.XmlQName rootQualifiedName, String path){
		final String ncNamePatternString = XmlNCName.NCNAME_PATTERN_STRING;
		final String qnamePatternString = "(?:(?:"+ncNamePatternString+"[:])?"+ncNamePatternString+")";
		final String nameTestPatternString = "(?:(?:"+qnamePatternString+"|\\*|"+ncNamePatternString+"[:]\\*))";
		final String stepPatternString = "(?:\\.|"+nameTestPatternString+")";
		final String pathPatternString = 
				"(?:"
					+ "(::descendant-or-self/)?"
					+ "((?:"+stepPatternString+"/)*"
					+ "(?:"+stepPatternString+"|@"+nameTestPatternString+"))"
				+ ")";
		final String selectorPatternString = "(?:"+pathPatternString+"(?:\\|"+pathPatternString+")*)";
		final Pattern selectorPattern = Pattern.compile(selectorPatternString);
		final Pattern pathPattern = Pattern.compile(pathPatternString);
		Matcher selectorMatcher = selectorPattern.matcher(path);
		if(!selectorMatcher.matches()){
			throw new XmlValidationException("Given invalid Path: "+path);
		}
		String[] pathes = path.split("\\|");
		Set<Xml.XmlQName> retList = new HashSet<Xml.XmlQName>();
		for(int i=0;i<pathes.length;++i){
			Matcher pathMatcher = pathPattern.matcher(pathes[i]);
			if(pathMatcher.matches()){
				String descendantOrSelfString = pathMatcher.group(1);
				String stepsString = pathMatcher.group(2);
				
				Queue<Xml.XmlQName> rootQueue = new ArrayDeque<Xml.XmlQName>();
				rootQueue.add(rootQualifiedName);
				
				if(descendantOrSelfString != null){
					Queue<Xml.XmlQName> descendantQueue = new ArrayDeque<Xml.XmlQName>();
					descendantQueue.add(rootQualifiedName);	
					while(descendantQueue.size() > 0){
						Xml.XmlQName currentDescendant = descendantQueue.poll();	
						if(complexTypeClassMap.containsKey(currentDescendant)){
							GroupWrapper groupWrapper = complexTypeGroupWrapperMap.get(currentDescendant);
							if(groupWrapper != null){
								for(int j=0;j<groupWrapper.elementNames.length;++j){
									if(!rootQueue.contains(groupWrapper.elementTypes[j])){
										rootQueue.add(groupWrapper.elementTypes[j]);
										descendantQueue.add(groupWrapper.elementTypes[j]);
									}
								}
							}
						}
					}
				}
				
				String[] steps = stepsString.split("/");
				for(int j=0;j<steps.length;++j){
					Set<Xml.XmlQName> newRootQueue = new HashSet<Xml.XmlQName>();
					while(rootQueue.size() > 0){
						Xml.XmlQName currentRoot = rootQueue.poll();
						if(".".equals(steps[j])){
							newRootQueue.add(currentRoot);
						}else{
							GroupWrapper groupWrapper = complexTypeGroupWrapperMap.get(currentRoot);
							String nameTest = steps[j];
							if(groupWrapper != null){
								Xml.XmlQName identifierQName = null;
								URI identifierNamespace = null;
								if("*".equals(nameTest)){
									identifierQName = null;
									identifierNamespace = null;
								}else{
									Map<String, URI> namespaceMap = typeNamespaceMap.get(currentRoot);
									String namePart;
									URI namespace;
									if(nameTest.contains(":")){
										String[] valueParts = nameTest.split(":");
										if(valueParts.length != 2){
											throw new IllegalArgumentException("Given value cannot be parsed as QName: "+nameTest);
										}else{
											namePart = valueParts[1];
											namespace = namespaceMap.get(valueParts[0]);
										}
									}else{
										namePart = nameTest;
										namespace = namespaceMap.get("");
									}
									if("*".equals(namePart)){
										identifierQName = null;
										identifierNamespace = namespace;
									}else{
										identifierQName = Xml.XmlQName.parseQName(nameTest, namespaceMap);
										identifierNamespace = identifierQName.namespace;
									}
								}
								if(identifierQName != null){
									for(int k=0;k<groupWrapper.elementNames.length;++k){
										if(identifierQName.equals(groupWrapper.elementNames[k])){
											newRootQueue.add(groupWrapper.elementTypes[k]);
										}
									}
								}else if(identifierNamespace != null){
									for(int k=0;k<groupWrapper.elementNames.length;++k){
										if(identifierNamespace.equals(groupWrapper.elementNames[k].namespace)){
											newRootQueue.add(groupWrapper.elementTypes[k]);
										}
									}
								}else{
									for(int k=0;k<groupWrapper.elementNames.length;++k){
										newRootQueue.add(groupWrapper.elementTypes[k]);
									}
								}
							}
						}
					}
					rootQueue.addAll(newRootQueue);
				}
				retList.addAll(rootQueue);
			}else{
				throw new AssertionError("Reached unreachable state!");
			}
		}
		Set<JClass> retClassSet = new HashSet<JClass>();
		for(Xml.XmlQName qualifiedName : retList){
			Xml.XmlQName type = qualifiedName;
			ElementWrapper elementWrapper = elementWrapperMap.get(qualifiedName);
			if(elementWrapper != null){
				type = elementWrapper.type;
			}
			JClass tmp = complexTypeClassMap.get(type);
			if(tmp != null){
				retClassSet.add(tmp);
			}
		}
		return retClassSet.toArray(new JClass[0]);
	}
	
	private static boolean derivedFromString(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "string")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "normalizedString")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "token")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "derivationSet")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "fullDerivationSet")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "xpath")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "public")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "language")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "NMTOKEN")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "Name")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "simpleDerivationSet")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "formChoice")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "derivationControl")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "NCName")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "typeDerivationControl")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "ID")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "IDREF")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "ENTITY")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromBoolean(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "boolean")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromFloat(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "float")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromDouble(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "double")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromDecimal(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "decimal")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "integer")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "nonPositiveInteger")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "long")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "nonNegativeInteger")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "negativeInteger")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "int")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "unsignedLong")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "positiveInteger")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "short")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "unsignedInt")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "byte")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "unsignedShort")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "unsignedByte")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromDuration(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "duration")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromDateTime(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "dateTime")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromTime(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "time")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromDate(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "date")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromGYearMonth(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "gYearMonth")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromGYear(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "gYear")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromGMonthDay(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "gMonthDay")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromGDay(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "gDay")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromGMonth(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "gMonth")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromHexBinary(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "hexBinary")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromBase64Binary(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "base64Binary")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromAnyURI(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "anyURI")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromQName(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "QName")).equals(qualifiedName)
				);
	}
	
	private static boolean derivedFromNOTATION(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "NOTATION")).equals(qualifiedName)
				);
	}
	
	private static boolean predefinedOrderedIsPartial(Xml.XmlQName qualifiedName){
		return (
				(new Xml.XmlQName(xs, "allNNI")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "block")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "derivationSet")).equals(qualifiedName)||
				(new Xml.XmlQName(xs, "final")).equals(qualifiedName)
				);
	}
	
	private static void setPredefinedAttributeWrappers(Set<Xml.XmlQName> attributeImplemented, Map<Xml.XmlQName, AttributeWrapper> attributeWrapperMap){
		attributeImplemented.add(new Xml.XmlQName(xml, "lang"));
		attributeImplemented.add(new Xml.XmlQName(xml, "space"));
		attributeImplemented.add(new Xml.XmlQName(xml, "base"));
		attributeImplemented.add(new Xml.XmlQName(xml, "id"));
		attributeWrapperMap.put(new Xml.XmlQName(xml, "lang"), new AttributeWrapper("lang", new Xml.XmlQName(xs, "language"), null, "optional"));
		attributeWrapperMap.put(new Xml.XmlQName(xml, "space"), new AttributeWrapper("space", new Xml.XmlQName(xs, "space"), "preserve", "optional"));
		attributeWrapperMap.put(new Xml.XmlQName(xml, "base"), new AttributeWrapper("base", new Xml.XmlQName(xs, "anyURI"), null, "optional"));
		attributeWrapperMap.put(new Xml.XmlQName(xml, "id"), new AttributeWrapper("id", new Xml.XmlQName(xs, "ID"), null, "optional"));
	}
	
	private static AttributeGroupWrapper predefinedAttributeGroupWrapper(Xml.XmlQName qualifiedName){
		if((new Xml.XmlQName(xs, "occurs")).equals(qualifiedName)){
			return new AttributeGroupWrapper(new AttributeWrapper[]{
					new AttributeWrapper("minOccurs", new Xml.XmlQName(xs, "nonNegativeInteger"), "1", "optional"),
					new AttributeWrapper("maxOccurs", new Xml.XmlQName(xs, "allNNI"), "1", "optional")
			}, null, null);
		}else if((new Xml.XmlQName(xs, "defRef")).equals(qualifiedName)){
			return new AttributeGroupWrapper(new AttributeWrapper[]{
					new AttributeWrapper("name", new Xml.XmlQName(xs, "NCName"), null, "optional"),
					new AttributeWrapper("ref", new Xml.XmlQName(xs, "QName"), null, "optional")
			}, null, null);
		}else if((new Xml.XmlQName(xs, "anyAttrGroup")).equals(qualifiedName)){
			return new AttributeGroupWrapper(new AttributeWrapper[]{
					new AttributeWrapper("namespace", new Xml.XmlQName(xs, "namespaceList"), null, "optional"),
					new AttributeWrapper("notNamespace", new Xml.XmlQName(xs, "wildcard/basicNamespaceList"), null, "optional"),
					new AttributeWrapper("processContents", new Xml.XmlQName(xs, "wildcard/processContents"), "strict", "optional")
			}, null, null);
		}else if((new Xml.XmlQName(xs, "specialAttrs")).equals(qualifiedName)){
			return new AttributeGroupWrapper(new AttributeWrapper[]{
					new AttributeWrapper("lang", new Xml.XmlQName(xs, "language"), null, "optional"),
					new AttributeWrapper("space", new Xml.XmlQName(xs, "space"), "preserve", "optional"),
					new AttributeWrapper("base", new Xml.XmlQName(xs, "anyURI"), null, "optional")
			}, null, null);
		}else{
			return null;
		}
	}
	
	private static GroupWrapper predefinedGroupWrapper(Xml.XmlQName qualifiedName){
		if((new Xml.XmlQName(xs, "schemaTop")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "simpleType"), new Xml.XmlQName(xs, "complexType"), new Xml.XmlQName(xs, "group"), new Xml.XmlQName(xs, "attributeGroup"), new Xml.XmlQName(xs, "element"), new Xml.XmlQName(xs, "attribute"), new Xml.XmlQName(xs, "notation")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "topLevelSimpleType"), new Xml.XmlQName(xs, "topLevelComplexType"), new Xml.XmlQName(xs, "namedGroup"), new Xml.XmlQName(xs, "namedAttributeGroup"), new Xml.XmlQName(xs, "topLevelElement"), new Xml.XmlQName(xs, "topLevelAttribute"), new Xml.XmlQName(xs, "notation")},
					"(simpleType[ ]+|complexType[ ]+|group[ ]+|attributeGroup[ ]+)|element[ ]+|attribute[ ]+|notation[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "redefinable")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "simpleType"), new Xml.XmlQName(xs, "complexType"), new Xml.XmlQName(xs, "group"), new Xml.XmlQName(xs, "attributeGroup")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "topLevelSimpleType"), new Xml.XmlQName(xs, "topLevelComplexType"), new Xml.XmlQName(xs, "namedGroup"), new Xml.XmlQName(xs, "namedAttributeGroup")},
					"simpleType[ ]+|complexType[ ]+|group[ ]+|attributeGroup[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "typeDefParticle")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "group"), new Xml.XmlQName(xs, "all"), new Xml.XmlQName(xs, "choice"), new Xml.XmlQName(xs, "sequence")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "groupRef"), new Xml.XmlQName(xs, "all"), new Xml.XmlQName(xs, "explicitGroup"), new Xml.XmlQName(xs, "explicitGroup")},
					"group[ ]+|all[ ]+|choice[ ]+|sequence[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "nestedParticle")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "element"), new Xml.XmlQName(xs, "group"), new Xml.XmlQName(xs, "choice"), new Xml.XmlQName(xs, "sequence"), new Xml.XmlQName(xs, "any")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "localElement"), new Xml.XmlQName(xs, "groupRef"), new Xml.XmlQName(xs, "explicitGroup"), new Xml.XmlQName(xs, "explicitGroup"), new Xml.XmlQName(xs, "any")},
					"element[ ]+|group[ ]+|choice[ ]+|sequence[ ]+|any[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "particle")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "element"), new Xml.XmlQName(xs, "group"), new Xml.XmlQName(xs, "all"), new Xml.XmlQName(xs, "choice"), new Xml.XmlQName(xs, "sequence"), new Xml.XmlQName(xs, "any")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "localElement"), new Xml.XmlQName(xs, "groupRef"), new Xml.XmlQName(xs, "all"), new Xml.XmlQName(xs, "explicitGroup"), new Xml.XmlQName(xs, "explicitGroup"), new Xml.XmlQName(xs, "any")},
					"element[ ]+|group[ ]+|all[ ]+|choice[ ]+|sequence[ ]+|any[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "attrDecls")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "attribute"), new Xml.XmlQName(xs, "attributeGroup"), new Xml.XmlQName(xs, "anyAttribute")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "attribute"), new Xml.XmlQName(xs, "attributeGroupRef"), new Xml.XmlQName(xs, "wildcard")},
					"(attribute[ ]+|attributeGroup[ ]+)*(anyAttribute[ ]+)?)",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{new BigInteger("-1"), new BigInteger("-1"), BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "complexTypeModel")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "simpleContent"), new Xml.XmlQName(xs, "complexContent"), new Xml.XmlQName(xs, "openContent"), new Xml.XmlQName(xs, "group"), new Xml.XmlQName(xs, "all"), new Xml.XmlQName(xs, "choice"), new Xml.XmlQName(xs, "sequence"), new Xml.XmlQName(xs, "attribute"),new Xml.XmlQName(xs, "attributeGroup"), new Xml.XmlQName(xs, "anyAttribute"), new Xml.XmlQName(xs, "assert")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "simpleContent"), new Xml.XmlQName(xs, "complexContent"), new Xml.XmlQName(xs, "openContent"), new Xml.XmlQName(xs, "groupRef"), new Xml.XmlQName(xs, "all"), new Xml.XmlQName(xs, "explicitGroup"), new Xml.XmlQName(xs, "explicitGroup"), new Xml.XmlQName(xs, "attribute"),new Xml.XmlQName(xs, "attributeGroupRef"), new Xml.XmlQName(xs, "wildcard"), new Xml.XmlQName(xs, "assertion")},
					"simpleContent[ ]+|complexContent[ ]+|((openContent[ ]+)?(group[ ]+|all[ ]+|choice[ ]+|sequence[ ]+)?(attribute[ ]+|attributeGroup[ ]+)*(anyAttribute[ ]+)?(assert[ ]+)*)",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, new BigInteger("-1"), new BigInteger("-1"), BigInteger.ONE, new BigInteger("-1")},
					null
					);
		}else if((new Xml.XmlQName(xs, "allModel")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "annotation"), new Xml.XmlQName(xs, "element"), new Xml.XmlQName(xs, "any"), new Xml.XmlQName(xs, "group")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "annotation"), new Xml.XmlQName(xs, "localElement"), new Xml.XmlQName(xs, "any"), new Xml.XmlQName(xs, "groupRef")},
					"(annotation[ ]+)?(element[ ]+|any[ ]+|group[ ]+)*",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1")},
					null
					);
		}else if((new Xml.XmlQName(xs, "identityConstraint")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "unique"), new Xml.XmlQName(xs, "key"), new Xml.XmlQName(xs, "keyref")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "keybase"), new Xml.XmlQName(xs, "keybase"), new Xml.XmlQName(xs, "keyref")},
					"unique[ ]+|key[ ]+|keyref[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "simpleDerivation")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "restriction"), new Xml.XmlQName(xs, "list"), new Xml.XmlQName(xs, "union")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "restriction"), new Xml.XmlQName(xs, "list"), new Xml.XmlQName(xs, "union")},
					"restriction[ ]+|list[ ]+|union[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "facets")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "minExclusive"), new Xml.XmlQName(xs, "minInclusive"), new Xml.XmlQName(xs, "maxExclusive"), new Xml.XmlQName(xs, "maxInclusive"), new Xml.XmlQName(xs, "totalDigits"), new Xml.XmlQName(xs, "fractionDigits"), new Xml.XmlQName(xs, "length"), new Xml.XmlQName(xs, "minLength"), new Xml.XmlQName(xs, "maxLength"), new Xml.XmlQName(xs, "enumeration"), new Xml.XmlQName(xs, "whiteSpace"), new Xml.XmlQName(xs, "pattern")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet")},
					"minExclusive[ ]+|minInclusive[ ]+|maxExclusive[ ]+|maxInclusive[ ]+|totalDigits[ ]+|fractionDigits[ ]+|length[ ]+|minLength[ ]+|maxLength[ ]+|enumeration[ ]+|whiteSpace[ ]+|pattern[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "simpleRestrictionModel")).equals(qualifiedName)){
			ArrayBigList<String> tmp = new ArrayBigList<String>(1);
			tmp.add("##other");
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "simpleType"), new Xml.XmlQName(xs, "minExclusive"), new Xml.XmlQName(xs, "minInclusive"), new Xml.XmlQName(xs, "maxExclusive"), new Xml.XmlQName(xs, "maxInclusive"), new Xml.XmlQName(xs, "totalDigits"), new Xml.XmlQName(xs, "fractionDigits"), new Xml.XmlQName(xs, "length"), new Xml.XmlQName(xs, "minLength"), new Xml.XmlQName(xs, "maxLength"), new Xml.XmlQName(xs, "enumeration"), new Xml.XmlQName(xs, "whiteSpace"), new Xml.XmlQName(xs, "pattern")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "localSimpleType"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet"), new Xml.XmlQName(xs, "facet")},
					"(simpleType[ ]+)?(minExclusive[ ]+|minInclusive[ ]+|maxExclusive[ ]+|maxInclusive[ ]+|totalDigits[ ]+|fractionDigits[ ]+|length[ ]+|minLength[ ]+|maxLength[ ]+|enumeration[ ]+|whiteSpace[ ]+|pattern[ ]+)*",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1"), new BigInteger("-1")},
					tmp
					);
		}else if((new Xml.XmlQName(xs, "composition")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "include"), new Xml.XmlQName(xs, "import"), new Xml.XmlQName(xs, "redefine"), new Xml.XmlQName(xs, "override"), new Xml.XmlQName(xs, "annotation")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "include"), new Xml.XmlQName(xs, "import"), new Xml.XmlQName(xs, "redefine"), new Xml.XmlQName(xs, "override"), new Xml.XmlQName(xs, "annotation")},
					"include[ ]+|import[ ]+|redefine[ ]+|override[ ]+|annotation[ ]+",
					new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO},
					new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					null
					);
		}else if((new Xml.XmlQName(xs, "assertions")).equals(qualifiedName)){
			return new GroupWrapper(
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "assert")},
					new Xml.XmlQName[]{new Xml.XmlQName(xs, "assertion")},
					"assert[ ]+",
					new BigInteger[]{BigInteger.ZERO},
					new BigInteger[]{new BigInteger("-1")},
					null
					);
		}else{
			return null;
		}
	}
	
	private static BigInteger minValue(BigInteger... values){
		if(values == null){
			return null;
		}else{
			BigInteger min = null;
			for(int i=0;i<values.length;++i){
				if(min == null || BigInteger.ZERO.compareTo(min) > 0 || min.compareTo(values[i]) > 0){
					min = values[i];
				}
			}
			return min;
		}
	}
	
	private static BigInteger maxValue(BigInteger... values){
		if(values == null){
			return null;
		}else{
			BigInteger max = null;
			for(int i=0;i<values.length;++i){
				if(max == null || BigInteger.ZERO.compareTo(values[i]) > 0){
					max = values[i];
				}else if(BigInteger.ZERO.compareTo(max) <= 0){
					max = max.add(values[i]);
				}
			}
			return max;
		}
	}
	
	private static Class<?> codeModelClassToJavaClass(JType codeModelClass) throws ClassNotFoundException{
		if(codeModelClass.isPrimitive()){
			return getPrimitiveType(Class.forName(codeModelClass.boxify().fullName()));
		}else{
			String ret = codeModelClass.fullName().replace('/', '.').replaceAll("(\\A|\\G)(?=.*\\[\\])", "$1[").replaceAll("\\[\\](?!\\[\\])", ";").replaceAll("\\[\\]", "").replaceAll("<.*>", "");
			if(ret.contains("boolean;")){
				ret = ret.replaceAll("boolean;" , "Z");
			}else if(ret.contains("byte;")){
				ret = ret.replaceAll("byte;" , "B");
			}else if(ret.contains("short;")){
				ret = ret.replaceAll("short;" , "S");
			}else if(ret.contains("int;")){
				ret = ret.replaceAll("int;" , "I");
			}else if(ret.contains("long;")){
				ret = ret.replaceAll("long;" , "J");
			}else if(ret.contains("float;")){
				ret = ret.replaceAll("float;" , "F");
			}else if(ret.contains("double;")){
				ret = ret.replaceAll("double;" , "D");
			}else if(ret.contains("char;")){
				ret = ret.replaceAll("char;" , "C");
			}else{
				ret = ret.replaceAll("(\\[)(?!\\[)", "$1L");
			}
			return Class.forName(ret);
		}
	}
	
	public static boolean isPrimitiveWrapper(Class<?> type){
		return (
				Boolean.class.equals(type)||
				Byte.class.equals(type)||
				Short.class.equals(type)||
				Integer.class.equals(type)||
				Long.class.equals(type)||
				Float.class.equals(type)||
				Double.class.equals(type)||
				Character.class.equals(type)
				);
	}
	
	public static Class<?> getPrimitiveType(Class<?> type){
		if(Boolean.class.equals(type)){
			return Boolean.TYPE;
		}else if(Byte.class.equals(type)){
			return Byte.TYPE;
		}else if(Short.class.equals(type)){
			return Short.TYPE;
		}else if(Integer.class.equals(type)){
			return Integer.TYPE;
		}else if(Long.class.equals(type)){
			return Long.TYPE;
		}else if(Float.class.equals(type)){
			return Float.TYPE;
		}else if(Double.class.equals(type)){
			return Double.TYPE;
		}else if(Character.class.equals(type)){
			return Character.TYPE;
		}else{
			throw new IllegalArgumentException("Given type must be a Primitive-Wrapper class-type!");
		}
	}
	
	public static Class<?> getPrimitiveWrapperType(Class<?> type){
		if(Boolean.TYPE.equals(type)){
			return Boolean.class;
		}else if(Byte.TYPE.equals(type)){
			return Byte.class;
		}else if(Short.TYPE.equals(type)){
			return Short.class;
		}else if(Integer.TYPE.equals(type)){
			return Integer.class;
		}else if(Long.TYPE.equals(type)){
			return Long.class;
		}else if(Float.TYPE.equals(type)){
			return Float.class;
		}else if(Double.TYPE.equals(type)){
			return Double.class;
		}else if(Character.TYPE.equals(type)){
			return Character.class;
		}else{
			throw new IllegalArgumentException("Given type must be a Primitive-Wrapper class-type!");
		}
	}
	
	public static ArrayBigList<String> intersectNamespaces(ArrayBigList<String> space1, ArrayBigList<String> space2){
		if(space1 == null || space1.size().equals(BigInteger.ZERO)){
			return space2;
		}
		if(space2 == null || space2.size().equals(BigInteger.ZERO)){
			return space1;
		}
		space1 = new ArrayBigList<String>(space1);
		space2 = new ArrayBigList<String>(space2);
		if(space1.size().compareTo(space2.size()) == 0){
			boolean equal = true;
			for(String s1 : space1){
				if(!space2.contains(s1)){
					equal = false;
					break;
				}
			}
			if(equal){
				return space1;
			}
		}
		if((space1.size().equals(BigInteger.ONE) && "##any".equals(space1.get(0)))||(space2.size().equals(BigInteger.ONE) && "##any".equals(space2.get(0)))){
			ArrayBigList<String> ret = new ArrayBigList<String>(1);
			ret.add("##other");
			return ret;
		}
		if(space1.size().equals(BigInteger.TWO)&& space1.contains("not")){
			String removeValue;
			if("not".equals(space1.get(0))){
				removeValue = space1.get(1);
			}else{
				removeValue = space1.get(0);
			}
			space2.remove(removeValue);
			return space2;
		}
		if(space2.size().equals(BigInteger.TWO) && space2.contains("not")){
			String removeValue;
			if("not".equals(space2.get(0))){
				removeValue = space2.get(1);
			}else{
				removeValue = space2.get(0);
			}
			space1.remove(removeValue);
			return space1;
		}
		if(!(space1.contains("not")&&space2.contains("not"))){
			space1.retainAll(space2);
			return space1;
		}
		return null;//Intersection not expressible
	}
	
	private static XmlSchema loadFile(File schemaFile) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException, InterruptedException, ExecutionException, ParseException, URISyntaxException{
		XmlSchemaFile file = new XmlSchemaFile(schemaFile);
		file.setLoadSimpleTypeValues(true);
		XmlLoader loader = new XmlLoader(file);
		loader.extend(new XmlLoaderSchema(file));
		//Register XML Schema Loader, then create and load root.
		loader.file.index();
		XmlSchema root = file.getRoot();
		return root;
	}
	
	private static File downloadFile(URL url) throws IOException, URISyntaxException{
		File ret;
		if(isLocal(url)){
			ret = new File(url.toURI());
		}else{
			ret = File.createTempFile("schema",".xsd");
			ret.deleteOnExit();
			
			InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream(ret);
			
			int n;
			byte[] buffer = new byte[1024];
			while((n = in.read(buffer)) > -1) {
				out.write(buffer, 0, n);   // Don't allow any extra bytes to creep in, final write
			}
			out.close ();
		}
		return ret;
	}
	
	//Copied from: http://www.java2s.com/Code/Java/Network-Protocol/IsURLalocalfile.htm
	/** Whether the URL refers to a resource in the local file system. */
	  public static boolean isLocal(java.net.URL url) {
	    if(isLocalFile(url)) {
	      return true;
	    }
	    String protocol = url.getProtocol();
	    if("jar".equalsIgnoreCase(protocol)) {
	      String path = url.getPath();
	      int emIdx = path.lastIndexOf('!');
	      String subUrlString = emIdx == -1 ? path : path.substring(0, emIdx);
	      try {
	        URL subUrl = new URL(subUrlString);
	        return isLocal(subUrl);
	      } catch(java.net.MalformedURLException mfu) {
	        return false;
	      }
	    }
	    else {
	      return false;
	    }
	  }
	  
	  /** Whether the URL is a file in the local file system. */
	  public static boolean isLocalFile(java.net.URL url) {
	    String scheme = url.getProtocol();
	    return "file".equalsIgnoreCase(scheme) && !hasHost(url);
	  }

	  public static boolean hasHost(java.net.URL url) {
	    String host = url.getHost();
	    return host != null && !"".equals(host);
	  }

	private static class GroupWrapper{
		public final Xml.XmlQName[] elementNames;
		public final Xml.XmlQName[] elementTypes;
		public final String arrangementPattern;
		public final BigInteger[] minBounds;
		public final BigInteger[] maxBounds;
		public final ArrayBigList<String> anyNamespace;
		
		public GroupWrapper(Xml.XmlQName[] elementNames, Xml.XmlQName[] elementTypes, String arrangementPattern, BigInteger[] minBounds, BigInteger[] maxBounds, ArrayBigList<String> anyNamespace){
			this.elementNames = elementNames;
			this.elementTypes = elementTypes;
			this.arrangementPattern = arrangementPattern;
			this.minBounds = minBounds;
			this.maxBounds = maxBounds;
			this.anyNamespace = anyNamespace;
		}
		
	}
	
	private static class ElementWrapper{
		public final Xml.XmlQName type;
		public final String[] keyNames;
		public final String[] keySelectors;
		public final String[] keyFields;
		
		public ElementWrapper(Xml.XmlQName type, String[] keyNames, String[] keySelectors, String[] keyFields){
			this.type = type;
			this.keyNames = keyNames;
			this.keySelectors = keySelectors;
			this.keyFields = keyFields;
		}
	}
	
	private static class AttributeWrapper{
		public final String name;
		public final Xml.XmlQName type;
		public final String defaultValue;
		public final String use;
		
		public AttributeWrapper(String name, Xml.XmlQName type, String defaultValue, String use){
			this.name = name;
			this.type = type;
			this.defaultValue = defaultValue;
			this.use = use;
		}
		
		@Override
		public boolean equals(Object o){
			return (
					(o != null) &&
					(o instanceof AttributeWrapper) &&
					((this.name == ((AttributeWrapper) o).name) || (this.name != null && this.name.equals(((AttributeWrapper) o).name)))
					);
		}
		
		@Override
		public int hashCode(){
			return Objects.hash(name);
		}
	}
	
	private static class AttributeGroupWrapper{
		public final AttributeWrapper[] attributes;
		/*processContents of local anyAttribute or value of the first anyAttribute of the referred attribute groups
		 * namespace intersection of own namespace and those of all anyAttributes in attributeGroups reffered to
		 */
		public final String anyAttributeProcessContents;
		public final ArrayBigList<String> anyAttributeNamespace;
		
		public AttributeGroupWrapper(AttributeWrapper[] attributes, String anyAttributeProcessContents, ArrayBigList<String> anyAttributeNamespace){
			this.attributes = attributes;
			this.anyAttributeProcessContents = anyAttributeProcessContents;
			this.anyAttributeNamespace = anyAttributeNamespace;
		}
	}
}
