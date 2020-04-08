package Xml;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents a qualified name for elements or types.
 *
 */
public class XmlQName {

	private static final Map<XmlQName, Set<XmlQName>> SUPERTYPE_MAP = new HashMap<XmlQName, Set<XmlQName>>(); 
	
	/**
	 * The namespace of this object
	 */
	public final URI namespace;
	
	/**
	 * The name of this object.
	 */
	public final String name;
	
	public XmlQName(URI namespace, String name){
		this(namespace, name, null);
	}
	
	/**
	 * Creates a new XmlQName and adds new supertypes for it. Supertype relationships are stored in class members and so apply for all XmlQName that equal the newly created object.
	 * 
	 * @param namespace The namespace of this object
	 * @param name The name of this object
	 * @param supertypes A set of supertypes of this qualified name.
	 */
	public XmlQName(URI namespace, String name, Set<XmlQName> supertypes){
		this.namespace = namespace;
		this.name = name;
		SUPERTYPE_MAP.putIfAbsent(this, new HashSet<XmlQName>());
		if(supertypes != null){
			SUPERTYPE_MAP.get(this).addAll(supertypes);
		}
		SUPERTYPE_MAP.get(this).add(this);
	}
	
	/**
	 * Returns all supertypes of this qualified name.
	 * 
	 * @return All supertypes of this qualified name
	 */
	public Set<XmlQName> getSupertypes(){
		return SUPERTYPE_MAP.get(this);
	}
	
	/**
	 * Returns {@code true}, if {@code this} is equal to {@code o} or one of the ancestors of {@code o}.
	 * 
	 * @param o The element to be tested
	 * @return {@code True}, if {@code this} is equal to {@code o} or one of the ancestors of {@code o}, otherwise {@code false}
	 */
	public boolean isSupertypeOf(XmlQName o){
		Queue<XmlQName> queue = new ArrayDeque<XmlQName>();
		XmlQName current;
		queue.add(o);
		while(queue.size() > 0){
			current = queue.poll();
			if(current.getSupertypes().contains(this)){
				return true;
			}
			Set<XmlQName> supertypes = current.getSupertypes();
			if(supertypes != null){
				queue.addAll(supertypes);
				queue.remove(current);
			}
		}
		return false;	
	}
	
	/**
	 * <p>Parses a given String to a qualified name.</p>
	 * <p>{@code value} must follow the following syntax:</p>
	 * <pre>
	 * value = (namespaceIdentifier ':' ) name;
	 * </pre>
	 * <p>If it does not, an Exception may be thrown</p>
	 * 
	 * @param value The value to be parsed
	 * @param namespaceMap The namespaceMap used to map namespaceIdentifiers to namespace-URIs
	 * @return The parsed qualified name
	 */
	public static XmlQName parseQName(String value, Map<String, URI> namespaceMap){
		String namePart;
		URI namespace;
		if(value.contains(":")){
			String[] valueParts = value.split(":");
			if(valueParts.length != 2){
				throw new IllegalArgumentException("Given value cannot be parsed as QName: "+value);
			}else{
				namePart = valueParts[1];
				namespace = namespaceMap.get(valueParts[0]);
			}
		}else{
			namePart = value;
			namespace = namespaceMap.get("");
		}
		return new XmlQName(namespace, namePart);
	}
	
	/**
	 * <p>Parses a given String to a qualified name.</p>
	 * <p>{@code value} must follow the following syntax:</p>
	 * <pre>
	 * value = '{' \\s* uri \\s* ',' \\s* name \\s* '}';
	 * </pre>
	 * <p>If it does not, an Exception may be thrown</p>
	 * 
	 * @param value The value to be parsed
	 * @return The parsed qualified name
	 */
	public static XmlQName parseQName(String value) {
		final Pattern parsePattern = Pattern.compile("\\{\\s*([^,]+)\\s*,\\s*([^,]+)\\s*\\}");
		Matcher matcher = parsePattern.matcher(value);
		if(!matcher.matches()){
			throw new RuntimeException("Value does not match pattern: "+value);
		}
		URI namespace;
		try{
			namespace = new URI(matcher.group(1));
		}catch(URISyntaxException e){
			throw new RuntimeException("Values namespace is not a valid URI: "+value, e);
		}
		String namePart = matcher.group(2);
		
		return new XmlQName(namespace, namePart);
	}
	
	/**
	 * Two objects are equal if all of the following applies:
	 * <ul>
	 * <li>{@code o} is not {@code null}</li>
	 * <li>{@code o} is a instance of {@linkplain XmlQName}</li>
	 * <li>{@code this.namespace} and {@code o.namespace} are both {@code null} or equal</li>
	 * <li>{@code this.name} and {@code o.name} are both {@code null} or equal</li>
	 * </ul>
	 * 
	 * @param o The object to tested
	 * @return {@code True}, if {@code this} and o are equal, otherwise {@code false}.
	 */
	@Override
	public boolean equals(Object o){
		return (
				(o != null) &&
				(o instanceof XmlQName) &&
				((this.namespace == ((XmlQName) o).namespace) || (this.namespace != null && this.namespace.equals(((XmlQName) o).namespace))) &&
				((this.name == ((XmlQName) o).name) || (this.name != null && this.name.equals(((XmlQName) o).name)))
				);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		return Objects.hash(namespace, name);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "{"+namespace+", "+name+"}";
	}
	
}
