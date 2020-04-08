package Xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import XmlComplexTypes.XmlSchema;

/**
 * This class represents a Schema file.
 *
 */
public class XmlSchemaFile extends XmlFile{

	public XmlSchemaFile(XmlFile file) throws FileNotFoundException {
		super(file);
	}

	public XmlSchemaFile(File file) throws FileNotFoundException {
		super(file);
	}
	
	public XmlSchemaFile(String filepath) throws FileNotFoundException {
		this(new File(filepath));
	}
	
	@Override
	public XmlSchema getRoot() throws IOException {
		if(XmlComplexType.class.equals(roots[0].getClass())){
			roots[0] = (XmlComplexType) loader.create(roots[0]);
		}
		return (XmlSchema) roots[0];
	}
	
}
