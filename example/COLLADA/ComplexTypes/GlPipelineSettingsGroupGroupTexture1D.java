
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlNCName;

public final class GlPipelineSettingsGroupGroupTexture1D
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((value[ ]+){1}|(param[ ]+){1}){0,1}";
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
    protected XmlNCName param;
    protected FxSampler1DType value;

    static {
        ALLOWED_ATTRIBUTES.add("index");
        REQUIRED_ATTRIBUTES.add("index");
        try {
            ATTRIBUTES_NAME_MAP.put("index", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_max_texture_image_units_index_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler1D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlPipelineSettingsGroupGroupTexture1D(XmlComplexType elem) {
        super(elem, GlPipelineSettingsGroupGroupTexture1D.class);
    }

    public XmlNCName getParam()
        throws IOException
    {
        if (param == null) {
            try {
                param = ((XmlNCName) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "param"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"), GlPipelineSettingsGroupGroupTexture1D.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return param;
    }

    public FxSampler1DType getValue()
        throws IOException
    {
        if (value == null) {
            try {
                value = ((FxSampler1DType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "value"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler1D_type"), GlPipelineSettingsGroupGroupTexture1D.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return value;
    }

}
