package XmlComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import Xml.XmlQName;
import Xml.XmlType;

public final class XmlRestriction extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "(annotation[ ]+)?((simpleType[ ]+)?(minExclusive[ ]+|minInclusive[ ]+|maxExclusive[ ]+|maxInclusive[ ]+|totalDigits[ ]+|fractionDigits[ ]+|length[ ]+|minLength[ ]+|maxLength[ ]+|enumeration[ ]+|whiteSpace[ ]+|pattern[ ]+|assertion[ ]+|explicitTimezone[ ]+|[^ ]+)*)";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "minExclusive"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "minInclusive"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "maxExclusive"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "maxInclusive"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "totalDigits"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "fractionDigits"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "length"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "minLength"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "maxLength"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "enumeration"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "whiteSpace"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "pattern"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "explicitTimezone"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "assertion"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(null, "##other"));
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "simpleType"), new XmlQName(xs, "localSimpleType"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "minExclusive"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "minInclusive"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "maxExclusive"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "maxInclusive"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "totalDigits"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "fractionDigits"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "length"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "minLength"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "maxLength"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "enumeration"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "whiteSpace"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "pattern"), new XmlQName(xs, "facet"));
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "explicitTimezone"), new XmlQName(xs, "facet"));
		
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "simpleType"), Integer.valueOf(1));
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("base");
		ALLOWED_ATTRIBUTES.add("##other");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("base", new XmlQName(xs, "QName"));
	}
	
	protected XmlAnnotation annotation;
	
	protected Xml.XmlComplexType[] simpleRestrictionModel;//Contains only not ##other Types
	
	
	public XmlRestriction(Xml.XmlComplexType elem) {
		super(elem, XmlRestriction.class);
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
	}
	
	public Xml.XmlComplexType[] getSimpleRestrictionModels() throws IOException {
		if(simpleRestrictionModel == null){
			simpleRestrictionModel = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Map.ofEntries(
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "simpleType"), new XmlQName(xs, "localSimpleType")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "minExclusive"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "minInclusive"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "maxExclusive"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "maxInclusive"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "totalDigits"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "fractionDigits"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "length"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "minLength"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "maxLength"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "enumeration"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "whiteSpace"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "pattern"), new XmlQName(xs, "facet")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "assertion"), new XmlQName(xs, "assertion")),
					new AbstractMap.SimpleEntry<XmlQName, XmlQName>(new XmlQName(xs, "explicitTimezone"), new XmlQName(xs, "facet"))
					));
		}
		return simpleRestrictionModel;
	}

}
