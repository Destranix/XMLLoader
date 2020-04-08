package XmlSimpleTypes;

import java.text.ParseException;
import java.time.Duration;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlDuration extends XmlSimpleType{
	
	protected final Duration value;
	
	public XmlDuration(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public Duration getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static Duration parseValue(String value){
		return  Duration.parse(value);//TODO: Check format same as https://www.w3.org/TR/xmlschema-2/#duration
	}
	
	public static void checkValueBasedFacets(Duration value){
		//Nothing
	}

	public static Duration parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		Duration ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}
}
