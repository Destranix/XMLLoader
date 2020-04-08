
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlAnyURI;

public final class FxTargetTypeGroupBinary
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((ref[ ]+){1}|(hex[ ]+){1}){0,1}";
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
    protected FxTargetTypeGroupBinaryGroupHex hex;
    protected XmlAnyURI ref;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hex"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hex"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_target_type/group/binary/group/hex"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hex"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hex"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public FxTargetTypeGroupBinary(XmlComplexType elem) {
        super(elem, FxTargetTypeGroupBinary.class);
    }

    public FxTargetTypeGroupBinaryGroupHex getHex()
        throws IOException
    {
        if (hex == null) {
            try {
                hex = ((FxTargetTypeGroupBinaryGroupHex) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hex"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_target_type/group/binary/group/hex"), FxTargetTypeGroupBinary.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return hex;
    }

    public XmlAnyURI getRef()
        throws IOException
    {
        if (ref == null) {
            try {
                ref = ((XmlAnyURI) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ref"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"), FxTargetTypeGroupBinary.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ref;
    }

}
