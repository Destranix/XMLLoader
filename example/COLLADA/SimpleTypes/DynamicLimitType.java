
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;

public class DynamicLimitType
    extends XmlSimpleType
{

    protected final double[] value;

    public DynamicLimitType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = DynamicLimitType.parseAndCheckValue(value, this.file);
    }

    @Override
    public double[] getValue() {
        return value;
    }

    public static double[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = DynamicLimitType.applyLexicalFacets(value, file);
        double[] ret = DynamicLimitType.parseValue(tmp, file);
        DynamicLimitType.checkValueBasedFacets(ret);
        return ret;
    }

    public static double[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        double[] ret = ((double[]) Float2Type.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Float2Type.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(double[] value) {
        Float2Type.checkValueBasedFacets(value);
    }

}
