
package SimpleTypes;

import java.text.ParseException;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;

public class DynamicLimitType
    extends XmlSimpleType
{

    protected final ArrayBigList<Double> value;

    public DynamicLimitType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = DynamicLimitType.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<Double> getValue() {
        return value;
    }

    public static ArrayBigList<Double> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = DynamicLimitType.applyLexicalFacets(value, file);
        ArrayBigList<Double> ret = DynamicLimitType.parseValue(tmp, file);
        DynamicLimitType.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<Double> parseValue(String value, XmlFile file)
        throws ParseException
    {
        ArrayBigList<Double> ret = ((ArrayBigList<Double> ) Float2Type.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Float2Type.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(ArrayBigList<Double> value) {
        Float2Type.checkValueBasedFacets(value);
    }

}
