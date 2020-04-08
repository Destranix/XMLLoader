
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class GlesPipelineSettingsGroupGroupAlphaFunc
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((func[ ]+){1}(value[ ]+){1}){1}";
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
    protected GlesPipelineSettingsGroupGroupAlphaFuncGroupFunc func;
    protected GlesPipelineSettingsGroupGroupAlphaFuncGroupValue value;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/alpha_func/group/func"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/alpha_func/group/value"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlesPipelineSettingsGroupGroupAlphaFunc(XmlComplexType elem) {
        super(elem, GlesPipelineSettingsGroupGroupAlphaFunc.class);
    }

    public GlesPipelineSettingsGroupGroupAlphaFuncGroupFunc getFunc()
        throws IOException
    {
        if (func == null) {
            try {
                func = ((GlesPipelineSettingsGroupGroupAlphaFuncGroupFunc) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "func"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/alpha_func/group/func"), GlesPipelineSettingsGroupGroupAlphaFunc.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return func;
    }

    public GlesPipelineSettingsGroupGroupAlphaFuncGroupValue getValue()
        throws IOException
    {
        if (value == null) {
            try {
                value = ((GlesPipelineSettingsGroupGroupAlphaFuncGroupValue) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_pipeline_settings_group/group/alpha_func/group/value"), GlesPipelineSettingsGroupGroupAlphaFunc.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return value;
    }

}
