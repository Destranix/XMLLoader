package XmlSimpleTypes;


import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlShort extends XmlSimpleType{
	
	protected final short value;
	
	public XmlShort(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValuePrimitive(value, this.file);
	}
	
	@Override
	public Short getValue() {
		return Short.valueOf(value);
	}
	
	public short getValuePrimitive() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static Short parseValue(String value){
		return Short.valueOf(parseValuePrimitive(value));
	}
	
	public static short parseValuePrimitive(String value){
		return Short.parseShort(value);
	}
	
	public static void checkValueBasedFacets(Short value){
		//Nothing
	}
	
	public static void checkValueBasedFacetsPrimitive(short value){
		//Nothing
	}
	
	public static Short parseAndCheckValue(String value, XmlFile file) throws ParseException{
		return Short.valueOf(parseAndCheckValuePrimitive(value, file));
	}
	
	public static short parseAndCheckValuePrimitive(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		short ret = parseValuePrimitive(tmp);
		checkValueBasedFacetsPrimitive(ret);
		return ret;
	}

}
