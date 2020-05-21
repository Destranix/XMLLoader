
package ComplexTypes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class MspaceType
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
        ALLOWED_ATTRIBUTES.add("linebreak");
        ATTRIBUTE_DEFAULT_VALUES.put("linebreak", "auto");
        try {
            ATTRIBUTES_NAME_MAP.put("linebreak", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("depth", new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "length-with-unit"));
            ATTRIBUTES_NAME_MAP.put("class", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NMTOKENS"));
            ATTRIBUTES_NAME_MAP.put("xref", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "IDREF"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ATTRIBUTES_NAME_MAP.put("href", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ATTRIBUTES_NAME_MAP.put("width", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("style", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("height", new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "length-with-unit"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("depth");
        ATTRIBUTE_DEFAULT_VALUES.put("depth", "0ex");
        ALLOWED_ATTRIBUTES.add("class");
        ALLOWED_ATTRIBUTES.add("xref");
        ALLOWED_ATTRIBUTES.add("id");
        ALLOWED_ATTRIBUTES.add("href");
        ALLOWED_ATTRIBUTES.add("width");
        ATTRIBUTE_DEFAULT_VALUES.put("width", "0em");
        ALLOWED_ATTRIBUTES.add("style");
        ALLOWED_ATTRIBUTES.add("height");
        ATTRIBUTE_DEFAULT_VALUES.put("height", "0ex");
    }

    public MspaceType(XmlComplexType elem) {
        super(elem, MspaceType.class);
    }

}
