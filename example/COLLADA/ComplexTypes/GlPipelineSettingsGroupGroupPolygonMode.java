
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class GlPipelineSettingsGroupGroupPolygonMode
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((face[ ]+){1}(mode[ ]+){1}){1}";
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
    protected GlPipelineSettingsGroupGroupPolygonModeGroupMode mode;
    protected GlPipelineSettingsGroupGroupPolygonModeGroupFace face;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mode"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_mode/group/mode"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mode"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mode"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "face"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_mode/group/face"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "face"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "face"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlPipelineSettingsGroupGroupPolygonMode(XmlComplexType elem) {
        super(elem, GlPipelineSettingsGroupGroupPolygonMode.class);
    }

    public GlPipelineSettingsGroupGroupPolygonModeGroupMode getMode()
        throws IOException
    {
        if (mode == null) {
            try {
                mode = ((GlPipelineSettingsGroupGroupPolygonModeGroupMode) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mode"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_mode/group/mode"), GlPipelineSettingsGroupGroupPolygonMode.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mode;
    }

    public GlPipelineSettingsGroupGroupPolygonModeGroupFace getFace()
        throws IOException
    {
        if (face == null) {
            try {
                face = ((GlPipelineSettingsGroupGroupPolygonModeGroupFace) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "face"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/polygon_mode/group/face"), GlPipelineSettingsGroupGroupPolygonMode.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return face;
    }

}
