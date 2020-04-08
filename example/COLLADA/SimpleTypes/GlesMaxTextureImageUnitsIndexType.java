
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlNonNegativeInteger;

public class GlesMaxTextureImageUnitsIndexType
    extends XmlSimpleType
{

    protected final BigInteger value;

    public GlesMaxTextureImageUnitsIndexType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = GlesMaxTextureImageUnitsIndexType.parseAndCheckValue(value, this.file);
    }

    @Override
    public BigInteger getValue() {
        return value;
    }

    public static BigInteger parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = GlesMaxTextureImageUnitsIndexType.applyLexicalFacets(value, file);
        BigInteger ret = GlesMaxTextureImageUnitsIndexType.parseValue(tmp);
        GlesMaxTextureImageUnitsIndexType.checkValueBasedFacets(ret);
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
        final BigInteger minInclusive = GlesMaxTextureImageUnitsIndexType.parseValue("0");
        if ((minInclusive.compareTo(value) > 0)) {
            throw new XmlValidationException(("Value too low. Must be >= 0, but was "+ value));
        }
        final BigInteger maxExclusive = GlesMaxTextureImageUnitsIndexType.parseValue("31");
        if ((maxExclusive.compareTo(value) <= 0)) {
            throw new XmlValidationException(("Value too low. Must be < 31, but was "+ value));
        }
    }

}
