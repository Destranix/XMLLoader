
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class LinkTypeGroupGroup1AttachmentEnd
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((rotate[ ]+){1}|(translate[ ]+){1}){0,}";
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
    protected TranslateType[] translate;
    protected RotateType[] rotate;

    static {
        ALLOWED_ATTRIBUTES.add("joint");
        REQUIRED_ATTRIBUTES.add("joint");
        try {
            ATTRIBUTES_NAME_MAP.put("joint", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public LinkTypeGroupGroup1AttachmentEnd(XmlComplexType elem) {
        super(elem, LinkTypeGroupGroup1AttachmentEnd.class);
    }

    public TranslateType[] getTranslate()
        throws IOException
    {
        if (translate == null) {
            try {
                translate = ((TranslateType[]) getChildren(new TranslateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate_type"), LinkTypeGroupGroup1AttachmentEnd.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return translate;
    }

    public RotateType[] getRotate()
        throws IOException
    {
        if (rotate == null) {
            try {
                rotate = ((RotateType[]) getChildren(new RotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate_type"), LinkTypeGroupGroup1AttachmentEnd.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rotate;
    }

}
