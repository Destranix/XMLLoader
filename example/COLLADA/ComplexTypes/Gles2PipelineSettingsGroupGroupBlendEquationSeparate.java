
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class Gles2PipelineSettingsGroupGroupBlendEquationSeparate
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((rgb[ ]+){1}(alpha[ ]+){1}){1}";
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
    protected Gles2PipelineSettingsGroupGroupBlendEquationSeparateGroupRgb rgb;
    protected Gles2PipelineSettingsGroupGroupBlendEquationSeparateGroupAlpha alpha;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rgb"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rgb"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_equation_separate/group/rgb"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rgb"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rgb"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_equation_separate/group/alpha"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public Gles2PipelineSettingsGroupGroupBlendEquationSeparate(XmlComplexType elem) {
        super(elem, Gles2PipelineSettingsGroupGroupBlendEquationSeparate.class);
    }

    public Gles2PipelineSettingsGroupGroupBlendEquationSeparateGroupRgb getRgb()
        throws IOException
    {
        if (rgb == null) {
            try {
                rgb = ((Gles2PipelineSettingsGroupGroupBlendEquationSeparateGroupRgb) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rgb"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_equation_separate/group/rgb"), Gles2PipelineSettingsGroupGroupBlendEquationSeparate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rgb;
    }

    public Gles2PipelineSettingsGroupGroupBlendEquationSeparateGroupAlpha getAlpha()
        throws IOException
    {
        if (alpha == null) {
            try {
                alpha = ((Gles2PipelineSettingsGroupGroupBlendEquationSeparateGroupAlpha) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "alpha"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_equation_separate/group/alpha"), Gles2PipelineSettingsGroupGroupBlendEquationSeparate.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return alpha;
    }

}
