
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlShort;

public class MagnitudeType
    extends XmlSimpleType
{

    protected final short value;

    public MagnitudeType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = MagnitudeType.parseAndCheckValuePrimitive(value, this.file);
    }

    @Override
    public Short getValue() {
        return Short.valueOf(value);
    }

    public short getValuePrimitive() {
        return value;
    }

    public static Short parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        return Short.valueOf(parseAndCheckValuePrimitive(value, file));
    }

    public static short parseAndCheckValuePrimitive(String value, XmlFile file)
        throws ParseException
    {
        String tmp = MagnitudeType.applyLexicalFacets(value, file);
        short ret = MagnitudeType.parseValuePrimitive(tmp);
        MagnitudeType.checkValueBasedFacetsPrimitive(ret);
        return ret;
    }

    public static Short parseValue(String value) {
        Short ret = Short.valueOf(parseValuePrimitive(value));
        return ret;
    }

    public static short parseValuePrimitive(String value) {
        short ret = ((short) XmlShort.parseValuePrimitive(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlShort.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(Short value) {
        checkValueBasedFacetsPrimitive(value.shortValue());
    }

    public static void checkValueBasedFacetsPrimitive(short value) {
        XmlShort.checkValueBasedFacets(value);
        final Short minInclusive = MagnitudeType.parseValue("-324");
        if (minInclusive.compareTo(Short.valueOf(value))> 0) {
            throw new XmlValidationException(("Value too low. Must be >= -324, but was "+ value));
        }
        final Short maxInclusive = MagnitudeType.parseValue("308");
        if (maxInclusive.compareTo(Short.valueOf(value))< 0) {
            throw new XmlValidationException(("Value too low. Must be <= 308, but was "+ value));
        }
    }

}
