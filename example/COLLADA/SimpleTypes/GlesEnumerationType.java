
package SimpleTypes;

import java.text.ParseException;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;
import XmlSimpleTypes.XmlString;

public class GlesEnumerationType
    extends XmlSimpleType
{

    protected final String value;

    public GlesEnumerationType(XmlSimpleType attr, String value)
        throws ParseException
    {
        super(attr);
        this.value = GlesEnumerationType.parseAndCheckValue(value, this.file);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static String parseAndCheckValue(String value, XmlFile file)
        throws ParseException
    {
        String tmp = (null);
        boolean couldParse = false;
        if ((!couldParse)) {
            try {
                tmp = GlShadeModelEnum.applyLexicalFacets(value, file);
                GlShadeModelEnum.checkValueBasedFacets(GlShadeModelEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlFuncEnum.applyLexicalFacets(value, file);
                GlFuncEnum.checkValueBasedFacets(GlFuncEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlStencilOpEnum.applyLexicalFacets(value, file);
                GlStencilOpEnum.checkValueBasedFacets(GlStencilOpEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlFaceEnum.applyLexicalFacets(value, file);
                GlFaceEnum.checkValueBasedFacets(GlFaceEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlPolygonModeEnum.applyLexicalFacets(value, file);
                GlPolygonModeEnum.checkValueBasedFacets(GlPolygonModeEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlLogicOpEnum.applyLexicalFacets(value, file);
                GlLogicOpEnum.checkValueBasedFacets(GlLogicOpEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlBlendEnum.applyLexicalFacets(value, file);
                GlBlendEnum.checkValueBasedFacets(GlBlendEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlLightModelColorControlEnum.applyLexicalFacets(value, file);
                GlLightModelColorControlEnum.checkValueBasedFacets(GlLightModelColorControlEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlMaterialEnum.applyLexicalFacets(value, file);
                GlMaterialEnum.checkValueBasedFacets(GlMaterialEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlFogEnum.applyLexicalFacets(value, file);
                GlFogEnum.checkValueBasedFacets(GlFogEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            try {
                tmp = GlFrontFaceEnum.applyLexicalFacets(value, file);
                GlFrontFaceEnum.checkValueBasedFacets(GlFrontFaceEnum.parseValue(tmp));
            } catch (XmlValidationException _x) {
            }
        }
        if ((!couldParse)) {
            throw new XmlValidationException(("Value could not be parsed: "+ value));
        }
        String ret = GlesEnumerationType.parseValue(tmp);
        return ret;
    }

    public static String parseValue(String value) {
        String ret;
        ret = XmlString.parseValue(value);
        return ret;
    }

    public static String applyLexicalFacets(String value, XmlFile file)
        throws ParseException
    {
        return value;
    }

    public static void checkValueBasedFacets(String value) {
    }

}
