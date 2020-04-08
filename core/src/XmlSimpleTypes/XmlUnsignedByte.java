package XmlSimpleTypes;


import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlUnsignedByte extends XmlSimpleType{
	
	protected final short value;
	
	public XmlUnsignedByte(XmlSimpleType attr, String value) throws ParseException{
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
		checkValueBasedFacetsPrimitive(value.shortValue());
	}
	
	public static void checkValueBasedFacetsPrimitive(short value){
		if(value < 0){
			throw new XmlValidationException("Value must be non-negative: "+value);
		}
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
