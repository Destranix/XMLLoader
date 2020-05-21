
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

public final class PolylistType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((input[ ]+){0,}(vcount[ ]+){0,1}(p[ ]+){0,1}(extra[ ]+){0,}){1}";
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
    protected ExtraType[] extra;
    protected PType p;
    protected InputLocalOffsetType[] input;
    protected ListOfUintsType vcount;

    static {
        ALLOWED_ATTRIBUTES.add("material");
        try {
            ATTRIBUTES_NAME_MAP.put("material", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("count", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "uint_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input_local_offset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_uints_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("name");
        ALLOWED_ATTRIBUTES.add("count");
        REQUIRED_ATTRIBUTES.add("count");
    }

    public PolylistType(XmlComplexType elem) {
        super(elem, PolylistType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), PolylistType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public PType getP()
        throws IOException
    {
        if (p == null) {
            try {
                p = ((PType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "p_type"), PolylistType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return p;
    }

    public InputLocalOffsetType[] getInput()
        throws IOException
    {
        if (input == null) {
            try {
                input = ((InputLocalOffsetType[]) getChildren(new InputLocalOffsetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input_local_offset_type"), PolylistType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return input;
    }

    public ListOfUintsType getVcount()
        throws IOException
    {
        if (vcount == null) {
            try {
                vcount = ((ListOfUintsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_uints_type"), PolylistType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vcount;
    }

}
