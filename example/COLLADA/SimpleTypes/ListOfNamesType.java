
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlName;

public class ListOfNamesType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final String[] value;

    public ListOfNamesType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfNamesType.parseAndCheckValue(value, this.file);
    }

    @Override
    public String[] getValue() {
        return value;
    }

    public static String[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfNamesType.applyLexicalFacets(value, file);
        String[] ret = ListOfNamesType.parseValue(tmp, file);
        ListOfNamesType.checkValueBasedFacets(ret);
        return ret;
    }

    public static String[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        String[] tmpSplit = (value.split("[ ]+"));
        String[] ret = new String[tmpSplit.length] ;
        for (int i = 0; (i < ret.length); i ++) {
            ret[i] = XmlName.parseAndCheckValue(tmpSplit[i], file);
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

    public static void checkValueBasedFacets(String[] value) {
    }

}