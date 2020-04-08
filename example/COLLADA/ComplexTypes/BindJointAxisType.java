
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class BindJointAxisType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((axis[ ]+){1}(value[ ]+){1}){1}";
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
    protected CommonSidrefOrParamType axis;
    protected CommonFloatOrParamType value;

    static {
        ALLOWED_ATTRIBUTES.add("target");
        try {
            ATTRIBUTES_NAME_MAP.put("target", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_sidref_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public BindJointAxisType(XmlComplexType elem) {
        super(elem, BindJointAxisType.class);
    }

    public CommonSidrefOrParamType getAxis()
        throws IOException
    {
        if (axis == null) {
            try {
                axis = ((CommonSidrefOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "axis"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_sidref_or_param_type"), BindJointAxisType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return axis;
    }

    public CommonFloatOrParamType getValue()
        throws IOException
    {
        if (value == null) {
            try {
                value = ((CommonFloatOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_float_or_param_type"), BindJointAxisType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return value;
    }

}
