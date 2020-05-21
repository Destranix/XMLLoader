
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class ListOfFloatsType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final ArrayBigList<Double> value;

    public ListOfFloatsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfFloatsType.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<Double> getValue() {
        return value;
    }

    public static ArrayBigList<Double> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfFloatsType.applyLexicalFacets(value, file);
        ArrayBigList<Double> ret = ListOfFloatsType.parseValue(tmp, file);
        ListOfFloatsType.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<Double> parseValue(String value, XmlFile file)
        throws ParseException
    {
        final Pattern splitPattern = (Pattern.compile("([^ ]*)[ ]+"));
        ArrayBigList<Double> ret = new ArrayBigList<Double>();
        Matcher matcher = splitPattern.matcher(value);
        while (matcher.find()) {
            ret.add(FloatType.parseAndCheckValue(matcher.group(1), file));
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

    public static void checkValueBasedFacets(ArrayBigList<Double> value) {
    }

}
