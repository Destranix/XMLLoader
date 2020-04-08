package Xml;

/**
 * This class is used as superclass for {@link XmlComplexType} and {@link XmlSimpleType}.
 */
public abstract class XmlType {
	
	/**
	 * The file, this element belongs to
	 */
	public final XmlFile file;
	
	/**
	 * The path of this element in its files element tree.
	 */
	public String path;
	
	/**
	 * The qualified name or the type of this element
	 */
	public XmlQName qualifiedName;
	
	
	/**
	 * The parent of this element or {@code null} if this element is a root of the document
	 */
	public XmlComplexType parent;
	protected final long pos;
	protected final long length;
	
	public XmlType(XmlFile file, String path, XmlQName qualifiedName, XmlComplexType parent, long pos, long length) {
		this.file = file;
		this.path = path;
		this.qualifiedName = qualifiedName;
		this.parent = parent;
		this.pos = pos;
		this.length = length;
	}
	
	protected XmlType(XmlType elem) {
		this.file = elem.file;
		this.path = elem.path;
		this.qualifiedName = elem.qualifiedName;
		this.parent = elem.parent;
		this.pos = elem.pos;
		this.length = elem.length;
	}
	
	/**
	 * Sets this elements parent and path.
	 * 
	 * @param parent The new parent.
	 */
	public void setParent(XmlComplexType parent) {
		this.parent = parent;
		this.path = parent.path+"/"+qualifiedName.name;
	}
	
	/**
	 * Sets this elements parent and path.
	 * 
	 * @param parent The new parent.
	 * @param index The index of this element in the parents children-field
	 */
	public void setParent(XmlComplexType parent, int index) {
		this.parent = parent;
		this.path = parent.path+"/"+qualifiedName.name+"["+index+"]";
	}
	
	/**
	 * Sets this elements qualified name.
	 * 
	 * @param qualifiedName the new qualified name
	 */
	public void setQualifiedName(XmlQName qualifiedName){
		this.qualifiedName = qualifiedName;
	}

}
