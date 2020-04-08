package XmlSimpleTypes;


import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlUnsignedShort extends XmlSimpleType{
	
	protected final int value;
	
	public XmlUnsignedShort(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValuePrimitive(value, this.file);
	}
	
	@Override
	public Integer getValue() {
		return Integer.valueOf(value);
	}
	
	public int getValuePrimitive() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static Integer parseValue(String value){
		return Integer.valueOf(parseValuePrimitive(value));
	}
	
	public static int parseValuePrimitive(String value){
		return Integer.parseInt(value);
	}
	
	public static void checkValueBasedFacets(Integer value){
		checkValueBasedFacetsPrimitive(value.intValue());
	}
	
	public static void checkValueBasedFacetsPrimitive(int value){
		if(value < 0){
			throw new XmlValidationException("Value must be non-negative: "+value);
		}
	}
	
	public static Integer parseAndCheckValue(String value, XmlFile file) throws ParseException{
		return Integer.valueOf(parseAndCheckValuePrimitive(value, file));
	}
	
	public static int parseAndCheckValuePrimitive(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		int ret = parseValuePrimitive(tmp);
		checkValueBasedFacetsPrimitive(ret);
		return ret;
	}

}
