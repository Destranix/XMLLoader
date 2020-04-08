package XmlSimpleTypes;

import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlBoolean extends XmlSimpleType{
	
	protected final boolean value;
	
	public XmlBoolean(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValuePrimitive(value, this.file);
	}
	
	@Override
	public Boolean getValue() {
		return Boolean.valueOf(value);
	}
	
	public boolean getValuePrimitive() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static Boolean parseValue(String value){
		return Boolean.valueOf(parseValuePrimitive(value));
	}
	
	public static boolean parseValuePrimitive(String value){
		return Boolean.parseBoolean(value);
	}
	
	public static void checkValueBasedFacets(Boolean value){
		//Nothing
	}
	
	public static void checkValueBasedFacetsPrimitive(boolean value){
		//Nothing
	}
	
	public static Boolean parseAndCheckValue(String value, XmlFile file) throws ParseException{
		return Boolean.valueOf(parseAndCheckValuePrimitive(value, file));
	}
	
	public static boolean parseAndCheckValuePrimitive(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		boolean ret = parseValuePrimitive(tmp);
		checkValueBasedFacetsPrimitive(ret);
		return ret;
	}

}
