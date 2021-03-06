
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((technique_override[ ]+){0,1}(bind[ ]+){0,}(extra[ ]+){0,}){1}";
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
    protected VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterialGroupTechniqueOverride techniqueOverride;
    protected VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterialGroupBind[] bind;

    static {
        ALLOWED_ATTRIBUTES.add("url");
        REQUIRED_ATTRIBUTES.add("url");
        try {
            ATTRIBUTES_NAME_MAP.put("url", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_override"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_override"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "visual_scene_type/group/evaluate_scene/group/render/group/instance_material/group/technique_override"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_override"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_override"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "visual_scene_type/group/evaluate_scene/group/render/group/instance_material/group/bind"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial(XmlComplexType elem) {
        super(elem, VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterialGroupTechniqueOverride getTechniqueOverride()
        throws IOException
    {
        if (techniqueOverride == null) {
            try {
                techniqueOverride = ((VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterialGroupTechniqueOverride) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_override"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "visual_scene_type/group/evaluate_scene/group/render/group/instance_material/group/technique_override"), VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return techniqueOverride;
    }

    public VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterialGroupBind[] getBind()
        throws IOException
    {
        if (bind == null) {
            try {
                bind = ((VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterialGroupBind[]) getChildren(new VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterialGroupBind[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "visual_scene_type/group/evaluate_scene/group/render/group/instance_material/group/bind"), VisualSceneTypeGroupEvaluateSceneGroupRenderGroupInstanceMaterial.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bind;
    }

}
