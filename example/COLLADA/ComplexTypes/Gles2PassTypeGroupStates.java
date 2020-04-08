
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class Gles2PassTypeGroupStates
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((blend_color[ ]+){1}|(blend_equation[ ]+){1}|(blend_equation_separate[ ]+){1}|(blend_func[ ]+){1}|(blend_func_separate[ ]+){1}|(color_mask[ ]+){1}|(cull_face[ ]+){1}|(depth_func[ ]+){1}|(depth_mask[ ]+){1}|(depth_range[ ]+){1}|(front_face[ ]+){1}|(line_width[ ]+){1}|(polygon_offset[ ]+){1}|(point_size[ ]+){1}|(sample_coverage[ ]+){1}|(scissor[ ]+){1}|(stencil_func[ ]+){1}|(stencil_func_separate[ ]+){1}|(stencil_mask[ ]+){1}|(stencil_mask_separate[ ]+){1}|(stencil_op[ ]+){1}|(stencil_op_separate[ ]+){1}|(blend_enable[ ]+){1}|(cull_face_enable[ ]+){1}|(depth_test_enable[ ]+){1}|(dither_enable[ ]+){1}|(polygon_offset_fill_enable[ ]+){1}|(point_size_enable[ ]+){1}|(sample_alpha_to_coverage_enable[ ]+){1}|(sample_coverage_enable[ ]+){1}|(scissor_test_enable[ ]+){1}|(stencil_test_enable[ ]+){1}){0,1}){1}){0,}";
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
    protected Gles2PipelineSettingsGroupGroupBlendColor[] blendColor;
    protected Gles2PipelineSettingsGroupGroupBlendFuncSeparate[] blendFuncSeparate;
    protected Gles2PipelineSettingsGroupGroupDepthMask[] depthMask;
    protected Gles2PipelineSettingsGroupGroupBlendEquation[] blendEquation;
    protected Gles2PipelineSettingsGroupGroupSampleAlphaToCoverageEnable[] sampleAlphaToCoverageEnable;
    protected Gles2PipelineSettingsGroupGroupDitherEnable[] ditherEnable;
    protected Gles2PipelineSettingsGroupGroupSampleCoverageEnable[] sampleCoverageEnable;
    protected Gles2PipelineSettingsGroupGroupFrontFace[] frontFace;
    protected Gles2PipelineSettingsGroupGroupStencilTestEnable[] stencilTestEnable;
    protected Gles2PipelineSettingsGroupGroupColorMask[] colorMask;
    protected Gles2PipelineSettingsGroupGroupSampleCoverage[] sampleCoverage;
    protected Gles2PipelineSettingsGroupGroupStencilMask[] stencilMask;
    protected Gles2PipelineSettingsGroupGroupPointSizeEnable[] pointSizeEnable;
    protected Gles2PipelineSettingsGroupGroupCullFace[] cullFace;
    protected Gles2PipelineSettingsGroupGroupDepthRange[] depthRange;
    protected Gles2PipelineSettingsGroupGroupStencilOp[] stencilOp;
    protected Gles2PipelineSettingsGroupGroupCullFaceEnable[] cullFaceEnable;
    protected Gles2PipelineSettingsGroupGroupStencilFunc[] stencilFunc;
    protected Gles2PipelineSettingsGroupGroupDepthTestEnable[] depthTestEnable;
    protected Gles2PipelineSettingsGroupGroupDepthFunc[] depthFunc;
    protected Gles2PipelineSettingsGroupGroupPointSize[] pointSize;
    protected Gles2PipelineSettingsGroupGroupBlendEnable[] blendEnable;
    protected Gles2PipelineSettingsGroupGroupPolygonOffsetFillEnable[] polygonOffsetFillEnable;
    protected Gles2PipelineSettingsGroupGroupStencilFuncSeparate[] stencilFuncSeparate;
    protected Gles2PipelineSettingsGroupGroupStencilMaskSeparate[] stencilMaskSeparate;
    protected Gles2PipelineSettingsGroupGroupStencilOpSeparate[] stencilOpSeparate;
    protected Gles2PipelineSettingsGroupGroupBlendFunc[] blendFunc;
    protected Gles2PipelineSettingsGroupGroupBlendEquationSeparate[] blendEquationSeparate;
    protected Gles2PipelineSettingsGroupGroupScissor[] scissor;
    protected Gles2PipelineSettingsGroupGroupLineWidth[] lineWidth;
    protected Gles2PipelineSettingsGroupGroupPolygonOffset[] polygonOffset;
    protected Gles2PipelineSettingsGroupGroupScissorTestEnable[] scissorTestEnable;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_color"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_color"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_color"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/depth_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_equation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/sample_alpha_to_coverage_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/dither_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/sample_coverage_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/front_face"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/color_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/sample_coverage"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/point_size_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/cull_face"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/depth_range"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_op"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/cull_face_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/depth_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/depth_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/point_size"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/polygon_offset_fill_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_func_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_mask_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_op_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_equation_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/scissor"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/line_width"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/polygon_offset"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/scissor_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public Gles2PassTypeGroupStates(XmlComplexType elem) {
        super(elem, Gles2PassTypeGroupStates.class);
    }

    public Gles2PipelineSettingsGroupGroupBlendColor[] getBlendColor()
        throws IOException
    {
        if (blendColor == null) {
            try {
                blendColor = ((Gles2PipelineSettingsGroupGroupBlendColor[]) getChildren(new Gles2PipelineSettingsGroupGroupBlendColor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_color"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendColor;
    }

    public Gles2PipelineSettingsGroupGroupBlendFuncSeparate[] getBlendFuncSeparate()
        throws IOException
    {
        if (blendFuncSeparate == null) {
            try {
                blendFuncSeparate = ((Gles2PipelineSettingsGroupGroupBlendFuncSeparate[]) getChildren(new Gles2PipelineSettingsGroupGroupBlendFuncSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func_separate"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendFuncSeparate;
    }

    public Gles2PipelineSettingsGroupGroupDepthMask[] getDepthMask()
        throws IOException
    {
        if (depthMask == null) {
            try {
                depthMask = ((Gles2PipelineSettingsGroupGroupDepthMask[]) getChildren(new Gles2PipelineSettingsGroupGroupDepthMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/depth_mask"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthMask;
    }

    public Gles2PipelineSettingsGroupGroupBlendEquation[] getBlendEquation()
        throws IOException
    {
        if (blendEquation == null) {
            try {
                blendEquation = ((Gles2PipelineSettingsGroupGroupBlendEquation[]) getChildren(new Gles2PipelineSettingsGroupGroupBlendEquation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_equation"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendEquation;
    }

    public Gles2PipelineSettingsGroupGroupSampleAlphaToCoverageEnable[] getSampleAlphaToCoverageEnable()
        throws IOException
    {
        if (sampleAlphaToCoverageEnable == null) {
            try {
                sampleAlphaToCoverageEnable = ((Gles2PipelineSettingsGroupGroupSampleAlphaToCoverageEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupSampleAlphaToCoverageEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/sample_alpha_to_coverage_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleAlphaToCoverageEnable;
    }

    public Gles2PipelineSettingsGroupGroupDitherEnable[] getDitherEnable()
        throws IOException
    {
        if (ditherEnable == null) {
            try {
                ditherEnable = ((Gles2PipelineSettingsGroupGroupDitherEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupDitherEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/dither_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ditherEnable;
    }

    public Gles2PipelineSettingsGroupGroupSampleCoverageEnable[] getSampleCoverageEnable()
        throws IOException
    {
        if (sampleCoverageEnable == null) {
            try {
                sampleCoverageEnable = ((Gles2PipelineSettingsGroupGroupSampleCoverageEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupSampleCoverageEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/sample_coverage_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleCoverageEnable;
    }

    public Gles2PipelineSettingsGroupGroupFrontFace[] getFrontFace()
        throws IOException
    {
        if (frontFace == null) {
            try {
                frontFace = ((Gles2PipelineSettingsGroupGroupFrontFace[]) getChildren(new Gles2PipelineSettingsGroupGroupFrontFace[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/front_face"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return frontFace;
    }

    public Gles2PipelineSettingsGroupGroupStencilTestEnable[] getStencilTestEnable()
        throws IOException
    {
        if (stencilTestEnable == null) {
            try {
                stencilTestEnable = ((Gles2PipelineSettingsGroupGroupStencilTestEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupStencilTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_test_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilTestEnable;
    }

    public Gles2PipelineSettingsGroupGroupColorMask[] getColorMask()
        throws IOException
    {
        if (colorMask == null) {
            try {
                colorMask = ((Gles2PipelineSettingsGroupGroupColorMask[]) getChildren(new Gles2PipelineSettingsGroupGroupColorMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/color_mask"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorMask;
    }

    public Gles2PipelineSettingsGroupGroupSampleCoverage[] getSampleCoverage()
        throws IOException
    {
        if (sampleCoverage == null) {
            try {
                sampleCoverage = ((Gles2PipelineSettingsGroupGroupSampleCoverage[]) getChildren(new Gles2PipelineSettingsGroupGroupSampleCoverage[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/sample_coverage"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleCoverage;
    }

    public Gles2PipelineSettingsGroupGroupStencilMask[] getStencilMask()
        throws IOException
    {
        if (stencilMask == null) {
            try {
                stencilMask = ((Gles2PipelineSettingsGroupGroupStencilMask[]) getChildren(new Gles2PipelineSettingsGroupGroupStencilMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_mask"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilMask;
    }

    public Gles2PipelineSettingsGroupGroupPointSizeEnable[] getPointSizeEnable()
        throws IOException
    {
        if (pointSizeEnable == null) {
            try {
                pointSizeEnable = ((Gles2PipelineSettingsGroupGroupPointSizeEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupPointSizeEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/point_size_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSizeEnable;
    }

    public Gles2PipelineSettingsGroupGroupCullFace[] getCullFace()
        throws IOException
    {
        if (cullFace == null) {
            try {
                cullFace = ((Gles2PipelineSettingsGroupGroupCullFace[]) getChildren(new Gles2PipelineSettingsGroupGroupCullFace[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/cull_face"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cullFace;
    }

    public Gles2PipelineSettingsGroupGroupDepthRange[] getDepthRange()
        throws IOException
    {
        if (depthRange == null) {
            try {
                depthRange = ((Gles2PipelineSettingsGroupGroupDepthRange[]) getChildren(new Gles2PipelineSettingsGroupGroupDepthRange[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/depth_range"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthRange;
    }

    public Gles2PipelineSettingsGroupGroupStencilOp[] getStencilOp()
        throws IOException
    {
        if (stencilOp == null) {
            try {
                stencilOp = ((Gles2PipelineSettingsGroupGroupStencilOp[]) getChildren(new Gles2PipelineSettingsGroupGroupStencilOp[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_op"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilOp;
    }

    public Gles2PipelineSettingsGroupGroupCullFaceEnable[] getCullFaceEnable()
        throws IOException
    {
        if (cullFaceEnable == null) {
            try {
                cullFaceEnable = ((Gles2PipelineSettingsGroupGroupCullFaceEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupCullFaceEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/cull_face_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cullFaceEnable;
    }

    public Gles2PipelineSettingsGroupGroupStencilFunc[] getStencilFunc()
        throws IOException
    {
        if (stencilFunc == null) {
            try {
                stencilFunc = ((Gles2PipelineSettingsGroupGroupStencilFunc[]) getChildren(new Gles2PipelineSettingsGroupGroupStencilFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_func"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilFunc;
    }

    public Gles2PipelineSettingsGroupGroupDepthTestEnable[] getDepthTestEnable()
        throws IOException
    {
        if (depthTestEnable == null) {
            try {
                depthTestEnable = ((Gles2PipelineSettingsGroupGroupDepthTestEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupDepthTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/depth_test_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthTestEnable;
    }

    public Gles2PipelineSettingsGroupGroupDepthFunc[] getDepthFunc()
        throws IOException
    {
        if (depthFunc == null) {
            try {
                depthFunc = ((Gles2PipelineSettingsGroupGroupDepthFunc[]) getChildren(new Gles2PipelineSettingsGroupGroupDepthFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/depth_func"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthFunc;
    }

    public Gles2PipelineSettingsGroupGroupPointSize[] getPointSize()
        throws IOException
    {
        if (pointSize == null) {
            try {
                pointSize = ((Gles2PipelineSettingsGroupGroupPointSize[]) getChildren(new Gles2PipelineSettingsGroupGroupPointSize[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/point_size"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSize;
    }

    public Gles2PipelineSettingsGroupGroupBlendEnable[] getBlendEnable()
        throws IOException
    {
        if (blendEnable == null) {
            try {
                blendEnable = ((Gles2PipelineSettingsGroupGroupBlendEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupBlendEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendEnable;
    }

    public Gles2PipelineSettingsGroupGroupPolygonOffsetFillEnable[] getPolygonOffsetFillEnable()
        throws IOException
    {
        if (polygonOffsetFillEnable == null) {
            try {
                polygonOffsetFillEnable = ((Gles2PipelineSettingsGroupGroupPolygonOffsetFillEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupPolygonOffsetFillEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/polygon_offset_fill_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonOffsetFillEnable;
    }

    public Gles2PipelineSettingsGroupGroupStencilFuncSeparate[] getStencilFuncSeparate()
        throws IOException
    {
        if (stencilFuncSeparate == null) {
            try {
                stencilFuncSeparate = ((Gles2PipelineSettingsGroupGroupStencilFuncSeparate[]) getChildren(new Gles2PipelineSettingsGroupGroupStencilFuncSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_func_separate"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilFuncSeparate;
    }

    public Gles2PipelineSettingsGroupGroupStencilMaskSeparate[] getStencilMaskSeparate()
        throws IOException
    {
        if (stencilMaskSeparate == null) {
            try {
                stencilMaskSeparate = ((Gles2PipelineSettingsGroupGroupStencilMaskSeparate[]) getChildren(new Gles2PipelineSettingsGroupGroupStencilMaskSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_mask_separate"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilMaskSeparate;
    }

    public Gles2PipelineSettingsGroupGroupStencilOpSeparate[] getStencilOpSeparate()
        throws IOException
    {
        if (stencilOpSeparate == null) {
            try {
                stencilOpSeparate = ((Gles2PipelineSettingsGroupGroupStencilOpSeparate[]) getChildren(new Gles2PipelineSettingsGroupGroupStencilOpSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/stencil_op_separate"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilOpSeparate;
    }

    public Gles2PipelineSettingsGroupGroupBlendFunc[] getBlendFunc()
        throws IOException
    {
        if (blendFunc == null) {
            try {
                blendFunc = ((Gles2PipelineSettingsGroupGroupBlendFunc[]) getChildren(new Gles2PipelineSettingsGroupGroupBlendFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendFunc;
    }

    public Gles2PipelineSettingsGroupGroupBlendEquationSeparate[] getBlendEquationSeparate()
        throws IOException
    {
        if (blendEquationSeparate == null) {
            try {
                blendEquationSeparate = ((Gles2PipelineSettingsGroupGroupBlendEquationSeparate[]) getChildren(new Gles2PipelineSettingsGroupGroupBlendEquationSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_equation_separate"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendEquationSeparate;
    }

    public Gles2PipelineSettingsGroupGroupScissor[] getScissor()
        throws IOException
    {
        if (scissor == null) {
            try {
                scissor = ((Gles2PipelineSettingsGroupGroupScissor[]) getChildren(new Gles2PipelineSettingsGroupGroupScissor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/scissor"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scissor;
    }

    public Gles2PipelineSettingsGroupGroupLineWidth[] getLineWidth()
        throws IOException
    {
        if (lineWidth == null) {
            try {
                lineWidth = ((Gles2PipelineSettingsGroupGroupLineWidth[]) getChildren(new Gles2PipelineSettingsGroupGroupLineWidth[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/line_width"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lineWidth;
    }

    public Gles2PipelineSettingsGroupGroupPolygonOffset[] getPolygonOffset()
        throws IOException
    {
        if (polygonOffset == null) {
            try {
                polygonOffset = ((Gles2PipelineSettingsGroupGroupPolygonOffset[]) getChildren(new Gles2PipelineSettingsGroupGroupPolygonOffset[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/polygon_offset"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonOffset;
    }

    public Gles2PipelineSettingsGroupGroupScissorTestEnable[] getScissorTestEnable()
        throws IOException
    {
        if (scissorTestEnable == null) {
            try {
                scissorTestEnable = ((Gles2PipelineSettingsGroupGroupScissorTestEnable[]) getChildren(new Gles2PipelineSettingsGroupGroupScissorTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/scissor_test_enable"), Gles2PassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scissorTestEnable;
    }

}
