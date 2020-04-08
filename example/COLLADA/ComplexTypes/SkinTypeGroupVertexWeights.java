
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.ListOfIntsType;
import SimpleTypes.ListOfUintsType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class SkinTypeGroupVertexWeights
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((input[ ]+){2,}(vcount[ ]+){0,1}(v[ ]+){0,1}(extra[ ]+){0,}){1}";
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
    protected ListOfIntsType v;
    protected InputLocalOffsetType[] input;
    protected ListOfUintsType vcount;

    static {
        ALLOWED_ATTRIBUTES.add("count");
        REQUIRED_ATTRIBUTES.add("count");
        try {
            ATTRIBUTES_NAME_MAP.put("count", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "uint_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "v"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "v"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_ints_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "v"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "v"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input_local_offset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), Integer.valueOf("2"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_uints_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public SkinTypeGroupVertexWeights(XmlComplexType elem) {
        super(elem, SkinTypeGroupVertexWeights.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), SkinTypeGroupVertexWeights.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public ListOfIntsType getV()
        throws IOException
    {
        if (v == null) {
            try {
                v = ((ListOfIntsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "v"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_ints_type"), SkinTypeGroupVertexWeights.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return v;
    }

    public InputLocalOffsetType[] getInput()
        throws IOException
    {
        if (input == null) {
            try {
                input = ((InputLocalOffsetType[]) getChildren(new InputLocalOffsetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input_local_offset_type"), SkinTypeGroupVertexWeights.class));
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
                vcount = ((ListOfUintsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vcount"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_uints_type"), SkinTypeGroupVertexWeights.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vcount;
    }

}
