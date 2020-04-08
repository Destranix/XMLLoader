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

public final class XmlAnnotation extends Xml.XmlComplexType{
	
	protected static final String ALLOWED_CHILDREN_PATTERN = "(appinfo[ ]+|documentation[ ]+)*";
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
		
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "appinfo"));
		ALLOWED_CHILDREN_NAMES.add(new XmlQName(xs, "documentation"));
		
		ALLOWED_ATTRIBUTES.add("id");
		ALLOWED_ATTRIBUTES.add("##other");
		
		ATTRIBUTES_NAME_MAP.put("id", new XmlQName(xs, "ID"));
	}
	
	protected XmlAppinfo[] appinfos;
	protected XmlDocumentation[] documentations;
	
	public XmlAnnotation(Xml.XmlComplexType elem) {
		super(elem, XmlAnnotation.class);
	}
	
	public XmlAppinfo[] getAppinfos() throws IOException {
		if(appinfos == null){
			appinfos = (XmlAppinfo[]) getChildren(new XmlAppinfo[0], new XmlQName(xs, "appinfo"));
		}
		return appinfos;
	}
	
	public XmlDocumentation[] getDocumentations() throws IOException {
		if(documentations == null){
			documentations = (XmlDocumentation[]) getChildren(new XmlDocumentation[0], new XmlQName(xs, "documentation"));
		}
		return documentations;
	}

}
