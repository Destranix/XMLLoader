
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class ListOfIntsType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final long[] value;

    public ListOfIntsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfIntsType.parseAndCheckValue(value, this.file);
    }

    @Override
    public long[] getValue() {
        return value;
    }

    public static long[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfIntsType.applyLexicalFacets(value, file);
        long[] ret = ListOfIntsType.parseValue(tmp, file);
        ListOfIntsType.checkValueBasedFacets(ret);
        return ret;
    }

    public static long[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        String[] tmpSplit = (value.split("[ ]+"));
        long[] ret = new long[tmpSplit.length] ;
        for (int i = 0; (i < ret.length); i ++) {
            ret[i] = IntType.parseAndCheckValuePrimitive(tmpSplit[i], file);
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

    public static void checkValueBasedFacets(long[] value) {
    }

}
