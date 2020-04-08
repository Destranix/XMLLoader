
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.Float2Type;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class CommonFloat2OrParamType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((float2[ ]+){1}|(param[ ]+){1}){0,1}";
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
    protected CommonParamType param;
    protected Float2Type float2;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public CommonFloat2OrParamType(XmlComplexType elem) {
        super(elem, CommonFloat2OrParamType.class);
    }

    public CommonParamType getParam()
        throws IOException
    {
        if (param == null) {
            try {
                param = ((CommonParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_param_type"), CommonFloat2OrParamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return param;
    }

    public Float2Type getFloat2()
        throws IOException
    {
        if (float2 == null) {
            try {
                float2 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), CommonFloat2OrParamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2;
    }

}
