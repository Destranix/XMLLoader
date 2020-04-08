
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class ListOfUintsType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final BigInteger[] value;

    public ListOfUintsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfUintsType.parseAndCheckValue(value, this.file);
    }

    @Override
    public BigInteger[] getValue() {
        return value;
    }

    public static BigInteger[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfUintsType.applyLexicalFacets(value, file);
        BigInteger[] ret = ListOfUintsType.parseValue(tmp, file);
        ListOfUintsType.checkValueBasedFacets(ret);
        return ret;
    }

    public static BigInteger[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        String[] tmpSplit = (value.split("[ ]+"));
        BigInteger[] ret = new BigInteger[tmpSplit.length] ;
        for (int i = 0; (i < ret.length); i ++) {
            ret[i] = UintType.parseAndCheckValue(tmpSplit[i], file);
        }
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = (normalize(value, true, file).trim().replaceAll("[ ]+", " "));
        if ((!RESTRICTION_PATTERN.matcher(tmp).matches())) {
            throw new XmlValidationException(("Value does not match restriction: "+ value));
        }
        return tmp;
    }

    public static void checkValueBasedFacets(BigInteger[] value) {
    }

}
