
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlFloat;

public class GlAlphaValueType
    extends XmlSimpleType
{

    protected final float value;

    public GlAlphaValueType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = GlAlphaValueType.parseAndCheckValuePrimitive(value, this.file);
    }

    @Override
    public Float getValue() {
        return Float.valueOf(value);
    }

    public float getValuePrimitive() {
        return value;
    }

    public static Float parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        return Float.valueOf(parseAndCheckValuePrimitive(value, file));
    }

    public static float parseAndCheckValuePrimitive(String value, XmlFile file)
        throws ParseException
    {
        String tmp = GlAlphaValueType.applyLexicalFacets(value, file);
        float ret = GlAlphaValueType.parseValuePrimitive(tmp);
        GlAlphaValueType.checkValueBasedFacetsPrimitive(ret);
        return ret;
    }

    public static Float parseValue(String value) {
        Float ret = Float.valueOf(parseValuePrimitive(value));
        return ret;
    }

    public static float parseValuePrimitive(String value) {
        float ret = ((float) XmlFloat.parseValuePrimitive(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlFloat.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(Float value) {
        checkValueBasedFacetsPrimitive(value.floatValue());
    }

    public static void checkValueBasedFacetsPrimitive(float value) {
        XmlFloat.checkValueBasedFacets(value);
        final Float minInclusive = GlAlphaValueType.parseValue("0.0");
        if (minInclusive.compareTo(Float.valueOf(value))> 0) {
            throw new XmlValidationException(("Value too low. Must be >= 0.0, but was "+ value));
        }
        final Float maxInclusive = GlAlphaValueType.parseValue("1.0");
        if (maxInclusive.compareTo(Float.valueOf(value))< 0) {
            throw new XmlValidationException(("Value too low. Must be <= 1.0, but was "+ value));
        }
    }

}
