
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class EffectType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((asset[ ]+){0,1}(annotate[ ]+){0,}(newparam[ ]+){0,}(((profile_COMMON[ ]+){1}|(profile_BRIDGE[ ]+){1}|(profile_GLES2[ ]+){1}|(profile_GLSL[ ]+){1}|(profile_CG[ ]+){1}|(profile_GLES[ ]+){1}){0,1}){1,}(extra[ ]+){0,}){1}";
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
    protected ProfileGlesType[] profileGLES;
    protected FxAnnotateType[] annotate;
    protected ProfileBridgeType[] profileBRIDGE;
    protected ProfileCgType[] profileCG;
    protected ProfileGles2Type[] profileGLES2;
    protected ProfileGlslType[] profileGLSL;
    protected AssetType asset;
    protected ProfileCommonType[] profileCOMMON;
    protected FxNewparamType[] newparam;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLES"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLES"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_gles_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLES"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_BRIDGE"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_BRIDGE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_bridge_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_BRIDGE"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_CG"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_CG"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_cg_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_CG"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLES2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLES2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_gles2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLES2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLSL"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLSL"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_glsl_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLSL"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_COMMON"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_COMMON"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_COMMON"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_newparam_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("id");
        REQUIRED_ATTRIBUTES.add("id");
    }

    public EffectType(XmlComplexType elem) {
        super(elem, EffectType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public ProfileGlesType[] getProfileGLES()
        throws IOException
    {
        if (profileGLES == null) {
            try {
                profileGLES = ((ProfileGlesType[]) getChildren(new ProfileGlesType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLES"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_gles_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return profileGLES;
    }

    public FxAnnotateType[] getAnnotate()
        throws IOException
    {
        if (annotate == null) {
            try {
                annotate = ((FxAnnotateType[]) getChildren(new FxAnnotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return annotate;
    }

    public ProfileBridgeType[] getProfileBRIDGE()
        throws IOException
    {
        if (profileBRIDGE == null) {
            try {
                profileBRIDGE = ((ProfileBridgeType[]) getChildren(new ProfileBridgeType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_BRIDGE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_bridge_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return profileBRIDGE;
    }

    public ProfileCgType[] getProfileCG()
        throws IOException
    {
        if (profileCG == null) {
            try {
                profileCG = ((ProfileCgType[]) getChildren(new ProfileCgType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_CG"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_cg_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return profileCG;
    }

    public ProfileGles2Type[] getProfileGLES2()
        throws IOException
    {
        if (profileGLES2 == null) {
            try {
                profileGLES2 = ((ProfileGles2Type[]) getChildren(new ProfileGles2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLES2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_gles2_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return profileGLES2;
    }

    public ProfileGlslType[] getProfileGLSL()
        throws IOException
    {
        if (profileGLSL == null) {
            try {
                profileGLSL = ((ProfileGlslType[]) getChildren(new ProfileGlslType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_GLSL"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_glsl_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return profileGLSL;
    }

    public AssetType getAsset()
        throws IOException
    {
        if (asset == null) {
            try {
                asset = ((AssetType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return asset;
    }

    public ProfileCommonType[] getProfileCOMMON()
        throws IOException
    {
        if (profileCOMMON == null) {
            try {
                profileCOMMON = ((ProfileCommonType[]) getChildren(new ProfileCommonType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_COMMON"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return profileCOMMON;
    }

    public FxNewparamType[] getNewparam()
        throws IOException
    {
        if (newparam == null) {
            try {
                newparam = ((FxNewparamType[]) getChildren(new FxNewparamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_newparam_type"), EffectType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return newparam;
    }

}
