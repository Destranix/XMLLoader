
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.ListOfUintsType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class PolygonsTypeGroupGroup1Ph
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((p[ ]+){1}(h[ ]+){1,}){1}";
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
    protected ListOfUintsType[] h;
    protected PType p;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "h"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "h"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_uints_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "h"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public PolygonsTypeGroupGroup1Ph(XmlComplexType elem) {
        super(elem, PolygonsTypeGroupGroup1Ph.class);
    }

    public ListOfUintsType[] getH()
        throws IOException
    {
        if (h == null) {
            try {
                h = ((ListOfUintsType[]) getChildren(new ListOfUintsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "h"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_uints_type"), PolygonsTypeGroupGroup1Ph.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return h;
    }

    public PType getP()
        throws IOException
    {
        if (p == null) {
            try {
                p = ((PType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p_type"), PolygonsTypeGroupGroup1Ph.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return p;
    }

}
