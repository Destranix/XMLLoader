
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((stiffness[ ]+){0,1}(damping[ ]+){0,1}(target_value[ ]+){0,1}){1}";
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
    protected TargetableFloatType damping;
    protected TargetableFloatType stiffness;
    protected TargetableFloatType targetValue;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "damping"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "damping"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "damping"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "damping"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stiffness"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stiffness"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stiffness"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stiffness"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "target_value"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "target_value"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "target_value"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "target_value"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear(XmlComplexType elem) {
        super(elem, RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear.class);
    }

    public TargetableFloatType getDamping()
        throws IOException
    {
        if (damping == null) {
            try {
                damping = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "damping"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return damping;
    }

    public TargetableFloatType getStiffness()
        throws IOException
    {
        if (stiffness == null) {
            try {
                stiffness = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stiffness"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stiffness;
    }

    public TargetableFloatType getTargetValue()
        throws IOException
    {
        if (targetValue == null) {
            try {
                targetValue = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "target_value"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return targetValue;
    }

}
