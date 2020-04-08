
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class PhysicsMaterialTypeGroupTechniqueCommon
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((dynamic_friction[ ]+){0,1}(restitution[ ]+){0,1}(static_friction[ ]+){0,1}){1}";
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
    protected TargetableFloatType staticFriction;
    protected TargetableFloatType dynamicFriction;
    protected TargetableFloatType restitution;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "static_friction"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "static_friction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "static_friction"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "static_friction"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic_friction"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic_friction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic_friction"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic_friction"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "restitution"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "restitution"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "restitution"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "restitution"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public PhysicsMaterialTypeGroupTechniqueCommon(XmlComplexType elem) {
        super(elem, PhysicsMaterialTypeGroupTechniqueCommon.class);
    }

    public TargetableFloatType getStaticFriction()
        throws IOException
    {
        if (staticFriction == null) {
            try {
                staticFriction = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "static_friction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), PhysicsMaterialTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return staticFriction;
    }

    public TargetableFloatType getDynamicFriction()
        throws IOException
    {
        if (dynamicFriction == null) {
            try {
                dynamicFriction = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic_friction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), PhysicsMaterialTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return dynamicFriction;
    }

    public TargetableFloatType getRestitution()
        throws IOException
    {
        if (restitution == null) {
            try {
                restitution = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "restitution"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), PhysicsMaterialTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return restitution;
    }

}
