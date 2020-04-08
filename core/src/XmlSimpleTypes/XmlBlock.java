package XmlSimpleTypes;

import java.text.ParseException;
import java.util.EnumSet;

import Xml.XmlBlockValue;
import Xml.XmlFile;
import Xml.XmlSimpleType;
import Xml.XmlValidationException;

public class XmlBlock extends XmlSimpleType{
	
	protected final EnumSet<XmlBlockValue> value;

	public XmlBlock(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public EnumSet<XmlBlockValue> getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static EnumSet<XmlBlockValue> parseValue(String value){
		EnumSet<XmlBlockValue> ret;
		if("#all".equals(value)){
			ret = EnumSet.allOf(XmlBlockValue.class);
		}else{
			ret = EnumSet.noneOf(XmlBlockValue.class);
			String[] values = value.split("\\s+");
			for(int i=0;i<values.length;++i){
				if(!"".equals(values[i])){
					switch(values[i]){
						case "extension":
							ret.add(XmlBlockValue.EXTENSION);
							break;
						case "restriction":
							ret.add(XmlBlockValue.RESTRICTION);
							break;
						case "substitution":
							ret.add(XmlBlockValue.SUBSTITUTION);
							break;
						default:
							throw new XmlValidationException("Illegal attribute value for block type. Was \""+values[i]+"\": "+value);
					}
				}
			}
		}
		return ret;
	}
	
	public static void checkValueBasedFacets(EnumSet<XmlBlockValue> value){
		//Nothing
	}
	
	public static EnumSet<XmlBlockValue> parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		EnumSet<XmlBlockValue> ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}
}
