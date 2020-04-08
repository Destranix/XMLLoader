
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class AccessorType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((param[ ]+){0,}){1}";
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
    protected ParamType[] param;

    static {
        ALLOWED_ATTRIBUTES.add("offset");
        ATTRIBUTE_DEFAULT_VALUES.put("offset", "0");
        try {
            ATTRIBUTES_NAME_MAP.put("offset", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "uint_type"));
            ATTRIBUTES_NAME_MAP.put("count", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "uint_type"));
            ATTRIBUTES_NAME_MAP.put("source", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ATTRIBUTES_NAME_MAP.put("stride", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "uint_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("count");
        REQUIRED_ATTRIBUTES.add("count");
        ALLOWED_ATTRIBUTES.add("source");
        REQUIRED_ATTRIBUTES.add("source");
        ALLOWED_ATTRIBUTES.add("stride");
        ATTRIBUTE_DEFAULT_VALUES.put("stride", "1");
    }

    public AccessorType(XmlComplexType elem) {
        super(elem, AccessorType.class);
    }

    public ParamType[] getParam()
        throws IOException
    {
        if (param == null) {
            try {
                param = ((ParamType[]) getChildren(new ParamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param_type"), AccessorType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return param;
    }

}
