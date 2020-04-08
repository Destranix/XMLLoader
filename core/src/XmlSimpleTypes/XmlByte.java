package XmlSimpleTypes;

import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlByte extends XmlSimpleType{
	
	protected final byte value;
	
	public XmlByte(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValuePrimitive(value, this.file);
	}
	
	@Override
	public Byte getValue() {
		return Byte.valueOf(value);
	}
	
	public byte getValuePrimitive() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static Byte parseValue(String value){
		return Byte.valueOf(parseValuePrimitive(value));
	}
	
	public static byte parseValuePrimitive(String value){
		return Byte.parseByte(value);
	}
	
	public static void checkValueBasedFacets(Byte value){
		//Nothing
	}
	
	public static void checkValueBasedFacetsPrimitive(byte value){
		//Nothing
	}

	public static Byte parseAndCheckValue(String value, XmlFile file) throws ParseException{
		return Byte.valueOf(parseAndCheckValuePrimitive(value, file));
	}
	
	public static byte parseAndCheckValuePrimitive(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		byte ret = parseValuePrimitive(tmp);
		checkValueBasedFacetsPrimitive(ret);
		return ret;
	}
}
