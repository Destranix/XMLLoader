package XmlSimpleTypes;


import java.math.BigInteger;
import java.text.ParseException;

import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlAllNNI extends XmlSimpleType{

	protected final BigInteger value;
	
	public XmlAllNNI(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public BigInteger getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		return normalize(value, true, file).trim().replaceAll("[ ]+", " ");
	}
	
	public static BigInteger parseValue(String value){
		if("unbounded".equals(value)){
			return new BigInteger("-1");
		}else{
			return new BigInteger(value);
		}
	}
	
	public static void checkValueBasedFacets(BigInteger value){
		if(BigInteger.ZERO.compareTo(value) > 0 && !(new BigInteger("-1")).equals(value)){
			throw new XmlValidationException("Value must be non-negative integer or \"unbounded\": "+value);
		}
	}
	
	public static BigInteger parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		BigInteger ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}
	
}
