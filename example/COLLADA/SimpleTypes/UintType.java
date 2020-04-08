
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import XmlSimpleTypes.XmlUnsignedLong;

public class UintType
    extends XmlSimpleType
{

    protected final BigInteger value;

    public UintType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = UintType.parseAndCheckValue(value, this.file);
    }

    @Override
    public BigInteger getValue() {
        return value;
    }

    public static BigInteger parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = UintType.applyLexicalFacets(value, file);
        BigInteger ret = UintType.parseValue(tmp);
        UintType.checkValueBasedFacets(ret);
        return ret;
    }

    public static BigInteger parseValue(String value) {
        BigInteger ret = ((BigInteger) XmlUnsignedLong.parseValue(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlUnsignedLong.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(BigInteger value) {
        XmlUnsignedLong.checkValueBasedFacets(value);
    }

}
