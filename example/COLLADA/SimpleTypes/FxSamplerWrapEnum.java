
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlNMTOKEN;

public class FxSamplerWrapEnum
    extends XmlSimpleType
{

    protected final String value;
    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("MIRROR_ONCE|WRAP|BORDER|CLAMP|MIRROR"));

    public FxSamplerWrapEnum(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = FxSamplerWrapEnum.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = FxSamplerWrapEnum.applyLexicalFacets(value, file);
        String ret = FxSamplerWrapEnum.parseValue(tmp);
        FxSamplerWrapEnum.checkValueBasedFacets(ret);
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
