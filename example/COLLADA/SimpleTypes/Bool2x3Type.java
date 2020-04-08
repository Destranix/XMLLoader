
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Bool2x3Type
    extends XmlSimpleType
{

    protected final boolean[] value;

    public Bool2x3Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Bool2x3Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public boolean[] getValue() {
        return value;
    }

    public static boolean[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Bool2x3Type.applyLexicalFacets(value, file);
        boolean[] ret = Bool2x3Type.parseValue(tmp, file);
        Bool2x3Type.checkValueBasedFacets(ret);
        return ret;
    }

    public static boolean[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        boolean[] ret = ((boolean[]) ListOfBoolsType.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfBoolsType.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(boolean[] value) {
        ListOfBoolsType.checkValueBasedFacets(value);
        if ((value.length < 6)) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 6, but was "+(value.length)));
        }
        if ((value.length > 6)) {
            throw new XmlValidationException(("Value too long. Length must be <= 6, but was "+(value.length)));
        }
    }

}