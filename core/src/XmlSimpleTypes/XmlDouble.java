package XmlSimpleTypes;

import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlDouble extends XmlSimpleType{
	
	protected final double value;
	
	public XmlDouble(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValuePrimitive(value, this.file);
	}
	
	@Override
	public Double getValue() {
		return Double.valueOf(value);
	}
	
	public double getValuePrimitive() throws ParseException{
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static Double parseValue(String value){
		return Double.valueOf(parseValuePrimitive(value));
	}
	
	public static double parseValuePrimitive(String value){
		return Double.parseDouble(value);
	}
	
	public static void checkValueBasedFacets(Double value){
		//Nothing
	}
	
	public static void checkValueBasedFacetsPrimitive(double value){
		//Nothing
	}
	
	public static Double parseAndCheckValue(String value, XmlFile file) throws ParseException{
		return Double.valueOf(parseAndCheckValuePrimitive(value, file));
	}
	
	public static double parseAndCheckValuePrimitive(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		double ret = parseValuePrimitive(tmp);
		checkValueBasedFacetsPrimitive(ret);
		return ret;
	}
}
