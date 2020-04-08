
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlSimpleTypePlaceholder;
import Xml.XmlText;
import Xml.XmlType;
import XmlSimpleTypes.XmlString;

public final class ParamType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = ".*";
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

    static {
        ALLOWED_ATTRIBUTES.add("semantic");
        try {
            ATTRIBUTES_NAME_MAP.put("semantic", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NMTOKEN"));
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ATTRIBUTES_NAME_MAP.put("type", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NMTOKEN"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("name");
        ALLOWED_ATTRIBUTES.add("sid");
        ALLOWED_ATTRIBUTES.add("type");
        REQUIRED_ATTRIBUTES.add("type");
    }

    public ParamType(XmlComplexType elem) {
        super(elem, ParamType.class);
    }

    public String getValue()
        throws IOException, ParseException
    {
        if (this.children == null) {
            loadChildren(true, true, ParamType.class);
        }
        if (this.children.length == 0) {
            this.children = new XmlType[] {new XmlText(this.file, this, this.pos, this.length)};
        }
        if (XmlSimpleTypePlaceholder.class.isAssignableFrom((children[0].getClass()))) {
            XmlString newChild = new XmlString(((XmlSimpleTypePlaceholder)(children[0])), (((XmlSimpleTypePlaceholder) children[0]).getDataAsString()));
            newChild.setQualifiedName((this.qualifiedName));
            (children)[ 0 ] = newChild;
        }
        return ((XmlString)(children[0])).getValue();
    }

}
