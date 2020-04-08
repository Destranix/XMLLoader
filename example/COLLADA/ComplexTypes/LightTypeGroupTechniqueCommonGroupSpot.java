
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class LightTypeGroupTechniqueCommonGroupSpot
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((color[ ]+){1}(constant_attenuation[ ]+){0,1}(linear_attenuation[ ]+){0,1}(quadratic_attenuation[ ]+){0,1}(falloff_angle[ ]+){0,1}(falloff_exponent[ ]+){0,1}){1}";
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
    protected TargetableFloatType constantAttenuation;
    protected TargetableFloatType falloffExponent;
    protected TargetableFloatType linearAttenuation;
    protected TargetableFloatType quadraticAttenuation;
    protected TargetableFloat3Type color;
    protected TargetableFloatType falloffAngle;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant_attenuation"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_exponent"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_exponent"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_exponent"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_exponent"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear_attenuation"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "quadratic_attenuation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "quadratic_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "quadratic_attenuation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "quadratic_attenuation"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_angle"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_angle"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_angle"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_angle"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public LightTypeGroupTechniqueCommonGroupSpot(XmlComplexType elem) {
        super(elem, LightTypeGroupTechniqueCommonGroupSpot.class);
    }

    public TargetableFloatType getConstantAttenuation()
        throws IOException
    {
        if (constantAttenuation == null) {
            try {
                constantAttenuation = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), LightTypeGroupTechniqueCommonGroupSpot.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return constantAttenuation;
    }

    public TargetableFloatType getFalloffExponent()
        throws IOException
    {
        if (falloffExponent == null) {
            try {
                falloffExponent = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_exponent"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), LightTypeGroupTechniqueCommonGroupSpot.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return falloffExponent;
    }

    public TargetableFloatType getLinearAttenuation()
        throws IOException
    {
        if (linearAttenuation == null) {
            try {
                linearAttenuation = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linear_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), LightTypeGroupTechniqueCommonGroupSpot.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return linearAttenuation;
    }

    public TargetableFloatType getQuadraticAttenuation()
        throws IOException
    {
        if (quadraticAttenuation == null) {
            try {
                quadraticAttenuation = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "quadratic_attenuation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), LightTypeGroupTechniqueCommonGroupSpot.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return quadraticAttenuation;
    }

    public TargetableFloat3Type getColor()
        throws IOException
    {
        if (color == null) {
            try {
                color = ((TargetableFloat3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "color"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float3_type"), LightTypeGroupTechniqueCommonGroupSpot.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return color;
    }

    public TargetableFloatType getFalloffAngle()
        throws IOException
    {
        if (falloffAngle == null) {
            try {
                falloffAngle = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "falloff_angle"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), LightTypeGroupTechniqueCommonGroupSpot.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return falloffAngle;
    }

}
