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

public final class XmlRedefine extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "(annotation[ ]+|(simpleType[ ]+|complexType[ ]+|group[ ]+|attributeGroup[ ]+))*";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "group"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "attributeGroup"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "simpleType"), new XmlQName(xs, "topLevelSimpleType"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "complexType"), new XmlQName(xs, "topLevelComplexType"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "group"), new XmlQName(xs, "namedGroup"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "attributeGroup"), new XmlQName(xs, "namedAttributeGroup"));
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("schemaLocation");
		ALLOWED_ATTRIBUTES.add("##other");
		
		REQUIRED_ATTRIBUTES.add("schemaLocation");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("schemaLocation", new XmlQName(xs, "anyURI"));
	}
	
	protected XmlAnnotation[] annotations;
	
	protected Xml.XmlComplexType[] redefinables;
	
	public XmlRedefine(Xml.XmlComplexType elem) {
		super(elem, XmlRedefine.class);
	}
	
	public XmlAnnotation[] getAnnotations() throws IOException {
		if(annotations == null){
			annotations = (XmlAnnotation[]) getChildren(new XmlAnnotation[0], new XmlQName(xs, "annotation"));
		}
		return annotations;
	}
	
	public Xml.XmlComplexType[] getRedefinables() throws IOException {
		if(redefinables == null){
			redefinables = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Map.of(
					new XmlQName(xs, "simpleType"), new XmlQName(xs, "topLevelSimpleType"),
					new XmlQName(xs, "complexType"), new XmlQName(xs, "topLevelComplexType"),
					new XmlQName(xs, "group"), new XmlQName(xs, "namedGroup"),
					new XmlQName(xs, "attributeGroup"), new XmlQName(xs, "namedAttributeGroup")
					));
		}
		return redefinables;
	}

}
