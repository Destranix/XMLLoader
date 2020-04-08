
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlToken;

public final class GlslProgramTypeGroupBindAttribute
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((semantic[ ]+){1}){1}";
    protected final static HashSet<XmlQName> ALLOWED_CHILDREN_NAMES = new HashSet<XmlQName>();
    protected final static HashMap<XmlQName, XmlQName> CHILDREN_NAME_MAP = new HashMap<XmlQName, XmlQName>();
    protected final static HashMap<XmlQName, Integer> ALLOWED_CHILDREN_MIN_BOUNDS = new HashMap<XmlQName, Integer>();
    protected final static HashMap<XmlQName, Integer> ALLOWED_CHILDREN_MAX_BOUNDS = new HashMap<XmlQName, Integer>();
    protected final static HashMap<String, String> ATTRIBUTE_DEFAULT_VALUES = new HashMap<String, String>();
    protected final static HashSet<String> ALLOWED_ATTRIBUTES = new HashSet<String>();
    protected final static HashSet<String> REQUIRED_ATTRIBUTES = new HashSet<String>();
    protected final static HashSet<String> FORBIDDEN_ATTRIBUTES = new HashSet<String>();
    protected final static HashMap<String, XmlQName> ATTRIBUTES_NAME_MAP = new HashMap<String, XmlQName>();
    protected final static HashMap<String, HashMap<String, XmlType>> KEY_MAPS = new HashMap<String, HashMap<String, XmlType>>();
    protected final static HashMap<String, String> KEY_OWNER_PATH_MAP = new HashMap<String, String>();
    protected final static HashMap<String, String> KEY_VALUE_PATH_MAP = new HashMap<String, String>();
    protected XmlToken semantic;

    static {
        ALLOWED_ATTRIBUTES.add("symbol");
        REQUIRED_ATTRIBUTES.add("symbol");
        try {
            ATTRIBUTES_NAME_MAP.put("symbol", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlslProgramTypeGroupBindAttribute(XmlComplexType elem) {
        super(elem, GlslProgramTypeGroupBindAttribute.class);
    }

    public XmlToken getSemantic()
        throws IOException
    {
        if (semantic == null) {
            try {
                semantic = ((XmlToken) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"), GlslProgramTypeGroupBindAttribute.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return semantic;
    }

}
