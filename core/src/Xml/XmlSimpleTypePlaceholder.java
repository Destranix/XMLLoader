package Xml;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * This class represents an XmlSimpleType, that has not yet been created/loaded.
 *
 */
public class XmlSimpleTypePlaceholder extends XmlSimpleType{
	
	protected String value;
	
	public XmlSimpleTypePlaceholder(XmlFile file, String path, XmlComplexType parent, XmlQName qualifiedName, long pos, long length) {
		this(file, path, parent, qualifiedName, pos, length, null);
	}
	
	public XmlSimpleTypePlaceholder(XmlFile file, String path, XmlComplexType parent, XmlQName qualifiedName, long pos, long length, String value) {
		super(file, path, qualifiedName, parent, pos, length);
		this.value = value;
	}
	
	public XmlSimpleTypePlaceholder(XmlSimpleType attr) {
		this(attr.file, attr.path, attr.parent, attr.qualifiedName, attr.pos, attr.length, null);
	}
	
	@Override
	public String getValue(){
		return value;
	}
	
	/**
	 * Loads this object. It calls the {@link XmlLoaderExtension#create(XmlType elem, XmlQName type)} method on this object with the given type and returns the result. 
	 * 
	 * @param type The type of the element
	 * @return The loaded/created element.
	 * @throws IOException If an IOException was thrown by {@link XmlLoaderExtension#create(XmlType elem, XmlQName type)}.
	 */
	public XmlSimpleType load(XmlQName type) throws IOException {
		return (XmlSimpleType) file.loader.create(this, type);
	}

	/**
	 * Loads the value of this object, if not yet loaded, and returns it as byte array.
	 * 
	 * @return This objects value as byte array.
	 * @throws IOException If an IOException was thrown by {@link #loadValue()}.
	 */
	public byte[] getDataAsByteArray() throws IOException {//Be aware of document's encoding!
		if(value == null){
			loadValue();
		}
		return value.getBytes();
	}
	
	/**
	 * Returns a MappedByteBuffer mapping the memory region in the underlying file, where the value of this object lies.
	 * 
	 * @return The mapped region.
	 * @throws IOException If an IOException occurred during file operations.
	 */
	public MappedByteBuffer getDataAsMappedByteBuffer() throws IOException {//Be aware of document's encoding!
			RandomAccessFile accessFile = file.getFile(2);
			MappedByteBuffer ret = accessFile.getChannel().map(FileChannel.MapMode.PRIVATE, pos, length);
			file.releaseFile(accessFile);
			return ret;
	}
	
	/**
	 * Immediately returns a PipedInputStream, that will get the data of this objects value by a extra thread, that reads the data
	 * 
	 * @return The input stream.
	 * @throws IOException If an IOException occurred during file operations.
	 */
	public PipedInputStream getDataAsPipedInputStream() throws IOException {//Be aware of document's encoding!
		final PipedOutputStream out = new PipedOutputStream();
		PipedInputStream stream = new PipedInputStream(out);
		//Start extra Thread, which reads the file
		Thread t = new Thread() {
			@Override
			public void run() {
				if(value == null){
					RandomAccessFile accessFile = file.getFile(0);
						try {
							accessFile.seek(pos);
							for(int i=0;i<length;++i) {
								byte b = accessFile.readByte();
								out.write(b);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					file.releaseFile(accessFile);
				}else{
					try {
						byte[] bytes = value.getBytes();
						for(int i=0;i<length;++i) {
							byte b = bytes[i];
							out.write(b);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		return stream;
	}
	
	/**
	 * Loads the value of this object, if not yet loaded, and returns it.
	 * 
	 * @return This objects value.
	 * @throws IOException If an IOException was thrown by {@link #loadValue()}.
	 */
	public String getDataAsString() throws IOException {
		if(value == null){
			loadValue();
		}
		return value;
	}
	
	/**
	 * Reads this objects value from the underlying file, if it was not yet loaded.
	 * 
	 * @throws IOException If an IOException occurred during file operations.
	 */
	public void loadValue() throws IOException {
		if(value == null){
			byte[] readBuffer = new byte[(int) length];
			RandomAccessFile accessFile = file.getFile(0);
			accessFile.seek(pos);
			accessFile.readFully(readBuffer, 0, (int)length);
			file.releaseFile(accessFile);
			value = new String(readBuffer);
		}
	}
	
	/* (non-Javadoc)
	 * @see Xml.XmlSimpleType#toString()
	 */
	@Override
	public String toString() {
		String startBrace, endBrace;
		startBrace="<";
		endBrace=">";
		StringBuilder b = new StringBuilder(startBrace);
		b.append(qualifiedName.name);
		b.append(endBrace);
		b.append("...");
		b.append(startBrace);
		b.append('/');
		b.append(qualifiedName.name);
		b.append(endBrace);
		return b.toString();
	}
	
}
