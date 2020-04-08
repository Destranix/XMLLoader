
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class Float2x3Type
    extends XmlSimpleType
{

    protected final double[] value;

    public Float2x3Type(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = Float2x3Type.parseAndCheckValue(value, this.file);
    }

    @Override
    public double[] getValue() {
        return value;
    }

    public static double[] parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Float2x3Type.applyLexicalFacets(value, file);
        double[] ret = Float2x3Type.parseValue(tmp, file);
        Float2x3Type.checkValueBasedFacets(ret);
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
        if ((value.length < 6)) {
            throw new XmlValidationException(("Value not long enough. Length must be >= 6, but was "+(value.length)));
        }
        if ((value.length > 6)) {
            throw new XmlValidationException(("Value too long. Length must be <= 6, but was "+(value.length)));
        }
    }

}
