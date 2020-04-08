package XmlSimpleTypes;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlAnyURI extends XmlSimpleType{
	
	protected final URI value;
	
	public XmlAnyURI(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public URI getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		return normalize(value, true, file).trim().replaceAll("[ ]+", " ");
	}
	
	public static URI parseValue(String value){
		try {
			return new URI(value);
		} catch (URISyntaxException e) {
			throw new XmlValidationException("Could not parse URI", e);
		}
	}
	
	public static void checkValueBasedFacets(URI value){
		//Nothing
	}
	
	public static URI parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		URI ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}

}