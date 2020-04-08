
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.Float3Type;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class InstanceRigidBodyTypeGroupTechniqueCommon
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((angular_velocity[ ]+){0,1}(velocity[ ]+){0,1}(dynamic[ ]+){0,1}(mass[ ]+){0,1}(mass_frame[ ]+){0,1}(inertia[ ]+){0,1}(instance_physics_material[ ]+){1}|(physics_material[ ]+){1}){0,1}(shape[ ]+){0,}){1}";
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
    protected InstanceRigidBodyTypeGroupTechniqueCommonGroupDynamic dynamic;
    protected InstancePhysicsMaterialType instancePhysicsMaterial;
    protected Float3Type angularVelocity;
    protected InstanceRigidBodyTypeGroupTechniqueCommonGroupShape[] shape;
    protected Float3Type velocity;
    protected TargetableFloat3Type inertia;
    protected TargetableFloatType mass;
    protected InstanceRigidBodyTypeGroupTechniqueCommonGroupMassFrame massFrame;
    protected PhysicsMaterialType physicsMaterial;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_rigid_body_type/group/technique_common/group/dynamic"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular_velocity"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular_velocity"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular_velocity"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular_velocity"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shape"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shape"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_rigid_body_type/group/technique_common/group/shape"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shape"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "velocity"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "velocity"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "velocity"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "velocity"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inertia"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inertia"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inertia"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inertia"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass_frame"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass_frame"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_rigid_body_type/group/technique_common/group/mass_frame"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass_frame"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass_frame"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public InstanceRigidBodyTypeGroupTechniqueCommon(XmlComplexType elem) {
        super(elem, InstanceRigidBodyTypeGroupTechniqueCommon.class);
    }

    public InstanceRigidBodyTypeGroupTechniqueCommonGroupDynamic getDynamic()
        throws IOException
    {
        if (dynamic == null) {
            try {
                dynamic = ((InstanceRigidBodyTypeGroupTechniqueCommonGroupDynamic) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "dynamic"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_rigid_body_type/group/technique_common/group/dynamic"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return dynamic;
    }

    public InstancePhysicsMaterialType getInstancePhysicsMaterial()
        throws IOException
    {
        if (instancePhysicsMaterial == null) {
            try {
                instancePhysicsMaterial = ((InstancePhysicsMaterialType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_physics_material_type"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instancePhysicsMaterial;
    }

    public Float3Type getAngularVelocity()
        throws IOException
    {
        if (angularVelocity == null) {
            try {
                angularVelocity = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "angular_velocity"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return angularVelocity;
    }

    public InstanceRigidBodyTypeGroupTechniqueCommonGroupShape[] getShape()
        throws IOException
    {
        if (shape == null) {
            try {
                shape = ((InstanceRigidBodyTypeGroupTechniqueCommonGroupShape[]) getChildren(new InstanceRigidBodyTypeGroupTechniqueCommonGroupShape[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shape"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_rigid_body_type/group/technique_common/group/shape"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return shape;
    }

    public Float3Type getVelocity()
        throws IOException
    {
        if (velocity == null) {
            try {
                velocity = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "velocity"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return velocity;
    }

    public TargetableFloat3Type getInertia()
        throws IOException
    {
        if (inertia == null) {
            try {
                inertia = ((TargetableFloat3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inertia"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float3_type"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return inertia;
    }

    public TargetableFloatType getMass()
        throws IOException
    {
        if (mass == null) {
            try {
                mass = ((TargetableFloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "targetable_float_type"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mass;
    }

    public InstanceRigidBodyTypeGroupTechniqueCommonGroupMassFrame getMassFrame()
        throws IOException
    {
        if (massFrame == null) {
            try {
                massFrame = ((InstanceRigidBodyTypeGroupTechniqueCommonGroupMassFrame) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mass_frame"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_rigid_body_type/group/technique_common/group/mass_frame"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return massFrame;
    }

    public PhysicsMaterialType getPhysicsMaterial()
        throws IOException
    {
        if (physicsMaterial == null) {
            try {
                physicsMaterial = ((PhysicsMaterialType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "physics_material_type"), InstanceRigidBodyTypeGroupTechniqueCommon.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return physicsMaterial;
    }

}
