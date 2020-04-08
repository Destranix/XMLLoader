
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class CgUserType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((setparam[ ]+){0,}){0,1}";
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
    protected CgSetparamType[] setparam;

    static {
        ALLOWED_ATTRIBUTES.add("source");
        try {
            ATTRIBUTES_NAME_MAP.put("source", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ATTRIBUTES_NAME_MAP.put("typename", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "setparam"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "setparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_setparam_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "setparam"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("typename");
        REQUIRED_ATTRIBUTES.add("typename");
    }

    public CgUserType(XmlComplexType elem) {
        super(elem, CgUserType.class);
    }

    public CgSetparamType[] getSetparam()
        throws IOException
    {
        if (setparam == null) {
            try {
                setparam = ((CgSetparamType[]) getChildren(new CgSetparamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "setparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_setparam_type"), CgUserType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return setparam;
    }

}
