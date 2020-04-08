
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class GlesTexcombinerOperandRgbEnum
    extends XmlSimpleType
{

    protected final String value;
    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("ONE_MINUS_SRC_COLOR|SRC_ALPHA|ONE_MINUS_SRC_ALPHA|SRC_COLOR"));

    public GlesTexcombinerOperandRgbEnum(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = GlesTexcombinerOperandRgbEnum.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = GlesTexcombinerOperandRgbEnum.applyLexicalFacets(value, file);
        String ret = GlesTexcombinerOperandRgbEnum.parseValue(tmp);
        GlesTexcombinerOperandRgbEnum.checkValueBasedFacets(ret);
        return ret;
    }

    public static String parseValue(String value) {
        String ret = ((String) GlBlendEnum.parseValue(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = GlBlendEnum.applyLexicalFacets(value, file);
        if ((!RESTRICTION_PATTERN.matcher(tmp).matches())) {
            throw new XmlValidationException(("Value does not match restriction: "+ value));
        }
        return tmp;
    }

    public static void checkValueBasedFacets(String value) {
        GlBlendEnum.checkValueBasedFacets(value);
    }

}
