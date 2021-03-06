
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlNMTOKEN;

public class CommonProfileParamEnum
    extends XmlSimpleType
{

    protected final String value;
    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("A|B|G|TIME|ANGLE|P|Q|R|S|T|U|V|W|X|Y|Z|DOUBLE_SIDED"));

    public CommonProfileParamEnum(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = CommonProfileParamEnum.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = CommonProfileParamEnum.applyLexicalFacets(value, file);
        String ret = CommonProfileParamEnum.parseValue(tmp);
        CommonProfileParamEnum.checkValueBasedFacets(ret);
        return ret;
    }

    public static String parseValue(String value) {
        String ret = ((String) XmlNMTOKEN.parseValue(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlNMTOKEN.applyLexicalFacets(value, file);
        if ((!RESTRICTION_PATTERN.matcher(tmp).matches())) {
            throw new XmlValidationException(("Value does not match restriction: "+ value));
        }
        return tmp;
    }

    public static void checkValueBasedFacets(String value) {
        XmlNMTOKEN.checkValueBasedFacets(value);
    }

}
