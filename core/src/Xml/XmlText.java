package Xml;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class represents XML-elements, that are assumed to be text. this might also be elements, that are simply not yet parsed.
 *
 */
public class XmlText extends XmlSimpleTypePlaceholder{
	
	protected static final URI xml;
	static{
		try{
			 xml = new URI("https://www.w3.org/2001/XML");
		} catch (URISyntaxException e) {
			throw new AssertionError("URI not parsable", e);
		}
		
	}

	public XmlText(XmlFile file, XmlComplexType parent, long pos, long length) {
		this(file, parent, pos, length, null);
	}
	
	public XmlText(XmlFile file, XmlComplexType parent, long pos, long length, String value) {
		super(file, "TEXT", parent, new XmlQName(xml, "TEXT"), pos, length, value);
	}
	
	@Override
	public XmlSimpleType load(XmlQName type) throws IOException {
		int nameIndex = this.path.lastIndexOf("text");
		this.path = this.path.substring(nameIndex) + type.name;
		this.qualifiedName = type;
		return (XmlSimpleType) file.loader.create(this, type);
	}
	
	@Override
	public String toString() {
		if(value == null){
			return "...";
		}else{
			return value;
		}
	}
	
}
