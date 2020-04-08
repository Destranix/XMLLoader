
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class BrepType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((curves[ ]+){0,1}(surface_curves[ ]+){0,1}(surfaces[ ]+){0,1}(source[ ]+){1,}(vertices[ ]+){1}(edges[ ]+){0,1}(wires[ ]+){0,1}(faces[ ]+){0,1}(pcurves[ ]+){0,1}(shells[ ]+){0,1}(solids[ ]+){0,1}(extra[ ]+){0,}){1}";
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
    protected EdgesType edges;
    protected ExtraType[] extra;
    protected VerticesType vertices;
    protected PcurvesType pcurves;
    protected SolidsType solids;
    protected FacesType faces;
    protected SurfaceCurvesType surfaceCurves;
    protected WiresType wires;
    protected ShellsType shells;
    protected SourceType[] source;
    protected CurvesType curves;
    protected SurfacesType surfaces;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "edges"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "edges"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "edges_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "edges"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "edges"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "pcurves"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "pcurves"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "pcurves_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "pcurves"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "pcurves"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "solids"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "solids"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "solids_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "solids"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "solids"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "faces"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "faces"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "faces_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "faces"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "faces"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_curves"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_curves"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_curves_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_curves"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_curves"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "wires"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "wires"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "wires_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "wires"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "wires"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shells"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shells"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shells_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shells"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shells"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "curves"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "curves"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "curves_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "curves"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "curves"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surfaces"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surfaces"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surfaces_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surfaces"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surfaces"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public BrepType(XmlComplexType elem) {
        super(elem, BrepType.class);
    }

    public EdgesType getEdges()
        throws IOException
    {
        if (edges == null) {
            try {
                edges = ((EdgesType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "edges"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "edges_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return edges;
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public VerticesType getVertices()
        throws IOException
    {
        if (vertices == null) {
            try {
                vertices = ((VerticesType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vertices;
    }

    public PcurvesType getPcurves()
        throws IOException
    {
        if (pcurves == null) {
            try {
                pcurves = ((PcurvesType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "pcurves"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "pcurves_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pcurves;
    }

    public SolidsType getSolids()
        throws IOException
    {
        if (solids == null) {
            try {
                solids = ((SolidsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "solids"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "solids_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return solids;
    }

    public FacesType getFaces()
        throws IOException
    {
        if (faces == null) {
            try {
                faces = ((FacesType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "faces"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "faces_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return faces;
    }

    public SurfaceCurvesType getSurfaceCurves()
        throws IOException
    {
        if (surfaceCurves == null) {
            try {
                surfaceCurves = ((SurfaceCurvesType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_curves"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surface_curves_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return surfaceCurves;
    }

    public WiresType getWires()
        throws IOException
    {
        if (wires == null) {
            try {
                wires = ((WiresType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "wires"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "wires_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return wires;
    }

    public ShellsType getShells()
        throws IOException
    {
        if (shells == null) {
            try {
                shells = ((ShellsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shells"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shells_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return shells;
    }

    public SourceType[] getSource()
        throws IOException
    {
        if (source == null) {
            try {
                source = ((SourceType[]) getChildren(new SourceType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return source;
    }

    public CurvesType getCurves()
        throws IOException
    {
        if (curves == null) {
            try {
                curves = ((CurvesType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "curves"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "curves_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return curves;
    }

    public SurfacesType getSurfaces()
        throws IOException
    {
        if (surfaces == null) {
            try {
                surfaces = ((SurfacesType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surfaces"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "surfaces_type"), BrepType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return surfaces;
    }

}
