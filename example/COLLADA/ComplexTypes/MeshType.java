
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class MeshType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((source[ ]+){1,}(vertices[ ]+){1}(lines[ ]+){1}|(linestrips[ ]+){1}|(polygons[ ]+){1}|(polylist[ ]+){1}|(triangles[ ]+){1}|(trifans[ ]+){1}|(tristrips[ ]+){1}){0,}(extra[ ]+){0,}){1}";
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
    protected ExtraType[] extra;
    protected TrifansType[] trifans;
    protected VerticesType[] vertices;
    protected PolygonsType[] polygons;
    protected LinesType[] lines;
    protected TristripsType[] tristrips;
    protected TrianglesType[] triangles;
    protected LinestripsType[] linestrips;
    protected PolylistType[] polylist;
    protected SourceType[] source;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "trifans"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "trifans"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "trifans_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "trifans"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygons"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygons"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygons_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygons"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lines"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lines"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lines_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lines"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "tristrips"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "tristrips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "tristrips_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "tristrips"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "triangles"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "triangles"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "triangles_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "triangles"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linestrips"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linestrips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linestrips_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linestrips"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polylist"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polylist"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polylist_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polylist"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public MeshType(XmlComplexType elem) {
        super(elem, MeshType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public TrifansType[] getTrifans()
        throws IOException
    {
        if (trifans == null) {
            try {
                trifans = ((TrifansType[]) getChildren(new TrifansType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "trifans"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "trifans_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return trifans;
    }

    public VerticesType[] getVertices()
        throws IOException
    {
        if (vertices == null) {
            try {
                vertices = ((VerticesType[]) getChildren(new VerticesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vertices_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vertices;
    }

    public PolygonsType[] getPolygons()
        throws IOException
    {
        if (polygons == null) {
            try {
                polygons = ((PolygonsType[]) getChildren(new PolygonsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygons"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polygons_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polygons;
    }

    public LinesType[] getLines()
        throws IOException
    {
        if (lines == null) {
            try {
                lines = ((LinesType[]) getChildren(new LinesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lines"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lines_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lines;
    }

    public TristripsType[] getTristrips()
        throws IOException
    {
        if (tristrips == null) {
            try {
                tristrips = ((TristripsType[]) getChildren(new TristripsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "tristrips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "tristrips_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return tristrips;
    }

    public TrianglesType[] getTriangles()
        throws IOException
    {
        if (triangles == null) {
            try {
                triangles = ((TrianglesType[]) getChildren(new TrianglesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "triangles"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "triangles_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return triangles;
    }

    public LinestripsType[] getLinestrips()
        throws IOException
    {
        if (linestrips == null) {
            try {
                linestrips = ((LinestripsType[]) getChildren(new LinestripsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linestrips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "linestrips_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return linestrips;
    }

    public PolylistType[] getPolylist()
        throws IOException
    {
        if (polylist == null) {
            try {
                polylist = ((PolylistType[]) getChildren(new PolylistType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polylist"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "polylist_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return polylist;
    }

    public SourceType[] getSource()
        throws IOException
    {
        if (source == null) {
            try {
                source = ((SourceType[]) getChildren(new SourceType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type"), MeshType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return source;
    }

}
