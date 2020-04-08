
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class ListOfFloatsType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final double[] value;

    public ListOfFloatsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfFloatsType.parseAndCheckValue(value, this.file);
    }

    @Override
    public double[] getValue() {
        return value;
    }

    public static double[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfFloatsType.applyLexicalFacets(value, file);
        double[] ret = ListOfFloatsType.parseValue(tmp, file);
        ListOfFloatsType.checkValueBasedFacets(ret);
        return ret;
    }

    public static double[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        String[] tmpSplit = (value.split("[ ]+"));
        double[] ret = new double[tmpSplit.length] ;
        for (int i = 0; (i < ret.length); i ++) {
            ret[i] = FloatType.parseAndCheckValuePrimitive(tmpSplit[i], file);
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

    public static void checkValueBasedFacets(double[] value) {
    }

}
