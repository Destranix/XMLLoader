package XmlSimpleTypes;

import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlFormValue;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlForm extends XmlSimpleType{
	
	protected final XmlFormValue value;

	public XmlForm(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public XmlFormValue getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static XmlFormValue parseValue(String value){
		XmlFormValue ret;
		switch(value){
			case "qualified":
				ret = XmlFormValue.QUALIFIED;
				break;
			case "unqualified":
				ret = XmlFormValue.UNQUALIFIED;
				break;
			default:
				throw new XmlValidationException("Illegal attribute value for form type: "+value);
		}
		return ret;
	}
	
	public static void checkValueBasedFacets(XmlFormValue value){
		//Nothing
	}
	
	public static XmlFormValue parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		XmlFormValue ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}
	
}
