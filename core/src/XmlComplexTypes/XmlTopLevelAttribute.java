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
import Xml.XmlValidationException;

public final class XmlTopLevelAttribute extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "((annotation[ ]+)?((simpleType[ ]+)?))";
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
		
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "annotation"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "simpleType"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "simpleType"), new XmlQName(xs, "localSimpleType"));

		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "simpleType"), Integer.valueOf(1));
		
		ALLOWED_ATTRIBUTES.add("default");
		ALLOWED_ATTRIBUTES.add("fixed");
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("name");
		ALLOWED_ATTRIBUTES.add("type");
		ALLOWED_ATTRIBUTES.add("inheritable");
		ALLOWED_ATTRIBUTES.add("##other");
		
		REQUIRED_ATTRIBUTES.add("name");
		
		FORBIDDEN_ATTRIBUTES.add("ref");
		FORBIDDEN_ATTRIBUTES.add("form");
		FORBIDDEN_ATTRIBUTES.add("use");
		FORBIDDEN_ATTRIBUTES.add("targetNamespace");
		
		ATTRIBUTES_NAME_MAP.put("default", new XmlQName(xs, "string"));
		ATTRIBUTES_NAME_MAP.put("fixed", new XmlQName(xs, "string"));
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("name", new XmlQName(xs, "NCName"));
		ATTRIBUTES_NAME_MAP.put("type", new XmlQName(xs, "QName"));
		ATTRIBUTES_NAME_MAP.put("inheritable", new XmlQName(xs, "boolean"));
		
		KEY_OWNER_PATH_MAP.put("attribute", ".[:name=xs:attribute]/..[:type=xs:schema]");
		KEY_VALUE_PATH_MAP.put("attribute", "@name");
	}
	
	protected XmlAnnotation annotation;
	
	protected XmlLocalSimpleType simpleType;
	
	public XmlTopLevelAttribute(Xml.XmlComplexType elem) throws IOException {
		super(elem, XmlTopLevelAttribute.class);
		if((elem.getAttribute("default") != null) && (elem.getAttribute("fixed", XmlTopLevelAttribute.class) != null)){
			throw new XmlValidationException("Attribute \"default\" and \"fixed\" cannot both be present: "+path);
		}
		if((getChildren(new XmlType[0], new XmlQName(xs, "simpleType"), new XmlQName(xs, "localSimpleType")).length != 0) && (elem.getAttribute("type", XmlTopLevelAttribute.class) != null)){
			throw new XmlValidationException("Attribute \"ref\" not allowed if child of kind \"simpleType\" is present: "+path);
		}
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
	}
	
	public XmlLocalSimpleType getSimpleType() throws IOException {
		if(simpleType == null){
			simpleType = (XmlLocalSimpleType) getChild(new XmlQName(xs, "simpleType"), new XmlQName(xs, "localSimpleType"));
		}
		return simpleType;
	}

}
