
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;

public class FxColorType
    extends XmlSimpleType
{

    protected final double[] value;

    public FxColorType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = FxColorType.parseAndCheckValue(value, this.file);
    }

    @Override
    public double[] getValue() {
        return value;
    }

    public static double[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = FxColorType.applyLexicalFacets(value, file);
        double[] ret = FxColorType.parseValue(tmp, file);
        FxColorType.checkValueBasedFacets(ret);
        return ret;
    }

    public static double[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        double[] ret = ((double[]) Float4Type.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Float4Type.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(double[] value) {
        Float4Type.checkValueBasedFacets(value);
    }

}
