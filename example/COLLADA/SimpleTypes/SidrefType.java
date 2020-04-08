
package SimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlString;

public class SidrefType
    extends XmlSimpleType
{

    protected final String value;
    private final static Pattern RESTRICTION_PATTERN = (Pattern.compile("(([(?:\\\\: | [A-Z] | _ | [a-z] | [\\u00C0-\\u00D6] | [\\u00D8-\\u00F6] | [\\u00F8-\\u02FF] | [\\u0370-\\u037D] | [\\u037F-\\u1FFF] | [\\u200C-\\u200D] | [\\u2070-\\u218F] | [\\u2C00-\\u2FEF] | [\\u3001-\\uD7FF] | [\\uF900-\\uFDCF] | [\\uFDF0-\\uFFFD] | [\\u10000-\\uEFFFF])-[:]][(?:\\\\: | [A-Z] | _ | [a-z] | [\\u00C0-\\u00D6] | [\\u00D8-\\u00F6] | [\\u00F8-\\u02FF] | [\\u0370-\\u037D] | [\\u037F-\\u1FFF] | [\\u200C-\\u200D] | [\\u2070-\\u218F] | [\\u2C00-\\u2FEF] | [\\u3001-\\uD7FF] | [\\uF900-\\uFDCF] | [\\uFDF0-\\uFFFD] | [\\u10000-\\uEFFFF] | \\\\Q-\\\\E | \\\\. | [0-9] |\\u00B7 | [\\u0300-\\u036F] | [\\u203F-\\u2040])-[:]]*)|[^\\u000A\\u000D])(/[(?:\\\\: | [A-Z] | _ | [a-z] | [\\u00C0-\\u00D6] | [\\u00D8-\\u00F6] | [\\u00F8-\\u02FF] | [\\u0370-\\u037D] | [\\u037F-\\u1FFF] | [\\u200C-\\u200D] | [\\u2070-\\u218F] | [\\u2C00-\\u2FEF] | [\\u3001-\\uD7FF] | [\\uF900-\\uFDCF] | [\\uFDF0-\\uFFFD] | [\\u10000-\\uEFFFF])-[:\\.]][(?:\\\\: | [A-Z] | _ | [a-z] | [\\u00C0-\\u00D6] | [\\u00D8-\\u00F6] | [\\u00F8-\\u02FF] | [\\u0370-\\u037D] | [\\u037F-\\u1FFF] | [\\u200C-\\u200D] | [\\u2070-\\u218F] | [\\u2C00-\\u2FEF] | [\\u3001-\\uD7FF] | [\\uF900-\\uFDCF] | [\\uFDF0-\\uFFFD] | [\\u10000-\\uEFFFF] | \\\\Q-\\\\E | \\\\. | [0-9] |\\u00B7 | [\\u0300-\\u036F] | [\\u203F-\\u2040])-[:]]*)+((\\.[(?:\\\\: | [A-Z] | _ | [a-z] | [\\u00C0-\\u00D6] | [\\u00D8-\\u00F6] | [\\u00F8-\\u02FF] | [\\u0370-\\u037D] | [\\u037F-\\u1FFF] | [\\u200C-\\u200D] | [\\u2070-\\u218F] | [\\u2C00-\\u2FEF] | [\\u3001-\\uD7FF] | [\\uF900-\\uFDCF] | [\\uFDF0-\\uFFFD] | [\\u10000-\\uEFFFF])-[:]][(?:\\\\: | [A-Z] | _ | [a-z] | [\\u00C0-\\u00D6] | [\\u00D8-\\u00F6] | [\\u00F8-\\u02FF] | [\\u0370-\\u037D] | [\\u037F-\\u1FFF] | [\\u200C-\\u200D] | [\\u2070-\\u218F] | [\\u2C00-\\u2FEF] | [\\u3001-\\uD7FF] | [\\uF900-\\uFDCF] | [\\uFDF0-\\uFFFD] | [\\u10000-\\uEFFFF] | \\\\Q-\\\\E | \\\\. | [0-9] |\\u00B7 | [\\u0300-\\u036F] | [\\u203F-\\u2040])-[:]]*)|(\\([0-9]+\\)){1,2})?"));

    public SidrefType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = SidrefType.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = SidrefType.applyLexicalFacets(value, file);
        String ret = SidrefType.parseValue(tmp);
        SidrefType.checkValueBasedFacets(ret);
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
