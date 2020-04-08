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

public final class XmlOverride extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "(annotation[ ]+)?((simpleType[ ]+|complexType[ ]+|group[ ]+|attributeGroup[ ]+)|element[ ]+|attribute[ ]+|notation[ ]+)*";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "element"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "attribute"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "notation"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "element"), new XmlQName(xs, "topLevelElement"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "attribute"), new XmlQName(xs, "topLevelAttribute"));
		
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("schemaLocation");
		ALLOWED_ATTRIBUTES.add("##other");
		
		REQUIRED_ATTRIBUTES.add("schemaLocation");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("schemaLocation", new XmlQName(xs, "anyURI"));
	}
	
	protected XmlAnnotation annotation;
	protected Xml.XmlComplexType[] schemaTops;
	
	public XmlOverride(Xml.XmlComplexType elem) {
		super(elem, XmlOverride.class);
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
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

}
