
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class NurbsType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((source[ ]+){1,}(control_vertices[ ]+){1}(extra[ ]+){0,}){1}";
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
    protected NurbsTypeGroupControlVertices controlVertices;
    protected SourceType[] source;

    static {
        ALLOWED_ATTRIBUTES.add("closed");
        ATTRIBUTE_DEFAULT_VALUES.put("closed", "false");
        try {
            ATTRIBUTES_NAME_MAP.put("closed", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ATTRIBUTES_NAME_MAP.put("degree", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "uint_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "control_vertices"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "control_vertices"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_type/group/control_vertices"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "control_vertices"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "control_vertices"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("degree");
        REQUIRED_ATTRIBUTES.add("degree");
    }

    public NurbsType(XmlComplexType elem) {
        super(elem, NurbsType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), NurbsType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public NurbsTypeGroupControlVertices getControlVertices()
        throws IOException
    {
        if (controlVertices == null) {
            try {
                controlVertices = ((NurbsTypeGroupControlVertices) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "control_vertices"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_type/group/control_vertices"), NurbsType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return controlVertices;
    }

    public SourceType[] getSource()
        throws IOException
    {
        if (source == null) {
            try {
                source = ((SourceType[]) getChildren(new SourceType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type"), NurbsType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return source;
    }

}
