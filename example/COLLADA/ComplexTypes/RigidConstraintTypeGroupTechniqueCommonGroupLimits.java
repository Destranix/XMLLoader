
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class RigidConstraintTypeGroupTechniqueCommonGroupLimits
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((swing_cone_and_twist[ ]+){0,1}(linear[ ]+){0,1}){1}";
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
    protected RigidConstraintTypeGroupTechniqueCommonGroupLimitsGroupSwingConeAndTwist swingConeAndTwist;
    protected RigidConstraintTypeGroupTechniqueCommonGroupLimitsGroupLinear linear;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swing_cone_and_twist"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swing_cone_and_twist"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/limits/group/swing_cone_and_twist"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swing_cone_and_twist"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swing_cone_and_twist"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/limits/group/linear"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupLimits(XmlComplexType elem) {
        super(elem, RigidConstraintTypeGroupTechniqueCommonGroupLimits.class);
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupLimitsGroupSwingConeAndTwist getSwingConeAndTwist()
        throws IOException
    {
        if (swingConeAndTwist == null) {
            try {
                swingConeAndTwist = ((RigidConstraintTypeGroupTechniqueCommonGroupLimitsGroupSwingConeAndTwist) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swing_cone_and_twist"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/limits/group/swing_cone_and_twist"), RigidConstraintTypeGroupTechniqueCommonGroupLimits.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return swingConeAndTwist;
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupLimitsGroupLinear getLinear()
        throws IOException
    {
        if (linear == null) {
            try {
                linear = ((RigidConstraintTypeGroupTechniqueCommonGroupLimitsGroupLinear) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/limits/group/linear"), RigidConstraintTypeGroupTechniqueCommonGroupLimits.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return linear;
    }

}
