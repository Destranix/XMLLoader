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
import XmlSimpleTypes.XmlNMTOKEN;

public final class XmlAttribute extends Xml.XmlComplexType{
	
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
		
		ATTRIBUTE_DEFAULT_VALUES.put("use", "optional");
		
		ALLOWED_ATTRIBUTES.add("default");
		ALLOWED_ATTRIBUTES.add("fixed");
		ALLOWED_ATTRIBUTES.add("form");
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("name");
		ALLOWED_ATTRIBUTES.add("ref");
		ALLOWED_ATTRIBUTES.add("type");
		ALLOWED_ATTRIBUTES.add("use");
		ALLOWED_ATTRIBUTES.add("targetNamespace");
		ALLOWED_ATTRIBUTES.add("inheritable");
		ALLOWED_ATTRIBUTES.add("##other");
		
		ATTRIBUTES_NAME_MAP.put("default", new XmlQName(xs, "string"));
		ATTRIBUTES_NAME_MAP.put("fixed", new XmlQName(xs, "string"));
		ATTRIBUTES_NAME_MAP.put("form", new XmlQName(xs, "formChoice"));
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("name", new XmlQName(xs, "NCName"));
		ATTRIBUTES_NAME_MAP.put("ref", new XmlQName(xs, "QName"));
		ATTRIBUTES_NAME_MAP.put("type", new XmlQName(xs, "QName"));
		ATTRIBUTES_NAME_MAP.put("use", new XmlQName(xs, "NMTOKEN"));
		ATTRIBUTES_NAME_MAP.put("targetNamespace", new XmlQName(xs, "anyURI"));
		ATTRIBUTES_NAME_MAP.put("inheritable", new XmlQName(xs, "boolean"));
	}
	
	protected XmlAnnotation annotation;
	
	protected XmlLocalSimpleType simpleType;
	
	public XmlAttribute(Xml.XmlComplexType elem) throws IOException {
		super(elem, XmlAttribute.class);
		setDefaultAttributeValue("form", elem.parent.getAttribute("attributeFormDefault"));
		if((elem.getAttribute("default", XmlAttribute.class) != null) && (elem.getAttribute("fixed", XmlAttribute.class) != null)){
			throw new XmlValidationException("Attribute \"default\" and \"fixed\" cannot both be present: "+path);
		}
		if((elem.getAttribute("name", XmlAttribute.class) != null) && (elem.getAttribute("ref", XmlAttribute.class) != null)){
			throw new XmlValidationException("Attribute \"name\" and \"ref\" cannot both be present: "+path);
		}
		if((elem.getAttribute("form", XmlAttribute.class) != null) && (elem.getAttribute("ref", XmlAttribute.class) != null)){
			throw new XmlValidationException("Attribute \"form\" and \"ref\" cannot both be present: "+path);
		}
		if((elem.getAttribute("type", XmlAttribute.class) != null) && (elem.getAttribute("ref", XmlAttribute.class) != null)){
			throw new XmlValidationException("Attribute \"type\" and \"ref\" cannot both be present: "+path);
		}
		if((getChildren(new XmlType[0], new XmlQName(xs, "simpleType"), new XmlQName(xs, "localSimpleType")).length != 0) && (elem.getAttribute("ref", XmlAttribute.class) != null)){
			throw new XmlValidationException("Attribute \"ref\" not allowed if child of kind \"simpleType\" is present: "+path);
		}
		if((getChildren(new XmlType[0], new XmlQName(xs, "simpleType"), new XmlQName(xs, "localSimpleType")).length != 0) && (elem.getAttribute("type", XmlAttribute.class) != null)){
			throw new XmlValidationException("Attribute \"type\" not allowed if child of kind \"simpleType\" is present: "+path);
		}
		String useValue = ((XmlNMTOKEN) getAttribute("use", XmlAttribute.class)).getValue();
		if(!(
				"prohibited".equals(useValue)||
				"optional".equals(useValue)||
				"required".equals(useValue)
				)){
			throw new XmlValidationException("Attribute \"use\" cannot have value \""+useValue+"\", must be one of {prohibited, optional, required}: "+path);
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
