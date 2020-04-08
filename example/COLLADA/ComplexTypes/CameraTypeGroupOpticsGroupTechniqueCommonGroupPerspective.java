
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((((xfov[ ]+){1}(yfov[ ]+){1}|(aspect_ratio[ ]+){1}){0,1}){1}|(yfov[ ]+){1}(aspect_ratio[ ]+){0,1}){1}){0,1}(znear[ ]+){1}(zfar[ ]+){1}){1}";
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
    protected TargetableFloatType[] yfov;
    protected TargetableFloatType znear;
    protected TargetableFloatType zfar;
    protected TargetableFloatType xfov;
    protected TargetableFloatType[] aspectRatio;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "yfov"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "yfov"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "yfov"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "yfov"), Integer.valueOf("2"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "znear"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "znear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "znear"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "znear"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfar"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfar"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfar"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfar"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "xfov"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "xfov"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "xfov"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "xfov"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "aspect_ratio"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "aspect_ratio"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "aspect_ratio"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "aspect_ratio"), Integer.valueOf("2"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective(XmlComplexType elem) {
        super(elem, CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective.class);
    }

    public TargetableFloatType[] getYfov()
        throws IOException
    {
        if (yfov == null) {
            try {
                yfov = ((TargetableFloatType[]) getChildren(new TargetableFloatType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "yfov"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return yfov;
    }

    public TargetableFloatType getZnear()
        throws IOException
    {
        if (znear == null) {
            try {
                znear = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "znear"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return znear;
    }

    public TargetableFloatType getZfar()
        throws IOException
    {
        if (zfar == null) {
            try {
                zfar = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "zfar"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return zfar;
    }

    public TargetableFloatType getXfov()
        throws IOException
    {
        if (xfov == null) {
            try {
                xfov = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "xfov"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return xfov;
    }

    public TargetableFloatType[] getAspectRatio()
        throws IOException
    {
        if (aspectRatio == null) {
            try {
                aspectRatio = ((TargetableFloatType[]) getChildren(new TargetableFloatType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "aspect_ratio"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), CameraTypeGroupOpticsGroupTechniqueCommonGroupPerspective.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return aspectRatio;
    }

}
