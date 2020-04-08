
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class KinematicsTechniqueType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((axis_info[ ]+){0,}(frame_origin[ ]+){1}(frame_tip[ ]+){1}(frame_tcp[ ]+){0,1}(frame_object[ ]+){0,1}){1}";
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
    protected KinematicsAxisInfoType[] axisInfo;
    protected KinematicsFrameType frameOrigin;
    protected KinematicsFrameType frameTcp;
    protected KinematicsFrameType frameObject;
    protected KinematicsFrameType frameTip;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis_info"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis_info"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_axis_info_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis_info"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_origin"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_origin"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_frame_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_origin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_origin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tcp"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tcp"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_frame_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tcp"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tcp"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_object"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_object"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_frame_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_object"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_object"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tip"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tip"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_frame_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tip"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tip"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public KinematicsTechniqueType(XmlComplexType elem) {
        super(elem, KinematicsTechniqueType.class);
    }

    public KinematicsAxisInfoType[] getAxisInfo()
        throws IOException
    {
        if (axisInfo == null) {
            try {
                axisInfo = ((KinematicsAxisInfoType[]) getChildren(new KinematicsAxisInfoType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis_info"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_axis_info_type"), KinematicsTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return axisInfo;
    }

    public KinematicsFrameType getFrameOrigin()
        throws IOException
    {
        if (frameOrigin == null) {
            try {
                frameOrigin = ((KinematicsFrameType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_origin"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_frame_type"), KinematicsTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return frameOrigin;
    }

    public KinematicsFrameType getFrameTcp()
        throws IOException
    {
        if (frameTcp == null) {
            try {
                frameTcp = ((KinematicsFrameType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tcp"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_frame_type"), KinematicsTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return frameTcp;
    }

    public KinematicsFrameType getFrameObject()
        throws IOException
    {
        if (frameObject == null) {
            try {
                frameObject = ((KinematicsFrameType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_object"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_frame_type"), KinematicsTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return frameObject;
    }

    public KinematicsFrameType getFrameTip()
        throws IOException
    {
        if (frameTip == null) {
            try {
                frameTip = ((KinematicsFrameType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "frame_tip"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_frame_type"), KinematicsTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return frameTip;
    }

}
