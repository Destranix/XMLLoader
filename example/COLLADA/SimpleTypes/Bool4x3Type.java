
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Bool4x3Type
    extends XmlSimpleType
{

    protected final ArrayBigList<Boolean> value;

    public Bool4x3Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Bool4x3Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<Boolean> getValue() {
        return value;
    }

    public static ArrayBigList<Boolean> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Bool4x3Type.applyLexicalFacets(value, file);
        ArrayBigList<Boolean> ret = Bool4x3Type.parseValue(tmp, file);
        Bool4x3Type.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<Boolean> parseValue(String value, XmlFile file)
        throws ParseException
    {
        ArrayBigList<Boolean> ret = ((ArrayBigList<Boolean> ) ListOfBoolsType.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfBoolsType.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(ArrayBigList<Boolean> value) {
        ListOfBoolsType.checkValueBasedFacets(value);
        if (value.size().compareTo(new BigInteger("12"))< 0) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 12, but was "+(value.size())));
        }
        if (value.size().compareTo(new BigInteger("12"))> 0) {
            throw new XmlValidationException(("Value too long. Length must be <= 12, but was "+(value.size())));
        }
    }

}
