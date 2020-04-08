package XmlComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import Xml.XmlQName;
import Xml.XmlType;

public final class XmlSchema extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "((include[ ]+|import[ ]+|redefine[ ]+|override[ ]+|annotation[ ]+)*(defaultOpenContent[ ]+(annotation[ ]+)*)?(((simpleType[ ]+|complexType[ ]+|group[ ]+|attributeGroup[ ]+)|element[ ]+|attribute[ ]+|notation[ ]+)(annotation[ ]+)*)*)";
	protected static final Set<XmlQName> ALLOWED_CHILDREN_NAMES = new HashSet<XmlQName>();
	protected static final Map<XmlQName, XmlQName> CHILDREN_NAME_MAP = new HashMap<XmlQName, XmlQName>();
	protected static final Map<XmlQName, Integer> ALLOWED_CHILDREN_MIN_BOUNDS = new HashMap<XmlQName, Integer>();
	protected static final Map<XmlQName, Integer> ALLOWED_CHILDREN_MAX_BOUNDS = new HashMap<XmlQName, Integer>();
	protected static final Map<String, String> ATTRIBUTE_DEFAULT_VALUES = new HashMap<String, String>();
	protected static final Set<String> ALLOWED_ATTRIBUTES = new HashSet<String>();
	protected static final Set<String> REQUIRED_ATTRIBUTES = new HashSet<String>();
	protected static final Set<String> FORBIDDEN_ATTRIBUTES = new HashSet<String>();
	protected static final Map<String, XmlQName> ATTRIBUTES_NAME_MAP = new HashMap<String, XmlQName>();
	
	protected static final Map<String, Map<String, XmlType>> KEY_MAPS = new HashMap<String, Map<String, XmlType>>();
	protected static final Map<String, String> KEY_OWNER_PATH_MAP = new HashMap<String, String>();
	protected static final Map<String, String> KEY_VALUE_PATH_MAP = new HashMap<String, String>();
	
	protected static final URI xs;
	
	static{
		try{
			 xs = new URI("http://www.w3.org/2001/XMLSchema");
		} catch (URISyntaxException e) {
			throw new AssertionError("URI not parsable", e);
		}
		
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "include"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "import"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "redefine"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "override"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "annotation"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "defaultOpenContent"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "simpleType"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "complexType"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "group"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "attributeGroup"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "element"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "attribute"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "notation"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "element"), new XmlQName(xs, "topLevelElement"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "attribute"), new XmlQName(xs, "topLevelAttribute"));
		
		ATTRIBUTE_DEFAULT_VALUES.put("attributeFormDefault", "unqualified");
		ATTRIBUTE_DEFAULT_VALUES.put("elementFormDefault", "unqualified");
		ATTRIBUTE_DEFAULT_VALUES.put("xpathDefaultNamespace", "##local");
		ATTRIBUTE_DEFAULT_VALUES.put("finalDefault", "");
		ATTRIBUTE_DEFAULT_VALUES.put("blockDefault", "");
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("attributeFormDefault");
		ALLOWED_ATTRIBUTES.add("elementFormDefault");
		ALLOWED_ATTRIBUTES.add("blockDefault");
		ALLOWED_ATTRIBUTES.add("finalDefault");
		ALLOWED_ATTRIBUTES.add("targetNamespace");
		ALLOWED_ATTRIBUTES.add("version");
		ALLOWED_ATTRIBUTES.add("defaultAttributes");
		ALLOWED_ATTRIBUTES.add("xpathDefaultNamespace");
		ALLOWED_ATTRIBUTES.add("lang");
		ALLOWED_ATTRIBUTES.add("##other");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("attributeFormDefault", new XmlQName(xs, "formChoice"));
		ATTRIBUTES_NAME_MAP.put("elementFormDefault", new XmlQName(xs, "formChoice"));
		ATTRIBUTES_NAME_MAP.put("blockDefault", new XmlQName(xs, "blockSet"));
		ATTRIBUTES_NAME_MAP.put("finalDefault", new XmlQName(xs, "fullDerivationSet"));
		ATTRIBUTES_NAME_MAP.put("targetNamespace", new XmlQName(xs, "anyURI"));
		ATTRIBUTES_NAME_MAP.put("version", new XmlQName(xs, "token"));
		ATTRIBUTES_NAME_MAP.put("defaultAttributes", new XmlQName(xs, "QName"));
		ATTRIBUTES_NAME_MAP.put("xpathDefaultNamespace", new XmlQName(xs, "xpathDefaultNamespace"));
		ATTRIBUTES_NAME_MAP.put("lang", new XmlQName(xs, "language"));
		
		KEY_MAPS.put("element", new HashMap<String, XmlType>());
		KEY_MAPS.put("attribute", new HashMap<String, XmlType>());
		KEY_MAPS.put("type", new HashMap<String, XmlType>());
		KEY_MAPS.put("group", new HashMap<String, XmlType>());
		KEY_MAPS.put("attributeGroup", new HashMap<String, XmlType>());
		KEY_MAPS.put("notation", new HashMap<String, XmlType>());
		KEY_MAPS.put("identityConstraint", new HashMap<String, XmlType>());
	}
	
	protected Xml.XmlComplexType[] compositions;//TODO:Annotations only in group where they belong to!!!!
	protected XmlDefaultOpenContent[] defaultOpenContents;
	protected Xml.XmlComplexType[] schemaTops;
	
	protected XmlAnnotation[] annotations;
	
	public XmlSchema(Xml.XmlComplexType elem) {
		super(elem, XmlSchema.class);
	}
	
	public Xml.XmlComplexType[] getCompositions() throws IOException {
		if(compositions == null){
			compositions = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Set.of(new XmlQName(xs, "include"), new XmlQName(xs, "import"), new XmlQName(xs, "redefine"), new XmlQName(xs, "override"), new XmlQName(xs, "annotation")));
		}
		return compositions;
	}
	
	public XmlDefaultOpenContent[] getDefaultOpenContents() throws IOException {
		if(defaultOpenContents == null){
			defaultOpenContents = (XmlDefaultOpenContent[]) getChildren(new XmlDefaultOpenContent[0], new XmlQName(xs, "defaultOpenContent"));
		}
		return defaultOpenContents;
	}
	
	public Xml.XmlComplexType[] getSchemaTops() throws IOException {
		if(schemaTops == null){
			schemaTops = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Map.of(
					new XmlQName(xs, "simpleType"), new XmlQName(xs, "topLevelSimpleType"),
					new XmlQName(xs, "complexType"), new XmlQName(xs, "topLevelComplexType"),
					new XmlQName(xs, "group"), new XmlQName(xs, "namedGroup"),
					new XmlQName(xs, "attributeGroup"), new XmlQName(xs, "namedAttributeGroup"),
					new XmlQName(xs, "element"), new XmlQName(xs, "topLevelElement"),
					new XmlQName(xs, "attribute"), new XmlQName(xs, "topLevelAttribute"),
					new XmlQName(xs, "notation"), new XmlQName(xs, "notation")
					));
		}
		return schemaTops;
	}
	
	public XmlAnnotation[] getAnnotations() throws IOException {
		if(annotations == null){
			annotations = (XmlAnnotation[]) getChildren(new XmlAnnotation[0], new XmlQName(xs, "annotation"));
		}
		return annotations;
	}

}
