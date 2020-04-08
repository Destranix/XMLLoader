
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Float3x4Type
    extends XmlSimpleType
{

    protected final double[] value;

    public Float3x4Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Float3x4Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public double[] getValue() {
        return value;
    }

    public static double[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Float3x4Type.applyLexicalFacets(value, file);
        double[] ret = Float3x4Type.parseValue(tmp, file);
        Float3x4Type.checkValueBasedFacets(ret);
        return ret;
    }

    public static double[] parseValue(String value, XmlFile file)
        throws ParseException
    {
        double[] ret = ((double[]) ListOfFloatsType.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = ListOfFloatsType.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(double[] value) {
        ListOfFloatsType.checkValueBasedFacets(value);
        if ((value.length < 12)) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 12, but was "+(value.length)));
        }
        if ((value.length > 12)) {
            throw new XmlValidationException(("Value too long. Length must be <= 12, but was "+(value.length)));
        }
    }

}
