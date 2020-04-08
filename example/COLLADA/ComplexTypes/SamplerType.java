
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class SamplerType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((input[ ]+){1,}){1}";
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
    protected InputLocalType[] input;

    static {
        ALLOWED_ATTRIBUTES.add("pre_behavior");
        try {
            ATTRIBUTES_NAME_MAP.put("pre_behavior", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler_behavior_enum"));
            ATTRIBUTES_NAME_MAP.put("post_behavior", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler_behavior_enum"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input_local_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("post_behavior");
        ALLOWED_ATTRIBUTES.add("id");
    }

    public SamplerType(XmlComplexType elem) {
        super(elem, SamplerType.class);
    }

    public InputLocalType[] getInput()
        throws IOException
    {
        if (input == null) {
            try {
                input = ((InputLocalType[]) getChildren(new InputLocalType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "input_local_type"), SamplerType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return input;
    }

}
