
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.Bool2Type;
import SimpleTypes.Bool2x2Type;
import SimpleTypes.Bool2x3Type;
import SimpleTypes.Bool2x4Type;
import SimpleTypes.Bool3Type;
import SimpleTypes.Bool3x2Type;
import SimpleTypes.Bool3x3Type;
import SimpleTypes.Bool3x4Type;
import SimpleTypes.Bool4Type;
import SimpleTypes.Bool4x2Type;
import SimpleTypes.Bool4x3Type;
import SimpleTypes.Bool4x4Type;
import SimpleTypes.Float2Type;
import SimpleTypes.Float2x2Type;
import SimpleTypes.Float2x3Type;
import SimpleTypes.Float2x4Type;
import SimpleTypes.Float3Type;
import SimpleTypes.Float3x2Type;
import SimpleTypes.Float3x3Type;
import SimpleTypes.Float3x4Type;
import SimpleTypes.Float4Type;
import SimpleTypes.Float4x2Type;
import SimpleTypes.Float4x3Type;
import SimpleTypes.Float4x4Type;
import SimpleTypes.FloatType;
import SimpleTypes.FxModifierEnum;
import SimpleTypes.GlEnumerationType;
import SimpleTypes.Int2Type;
import SimpleTypes.Int2x2Type;
import SimpleTypes.Int2x3Type;
import SimpleTypes.Int2x4Type;
import SimpleTypes.Int3Type;
import SimpleTypes.Int3x2Type;
import SimpleTypes.Int3x3Type;
import SimpleTypes.Int3x4Type;
import SimpleTypes.Int4Type;
import SimpleTypes.Int4x2Type;
import SimpleTypes.Int4x3Type;
import SimpleTypes.Int4x4Type;
import SimpleTypes.IntType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlBoolean;
import XmlSimpleTypes.XmlNCName;
import XmlSimpleTypes.XmlString;

public final class CgNewparamType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((annotate[ ]+){0,}(semantic[ ]+){0,1}(modifier[ ]+){0,1}(((bool[ ]+){1}|(bool2[ ]+){1}|(bool3[ ]+){1}|(bool4[ ]+){1}|(bool2x1[ ]+){1}|(bool2x2[ ]+){1}|(bool2x3[ ]+){1}|(bool2x4[ ]+){1}|(bool3x1[ ]+){1}|(bool3x2[ ]+){1}|(bool3x3[ ]+){1}|(bool3x4[ ]+){1}|(bool4x1[ ]+){1}|(bool4x2[ ]+){1}|(bool4x3[ ]+){1}|(bool4x4[ ]+){1}|(float[ ]+){1}|(float2[ ]+){1}|(float3[ ]+){1}|(float4[ ]+){1}|(float2x1[ ]+){1}|(float2x2[ ]+){1}|(float2x3[ ]+){1}|(float2x4[ ]+){1}|(float3x1[ ]+){1}|(float3x2[ ]+){1}|(float3x3[ ]+){1}|(float3x4[ ]+){1}|(float4x1[ ]+){1}|(float4x2[ ]+){1}|(float4x3[ ]+){1}|(float4x4[ ]+){1}|(int[ ]+){1}|(int2[ ]+){1}|(int3[ ]+){1}|(int4[ ]+){1}|(int2x1[ ]+){1}|(int2x2[ ]+){1}|(int2x3[ ]+){1}|(int2x4[ ]+){1}|(int3x1[ ]+){1}|(int3x2[ ]+){1}|(int3x3[ ]+){1}|(int3x4[ ]+){1}|(int4x1[ ]+){1}|(int4x2[ ]+){1}|(int4x3[ ]+){1}|(int4x4[ ]+){1}|(half[ ]+){1}|(half2[ ]+){1}|(half3[ ]+){1}|(half4[ ]+){1}|(half2x1[ ]+){1}|(half2x2[ ]+){1}|(half2x3[ ]+){1}|(half2x4[ ]+){1}|(half3x1[ ]+){1}|(half3x2[ ]+){1}|(half3x3[ ]+){1}|(half3x4[ ]+){1}|(half4x1[ ]+){1}|(half4x2[ ]+){1}|(half4x3[ ]+){1}|(half4x4[ ]+){1}|(fixed[ ]+){1}|(fixed2[ ]+){1}|(fixed3[ ]+){1}|(fixed4[ ]+){1}|(fixed2x1[ ]+){1}|(fixed2x2[ ]+){1}|(fixed2x3[ ]+){1}|(fixed2x4[ ]+){1}|(fixed3x1[ ]+){1}|(fixed3x2[ ]+){1}|(fixed3x3[ ]+){1}|(fixed3x4[ ]+){1}|(fixed4x1[ ]+){1}|(fixed4x2[ ]+){1}|(fixed4x3[ ]+){1}|(fixed4x4[ ]+){1}|(sampler1D[ ]+){1}|(sampler2D[ ]+){1}|(sampler3D[ ]+){1}|(samplerRECT[ ]+){1}|(samplerCUBE[ ]+){1}|(samplerDEPTH[ ]+){1}|(string[ ]+){1}|(enum[ ]+){1}|(array[ ]+){1}|(usertype[ ]+){1}){0,1}){1}){1}";
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
    protected Float3Type half3;
    protected Float4Type half4;
    protected Float2Type half2;
    protected Bool4Type bool4;
    protected Int3x4Type int3x4;
    protected FloatType half;
    protected Int3x3Type int3x3;
    protected Int3x2Type int3x2;
    protected Int3Type int3x1;
    protected Float3x4Type half3x4;
    protected Float3x2Type half3x2;
    protected Float3x3Type half3x3;
    protected Bool2x4Type bool2x4;
    protected Bool4x2Type bool4x2;
    protected Bool4x3Type bool4x3;
    protected FxModifierEnum modifier;
    protected Bool2x2Type bool2x2;
    protected Bool2x3Type bool2x3;
    protected Bool4Type bool4x1;
    protected FxAnnotateType[] annotate;
    protected Bool2Type bool2;
    protected Bool4x4Type bool4x4;
    protected Float3x3Type float3x3;
    protected Float3Type fixed3x1;
    protected Bool3Type bool3;
    protected Float3x4Type float3x4;
    protected Float3x2Type fixed3x2;
    protected FxSampler1DType sampler1D;
    protected Float3Type float3x1;
    protected Float3x2Type float3x2;
    protected Int2Type int2;
    protected Int3Type int3;
    protected Int4Type int4;
    protected Bool2Type bool2x1;
    protected Float3x3Type fixed3x3;
    protected Float3x4Type fixed3x4;
    protected Float4Type float4;
    protected Float3Type float3;
    protected Float2Type float2;
    protected FxSamplerRECTType samplerRECT;
    protected Float2Type half2x1;
    protected Float2x2Type half2x2;
    protected IntType intValue;
    protected XmlString string;
    protected FxSamplerDEPTHType samplerDEPTH;
    protected Int4x4Type int4x4;
    protected Float3Type fixed3;
    protected Int4x3Type int4x3;
    protected Float2Type fixed2;
    protected XmlNCName semantic;
    protected Int2x4Type int2x4;
    protected Int4x2Type int4x2;
    protected Int2x3Type int2x3;
    protected Int4Type int4x1;
    protected Float4Type fixed4;
    protected Int2x2Type int2x2;
    protected Float4x3Type half4x3;
    protected Int2Type int2x1;
    protected Float4x4Type half4x4;
    protected Float2x3Type half2x3;
    protected Float4Type half4x1;
    protected Float2x4Type half2x4;
    protected Float4x2Type half4x2;
    protected Bool3x3Type bool3x3;
    protected Bool3x4Type bool3x4;
    protected Bool3Type bool3x1;
    protected Bool3x2Type bool3x2;
    protected Float4x4Type float4x4;
    protected FxSamplerCUBEType samplerCUBE;
    protected CgArrayType array;
    protected Float2Type fixed2x1;
    protected Float2x4Type float2x4;
    protected Float4x2Type float4x2;
    protected Float2x2Type fixed2x2;
    protected Float4x3Type float4x3;
    protected Float2x3Type fixed2x3;
    protected Float4Type fixed4x1;
    protected Float2x2Type float2x2;
    protected Float2x3Type float2x3;
    protected Float4Type float4x1;
    protected Float2Type float2x1;
    protected XmlBoolean bool;
    protected CgUserType usertype;
    protected Float2x4Type fixed2x4;
    protected Float4x2Type fixed4x2;
    protected GlEnumerationType enumValue;
    protected Float4x3Type fixed4x3;
    protected FxSampler3DType sampler3D;
    protected Float4x4Type fixed4x4;
    protected FloatType floatValue;
    protected Float3Type half3x1;
    protected FloatType fixed;
    protected FxSampler2DType sampler2D;

    static {
        ALLOWED_ATTRIBUTES.add("sid");
        REQUIRED_ATTRIBUTES.add("sid");
        try {
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_modifier_enum"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler1D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerRECT_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerDEPTH_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerCUBE_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_user_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_enumeration_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler3D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler2D_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public CgNewparamType(XmlComplexType elem) {
        super(elem, CgNewparamType.class);
    }

    public Float3Type getHalf3()
        throws IOException
    {
        if (half3 == null) {
            try {
                half3 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half3;
    }

    public Float4Type getHalf4()
        throws IOException
    {
        if (half4 == null) {
            try {
                half4 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half4;
    }

    public Float2Type getHalf2()
        throws IOException
    {
        if (half2 == null) {
            try {
                half2 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half2;
    }

    public Bool4Type getBool4()
        throws IOException
    {
        if (bool4 == null) {
            try {
                bool4 = ((Bool4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool4;
    }

    public Int3x4Type getInt3x4()
        throws IOException
    {
        if (int3x4 == null) {
            try {
                int3x4 = ((Int3x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int3x4;
    }

    public FloatType getHalf()
        throws IOException
    {
        if (half == null) {
            try {
                half = ((FloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half;
    }

    public Int3x3Type getInt3x3()
        throws IOException
    {
        if (int3x3 == null) {
            try {
                int3x3 = ((Int3x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int3x3;
    }

    public Int3x2Type getInt3x2()
        throws IOException
    {
        if (int3x2 == null) {
            try {
                int3x2 = ((Int3x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int3x2;
    }

    public Int3Type getInt3x1()
        throws IOException
    {
        if (int3x1 == null) {
            try {
                int3x1 = ((Int3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int3x1;
    }

    public Float3x4Type getHalf3x4()
        throws IOException
    {
        if (half3x4 == null) {
            try {
                half3x4 = ((Float3x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half3x4;
    }

    public Float3x2Type getHalf3x2()
        throws IOException
    {
        if (half3x2 == null) {
            try {
                half3x2 = ((Float3x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half3x2;
    }

    public Float3x3Type getHalf3x3()
        throws IOException
    {
        if (half3x3 == null) {
            try {
                half3x3 = ((Float3x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half3x3;
    }

    public Bool2x4Type getBool2x4()
        throws IOException
    {
        if (bool2x4 == null) {
            try {
                bool2x4 = ((Bool2x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool2x4;
    }

    public Bool4x2Type getBool4x2()
        throws IOException
    {
        if (bool4x2 == null) {
            try {
                bool4x2 = ((Bool4x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool4x2;
    }

    public Bool4x3Type getBool4x3()
        throws IOException
    {
        if (bool4x3 == null) {
            try {
                bool4x3 = ((Bool4x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool4x3;
    }

    public FxModifierEnum getModifier()
        throws IOException
    {
        if (modifier == null) {
            try {
                modifier = ((FxModifierEnum) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_modifier_enum"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return modifier;
    }

    public Bool2x2Type getBool2x2()
        throws IOException
    {
        if (bool2x2 == null) {
            try {
                bool2x2 = ((Bool2x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool2x2;
    }

    public Bool2x3Type getBool2x3()
        throws IOException
    {
        if (bool2x3 == null) {
            try {
                bool2x3 = ((Bool2x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool2x3;
    }

    public Bool4Type getBool4x1()
        throws IOException
    {
        if (bool4x1 == null) {
            try {
                bool4x1 = ((Bool4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool4x1;
    }

    public FxAnnotateType[] getAnnotate()
        throws IOException
    {
        if (annotate == null) {
            try {
                annotate = ((FxAnnotateType[]) getChildren(new FxAnnotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return annotate;
    }

    public Bool2Type getBool2()
        throws IOException
    {
        if (bool2 == null) {
            try {
                bool2 = ((Bool2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool2;
    }

    public Bool4x4Type getBool4x4()
        throws IOException
    {
        if (bool4x4 == null) {
            try {
                bool4x4 = ((Bool4x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool4x4;
    }

    public Float3x3Type getFloat3x3()
        throws IOException
    {
        if (float3x3 == null) {
            try {
                float3x3 = ((Float3x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x3;
    }

    public Float3Type getFixed3x1()
        throws IOException
    {
        if (fixed3x1 == null) {
            try {
                fixed3x1 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed3x1;
    }

    public Bool3Type getBool3()
        throws IOException
    {
        if (bool3 == null) {
            try {
                bool3 = ((Bool3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool3;
    }

    public Float3x4Type getFloat3x4()
        throws IOException
    {
        if (float3x4 == null) {
            try {
                float3x4 = ((Float3x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x4;
    }

    public Float3x2Type getFixed3x2()
        throws IOException
    {
        if (fixed3x2 == null) {
            try {
                fixed3x2 = ((Float3x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed3x2;
    }

    public FxSampler1DType getSampler1D()
        throws IOException
    {
        if (sampler1D == null) {
            try {
                sampler1D = ((FxSampler1DType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler1D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler1D_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler1D;
    }

    public Float3Type getFloat3x1()
        throws IOException
    {
        if (float3x1 == null) {
            try {
                float3x1 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x1;
    }

    public Float3x2Type getFloat3x2()
        throws IOException
    {
        if (float3x2 == null) {
            try {
                float3x2 = ((Float3x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x2;
    }

    public Int2Type getInt2()
        throws IOException
    {
        if (int2 == null) {
            try {
                int2 = ((Int2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int2;
    }

    public Int3Type getInt3()
        throws IOException
    {
        if (int3 == null) {
            try {
                int3 = ((Int3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int3;
    }

    public Int4Type getInt4()
        throws IOException
    {
        if (int4 == null) {
            try {
                int4 = ((Int4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int4;
    }

    public Bool2Type getBool2x1()
        throws IOException
    {
        if (bool2x1 == null) {
            try {
                bool2x1 = ((Bool2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool2x1;
    }

    public Float3x3Type getFixed3x3()
        throws IOException
    {
        if (fixed3x3 == null) {
            try {
                fixed3x3 = ((Float3x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed3x3;
    }

    public Float3x4Type getFixed3x4()
        throws IOException
    {
        if (fixed3x4 == null) {
            try {
                fixed3x4 = ((Float3x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed3x4;
    }

    public Float4Type getFloat4()
        throws IOException
    {
        if (float4 == null) {
            try {
                float4 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4;
    }

    public Float3Type getFloat3()
        throws IOException
    {
        if (float3 == null) {
            try {
                float3 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3;
    }

    public Float2Type getFloat2()
        throws IOException
    {
        if (float2 == null) {
            try {
                float2 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2;
    }

    public FxSamplerRECTType getSamplerRECT()
        throws IOException
    {
        if (samplerRECT == null) {
            try {
                samplerRECT = ((FxSamplerRECTType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerRECT"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerRECT_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerRECT;
    }

    public Float2Type getHalf2x1()
        throws IOException
    {
        if (half2x1 == null) {
            try {
                half2x1 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half2x1;
    }

    public Float2x2Type getHalf2x2()
        throws IOException
    {
        if (half2x2 == null) {
            try {
                half2x2 = ((Float2x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half2x2;
    }

    public IntType getIntValue()
        throws IOException
    {
        if (intValue == null) {
            try {
                intValue = ((IntType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intValue;
    }

    public XmlString getString()
        throws IOException
    {
        if (string == null) {
            try {
                string = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return string;
    }

    public FxSamplerDEPTHType getSamplerDEPTH()
        throws IOException
    {
        if (samplerDEPTH == null) {
            try {
                samplerDEPTH = ((FxSamplerDEPTHType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerDEPTH"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerDEPTH_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerDEPTH;
    }

    public Int4x4Type getInt4x4()
        throws IOException
    {
        if (int4x4 == null) {
            try {
                int4x4 = ((Int4x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int4x4;
    }

    public Float3Type getFixed3()
        throws IOException
    {
        if (fixed3 == null) {
            try {
                fixed3 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed3;
    }

    public Int4x3Type getInt4x3()
        throws IOException
    {
        if (int4x3 == null) {
            try {
                int4x3 = ((Int4x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int4x3;
    }

    public Float2Type getFixed2()
        throws IOException
    {
        if (fixed2 == null) {
            try {
                fixed2 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed2;
    }

    public XmlNCName getSemantic()
        throws IOException
    {
        if (semantic == null) {
            try {
                semantic = ((XmlNCName) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return semantic;
    }

    public Int2x4Type getInt2x4()
        throws IOException
    {
        if (int2x4 == null) {
            try {
                int2x4 = ((Int2x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int2x4;
    }

    public Int4x2Type getInt4x2()
        throws IOException
    {
        if (int4x2 == null) {
            try {
                int4x2 = ((Int4x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int4x2;
    }

    public Int2x3Type getInt2x3()
        throws IOException
    {
        if (int2x3 == null) {
            try {
                int2x3 = ((Int2x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int2x3;
    }

    public Int4Type getInt4x1()
        throws IOException
    {
        if (int4x1 == null) {
            try {
                int4x1 = ((Int4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int4x1;
    }

    public Float4Type getFixed4()
        throws IOException
    {
        if (fixed4 == null) {
            try {
                fixed4 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed4;
    }

    public Int2x2Type getInt2x2()
        throws IOException
    {
        if (int2x2 == null) {
            try {
                int2x2 = ((Int2x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int2x2;
    }

    public Float4x3Type getHalf4x3()
        throws IOException
    {
        if (half4x3 == null) {
            try {
                half4x3 = ((Float4x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half4x3;
    }

    public Int2Type getInt2x1()
        throws IOException
    {
        if (int2x1 == null) {
            try {
                int2x1 = ((Int2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int2x1;
    }

    public Float4x4Type getHalf4x4()
        throws IOException
    {
        if (half4x4 == null) {
            try {
                half4x4 = ((Float4x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half4x4;
    }

    public Float2x3Type getHalf2x3()
        throws IOException
    {
        if (half2x3 == null) {
            try {
                half2x3 = ((Float2x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half2x3;
    }

    public Float4Type getHalf4x1()
        throws IOException
    {
        if (half4x1 == null) {
            try {
                half4x1 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half4x1;
    }

    public Float2x4Type getHalf2x4()
        throws IOException
    {
        if (half2x4 == null) {
            try {
                half2x4 = ((Float2x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half2x4;
    }

    public Float4x2Type getHalf4x2()
        throws IOException
    {
        if (half4x2 == null) {
            try {
                half4x2 = ((Float4x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half4x2;
    }

    public Bool3x3Type getBool3x3()
        throws IOException
    {
        if (bool3x3 == null) {
            try {
                bool3x3 = ((Bool3x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool3x3;
    }

    public Bool3x4Type getBool3x4()
        throws IOException
    {
        if (bool3x4 == null) {
            try {
                bool3x4 = ((Bool3x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool3x4;
    }

    public Bool3Type getBool3x1()
        throws IOException
    {
        if (bool3x1 == null) {
            try {
                bool3x1 = ((Bool3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool3x1;
    }

    public Bool3x2Type getBool3x2()
        throws IOException
    {
        if (bool3x2 == null) {
            try {
                bool3x2 = ((Bool3x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool3x2;
    }

    public Float4x4Type getFloat4x4()
        throws IOException
    {
        if (float4x4 == null) {
            try {
                float4x4 = ((Float4x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x4;
    }

    public FxSamplerCUBEType getSamplerCUBE()
        throws IOException
    {
        if (samplerCUBE == null) {
            try {
                samplerCUBE = ((FxSamplerCUBEType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "samplerCUBE"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_samplerCUBE_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return samplerCUBE;
    }

    public CgArrayType getArray()
        throws IOException
    {
        if (array == null) {
            try {
                array = ((CgArrayType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_array_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return array;
    }

    public Float2Type getFixed2x1()
        throws IOException
    {
        if (fixed2x1 == null) {
            try {
                fixed2x1 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed2x1;
    }

    public Float2x4Type getFloat2x4()
        throws IOException
    {
        if (float2x4 == null) {
            try {
                float2x4 = ((Float2x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x4;
    }

    public Float4x2Type getFloat4x2()
        throws IOException
    {
        if (float4x2 == null) {
            try {
                float4x2 = ((Float4x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x2;
    }

    public Float2x2Type getFixed2x2()
        throws IOException
    {
        if (fixed2x2 == null) {
            try {
                fixed2x2 = ((Float2x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed2x2;
    }

    public Float4x3Type getFloat4x3()
        throws IOException
    {
        if (float4x3 == null) {
            try {
                float4x3 = ((Float4x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x3;
    }

    public Float2x3Type getFixed2x3()
        throws IOException
    {
        if (fixed2x3 == null) {
            try {
                fixed2x3 = ((Float2x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed2x3;
    }

    public Float4Type getFixed4x1()
        throws IOException
    {
        if (fixed4x1 == null) {
            try {
                fixed4x1 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed4x1;
    }

    public Float2x2Type getFloat2x2()
        throws IOException
    {
        if (float2x2 == null) {
            try {
                float2x2 = ((Float2x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x2;
    }

    public Float2x3Type getFloat2x3()
        throws IOException
    {
        if (float2x3 == null) {
            try {
                float2x3 = ((Float2x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x3;
    }

    public Float4Type getFloat4x1()
        throws IOException
    {
        if (float4x1 == null) {
            try {
                float4x1 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x1;
    }

    public Float2Type getFloat2x1()
        throws IOException
    {
        if (float2x1 == null) {
            try {
                float2x1 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x1;
    }

    public XmlBoolean getBool()
        throws IOException
    {
        if (bool == null) {
            try {
                bool = ((XmlBoolean) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool;
    }

    public CgUserType getUsertype()
        throws IOException
    {
        if (usertype == null) {
            try {
                usertype = ((CgUserType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "usertype"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_user_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return usertype;
    }

    public Float2x4Type getFixed2x4()
        throws IOException
    {
        if (fixed2x4 == null) {
            try {
                fixed2x4 = ((Float2x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed2x4;
    }

    public Float4x2Type getFixed4x2()
        throws IOException
    {
        if (fixed4x2 == null) {
            try {
                fixed4x2 = ((Float4x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed4x2;
    }

    public GlEnumerationType getEnumValue()
        throws IOException
    {
        if (enumValue == null) {
            try {
                enumValue = ((GlEnumerationType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gl_enumeration_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return enumValue;
    }

    public Float4x3Type getFixed4x3()
        throws IOException
    {
        if (fixed4x3 == null) {
            try {
                fixed4x3 = ((Float4x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed4x3;
    }

    public FxSampler3DType getSampler3D()
        throws IOException
    {
        if (sampler3D == null) {
            try {
                sampler3D = ((FxSampler3DType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler3D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler3D_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler3D;
    }

    public Float4x4Type getFixed4x4()
        throws IOException
    {
        if (fixed4x4 == null) {
            try {
                fixed4x4 = ((Float4x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed4x4;
    }

    public FloatType getFloatValue()
        throws IOException
    {
        if (floatValue == null) {
            try {
                floatValue = ((FloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return floatValue;
    }

    public Float3Type getHalf3x1()
        throws IOException
    {
        if (half3x1 == null) {
            try {
                half3x1 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "half3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return half3x1;
    }

    public FloatType getFixed()
        throws IOException
    {
        if (fixed == null) {
            try {
                fixed = ((FloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fixed"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return fixed;
    }

    public FxSampler2DType getSampler2D()
        throws IOException
    {
        if (sampler2D == null) {
            try {
                sampler2D = ((FxSampler2DType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sampler2D_type"), CgNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler2D;
    }

}
