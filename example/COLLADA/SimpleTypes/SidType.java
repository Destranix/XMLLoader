
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import XmlSimpleTypes.XmlNCName;

public class SidType
    extends XmlSimpleType
{

    protected final String value;

    public SidType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = SidType.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = SidType.applyLexicalFacets(value, file);
        String ret = SidType.parseValue(tmp);
        SidType.checkValueBasedFacets(ret);
        return ret;
    }

    public static String parseValue(String value) {
        String ret = ((String) XmlNCName.parseValue(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlNCName.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(String value) {
        XmlNCName.checkValueBasedFacets(value);
    }

}
