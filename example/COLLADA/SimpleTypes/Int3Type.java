
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Int3Type
    extends XmlSimpleType
{

    protected final long[] value;

    public Int3Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Int3Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public long[] getValue() {
        return value;
    }

    public static long[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Int3Type.applyLexicalFacets(value, file);
        long[] ret = Int3Type.parseValue(tmp, file);
        Int3Type.checkValueBasedFacets(ret);
        return ret;
    }

    public static long[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        long[] ret = ((long[]) ListOfIntsType.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfIntsType.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(long[] value) {
        ListOfIntsType.checkValueBasedFacets(value);
        if ((value.length < 3)) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 3, but was "+(value.length)));
        }
        if ((value.length > 3)) {
            throw new XmlValidationException(("Value too long. Length must be <= 3, but was "+(value.length)));
        }
    }

}