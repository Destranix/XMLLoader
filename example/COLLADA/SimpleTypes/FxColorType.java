
package SimpleTypes;

import java.text.ParseException;
import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;

public class FxColorType
    extends XmlSimpleType
{

    protected final ArrayBigList<Double> value;

    public FxColorType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = FxColorType.parseAndCheckValue(value, this.file);
    }

    @Override
    public ArrayBigList<Double> getValue() {
        return value;
    }

    public static ArrayBigList<Double> parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = FxColorType.applyLexicalFacets(value, file);
        ArrayBigList<Double> ret = FxColorType.parseValue(tmp, file);
        FxColorType.checkValueBasedFacets(ret);
        return ret;
    }

    public static ArrayBigList<Double> parseValue(String value, XmlFile file)
        throws ParseException
    {
        ArrayBigList<Double> ret = ((ArrayBigList<Double> ) Float4Type.parseValue(value, file));
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        String tmp = Float4Type.applyLexicalFacets(value, file);
        return tmp;
    }

    public static void checkValueBasedFacets(ArrayBigList<Double> value) {
        Float4Type.checkValueBasedFacets(value);
    }

}
