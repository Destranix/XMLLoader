
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import XmlSimpleTypes.XmlString;

public class FxDrawType
    extends XmlSimpleType
{

    protected final String value;

    public FxDrawType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = FxDrawType.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = FxDrawType.applyLexicalFacets(value, file);
        String ret = FxDrawType.parseValue(tmp);
        FxDrawType.checkValueBasedFacets(ret);
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
        return tmp;
    }

    public static void checkValueBasedFacets(String value) {
        XmlString.checkValueBasedFacets(value);
    }

}
