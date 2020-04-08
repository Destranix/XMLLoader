package XmlSimpleTypes;

import java.text.ParseException;
import java.util.EnumSet;

import Xml.XmlFile;
import Xml.XmlFinalValue;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlFinal extends XmlSimpleType{
	
	protected final EnumSet<XmlFinalValue> value;


	public XmlFinal(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public EnumSet<XmlFinalValue> getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static EnumSet<XmlFinalValue> parseValue(String value){
		EnumSet<XmlFinalValue> ret;
		if("#all".equals(value)){
			ret = EnumSet.allOf(XmlFinalValue.class);
		}else{
			ret = EnumSet.noneOf(XmlFinalValue.class);
			String[] values = value.split("\\s+");
			for(int i=0;i<values.length;++i){
				if(!"".equals(values[i])){
					switch(values[i]){
						case "extension":
							ret.add(XmlFinalValue.EXTENSION);
							break;
						case "restriction":
							ret.add(XmlFinalValue.RESTRICTION);
							break;
						case "list":
							ret.add(XmlFinalValue.LIST);
							break;
						case "union":
							ret.add(XmlFinalValue.UNION);
							break;
						default:
							throw new XmlValidationException("Illegal attribute value for final type: "+value);
					}
				}
			}
		}
		return ret;
	}
	
	public static void checkValueBasedFacets(EnumSet<XmlFinalValue> value){
		//Nothing
	}
	
	public static EnumSet<XmlFinalValue> parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		EnumSet<XmlFinalValue> ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}
}
