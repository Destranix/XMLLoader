
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class FxColortargetType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((param[ ]+){1}|(instance_image[ ]+){1}){0,1})(())";
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
    protected FxRendertargetTypeGroupParam param;
    protected InstanceImageType instanceImage;

    static {
        ALLOWED_ATTRIBUTES.add("mip");
        ATTRIBUTE_DEFAULT_VALUES.put("mip", "0");
        try {
            ATTRIBUTES_NAME_MAP.put("mip", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "nonNegativeInteger"));
            ATTRIBUTES_NAME_MAP.put("face", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_face_enum"));
            ATTRIBUTES_NAME_MAP.put("slice", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "nonNegativeInteger"));
            ATTRIBUTES_NAME_MAP.put("index", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "nonNegativeInteger"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_rendertarget_type/group/param"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_image"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_image"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_image_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_image"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_image"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("face");
        ATTRIBUTE_DEFAULT_VALUES.put("face", "POSITIVE_X");
        ALLOWED_ATTRIBUTES.add("slice");
        ATTRIBUTE_DEFAULT_VALUES.put("slice", "0");
        ALLOWED_ATTRIBUTES.add("index");
        ATTRIBUTE_DEFAULT_VALUES.put("index", "0");
    }

    public FxColortargetType(XmlComplexType elem) {
        super(elem, FxColortargetType.class);
    }

    public FxRendertargetTypeGroupParam getParam()
        throws IOException
    {
        if (param == null) {
            try {
                param = ((FxRendertargetTypeGroupParam) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_rendertarget_type/group/param"), FxColortargetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return param;
    }

    public InstanceImageType getInstanceImage()
        throws IOException
    {
        if (instanceImage == null) {
            try {
                instanceImage = ((InstanceImageType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_image"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_image_type"), FxColortargetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceImage;
    }

}
