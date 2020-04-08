package XmlXPath;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathVariableResolver;

import org.xml.sax.SAXException;

/**
 *This is an (yet untested) class, used to check assertions.
 */
public class XmlXPathEvaluator {

	public XmlXPathEvaluator() throws ParserConfigurationException, SAXException, IOException{
	}
	
	/**
	 * Checks if the given expression does evaluate to code true for the given object.
	 * 
	 * @param expression The given expression.
	 * @param value The given object
	 * @return {@code True} if the expression evaluates to {@code true} otherwise {@code false}.
	 * @throws XPathExpressionException If an XPathExpressionException was thrown by an underlying method.
	 */
	public static boolean expressionEvaluatesToTrue(String expression, Object value) throws XPathExpressionException{
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		xpath.setXPathVariableResolver(new ValueXPathVariableResolver(value));
		return ((Boolean) xpath.evaluate(expression, null, XPathConstants.BOOLEAN)).booleanValue();
	}
	
	private static class ValueXPathVariableResolver implements XPathVariableResolver{
		
		private final Object value;
		
		public ValueXPathVariableResolver(Object value){
			this.value = value;
		}

		@Override
		public Object resolveVariable(QName variableName) {
			if((new QName(null, "value")).equals(variableName)){
				return value;
			}
			return null;
		}
		
		
		
	}
	
}
