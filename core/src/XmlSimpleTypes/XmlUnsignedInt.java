package XmlSimpleTypes;


import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlUnsignedInt extends XmlSimpleType{
	
	protected final long value;
	
	public XmlUnsignedInt(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValuePrimitive(value, this.file);
	}
	
	@Override
	public Long getValue() {
		return Long.valueOf(value);
	}
	
	public long getValuePrimitive() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static Long parseValue(String value){
		return Long.valueOf(parseValuePrimitive(value));
	}
	
	public static long parseValuePrimitive(String value){
		return Long.parseLong(value);
	}
	
	public static void checkValueBasedFacets(Long value){
		checkValueBasedFacetsPrimitive(value.longValue());
	}
	
	public static void checkValueBasedFacetsPrimitive(long value){
		if(value < 0){
			throw new XmlValidationException("Value must be non-negative: "+value);
		}
	}
	
	public static Long parseAndCheckValue(String value, XmlFile file) throws ParseException{
		return Long.valueOf(parseAndCheckValuePrimitive(value, file));
	}
	
	public static long parseAndCheckValuePrimitive(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		long ret = parseValuePrimitive(tmp);
		checkValueBasedFacetsPrimitive(ret);
		return ret;
	}
	
}
