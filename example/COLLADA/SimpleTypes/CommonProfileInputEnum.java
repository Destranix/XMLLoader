
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlNMTOKEN;

public class CommonProfileInputEnum
    extends XmlSimpleType
{

    protected final String value;
    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("BINORMAL|UV|INV_BIND_MATRIX|INPUT|OUTPUT|TANGENT|OUT_TANGENT|MORPH_TARGET|LINEAR_STEPS|TEXTANGENT|INTERPOLATION|POSITION|CONTINUITY|IMAGE|IN_TANGENT|COLOR|VERTEX|WEIGHT|MORPH_WEIGHT|JOINT|TEXCOORD|NORMAL|TEXBINORMAL"));

    public CommonProfileInputEnum(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = CommonProfileInputEnum.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = CommonProfileInputEnum.applyLexicalFacets(value, file);
        String ret = CommonProfileInputEnum.parseValue(tmp);
        CommonProfileInputEnum.checkValueBasedFacets(ret);
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
