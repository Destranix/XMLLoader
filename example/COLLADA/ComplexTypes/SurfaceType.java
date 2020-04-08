
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class SurfaceType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((plane[ ]+){1}|(sphere[ ]+){1}|(torus[ ]+){1}|(swept_surface[ ]+){1}|(nurbs_surface[ ]+){1}|(cone[ ]+){1}|(cylinder[ ]+){1}){0,1}(orient[ ]+){0,}(origin[ ]+){0,1}){1}";
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
    protected SurfaceTypeGroupGroup0Cylinder cylinder;
    protected SphereType sphere;
    protected ConeType cone;
    protected NurbsSurfaceType nurbsSurface;
    protected OrientType[] orient;
    protected TorusType torus;
    protected OriginType origin;
    protected PlaneType plane;
    protected SweptSurfaceType sweptSurface;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_type/group/group0/cylinder"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cone"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cone"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cone_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cone"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cone"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_surface"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_surface"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_surface_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_surface"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_surface"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "torus"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "torus"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "torus_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "torus"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "torus"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swept_surface"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swept_surface"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swept_surface_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swept_surface"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swept_surface"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("sid");
    }

    public SurfaceType(XmlComplexType elem) {
        super(elem, SurfaceType.class);
    }

    public SurfaceTypeGroupGroup0Cylinder getCylinder()
        throws IOException
    {
        if (cylinder == null) {
            try {
                cylinder = ((SurfaceTypeGroupGroup0Cylinder) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_type/group/group0/cylinder"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cylinder;
    }

    public SphereType getSphere()
        throws IOException
    {
        if (sphere == null) {
            try {
                sphere = ((SphereType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere_type"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sphere;
    }

    public ConeType getCone()
        throws IOException
    {
        if (cone == null) {
            try {
                cone = ((ConeType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cone"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cone_type"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cone;
    }

    public NurbsSurfaceType getNurbsSurface()
        throws IOException
    {
        if (nurbsSurface == null) {
            try {
                nurbsSurface = ((NurbsSurfaceType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_surface"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_surface_type"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return nurbsSurface;
    }

    public OrientType[] getOrient()
        throws IOException
    {
        if (orient == null) {
            try {
                orient = ((OrientType[]) getChildren(new OrientType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient_type"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return orient;
    }

    public TorusType getTorus()
        throws IOException
    {
        if (torus == null) {
            try {
                torus = ((TorusType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "torus"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "torus_type"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return torus;
    }

    public OriginType getOrigin()
        throws IOException
    {
        if (origin == null) {
            try {
                origin = ((OriginType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin_type"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return origin;
    }

    public PlaneType getPlane()
        throws IOException
    {
        if (plane == null) {
            try {
                plane = ((PlaneType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane_type"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return plane;
    }

    public SweptSurfaceType getSweptSurface()
        throws IOException
    {
        if (sweptSurface == null) {
            try {
                sweptSurface = ((SweptSurfaceType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swept_surface"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "swept_surface_type"), SurfaceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sweptSurface;
    }

}
