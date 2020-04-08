
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.FxDrawType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((color_target[ ]+){0,}(depth_target[ ]+){0,}(stencil_target[ ]+){0,}(color_clear[ ]+){0,}(depth_clear[ ]+){0,}(stencil_clear[ ]+){0,}(draw[ ]+){0,1}){1}";
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
    protected FxDrawType draw;
    protected FxClearcolorType[] colorClear;
    protected FxCleardepthType[] depthClear;
    protected FxDepthtargetType[] depthTarget;
    protected FxClearstencilType[] stencilClear;
    protected FxStenciltargetType[] stencilTarget;
    protected FxColortargetType[] colorTarget;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "draw"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "draw"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_draw_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "draw"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "draw"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_clear"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_clear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_clearcolor_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_clear"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_clear"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_clear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_cleardepth_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_clear"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_target"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_target"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_depthtarget_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_target"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_clear"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_clear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_clearstencil_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_clear"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_target"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_target"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_stenciltarget_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_target"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_target"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_target"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_colortarget_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_target"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate(XmlComplexType elem) {
        super(elem, ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate.class);
    }

    public FxDrawType getDraw()
        throws IOException
    {
        if (draw == null) {
            try {
                draw = ((FxDrawType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "draw"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_draw_type"), ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return draw;
    }

    public FxClearcolorType[] getColorClear()
        throws IOException
    {
        if (colorClear == null) {
            try {
                colorClear = ((FxClearcolorType[]) getChildren(new FxClearcolorType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_clear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_clearcolor_type"), ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorClear;
    }

    public FxCleardepthType[] getDepthClear()
        throws IOException
    {
        if (depthClear == null) {
            try {
                depthClear = ((FxCleardepthType[]) getChildren(new FxCleardepthType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_clear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_cleardepth_type"), ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthClear;
    }

    public FxDepthtargetType[] getDepthTarget()
        throws IOException
    {
        if (depthTarget == null) {
            try {
                depthTarget = ((FxDepthtargetType[]) getChildren(new FxDepthtargetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_target"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_depthtarget_type"), ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthTarget;
    }

    public FxClearstencilType[] getStencilClear()
        throws IOException
    {
        if (stencilClear == null) {
            try {
                stencilClear = ((FxClearstencilType[]) getChildren(new FxClearstencilType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_clear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_clearstencil_type"), ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilClear;
    }

    public FxStenciltargetType[] getStencilTarget()
        throws IOException
    {
        if (stencilTarget == null) {
            try {
                stencilTarget = ((FxStenciltargetType[]) getChildren(new FxStenciltargetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_target"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_stenciltarget_type"), ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilTarget;
    }

    public FxColortargetType[] getColorTarget()
        throws IOException
    {
        if (colorTarget == null) {
            try {
                colorTarget = ((FxColortargetType[]) getChildren(new FxColortargetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_target"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_colortarget_type"), ProfileGlesTypeGroupTechniqueGroupPassGroupEvaluate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorTarget;
    }

}
