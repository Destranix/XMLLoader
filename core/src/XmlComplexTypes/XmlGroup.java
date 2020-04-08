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

public final class XmlGroup extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "((annotation[ ]+)?(element[ ]+|group[ ]+|all[ ]+|choice[ ]+|sequence[ ]+|any[ ]+)*)";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "element"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "group"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "all"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "choice"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "sequence"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "any"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "element"), new XmlQName(xs, "localElement"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "group"), new XmlQName(xs, "groupRef"));

		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "particle"), Integer.valueOf(1));
		
		ATTRIBUTE_DEFAULT_VALUES.put("maxOccurs", "1");
		ATTRIBUTE_DEFAULT_VALUES.put("minOccurs", "1");
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("name");
		ALLOWED_ATTRIBUTES.add("ref");
		ALLOWED_ATTRIBUTES.add("maxOccurs");
		ALLOWED_ATTRIBUTES.add("minOccurs");
		ALLOWED_ATTRIBUTES.add("##other");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("name", new XmlQName(xs, "NCName"));
		ATTRIBUTES_NAME_MAP.put("ref", new XmlQName(xs, "QName"));
		ATTRIBUTES_NAME_MAP.put("maxOccurs", new XmlQName(xs, "allNNI"));
		ATTRIBUTES_NAME_MAP.put("minOccurs", new XmlQName(xs, "nonNegativeInteger"));
	}
	
	protected XmlAnnotation annotation;
	
	protected Xml.XmlComplexType[] particles;
	
	public XmlGroup(Xml.XmlComplexType elem) throws IOException {
		super(elem, XmlGroup.class);
		if((elem.getAttribute("name", XmlGroup.class) != null) && (elem.getAttribute("ref", XmlGroup.class) != null)){
			throw new XmlValidationException("Attribute \"name\" and \"ref\" cannot both be present: "+path);
		}
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
	}
	
	public Xml.XmlComplexType[] getParticles() throws IOException {
		if(particles == null){
			particles = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Map.of(
					new XmlQName(xs, "element"), new XmlQName(xs, "localElement"),
					new XmlQName(xs, "group"), new XmlQName(xs, "groupRef"),
					new XmlQName(xs, "all"), new XmlQName(xs, "all"),
					new XmlQName(xs, "choice"), new XmlQName(xs, "choice"),
					new XmlQName(xs, "sequence"), new XmlQName(xs, "sequence"),
					new XmlQName(xs, "any"), new XmlQName(xs, "any")
					));
		}
		return particles;
	}

}
