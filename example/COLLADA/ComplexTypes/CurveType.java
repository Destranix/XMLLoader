
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class CurveType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((line[ ]+){1}|(circle[ ]+){1}|(ellipse[ ]+){1}|(parabola[ ]+){1}|(hyperbola[ ]+){1}|(nurbs[ ]+){1}){0,1}(orient[ ]+){0,}(origin[ ]+){0,1}){1}";
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
    protected ParabolaType parabola;
    protected HyperbolaType hyperbola;
    protected NurbsType nurbs;
    protected EllipseType ellipse;
    protected LineType line;
    protected CircleType circle;
    protected OrientType[] orient;
    protected OriginType origin;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "parabola"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "parabola"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "parabola_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "parabola"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "parabola"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hyperbola"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hyperbola"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hyperbola_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hyperbola"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hyperbola"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ellipse"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ellipse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ellipse_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ellipse"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ellipse"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "circle"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "circle"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "circle_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "circle"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "circle"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("sid");
    }

    public CurveType(XmlComplexType elem) {
        super(elem, CurveType.class);
    }

    public ParabolaType getParabola()
        throws IOException
    {
        if (parabola == null) {
            try {
                parabola = ((ParabolaType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "parabola"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "parabola_type"), CurveType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return parabola;
    }

    public HyperbolaType getHyperbola()
        throws IOException
    {
        if (hyperbola == null) {
            try {
                hyperbola = ((HyperbolaType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hyperbola"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hyperbola_type"), CurveType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return hyperbola;
    }

    public NurbsType getNurbs()
        throws IOException
    {
        if (nurbs == null) {
            try {
                nurbs = ((NurbsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "nurbs_type"), CurveType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return nurbs;
    }

    public EllipseType getEllipse()
        throws IOException
    {
        if (ellipse == null) {
            try {
                ellipse = ((EllipseType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ellipse"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ellipse_type"), CurveType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ellipse;
    }

    public LineType getLine()
        throws IOException
    {
        if (line == null) {
            try {
                line = ((LineType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "line_type"), CurveType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return line;
    }

    public CircleType getCircle()
        throws IOException
    {
        if (circle == null) {
            try {
                circle = ((CircleType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "circle"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "circle_type"), CurveType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return circle;
    }

    public OrientType[] getOrient()
        throws IOException
    {
        if (orient == null) {
            try {
                orient = ((OrientType[]) getChildren(new OrientType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "orient_type"), CurveType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return orient;
    }

    public OriginType getOrigin()
        throws IOException
    {
        if (origin == null) {
            try {
                origin = ((OriginType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "origin_type"), CurveType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return origin;
    }

}
