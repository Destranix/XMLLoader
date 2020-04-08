package XmlSimpleTypes;

import java.text.ParseException;
import java.util.Base64;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlBase64Binary extends XmlSimpleType{
	
	protected final byte[] value;
	
	public XmlBase64Binary(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public byte[] getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		return normalize(value, true, file).trim().replaceAll("[ ]+", " ");
	}
	
	public static byte[] parseValue(String value){
		return Base64.getDecoder().decode(value);
	}
	
	public static void checkValueBasedFacets(byte[] value){
		//Nothing
	}
	
	public static byte[] parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		byte[] ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}

}
