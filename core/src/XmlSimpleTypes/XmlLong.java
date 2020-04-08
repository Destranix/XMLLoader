package XmlSimpleTypes;

import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlLong extends XmlSimpleType{
	
	protected final long value;
	
	public XmlLong(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValuePrimitive(value, this.file);
	}
	
	@Override
	public Long getValue() {
		return Long.valueOf(value);
	}
	
	public long getValuePrimitive() throws ParseException{
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
		//Nothing
	}
	
	public static void checkValueBasedFacetsPrimitive(long value){
		//Nothing
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
