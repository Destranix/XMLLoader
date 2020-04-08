
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class Gles2PipelineSettingsGroupGroupBlendFunc
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((src[ ]+){1}(dest[ ]+){1}){1}";
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
    protected Gles2PipelineSettingsGroupGroupBlendFuncGroupDest dest;
    protected Gles2PipelineSettingsGroupGroupBlendFuncGroupSrc src;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func/group/dest"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func/group/src"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public Gles2PipelineSettingsGroupGroupBlendFunc(XmlComplexType elem) {
        super(elem, Gles2PipelineSettingsGroupGroupBlendFunc.class);
    }

    public Gles2PipelineSettingsGroupGroupBlendFuncGroupDest getDest()
        throws IOException
    {
        if (dest == null) {
            try {
                dest = ((Gles2PipelineSettingsGroupGroupBlendFuncGroupDest) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dest"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func/group/dest"), Gles2PipelineSettingsGroupGroupBlendFunc.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return dest;
    }

    public Gles2PipelineSettingsGroupGroupBlendFuncGroupSrc getSrc()
        throws IOException
    {
        if (src == null) {
            try {
                src = ((Gles2PipelineSettingsGroupGroupBlendFuncGroupSrc) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "src"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_pipeline_settings_group/group/blend_func/group/src"), Gles2PipelineSettingsGroupGroupBlendFunc.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return src;
    }

}
