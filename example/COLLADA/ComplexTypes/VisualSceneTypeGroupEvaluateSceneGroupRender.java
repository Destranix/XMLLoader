
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlNCName;

public final class VisualSceneTypeGroupEvaluateSceneGroupRender
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((layer[ ]+){0,}(instance_material[ ]+){0,1}(extra[ ]+){0,}){1}";
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
    protected VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial instanceMaterial;
    protected ExtraType[] extra;
    protected XmlNCName[] layer;

    static {
        ALLOWED_ATTRIBUTES.add("camera_node");
        try {
            ATTRIBUTES_NAME_MAP.put("camera_node", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_material"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "visual_scene_type/group/evaluate_scene/group/render/group/instance_material"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_material"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_material"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "layer"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "layer"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "layer"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("name");
        ALLOWED_ATTRIBUTES.add("sid");
    }

    public VisualSceneTypeGroupEvaluateSceneGroupRender(XmlComplexType elem) {
        super(elem, VisualSceneTypeGroupEvaluateSceneGroupRender.class);
    }

    public VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial getInstanceMaterial()
        throws IOException
    {
        if (instanceMaterial == null) {
            try {
                instanceMaterial = ((VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "visual_scene_type/group/evaluate_scene/group/render/group/instance_material"), VisualSceneTypeGroupEvaluateSceneGroupRender.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceMaterial;
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), VisualSceneTypeGroupEvaluateSceneGroupRender.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public XmlNCName[] getLayer()
        throws IOException
    {
        if (layer == null) {
            try {
                layer = ((XmlNCName[]) getChildren(new XmlNCName[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "layer"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"), VisualSceneTypeGroupEvaluateSceneGroupRender.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return layer;
    }

}
