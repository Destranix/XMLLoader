
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class CameraTypeGroupOpticsGroupTechniqueCommon
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((orthographic[ ]+){1}|(perspective[ ]+){1}){0,1}";
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
    protected CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective perspective;
    protected CameraTypeGroupOpticsGroupTechniqueCommonGroupOrthographic orthographic;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "perspective"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "perspective"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "camera_type/group/optics/group/technique_common/group/perspective"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "perspective"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "perspective"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orthographic"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orthographic"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "camera_type/group/optics/group/technique_common/group/orthographic"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orthographic"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orthographic"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public CameraTypeGroupOpticsGroupTechniqueCommon(XmlComplexType elem) {
        super(elem, CameraTypeGroupOpticsGroupTechniqueCommon.class);
    }

    public CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective getPerspective()
        throws IOException
    {
        if (perspective == null) {
            try {
                perspective = ((CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "perspective"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "camera_type/group/optics/group/technique_common/group/perspective"), CameraTypeGroupOpticsGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return perspective;
    }

    public CameraTypeGroupOpticsGroupTechniqueCommonGroupOrthographic getOrthographic()
        throws IOException
    {
        if (orthographic == null) {
            try {
                orthographic = ((CameraTypeGroupOpticsGroupTechniqueCommonGroupOrthographic) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orthographic"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "camera_type/group/optics/group/technique_common/group/orthographic"), CameraTypeGroupOpticsGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return orthographic;
    }

}
