package XmlSimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;

import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlQNameList extends XmlSimpleType{
	
	private static final Pattern RESTRICTION_PATTERN = Pattern.compile("((?:##defined|##definedSibling|.*)(?:(?:[ ]+)(?:##defined|##definedSibling|.*))*)");
	
	protected final String[] value;

	public XmlQNameList(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public String[] getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		if(!RESTRICTION_PATTERN.matcher(tmp).matches()){
			throw new XmlValidationException("Value does not match restriction: "+value);
		}
		return tmp;
	}
	
	public static String[] parseValue(String value){
		return value.split("[ ]+");
	}
	
	public static void checkValueBasedFacets(String[] value){
		//Nothing
	}
	
	public static String[] parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		String[] ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}

}
