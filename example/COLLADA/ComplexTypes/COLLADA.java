
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class COLLADA
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((asset[ ]+){1}(library_animations[ ]+){1}|(library_animation_clips[ ]+){1}|(library_cameras[ ]+){1}|(library_controllers[ ]+){1}|(library_geometries[ ]+){1}|(library_effects[ ]+){1}|(library_force_fields[ ]+){1}|(library_images[ ]+){1}|(library_lights[ ]+){1}|(library_materials[ ]+){1}|(library_nodes[ ]+){1}|(library_physics_materials[ ]+){1}|(library_physics_models[ ]+){1}|(library_physics_scenes[ ]+){1}|(library_visual_scenes[ ]+){1}|(library_joints[ ]+){1}|(library_kinematics_models[ ]+){1}|(library_articulated_systems[ ]+){1}|(library_kinematics_scenes[ ]+){1}|(library_formulas[ ]+){1}){0,}(scene[ ]+){0,1}(extra[ ]+){0,}){1}";
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
    protected LibraryPhysicsScenesType[] libraryPhysicsScenes;
    protected LibraryFormulasType[] libraryFormulas;
    protected LibraryArticulatedSystemsType[] libraryArticulatedSystems;
    protected LibraryEffectsType[] libraryEffects;
    protected LibraryPhysicsMaterialsType[] libraryPhysicsMaterials;
    protected LibraryAnimationsType[] libraryAnimations;
    protected LibraryForceFieldsType[] libraryForceFields;
    protected LibraryImagesType[] libraryImages;
    protected LibraryVisualScenesType[] libraryVisualScenes;
    protected COLLADAGroupScene scene;
    protected LibraryLightsType[] libraryLights;
    protected ExtraType[] extra;
    protected LibraryJointsType[] libraryJoints;
    protected LibraryAnimationClipsType[] libraryAnimationClips;
    protected LibraryKinematicsModelsType[] libraryKinematicsModels;
    protected LibraryControllersType[] libraryControllers;
    protected LibraryGeometriesType[] libraryGeometries;
    protected LibraryKinematicsScenesType[] libraryKinematicsScenes;
    protected AssetType[] asset;
    protected LibraryNodesType[] libraryNodes;
    protected LibraryMaterialsType[] libraryMaterials;
    protected LibraryCamerasType[] libraryCameras;
    protected LibraryPhysicsModelsType[] libraryPhysicsModels;

    static {
        ALLOWED_ATTRIBUTES.add("version");
        REQUIRED_ATTRIBUTES.add("version");
        try {
            ATTRIBUTES_NAME_MAP.put("version", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "version_enum"));
            ATTRIBUTES_NAME_MAP.put("base", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_scenes"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_scenes"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_scenes_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_scenes"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_formulas"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_formulas"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_formulas_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_formulas"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_articulated_systems"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_articulated_systems"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_articulated_systems_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_articulated_systems"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_effects"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_effects"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_effects_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_effects"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_materials"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_materials"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_materials_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_materials"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animations"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animations"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animations_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animations"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_force_fields"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_force_fields"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_force_fields_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_force_fields"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_images"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_images"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_images_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_images"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_visual_scenes"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_visual_scenes"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_visual_scenes_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_visual_scenes"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scene"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scene"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "COLLADA/group/scene"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scene"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scene"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_lights"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_lights"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_lights_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_lights"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_joints"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_joints"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_joints_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_joints"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animation_clips"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animation_clips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animation_clips_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animation_clips"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_models"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_models"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_models_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_models"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_controllers"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_controllers"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_controllers_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_controllers"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_geometries"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_geometries"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_geometries_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_geometries"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_scenes"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_scenes"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_scenes_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_scenes"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_nodes"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_nodes"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_nodes_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_nodes"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_materials"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_materials"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_materials_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_materials"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_cameras"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_cameras"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_cameras_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_cameras"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_models"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_models"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_models_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_models"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("base");
        KEY_MAPS.put("sources", new HashMap<String, XmlType>());
        addKeyPaths(SourceType.class, "sources", ".[:name=source]/../::ancestor-or-self/.[:type={http:%2F%2Fwww.collada.org%2F2008%2F03%2FCOLLADASchema, COLLADA}]", "@id");
    }

    public COLLADA(XmlComplexType elem) {
        super(elem, COLLADA.class);
    }

    public LibraryPhysicsScenesType[] getLibraryPhysicsScenes()
        throws IOException
    {
        if (libraryPhysicsScenes == null) {
            try {
                libraryPhysicsScenes = ((LibraryPhysicsScenesType[]) getChildren(new LibraryPhysicsScenesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_scenes"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_scenes_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryPhysicsScenes;
    }

    public LibraryFormulasType[] getLibraryFormulas()
        throws IOException
    {
        if (libraryFormulas == null) {
            try {
                libraryFormulas = ((LibraryFormulasType[]) getChildren(new LibraryFormulasType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_formulas"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_formulas_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryFormulas;
    }

    public LibraryArticulatedSystemsType[] getLibraryArticulatedSystems()
        throws IOException
    {
        if (libraryArticulatedSystems == null) {
            try {
                libraryArticulatedSystems = ((LibraryArticulatedSystemsType[]) getChildren(new LibraryArticulatedSystemsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_articulated_systems"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_articulated_systems_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryArticulatedSystems;
    }

    public LibraryEffectsType[] getLibraryEffects()
        throws IOException
    {
        if (libraryEffects == null) {
            try {
                libraryEffects = ((LibraryEffectsType[]) getChildren(new LibraryEffectsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_effects"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_effects_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryEffects;
    }

    public LibraryPhysicsMaterialsType[] getLibraryPhysicsMaterials()
        throws IOException
    {
        if (libraryPhysicsMaterials == null) {
            try {
                libraryPhysicsMaterials = ((LibraryPhysicsMaterialsType[]) getChildren(new LibraryPhysicsMaterialsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_materials"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_materials_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryPhysicsMaterials;
    }

    public LibraryAnimationsType[] getLibraryAnimations()
        throws IOException
    {
        if (libraryAnimations == null) {
            try {
                libraryAnimations = ((LibraryAnimationsType[]) getChildren(new LibraryAnimationsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animations"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animations_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryAnimations;
    }

    public LibraryForceFieldsType[] getLibraryForceFields()
        throws IOException
    {
        if (libraryForceFields == null) {
            try {
                libraryForceFields = ((LibraryForceFieldsType[]) getChildren(new LibraryForceFieldsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_force_fields"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_force_fields_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryForceFields;
    }

    public LibraryImagesType[] getLibraryImages()
        throws IOException
    {
        if (libraryImages == null) {
            try {
                libraryImages = ((LibraryImagesType[]) getChildren(new LibraryImagesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_images"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_images_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryImages;
    }

    public LibraryVisualScenesType[] getLibraryVisualScenes()
        throws IOException
    {
        if (libraryVisualScenes == null) {
            try {
                libraryVisualScenes = ((LibraryVisualScenesType[]) getChildren(new LibraryVisualScenesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_visual_scenes"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_visual_scenes_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryVisualScenes;
    }

    public COLLADAGroupScene getScene()
        throws IOException
    {
        if (scene == null) {
            try {
                scene = ((COLLADAGroupScene) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "scene"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "COLLADA/group/scene"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scene;
    }

    public LibraryLightsType[] getLibraryLights()
        throws IOException
    {
        if (libraryLights == null) {
            try {
                libraryLights = ((LibraryLightsType[]) getChildren(new LibraryLightsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_lights"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_lights_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryLights;
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public LibraryJointsType[] getLibraryJoints()
        throws IOException
    {
        if (libraryJoints == null) {
            try {
                libraryJoints = ((LibraryJointsType[]) getChildren(new LibraryJointsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_joints"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_joints_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryJoints;
    }

    public LibraryAnimationClipsType[] getLibraryAnimationClips()
        throws IOException
    {
        if (libraryAnimationClips == null) {
            try {
                libraryAnimationClips = ((LibraryAnimationClipsType[]) getChildren(new LibraryAnimationClipsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animation_clips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_animation_clips_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryAnimationClips;
    }

    public LibraryKinematicsModelsType[] getLibraryKinematicsModels()
        throws IOException
    {
        if (libraryKinematicsModels == null) {
            try {
                libraryKinematicsModels = ((LibraryKinematicsModelsType[]) getChildren(new LibraryKinematicsModelsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_models"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_models_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryKinematicsModels;
    }

    public LibraryControllersType[] getLibraryControllers()
        throws IOException
    {
        if (libraryControllers == null) {
            try {
                libraryControllers = ((LibraryControllersType[]) getChildren(new LibraryControllersType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_controllers"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_controllers_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryControllers;
    }

    public LibraryGeometriesType[] getLibraryGeometries()
        throws IOException
    {
        if (libraryGeometries == null) {
            try {
                libraryGeometries = ((LibraryGeometriesType[]) getChildren(new LibraryGeometriesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_geometries"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_geometries_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryGeometries;
    }

    public LibraryKinematicsScenesType[] getLibraryKinematicsScenes()
        throws IOException
    {
        if (libraryKinematicsScenes == null) {
            try {
                libraryKinematicsScenes = ((LibraryKinematicsScenesType[]) getChildren(new LibraryKinematicsScenesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_scenes"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_kinematics_scenes_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryKinematicsScenes;
    }

    public AssetType[] getAsset()
        throws IOException
    {
        if (asset == null) {
            try {
                asset = ((AssetType[]) getChildren(new AssetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return asset;
    }

    public LibraryNodesType[] getLibraryNodes()
        throws IOException
    {
        if (libraryNodes == null) {
            try {
                libraryNodes = ((LibraryNodesType[]) getChildren(new LibraryNodesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_nodes"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_nodes_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryNodes;
    }

    public LibraryMaterialsType[] getLibraryMaterials()
        throws IOException
    {
        if (libraryMaterials == null) {
            try {
                libraryMaterials = ((LibraryMaterialsType[]) getChildren(new LibraryMaterialsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_materials"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_materials_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryMaterials;
    }

    public LibraryCamerasType[] getLibraryCameras()
        throws IOException
    {
        if (libraryCameras == null) {
            try {
                libraryCameras = ((LibraryCamerasType[]) getChildren(new LibraryCamerasType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_cameras"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_cameras_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryCameras;
    }

    public LibraryPhysicsModelsType[] getLibraryPhysicsModels()
        throws IOException
    {
        if (libraryPhysicsModels == null) {
            try {
                libraryPhysicsModels = ((LibraryPhysicsModelsType[]) getChildren(new LibraryPhysicsModelsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_models"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "library_physics_models_type"), COLLADA.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return libraryPhysicsModels;
    }

}
