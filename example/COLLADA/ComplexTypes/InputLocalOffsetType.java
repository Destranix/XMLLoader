
package ComplexTypes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class InputLocalOffsetType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "()";
    protected final static HashSet<XmlQName> ALLOWED_CHILDREN_NAMES = new HashSet<XmlQName>();
    protected final static HashMap<XmlQName, XmlQName> CHILDREN_NAME_MAP = new HashMap<XmlQName, XmlQName>();
    protected final static HashMap<XmlQName, Integer> ALLOWED_CHILDREN_MIN_BOUNDS = new HashMap<XmlQName, Integer>();
    protected final static HashMap<XmlQName, Integer> ALLOWED_CHILDREN_MAX_BOUNDS = new HashMap<XmlQName, Integer>();
    protected final static HashMap<String, String> ATTRIBUTE_DEFAULT_VALUES = new HashMap<String, String>();
    protected final static HashSet<String> ALLOWED_ATTRIBUTES = new HashSet<String>();
    protected final static HashSet<String> REQUIRED_ATTRIBUTES = new HashSet<String>();
    protected final static HashSet<String> FORBIDDEN_ATTRIBUTES = new HashSet<String>();
    protected final static HashMap<String, XmlQName> ATTRIBUTES_NAME_MAP = new HashMap<String, XmlQName>();
    protected final static HashMap<String, HashMap<String, XmlType>> KEY_MAPS = new HashMap<String, HashMap<String, XmlType>>();
    protected final static HashMap<String, String> KEY_OWNER_PATH_MAP = new HashMap<String, String>();
    protected final static HashMap<String, String> KEY_VALUE_PATH_MAP = new HashMap<String, String>();

    static {
        ALLOWED_ATTRIBUTES.add("set");
        try {
            ATTRIBUTES_NAME_MAP.put("set", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "uint_type"));
            ATTRIBUTES_NAME_MAP.put("semantic", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NMTOKEN"));
            ATTRIBUTES_NAME_MAP.put("offset", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "uint_type"));
            ATTRIBUTES_NAME_MAP.put("source", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "urifragment_type"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("semantic");
        REQUIRED_ATTRIBUTES.add("semantic");
        ALLOWED_ATTRIBUTES.add("offset");
        REQUIRED_ATTRIBUTES.add("offset");
        ALLOWED_ATTRIBUTES.add("source");
        REQUIRED_ATTRIBUTES.add("source");
    }

    public InputLocalOffsetType(XmlComplexType elem) {
        super(elem, InputLocalOffsetType.class);
    }

}
