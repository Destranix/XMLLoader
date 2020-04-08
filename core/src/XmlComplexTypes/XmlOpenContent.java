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

public final class XmlOpenContent extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "((annotation[ ]+)?(any[ ]+)?";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "any"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "any"), new XmlQName(xs, "wildcard"));
		
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "any"), Integer.valueOf(1));
		
		ATTRIBUTE_DEFAULT_VALUES.put("mode", "interleave");
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("mode");
		ALLOWED_ATTRIBUTES.add("##other");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("mode", new XmlQName(xs, "NMTOKEN"));
	}
	
	protected XmlAnnotation annotation;
	
	protected XmlWildcard any;
	
	public XmlOpenContent(Xml.XmlComplexType elem) throws IOException {
		super(elem, XmlOpenContent.class);
		String modeValue = ((XmlNMTOKEN) getAttribute("mode", XmlOpenContent.class)).getValue();
		if(!(
				"none".equals(modeValue)||
				"interleave".equals(modeValue)||
				"suffix".equals(modeValue)
				)){
			throw new XmlValidationException("Attribute \"mode\" cannot have value \""+modeValue+"\", must be one of {none, interleave, suffix}: "+path);
		}
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
	}
	
	public XmlWildcard getAny() throws IOException {
		if(any == null){
			any = (XmlWildcard) getChild(new XmlQName(xs, "any"), new XmlQName(xs, "wildcard"));
		}
		return any;
	}

}
