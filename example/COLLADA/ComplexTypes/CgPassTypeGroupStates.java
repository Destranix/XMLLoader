
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class CgPassTypeGroupStates
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((alpha_func[ ]+){1}|(blend_func[ ]+){1}|(blend_func_separate[ ]+){1}|(blend_equation[ ]+){1}|(blend_equation_separate[ ]+){1}|(color_material[ ]+){1}|(cull_face[ ]+){1}|(depth_func[ ]+){1}|(fog_mode[ ]+){1}|(fog_coord_src[ ]+){1}|(front_face[ ]+){1}|(light_model_color_control[ ]+){1}|(logic_op[ ]+){1}|(polygon_mode[ ]+){1}|(shade_model[ ]+){1}|(stencil_func[ ]+){1}|(stencil_op[ ]+){1}|(stencil_func_separate[ ]+){1}|(stencil_op_separate[ ]+){1}|(stencil_mask_separate[ ]+){1}|(light_enable[ ]+){1}|(light_ambient[ ]+){1}|(light_diffuse[ ]+){1}|(light_specular[ ]+){1}|(light_position[ ]+){1}|(light_constant_attenuation[ ]+){1}|(light_linear_attenuation[ ]+){1}|(light_quadratic_attenuation[ ]+){1}|(light_spot_cutoff[ ]+){1}|(light_spot_direction[ ]+){1}|(light_spot_exponent[ ]+){1}|(texture1D[ ]+){1}|(texture2D[ ]+){1}|(texture3D[ ]+){1}|(textureCUBE[ ]+){1}|(textureRECT[ ]+){1}|(textureDEPTH[ ]+){1}|(texture1D_enable[ ]+){1}|(texture2D_enable[ ]+){1}|(texture3D_enable[ ]+){1}|(textureCUBE_enable[ ]+){1}|(textureRECT_enable[ ]+){1}|(textureDEPTH_enable[ ]+){1}|(texture_env_color[ ]+){1}|(texture_env_mode[ ]+){1}|(clip_plane[ ]+){1}|(clip_plane_enable[ ]+){1}|(blend_color[ ]+){1}|(color_mask[ ]+){1}|(depth_bounds[ ]+){1}|(depth_mask[ ]+){1}|(depth_range[ ]+){1}|(fog_density[ ]+){1}|(fog_start[ ]+){1}|(fog_end[ ]+){1}|(fog_color[ ]+){1}|(light_model_ambient[ ]+){1}|(lighting_enable[ ]+){1}|(line_stipple[ ]+){1}|(line_width[ ]+){1}|(material_ambient[ ]+){1}|(material_diffuse[ ]+){1}|(material_emission[ ]+){1}|(material_shininess[ ]+){1}|(material_specular[ ]+){1}|(model_view_matrix[ ]+){1}|(point_distance_attenuation[ ]+){1}|(point_fade_threshold_size[ ]+){1}|(point_size[ ]+){1}|(point_size_min[ ]+){1}|(point_size_max[ ]+){1}|(polygon_offset[ ]+){1}|(projection_matrix[ ]+){1}|(scissor[ ]+){1}|(stencil_mask[ ]+){1}|(alpha_test_enable[ ]+){1}|(blend_enable[ ]+){1}|(color_logic_op_enable[ ]+){1}|(color_material_enable[ ]+){1}|(cull_face_enable[ ]+){1}|(depth_bounds_enable[ ]+){1}|(depth_clamp_enable[ ]+){1}|(depth_test_enable[ ]+){1}|(dither_enable[ ]+){1}|(fog_enable[ ]+){1}|(light_model_local_viewer_enable[ ]+){1}|(light_model_two_side_enable[ ]+){1}|(line_smooth_enable[ ]+){1}|(line_stipple_enable[ ]+){1}|(logic_op_enable[ ]+){1}|(multisample_enable[ ]+){1}|(normalize_enable[ ]+){1}|(point_smooth_enable[ ]+){1}|(polygon_offset_fill_enable[ ]+){1}|(polygon_offset_line_enable[ ]+){1}|(polygon_offset_point_enable[ ]+){1}|(polygon_smooth_enable[ ]+){1}|(polygon_stipple_enable[ ]+){1}|(rescale_normal_enable[ ]+){1}|(sample_alpha_to_coverage_enable[ ]+){1}|(sample_alpha_to_one_enable[ ]+){1}|(sample_coverage_enable[ ]+){1}|(scissor_test_enable[ ]+){1}|(stencil_test_enable[ ]+){1}){0,1}){0,}){1}";
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
    protected GlPipelineSettingsGroupGroupAlphaTestEnable[] alphaTestEnable;
    protected GlPipelineSettingsGroupGroupDepthMask[] depthMask;
    protected GlPipelineSettingsGroupGroupFogStart[] fogStart;
    protected GlPipelineSettingsGroupGroupTextureEnvColor[] textureEnvColor;
    protected GlPipelineSettingsGroupGroupRescaleNormalEnable[] rescaleNormalEnable;
    protected GlPipelineSettingsGroupGroupTextureDEPTHEnable[] textureDEPTHEnable;
    protected GlPipelineSettingsGroupGroupDepthBounds[] depthBounds;
    protected GlPipelineSettingsGroupGroupTexture3D[] texture3D;
    protected GlPipelineSettingsGroupGroupSampleCoverageEnable[] sampleCoverageEnable;
    protected GlPipelineSettingsGroupGroupColorMask[] colorMask;
    protected GlPipelineSettingsGroupGroupTextureCUBEEnable[] textureCUBEEnable;
    protected GlPipelineSettingsGroupGroupStencilMask[] stencilMask;
    protected GlPipelineSettingsGroupGroupPolygonOffsetLineEnable[] polygonOffsetLineEnable;
    protected GlPipelineSettingsGroupGroupFogColor[] fogColor;
    protected GlPipelineSettingsGroupGroupLightSpotCutoff[] lightSpotCutoff;
    protected GlPipelineSettingsGroupGroupStencilOp[] stencilOp;
    protected GlPipelineSettingsGroupGroupCullFaceEnable[] cullFaceEnable;
    protected GlPipelineSettingsGroupGroupStencilFunc[] stencilFunc;
    protected GlPipelineSettingsGroupGroupLineSmoothEnable[] lineSmoothEnable;
    protected GlPipelineSettingsGroupGroupTexture2D[] texture2D;
    protected GlPipelineSettingsGroupGroupBlendEnable[] blendEnable;
    protected GlPipelineSettingsGroupGroupLightLinearAttenuation[] lightLinearAttenuation;
    protected GlPipelineSettingsGroupGroupTextureCUBE[] textureCUBE;
    protected GlPipelineSettingsGroupGroupStencilFuncSeparate[] stencilFuncSeparate;
    protected GlPipelineSettingsGroupGroupLightModelAmbient[] lightModelAmbient;
    protected GlPipelineSettingsGroupGroupDepthBoundsEnable[] depthBoundsEnable;
    protected GlPipelineSettingsGroupGroupLightEnable[] lightEnable;
    protected GlPipelineSettingsGroupGroupBlendEquationSeparate[] blendEquationSeparate;
    protected GlPipelineSettingsGroupGroupFogCoordSrc[] fogCoordSrc;
    protected GlPipelineSettingsGroupGroupMaterialEmission[] materialEmission;
    protected GlPipelineSettingsGroupGroupPointDistanceAttenuation[] pointDistanceAttenuation;
    protected GlPipelineSettingsGroupGroupScissorTestEnable[] scissorTestEnable;
    protected GlPipelineSettingsGroupGroupLightDiffuse[] lightDiffuse;
    protected GlPipelineSettingsGroupGroupBlendEquation[] blendEquation;
    protected GlPipelineSettingsGroupGroupTexture1D[] texture1D;
    protected GlPipelineSettingsGroupGroupColorMaterialEnable[] colorMaterialEnable;
    protected GlPipelineSettingsGroupGroupLightModelLocalViewerEnable[] lightModelLocalViewerEnable;
    protected GlPipelineSettingsGroupGroupLightSpotExponent[] lightSpotExponent;
    protected GlPipelineSettingsGroupGroupMaterialDiffuse[] materialDiffuse;
    protected GlPipelineSettingsGroupGroupColorLogicOpEnable[] colorLogicOpEnable;
    protected GlPipelineSettingsGroupGroupPolygonOffsetPointEnable[] polygonOffsetPointEnable;
    protected GlPipelineSettingsGroupGroupTextureRECTEnable[] textureRECTEnable;
    protected GlPipelineSettingsGroupGroupAlphaFunc[] alphaFunc;
    protected GlPipelineSettingsGroupGroupModelViewMatrix[] modelViewMatrix;
    protected GlPipelineSettingsGroupGroupFogEnable[] fogEnable;
    protected GlPipelineSettingsGroupGroupTextureRECT[] textureRECT;
    protected GlPipelineSettingsGroupGroupPointSmoothEnable[] pointSmoothEnable;
    protected GlPipelineSettingsGroupGroupTexture3DEnable[] texture3DEnable;
    protected GlPipelineSettingsGroupGroupPointSize[] pointSize;
    protected GlPipelineSettingsGroupGroupPolygonOffsetFillEnable[] polygonOffsetFillEnable;
    protected GlPipelineSettingsGroupGroupStencilMaskSeparate[] stencilMaskSeparate;
    protected GlPipelineSettingsGroupGroupBlendFunc[] blendFunc;
    protected GlPipelineSettingsGroupGroupNormalizeEnable[] normalizeEnable;
    protected GlPipelineSettingsGroupGroupPolygonOffset[] polygonOffset;
    protected GlPipelineSettingsGroupGroupBlendColor[] blendColor;
    protected GlPipelineSettingsGroupGroupShadeModel[] shadeModel;
    protected GlPipelineSettingsGroupGroupSampleAlphaToCoverageEnable[] sampleAlphaToCoverageEnable;
    protected GlPipelineSettingsGroupGroupSampleAlphaToOneEnable[] sampleAlphaToOneEnable;
    protected GlPipelineSettingsGroupGroupDitherEnable[] ditherEnable;
    protected GlPipelineSettingsGroupGroupLightSpotDirection[] lightSpotDirection;
    protected GlPipelineSettingsGroupGroupFrontFace[] frontFace;
    protected GlPipelineSettingsGroupGroupLightSpecular[] lightSpecular;
    protected GlPipelineSettingsGroupGroupStencilTestEnable[] stencilTestEnable;
    protected GlPipelineSettingsGroupGroupLightAmbient[] lightAmbient;
    protected GlPipelineSettingsGroupGroupColorMaterial[] colorMaterial;
    protected GlPipelineSettingsGroupGroupLightModelTwoSideEnable[] lightModelTwoSideEnable;
    protected GlPipelineSettingsGroupGroupFogEnd[] fogEnd;
    protected GlPipelineSettingsGroupGroupClipPlane[] clipPlane;
    protected GlPipelineSettingsGroupGroupLogicOp[] logicOp;
    protected GlPipelineSettingsGroupGroupPointFadeThresholdSize[] pointFadeThresholdSize;
    protected GlPipelineSettingsGroupGroupLineStippleEnable[] lineStippleEnable;
    protected GlPipelineSettingsGroupGroupTexture2DEnable[] texture2DEnable;
    protected GlPipelineSettingsGroupGroupLineStipple[] lineStipple;
    protected GlPipelineSettingsGroupGroupMaterialAmbient[] materialAmbient;
    protected GlPipelineSettingsGroupGroupPolygonSmoothEnable[] polygonSmoothEnable;
    protected GlPipelineSettingsGroupGroupClipPlaneEnable[] clipPlaneEnable;
    protected GlPipelineSettingsGroupGroupStencilOpSeparate[] stencilOpSeparate;
    protected GlPipelineSettingsGroupGroupLightQuadraticAttenuation[] lightQuadraticAttenuation;
    protected GlPipelineSettingsGroupGroupFogDensity[] fogDensity;
    protected GlPipelineSettingsGroupGroupProjectionMatrix[] projectionMatrix;
    protected GlPipelineSettingsGroupGroupBlendFuncSeparate[] blendFuncSeparate;
    protected GlPipelineSettingsGroupGroupMaterialSpecular[] materialSpecular;
    protected GlPipelineSettingsGroupGroupLightModelColorControl[] lightModelColorControl;
    protected GlPipelineSettingsGroupGroupPolygonMode[] polygonMode;
    protected GlPipelineSettingsGroupGroupLightConstantAttenuation[] lightConstantAttenuation;
    protected GlPipelineSettingsGroupGroupPointSizeMin[] pointSizeMin;
    protected GlPipelineSettingsGroupGroupPolygonStippleEnable[] polygonStippleEnable;
    protected GlPipelineSettingsGroupGroupLightPosition[] lightPosition;
    protected GlPipelineSettingsGroupGroupPointSizeMax[] pointSizeMax;
    protected GlPipelineSettingsGroupGroupCullFace[] cullFace;
    protected GlPipelineSettingsGroupGroupDepthRange[] depthRange;
    protected GlPipelineSettingsGroupGroupDepthTestEnable[] depthTestEnable;
    protected GlPipelineSettingsGroupGroupTextureEnvMode[] textureEnvMode;
    protected GlPipelineSettingsGroupGroupDepthClampEnable[] depthClampEnable;
    protected GlPipelineSettingsGroupGroupLightingEnable[] lightingEnable;
    protected GlPipelineSettingsGroupGroupDepthFunc[] depthFunc;
    protected GlPipelineSettingsGroupGroupLogicOpEnable[] logicOpEnable;
    protected GlPipelineSettingsGroupGroupMultisampleEnable[] multisampleEnable;
    protected GlPipelineSettingsGroupGroupMaterialShininess[] materialShininess;
    protected GlPipelineSettingsGroupGroupTexture1DEnable[] texture1DEnable;
    protected GlPipelineSettingsGroupGroupFogMode[] fogMode;
    protected GlPipelineSettingsGroupGroupScissor[] scissor;
    protected GlPipelineSettingsGroupGroupLineWidth[] lineWidth;
    protected GlPipelineSettingsGroupGroupTextureDEPTH[] textureDEPTH;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/alpha_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_start"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_start"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_start"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_start"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_env_color"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_env_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture_env_color"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_env_color"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rescale_normal_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rescale_normal_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/rescale_normal_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rescale_normal_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureDEPTH_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureDEPTH_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureDEPTH_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureDEPTH_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_bounds"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_bounds"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_bounds"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_bounds"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture3D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture3D"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture3D"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/sample_coverage_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/color_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureCUBE_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureCUBE_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureCUBE_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureCUBE_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_line_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_line_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_offset_line_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_line_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_color"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_color"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_color"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_cutoff"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_cutoff"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_spot_cutoff"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_cutoff"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/cull_face_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_smooth_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/line_smooth_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_smooth_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture2D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture2D"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture2D"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_linear_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_linear_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_linear_attenuation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_linear_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureCUBE"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureCUBE"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureCUBE"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_ambient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_model_ambient"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_ambient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_bounds_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_bounds_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_bounds_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_bounds_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_equation_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_coord_src"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_coord_src"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_coord_src"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_coord_src"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_emission"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_emission"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_emission"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_emission"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_distance_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_distance_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_distance_attenuation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_distance_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/scissor_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_diffuse"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_diffuse"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_diffuse"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_equation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture1D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture1D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture1D"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture1D"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/color_material_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_local_viewer_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_local_viewer_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_model_local_viewer_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_local_viewer_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_exponent"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_exponent"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_spot_exponent"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_exponent"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_diffuse"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_diffuse"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_diffuse"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_logic_op_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_logic_op_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/color_logic_op_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_logic_op_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_point_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_point_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_offset_point_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_point_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureRECT_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureRECT_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureRECT_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureRECT_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/alpha_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "model_view_matrix"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "model_view_matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/model_view_matrix"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "model_view_matrix"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureRECT"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureRECT"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureRECT"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureRECT"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_smooth_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_smooth_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_smooth_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture3D_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture3D_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture3D_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture3D_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_size"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_offset_fill_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_mask_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "normalize_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "normalize_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/normalize_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "normalize_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_offset"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_color"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_color"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_color"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shade_model"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shade_model"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/shade_model"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shade_model"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/sample_alpha_to_coverage_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_one_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_one_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/sample_alpha_to_one_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_one_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/dither_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_direction"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_direction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_spot_direction"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_direction"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/front_face"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_specular"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_specular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_specular"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_specular"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_ambient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_ambient"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_ambient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/color_material"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_two_side_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_two_side_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_model_two_side_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_two_side_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_end"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_end"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_end"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_end"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/clip_plane"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/logic_op"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_fade_threshold_size"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_fade_threshold_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_fade_threshold_size"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_fade_threshold_size"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_stipple_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_stipple_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/line_stipple_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_stipple_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture2D_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture2D_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture2D_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture2D_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_stipple"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_stipple"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/line_stipple"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_stipple"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_ambient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_ambient"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_ambient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_smooth_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_smooth_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_smooth_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/clip_plane_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_quadratic_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_quadratic_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_quadratic_attenuation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_quadratic_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_density"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_density"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_density"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_density"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "projection_matrix"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "projection_matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/projection_matrix"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "projection_matrix"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func_separate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_func_separate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func_separate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_specular"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_specular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_specular"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_specular"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_color_control"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_color_control"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_model_color_control"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_color_control"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_mode"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_mode"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_mode"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_constant_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_constant_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_constant_attenuation"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_constant_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_min"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_min"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_size_min"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_min"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_stipple_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_stipple_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_stipple_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_stipple_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_position"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_position"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_position"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_position"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_max"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_max"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_size_max"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_max"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/cull_face"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_range"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_test_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_env_mode"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_env_mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture_env_mode"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_env_mode"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_clamp_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_clamp_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_clamp_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_clamp_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lighting_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lighting_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/lighting_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lighting_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/logic_op_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "multisample_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "multisample_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/multisample_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "multisample_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_shininess"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_shininess"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_shininess"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_shininess"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture1D_enable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture1D_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture1D_enable"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture1D_enable"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_mode"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_mode"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_mode"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/scissor"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/line_width"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureDEPTH"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureDEPTH"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureDEPTH"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public CgPassTypeGroupStates(XmlComplexType elem) {
        super(elem, CgPassTypeGroupStates.class);
    }

    public GlPipelineSettingsGroupGroupAlphaTestEnable[] getAlphaTestEnable()
        throws IOException
    {
        if (alphaTestEnable == null) {
            try {
                alphaTestEnable = ((GlPipelineSettingsGroupGroupAlphaTestEnable[]) getChildren(new GlPipelineSettingsGroupGroupAlphaTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/alpha_test_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return alphaTestEnable;
    }

    public GlPipelineSettingsGroupGroupDepthMask[] getDepthMask()
        throws IOException
    {
        if (depthMask == null) {
            try {
                depthMask = ((GlPipelineSettingsGroupGroupDepthMask[]) getChildren(new GlPipelineSettingsGroupGroupDepthMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_mask"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthMask;
    }

    public GlPipelineSettingsGroupGroupFogStart[] getFogStart()
        throws IOException
    {
        if (fogStart == null) {
            try {
                fogStart = ((GlPipelineSettingsGroupGroupFogStart[]) getChildren(new GlPipelineSettingsGroupGroupFogStart[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_start"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_start"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogStart;
    }

    public GlPipelineSettingsGroupGroupTextureEnvColor[] getTextureEnvColor()
        throws IOException
    {
        if (textureEnvColor == null) {
            try {
                textureEnvColor = ((GlPipelineSettingsGroupGroupTextureEnvColor[]) getChildren(new GlPipelineSettingsGroupGroupTextureEnvColor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_env_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture_env_color"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return textureEnvColor;
    }

    public GlPipelineSettingsGroupGroupRescaleNormalEnable[] getRescaleNormalEnable()
        throws IOException
    {
        if (rescaleNormalEnable == null) {
            try {
                rescaleNormalEnable = ((GlPipelineSettingsGroupGroupRescaleNormalEnable[]) getChildren(new GlPipelineSettingsGroupGroupRescaleNormalEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rescale_normal_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/rescale_normal_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rescaleNormalEnable;
    }

    public GlPipelineSettingsGroupGroupTextureDEPTHEnable[] getTextureDEPTHEnable()
        throws IOException
    {
        if (textureDEPTHEnable == null) {
            try {
                textureDEPTHEnable = ((GlPipelineSettingsGroupGroupTextureDEPTHEnable[]) getChildren(new GlPipelineSettingsGroupGroupTextureDEPTHEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureDEPTH_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureDEPTH_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return textureDEPTHEnable;
    }

    public GlPipelineSettingsGroupGroupDepthBounds[] getDepthBounds()
        throws IOException
    {
        if (depthBounds == null) {
            try {
                depthBounds = ((GlPipelineSettingsGroupGroupDepthBounds[]) getChildren(new GlPipelineSettingsGroupGroupDepthBounds[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_bounds"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_bounds"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthBounds;
    }

    public GlPipelineSettingsGroupGroupTexture3D[] getTexture3D()
        throws IOException
    {
        if (texture3D == null) {
            try {
                texture3D = ((GlPipelineSettingsGroupGroupTexture3D[]) getChildren(new GlPipelineSettingsGroupGroupTexture3D[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture3D"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return texture3D;
    }

    public GlPipelineSettingsGroupGroupSampleCoverageEnable[] getSampleCoverageEnable()
        throws IOException
    {
        if (sampleCoverageEnable == null) {
            try {
                sampleCoverageEnable = ((GlPipelineSettingsGroupGroupSampleCoverageEnable[]) getChildren(new GlPipelineSettingsGroupGroupSampleCoverageEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/sample_coverage_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleCoverageEnable;
    }

    public GlPipelineSettingsGroupGroupColorMask[] getColorMask()
        throws IOException
    {
        if (colorMask == null) {
            try {
                colorMask = ((GlPipelineSettingsGroupGroupColorMask[]) getChildren(new GlPipelineSettingsGroupGroupColorMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/color_mask"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorMask;
    }

    public GlPipelineSettingsGroupGroupTextureCUBEEnable[] getTextureCUBEEnable()
        throws IOException
    {
        if (textureCUBEEnable == null) {
            try {
                textureCUBEEnable = ((GlPipelineSettingsGroupGroupTextureCUBEEnable[]) getChildren(new GlPipelineSettingsGroupGroupTextureCUBEEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureCUBE_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureCUBE_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return textureCUBEEnable;
    }

    public GlPipelineSettingsGroupGroupStencilMask[] getStencilMask()
        throws IOException
    {
        if (stencilMask == null) {
            try {
                stencilMask = ((GlPipelineSettingsGroupGroupStencilMask[]) getChildren(new GlPipelineSettingsGroupGroupStencilMask[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_mask"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilMask;
    }

    public GlPipelineSettingsGroupGroupPolygonOffsetLineEnable[] getPolygonOffsetLineEnable()
        throws IOException
    {
        if (polygonOffsetLineEnable == null) {
            try {
                polygonOffsetLineEnable = ((GlPipelineSettingsGroupGroupPolygonOffsetLineEnable[]) getChildren(new GlPipelineSettingsGroupGroupPolygonOffsetLineEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_line_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_offset_line_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonOffsetLineEnable;
    }

    public GlPipelineSettingsGroupGroupFogColor[] getFogColor()
        throws IOException
    {
        if (fogColor == null) {
            try {
                fogColor = ((GlPipelineSettingsGroupGroupFogColor[]) getChildren(new GlPipelineSettingsGroupGroupFogColor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_color"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogColor;
    }

    public GlPipelineSettingsGroupGroupLightSpotCutoff[] getLightSpotCutoff()
        throws IOException
    {
        if (lightSpotCutoff == null) {
            try {
                lightSpotCutoff = ((GlPipelineSettingsGroupGroupLightSpotCutoff[]) getChildren(new GlPipelineSettingsGroupGroupLightSpotCutoff[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_cutoff"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_spot_cutoff"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightSpotCutoff;
    }

    public GlPipelineSettingsGroupGroupStencilOp[] getStencilOp()
        throws IOException
    {
        if (stencilOp == null) {
            try {
                stencilOp = ((GlPipelineSettingsGroupGroupStencilOp[]) getChildren(new GlPipelineSettingsGroupGroupStencilOp[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilOp;
    }

    public GlPipelineSettingsGroupGroupCullFaceEnable[] getCullFaceEnable()
        throws IOException
    {
        if (cullFaceEnable == null) {
            try {
                cullFaceEnable = ((GlPipelineSettingsGroupGroupCullFaceEnable[]) getChildren(new GlPipelineSettingsGroupGroupCullFaceEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/cull_face_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cullFaceEnable;
    }

    public GlPipelineSettingsGroupGroupStencilFunc[] getStencilFunc()
        throws IOException
    {
        if (stencilFunc == null) {
            try {
                stencilFunc = ((GlPipelineSettingsGroupGroupStencilFunc[]) getChildren(new GlPipelineSettingsGroupGroupStencilFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilFunc;
    }

    public GlPipelineSettingsGroupGroupLineSmoothEnable[] getLineSmoothEnable()
        throws IOException
    {
        if (lineSmoothEnable == null) {
            try {
                lineSmoothEnable = ((GlPipelineSettingsGroupGroupLineSmoothEnable[]) getChildren(new GlPipelineSettingsGroupGroupLineSmoothEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/line_smooth_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lineSmoothEnable;
    }

    public GlPipelineSettingsGroupGroupTexture2D[] getTexture2D()
        throws IOException
    {
        if (texture2D == null) {
            try {
                texture2D = ((GlPipelineSettingsGroupGroupTexture2D[]) getChildren(new GlPipelineSettingsGroupGroupTexture2D[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture2D"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return texture2D;
    }

    public GlPipelineSettingsGroupGroupBlendEnable[] getBlendEnable()
        throws IOException
    {
        if (blendEnable == null) {
            try {
                blendEnable = ((GlPipelineSettingsGroupGroupBlendEnable[]) getChildren(new GlPipelineSettingsGroupGroupBlendEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendEnable;
    }

    public GlPipelineSettingsGroupGroupLightLinearAttenuation[] getLightLinearAttenuation()
        throws IOException
    {
        if (lightLinearAttenuation == null) {
            try {
                lightLinearAttenuation = ((GlPipelineSettingsGroupGroupLightLinearAttenuation[]) getChildren(new GlPipelineSettingsGroupGroupLightLinearAttenuation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_linear_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_linear_attenuation"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightLinearAttenuation;
    }

    public GlPipelineSettingsGroupGroupTextureCUBE[] getTextureCUBE()
        throws IOException
    {
        if (textureCUBE == null) {
            try {
                textureCUBE = ((GlPipelineSettingsGroupGroupTextureCUBE[]) getChildren(new GlPipelineSettingsGroupGroupTextureCUBE[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureCUBE"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return textureCUBE;
    }

    public GlPipelineSettingsGroupGroupStencilFuncSeparate[] getStencilFuncSeparate()
        throws IOException
    {
        if (stencilFuncSeparate == null) {
            try {
                stencilFuncSeparate = ((GlPipelineSettingsGroupGroupStencilFuncSeparate[]) getChildren(new GlPipelineSettingsGroupGroupStencilFuncSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_func_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func_separate"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilFuncSeparate;
    }

    public GlPipelineSettingsGroupGroupLightModelAmbient[] getLightModelAmbient()
        throws IOException
    {
        if (lightModelAmbient == null) {
            try {
                lightModelAmbient = ((GlPipelineSettingsGroupGroupLightModelAmbient[]) getChildren(new GlPipelineSettingsGroupGroupLightModelAmbient[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_model_ambient"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightModelAmbient;
    }

    public GlPipelineSettingsGroupGroupDepthBoundsEnable[] getDepthBoundsEnable()
        throws IOException
    {
        if (depthBoundsEnable == null) {
            try {
                depthBoundsEnable = ((GlPipelineSettingsGroupGroupDepthBoundsEnable[]) getChildren(new GlPipelineSettingsGroupGroupDepthBoundsEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_bounds_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_bounds_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthBoundsEnable;
    }

    public GlPipelineSettingsGroupGroupLightEnable[] getLightEnable()
        throws IOException
    {
        if (lightEnable == null) {
            try {
                lightEnable = ((GlPipelineSettingsGroupGroupLightEnable[]) getChildren(new GlPipelineSettingsGroupGroupLightEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightEnable;
    }

    public GlPipelineSettingsGroupGroupBlendEquationSeparate[] getBlendEquationSeparate()
        throws IOException
    {
        if (blendEquationSeparate == null) {
            try {
                blendEquationSeparate = ((GlPipelineSettingsGroupGroupBlendEquationSeparate[]) getChildren(new GlPipelineSettingsGroupGroupBlendEquationSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_equation_separate"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendEquationSeparate;
    }

    public GlPipelineSettingsGroupGroupFogCoordSrc[] getFogCoordSrc()
        throws IOException
    {
        if (fogCoordSrc == null) {
            try {
                fogCoordSrc = ((GlPipelineSettingsGroupGroupFogCoordSrc[]) getChildren(new GlPipelineSettingsGroupGroupFogCoordSrc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_coord_src"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_coord_src"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogCoordSrc;
    }

    public GlPipelineSettingsGroupGroupMaterialEmission[] getMaterialEmission()
        throws IOException
    {
        if (materialEmission == null) {
            try {
                materialEmission = ((GlPipelineSettingsGroupGroupMaterialEmission[]) getChildren(new GlPipelineSettingsGroupGroupMaterialEmission[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_emission"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_emission"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialEmission;
    }

    public GlPipelineSettingsGroupGroupPointDistanceAttenuation[] getPointDistanceAttenuation()
        throws IOException
    {
        if (pointDistanceAttenuation == null) {
            try {
                pointDistanceAttenuation = ((GlPipelineSettingsGroupGroupPointDistanceAttenuation[]) getChildren(new GlPipelineSettingsGroupGroupPointDistanceAttenuation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_distance_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_distance_attenuation"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointDistanceAttenuation;
    }

    public GlPipelineSettingsGroupGroupScissorTestEnable[] getScissorTestEnable()
        throws IOException
    {
        if (scissorTestEnable == null) {
            try {
                scissorTestEnable = ((GlPipelineSettingsGroupGroupScissorTestEnable[]) getChildren(new GlPipelineSettingsGroupGroupScissorTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/scissor_test_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scissorTestEnable;
    }

    public GlPipelineSettingsGroupGroupLightDiffuse[] getLightDiffuse()
        throws IOException
    {
        if (lightDiffuse == null) {
            try {
                lightDiffuse = ((GlPipelineSettingsGroupGroupLightDiffuse[]) getChildren(new GlPipelineSettingsGroupGroupLightDiffuse[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_diffuse"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightDiffuse;
    }

    public GlPipelineSettingsGroupGroupBlendEquation[] getBlendEquation()
        throws IOException
    {
        if (blendEquation == null) {
            try {
                blendEquation = ((GlPipelineSettingsGroupGroupBlendEquation[]) getChildren(new GlPipelineSettingsGroupGroupBlendEquation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_equation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_equation"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendEquation;
    }

    public GlPipelineSettingsGroupGroupTexture1D[] getTexture1D()
        throws IOException
    {
        if (texture1D == null) {
            try {
                texture1D = ((GlPipelineSettingsGroupGroupTexture1D[]) getChildren(new GlPipelineSettingsGroupGroupTexture1D[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture1D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture1D"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return texture1D;
    }

    public GlPipelineSettingsGroupGroupColorMaterialEnable[] getColorMaterialEnable()
        throws IOException
    {
        if (colorMaterialEnable == null) {
            try {
                colorMaterialEnable = ((GlPipelineSettingsGroupGroupColorMaterialEnable[]) getChildren(new GlPipelineSettingsGroupGroupColorMaterialEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/color_material_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorMaterialEnable;
    }

    public GlPipelineSettingsGroupGroupLightModelLocalViewerEnable[] getLightModelLocalViewerEnable()
        throws IOException
    {
        if (lightModelLocalViewerEnable == null) {
            try {
                lightModelLocalViewerEnable = ((GlPipelineSettingsGroupGroupLightModelLocalViewerEnable[]) getChildren(new GlPipelineSettingsGroupGroupLightModelLocalViewerEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_local_viewer_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_model_local_viewer_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightModelLocalViewerEnable;
    }

    public GlPipelineSettingsGroupGroupLightSpotExponent[] getLightSpotExponent()
        throws IOException
    {
        if (lightSpotExponent == null) {
            try {
                lightSpotExponent = ((GlPipelineSettingsGroupGroupLightSpotExponent[]) getChildren(new GlPipelineSettingsGroupGroupLightSpotExponent[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_exponent"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_spot_exponent"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightSpotExponent;
    }

    public GlPipelineSettingsGroupGroupMaterialDiffuse[] getMaterialDiffuse()
        throws IOException
    {
        if (materialDiffuse == null) {
            try {
                materialDiffuse = ((GlPipelineSettingsGroupGroupMaterialDiffuse[]) getChildren(new GlPipelineSettingsGroupGroupMaterialDiffuse[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_diffuse"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialDiffuse;
    }

    public GlPipelineSettingsGroupGroupColorLogicOpEnable[] getColorLogicOpEnable()
        throws IOException
    {
        if (colorLogicOpEnable == null) {
            try {
                colorLogicOpEnable = ((GlPipelineSettingsGroupGroupColorLogicOpEnable[]) getChildren(new GlPipelineSettingsGroupGroupColorLogicOpEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_logic_op_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/color_logic_op_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorLogicOpEnable;
    }

    public GlPipelineSettingsGroupGroupPolygonOffsetPointEnable[] getPolygonOffsetPointEnable()
        throws IOException
    {
        if (polygonOffsetPointEnable == null) {
            try {
                polygonOffsetPointEnable = ((GlPipelineSettingsGroupGroupPolygonOffsetPointEnable[]) getChildren(new GlPipelineSettingsGroupGroupPolygonOffsetPointEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_point_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_offset_point_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonOffsetPointEnable;
    }

    public GlPipelineSettingsGroupGroupTextureRECTEnable[] getTextureRECTEnable()
        throws IOException
    {
        if (textureRECTEnable == null) {
            try {
                textureRECTEnable = ((GlPipelineSettingsGroupGroupTextureRECTEnable[]) getChildren(new GlPipelineSettingsGroupGroupTextureRECTEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureRECT_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureRECT_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return textureRECTEnable;
    }

    public GlPipelineSettingsGroupGroupAlphaFunc[] getAlphaFunc()
        throws IOException
    {
        if (alphaFunc == null) {
            try {
                alphaFunc = ((GlPipelineSettingsGroupGroupAlphaFunc[]) getChildren(new GlPipelineSettingsGroupGroupAlphaFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/alpha_func"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return alphaFunc;
    }

    public GlPipelineSettingsGroupGroupModelViewMatrix[] getModelViewMatrix()
        throws IOException
    {
        if (modelViewMatrix == null) {
            try {
                modelViewMatrix = ((GlPipelineSettingsGroupGroupModelViewMatrix[]) getChildren(new GlPipelineSettingsGroupGroupModelViewMatrix[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "model_view_matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/model_view_matrix"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return modelViewMatrix;
    }

    public GlPipelineSettingsGroupGroupFogEnable[] getFogEnable()
        throws IOException
    {
        if (fogEnable == null) {
            try {
                fogEnable = ((GlPipelineSettingsGroupGroupFogEnable[]) getChildren(new GlPipelineSettingsGroupGroupFogEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogEnable;
    }

    public GlPipelineSettingsGroupGroupTextureRECT[] getTextureRECT()
        throws IOException
    {
        if (textureRECT == null) {
            try {
                textureRECT = ((GlPipelineSettingsGroupGroupTextureRECT[]) getChildren(new GlPipelineSettingsGroupGroupTextureRECT[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureRECT"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureRECT"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return textureRECT;
    }

    public GlPipelineSettingsGroupGroupPointSmoothEnable[] getPointSmoothEnable()
        throws IOException
    {
        if (pointSmoothEnable == null) {
            try {
                pointSmoothEnable = ((GlPipelineSettingsGroupGroupPointSmoothEnable[]) getChildren(new GlPipelineSettingsGroupGroupPointSmoothEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_smooth_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSmoothEnable;
    }

    public GlPipelineSettingsGroupGroupTexture3DEnable[] getTexture3DEnable()
        throws IOException
    {
        if (texture3DEnable == null) {
            try {
                texture3DEnable = ((GlPipelineSettingsGroupGroupTexture3DEnable[]) getChildren(new GlPipelineSettingsGroupGroupTexture3DEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture3D_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture3D_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return texture3DEnable;
    }

    public GlPipelineSettingsGroupGroupPointSize[] getPointSize()
        throws IOException
    {
        if (pointSize == null) {
            try {
                pointSize = ((GlPipelineSettingsGroupGroupPointSize[]) getChildren(new GlPipelineSettingsGroupGroupPointSize[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_size"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSize;
    }

    public GlPipelineSettingsGroupGroupPolygonOffsetFillEnable[] getPolygonOffsetFillEnable()
        throws IOException
    {
        if (polygonOffsetFillEnable == null) {
            try {
                polygonOffsetFillEnable = ((GlPipelineSettingsGroupGroupPolygonOffsetFillEnable[]) getChildren(new GlPipelineSettingsGroupGroupPolygonOffsetFillEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset_fill_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_offset_fill_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonOffsetFillEnable;
    }

    public GlPipelineSettingsGroupGroupStencilMaskSeparate[] getStencilMaskSeparate()
        throws IOException
    {
        if (stencilMaskSeparate == null) {
            try {
                stencilMaskSeparate = ((GlPipelineSettingsGroupGroupStencilMaskSeparate[]) getChildren(new GlPipelineSettingsGroupGroupStencilMaskSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_mask_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_mask_separate"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilMaskSeparate;
    }

    public GlPipelineSettingsGroupGroupBlendFunc[] getBlendFunc()
        throws IOException
    {
        if (blendFunc == null) {
            try {
                blendFunc = ((GlPipelineSettingsGroupGroupBlendFunc[]) getChildren(new GlPipelineSettingsGroupGroupBlendFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_func"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendFunc;
    }

    public GlPipelineSettingsGroupGroupNormalizeEnable[] getNormalizeEnable()
        throws IOException
    {
        if (normalizeEnable == null) {
            try {
                normalizeEnable = ((GlPipelineSettingsGroupGroupNormalizeEnable[]) getChildren(new GlPipelineSettingsGroupGroupNormalizeEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "normalize_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/normalize_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return normalizeEnable;
    }

    public GlPipelineSettingsGroupGroupPolygonOffset[] getPolygonOffset()
        throws IOException
    {
        if (polygonOffset == null) {
            try {
                polygonOffset = ((GlPipelineSettingsGroupGroupPolygonOffset[]) getChildren(new GlPipelineSettingsGroupGroupPolygonOffset[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_offset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_offset"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonOffset;
    }

    public GlPipelineSettingsGroupGroupBlendColor[] getBlendColor()
        throws IOException
    {
        if (blendColor == null) {
            try {
                blendColor = ((GlPipelineSettingsGroupGroupBlendColor[]) getChildren(new GlPipelineSettingsGroupGroupBlendColor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_color"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendColor;
    }

    public GlPipelineSettingsGroupGroupShadeModel[] getShadeModel()
        throws IOException
    {
        if (shadeModel == null) {
            try {
                shadeModel = ((GlPipelineSettingsGroupGroupShadeModel[]) getChildren(new GlPipelineSettingsGroupGroupShadeModel[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shade_model"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/shade_model"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return shadeModel;
    }

    public GlPipelineSettingsGroupGroupSampleAlphaToCoverageEnable[] getSampleAlphaToCoverageEnable()
        throws IOException
    {
        if (sampleAlphaToCoverageEnable == null) {
            try {
                sampleAlphaToCoverageEnable = ((GlPipelineSettingsGroupGroupSampleAlphaToCoverageEnable[]) getChildren(new GlPipelineSettingsGroupGroupSampleAlphaToCoverageEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_coverage_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/sample_alpha_to_coverage_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleAlphaToCoverageEnable;
    }

    public GlPipelineSettingsGroupGroupSampleAlphaToOneEnable[] getSampleAlphaToOneEnable()
        throws IOException
    {
        if (sampleAlphaToOneEnable == null) {
            try {
                sampleAlphaToOneEnable = ((GlPipelineSettingsGroupGroupSampleAlphaToOneEnable[]) getChildren(new GlPipelineSettingsGroupGroupSampleAlphaToOneEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sample_alpha_to_one_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/sample_alpha_to_one_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampleAlphaToOneEnable;
    }

    public GlPipelineSettingsGroupGroupDitherEnable[] getDitherEnable()
        throws IOException
    {
        if (ditherEnable == null) {
            try {
                ditherEnable = ((GlPipelineSettingsGroupGroupDitherEnable[]) getChildren(new GlPipelineSettingsGroupGroupDitherEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dither_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/dither_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ditherEnable;
    }

    public GlPipelineSettingsGroupGroupLightSpotDirection[] getLightSpotDirection()
        throws IOException
    {
        if (lightSpotDirection == null) {
            try {
                lightSpotDirection = ((GlPipelineSettingsGroupGroupLightSpotDirection[]) getChildren(new GlPipelineSettingsGroupGroupLightSpotDirection[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_spot_direction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_spot_direction"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightSpotDirection;
    }

    public GlPipelineSettingsGroupGroupFrontFace[] getFrontFace()
        throws IOException
    {
        if (frontFace == null) {
            try {
                frontFace = ((GlPipelineSettingsGroupGroupFrontFace[]) getChildren(new GlPipelineSettingsGroupGroupFrontFace[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "front_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/front_face"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return frontFace;
    }

    public GlPipelineSettingsGroupGroupLightSpecular[] getLightSpecular()
        throws IOException
    {
        if (lightSpecular == null) {
            try {
                lightSpecular = ((GlPipelineSettingsGroupGroupLightSpecular[]) getChildren(new GlPipelineSettingsGroupGroupLightSpecular[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_specular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_specular"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightSpecular;
    }

    public GlPipelineSettingsGroupGroupStencilTestEnable[] getStencilTestEnable()
        throws IOException
    {
        if (stencilTestEnable == null) {
            try {
                stencilTestEnable = ((GlPipelineSettingsGroupGroupStencilTestEnable[]) getChildren(new GlPipelineSettingsGroupGroupStencilTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_test_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilTestEnable;
    }

    public GlPipelineSettingsGroupGroupLightAmbient[] getLightAmbient()
        throws IOException
    {
        if (lightAmbient == null) {
            try {
                lightAmbient = ((GlPipelineSettingsGroupGroupLightAmbient[]) getChildren(new GlPipelineSettingsGroupGroupLightAmbient[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_ambient"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightAmbient;
    }

    public GlPipelineSettingsGroupGroupColorMaterial[] getColorMaterial()
        throws IOException
    {
        if (colorMaterial == null) {
            try {
                colorMaterial = ((GlPipelineSettingsGroupGroupColorMaterial[]) getChildren(new GlPipelineSettingsGroupGroupColorMaterial[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/color_material"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return colorMaterial;
    }

    public GlPipelineSettingsGroupGroupLightModelTwoSideEnable[] getLightModelTwoSideEnable()
        throws IOException
    {
        if (lightModelTwoSideEnable == null) {
            try {
                lightModelTwoSideEnable = ((GlPipelineSettingsGroupGroupLightModelTwoSideEnable[]) getChildren(new GlPipelineSettingsGroupGroupLightModelTwoSideEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_two_side_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_model_two_side_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightModelTwoSideEnable;
    }

    public GlPipelineSettingsGroupGroupFogEnd[] getFogEnd()
        throws IOException
    {
        if (fogEnd == null) {
            try {
                fogEnd = ((GlPipelineSettingsGroupGroupFogEnd[]) getChildren(new GlPipelineSettingsGroupGroupFogEnd[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_end"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_end"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogEnd;
    }

    public GlPipelineSettingsGroupGroupClipPlane[] getClipPlane()
        throws IOException
    {
        if (clipPlane == null) {
            try {
                clipPlane = ((GlPipelineSettingsGroupGroupClipPlane[]) getChildren(new GlPipelineSettingsGroupGroupClipPlane[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/clip_plane"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return clipPlane;
    }

    public GlPipelineSettingsGroupGroupLogicOp[] getLogicOp()
        throws IOException
    {
        if (logicOp == null) {
            try {
                logicOp = ((GlPipelineSettingsGroupGroupLogicOp[]) getChildren(new GlPipelineSettingsGroupGroupLogicOp[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/logic_op"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return logicOp;
    }

    public GlPipelineSettingsGroupGroupPointFadeThresholdSize[] getPointFadeThresholdSize()
        throws IOException
    {
        if (pointFadeThresholdSize == null) {
            try {
                pointFadeThresholdSize = ((GlPipelineSettingsGroupGroupPointFadeThresholdSize[]) getChildren(new GlPipelineSettingsGroupGroupPointFadeThresholdSize[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_fade_threshold_size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_fade_threshold_size"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointFadeThresholdSize;
    }

    public GlPipelineSettingsGroupGroupLineStippleEnable[] getLineStippleEnable()
        throws IOException
    {
        if (lineStippleEnable == null) {
            try {
                lineStippleEnable = ((GlPipelineSettingsGroupGroupLineStippleEnable[]) getChildren(new GlPipelineSettingsGroupGroupLineStippleEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_stipple_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/line_stipple_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lineStippleEnable;
    }

    public GlPipelineSettingsGroupGroupTexture2DEnable[] getTexture2DEnable()
        throws IOException
    {
        if (texture2DEnable == null) {
            try {
                texture2DEnable = ((GlPipelineSettingsGroupGroupTexture2DEnable[]) getChildren(new GlPipelineSettingsGroupGroupTexture2DEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture2D_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture2D_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return texture2DEnable;
    }

    public GlPipelineSettingsGroupGroupLineStipple[] getLineStipple()
        throws IOException
    {
        if (lineStipple == null) {
            try {
                lineStipple = ((GlPipelineSettingsGroupGroupLineStipple[]) getChildren(new GlPipelineSettingsGroupGroupLineStipple[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_stipple"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/line_stipple"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lineStipple;
    }

    public GlPipelineSettingsGroupGroupMaterialAmbient[] getMaterialAmbient()
        throws IOException
    {
        if (materialAmbient == null) {
            try {
                materialAmbient = ((GlPipelineSettingsGroupGroupMaterialAmbient[]) getChildren(new GlPipelineSettingsGroupGroupMaterialAmbient[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_ambient"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialAmbient;
    }

    public GlPipelineSettingsGroupGroupPolygonSmoothEnable[] getPolygonSmoothEnable()
        throws IOException
    {
        if (polygonSmoothEnable == null) {
            try {
                polygonSmoothEnable = ((GlPipelineSettingsGroupGroupPolygonSmoothEnable[]) getChildren(new GlPipelineSettingsGroupGroupPolygonSmoothEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_smooth_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_smooth_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonSmoothEnable;
    }

    public GlPipelineSettingsGroupGroupClipPlaneEnable[] getClipPlaneEnable()
        throws IOException
    {
        if (clipPlaneEnable == null) {
            try {
                clipPlaneEnable = ((GlPipelineSettingsGroupGroupClipPlaneEnable[]) getChildren(new GlPipelineSettingsGroupGroupClipPlaneEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "clip_plane_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/clip_plane_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return clipPlaneEnable;
    }

    public GlPipelineSettingsGroupGroupStencilOpSeparate[] getStencilOpSeparate()
        throws IOException
    {
        if (stencilOpSeparate == null) {
            try {
                stencilOpSeparate = ((GlPipelineSettingsGroupGroupStencilOpSeparate[]) getChildren(new GlPipelineSettingsGroupGroupStencilOpSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "stencil_op_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op_separate"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return stencilOpSeparate;
    }

    public GlPipelineSettingsGroupGroupLightQuadraticAttenuation[] getLightQuadraticAttenuation()
        throws IOException
    {
        if (lightQuadraticAttenuation == null) {
            try {
                lightQuadraticAttenuation = ((GlPipelineSettingsGroupGroupLightQuadraticAttenuation[]) getChildren(new GlPipelineSettingsGroupGroupLightQuadraticAttenuation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_quadratic_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_quadratic_attenuation"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightQuadraticAttenuation;
    }

    public GlPipelineSettingsGroupGroupFogDensity[] getFogDensity()
        throws IOException
    {
        if (fogDensity == null) {
            try {
                fogDensity = ((GlPipelineSettingsGroupGroupFogDensity[]) getChildren(new GlPipelineSettingsGroupGroupFogDensity[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_density"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_density"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogDensity;
    }

    public GlPipelineSettingsGroupGroupProjectionMatrix[] getProjectionMatrix()
        throws IOException
    {
        if (projectionMatrix == null) {
            try {
                projectionMatrix = ((GlPipelineSettingsGroupGroupProjectionMatrix[]) getChildren(new GlPipelineSettingsGroupGroupProjectionMatrix[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "projection_matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/projection_matrix"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return projectionMatrix;
    }

    public GlPipelineSettingsGroupGroupBlendFuncSeparate[] getBlendFuncSeparate()
        throws IOException
    {
        if (blendFuncSeparate == null) {
            try {
                blendFuncSeparate = ((GlPipelineSettingsGroupGroupBlendFuncSeparate[]) getChildren(new GlPipelineSettingsGroupGroupBlendFuncSeparate[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blend_func_separate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/blend_func_separate"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blendFuncSeparate;
    }

    public GlPipelineSettingsGroupGroupMaterialSpecular[] getMaterialSpecular()
        throws IOException
    {
        if (materialSpecular == null) {
            try {
                materialSpecular = ((GlPipelineSettingsGroupGroupMaterialSpecular[]) getChildren(new GlPipelineSettingsGroupGroupMaterialSpecular[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_specular"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_specular"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialSpecular;
    }

    public GlPipelineSettingsGroupGroupLightModelColorControl[] getLightModelColorControl()
        throws IOException
    {
        if (lightModelColorControl == null) {
            try {
                lightModelColorControl = ((GlPipelineSettingsGroupGroupLightModelColorControl[]) getChildren(new GlPipelineSettingsGroupGroupLightModelColorControl[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_model_color_control"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_model_color_control"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightModelColorControl;
    }

    public GlPipelineSettingsGroupGroupPolygonMode[] getPolygonMode()
        throws IOException
    {
        if (polygonMode == null) {
            try {
                polygonMode = ((GlPipelineSettingsGroupGroupPolygonMode[]) getChildren(new GlPipelineSettingsGroupGroupPolygonMode[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_mode"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonMode;
    }

    public GlPipelineSettingsGroupGroupLightConstantAttenuation[] getLightConstantAttenuation()
        throws IOException
    {
        if (lightConstantAttenuation == null) {
            try {
                lightConstantAttenuation = ((GlPipelineSettingsGroupGroupLightConstantAttenuation[]) getChildren(new GlPipelineSettingsGroupGroupLightConstantAttenuation[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_constant_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_constant_attenuation"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightConstantAttenuation;
    }

    public GlPipelineSettingsGroupGroupPointSizeMin[] getPointSizeMin()
        throws IOException
    {
        if (pointSizeMin == null) {
            try {
                pointSizeMin = ((GlPipelineSettingsGroupGroupPointSizeMin[]) getChildren(new GlPipelineSettingsGroupGroupPointSizeMin[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_min"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_size_min"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSizeMin;
    }

    public GlPipelineSettingsGroupGroupPolygonStippleEnable[] getPolygonStippleEnable()
        throws IOException
    {
        if (polygonStippleEnable == null) {
            try {
                polygonStippleEnable = ((GlPipelineSettingsGroupGroupPolygonStippleEnable[]) getChildren(new GlPipelineSettingsGroupGroupPolygonStippleEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygon_stipple_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_stipple_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygonStippleEnable;
    }

    public GlPipelineSettingsGroupGroupLightPosition[] getLightPosition()
        throws IOException
    {
        if (lightPosition == null) {
            try {
                lightPosition = ((GlPipelineSettingsGroupGroupLightPosition[]) getChildren(new GlPipelineSettingsGroupGroupLightPosition[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_position"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/light_position"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightPosition;
    }

    public GlPipelineSettingsGroupGroupPointSizeMax[] getPointSizeMax()
        throws IOException
    {
        if (pointSizeMax == null) {
            try {
                pointSizeMax = ((GlPipelineSettingsGroupGroupPointSizeMax[]) getChildren(new GlPipelineSettingsGroupGroupPointSizeMax[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point_size_max"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/point_size_max"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pointSizeMax;
    }

    public GlPipelineSettingsGroupGroupCullFace[] getCullFace()
        throws IOException
    {
        if (cullFace == null) {
            try {
                cullFace = ((GlPipelineSettingsGroupGroupCullFace[]) getChildren(new GlPipelineSettingsGroupGroupCullFace[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cull_face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/cull_face"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cullFace;
    }

    public GlPipelineSettingsGroupGroupDepthRange[] getDepthRange()
        throws IOException
    {
        if (depthRange == null) {
            try {
                depthRange = ((GlPipelineSettingsGroupGroupDepthRange[]) getChildren(new GlPipelineSettingsGroupGroupDepthRange[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_range"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_range"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthRange;
    }

    public GlPipelineSettingsGroupGroupDepthTestEnable[] getDepthTestEnable()
        throws IOException
    {
        if (depthTestEnable == null) {
            try {
                depthTestEnable = ((GlPipelineSettingsGroupGroupDepthTestEnable[]) getChildren(new GlPipelineSettingsGroupGroupDepthTestEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_test_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_test_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthTestEnable;
    }

    public GlPipelineSettingsGroupGroupTextureEnvMode[] getTextureEnvMode()
        throws IOException
    {
        if (textureEnvMode == null) {
            try {
                textureEnvMode = ((GlPipelineSettingsGroupGroupTextureEnvMode[]) getChildren(new GlPipelineSettingsGroupGroupTextureEnvMode[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture_env_mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture_env_mode"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return textureEnvMode;
    }

    public GlPipelineSettingsGroupGroupDepthClampEnable[] getDepthClampEnable()
        throws IOException
    {
        if (depthClampEnable == null) {
            try {
                depthClampEnable = ((GlPipelineSettingsGroupGroupDepthClampEnable[]) getChildren(new GlPipelineSettingsGroupGroupDepthClampEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_clamp_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_clamp_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthClampEnable;
    }

    public GlPipelineSettingsGroupGroupLightingEnable[] getLightingEnable()
        throws IOException
    {
        if (lightingEnable == null) {
            try {
                lightingEnable = ((GlPipelineSettingsGroupGroupLightingEnable[]) getChildren(new GlPipelineSettingsGroupGroupLightingEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lighting_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/lighting_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lightingEnable;
    }

    public GlPipelineSettingsGroupGroupDepthFunc[] getDepthFunc()
        throws IOException
    {
        if (depthFunc == null) {
            try {
                depthFunc = ((GlPipelineSettingsGroupGroupDepthFunc[]) getChildren(new GlPipelineSettingsGroupGroupDepthFunc[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "depth_func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/depth_func"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return depthFunc;
    }

    public GlPipelineSettingsGroupGroupLogicOpEnable[] getLogicOpEnable()
        throws IOException
    {
        if (logicOpEnable == null) {
            try {
                logicOpEnable = ((GlPipelineSettingsGroupGroupLogicOpEnable[]) getChildren(new GlPipelineSettingsGroupGroupLogicOpEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "logic_op_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/logic_op_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return logicOpEnable;
    }

    public GlPipelineSettingsGroupGroupMultisampleEnable[] getMultisampleEnable()
        throws IOException
    {
        if (multisampleEnable == null) {
            try {
                multisampleEnable = ((GlPipelineSettingsGroupGroupMultisampleEnable[]) getChildren(new GlPipelineSettingsGroupGroupMultisampleEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "multisample_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/multisample_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return multisampleEnable;
    }

    public GlPipelineSettingsGroupGroupMaterialShininess[] getMaterialShininess()
        throws IOException
    {
        if (materialShininess == null) {
            try {
                materialShininess = ((GlPipelineSettingsGroupGroupMaterialShininess[]) getChildren(new GlPipelineSettingsGroupGroupMaterialShininess[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "material_shininess"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/material_shininess"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return materialShininess;
    }

    public GlPipelineSettingsGroupGroupTexture1DEnable[] getTexture1DEnable()
        throws IOException
    {
        if (texture1DEnable == null) {
            try {
                texture1DEnable = ((GlPipelineSettingsGroupGroupTexture1DEnable[]) getChildren(new GlPipelineSettingsGroupGroupTexture1DEnable[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture1D_enable"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/texture1D_enable"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return texture1DEnable;
    }

    public GlPipelineSettingsGroupGroupFogMode[] getFogMode()
        throws IOException
    {
        if (fogMode == null) {
            try {
                fogMode = ((GlPipelineSettingsGroupGroupFogMode[]) getChildren(new GlPipelineSettingsGroupGroupFogMode[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fog_mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/fog_mode"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fogMode;
    }

    public GlPipelineSettingsGroupGroupScissor[] getScissor()
        throws IOException
    {
        if (scissor == null) {
            try {
                scissor = ((GlPipelineSettingsGroupGroupScissor[]) getChildren(new GlPipelineSettingsGroupGroupScissor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scissor"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/scissor"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scissor;
    }

    public GlPipelineSettingsGroupGroupLineWidth[] getLineWidth()
        throws IOException
    {
        if (lineWidth == null) {
            try {
                lineWidth = ((GlPipelineSettingsGroupGroupLineWidth[]) getChildren(new GlPipelineSettingsGroupGroupLineWidth[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_width"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/line_width"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lineWidth;
    }

    public GlPipelineSettingsGroupGroupTextureDEPTH[] getTextureDEPTH()
        throws IOException
    {
        if (textureDEPTH == null) {
            try {
                textureDEPTH = ((GlPipelineSettingsGroupGroupTextureDEPTH[]) getChildren(new GlPipelineSettingsGroupGroupTextureDEPTH[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "textureDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/textureDEPTH"), CgPassTypeGroupStates.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return textureDEPTH;
    }

}
