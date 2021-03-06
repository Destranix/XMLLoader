
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class MotionTechniqueType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((axis_info[ ]+){0,}(effector_info[ ]+){0,1}){1}";
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
    protected MotionAxisInfoType[] axisInfo;
    protected MotionEffectorInfoType effectorInfo;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis_info"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis_info"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "motion_axis_info_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis_info"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "effector_info"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "effector_info"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "motion_effector_info_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "effector_info"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "effector_info"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public MotionTechniqueType(XmlComplexType elem) {
        super(elem, MotionTechniqueType.class);
    }

    public MotionAxisInfoType[] getAxisInfo()
        throws IOException
    {
        if (axisInfo == null) {
            try {
                axisInfo = ((MotionAxisInfoType[]) getChildren(new MotionAxisInfoType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis_info"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "motion_axis_info_type"), MotionTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return axisInfo;
    }

    public MotionEffectorInfoType getEffectorInfo()
        throws IOException
    {
        if (effectorInfo == null) {
            try {
                effectorInfo = ((MotionEffectorInfoType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "effector_info"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "motion_effector_info_type"), MotionTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return effectorInfo;
    }

}
