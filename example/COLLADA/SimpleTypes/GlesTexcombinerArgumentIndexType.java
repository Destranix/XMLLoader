
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlNonNegativeInteger;

public class GlesTexcombinerArgumentIndexType
    extends XmlSimpleType
{

    protected final BigInteger value;

    public GlesTexcombinerArgumentIndexType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = GlesTexcombinerArgumentIndexType.parseAndCheckValue(value, this.file);
    }

    @Override
    public BigInteger getValue() {
        return value;
    }

    public static BigInteger parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = GlesTexcombinerArgumentIndexType.applyLexicalFacets(value, file);
        BigInteger ret = GlesTexcombinerArgumentIndexType.parseValue(tmp);
        GlesTexcombinerArgumentIndexType.checkValueBasedFacets(ret);
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
        final BigInteger minInclusive = GlesTexcombinerArgumentIndexType.parseValue("0");
        if ((minInclusive.compareTo(value) > 0)) {
            throw new XmlValidationException(("Value too low. Must be >= 0, but was "+ value));
        }
        final BigInteger maxInclusive = GlesTexcombinerArgumentIndexType.parseValue("2");
        if ((maxInclusive.compareTo(value) < 0)) {
            throw new XmlValidationException(("Value too low. Must be <= 2, but was "+ value));
        }
    }

}
