
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Bool2x4Type
    extends XmlSimpleType
{

    protected final ArrayBigList<Boolean> value;

    public Bool2x4Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Bool2x4Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<Boolean> getValue() {
        return value;
    }

    public static ArrayBigList<Boolean> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Bool2x4Type.applyLexicalFacets(value, file);
        ArrayBigList<Boolean> ret = Bool2x4Type.parseValue(tmp, file);
        Bool2x4Type.checkValueBasedFacets(ret);
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
        if (value.size().compareTo(new BigInteger("8"))< 0) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 8, but was "+(value.size())));
        }
        if (value.size().compareTo(new BigInteger("8"))> 0) {
            throw new XmlValidationException(("Value too long. Length must be <= 8, but was "+(value.size())));
        }
    }

}
