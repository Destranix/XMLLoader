package XmlSimpleTypes;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import Xml.XmlFile;
import Xml.XmlSimpleType;

public class XmlGYearMonth extends XmlSimpleType{
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("['-']yyyy'-'MM[XXXXX]");
	
	protected final TemporalAccessor value;
	
	public XmlGYearMonth(XmlSimpleType attr, String value) throws ParseException{
		super(attr);
		this.value = parseAndCheckValue(value, this.file);
	}
	
	@Override
	public TemporalAccessor getValue() {
		return value;
	}
	
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		String tmp = normalize(value, true, file).trim().replaceAll("[ ]+", " ");
		return tmp;
	}
	
	public static TemporalAccessor parseValue(String value){
		return FORMATTER.parse(value);
	}
	
	public static void checkValueBasedFacets(TemporalAccessor value){
		//Nothing
	}
	
	public static TemporalAccessor parseAndCheckValue(String value, XmlFile file) throws ParseException{
		String tmp = applyLexicalFacets(value, file);
		TemporalAccessor ret = parseValue(tmp);
		checkValueBasedFacets(ret);
		return ret;
	}

}
