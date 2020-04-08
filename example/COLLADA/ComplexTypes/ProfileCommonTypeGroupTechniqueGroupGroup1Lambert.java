
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ProfileCommonTypeGroupTechniqueGroupGroup1Lambert
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((emission[ ]+){0,1}(ambient[ ]+){0,1}(diffuse[ ]+){0,1}(reflective[ ]+){0,1}(reflectivity[ ]+){0,1}(transparent[ ]+){0,1}(transparency[ ]+){0,1}(index_of_refraction[ ]+){0,1}){1}";
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
    protected FxCommonColorOrTextureType diffuse;
    protected FxCommonFloatOrParamType transparency;
    protected FxCommonFloatOrParamType indexOfRefraction;
    protected FxCommonFloatOrParamType reflectivity;
    protected FxCommonTransparentType transparent;
    protected FxCommonColorOrTextureType emission;
    protected FxCommonColorOrTextureType ambient;
    protected FxCommonColorOrTextureType reflective;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "diffuse"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "diffuse"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "diffuse"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparency"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparency"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_float_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparency"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparency"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index_of_refraction"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index_of_refraction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_float_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index_of_refraction"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index_of_refraction"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflectivity"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflectivity"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_float_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflectivity"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflectivity"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparent"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparent"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_transparent_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparent"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparent"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "emission"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "emission"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "emission"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "emission"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflective"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflective"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflective"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflective"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ProfileCommonTypeGroupTechniqueGroupGroup1Lambert(XmlComplexType elem) {
        super(elem, ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class);
    }

    public FxCommonColorOrTextureType getDiffuse()
        throws IOException
    {
        if (diffuse == null) {
            try {
                diffuse = ((FxCommonColorOrTextureType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "diffuse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type"), ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return diffuse;
    }

    public FxCommonFloatOrParamType getTransparency()
        throws IOException
    {
        if (transparency == null) {
            try {
                transparency = ((FxCommonFloatOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparency"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_float_or_param_type"), ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return transparency;
    }

    public FxCommonFloatOrParamType getIndexOfRefraction()
        throws IOException
    {
        if (indexOfRefraction == null) {
            try {
                indexOfRefraction = ((FxCommonFloatOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index_of_refraction"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_float_or_param_type"), ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return indexOfRefraction;
    }

    public FxCommonFloatOrParamType getReflectivity()
        throws IOException
    {
        if (reflectivity == null) {
            try {
                reflectivity = ((FxCommonFloatOrParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflectivity"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_float_or_param_type"), ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return reflectivity;
    }

    public FxCommonTransparentType getTransparent()
        throws IOException
    {
        if (transparent == null) {
            try {
                transparent = ((FxCommonTransparentType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "transparent"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_transparent_type"), ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return transparent;
    }

    public FxCommonColorOrTextureType getEmission()
        throws IOException
    {
        if (emission == null) {
            try {
                emission = ((FxCommonColorOrTextureType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "emission"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type"), ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return emission;
    }

    public FxCommonColorOrTextureType getAmbient()
        throws IOException
    {
        if (ambient == null) {
            try {
                ambient = ((FxCommonColorOrTextureType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type"), ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ambient;
    }

    public FxCommonColorOrTextureType getReflective()
        throws IOException
    {
        if (reflective == null) {
            try {
                reflective = ((FxCommonColorOrTextureType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "reflective"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_common_color_or_texture_type"), ProfileCommonTypeGroupTechniqueGroupGroup1Lambert.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return reflective;
    }

}
