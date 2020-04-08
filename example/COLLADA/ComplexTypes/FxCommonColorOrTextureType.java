
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class FxCommonColorOrTextureType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((color[ ]+){1}|(param[ ]+){1}|(texture[ ]+){1}){0,1}";
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
    protected FxCommonColorOrTextureTypeGroupParam param;
    protected FxCommonColorOrTextureTypeGroupTexture texture;
    protected FxCommonColorOrTextureTypeGroupColor color;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type/group/param"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type/group/texture"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type/group/color"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public FxCommonColorOrTextureType(XmlComplexType elem) {
        super(elem, FxCommonColorOrTextureType.class);
    }

    public FxCommonColorOrTextureTypeGroupParam getParam()
        throws IOException
    {
        if (param == null) {
            try {
                param = ((FxCommonColorOrTextureTypeGroupParam) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type/group/param"), FxCommonColorOrTextureType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return param;
    }

    public FxCommonColorOrTextureTypeGroupTexture getTexture()
        throws IOException
    {
        if (texture == null) {
            try {
                texture = ((FxCommonColorOrTextureTypeGroupTexture) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "texture"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type/group/texture"), FxCommonColorOrTextureType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return texture;
    }

    public FxCommonColorOrTextureTypeGroupColor getColor()
        throws IOException
    {
        if (color == null) {
            try {
                color = ((FxCommonColorOrTextureTypeGroupColor) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type/group/color"), FxCommonColorOrTextureType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return color;
    }

}
