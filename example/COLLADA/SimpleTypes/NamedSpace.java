
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlString;

public class NamedSpace
    extends XmlSimpleType
{

    protected final String value;
    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("thickmathspace|mediummathspace|veryverythinmathspace|verythickmathspace|thinmathspace|veryverythickmathspace|verythinmathspace"));

    public NamedSpace(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = NamedSpace.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = NamedSpace.applyLexicalFacets(value, file);
        String ret = NamedSpace.parseValue(tmp);
        NamedSpace.checkValueBasedFacets(ret);
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
