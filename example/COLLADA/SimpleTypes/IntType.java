
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import XmlSimpleTypes.XmlLong;

public class IntType
    extends XmlSimpleType
{

    protected final long value;

    public IntType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = IntType.parseAndCheckValuePrimitive(value, this.file);
    }

    @Override
    public Long getValue() {
        return Long.valueOf(value);
    }

    public long getValuePrimitive() {
        return value;
    }

    public static Long parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        return Long.valueOf(parseAndCheckValuePrimitive(value, file));
    }

    public static long parseAndCheckValuePrimitive(String value, XmlFile file)
        throws ParseException
    {
        String tmp = IntType.applyLexicalFacets(value, file);
        long ret = IntType.parseValuePrimitive(tmp);
        IntType.checkValueBasedFacetsPrimitive(ret);
        return ret;
    }

    public static Long parseValue(String value) {
        Long ret = Long.valueOf(parseValuePrimitive(value));
        return ret;
    }

    public static long parseValuePrimitive(String value) {
        long ret = ((long) XmlLong.parseValuePrimitive(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlLong.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(Long value) {
        checkValueBasedFacetsPrimitive(value.longValue());
    }

    public static void checkValueBasedFacetsPrimitive(long value) {
        XmlLong.checkValueBasedFacets(value);
    }

}
