
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class MotionAxisInfoType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((bind[ ]+){0,}(newparam[ ]+){0,}(setparam[ ]+){0,}(speed[ ]+){0,1}(acceleration[ ]+){0,1}(deceleration[ ]+){0,1}(jerk[ ]+){0,1}){1}";
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
    protected CommonFloatOrParamType speed;
    protected CommonFloatOrParamType acceleration;
    protected KinematicsSetparamType[] setparam;
    protected CommonFloatOrParamType deceleration;
    protected CommonFloatOrParamType jerk;
    protected KinematicsNewparamType[] newparam;
    protected KinematicsBindType[] bind;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ATTRIBUTES_NAME_MAP.put("axis", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "speed"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "speed"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "speed"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "speed"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "acceleration"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "acceleration"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "acceleration"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "acceleration"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "setparam"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "setparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_setparam_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "setparam"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "deceleration"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "deceleration"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "deceleration"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "deceleration"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "jerk"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "jerk"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "jerk"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "jerk"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_newparam_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_bind_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("sid");
        ALLOWED_ATTRIBUTES.add("axis");
        REQUIRED_ATTRIBUTES.add("axis");
    }

    public MotionAxisInfoType(XmlComplexType elem) {
        super(elem, MotionAxisInfoType.class);
    }

    public CommonFloatOrParamType getSpeed()
        throws IOException
    {
        if (speed == null) {
            try {
                speed = ((CommonFloatOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "speed"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"), MotionAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return speed;
    }

    public CommonFloatOrParamType getAcceleration()
        throws IOException
    {
        if (acceleration == null) {
            try {
                acceleration = ((CommonFloatOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "acceleration"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"), MotionAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return acceleration;
    }

    public KinematicsSetparamType[] getSetparam()
        throws IOException
    {
        if (setparam == null) {
            try {
                setparam = ((KinematicsSetparamType[]) getChildren(new KinematicsSetparamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "setparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_setparam_type"), MotionAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return setparam;
    }

    public CommonFloatOrParamType getDeceleration()
        throws IOException
    {
        if (deceleration == null) {
            try {
                deceleration = ((CommonFloatOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "deceleration"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"), MotionAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return deceleration;
    }

    public CommonFloatOrParamType getJerk()
        throws IOException
    {
        if (jerk == null) {
            try {
                jerk = ((CommonFloatOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "jerk"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"), MotionAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return jerk;
    }

    public KinematicsNewparamType[] getNewparam()
        throws IOException
    {
        if (newparam == null) {
            try {
                newparam = ((KinematicsNewparamType[]) getChildren(new KinematicsNewparamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_newparam_type"), MotionAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return newparam;
    }

    public KinematicsBindType[] getBind()
        throws IOException
    {
        if (bind == null) {
            try {
                bind = ((KinematicsBindType[]) getChildren(new KinematicsBindType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_bind_type"), MotionAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bind;
    }

}
