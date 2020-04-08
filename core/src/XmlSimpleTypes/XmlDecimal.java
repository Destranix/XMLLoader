package XmlSimpleTypes;

import java.math.BigDecimal;
import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlDecimal extends XmlSimpleType{
	
	protected final BigDecimal value;
	
	public XmlDecimal(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public BigDecimal getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static BigDecimal parseValue(String value){
		return new BigDecimal(value);
	}
	
	public static void checkValueBasedFacets(BigDecimal value){
		//Nothing
	}
	
	public static BigDecimal parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		BigDecimal ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}

}
