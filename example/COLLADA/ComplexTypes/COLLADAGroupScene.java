
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class COLLADAGroupScene
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((instance_physics_scene[ ]+){0,}(instance_visual_scene[ ]+){0,1}(instance_kinematics_scene[ ]+){0,}(extra[ ]+){0,}){1}";
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
    protected InstanceKinematicsSceneType[] instanceKinematicsScene;
    protected InstanceWithExtraType instanceVisualScene;
    protected InstanceWithExtraType[] instancePhysicsScene;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_kinematics_scene"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_kinematics_scene"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_kinematics_scene_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_kinematics_scene"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_visual_scene"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_visual_scene"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_with_extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_visual_scene"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_visual_scene"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_scene"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_scene"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_with_extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_scene"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public COLLADAGroupScene(XmlComplexType elem) {
        super(elem, COLLADAGroupScene.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), COLLADAGroupScene.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public InstanceKinematicsSceneType[] getInstanceKinematicsScene()
        throws IOException
    {
        if (instanceKinematicsScene == null) {
            try {
                instanceKinematicsScene = ((InstanceKinematicsSceneType[]) getChildren(new InstanceKinematicsSceneType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_kinematics_scene"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_kinematics_scene_type"), COLLADAGroupScene.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceKinematicsScene;
    }

    public InstanceWithExtraType getInstanceVisualScene()
        throws IOException
    {
        if (instanceVisualScene == null) {
            try {
                instanceVisualScene = ((InstanceWithExtraType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_visual_scene"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_with_extra_type"), COLLADAGroupScene.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceVisualScene;
    }

    public InstanceWithExtraType[] getInstancePhysicsScene()
        throws IOException
    {
        if (instancePhysicsScene == null) {
            try {
                instancePhysicsScene = ((InstanceWithExtraType[]) getChildren(new InstanceWithExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_scene"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_with_extra_type"), COLLADAGroupScene.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instancePhysicsScene;
    }

}
