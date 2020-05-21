
package ComplexTypes;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.ListOfHexBinaryType;
import Util.ArrayBigList;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlSimpleTypePlaceholder;
import Xml.XmlText;
import Xml.XmlType;

public final class ImageSourceTypeGroupHex
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
        ALLOWED_ATTRIBUTES.add("format");
        REQUIRED_ATTRIBUTES.add("format");
        try {
            ATTRIBUTES_NAME_MAP.put("format", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ImageSourceTypeGroupHex(XmlComplexType elem) {
        super(elem, ImageSourceTypeGroupHex.class);
    }

    public ArrayBigList<BigInteger> getValue()
        throws IOException, ParseException
    {
        if (this.children == null) {
            loadChildren(true, true, ImageSourceTypeGroupHex.class);
        }
        if (this.children.length == 0) {
            this.children = new XmlType[] {new XmlText(this.file, this, this.pos, this.length)};
        }
        if (XmlSimpleTypePlaceholder.class.isAssignableFrom((children[0].getClass()))) {
            ListOfHexBinaryType newChild = new ListOfHexBinaryType(((XmlSimpleTypePlaceholder)(children[0])), (((XmlSimpleTypePlaceholder) children[0]).getDataAsString()));
            newChild.setQualifiedName((this.qualifiedName));
            (children)[ 0 ] = newChild;
        }
        return ((ListOfHexBinaryType)(children[0])).getValue();
    }

}
