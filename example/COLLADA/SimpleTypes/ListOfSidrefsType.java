
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class ListOfSidrefsType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final ArrayBigList<String> value;

    public ListOfSidrefsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfSidrefsType.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<String> getValue() {
        return value;
    }

    public static ArrayBigList<String> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfSidrefsType.applyLexicalFacets(value, file);
        ArrayBigList<String> ret = ListOfSidrefsType.parseValue(tmp, file);
        ListOfSidrefsType.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<String> parseValue(String value, XmlFile file)
        throws ParseException
    {
        final Pattern splitPattern = (Pattern.compile("([^ ]*)[ ]+"));
        ArrayBigList<String> ret = new ArrayBigList<String>();
        Matcher matcher = splitPattern.matcher(value);
        while (matcher.find()) {
            ret.add(SidrefType.parseAndCheckValue(matcher.group(1), file));
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

    public static void checkValueBasedFacets(ArrayBigList<String> value) {
    }

}
