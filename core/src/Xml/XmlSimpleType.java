package Xml;

import java.text.ParseException;
import java.util.PrimitiveIterator;

/**
 * <p>This class is used for elements of simple types and for attributes</p>
 *
 */
public abstract class XmlSimpleType extends XmlType{
	
	public XmlSimpleType(XmlFile file, String path, XmlQName qualifiedName, XmlComplexType parent, long pos, long length) {
		super(file, path, qualifiedName, parent, pos, length);
	}
	
	public XmlSimpleType(XmlType elem) {
		super(elem.file, elem.path, elem.qualifiedName, elem.parent, elem.pos, elem.length);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public static final boolean isSimpleType(){
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public static final boolean isComplexType(){
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String startBrace, endBrace;
		startBrace="<";
		endBrace=">";
		StringBuilder b = new StringBuilder(startBrace);
		b.append(qualifiedName.name);
		b.append(endBrace);
		b.append(getValue().toString());
		b.append(startBrace);
		b.append('/');
		b.append(qualifiedName.name);
		b.append(endBrace);
		return b.toString();
	}
	
	/**
	 * Returns this elements value.
	 * 
	 * @return This elements value.
	 */
	public abstract Object getValue();
	
	/**
	 * Applies all lexical facets of this simple type and all enumeration restrictions.
	 * 
	 * @param value The value to be tested
	 * @param file The file, which to refer to
	 * @return The value after applying all lexical facets
	 * @throws ParseException If the value could not be parsed
	 */
	public static String applyLexicalFacets(String value, XmlFile file) throws ParseException{
		return value;
	}
	
	/**
	 * Checks all value based facets(except those from enumeration facets, which are tested in {@link #applyLexicalFacets(String value, XmlFile file)}).
	 * 
	 * @param value The value to be checked.
	 */
	public static void checkValueBasedFacets(Object value) {
		//Nothing
	}
	
	/**
	 * Parses the given String.
	 * 
	 * @param value The String to be parsed.
	 * @return The parsed value.
	 */
	public static Object parseValue(String value) {
		return value;
	}
	
	/**
	 * First applies lexical facets on {@code value}, than parses the result and checks value based facets. The the result is returned.
	 * 
	 * @param value The String to be parsed.
	 * @param file The file, which to refer to
	 * @return The parsed value.
	 * @throws ParseException If the value could not be parsed
	 */
	public static Object parseAndCheckValue(String value, XmlFile file) throws ParseException{
		return value;
	}
	
	/**
	 * <p>Normalizes the given String using the entity references of {@code file}.</p>
	 * <p>If {@code whitespaceReplace} is {@code true}, '\n', '\r' and '\t' will be replaced by ' '</p>
	 * <p>See <a href="https://www.w3.org/TR/REC-xml/#AVNormalize">https://www.w3.org/TR/REC-xml/#AVNormalize</a> for details</p>
	 * 
	 * @param value The value to be normalized
	 * @param whitespaceReplace Indicates, how whitespaces will be replaced
	 * @param file The file, which to refer to
	 * @return The normalized value
	 * @throws ParseException If the given value was illegal and so could not be parsed.
	 */
	public static String normalize(String value, boolean whitespaceReplace, XmlFile file) throws ParseException {
		if(whitespaceReplace){
			value = value.replace('\r', '\n');
		}
		StringBuilder ret = new StringBuilder();
		PrimitiveIterator.OfInt iter = value.codePoints().iterator();
		int index = 0;
		while(iter.hasNext()){
			int codePoint = iter.nextInt();
			index++;
			if(codePoint == '&'){
				if(!iter.hasNext()){
					throw new ParseException("Illegal Reference: "+value, index);
				}else{
					codePoint = iter.nextInt();
					index++;
					if(codePoint == '#'){
						if(!iter.hasNext()){
							throw new ParseException("Illegal Reference: "+value, index);
						}else{
							codePoint = iter.nextInt();
							index++;
							boolean isHexadecimal = false;
							if(codePoint == 'x'){
								isHexadecimal = true;
								if(!iter.hasNext()){
									throw new ParseException("Unexpected End while parsing: "+value, index);
								}else{
									codePoint = iter.nextInt();
									index++;
								}
							}
							StringBuilder numberString = new StringBuilder();
							while(codePoint != ';'){
								numberString.appendCodePoint(codePoint);
								if(!iter.hasNext()){
									throw new ParseException("Unexpected End while parsing, expecting ';': "+value, index);
								}else{
									codePoint = iter.nextInt();
									index++;
								}
							}
							try{
								ret.appendCodePoint(Integer.parseInt(numberString.toString(), (isHexadecimal?16:10)));
							}catch(NumberFormatException e){
								throw new ParseException("Illegal Character Reference: "+value, index-numberString.length());
							}
						}
					}else{
						StringBuilder nameString = new StringBuilder();
						while(codePoint != ';'){
							nameString.appendCodePoint(codePoint);
							if(!iter.hasNext()){
								throw new ParseException("Unexpected End while parsing, expecting ';': "+value, index);
							}else{
								codePoint = iter.nextInt();
								index++;
							}
						}
						switch(nameString.toString()){
							case "quot":
								ret.appendCodePoint('"');
								break;
							case "amp":
								ret.appendCodePoint('&');
								break;
							case "apos":
								ret.appendCodePoint('\'');
								break;
							case "lt":
								ret.appendCodePoint('<');
								break;
							case "gt":
								ret.appendCodePoint('>');
								break;
							default:
								String replaceValue = file.resolveEntity(nameString.toString());
								if(replaceValue == null){
									throw new ParseException("Illegal Entity Reference. Referenced entity does not exist: "+value, index);
								}else{
									ret.append(replaceValue);
								}
						}
					}
				}
			}else if(whitespaceReplace &&(codePoint == ' ' || codePoint == '\r' || codePoint == '\n' || codePoint == '\t')){
				ret.appendCodePoint(' ');
			}else{
				ret.appendCodePoint(codePoint);
			}
		}
		return ret.toString();
	}
	
}
