
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class RigidConstraintTypeGroupTechniqueCommonGroupSpring
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((angular[ ]+){0,1}(linear[ ]+){0,1}){1}";
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
    protected RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupAngular angular;
    protected RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear linear;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/spring/group/angular"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/spring/group/linear"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupSpring(XmlComplexType elem) {
        super(elem, RigidConstraintTypeGroupTechniqueCommonGroupSpring.class);
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupAngular getAngular()
        throws IOException
    {
        if (angular == null) {
            try {
                angular = ((RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupAngular) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/spring/group/angular"), RigidConstraintTypeGroupTechniqueCommonGroupSpring.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return angular;
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear getLinear()
        throws IOException
    {
        if (linear == null) {
            try {
                linear = ((RigidConstraintTypeGroupTechniqueCommonGroupSpringGroupLinear) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/spring/group/linear"), RigidConstraintTypeGroupTechniqueCommonGroupSpring.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return linear;
    }

}
