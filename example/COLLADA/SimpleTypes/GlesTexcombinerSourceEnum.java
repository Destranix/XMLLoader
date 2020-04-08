
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlToken;

public class GlesTexcombinerSourceEnum
    extends XmlSimpleType
{

    protected final String value;
    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("TEXTURE|CONSTANT|PRIMARY|PREVIOUS"));

    public GlesTexcombinerSourceEnum(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = GlesTexcombinerSourceEnum.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = GlesTexcombinerSourceEnum.applyLexicalFacets(value, file);
        String ret = GlesTexcombinerSourceEnum.parseValue(tmp);
        GlesTexcombinerSourceEnum.checkValueBasedFacets(ret);
        return ret;
    }

    public static String parseValue(String value) {
        String ret = ((String) XmlToken.parseValue(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlToken.applyLexicalFacets(value, file);
        if ((!RESTRICTION_PATTERN.matcher(tmp).matches())) {
            throw new XmlValidationException(("Value does not match restriction: "+ value));
        }
        return tmp;
    }

    public static void checkValueBasedFacets(String value) {
        XmlToken.checkValueBasedFacets(value);
    }

}
