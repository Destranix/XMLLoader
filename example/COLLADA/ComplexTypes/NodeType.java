
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class NodeType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((asset[ ]+){0,1}(lookat[ ]+){1}|(matrix[ ]+){1}|(rotate[ ]+){1}|(scale[ ]+){1}|(skew[ ]+){1}|(translate[ ]+){1}){0,}(instance_camera[ ]+){0,}(instance_controller[ ]+){0,}(instance_geometry[ ]+){0,}(instance_light[ ]+){0,}(instance_node[ ]+){0,}(node[ ]+){0,}(extra[ ]+){0,}){1}";
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
    protected LookatType[] lookat;
    protected SkewType[] skew;
    protected InstanceLightType[] instanceLight;
    protected InstanceCameraType[] instanceCamera;
    protected InstanceNodeType[] instanceNode;
    protected MatrixType1 [] matrix;
    protected InstanceControllerType[] instanceController;
    protected ExtraType[] extra;
    protected ScaleType[] scale;
    protected TranslateType[] translate;
    protected InstanceGeometryType[] instanceGeometry;
    protected AssetType[] asset;
    protected RotateType[] rotate;
    protected NodeType[] node;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ATTRIBUTES_NAME_MAP.put("type", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "node_enum"));
            ATTRIBUTES_NAME_MAP.put("layer", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_names_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lookat"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lookat"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lookat_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lookat"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "skew"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "skew"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "skew_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "skew"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_light"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_light"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_light_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_light"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_camera"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_camera"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_camera_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_camera"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_node"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_node"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_node_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_node"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "matrix"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "matrix_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "matrix"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_controller"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_controller"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_controller_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_controller"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scale"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scale"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scale_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scale"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "node"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "node"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "node_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "node"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("id");
        ALLOWED_ATTRIBUTES.add("sid");
        ALLOWED_ATTRIBUTES.add("type");
        ATTRIBUTE_DEFAULT_VALUES.put("type", "NODE");
        ALLOWED_ATTRIBUTES.add("layer");
    }

    public NodeType(XmlComplexType elem) {
        super(elem, NodeType.class);
    }

    public LookatType[] getLookat()
        throws IOException
    {
        if (lookat == null) {
            try {
                lookat = ((LookatType[]) getChildren(new LookatType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lookat"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lookat_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lookat;
    }

    public SkewType[] getSkew()
        throws IOException
    {
        if (skew == null) {
            try {
                skew = ((SkewType[]) getChildren(new SkewType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "skew"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "skew_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return skew;
    }

    public InstanceLightType[] getInstanceLight()
        throws IOException
    {
        if (instanceLight == null) {
            try {
                instanceLight = ((InstanceLightType[]) getChildren(new InstanceLightType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_light"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_light_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceLight;
    }

    public InstanceCameraType[] getInstanceCamera()
        throws IOException
    {
        if (instanceCamera == null) {
            try {
                instanceCamera = ((InstanceCameraType[]) getChildren(new InstanceCameraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_camera"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_camera_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceCamera;
    }

    public InstanceNodeType[] getInstanceNode()
        throws IOException
    {
        if (instanceNode == null) {
            try {
                instanceNode = ((InstanceNodeType[]) getChildren(new InstanceNodeType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_node"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_node_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceNode;
    }

    public MatrixType1 [] getMatrix()
        throws IOException
    {
        if (matrix == null) {
            try {
                matrix = ((MatrixType1 []) getChildren(new MatrixType1 [ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "matrix"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "matrix_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return matrix;
    }

    public InstanceControllerType[] getInstanceController()
        throws IOException
    {
        if (instanceController == null) {
            try {
                instanceController = ((InstanceControllerType[]) getChildren(new InstanceControllerType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_controller"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_controller_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceController;
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public ScaleType[] getScale()
        throws IOException
    {
        if (scale == null) {
            try {
                scale = ((ScaleType[]) getChildren(new ScaleType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scale"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scale_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scale;
    }

    public TranslateType[] getTranslate()
        throws IOException
    {
        if (translate == null) {
            try {
                translate = ((TranslateType[]) getChildren(new TranslateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return translate;
    }

    public InstanceGeometryType[] getInstanceGeometry()
        throws IOException
    {
        if (instanceGeometry == null) {
            try {
                instanceGeometry = ((InstanceGeometryType[]) getChildren(new InstanceGeometryType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceGeometry;
    }

    public AssetType[] getAsset()
        throws IOException
    {
        if (asset == null) {
            try {
                asset = ((AssetType[]) getChildren(new AssetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return asset;
    }

    public RotateType[] getRotate()
        throws IOException
    {
        if (rotate == null) {
            try {
                rotate = ((RotateType[]) getChildren(new RotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rotate;
    }

    public NodeType[] getNode()
        throws IOException
    {
        if (node == null) {
            try {
                node = ((NodeType[]) getChildren(new NodeType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "node"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "node_type"), NodeType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return node;
    }

}
