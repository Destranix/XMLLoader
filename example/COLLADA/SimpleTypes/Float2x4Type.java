
package SimpleTypes;

import java.math.BigInteger;
import java.text.ParseException;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Float2x4Type
    extends XmlSimpleType
{

    protected final ArrayBigList<Double> value;

    public Float2x4Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Float2x4Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<Double> getValue() {
        return value;
    }

    public static ArrayBigList<Double> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Float2x4Type.applyLexicalFacets(value, file);
        ArrayBigList<Double> ret = Float2x4Type.parseValue(tmp, file);
        Float2x4Type.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<Double> parseValue(String value, XmlFile file)
        throws ParseException
    {
        ArrayBigList<Double> ret = ((ArrayBigList<Double> ) ListOfFloatsType.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfFloatsType.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(ArrayBigList<Double> value) {
        ListOfFloatsType.checkValueBasedFacets(value);
        if (value.size().compareTo(new BigInteger("8"))< 0) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 8, but was "+(value.size())));
        }
        if (value.size().compareTo(new BigInteger("8"))> 0) {
            throw new XmlValidationException(("Value too long. Length must be <= 8, but was "+(value.size())));
        }
    }

}
