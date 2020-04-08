package XmlComplexTypes;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import Xml.XmlQName;
import Xml.XmlType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlAllNNI;
import XmlSimpleTypes.XmlNonNegativeInteger;

public final class XmlNamedGroup extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "((annotation[ ]+)?(all[ ]+|choice[ ]+|sequence[ ]+))";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "all"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "choice"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "sequence"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "all"), new XmlQName(xs, "namedGroup/all"));

		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "all"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "choice"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "sequence"), Integer.valueOf(1));
		
		ATTRIBUTE_DEFAULT_VALUES.put("defaultAttributesApply", "true");
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("name");
		ALLOWED_ATTRIBUTES.add("##other");
		
		REQUIRED_ATTRIBUTES.add("name");
		
		FORBIDDEN_ATTRIBUTES.add("ref");
		FORBIDDEN_ATTRIBUTES.add("maxOccurs");
		FORBIDDEN_ATTRIBUTES.add("minOccurs");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("name", new XmlQName(xs, "NCName"));
		
		KEY_OWNER_PATH_MAP.put("group", ".[:name=xs:group]/..[:type=xs:schema]");
		KEY_VALUE_PATH_MAP.put("group", "@name");
	}
	
	protected XmlAnnotation annotation;
	
	protected XmlNamedGroup.XmlAll all;
	protected XmlExplicitGroup choice;
	protected XmlExplicitGroup sequence;
	
	public XmlNamedGroup(Xml.XmlComplexType elem) {
		super(elem, XmlNamedGroup.class);
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
	}
	
	public XmlNamedGroup.XmlAll getAll() throws IOException {
		if(all == null){
			all = (XmlNamedGroup.XmlAll) getChild(new XmlQName(xs, "all"), new XmlQName(xs, "namedGroup/all"));
		}
		return all;
	}
	
	public XmlExplicitGroup getChoice() throws IOException {
		if(choice == null){
			choice = (XmlExplicitGroup) getChild(new XmlQName(xs, "choice"));
		}
		return choice;
	}
	
	public XmlExplicitGroup getSequence() throws IOException {
		if(sequence == null){
			sequence = (XmlExplicitGroup) getChild(new XmlQName(xs, "sequence"));
		}
		return sequence;
	}
	
	public static final class XmlAll extends Xml.XmlComplexType{
		
		protected static final String ALLOWED_CHILDREN_PATTERN = "((annotation[ ]+)?(element[ ]+)*)";
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
			
			CHILDREN_NAME_MAP.put(new XmlQName(xs, "element"), new XmlQName(xs, "localElement"));

			ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
			
			ALLOWED_ATTRIBUTES.add("id");
			ALLOWED_ATTRIBUTES.add("##other");
			
			FORBIDDEN_ATTRIBUTES.add("name");
			FORBIDDEN_ATTRIBUTES.add("ref");
			FORBIDDEN_ATTRIBUTES.add("minOccurs");
			FORBIDDEN_ATTRIBUTES.add("maxOccurs");
			
			ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		}
		
		protected XmlAnnotation annotation;
		
		protected XmlLocalElement[] elements;
		
		public XmlAll(Xml.XmlComplexType elem) throws IOException {
			super(elem, XmlNamedGroup.XmlAll.class);
			BigInteger minOccursValue = ((XmlNonNegativeInteger) getAttribute("minOccurs", XmlNamedGroup.class)).getValue();
			if(!(BigInteger.ZERO.equals(minOccursValue) || BigInteger.ONE.equals(minOccursValue))){
				throw new XmlValidationException("Attribute \"minOccurs\" must be either 0 or 1, but was \""+minOccursValue+"\": "+path);
			}
			BigInteger maxOccursValue = ((XmlAllNNI) getAttribute("maxOccurs", XmlNamedGroup.class)).getValue();
			if(!(BigInteger.ZERO.equals(maxOccursValue) || BigInteger.ONE.equals(maxOccursValue))){
				throw new XmlValidationException("Attribute \"maxOccurs\" must be either 0 or 1, but was \""+maxOccursValue+"\": "+path);
			}
		}
		
		public XmlAnnotation getAnnotation() throws IOException {
			if(annotation == null){
				annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
			}
			return annotation;
		}
		
		public XmlLocalElement[] getElements() throws IOException {
			if(elements == null){
				elements = (XmlLocalElement[]) getChildren(new XmlLocalElement[0], new XmlQName(xs, "element"), new XmlQName(xs, "localElement"));
			}
			return elements;
		}
		
	}

}
