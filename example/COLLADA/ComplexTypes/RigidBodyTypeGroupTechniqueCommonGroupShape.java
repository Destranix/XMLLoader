
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class RigidBodyTypeGroupTechniqueCommonGroupShape
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((((hollow[ ]+){0,1}(mass[ ]+){0,1}(density[ ]+){0,1}(instance_physics_material[ ]+){1}|(physics_material[ ]+){1}){0,1}(instance_geometry[ ]+){1}|(plane[ ]+){1}|(box[ ]+){1}|(sphere[ ]+){1}|(cylinder[ ]+){1}|(capsule[ ]+){1}){0,1}(translate[ ]+){1}|(rotate[ ]+){1}){0,}(extra[ ]+){0,}){1}";
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
    protected TargetableFloatType[] density;
    protected SphereType[] sphere;
    protected TargetableFloatType[] mass;
    protected PhysicsMaterialType[] physicsMaterial;
    protected CylinderType[] cylinder;
    protected InstancePhysicsMaterialType[] instancePhysicsMaterial;
    protected BoxType[] box;
    protected ExtraType[] extra;
    protected RigidBodyTypeGroupTechniqueCommonGroupShapeGroupHollow[] hollow;
    protected TranslateType[] translate;
    protected InstanceGeometryType[] instanceGeometry;
    protected RotateType[] rotate;
    protected CapsuleType[] capsule;
    protected PlaneType[] plane;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "density"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "density"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "density"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "box"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "box"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "box_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "box"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hollow"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hollow"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_body_type/group/technique_common/group/shape/group/hollow"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hollow"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "capsule"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "capsule"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "capsule_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "capsule"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public RigidBodyTypeGroupTechniqueCommonGroupShape(XmlComplexType elem) {
        super(elem, RigidBodyTypeGroupTechniqueCommonGroupShape.class);
    }

    public TargetableFloatType[] getDensity()
        throws IOException
    {
        if (density == null) {
            try {
                density = ((TargetableFloatType[]) getChildren(new TargetableFloatType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "density"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return density;
    }

    public SphereType[] getSphere()
        throws IOException
    {
        if (sphere == null) {
            try {
                sphere = ((SphereType[]) getChildren(new SphereType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sphere_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sphere;
    }

    public TargetableFloatType[] getMass()
        throws IOException
    {
        if (mass == null) {
            try {
                mass = ((TargetableFloatType[]) getChildren(new TargetableFloatType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mass;
    }

    public PhysicsMaterialType[] getPhysicsMaterial()
        throws IOException
    {
        if (physicsMaterial == null) {
            try {
                physicsMaterial = ((PhysicsMaterialType[]) getChildren(new PhysicsMaterialType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return physicsMaterial;
    }

    public CylinderType[] getCylinder()
        throws IOException
    {
        if (cylinder == null) {
            try {
                cylinder = ((CylinderType[]) getChildren(new CylinderType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cylinder_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cylinder;
    }

    public InstancePhysicsMaterialType[] getInstancePhysicsMaterial()
        throws IOException
    {
        if (instancePhysicsMaterial == null) {
            try {
                instancePhysicsMaterial = ((InstancePhysicsMaterialType[]) getChildren(new InstancePhysicsMaterialType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instancePhysicsMaterial;
    }

    public BoxType[] getBox()
        throws IOException
    {
        if (box == null) {
            try {
                box = ((BoxType[]) getChildren(new BoxType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "box"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "box_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return box;
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public RigidBodyTypeGroupTechniqueCommonGroupShapeGroupHollow[] getHollow()
        throws IOException
    {
        if (hollow == null) {
            try {
                hollow = ((RigidBodyTypeGroupTechniqueCommonGroupShapeGroupHollow[]) getChildren(new RigidBodyTypeGroupTechniqueCommonGroupShapeGroupHollow[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "hollow"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rigid_body_type/group/technique_common/group/shape/group/hollow"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return hollow;
    }

    public TranslateType[] getTranslate()
        throws IOException
    {
        if (translate == null) {
            try {
                translate = ((TranslateType[]) getChildren(new TranslateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
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
                instanceGeometry = ((InstanceGeometryType[]) getChildren(new InstanceGeometryType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_geometry_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceGeometry;
    }

    public RotateType[] getRotate()
        throws IOException
    {
        if (rotate == null) {
            try {
                rotate = ((RotateType[]) getChildren(new RotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rotate;
    }

    public CapsuleType[] getCapsule()
        throws IOException
    {
        if (capsule == null) {
            try {
                capsule = ((CapsuleType[]) getChildren(new CapsuleType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "capsule"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "capsule_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return capsule;
    }

    public PlaneType[] getPlane()
        throws IOException
    {
        if (plane == null) {
            try {
                plane = ((PlaneType[]) getChildren(new PlaneType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "plane_type"), RigidBodyTypeGroupTechniqueCommonGroupShape.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return plane;
    }

}
