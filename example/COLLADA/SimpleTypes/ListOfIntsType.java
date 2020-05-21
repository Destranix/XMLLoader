
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class ListOfIntsType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final ArrayBigList<Long> value;

    public ListOfIntsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfIntsType.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<Long> getValue() {
        return value;
    }

    public static ArrayBigList<Long> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfIntsType.applyLexicalFacets(value, file);
        ArrayBigList<Long> ret = ListOfIntsType.parseValue(tmp, file);
        ListOfIntsType.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<Long> parseValue(String value, XmlFile file)
        throws ParseException
    {
        final Pattern splitPattern = (Pattern.compile("([^ ]*)[ ]+"));
        ArrayBigList<Long> ret = new ArrayBigList<Long>();
        Matcher matcher = splitPattern.matcher(value);
        while (matcher.find()) {
            ret.add(IntType.parseAndCheckValue(matcher.group(1), file));
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

    public static void checkValueBasedFacets(ArrayBigList<Long> value) {
    }

}
