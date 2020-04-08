package XmlSimpleTypes;


import java.math.BigInteger;
import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlUnsignedLong extends XmlSimpleType{
	
protected final BigInteger value;
	
	public XmlUnsignedLong(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public BigInteger getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static BigInteger parseValue(String value){
		return new BigInteger(value);
	}
	
	public static void checkValueBasedFacets(BigInteger value){
		if(BigInteger.ZERO.compareTo(value) > 0){
			throw new XmlValidationException("Value must be positive: "+value);
		}
	}
	
	public static BigInteger parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		BigInteger ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}
	
}
