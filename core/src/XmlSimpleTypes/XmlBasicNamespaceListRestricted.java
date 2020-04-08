package XmlSimpleTypes;

import java.text.ParseException;
import java.util.regex.Pattern;

import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlBasicNamespaceListRestricted extends XmlSimpleType{
	private static final Pattern RESTRICTION_PATTERN = Pattern.compile("(?:##targetNamespace|##local|(?:(?:[a-zA-Z][0-9a-zA-Z+\\\\-\\\\.]*:)?/{0,2}[0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)?(?:#[0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)?)(?:(?:[ ]+)(?:##targetNamespace|##local|(?:(?:[a-zA-Z][0-9a-zA-Z+\\\\-\\\\.]*:)?/{0,2}[0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)?(?:#[0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)?))*");
	
	protected final String[] value;

	public XmlBasicNamespaceListRestricted(XmlSimpleType attr, String value) throws ParseException{
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
		if(value.length < 1){
			throw new XmlValidationException("Value not long enough. Must be >= 1, but was: "+value.length);
		}
	}
	
	public static String[] parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		String[] ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}
}
