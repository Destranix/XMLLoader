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

public final class XmlLocalElement extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "(annotation[ ]+)?(simpleType[ ]+|complexType[ ]+)?(alternative[ ]+)*(unique[ ]+|key[ ]+|keyref[ ]+)*";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "complexType"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "alternative"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "unique"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "key"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "keyref"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "simpleType"), new XmlQName(xs, "localSimpleType"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "complexType"), new XmlQName(xs, "localComplexType"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "alternative"), new XmlQName(xs, "altType"));

		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "simpleType"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "complexType"), Integer.valueOf(1));
		
		ATTRIBUTE_DEFAULT_VALUES.put("maxOccurs", "1");
		ATTRIBUTE_DEFAULT_VALUES.put("minOccurs", "1");
		ATTRIBUTE_DEFAULT_VALUES.put("nillable", "false");
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("name");
		ALLOWED_ATTRIBUTES.add("ref");
		ALLOWED_ATTRIBUTES.add("type");
		ALLOWED_ATTRIBUTES.add("maxOccurs");
		ALLOWED_ATTRIBUTES.add("minOccurs");
		ALLOWED_ATTRIBUTES.add("default");
		ALLOWED_ATTRIBUTES.add("fixed");
		ALLOWED_ATTRIBUTES.add("nillable");
		ALLOWED_ATTRIBUTES.add("block");
		ALLOWED_ATTRIBUTES.add("form");
		ALLOWED_ATTRIBUTES.add("targetNamespace");
		ALLOWED_ATTRIBUTES.add("##other");
		
		FORBIDDEN_ATTRIBUTES.add("substitutionGroup");
		FORBIDDEN_ATTRIBUTES.add("final");
		FORBIDDEN_ATTRIBUTES.add("abstract");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("name", new XmlQName(xs, "NCName"));
		ATTRIBUTES_NAME_MAP.put("ref", new XmlQName(xs, "QName"));
		ATTRIBUTES_NAME_MAP.put("type", new XmlQName(xs, "QName"));
		ATTRIBUTES_NAME_MAP.put("maxOccurs", new XmlQName(xs, "allNNI"));
		ATTRIBUTES_NAME_MAP.put("minOccurs", new XmlQName(xs, "nonNegativeInteger"));
		ATTRIBUTES_NAME_MAP.put("default", new XmlQName(xs, "string"));
		ATTRIBUTES_NAME_MAP.put("fixed", new XmlQName(xs, "string"));
		ATTRIBUTES_NAME_MAP.put("nillable", new XmlQName(xs, "boolean"));
		ATTRIBUTES_NAME_MAP.put("block", new XmlQName(xs, "blockSet"));
		ATTRIBUTES_NAME_MAP.put("form", new XmlQName(xs, "formChoice"));
		ATTRIBUTES_NAME_MAP.put("targetNamespace", new XmlQName(xs, "anyURI"));
	}
	
	protected XmlAnnotation annotation;
	
	protected XmlLocalSimpleType simpleType;
	protected XmlLocalComplexType complexType;
	
	protected XmlAltType[] alternatives;
	protected Xml.XmlComplexType[] identityConstraints;
	
	public XmlLocalElement(Xml.XmlComplexType elem) {
		super(elem, XmlLocalElement.class);
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
	
	public XmlLocalComplexType getComplexType() throws IOException {
		if(complexType == null){
			complexType = (XmlLocalComplexType) getChild(new XmlQName(xs, "complexType"), new XmlQName(xs, "localComplexType"));
		}
		return complexType;
	}
	
	public XmlAltType[] getAlternatives() throws IOException {
		if(alternatives == null){
			alternatives = (XmlAltType[]) getChildren(new XmlAltType[0], new XmlQName(xs, "alternative"), new XmlQName(xs, "altType"));
		}
		return alternatives;
	}
	
	public Xml.XmlComplexType[] getIdentityConstraints() throws IOException {
		if(identityConstraints == null){
			identityConstraints = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Map.of(
					new XmlQName(xs, "unique"), new XmlQName(xs, "unique"),
					new XmlQName(xs, "key"), new XmlQName(xs, "key"),
					new XmlQName(xs, "keyref"), new XmlQName(xs, "keyref")
					));
		}
		return identityConstraints;
	}

}
