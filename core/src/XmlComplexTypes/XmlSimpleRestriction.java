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

public final class XmlSimpleRestriction extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "((annotation[ ]+)?((simpleType[ ]+)?(minExclusive[ ]+|minInclusive[ ]+|maxExclusive[ ]+|maxInclusive[ ]+|totalDigits[ ]+|fractionDigits[ ]+|length[ ]+|minLength[ ]+|maxLength[ ]+|enumeration[ ]+|whiteSpace[ ]+|pattern[ ]+|assertion[ ]+|explicitTimezone[ ]+|[^ ]+)*)?((attribute[ ]+|attributeGroup[ ]+)*(anyAttribute[ ]+)?)(assertion[ ]+|assert[ ]+)*)";
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
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "attribute"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "attributeGroup"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "anyAttribute"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "assertion"));ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "assert"));
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
		
		CHILDREN_NAME_MAP.put(new XmlQName(xs, "attributeGroup"), new XmlQName(xs, "attributeGroupRef"));
		
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "annotation"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "simpleType"), Integer.valueOf(1));
		ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(xs, "anyAttribute"), Integer.valueOf(1));
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("base");
		ALLOWED_ATTRIBUTES.add("##other");
		
		REQUIRED_ATTRIBUTES.add("base");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
		ATTRIBUTES_NAME_MAP.put("base", new XmlQName(xs, "QName"));
	}
	
	protected XmlAnnotation annotation;
	
	protected Xml.XmlComplexType[] simpleRestrictionModels;//Contains only not ##other Types
	protected Xml.XmlComplexType[] attrDecls;
	protected XmlAssertion[] assertions;
	
	public XmlSimpleRestriction(Xml.XmlComplexType elem) {
		super(elem, XmlSimpleRestriction.class);
	}
	
	public XmlAnnotation getAnnotation() throws IOException {
		if(annotation == null){
			annotation = (XmlAnnotation) getChild(new XmlQName(xs, "annotation"));
		}
		return annotation;
	}
	
	public Xml.XmlComplexType[] getSimpleRestrictionModels() throws IOException {
		if(simpleRestrictionModels == null){
			simpleRestrictionModels = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Map.ofEntries(
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
		return simpleRestrictionModels;
	}
	
	public Xml.XmlComplexType[] getAttrDecls() throws IOException {
		if(attrDecls == null){
			attrDecls = (Xml.XmlComplexType[]) getChildren(new Xml.XmlComplexType[0], Map.of(
					new XmlQName(xs, "attribute"), new XmlQName(xs, "attribute"),
					new XmlQName(xs, "attributeGroup"), new XmlQName(xs, "attributeGroupRef"),
					new XmlQName(xs, "anyAttribute"), new XmlQName(xs, "anyAttribute")
					));
		}
		return attrDecls;
	}
	
	public XmlAssertion[] getAssertions() throws IOException {
		if(assertions == null){
			assertions = (XmlAssertion[]) getChildren(new XmlAssertion[0], new XmlQName(xs, "assertion"));
		}
		return assertions;
	}

}
