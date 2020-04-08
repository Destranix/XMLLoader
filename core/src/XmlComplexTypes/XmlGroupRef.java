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

public final class XmlGroupRef extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "(annotation[ ]+)?";
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

		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		
		ATTRIBUTE_DEFAULT_VALUES.put("maxOccurs", "1");
		ATTRIBUTE_DEFAULT_VALUES.put("minOccurs", "1");
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("ref");
		ALLOWED_ATTRIBUTES.add("maxOccurs");
		ALLOWED_ATTRIBUTES.add("minOccurs");
		ALLOWED_ATTRIBUTES.add("##other");
		
		REQUIRED_ATTRIBUTES.add("ref");
		
		FORBIDDEN_ATTRIBUTES.add("name");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("ref", new XmlQName(xs, "QName"));
		ATTRIBUTES_NAME_MAP.put("maxOccurs", new XmlQName(xs, "allNNI"));
		ATTRIBUTES_NAME_MAP.put("minOccurs", new XmlQName(xs, "nonNegativeInteger"));
	}
	
	protected XmlAnnotation annotation;
	
	public XmlGroupRef(Xml.XmlComplexType elem) {
		super(elem, XmlGroupRef.class);
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
	}

}
