
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import XmlSimpleTypes.XmlDouble;

public class FloatType
    extends XmlSimpleType
{

    protected final double value;

    public FloatType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = FloatType.parseAndCheckValuePrimitive(value, this.file);
    }

    @Override
    public Double getValue() {
        return Double.valueOf(value);
    }

    public double getValuePrimitive() {
        return value;
    }

    public static Double parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        return Double.valueOf(parseAndCheckValuePrimitive(value, file));
    }

    public static double parseAndCheckValuePrimitive(String value, XmlFile file)
        throws ParseException
    {
        String tmp = FloatType.applyLexicalFacets(value, file);
        double ret = FloatType.parseValuePrimitive(tmp);
        FloatType.checkValueBasedFacetsPrimitive(ret);
        return ret;
    }

    public static Double parseValue(String value) {
        Double ret = Double.valueOf(parseValuePrimitive(value));
        return ret;
    }

    public static double parseValuePrimitive(String value) {
        double ret = ((double) XmlDouble.parseValuePrimitive(value));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = XmlDouble.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(Double value) {
        checkValueBasedFacetsPrimitive(value.doubleValue());
    }

    public static void checkValueBasedFacetsPrimitive(double value) {
        XmlDouble.checkValueBasedFacets(value);
    }

}
