
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
import SimpleTypes.GlEnumerationType;
import SimpleTypes.Int2Type;
import SimpleTypes.Int3Type;
import SimpleTypes.Int4Type;
import SimpleTypes.IntType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlBoolean;

public final class Gles2ValueGroupGroupUsertypeGroupSetparam
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((bool[ ]+){1}|(bvec2[ ]+){1}|(bvec3[ ]+){1}|(bvec4[ ]+){1}|(float[ ]+){1}|(vec2[ ]+){1}|(vec3[ ]+){1}|(vec4[ ]+){1}|(mat2[ ]+){1}|(mat3[ ]+){1}|(mat4[ ]+){1}|(int[ ]+){1}|(ivec2[ ]+){1}|(ivec3[ ]+){1}|(ivec4[ ]+){1}|(enum[ ]+){1}|(sampler2D[ ]+){1}|(sampler3D[ ]+){1}|(samplerCUBE[ ]+){1}|(samplerDEPTH[ ]+){1}|(usertype[ ]+){1}|(array[ ]+){1}){0,1}){0,}){1}";
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
    protected FxSamplerDEPTHType[] samplerDEPTH;
    protected Gles2ValueGroupGroupUsertype[] usertype;
    protected Float4x4Type[] mat4;
    protected GlEnumerationType[] enumValue;
    protected FxSampler3DType[] sampler3D;
    protected Float2x2Type[] mat2;
    protected Float3x3Type[] mat3;
    protected FloatType[] floatValue;
    protected Float4Type[] vec4;
    protected Int3Type[] ivec3;
    protected Int4Type[] ivec4;
    protected Float2Type[] vec2;
    protected Bool4Type[] bvec4;
    protected Float3Type[] vec3;
    protected Int2Type[] ivec2;
    protected IntType[] intValue;
    protected FxSamplerCUBEType[] samplerCUBE;
    protected Gles2ValueGroupGroupArray[] array;
    protected FxSampler2DType[] sampler2D;
    protected Bool3Type[] bvec3;
    protected XmlBoolean[] bool;
    protected Bool2Type[] bvec2;

    static {
        ALLOWED_ATTRIBUTES.add("ref");
        REQUIRED_ATTRIBUTES.add("ref");
        try {
            ATTRIBUTES_NAME_MAP.put("ref", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerDEPTH_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_value_group/group/usertype"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_enumeration_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler3D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerCUBE_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_value_group/group/array"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler2D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public Gles2ValueGroupGroupUsertypeGroupSetparam(XmlComplexType elem) {
        super(elem, Gles2ValueGroupGroupUsertypeGroupSetparam.class);
    }

    public FxSamplerDEPTHType[] getSamplerDEPTH()
        throws IOException
    {
        if (samplerDEPTH == null) {
            try {
                samplerDEPTH = ((FxSamplerDEPTHType[]) getChildren(new FxSamplerDEPTHType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerDEPTH_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerDEPTH;
    }

    public Gles2ValueGroupGroupUsertype[] getUsertype()
        throws IOException
    {
        if (usertype == null) {
            try {
                usertype = ((Gles2ValueGroupGroupUsertype[]) getChildren(new Gles2ValueGroupGroupUsertype[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_value_group/group/usertype"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return usertype;
    }

    public Float4x4Type[] getMat4()
        throws IOException
    {
        if (mat4 == null) {
            try {
                mat4 = ((Float4x4Type[]) getChildren(new Float4x4Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mat4;
    }

    public GlEnumerationType[] getEnumValue()
        throws IOException
    {
        if (enumValue == null) {
            try {
                enumValue = ((GlEnumerationType[]) getChildren(new GlEnumerationType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_enumeration_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return enumValue;
    }

    public FxSampler3DType[] getSampler3D()
        throws IOException
    {
        if (sampler3D == null) {
            try {
                sampler3D = ((FxSampler3DType[]) getChildren(new FxSampler3DType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler3D_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler3D;
    }

    public Float2x2Type[] getMat2()
        throws IOException
    {
        if (mat2 == null) {
            try {
                mat2 = ((Float2x2Type[]) getChildren(new Float2x2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mat2;
    }

    public Float3x3Type[] getMat3()
        throws IOException
    {
        if (mat3 == null) {
            try {
                mat3 = ((Float3x3Type[]) getChildren(new Float3x3Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mat3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mat3;
    }

    public FloatType[] getFloatValue()
        throws IOException
    {
        if (floatValue == null) {
            try {
                floatValue = ((FloatType[]) getChildren(new FloatType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return floatValue;
    }

    public Float4Type[] getVec4()
        throws IOException
    {
        if (vec4 == null) {
            try {
                vec4 = ((Float4Type[]) getChildren(new Float4Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vec4;
    }

    public Int3Type[] getIvec3()
        throws IOException
    {
        if (ivec3 == null) {
            try {
                ivec3 = ((Int3Type[]) getChildren(new Int3Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ivec3;
    }

    public Int4Type[] getIvec4()
        throws IOException
    {
        if (ivec4 == null) {
            try {
                ivec4 = ((Int4Type[]) getChildren(new Int4Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ivec4;
    }

    public Float2Type[] getVec2()
        throws IOException
    {
        if (vec2 == null) {
            try {
                vec2 = ((Float2Type[]) getChildren(new Float2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vec2;
    }

    public Bool4Type[] getBvec4()
        throws IOException
    {
        if (bvec4 == null) {
            try {
                bvec4 = ((Bool4Type[]) getChildren(new Bool4Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bvec4;
    }

    public Float3Type[] getVec3()
        throws IOException
    {
        if (vec3 == null) {
            try {
                vec3 = ((Float3Type[]) getChildren(new Float3Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "vec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vec3;
    }

    public Int2Type[] getIvec2()
        throws IOException
    {
        if (ivec2 == null) {
            try {
                ivec2 = ((Int2Type[]) getChildren(new Int2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "ivec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ivec2;
    }

    public IntType[] getIntValue()
        throws IOException
    {
        if (intValue == null) {
            try {
                intValue = ((IntType[]) getChildren(new IntType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intValue;
    }

    public FxSamplerCUBEType[] getSamplerCUBE()
        throws IOException
    {
        if (samplerCUBE == null) {
            try {
                samplerCUBE = ((FxSamplerCUBEType[]) getChildren(new FxSamplerCUBEType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerCUBE_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerCUBE;
    }

    public Gles2ValueGroupGroupArray[] getArray()
        throws IOException
    {
        if (array == null) {
            try {
                array = ((Gles2ValueGroupGroupArray[]) getChildren(new Gles2ValueGroupGroupArray[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_value_group/group/array"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return array;
    }

    public FxSampler2DType[] getSampler2D()
        throws IOException
    {
        if (sampler2D == null) {
            try {
                sampler2D = ((FxSampler2DType[]) getChildren(new FxSampler2DType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler2D_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler2D;
    }

    public Bool3Type[] getBvec3()
        throws IOException
    {
        if (bvec3 == null) {
            try {
                bvec3 = ((Bool3Type[]) getChildren(new Bool3Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bvec3;
    }

    public XmlBoolean[] getBool()
        throws IOException
    {
        if (bool == null) {
            try {
                bool = ((XmlBoolean[]) getChildren(new XmlBoolean[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool;
    }

    public Bool2Type[] getBvec2()
        throws IOException
    {
        if (bvec2 == null) {
            try {
                bvec2 = ((Bool2Type[]) getChildren(new Bool2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bvec2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"), Gles2ValueGroupGroupUsertypeGroupSetparam.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bvec2;
    }

}
