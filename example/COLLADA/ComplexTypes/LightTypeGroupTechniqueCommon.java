
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class LightTypeGroupTechniqueCommon
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((ambient[ ]+){1}|(directional[ ]+){1}|(point[ ]+){1}|(spot[ ]+){1}){0,1}";
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
    protected LightTypeGroupTechniqueCommonGroupDirectional directional;
    protected LightTypeGroupTechniqueCommonGroupPoint point;
    protected LightTypeGroupTechniqueCommonGroupAmbient ambient;
    protected LightTypeGroupTechniqueCommonGroupSpot spot;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "directional"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "directional"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_type/group/technique_common/group/directional"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "directional"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "directional"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_type/group/technique_common/group/point"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_type/group/technique_common/group/ambient"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spot"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spot"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_type/group/technique_common/group/spot"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spot"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spot"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public LightTypeGroupTechniqueCommon(XmlComplexType elem) {
        super(elem, LightTypeGroupTechniqueCommon.class);
    }

    public LightTypeGroupTechniqueCommonGroupDirectional getDirectional()
        throws IOException
    {
        if (directional == null) {
            try {
                directional = ((LightTypeGroupTechniqueCommonGroupDirectional) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "directional"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_type/group/technique_common/group/directional"), LightTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return directional;
    }

    public LightTypeGroupTechniqueCommonGroupPoint getPoint()
        throws IOException
    {
        if (point == null) {
            try {
                point = ((LightTypeGroupTechniqueCommonGroupPoint) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "point"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_type/group/technique_common/group/point"), LightTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return point;
    }

    public LightTypeGroupTechniqueCommonGroupAmbient getAmbient()
        throws IOException
    {
        if (ambient == null) {
            try {
                ambient = ((LightTypeGroupTechniqueCommonGroupAmbient) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ambient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_type/group/technique_common/group/ambient"), LightTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ambient;
    }

    public LightTypeGroupTechniqueCommonGroupSpot getSpot()
        throws IOException
    {
        if (spot == null) {
            try {
                spot = ((LightTypeGroupTechniqueCommonGroupSpot) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "spot"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "light_type/group/technique_common/group/spot"), LightTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return spot;
    }

}
