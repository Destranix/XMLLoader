
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

public final class GlslArrayType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((bool[ ]+){1}|(bool2[ ]+){1}|(bool3[ ]+){1}|(bool4[ ]+){1}|(float[ ]+){1}|(float2[ ]+){1}|(float3[ ]+){1}|(float4[ ]+){1}|(float2x2[ ]+){1}|(float3x3[ ]+){1}|(float4x4[ ]+){1}|(int[ ]+){1}|(int2[ ]+){1}|(int3[ ]+){1}|(int4[ ]+){1}|(sampler1D[ ]+){1}|(sampler2D[ ]+){1}|(sampler3D[ ]+){1}|(samplerCUBE[ ]+){1}|(samplerRECT[ ]+){1}|(samplerDEPTH[ ]+){1}|(enum[ ]+){1}|(array[ ]+){1}){0,1}){1,}){1}";
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
    protected Bool4Type[] bool4;
    protected GlEnumerationType[] enumValue;
    protected FxSampler3DType[] sampler3D;
    protected FloatType[] floatValue;
    protected Float4Type[] float4;
    protected Float3Type[] float3;
    protected Float2Type[] float2;
    protected FxSamplerRECTType[] samplerRECT;
    protected Float4x4Type[] float4x4;
    protected IntType[] intValue;
    protected FxSamplerCUBEType[] samplerCUBE;
    protected GlslArrayType[] array;
    protected Bool2Type[] bool2;
    protected Float3x3Type[] float3x3;
    protected FxSampler2DType[] sampler2D;
    protected Bool3Type[] bool3;
    protected FxSampler1DType[] sampler1D;
    protected Float2x2Type[] float2x2;
    protected Int2Type[] int2;
    protected Int3Type[] int3;
    protected Int4Type[] int4;
    protected XmlBoolean[] bool;

    static {
        ALLOWED_ATTRIBUTES.add("length");
        REQUIRED_ATTRIBUTES.add("length");
        try {
            ATTRIBUTES_NAME_MAP.put("length", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "positiveInteger"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerDEPTH_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_enumeration_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler3D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerRECT_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerCUBE_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "glsl_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler2D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler1D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlslArrayType(XmlComplexType elem) {
        super(elem, GlslArrayType.class);
    }

    public FxSamplerDEPTHType[] getSamplerDEPTH()
        throws IOException
    {
        if (samplerDEPTH == null) {
            try {
                samplerDEPTH = ((FxSamplerDEPTHType[]) getChildren(new FxSamplerDEPTHType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerDEPTH_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerDEPTH;
    }

    public Bool4Type[] getBool4()
        throws IOException
    {
        if (bool4 == null) {
            try {
                bool4 = ((Bool4Type[]) getChildren(new Bool4Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool4;
    }

    public GlEnumerationType[] getEnumValue()
        throws IOException
    {
        if (enumValue == null) {
            try {
                enumValue = ((GlEnumerationType[]) getChildren(new GlEnumerationType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_enumeration_type"), GlslArrayType.class));
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
                sampler3D = ((FxSampler3DType[]) getChildren(new FxSampler3DType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler3D_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler3D;
    }

    public FloatType[] getFloatValue()
        throws IOException
    {
        if (floatValue == null) {
            try {
                floatValue = ((FloatType[]) getChildren(new FloatType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return floatValue;
    }

    public Float4Type[] getFloat4()
        throws IOException
    {
        if (float4 == null) {
            try {
                float4 = ((Float4Type[]) getChildren(new Float4Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4;
    }

    public Float3Type[] getFloat3()
        throws IOException
    {
        if (float3 == null) {
            try {
                float3 = ((Float3Type[]) getChildren(new Float3Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3;
    }

    public Float2Type[] getFloat2()
        throws IOException
    {
        if (float2 == null) {
            try {
                float2 = ((Float2Type[]) getChildren(new Float2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2;
    }

    public FxSamplerRECTType[] getSamplerRECT()
        throws IOException
    {
        if (samplerRECT == null) {
            try {
                samplerRECT = ((FxSamplerRECTType[]) getChildren(new FxSamplerRECTType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerRECT_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerRECT;
    }

    public Float4x4Type[] getFloat4x4()
        throws IOException
    {
        if (float4x4 == null) {
            try {
                float4x4 = ((Float4x4Type[]) getChildren(new Float4x4Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x4;
    }

    public IntType[] getIntValue()
        throws IOException
    {
        if (intValue == null) {
            try {
                intValue = ((IntType[]) getChildren(new IntType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"), GlslArrayType.class));
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
                samplerCUBE = ((FxSamplerCUBEType[]) getChildren(new FxSamplerCUBEType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerCUBE_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerCUBE;
    }

    public GlslArrayType[] getArray()
        throws IOException
    {
        if (array == null) {
            try {
                array = ((GlslArrayType[]) getChildren(new GlslArrayType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "glsl_array_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return array;
    }

    public Bool2Type[] getBool2()
        throws IOException
    {
        if (bool2 == null) {
            try {
                bool2 = ((Bool2Type[]) getChildren(new Bool2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool2;
    }

    public Float3x3Type[] getFloat3x3()
        throws IOException
    {
        if (float3x3 == null) {
            try {
                float3x3 = ((Float3x3Type[]) getChildren(new Float3x3Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x3;
    }

    public FxSampler2DType[] getSampler2D()
        throws IOException
    {
        if (sampler2D == null) {
            try {
                sampler2D = ((FxSampler2DType[]) getChildren(new FxSampler2DType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler2D_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler2D;
    }

    public Bool3Type[] getBool3()
        throws IOException
    {
        if (bool3 == null) {
            try {
                bool3 = ((Bool3Type[]) getChildren(new Bool3Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool3;
    }

    public FxSampler1DType[] getSampler1D()
        throws IOException
    {
        if (sampler1D == null) {
            try {
                sampler1D = ((FxSampler1DType[]) getChildren(new FxSampler1DType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler1D_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler1D;
    }

    public Float2x2Type[] getFloat2x2()
        throws IOException
    {
        if (float2x2 == null) {
            try {
                float2x2 = ((Float2x2Type[]) getChildren(new Float2x2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x2;
    }

    public Int2Type[] getInt2()
        throws IOException
    {
        if (int2 == null) {
            try {
                int2 = ((Int2Type[]) getChildren(new Int2Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int2;
    }

    public Int3Type[] getInt3()
        throws IOException
    {
        if (int3 == null) {
            try {
                int3 = ((Int3Type[]) getChildren(new Int3Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int3;
    }

    public Int4Type[] getInt4()
        throws IOException
    {
        if (int4 == null) {
            try {
                int4 = ((Int4Type[]) getChildren(new Int4Type[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int4;
    }

    public XmlBoolean[] getBool()
        throws IOException
    {
        if (bool == null) {
            try {
                bool = ((XmlBoolean[]) getChildren(new XmlBoolean[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"), GlslArrayType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool;
    }

}
