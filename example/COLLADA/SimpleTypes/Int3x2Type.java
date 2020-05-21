
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Int3x2Type
    extends XmlSimpleType
{

    protected final ArrayBigList<Long> value;

    public Int3x2Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Int3x2Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<Long> getValue() {
        return value;
    }

    public static ArrayBigList<Long> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Int3x2Type.applyLexicalFacets(value, file);
        ArrayBigList<Long> ret = Int3x2Type.parseValue(tmp, file);
        Int3x2Type.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<Long> parseValue(String value, XmlFile file)
        throws ParseException
    {
        ArrayBigList<Long> ret = ((ArrayBigList<Long> ) ListOfIntsType.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfIntsType.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(ArrayBigList<Long> value) {
        ListOfIntsType.checkValueBasedFacets(value);
        if (value.size().compareTo(new BigInteger("6"))< 0) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 6, but was "+(value.size())));
        }
        if (value.size().compareTo(new BigInteger("6"))> 0) {
            throw new XmlValidationException(("Value too long. Length must be <= 6, but was "+(value.size())));
        }
    }

}
