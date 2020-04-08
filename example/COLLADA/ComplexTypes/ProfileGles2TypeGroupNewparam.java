
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.Bool2Type;
import SimpleTypes.Bool3Type;
import SimpleTypes.Bool4Type;
import SimpleTypes.Float2Type;
import SimpleTypes.Float2x2Type;
import SimpleTypes.Float3Type;
import SimpleTypes.Float3x3Type;
import SimpleTypes.Float4Type;
import SimpleTypes.Float4x4Type;
import SimpleTypes.FloatType;
import SimpleTypes.FxModifierEnum;
import SimpleTypes.GlEnumerationType;
import SimpleTypes.Int2Type;
import SimpleTypes.Int3Type;
import SimpleTypes.Int4Type;
import SimpleTypes.IntType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlBoolean;
import XmlSimpleTypes.XmlNCName;

public final class ProfileGles2TypeGroupNewparam
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((annotate[ ]+){0,}(semantic[ ]+){0,1}(modifier[ ]+){0,1}(((bool[ ]+){1}|(bvec2[ ]+){1}|(bvec3[ ]+){1}|(bvec4[ ]+){1}|(float[ ]+){1}|(vec2[ ]+){1}|(vec3[ ]+){1}|(vec4[ ]+){1}|(mat2[ ]+){1}|(mat3[ ]+){1}|(mat4[ ]+){1}|(int[ ]+){1}|(ivec2[ ]+){1}|(ivec3[ ]+){1}|(ivec4[ ]+){1}|(enum[ ]+){1}|(sampler2D[ ]+){1}|(sampler3D[ ]+){1}|(samplerCUBE[ ]+){1}|(samplerDEPTH[ ]+){1}|(usertype[ ]+){1}|(array[ ]+){1}){0,1}){1}){1})(())";
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
    protected FxSamplerDEPTHType samplerDEPTH;
    protected XmlNCName semantic;
    protected Float4Type vec4;
    protected FxModifierEnum modifier;
    protected Float2Type vec2;
    protected Bool4Type bvec4;
    protected Float3Type vec3;
    protected FxAnnotateType[] annotate;
    protected FxSamplerCUBEType samplerCUBE;
    protected Gles2ValueGroupGroupArray array;
    protected Bool3Type bvec3;
    protected XmlBoolean bool;
    protected Bool2Type bvec2;
    protected Gles2ValueGroupGroupUsertype usertype;
    protected Float4x4Type mat4;
    protected GlEnumerationType enumValue;
    protected FxSampler3DType sampler3D;
    protected Float2x2Type mat2;
    protected Float3x3Type mat3;
    protected FloatType floatValue;
    protected Int3Type ivec3;
    protected Int4Type ivec4;
    protected Int2Type ivec2;
    protected IntType intValue;
    protected FxSampler2DType sampler2D;

    static {
        ALLOWED_ATTRIBUTES.add("sid");
        REQUIRED_ATTRIBUTES.add("sid");
        try {
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerDEPTH_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_modifier_enum"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerCUBE_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_value_group/group/array"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_value_group/group/usertype"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_enumeration_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler3D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler2D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ProfileGles2TypeGroupNewparam(XmlComplexType elem) {
        super(elem, ProfileGles2TypeGroupNewparam.class);
    }

    public FxSamplerDEPTHType getSamplerDEPTH()
        throws IOException
    {
        if (samplerDEPTH == null) {
            try {
                samplerDEPTH = ((FxSamplerDEPTHType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerDEPTH_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerDEPTH;
    }

    public XmlNCName getSemantic()
        throws IOException
    {
        if (semantic == null) {
            try {
                semantic = ((XmlNCName) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return semantic;
    }

    public Float4Type getVec4()
        throws IOException
    {
        if (vec4 == null) {
            try {
                vec4 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vec4;
    }

    public FxModifierEnum getModifier()
        throws IOException
    {
        if (modifier == null) {
            try {
                modifier = ((FxModifierEnum) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_modifier_enum"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return modifier;
    }

    public Float2Type getVec2()
        throws IOException
    {
        if (vec2 == null) {
            try {
                vec2 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vec2;
    }

    public Bool4Type getBvec4()
        throws IOException
    {
        if (bvec4 == null) {
            try {
                bvec4 = ((Bool4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bvec4;
    }

    public Float3Type getVec3()
        throws IOException
    {
        if (vec3 == null) {
            try {
                vec3 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vec3;
    }

    public FxAnnotateType[] getAnnotate()
        throws IOException
    {
        if (annotate == null) {
            try {
                annotate = ((FxAnnotateType[]) getChildren(new FxAnnotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return annotate;
    }

    public FxSamplerCUBEType getSamplerCUBE()
        throws IOException
    {
        if (samplerCUBE == null) {
            try {
                samplerCUBE = ((FxSamplerCUBEType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerCUBE_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerCUBE;
    }

    public Gles2ValueGroupGroupArray getArray()
        throws IOException
    {
        if (array == null) {
            try {
                array = ((Gles2ValueGroupGroupArray) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_value_group/group/array"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return array;
    }

    public Bool3Type getBvec3()
        throws IOException
    {
        if (bvec3 == null) {
            try {
                bvec3 = ((Bool3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bvec3;
    }

    public XmlBoolean getBool()
        throws IOException
    {
        if (bool == null) {
            try {
                bool = ((XmlBoolean) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool;
    }

    public Bool2Type getBvec2()
        throws IOException
    {
        if (bvec2 == null) {
            try {
                bvec2 = ((Bool2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bvec2;
    }

    public Gles2ValueGroupGroupUsertype getUsertype()
        throws IOException
    {
        if (usertype == null) {
            try {
                usertype = ((Gles2ValueGroupGroupUsertype) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_value_group/group/usertype"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return usertype;
    }

    public Float4x4Type getMat4()
        throws IOException
    {
        if (mat4 == null) {
            try {
                mat4 = ((Float4x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mat4;
    }

    public GlEnumerationType getEnumValue()
        throws IOException
    {
        if (enumValue == null) {
            try {
                enumValue = ((GlEnumerationType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_enumeration_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return enumValue;
    }

    public FxSampler3DType getSampler3D()
        throws IOException
    {
        if (sampler3D == null) {
            try {
                sampler3D = ((FxSampler3DType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler3D_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler3D;
    }

    public Float2x2Type getMat2()
        throws IOException
    {
        if (mat2 == null) {
            try {
                mat2 = ((Float2x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mat2;
    }

    public Float3x3Type getMat3()
        throws IOException
    {
        if (mat3 == null) {
            try {
                mat3 = ((Float3x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mat3;
    }

    public FloatType getFloatValue()
        throws IOException
    {
        if (floatValue == null) {
            try {
                floatValue = ((FloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return floatValue;
    }

    public Int3Type getIvec3()
        throws IOException
    {
        if (ivec3 == null) {
            try {
                ivec3 = ((Int3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ivec3;
    }

    public Int4Type getIvec4()
        throws IOException
    {
        if (ivec4 == null) {
            try {
                ivec4 = ((Int4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ivec4;
    }

    public Int2Type getIvec2()
        throws IOException
    {
        if (ivec2 == null) {
            try {
                ivec2 = ((Int2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ivec2;
    }

    public IntType getIntValue()
        throws IOException
    {
        if (intValue == null) {
            try {
                intValue = ((IntType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intValue;
    }

    public FxSampler2DType getSampler2D()
        throws IOException
    {
        if (sampler2D == null) {
            try {
                sampler2D = ((FxSampler2DType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler2D_type"), ProfileGles2TypeGroupNewparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler2D;
    }

}
