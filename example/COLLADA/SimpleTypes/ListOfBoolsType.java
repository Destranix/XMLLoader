
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlBoolean;

public class ListOfBoolsType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final boolean[] value;

    public ListOfBoolsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfBoolsType.parseAndCheckValue(value, this.file);
    }

    @Override
    public boolean[] getValue() {
        return value;
    }

    public static boolean[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfBoolsType.applyLexicalFacets(value, file);
        boolean[] ret = ListOfBoolsType.parseValue(tmp, file);
        ListOfBoolsType.checkValueBasedFacets(ret);
        return ret;
    }

    public static boolean[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        String[] tmpSplit = (value.split("[ ]+"));
        boolean[] ret = new boolean[tmpSplit.length] ;
        for (int i = 0; (i < ret.length); i ++) {
            ret[i] = XmlBoolean.parseAndCheckValuePrimitive(tmpSplit[i], file);
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

    public static void checkValueBasedFacets(boolean[] value) {
    }

}
