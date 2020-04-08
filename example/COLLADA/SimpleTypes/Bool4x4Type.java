
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Bool4x4Type
    extends XmlSimpleType
{

    protected final boolean[] value;

    public Bool4x4Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Bool4x4Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public boolean[] getValue() {
        return value;
    }

    public static boolean[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Bool4x4Type.applyLexicalFacets(value, file);
        boolean[] ret = Bool4x4Type.parseValue(tmp, file);
        Bool4x4Type.checkValueBasedFacets(ret);
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
        if ((value.length < 16)) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 16, but was "+(value.length)));
        }
        if ((value.length > 16)) {
            throw new XmlValidationException(("Value too long. Length must be <= 16, but was "+(value.length)));
        }
    }

}
