package XmlSimpleTypes;

import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlFloat extends XmlSimpleType{
	
	protected final float value;
	
	public XmlFloat(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValuePrimitive(value, this.file);
	}
	
	@Override
	public Float getValue() {
		return Float.valueOf(value);
	}
	
	public float getValuePrimitive() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static Float parseValue(String value){
		return Float.valueOf(parseValuePrimitive(value));
	}
	
	public static float parseValuePrimitive(String value){
		return Float.parseFloat(value);
	}
	
	public static void checkValueBasedFacets(Float value){
		//Nothing
	}
	
	public static void checkValueBasedFacetsPrimitive(float value){
		//Nothing
	}
	
	public static Float parseAndCheckValue(String value, XmlFile file) throws ParseException{
		return Float.valueOf(parseAndCheckValuePrimitive(value, file));
	}
	
	public static float parseAndCheckValuePrimitive(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		float ret = parseValuePrimitive(tmp);
		checkValueBasedFacetsPrimitive(ret);
		return ret;
	}

}
