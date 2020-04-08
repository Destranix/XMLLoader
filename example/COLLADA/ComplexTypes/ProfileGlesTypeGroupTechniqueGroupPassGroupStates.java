
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ProfileGlesTypeGroupTechniqueGroupPassGroupStates
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((alpha_func[ ]+){1}|(blend_func[ ]+){1}|(clip_plane[ ]+){1}|(color_mask[ ]+){1}|(cull_face[ ]+){1}|(depth_func[ ]+){1}|(depth_mask[ ]+){1}|(depth_range[ ]+){1}|(fog_color[ ]+){1}|(fog_density[ ]+){1}|(fog_mode[ ]+){1}|(fog_start[ ]+){1}|(fog_end[ ]+){1}|(front_face[ ]+){1}|(logic_op[ ]+){1}|(light_ambient[ ]+){1}|(light_diffuse[ ]+){1}|(light_specular[ ]+){1}|(light_position[ ]+){1}|(light_constant_attenuation[ ]+){1}|(light_linear_attenuation[ ]+){1}|(light_quadratic_attenuation[ ]+){1}|(light_spot_cutoff[ ]+){1}|(light_spot_direction[ ]+){1}|(light_spot_exponent[ ]+){1}|(light_model_ambient[ ]+){1}|(line_width[ ]+){1}|(material_ambient[ ]+){1}|(material_diffuse[ ]+){1}|(material_emission[ ]+){1}|(material_shininess[ ]+){1}|(material_specular[ ]+){1}|(model_view_matrix[ ]+){1}|(point_distance_attenuation[ ]+){1}|(point_fade_threshold_size[ ]+){1}|(point_size[ ]+){1}|(point_size_min[ ]+){1}|(point_size_max[ ]+){1}|(polygon_offset[ ]+){1}|(projection_matrix[ ]+){1}|(scissor[ ]+){1}|(shade_model[ ]+){1}|(stencil_func[ ]+){1}|(stencil_mask[ ]+){1}|(stencil_op[ ]+){1}|(texture_pipeline[ ]+){1}|(alpha_test_enable[ ]+){1}|(blend_enable[ ]+){1}|(clip_plane_enable[ ]+){1}|(color_logic_op_enable[ ]+){1}|(color_material_enable[ ]+){1}|(cull_face_enable[ ]+){1}|(depth_test_enable[ ]+){1}|(dither_enable[ ]+){1}|(fog_enable[ ]+){1}|(light_enable[ ]+){1}|(lighting_enable[ ]+){1}|(light_model_two_side_enable[ ]+){1}|(line_smooth_enable[ ]+){1}|(multisample_enable[ ]+){1}|(normalize_enable[ ]+){1}|(point_smooth_enable[ ]+){1}|(polygon_offset_fill_enable[ ]+){1}|(rescale_normal_enable[ ]+){1}|(sample_alpha_to_coverage_enable[ ]+){1}|(sample_alpha_to_one_enable[ ]+){1}|(sample_coverage_enable[ ]+){1}|(scissor_test_enable[ ]+){1}|(stencil_test_enable[ ]+){1}){0,1}){0,}){1}";
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
    protected GlesPipelineSettingsGroupGroupAlphaTestEnable[] alphaTestEnable;
    protected GlesPipelineSettingsGroupGroupDepthMask[] depthMask;
    protected GlesPipelineSettingsGroupGroupShadeModel[] shadeModel;
    protected GlesPipelineSettingsGroupGroupFogStart[] fogStart;
    protected GlesPipelineSettingsGroupGroupSampleAlphaToCoverageEnable[] sampleAlphaToCoverageEnable;
    protected GlesPipelineSettingsGroupGroupSampleAlphaToOneEnable[] sampleAlphaToOneEnable;
    protected GlesPipelineSettingsGroupGroupRescaleNormalEnable[] rescaleNormalEnable;
    protected GlesPipelineSettingsGroupGroupDitherEnable[] ditherEnable;
    protected GlesPipelineSettingsGroupGroupLightSpotDirection[] lightSpotDirection;
    protected GlesPipelineSettingsGroupGroupSampleCoverageEnable[] sampleCoverageEnable;
    protected GlesPipelineSettingsGroupGroupFrontFace[] frontFace;
    protected GlesPipelineSettingsGroupGroupLightSpecular[] lightSpecular;
    protected GlesPipelineSettingsGroupGroupStencilTestEnable[] stencilTestEnable;
    protected GlesPipelineSettingsGroupGroupLightAmbient[] lightAmbient;
    protected GlesPipelineSettingsGroupGroupColorMask[] colorMask;
    protected GlesPipelineSettingsGroupGroupLightModelTwoSideEnable[] lightModelTwoSideEnable;
    protected GlesPipelineSettingsGroupGroupFogEnd[] fogEnd;
    protected GlesPipelineSettingsGroupGroupStencilMask[] stencilMask;
    protected GlesPipelineSettingsGroupGroupClipPlane[] clipPlane;
    protected GlesPipelineSettingsGroupGroupFogColor[] fogColor;
    protected GlesPipelineSettingsGroupGroupLogicOp[] logicOp;
    protected GlesPipelineSettingsGroupGroupLightSpotCutoff[] lightSpotCutoff;
    protected GlesPipelineSettingsGroupGroupPointFadeThresholdSize[] pointFadeThresholdSize;
    protected GlesPipelineSettingsGroupGroupStencilOp[] stencilOp;
    protected GlesPipelineSettingsGroupGroupCullFaceEnable[] cullFaceEnable;
    protected GlesPipelineSettingsGroupGroupStencilFunc[] stencilFunc;
    protected GlesPipelineSettingsGroupGroupLineSmoothEnable[] lineSmoothEnable;
    protected GlesPipelineSettingsGroupGroupMaterialAmbient[] materialAmbient;
    protected GlesPipelineSettingsGroupGroupBlendEnable[] blendEnable;
    protected GlesPipelineSettingsGroupGroupClipPlaneEnable[] clipPlaneEnable;
    protected GlesPipelineSettingsGroupGroupLightLinearAttenuation[] lightLinearAttenuation;
    protected GlesPipelineSettingsGroupGroupLightModelAmbient[] lightModelAmbient;
    protected GlesPipelineSettingsGroupGroupTexturePipeline[] texturePipeline;
    protected GlesPipelineSettingsGroupGroupFogDensity[] fogDensity;
    protected GlesPipelineSettingsGroupGroupLightQuadraticAttenuation[] lightQuadraticAttenuation;
    protected GlesPipelineSettingsGroupGroupLightEnable[] lightEnable;
    protected GlesPipelineSettingsGroupGroupProjectionMatrix[] projectionMatrix;
    protected GlesPipelineSettingsGroupGroupMaterialEmission[] materialEmission;
    protected GlesPipelineSettingsGroupGroupPointDistanceAttenuation[] pointDistanceAttenuation;
    protected GlesPipelineSettingsGroupGroupScissorTestEnable[] scissorTestEnable;
    protected GlesPipelineSettingsGroupGroupMaterialSpecular[] materialSpecular;
    protected GlesPipelineSettingsGroupGroupLightDiffuse[] lightDiffuse;
    protected GlesPipelineSettingsGroupGroupColorMaterialEnable[] colorMaterialEnable;
    protected GlesPipelineSettingsGroupGroupLightConstantAttenuation[] lightConstantAttenuation;
    protected GlesPipelineSettingsGroupGroupLightSpotExponent[] lightSpotExponent;
    protected GlesPipelineSettingsGroupGroupPointSizeMin[] pointSizeMin;
    protected GlesPipelineSettingsGroupGroupMaterialDiffuse[] materialDiffuse;
    protected GlesPipelineSettingsGroupGroupLightPosition[] lightPosition;
    protected GlesPipelineSettingsGroupGroupColorLogicOpEnable[] colorLogicOpEnable;
    protected GlesPipelineSettingsGroupGroupPointSizeMax[] pointSizeMax;
    protected GlesPipelineSettingsGroupGroupAlphaFunc[] alphaFunc;
    protected GlesPipelineSettingsGroupGroupModelViewMatrix[] modelViewMatrix;
    protected GlesPipelineSettingsGroupGroupCullFace[] cullFace;
    protected GlesPipelineSettingsGroupGroupFogEnable[] fogEnable;
    protected GlesPipelineSettingsGroupGroupDepthRange[] depthRange;
    protected GlesPipelineSettingsGroupGroupPointSmoothEnable[] pointSmoothEnable;
    protected GlesPipelineSettingsGroupGroupDepthTestEnable[] depthTestEnable;
    protected GlesPipelineSettingsGroupGroupLightingEnable[] lightingEnable;
    protected GlesPipelineSettingsGroupGroupDepthFunc[] depthFunc;
    protected GlesPipelineSettingsGroupGroupPointSize[] pointSize;
    protected GlesPipelineSettingsGroupGroupMultisampleEnable[] multisampleEnable;
    protected GlesPipelineSettingsGroupGroupPolygonOffsetFillEnable[] polygonOffsetFillEnable;
    protected GlesPipelineSettingsGroupGroupMaterialShininess[] materialShininess;
    protected GlesPipelineSettingsGroupGroupFogMode[] fogMode;
    protected GlesPipelineSettingsGroupGroupBlendFunc[] blendFunc;
    protected GlesPipelineSettingsGroupGroupScissor[] scissor;
    protected GlesPipelineSettingsGroupGroupNormalizeEnable[] normalizeEnable;
    protected GlesPipelineSettingsGroupGroupLineWidth[] lineWidth;
    protected GlesPipelineSettingsGroupGroupPolygonOffset[] polygonOffset;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/alpha_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/depth_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shade_model"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shade_model"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/shade_model"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shade_model"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_start"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_start"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_start"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_start"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/sample_alpha_to_coverage_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_one_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_one_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/sample_alpha_to_one_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_one_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rescale_normal_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rescale_normal_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/rescale_normal_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rescale_normal_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/dither_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_direction"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_direction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_spot_direction"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_direction"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/sample_coverage_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/front_face"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_specular"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_specular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_specular"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_specular"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/stencil_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_ambient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_ambient"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_ambient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/color_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_two_side_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_two_side_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_model_two_side_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_two_side_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_end"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_end"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_end"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_end"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/stencil_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/clip_plane"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_color"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_color"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_color"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/logic_op"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_cutoff"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_cutoff"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_spot_cutoff"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_cutoff"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_fade_threshold_size"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_fade_threshold_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_fade_threshold_size"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_fade_threshold_size"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/stencil_op"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/cull_face_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/stencil_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_smooth_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/line_smooth_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_smooth_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_ambient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_ambient"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_ambient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/blend_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/clip_plane_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_linear_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_linear_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_linear_attenuation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_linear_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_ambient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_model_ambient"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_ambient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_pipeline"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_pipeline"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/texture_pipeline"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_pipeline"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_density"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_density"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_density"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_density"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_quadratic_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_quadratic_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_quadratic_attenuation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_quadratic_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "projection_matrix"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "projection_matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/projection_matrix"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "projection_matrix"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_emission"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_emission"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_emission"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_emission"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_distance_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_distance_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_distance_attenuation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_distance_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/scissor_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_specular"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_specular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_specular"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_specular"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_diffuse"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_diffuse"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_diffuse"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/color_material_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_constant_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_constant_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_constant_attenuation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_constant_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_exponent"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_exponent"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_spot_exponent"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_exponent"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_min"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_min"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_size_min"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_min"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_diffuse"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_diffuse"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_diffuse"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_position"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_position"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_position"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_position"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_logic_op_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_logic_op_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/color_logic_op_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_logic_op_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_max"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_max"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_size_max"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_max"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/alpha_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "model_view_matrix"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "model_view_matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/model_view_matrix"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "model_view_matrix"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/cull_face"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/depth_range"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_smooth_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_smooth_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_smooth_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/depth_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lighting_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lighting_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/lighting_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lighting_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/depth_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_size"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "multisample_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "multisample_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/multisample_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "multisample_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/polygon_offset_fill_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_shininess"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_shininess"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_shininess"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_shininess"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_mode"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_mode"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_mode"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/blend_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/scissor"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "normalize_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "normalize_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/normalize_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "normalize_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/line_width"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/polygon_offset"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ProfileGlesTypeGroupTechniqueGroupPassGroupStates(XmlComplexType elem) {
        super(elem, ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class);
    }

    public GlesPipelineSettingsGroupGroupAlphaTestEnable[] getAlphaTestEnable()
        throws IOException
    {
        if (alphaTestEnable == null) {
            try {
                alphaTestEnable = ((GlesPipelineSettingsGroupGroupAlphaTestEnable[]) getChildren(new GlesPipelineSettingsGroupGroupAlphaTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/alpha_test_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return alphaTestEnable;
    }

    public GlesPipelineSettingsGroupGroupDepthMask[] getDepthMask()
        throws IOException
    {
        if (depthMask == null) {
            try {
                depthMask = ((GlesPipelineSettingsGroupGroupDepthMask[]) getChildren(new GlesPipelineSettingsGroupGroupDepthMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/depth_mask"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthMask;
    }

    public GlesPipelineSettingsGroupGroupShadeModel[] getShadeModel()
        throws IOException
    {
        if (shadeModel == null) {
            try {
                shadeModel = ((GlesPipelineSettingsGroupGroupShadeModel[]) getChildren(new GlesPipelineSettingsGroupGroupShadeModel[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shade_model"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/shade_model"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return shadeModel;
    }

    public GlesPipelineSettingsGroupGroupFogStart[] getFogStart()
        throws IOException
    {
        if (fogStart == null) {
            try {
                fogStart = ((GlesPipelineSettingsGroupGroupFogStart[]) getChildren(new GlesPipelineSettingsGroupGroupFogStart[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_start"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_start"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogStart;
    }

    public GlesPipelineSettingsGroupGroupSampleAlphaToCoverageEnable[] getSampleAlphaToCoverageEnable()
        throws IOException
    {
        if (sampleAlphaToCoverageEnable == null) {
            try {
                sampleAlphaToCoverageEnable = ((GlesPipelineSettingsGroupGroupSampleAlphaToCoverageEnable[]) getChildren(new GlesPipelineSettingsGroupGroupSampleAlphaToCoverageEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/sample_alpha_to_coverage_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleAlphaToCoverageEnable;
    }

    public GlesPipelineSettingsGroupGroupSampleAlphaToOneEnable[] getSampleAlphaToOneEnable()
        throws IOException
    {
        if (sampleAlphaToOneEnable == null) {
            try {
                sampleAlphaToOneEnable = ((GlesPipelineSettingsGroupGroupSampleAlphaToOneEnable[]) getChildren(new GlesPipelineSettingsGroupGroupSampleAlphaToOneEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_one_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/sample_alpha_to_one_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleAlphaToOneEnable;
    }

    public GlesPipelineSettingsGroupGroupRescaleNormalEnable[] getRescaleNormalEnable()
        throws IOException
    {
        if (rescaleNormalEnable == null) {
            try {
                rescaleNormalEnable = ((GlesPipelineSettingsGroupGroupRescaleNormalEnable[]) getChildren(new GlesPipelineSettingsGroupGroupRescaleNormalEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rescale_normal_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/rescale_normal_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rescaleNormalEnable;
    }

    public GlesPipelineSettingsGroupGroupDitherEnable[] getDitherEnable()
        throws IOException
    {
        if (ditherEnable == null) {
            try {
                ditherEnable = ((GlesPipelineSettingsGroupGroupDitherEnable[]) getChildren(new GlesPipelineSettingsGroupGroupDitherEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/dither_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ditherEnable;
    }

    public GlesPipelineSettingsGroupGroupLightSpotDirection[] getLightSpotDirection()
        throws IOException
    {
        if (lightSpotDirection == null) {
            try {
                lightSpotDirection = ((GlesPipelineSettingsGroupGroupLightSpotDirection[]) getChildren(new GlesPipelineSettingsGroupGroupLightSpotDirection[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_direction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_spot_direction"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightSpotDirection;
    }

    public GlesPipelineSettingsGroupGroupSampleCoverageEnable[] getSampleCoverageEnable()
        throws IOException
    {
        if (sampleCoverageEnable == null) {
            try {
                sampleCoverageEnable = ((GlesPipelineSettingsGroupGroupSampleCoverageEnable[]) getChildren(new GlesPipelineSettingsGroupGroupSampleCoverageEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/sample_coverage_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleCoverageEnable;
    }

    public GlesPipelineSettingsGroupGroupFrontFace[] getFrontFace()
        throws IOException
    {
        if (frontFace == null) {
            try {
                frontFace = ((GlesPipelineSettingsGroupGroupFrontFace[]) getChildren(new GlesPipelineSettingsGroupGroupFrontFace[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/front_face"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return frontFace;
    }

    public GlesPipelineSettingsGroupGroupLightSpecular[] getLightSpecular()
        throws IOException
    {
        if (lightSpecular == null) {
            try {
                lightSpecular = ((GlesPipelineSettingsGroupGroupLightSpecular[]) getChildren(new GlesPipelineSettingsGroupGroupLightSpecular[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_specular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_specular"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightSpecular;
    }

    public GlesPipelineSettingsGroupGroupStencilTestEnable[] getStencilTestEnable()
        throws IOException
    {
        if (stencilTestEnable == null) {
            try {
                stencilTestEnable = ((GlesPipelineSettingsGroupGroupStencilTestEnable[]) getChildren(new GlesPipelineSettingsGroupGroupStencilTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/stencil_test_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilTestEnable;
    }

    public GlesPipelineSettingsGroupGroupLightAmbient[] getLightAmbient()
        throws IOException
    {
        if (lightAmbient == null) {
            try {
                lightAmbient = ((GlesPipelineSettingsGroupGroupLightAmbient[]) getChildren(new GlesPipelineSettingsGroupGroupLightAmbient[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_ambient"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightAmbient;
    }

    public GlesPipelineSettingsGroupGroupColorMask[] getColorMask()
        throws IOException
    {
        if (colorMask == null) {
            try {
                colorMask = ((GlesPipelineSettingsGroupGroupColorMask[]) getChildren(new GlesPipelineSettingsGroupGroupColorMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/color_mask"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorMask;
    }

    public GlesPipelineSettingsGroupGroupLightModelTwoSideEnable[] getLightModelTwoSideEnable()
        throws IOException
    {
        if (lightModelTwoSideEnable == null) {
            try {
                lightModelTwoSideEnable = ((GlesPipelineSettingsGroupGroupLightModelTwoSideEnable[]) getChildren(new GlesPipelineSettingsGroupGroupLightModelTwoSideEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_two_side_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_model_two_side_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightModelTwoSideEnable;
    }

    public GlesPipelineSettingsGroupGroupFogEnd[] getFogEnd()
        throws IOException
    {
        if (fogEnd == null) {
            try {
                fogEnd = ((GlesPipelineSettingsGroupGroupFogEnd[]) getChildren(new GlesPipelineSettingsGroupGroupFogEnd[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_end"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_end"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogEnd;
    }

    public GlesPipelineSettingsGroupGroupStencilMask[] getStencilMask()
        throws IOException
    {
        if (stencilMask == null) {
            try {
                stencilMask = ((GlesPipelineSettingsGroupGroupStencilMask[]) getChildren(new GlesPipelineSettingsGroupGroupStencilMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/stencil_mask"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilMask;
    }

    public GlesPipelineSettingsGroupGroupClipPlane[] getClipPlane()
        throws IOException
    {
        if (clipPlane == null) {
            try {
                clipPlane = ((GlesPipelineSettingsGroupGroupClipPlane[]) getChildren(new GlesPipelineSettingsGroupGroupClipPlane[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/clip_plane"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return clipPlane;
    }

    public GlesPipelineSettingsGroupGroupFogColor[] getFogColor()
        throws IOException
    {
        if (fogColor == null) {
            try {
                fogColor = ((GlesPipelineSettingsGroupGroupFogColor[]) getChildren(new GlesPipelineSettingsGroupGroupFogColor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_color"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogColor;
    }

    public GlesPipelineSettingsGroupGroupLogicOp[] getLogicOp()
        throws IOException
    {
        if (logicOp == null) {
            try {
                logicOp = ((GlesPipelineSettingsGroupGroupLogicOp[]) getChildren(new GlesPipelineSettingsGroupGroupLogicOp[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/logic_op"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return logicOp;
    }

    public GlesPipelineSettingsGroupGroupLightSpotCutoff[] getLightSpotCutoff()
        throws IOException
    {
        if (lightSpotCutoff == null) {
            try {
                lightSpotCutoff = ((GlesPipelineSettingsGroupGroupLightSpotCutoff[]) getChildren(new GlesPipelineSettingsGroupGroupLightSpotCutoff[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_cutoff"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_spot_cutoff"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightSpotCutoff;
    }

    public GlesPipelineSettingsGroupGroupPointFadeThresholdSize[] getPointFadeThresholdSize()
        throws IOException
    {
        if (pointFadeThresholdSize == null) {
            try {
                pointFadeThresholdSize = ((GlesPipelineSettingsGroupGroupPointFadeThresholdSize[]) getChildren(new GlesPipelineSettingsGroupGroupPointFadeThresholdSize[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_fade_threshold_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_fade_threshold_size"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointFadeThresholdSize;
    }

    public GlesPipelineSettingsGroupGroupStencilOp[] getStencilOp()
        throws IOException
    {
        if (stencilOp == null) {
            try {
                stencilOp = ((GlesPipelineSettingsGroupGroupStencilOp[]) getChildren(new GlesPipelineSettingsGroupGroupStencilOp[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/stencil_op"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilOp;
    }

    public GlesPipelineSettingsGroupGroupCullFaceEnable[] getCullFaceEnable()
        throws IOException
    {
        if (cullFaceEnable == null) {
            try {
                cullFaceEnable = ((GlesPipelineSettingsGroupGroupCullFaceEnable[]) getChildren(new GlesPipelineSettingsGroupGroupCullFaceEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/cull_face_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cullFaceEnable;
    }

    public GlesPipelineSettingsGroupGroupStencilFunc[] getStencilFunc()
        throws IOException
    {
        if (stencilFunc == null) {
            try {
                stencilFunc = ((GlesPipelineSettingsGroupGroupStencilFunc[]) getChildren(new GlesPipelineSettingsGroupGroupStencilFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/stencil_func"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilFunc;
    }

    public GlesPipelineSettingsGroupGroupLineSmoothEnable[] getLineSmoothEnable()
        throws IOException
    {
        if (lineSmoothEnable == null) {
            try {
                lineSmoothEnable = ((GlesPipelineSettingsGroupGroupLineSmoothEnable[]) getChildren(new GlesPipelineSettingsGroupGroupLineSmoothEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/line_smooth_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lineSmoothEnable;
    }

    public GlesPipelineSettingsGroupGroupMaterialAmbient[] getMaterialAmbient()
        throws IOException
    {
        if (materialAmbient == null) {
            try {
                materialAmbient = ((GlesPipelineSettingsGroupGroupMaterialAmbient[]) getChildren(new GlesPipelineSettingsGroupGroupMaterialAmbient[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_ambient"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialAmbient;
    }

    public GlesPipelineSettingsGroupGroupBlendEnable[] getBlendEnable()
        throws IOException
    {
        if (blendEnable == null) {
            try {
                blendEnable = ((GlesPipelineSettingsGroupGroupBlendEnable[]) getChildren(new GlesPipelineSettingsGroupGroupBlendEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/blend_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendEnable;
    }

    public GlesPipelineSettingsGroupGroupClipPlaneEnable[] getClipPlaneEnable()
        throws IOException
    {
        if (clipPlaneEnable == null) {
            try {
                clipPlaneEnable = ((GlesPipelineSettingsGroupGroupClipPlaneEnable[]) getChildren(new GlesPipelineSettingsGroupGroupClipPlaneEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/clip_plane_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return clipPlaneEnable;
    }

    public GlesPipelineSettingsGroupGroupLightLinearAttenuation[] getLightLinearAttenuation()
        throws IOException
    {
        if (lightLinearAttenuation == null) {
            try {
                lightLinearAttenuation = ((GlesPipelineSettingsGroupGroupLightLinearAttenuation[]) getChildren(new GlesPipelineSettingsGroupGroupLightLinearAttenuation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_linear_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_linear_attenuation"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightLinearAttenuation;
    }

    public GlesPipelineSettingsGroupGroupLightModelAmbient[] getLightModelAmbient()
        throws IOException
    {
        if (lightModelAmbient == null) {
            try {
                lightModelAmbient = ((GlesPipelineSettingsGroupGroupLightModelAmbient[]) getChildren(new GlesPipelineSettingsGroupGroupLightModelAmbient[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_model_ambient"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightModelAmbient;
    }

    public GlesPipelineSettingsGroupGroupTexturePipeline[] getTexturePipeline()
        throws IOException
    {
        if (texturePipeline == null) {
            try {
                texturePipeline = ((GlesPipelineSettingsGroupGroupTexturePipeline[]) getChildren(new GlesPipelineSettingsGroupGroupTexturePipeline[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_pipeline"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/texture_pipeline"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return texturePipeline;
    }

    public GlesPipelineSettingsGroupGroupFogDensity[] getFogDensity()
        throws IOException
    {
        if (fogDensity == null) {
            try {
                fogDensity = ((GlesPipelineSettingsGroupGroupFogDensity[]) getChildren(new GlesPipelineSettingsGroupGroupFogDensity[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_density"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_density"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogDensity;
    }

    public GlesPipelineSettingsGroupGroupLightQuadraticAttenuation[] getLightQuadraticAttenuation()
        throws IOException
    {
        if (lightQuadraticAttenuation == null) {
            try {
                lightQuadraticAttenuation = ((GlesPipelineSettingsGroupGroupLightQuadraticAttenuation[]) getChildren(new GlesPipelineSettingsGroupGroupLightQuadraticAttenuation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_quadratic_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_quadratic_attenuation"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightQuadraticAttenuation;
    }

    public GlesPipelineSettingsGroupGroupLightEnable[] getLightEnable()
        throws IOException
    {
        if (lightEnable == null) {
            try {
                lightEnable = ((GlesPipelineSettingsGroupGroupLightEnable[]) getChildren(new GlesPipelineSettingsGroupGroupLightEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightEnable;
    }

    public GlesPipelineSettingsGroupGroupProjectionMatrix[] getProjectionMatrix()
        throws IOException
    {
        if (projectionMatrix == null) {
            try {
                projectionMatrix = ((GlesPipelineSettingsGroupGroupProjectionMatrix[]) getChildren(new GlesPipelineSettingsGroupGroupProjectionMatrix[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "projection_matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/projection_matrix"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return projectionMatrix;
    }

    public GlesPipelineSettingsGroupGroupMaterialEmission[] getMaterialEmission()
        throws IOException
    {
        if (materialEmission == null) {
            try {
                materialEmission = ((GlesPipelineSettingsGroupGroupMaterialEmission[]) getChildren(new GlesPipelineSettingsGroupGroupMaterialEmission[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_emission"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_emission"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialEmission;
    }

    public GlesPipelineSettingsGroupGroupPointDistanceAttenuation[] getPointDistanceAttenuation()
        throws IOException
    {
        if (pointDistanceAttenuation == null) {
            try {
                pointDistanceAttenuation = ((GlesPipelineSettingsGroupGroupPointDistanceAttenuation[]) getChildren(new GlesPipelineSettingsGroupGroupPointDistanceAttenuation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_distance_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_distance_attenuation"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointDistanceAttenuation;
    }

    public GlesPipelineSettingsGroupGroupScissorTestEnable[] getScissorTestEnable()
        throws IOException
    {
        if (scissorTestEnable == null) {
            try {
                scissorTestEnable = ((GlesPipelineSettingsGroupGroupScissorTestEnable[]) getChildren(new GlesPipelineSettingsGroupGroupScissorTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/scissor_test_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scissorTestEnable;
    }

    public GlesPipelineSettingsGroupGroupMaterialSpecular[] getMaterialSpecular()
        throws IOException
    {
        if (materialSpecular == null) {
            try {
                materialSpecular = ((GlesPipelineSettingsGroupGroupMaterialSpecular[]) getChildren(new GlesPipelineSettingsGroupGroupMaterialSpecular[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_specular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_specular"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialSpecular;
    }

    public GlesPipelineSettingsGroupGroupLightDiffuse[] getLightDiffuse()
        throws IOException
    {
        if (lightDiffuse == null) {
            try {
                lightDiffuse = ((GlesPipelineSettingsGroupGroupLightDiffuse[]) getChildren(new GlesPipelineSettingsGroupGroupLightDiffuse[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_diffuse"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightDiffuse;
    }

    public GlesPipelineSettingsGroupGroupColorMaterialEnable[] getColorMaterialEnable()
        throws IOException
    {
        if (colorMaterialEnable == null) {
            try {
                colorMaterialEnable = ((GlesPipelineSettingsGroupGroupColorMaterialEnable[]) getChildren(new GlesPipelineSettingsGroupGroupColorMaterialEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/color_material_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorMaterialEnable;
    }

    public GlesPipelineSettingsGroupGroupLightConstantAttenuation[] getLightConstantAttenuation()
        throws IOException
    {
        if (lightConstantAttenuation == null) {
            try {
                lightConstantAttenuation = ((GlesPipelineSettingsGroupGroupLightConstantAttenuation[]) getChildren(new GlesPipelineSettingsGroupGroupLightConstantAttenuation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_constant_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_constant_attenuation"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightConstantAttenuation;
    }

    public GlesPipelineSettingsGroupGroupLightSpotExponent[] getLightSpotExponent()
        throws IOException
    {
        if (lightSpotExponent == null) {
            try {
                lightSpotExponent = ((GlesPipelineSettingsGroupGroupLightSpotExponent[]) getChildren(new GlesPipelineSettingsGroupGroupLightSpotExponent[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_exponent"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_spot_exponent"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightSpotExponent;
    }

    public GlesPipelineSettingsGroupGroupPointSizeMin[] getPointSizeMin()
        throws IOException
    {
        if (pointSizeMin == null) {
            try {
                pointSizeMin = ((GlesPipelineSettingsGroupGroupPointSizeMin[]) getChildren(new GlesPipelineSettingsGroupGroupPointSizeMin[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_min"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_size_min"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSizeMin;
    }

    public GlesPipelineSettingsGroupGroupMaterialDiffuse[] getMaterialDiffuse()
        throws IOException
    {
        if (materialDiffuse == null) {
            try {
                materialDiffuse = ((GlesPipelineSettingsGroupGroupMaterialDiffuse[]) getChildren(new GlesPipelineSettingsGroupGroupMaterialDiffuse[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_diffuse"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialDiffuse;
    }

    public GlesPipelineSettingsGroupGroupLightPosition[] getLightPosition()
        throws IOException
    {
        if (lightPosition == null) {
            try {
                lightPosition = ((GlesPipelineSettingsGroupGroupLightPosition[]) getChildren(new GlesPipelineSettingsGroupGroupLightPosition[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_position"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/light_position"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightPosition;
    }

    public GlesPipelineSettingsGroupGroupColorLogicOpEnable[] getColorLogicOpEnable()
        throws IOException
    {
        if (colorLogicOpEnable == null) {
            try {
                colorLogicOpEnable = ((GlesPipelineSettingsGroupGroupColorLogicOpEnable[]) getChildren(new GlesPipelineSettingsGroupGroupColorLogicOpEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_logic_op_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/color_logic_op_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorLogicOpEnable;
    }

    public GlesPipelineSettingsGroupGroupPointSizeMax[] getPointSizeMax()
        throws IOException
    {
        if (pointSizeMax == null) {
            try {
                pointSizeMax = ((GlesPipelineSettingsGroupGroupPointSizeMax[]) getChildren(new GlesPipelineSettingsGroupGroupPointSizeMax[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_max"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_size_max"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSizeMax;
    }

    public GlesPipelineSettingsGroupGroupAlphaFunc[] getAlphaFunc()
        throws IOException
    {
        if (alphaFunc == null) {
            try {
                alphaFunc = ((GlesPipelineSettingsGroupGroupAlphaFunc[]) getChildren(new GlesPipelineSettingsGroupGroupAlphaFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/alpha_func"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return alphaFunc;
    }

    public GlesPipelineSettingsGroupGroupModelViewMatrix[] getModelViewMatrix()
        throws IOException
    {
        if (modelViewMatrix == null) {
            try {
                modelViewMatrix = ((GlesPipelineSettingsGroupGroupModelViewMatrix[]) getChildren(new GlesPipelineSettingsGroupGroupModelViewMatrix[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "model_view_matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/model_view_matrix"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return modelViewMatrix;
    }

    public GlesPipelineSettingsGroupGroupCullFace[] getCullFace()
        throws IOException
    {
        if (cullFace == null) {
            try {
                cullFace = ((GlesPipelineSettingsGroupGroupCullFace[]) getChildren(new GlesPipelineSettingsGroupGroupCullFace[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/cull_face"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cullFace;
    }

    public GlesPipelineSettingsGroupGroupFogEnable[] getFogEnable()
        throws IOException
    {
        if (fogEnable == null) {
            try {
                fogEnable = ((GlesPipelineSettingsGroupGroupFogEnable[]) getChildren(new GlesPipelineSettingsGroupGroupFogEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogEnable;
    }

    public GlesPipelineSettingsGroupGroupDepthRange[] getDepthRange()
        throws IOException
    {
        if (depthRange == null) {
            try {
                depthRange = ((GlesPipelineSettingsGroupGroupDepthRange[]) getChildren(new GlesPipelineSettingsGroupGroupDepthRange[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/depth_range"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthRange;
    }

    public GlesPipelineSettingsGroupGroupPointSmoothEnable[] getPointSmoothEnable()
        throws IOException
    {
        if (pointSmoothEnable == null) {
            try {
                pointSmoothEnable = ((GlesPipelineSettingsGroupGroupPointSmoothEnable[]) getChildren(new GlesPipelineSettingsGroupGroupPointSmoothEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_smooth_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSmoothEnable;
    }

    public GlesPipelineSettingsGroupGroupDepthTestEnable[] getDepthTestEnable()
        throws IOException
    {
        if (depthTestEnable == null) {
            try {
                depthTestEnable = ((GlesPipelineSettingsGroupGroupDepthTestEnable[]) getChildren(new GlesPipelineSettingsGroupGroupDepthTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/depth_test_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthTestEnable;
    }

    public GlesPipelineSettingsGroupGroupLightingEnable[] getLightingEnable()
        throws IOException
    {
        if (lightingEnable == null) {
            try {
                lightingEnable = ((GlesPipelineSettingsGroupGroupLightingEnable[]) getChildren(new GlesPipelineSettingsGroupGroupLightingEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lighting_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/lighting_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightingEnable;
    }

    public GlesPipelineSettingsGroupGroupDepthFunc[] getDepthFunc()
        throws IOException
    {
        if (depthFunc == null) {
            try {
                depthFunc = ((GlesPipelineSettingsGroupGroupDepthFunc[]) getChildren(new GlesPipelineSettingsGroupGroupDepthFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/depth_func"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthFunc;
    }

    public GlesPipelineSettingsGroupGroupPointSize[] getPointSize()
        throws IOException
    {
        if (pointSize == null) {
            try {
                pointSize = ((GlesPipelineSettingsGroupGroupPointSize[]) getChildren(new GlesPipelineSettingsGroupGroupPointSize[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/point_size"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSize;
    }

    public GlesPipelineSettingsGroupGroupMultisampleEnable[] getMultisampleEnable()
        throws IOException
    {
        if (multisampleEnable == null) {
            try {
                multisampleEnable = ((GlesPipelineSettingsGroupGroupMultisampleEnable[]) getChildren(new GlesPipelineSettingsGroupGroupMultisampleEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "multisample_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/multisample_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return multisampleEnable;
    }

    public GlesPipelineSettingsGroupGroupPolygonOffsetFillEnable[] getPolygonOffsetFillEnable()
        throws IOException
    {
        if (polygonOffsetFillEnable == null) {
            try {
                polygonOffsetFillEnable = ((GlesPipelineSettingsGroupGroupPolygonOffsetFillEnable[]) getChildren(new GlesPipelineSettingsGroupGroupPolygonOffsetFillEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/polygon_offset_fill_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonOffsetFillEnable;
    }

    public GlesPipelineSettingsGroupGroupMaterialShininess[] getMaterialShininess()
        throws IOException
    {
        if (materialShininess == null) {
            try {
                materialShininess = ((GlesPipelineSettingsGroupGroupMaterialShininess[]) getChildren(new GlesPipelineSettingsGroupGroupMaterialShininess[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_shininess"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/material_shininess"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialShininess;
    }

    public GlesPipelineSettingsGroupGroupFogMode[] getFogMode()
        throws IOException
    {
        if (fogMode == null) {
            try {
                fogMode = ((GlesPipelineSettingsGroupGroupFogMode[]) getChildren(new GlesPipelineSettingsGroupGroupFogMode[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/fog_mode"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogMode;
    }

    public GlesPipelineSettingsGroupGroupBlendFunc[] getBlendFunc()
        throws IOException
    {
        if (blendFunc == null) {
            try {
                blendFunc = ((GlesPipelineSettingsGroupGroupBlendFunc[]) getChildren(new GlesPipelineSettingsGroupGroupBlendFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/blend_func"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendFunc;
    }

    public GlesPipelineSettingsGroupGroupScissor[] getScissor()
        throws IOException
    {
        if (scissor == null) {
            try {
                scissor = ((GlesPipelineSettingsGroupGroupScissor[]) getChildren(new GlesPipelineSettingsGroupGroupScissor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/scissor"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scissor;
    }

    public GlesPipelineSettingsGroupGroupNormalizeEnable[] getNormalizeEnable()
        throws IOException
    {
        if (normalizeEnable == null) {
            try {
                normalizeEnable = ((GlesPipelineSettingsGroupGroupNormalizeEnable[]) getChildren(new GlesPipelineSettingsGroupGroupNormalizeEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "normalize_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/normalize_enable"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return normalizeEnable;
    }

    public GlesPipelineSettingsGroupGroupLineWidth[] getLineWidth()
        throws IOException
    {
        if (lineWidth == null) {
            try {
                lineWidth = ((GlesPipelineSettingsGroupGroupLineWidth[]) getChildren(new GlesPipelineSettingsGroupGroupLineWidth[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/line_width"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lineWidth;
    }

    public GlesPipelineSettingsGroupGroupPolygonOffset[] getPolygonOffset()
        throws IOException
    {
        if (polygonOffset == null) {
            try {
                polygonOffset = ((GlesPipelineSettingsGroupGroupPolygonOffset[]) getChildren(new GlesPipelineSettingsGroupGroupPolygonOffset[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/polygon_offset"), ProfileGlesTypeGroupTechniqueGroupPassGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonOffset;
    }

}
