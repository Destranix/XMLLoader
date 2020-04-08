
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class RigidConstraintTypeGroupTechniqueCommon
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((enabled[ ]+){0,1}(interpenetrate[ ]+){0,1}(limits[ ]+){0,1}(spring[ ]+){0,1}){1}";
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
    protected RigidConstraintTypeGroupTechniqueCommonGroupInterpenetrate interpenetrate;
    protected RigidConstraintTypeGroupTechniqueCommonGroupEnabled enabled;
    protected RigidConstraintTypeGroupTechniqueCommonGroupLimits limits;
    protected RigidConstraintTypeGroupTechniqueCommonGroupSpring spring;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "interpenetrate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "interpenetrate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/interpenetrate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "interpenetrate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "interpenetrate"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enabled"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enabled"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/enabled"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enabled"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enabled"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/limits"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spring"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spring"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/spring"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spring"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spring"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public RigidConstraintTypeGroupTechniqueCommon(XmlComplexType elem) {
        super(elem, RigidConstraintTypeGroupTechniqueCommon.class);
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupInterpenetrate getInterpenetrate()
        throws IOException
    {
        if (interpenetrate == null) {
            try {
                interpenetrate = ((RigidConstraintTypeGroupTechniqueCommonGroupInterpenetrate) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "interpenetrate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/interpenetrate"), RigidConstraintTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return interpenetrate;
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupEnabled getEnabled()
        throws IOException
    {
        if (enabled == null) {
            try {
                enabled = ((RigidConstraintTypeGroupTechniqueCommonGroupEnabled) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enabled"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/enabled"), RigidConstraintTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return enabled;
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupLimits getLimits()
        throws IOException
    {
        if (limits == null) {
            try {
                limits = ((RigidConstraintTypeGroupTechniqueCommonGroupLimits) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/limits"), RigidConstraintTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return limits;
    }

    public RigidConstraintTypeGroupTechniqueCommonGroupSpring getSpring()
        throws IOException
    {
        if (spring == null) {
            try {
                spring = ((RigidConstraintTypeGroupTechniqueCommonGroupSpring) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spring"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_constraint_type/group/technique_common/group/spring"), RigidConstraintTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return spring;
    }

}
