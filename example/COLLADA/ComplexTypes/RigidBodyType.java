
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class RigidBodyType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((technique_common[ ]+){1}(technique[ ]+){0,}(extra[ ]+){0,}){1}";
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
    protected RigidBodyTypeGroupTechniqueCommon techniqueCommon;
    protected TechniqueType[] technique;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_body_type/group/technique_common"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("id");
        ALLOWED_ATTRIBUTES.add("sid");
        REQUIRED_ATTRIBUTES.add("sid");
    }

    public RigidBodyType(XmlComplexType elem) {
        super(elem, RigidBodyType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), RigidBodyType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public RigidBodyTypeGroupTechniqueCommon getTechniqueCommon()
        throws IOException
    {
        if (techniqueCommon == null) {
            try {
                techniqueCommon = ((RigidBodyTypeGroupTechniqueCommon) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_body_type/group/technique_common"), RigidBodyType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return techniqueCommon;
    }

    public TechniqueType[] getTechnique()
        throws IOException
    {
        if (technique == null) {
            try {
                technique = ((TechniqueType[]) getChildren(new TechniqueType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_type"), RigidBodyType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return technique;
    }

}
