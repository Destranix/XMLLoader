
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Int2x2Type
    extends XmlSimpleType
{

    protected final long[] value;

    public Int2x2Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Int2x2Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public long[] getValue() {
        return value;
    }

    public static long[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Int2x2Type.applyLexicalFacets(value, file);
        long[] ret = Int2x2Type.parseValue(tmp, file);
        Int2x2Type.checkValueBasedFacets(ret);
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
        if ((value.length < 4)) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 4, but was "+(value.length)));
        }
        if ((value.length > 4)) {
            throw new XmlValidationException(("Value too long. Length must be <= 4, but was "+(value.length)));
        }
    }

}
