
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class MtrType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((mtd[ ]+){1}){1}";
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
    protected MtdType mtd;

    static {
        ALLOWED_ATTRIBUTES.add("class");
        try {
            ATTRIBUTES_NAME_MAP.put("class", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NMTOKENS"));
            ATTRIBUTES_NAME_MAP.put("xref", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "IDREF"));
            ATTRIBUTES_NAME_MAP.put("rowalign", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("columnalign", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ATTRIBUTES_NAME_MAP.put("href", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ATTRIBUTES_NAME_MAP.put("style", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("groupalign", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtd"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtd"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtd.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtd"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtd"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("xref");
        ALLOWED_ATTRIBUTES.add("rowalign");
        ATTRIBUTE_DEFAULT_VALUES.put("rowalign", "baseline");
        ALLOWED_ATTRIBUTES.add("columnalign");
        ATTRIBUTE_DEFAULT_VALUES.put("columnalign", "center");
        ALLOWED_ATTRIBUTES.add("id");
        ALLOWED_ATTRIBUTES.add("href");
        ALLOWED_ATTRIBUTES.add("style");
        ALLOWED_ATTRIBUTES.add("groupalign");
        ALLOWED_ATTRIBUTES.add("##other");
    }

    public MtrType(XmlComplexType elem) {
        super(elem, MtrType.class);
    }

    public MtdType getMtd()
        throws IOException
    {
        if (mtd == null) {
            try {
                mtd = ((MtdType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtd"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtd.type"), MtrType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mtd;
    }

}
