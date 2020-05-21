package XmlSimpleTypes;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Util.ArrayBigList;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlNamespaceList extends XmlSimpleType{
	
	private static final Pattern RESTRICTION_PATTERN = Pattern.compile("(?:##targetNamespace|##local|##any|##other|(?:(?:[a-zA-Z][0-9a-zA-Z+\\\\-\\\\.]*:)?/{0,2}[0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)?(?:#[0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)?)(?:(?:[ ]+)(?:##targetNamespace|##local|##any|##other|(?:(?:[a-zA-Z][0-9a-zA-Z+\\\\-\\\\.]*:)?/{0,2}[0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)?(?:#[0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)?))*");
	
	protected final ArrayBigList<String> value;

	public XmlNamespaceList(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public ArrayBigList<String> getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		if(!RESTRICTION_PATTERN.matcher(tmp).matches()){
			throw new XmlValidationException("Value does not match restriction: "+value);
		}
		return tmp;
	}
	
	public static ArrayBigList<String>  parseValue(String value){
		final Pattern splitPattern = Pattern.compile("([^ ]*)[ ]+");
		
		ArrayBigList<String> ret =  new ArrayBigList<String>();
		Matcher matcher = splitPattern.matcher(value);
		while(matcher.find()){
			ret.add(matcher.group(1));
		}
		return ret;
	}
	
	public static void checkValueBasedFacets(ArrayBigList<String> value){
		//Nothing
	}
	
	public static ArrayBigList<String> parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		ArrayBigList<String>  ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}

}
