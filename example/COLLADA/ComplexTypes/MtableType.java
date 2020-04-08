
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class MtableType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((mtr[ ]+){1}|(mlabeledtr[ ]+){1}){0,1}";
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
    protected MlabeledtrType mlabeledtr;
    protected MtrType mtr;

    static {
        ALLOWED_ATTRIBUTES.add("xref");
        try {
            ATTRIBUTES_NAME_MAP.put("xref", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "IDREF"));
            ATTRIBUTES_NAME_MAP.put("columnwidth", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("side", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("equalrows", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ATTRIBUTES_NAME_MAP.put("rowlines", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("equalcolumns", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ATTRIBUTES_NAME_MAP.put("framespacing", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("groupalign", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("alignmentscope", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("align", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("displaystyle", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ATTRIBUTES_NAME_MAP.put("class", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NMTOKENS"));
            ATTRIBUTES_NAME_MAP.put("rowspacing", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("minlabelspacing", new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "length-with-unit"));
            ATTRIBUTES_NAME_MAP.put("rowalign", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("columnalign", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("columnlines", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ATTRIBUTES_NAME_MAP.put("href", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ATTRIBUTES_NAME_MAP.put("width", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("style", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("frame", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "attribute/type"));
            ATTRIBUTES_NAME_MAP.put("columnspacing", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mlabeledtr"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mlabeledtr"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mlabeledtr.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mlabeledtr"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mlabeledtr"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtr"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtr"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtr.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtr"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtr"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("columnwidth");
        ATTRIBUTE_DEFAULT_VALUES.put("columnwidth", "auto");
        ALLOWED_ATTRIBUTES.add("side");
        ATTRIBUTE_DEFAULT_VALUES.put("side", "right");
        ALLOWED_ATTRIBUTES.add("equalrows");
        ATTRIBUTE_DEFAULT_VALUES.put("equalrows", "false");
        ALLOWED_ATTRIBUTES.add("rowlines");
        ATTRIBUTE_DEFAULT_VALUES.put("rowlines", "none");
        ALLOWED_ATTRIBUTES.add("equalcolumns");
        ATTRIBUTE_DEFAULT_VALUES.put("equalcolumns", "false");
        ALLOWED_ATTRIBUTES.add("framespacing");
        ATTRIBUTE_DEFAULT_VALUES.put("framespacing", "0.4em 0.5ex");
        ALLOWED_ATTRIBUTES.add("groupalign");
        ALLOWED_ATTRIBUTES.add("alignmentscope");
        ATTRIBUTE_DEFAULT_VALUES.put("alignmentscope", "true");
        ALLOWED_ATTRIBUTES.add("align");
        ATTRIBUTE_DEFAULT_VALUES.put("align", "axis");
        ALLOWED_ATTRIBUTES.add("displaystyle");
        ATTRIBUTE_DEFAULT_VALUES.put("displaystyle", "false");
        ALLOWED_ATTRIBUTES.add("class");
        ALLOWED_ATTRIBUTES.add("rowspacing");
        ATTRIBUTE_DEFAULT_VALUES.put("rowspacing", "1.0ex");
        ALLOWED_ATTRIBUTES.add("minlabelspacing");
        ATTRIBUTE_DEFAULT_VALUES.put("minlabelspacing", "0.8em");
        ALLOWED_ATTRIBUTES.add("rowalign");
        ATTRIBUTE_DEFAULT_VALUES.put("rowalign", "baseline");
        ALLOWED_ATTRIBUTES.add("columnalign");
        ATTRIBUTE_DEFAULT_VALUES.put("columnalign", "center");
        ALLOWED_ATTRIBUTES.add("columnlines");
        ATTRIBUTE_DEFAULT_VALUES.put("columnlines", "none");
        ALLOWED_ATTRIBUTES.add("id");
        ALLOWED_ATTRIBUTES.add("href");
        ALLOWED_ATTRIBUTES.add("width");
        ATTRIBUTE_DEFAULT_VALUES.put("width", "auto");
        ALLOWED_ATTRIBUTES.add("style");
        ALLOWED_ATTRIBUTES.add("frame");
        ATTRIBUTE_DEFAULT_VALUES.put("frame", "none");
        ALLOWED_ATTRIBUTES.add("columnspacing");
        ATTRIBUTE_DEFAULT_VALUES.put("columnspacing", "0.8em");
        ALLOWED_ATTRIBUTES.add("##other");
    }

    public MtableType(XmlComplexType elem) {
        super(elem, MtableType.class);
    }

    public MlabeledtrType getMlabeledtr()
        throws IOException
    {
        if (mlabeledtr == null) {
            try {
                mlabeledtr = ((MlabeledtrType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mlabeledtr"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mlabeledtr.type"), MtableType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mlabeledtr;
    }

    public MtrType getMtr()
        throws IOException
    {
        if (mtr == null) {
            try {
                mtr = ((MtrType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtr"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtr.type"), MtableType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mtr;
    }

}
