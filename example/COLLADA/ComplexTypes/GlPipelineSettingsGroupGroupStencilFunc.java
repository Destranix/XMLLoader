
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class GlPipelineSettingsGroupGroupStencilFunc
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((func[ ]+){1}(ref[ ]+){1}(mask[ ]+){1}){1}";
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
    protected GlPipelineSettingsGroupGroupStencilFuncGroupMask mask;
    protected GlPipelineSettingsGroupGroupStencilFuncGroupFunc func;
    protected GlPipelineSettingsGroupGroupStencilFuncGroupRef ref;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mask"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func/group/mask"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mask"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mask"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func/group/func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func/group/ref"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlPipelineSettingsGroupGroupStencilFunc(XmlComplexType elem) {
        super(elem, GlPipelineSettingsGroupGroupStencilFunc.class);
    }

    public GlPipelineSettingsGroupGroupStencilFuncGroupMask getMask()
        throws IOException
    {
        if (mask == null) {
            try {
                mask = ((GlPipelineSettingsGroupGroupStencilFuncGroupMask) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mask"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func/group/mask"), GlPipelineSettingsGroupGroupStencilFunc.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mask;
    }

    public GlPipelineSettingsGroupGroupStencilFuncGroupFunc getFunc()
        throws IOException
    {
        if (func == null) {
            try {
                func = ((GlPipelineSettingsGroupGroupStencilFuncGroupFunc) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func/group/func"), GlPipelineSettingsGroupGroupStencilFunc.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return func;
    }

    public GlPipelineSettingsGroupGroupStencilFuncGroupRef getRef()
        throws IOException
    {
        if (ref == null) {
            try {
                ref = ((GlPipelineSettingsGroupGroupStencilFuncGroupRef) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_func/group/ref"), GlPipelineSettingsGroupGroupStencilFunc.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ref;
    }

}
