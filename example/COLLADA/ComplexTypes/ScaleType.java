
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.Float3Type;
import Util.ArrayBigList;
import Xml.XmlComplexType;
import Xml.XmlFile;
import Xml.XmlQName;
import Xml.XmlSimpleType;
import Xml.XmlSimpleTypePlaceholder;
import Xml.XmlText;
import Xml.XmlType;

public final class ScaleType
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
        ALLOWED_ATTRIBUTES.add("sid");
        try {
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ScaleType(XmlComplexType elem) {
        super(elem, ScaleType.class);
    }

    public ArrayBigList<Double> getValue()
        throws IOException, ParseException
    {
        if (this.children == null) {
            loadChildren(true, true, ScaleType.class);
        }
        if (this.children.length == 0) {
            this.children = new XmlType[] {new XmlText(this.file, this, this.pos, this.length)};
        }
        if (XmlSimpleTypePlaceholder.class.isAssignableFrom((children[0].getClass()))) {
            ScaleType.SimpleTypeClass newChild = new ScaleType.SimpleTypeClass(((XmlSimpleTypePlaceholder)(children[0])), (((XmlSimpleTypePlaceholder) children[0]).getDataAsString()));
            newChild.setQualifiedName((this.qualifiedName));
            (children)[ 0 ] = newChild;
        }
        return ((ScaleType.SimpleTypeClass)(children[0])).getValue();
    }

    public static class SimpleTypeClass
        extends XmlSimpleType
    {

        protected final ArrayBigList<Double> value;

        public SimpleTypeClass(XmlSimpleType attr, String value)
            throws ParseException
        {
            super(attr);
            this.value = ScaleType.SimpleTypeClass.parseAndCheckValue(value, this.file);
        }

        @Override
        public ArrayBigList<Double> getValue() {
            return value;
        }

        public static ArrayBigList<Double> parseAndCheckValue(String value, XmlFile file)
            throws ParseException
        {
            String tmp = ScaleType.SimpleTypeClass.applyLexicalFacets(value, file);
            ArrayBigList<Double> ret = ScaleType.SimpleTypeClass.parseValue(tmp, file);
            ScaleType.SimpleTypeClass.checkValueBasedFacets(ret);
            return ret;
        }

        public static ArrayBigList<Double> parseValue(String value, XmlFile file)
            throws ParseException
        {
            ArrayBigList<Double> ret = ((ArrayBigList<Double> ) Float3Type.parseValue(value, file));
            return ret;
        }

        public static String applyLexicalFacets(String value, XmlFile file)
            throws ParseException
        {
            String tmp = Float3Type.applyLexicalFacets(value, file);
            return tmp;
        }

        public static void checkValueBasedFacets(ArrayBigList<Double> value) {
            Float3Type.checkValueBasedFacets(value);
        }

    }

}
