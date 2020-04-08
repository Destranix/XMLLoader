
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

public final class ImageTypeGroupGroup2Create3dGroupFormat
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((hint[ ]+){1}(exact[ ]+){0,1}){1}";
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
    protected XmlToken exact;
    protected ImageTypeGroupGroup2Create3dGroupFormatGroupHint hint;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "exact"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "exact"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "exact"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "exact"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hint"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hint"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/format/group/hint"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hint"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hint"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ImageTypeGroupGroup2Create3dGroupFormat(XmlComplexType elem) {
        super(elem, ImageTypeGroupGroup2Create3dGroupFormat.class);
    }

    public XmlToken getExact()
        throws IOException
    {
        if (exact == null) {
            try {
                exact = ((XmlToken) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "exact"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"), ImageTypeGroupGroup2Create3dGroupFormat.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return exact;
    }

    public ImageTypeGroupGroup2Create3dGroupFormatGroupHint getHint()
        throws IOException
    {
        if (hint == null) {
            try {
                hint = ((ImageTypeGroupGroup2Create3dGroupFormatGroupHint) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hint"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/format/group/hint"), ImageTypeGroupGroup2Create3dGroupFormat.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return hint;
    }

}
