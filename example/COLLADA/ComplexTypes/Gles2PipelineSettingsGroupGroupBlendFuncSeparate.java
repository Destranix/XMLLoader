
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class Gles2PipelineSettingsGroupGroupBlendFuncSeparate
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((src_rgb[ ]+){1}(dest_rgb[ ]+){1}(src_alpha[ ]+){1}(dest_alpha[ ]+){1}){1}";
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
    protected Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupDestRgb destRgb;
    protected Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupDestAlpha destAlpha;
    protected Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupSrcAlpha srcAlpha;
    protected Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupSrcRgb srcRgb;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_rgb"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_rgb"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate/group/dest_rgb"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_rgb"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_rgb"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_alpha"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_alpha"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate/group/dest_alpha"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_alpha"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_alpha"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_alpha"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_alpha"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate/group/src_alpha"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_alpha"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_alpha"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_rgb"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_rgb"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate/group/src_rgb"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_rgb"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_rgb"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public Gles2PipelineSettingsGroupGroupBlendFuncSeparate(XmlComplexType elem) {
        super(elem, Gles2PipelineSettingsGroupGroupBlendFuncSeparate.class);
    }

    public Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupDestRgb getDestRgb()
        throws IOException
    {
        if (destRgb == null) {
            try {
                destRgb = ((Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupDestRgb) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_rgb"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate/group/dest_rgb"), Gles2PipelineSettingsGroupGroupBlendFuncSeparate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return destRgb;
    }

    public Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupDestAlpha getDestAlpha()
        throws IOException
    {
        if (destAlpha == null) {
            try {
                destAlpha = ((Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupDestAlpha) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest_alpha"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate/group/dest_alpha"), Gles2PipelineSettingsGroupGroupBlendFuncSeparate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return destAlpha;
    }

    public Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupSrcAlpha getSrcAlpha()
        throws IOException
    {
        if (srcAlpha == null) {
            try {
                srcAlpha = ((Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupSrcAlpha) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_alpha"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate/group/src_alpha"), Gles2PipelineSettingsGroupGroupBlendFuncSeparate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return srcAlpha;
    }

    public Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupSrcRgb getSrcRgb()
        throws IOException
    {
        if (srcRgb == null) {
            try {
                srcRgb = ((Gles2PipelineSettingsGroupGroupBlendFuncSeparateGroupSrcRgb) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src_rgb"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate/group/src_rgb"), Gles2PipelineSettingsGroupGroupBlendFuncSeparate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return srcRgb;
    }

}
