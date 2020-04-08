
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class GlPipelineSettingsGroupGroupStencilOp
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((fail[ ]+){1}(zfail[ ]+){1}(zpass[ ]+){1}){1}";
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
    protected GlPipelineSettingsGroupGroupStencilOpGroupZfail zfail;
    protected GlPipelineSettingsGroupGroupStencilOpGroupZpass zpass;
    protected GlPipelineSettingsGroupGroupStencilOpGroupFail fail;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfail"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfail"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op/group/zfail"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfail"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfail"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zpass"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zpass"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op/group/zpass"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zpass"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zpass"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fail"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fail"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op/group/fail"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fail"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fail"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlPipelineSettingsGroupGroupStencilOp(XmlComplexType elem) {
        super(elem, GlPipelineSettingsGroupGroupStencilOp.class);
    }

    public GlPipelineSettingsGroupGroupStencilOpGroupZfail getZfail()
        throws IOException
    {
        if (zfail == null) {
            try {
                zfail = ((GlPipelineSettingsGroupGroupStencilOpGroupZfail) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfail"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op/group/zfail"), GlPipelineSettingsGroupGroupStencilOp.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return zfail;
    }

    public GlPipelineSettingsGroupGroupStencilOpGroupZpass getZpass()
        throws IOException
    {
        if (zpass == null) {
            try {
                zpass = ((GlPipelineSettingsGroupGroupStencilOpGroupZpass) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zpass"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op/group/zpass"), GlPipelineSettingsGroupGroupStencilOp.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return zpass;
    }

    public GlPipelineSettingsGroupGroupStencilOpGroupFail getFail()
        throws IOException
    {
        if (fail == null) {
            try {
                fail = ((GlPipelineSettingsGroupGroupStencilOpGroupFail) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fail"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_pipeline_settings_group/group/stencil_op/group/fail"), GlPipelineSettingsGroupGroupStencilOp.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fail;
    }

}
