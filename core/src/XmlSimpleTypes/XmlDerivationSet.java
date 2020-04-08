package XmlSimpleTypes;

import java.text.ParseException;
import java.util.EnumSet;

import Xml.XmlDerivationSetValue;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlDerivationSet extends XmlSimpleType{
	
	protected final EnumSet<XmlDerivationSetValue> value;


	public XmlDerivationSet(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public EnumSet<XmlDerivationSetValue> getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static EnumSet<XmlDerivationSetValue> parseValue(String value){
		EnumSet<XmlDerivationSetValue> ret;
		if("#all".equals(value)){
			ret = EnumSet.allOf(XmlDerivationSetValue.class);
		}else{
			ret = EnumSet.noneOf(XmlDerivationSetValue.class);
			String[] values = value.split("\\s+");
			for(int i=0;i<values.length;++i){
				switch(values[i]){
					case "extension":
						ret.add(XmlDerivationSetValue.EXTENSION);
						break;
					case "restriction":
						ret.add(XmlDerivationSetValue.RESTRICTION);
						break;
					default:
						throw new XmlValidationException("Illegal attribute value for derivationSet type: "+value);
				}
			}
		}
		return ret;
	}
	
	public static void checkValueBasedFacets(EnumSet<XmlDerivationSetValue> value){
		//Nothing
	}
	
	public static EnumSet<XmlDerivationSetValue> parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		EnumSet<XmlDerivationSetValue> ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}

}
