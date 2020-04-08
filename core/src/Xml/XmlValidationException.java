package Xml;

/**
 * This exception occurs, when the element is not valid.
 */
public class XmlValidationException extends RuntimeException{

	private static final long serialVersionUID = -7923342950227761718L;
	
	public XmlValidationException(String message){
		super(message);
	}
	
	public XmlValidationException(String message, Throwable cause){
		super(message, cause);
	}
	
	public XmlValidationException(Throwable cause){
		super(cause);
	}

}
