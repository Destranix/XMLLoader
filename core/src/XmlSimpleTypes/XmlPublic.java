package XmlSimpleTypes;

import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlPublic extends XmlSimpleType{
	
	protected final String value;
	
	public XmlPublic(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public String getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static String parseValue(String value){
		return value;
	}
	
	public static void checkValueBasedFacets(String value){
		//Nothing
	}
	
	public static String parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		String ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}
	
}
