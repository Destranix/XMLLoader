
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlUnsignedByte;

public class DigitsType
    extends XmlSimpleType
{

    protected final short value;

    public DigitsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = DigitsType.parseAndCheckValuePrimitive(value, this.file);
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
        String tmp = DigitsType.applyLexicalFacets(value, file);
        short ret = DigitsType.parseValuePrimitive(tmp);
        DigitsType.checkValueBasedFacetsPrimitive(ret);
        return ret;
    }

    public static Short parseValue(String value) {
        Short ret = Short.valueOf(parseValuePrimitive(value));
        return ret;
    }

    public static short parseValuePrimitive(String value) {
        short ret = ((short) XmlUnsignedByte.parseValuePrimitive(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlUnsignedByte.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(Short value) {
        checkValueBasedFacetsPrimitive(value.shortValue());
    }

    public static void checkValueBasedFacetsPrimitive(short value) {
        XmlUnsignedByte.checkValueBasedFacets(value);
        final Short minInclusive = DigitsType.parseValue("1");
        if (minInclusive.compareTo(Short.valueOf(value))> 0) {
            throw new XmlValidationException(("Value too low. Must be >= 1, but was "+ value));
        }
        final Short maxInclusive = DigitsType.parseValue("17");
        if (maxInclusive.compareTo(Short.valueOf(value))< 0) {
            throw new XmlValidationException(("Value too low. Must be <= 17, but was "+ value));
        }
    }

}
