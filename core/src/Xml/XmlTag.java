package Xml;


import java.util.Map;

/**
 * This class represents a single XML-tag.
 *
 */
public class XmlTag {

public static enum TagType {META, START, END, STARTEND, COMMENT, DOCTYPE, TEXT};
	
	public final long pos;
	public final long length;
	public final Map<String, XmlSimpleType> attributes;
	public final String namespaceId;
	public final String name;
	public final TagType type;
	
	public XmlTag(long pos, long length, Map<String, XmlSimpleType> attributes, String namespaceId, String name, TagType type) {
		this.pos = pos;
		this.length = length;
		this.attributes = attributes;
		this.namespaceId = namespaceId;
		this.name = name;
		this.type = type;
	}
	
}
