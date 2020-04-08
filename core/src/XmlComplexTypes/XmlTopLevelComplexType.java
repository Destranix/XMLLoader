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

public final class XmlTopLevelComplexType extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "((annotation[ ]+)?(simpleContent[ ]+|complexContent[ ]+|((group[ ]+|all[ ]+|choice[ ]+|sequence[ ]+)?((attribute[ ]+|attributeGroup[ ]+)*(anyAttribute[ ]+)?)(assertion[ ]+|assert[ ]+)*)))";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "simpleContent"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "complexContent"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "group"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "all"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "choice"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "sequence"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "attribute"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "attributeGroup"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "anyAttribute"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "assertion"));ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "assert"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "group"), new XmlQName(xs, "groupRef"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "attributeGroup"), new XmlQName(xs, "attributeGroupRef"));

		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "typeDefParticle"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "anyAttribute"), Integer.valueOf(1));
		
		ATTRIBUTE_DEFAULT_VALUES.put("abstract", "false");
		ATTRIBUTE_DEFAULT_VALUES.put("mixed", "false");
		ATTRIBUTE_DEFAULT_VALUES.put("defaultAttributesApply", "true");
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("name");
		ALLOWED_ATTRIBUTES.add("abstract");
		ALLOWED_ATTRIBUTES.add("mixed");
		ALLOWED_ATTRIBUTES.add("block");
		ALLOWED_ATTRIBUTES.add("final");
		ALLOWED_ATTRIBUTES.add("defaultAttributesApply");
		ALLOWED_ATTRIBUTES.add("##other");
		
		REQUIRED_ATTRIBUTES.add("name");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("name", new XmlQName(xs, "NCName"));
		ATTRIBUTES_NAME_MAP.put("abstract", new XmlQName(xs, "boolean"));
		ATTRIBUTES_NAME_MAP.put("mixed", new XmlQName(xs, "boolean"));
		ATTRIBUTES_NAME_MAP.put("block", new XmlQName(xs, "derivationSet"));
		ATTRIBUTES_NAME_MAP.put("final", new XmlQName(xs, "derivationSet"));
		ATTRIBUTES_NAME_MAP.put("defaultAttributesApply", new XmlQName(xs, "boolean"));
		
		KEY_OWNER_PATH_MAP.put("type", ".[:name=xs:complexType]/..[:type=xs:schema]");
		KEY_VALUE_PATH_MAP.put("type", "@name");
	}
	
	protected XmlAnnotation annotation;
	
	protected Xml.XmlComplexType[] complexTypeModels;
	
	public XmlTopLevelComplexType(Xml.XmlComplexType elem) {
		super(elem, XmlTopLevelComplexType.class);
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
	}
	
	public Xml.XmlComplexType[] getComplexTypeModels() throws IOException {
		if(complexTypeModels == null){
			complexTypeModels = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Map.of(
					new XmlQName(xs, "simpleContent"), new XmlQName(xs, "simpleContent"),
					new XmlQName(xs, "complexContent"), new XmlQName(xs, "complexContent"),
					new XmlQName(xs, "group"), 	new XmlQName(xs, "groupRef"), 
					new XmlQName(xs, "all"), 	new XmlQName(xs, "all"),
					new XmlQName(xs, "choice"), new XmlQName(xs, "choice"),
					new XmlQName(xs, "sequence"), 	new XmlQName(xs, "sequence"),
					new XmlQName(xs, "attribute"), new XmlQName(xs, "attribute"),
					new XmlQName(xs, "attributeGroup"), new XmlQName(xs, "attributeGroupRef"),
					new XmlQName(xs, "anyAttribute"), new XmlQName(xs, "anyAttribute"),
					new XmlQName(xs, "assertion"), new XmlQName(xs, "assertion")
					));
		}
		return complexTypeModels;
	}

}
