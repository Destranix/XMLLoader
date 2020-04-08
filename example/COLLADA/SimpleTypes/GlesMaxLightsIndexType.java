
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlNonNegativeInteger;

public class GlesMaxLightsIndexType
    extends XmlSimpleType
{

    protected final BigInteger value;

    public GlesMaxLightsIndexType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = GlesMaxLightsIndexType.parseAndCheckValue(value, this.file);
    }

    @Override
    public BigInteger getValue() {
        return value;
    }

    public static BigInteger parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = GlesMaxLightsIndexType.applyLexicalFacets(value, file);
        BigInteger ret = GlesMaxLightsIndexType.parseValue(tmp);
        GlesMaxLightsIndexType.checkValueBasedFacets(ret);
        return ret;
    }

    public static BigInteger parseValue(String value) {
        BigInteger ret = ((BigInteger) XmlNonNegativeInteger.parseValue(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlNonNegativeInteger.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(BigInteger value) {
        XmlNonNegativeInteger.checkValueBasedFacets(value);
        final BigInteger minInclusive = GlesMaxLightsIndexType.parseValue("0");
        if ((minInclusive.compareTo(value) > 0)) {
            throw new XmlValidationException(("Value too low. Must be >= 0, but was "+ value));
        }
        final BigInteger maxExclusive = GlesMaxLightsIndexType.parseValue("7");
        if ((maxExclusive.compareTo(value) <= 0)) {
            throw new XmlValidationException(("Value too low. Must be < 7, but was "+ value));
        }
    }

}
