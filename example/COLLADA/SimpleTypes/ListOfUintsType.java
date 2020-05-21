
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class ListOfUintsType
    extends XmlSimpleType
{

    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(.*(?:(?:[ ]+).*)*)"));
    protected final ArrayBigList<BigInteger> value;

    public ListOfUintsType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = ListOfUintsType.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<BigInteger> getValue() {
        return value;
    }

    public static ArrayBigList<BigInteger> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfUintsType.applyLexicalFacets(value, file);
        ArrayBigList<BigInteger> ret = ListOfUintsType.parseValue(tmp, file);
        ListOfUintsType.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<BigInteger> parseValue(String value, XmlFile file)
        throws ParseException
    {
        final Pattern splitPattern = (Pattern.compile("([^ ]*)[ ]+"));
        ArrayBigList<BigInteger> ret = new ArrayBigList<BigInteger>();
        Matcher matcher = splitPattern.matcher(value);
        while (matcher.find()) {
            ret.add(UintType.parseAndCheckValue(matcher.group(1), file));
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

    public static void checkValueBasedFacets(ArrayBigList<BigInteger> value) {
    }

}
