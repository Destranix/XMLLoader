
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlString;

public class GlBlendEnum
    extends XmlSimpleType
{

    protected final String value;
    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("ONE_MINUS_SRC_COLOR|ZERO|SRC_ALPHA|ONE|DST_ALPHA|SRC_COLOR|ONE_MINUS_DEST_COLOR|SRC_ALPHA_SATURATE|ONE_MINUS_DST_ALPHA|DEST_COLOR|CONSTANT_ALPHA|ONE_MINUS_SRC_ALPHA|CONSTANT_COLOR|ONE_MINUS_CONSTANT_ALPHA|ONE_MINUS_CONSTANT_COLOR"));

    public GlBlendEnum(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = GlBlendEnum.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = GlBlendEnum.applyLexicalFacets(value, file);
        String ret = GlBlendEnum.parseValue(tmp);
        GlBlendEnum.checkValueBasedFacets(ret);
        return ret;
    }

    public static String parseValue(String value) {
        String ret = ((String) XmlString.parseValue(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlString.applyLexicalFacets(value, file);
        if ((!RESTRICTION_PATTERN.matcher(tmp).matches())) {
            throw new XmlValidationException(("Value does not match restriction: "+ value));
        }
        return tmp;
    }

    public static void checkValueBasedFacets(String value) {
        XmlString.checkValueBasedFacets(value);
    }

}
