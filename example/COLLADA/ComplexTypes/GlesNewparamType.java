
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
import SimpleTypes.GlesEnumerationType;
import SimpleTypes.Int2Type;
import SimpleTypes.Int3Type;
import SimpleTypes.Int4Type;
import SimpleTypes.IntType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlBoolean;
import XmlSimpleTypes.XmlNCName;

public final class GlesNewparamType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((annotate[ ]+){0,}(semantic[ ]+){0,1}(modifier[ ]+){0,1}(((bool[ ]+){1}|(bool2[ ]+){1}|(bool3[ ]+){1}|(bool4[ ]+){1}|(int[ ]+){1}|(int2[ ]+){1}|(int3[ ]+){1}|(int4[ ]+){1}|(float[ ]+){1}|(float2[ ]+){1}|(float3[ ]+){1}|(float4[ ]+){1}|(float1x1[ ]+){1}|(float1x2[ ]+){1}|(float1x3[ ]+){1}|(float1x4[ ]+){1}|(float2x1[ ]+){1}|(float2x2[ ]+){1}|(float2x3[ ]+){1}|(float2x4[ ]+){1}|(float3x1[ ]+){1}|(float3x2[ ]+){1}|(float3x3[ ]+){1}|(float3x4[ ]+){1}|(float4x1[ ]+){1}|(float4x2[ ]+){1}|(float4x3[ ]+){1}|(float4x4[ ]+){1}|(sampler2D[ ]+){1}|(enum[ ]+){1}){0,1}){1}){1}";
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
    protected Bool4Type bool4;
    protected XmlNCName semantic;
    protected FxModifierEnum modifier;
    protected FxAnnotateType[] annotate;
    protected Float4x4Type float4x4;
    protected Bool2Type bool2;
    protected Float2x4Type float2x4;
    protected Float3x3Type float3x3;
    protected Float4x2Type float4x2;
    protected Bool3Type bool3;
    protected Float3x4Type float3x4;
    protected Float4x3Type float4x3;
    protected Float3Type float1x3;
    protected Float2x2Type float2x2;
    protected Float3Type float3x1;
    protected Int2Type int2;
    protected Float4Type float1x4;
    protected Float2x3Type float2x3;
    protected Float3x2Type float3x2;
    protected Float4Type float4x1;
    protected Int3Type int3;
    protected FloatType float1x1;
    protected Int4Type int4;
    protected Float2Type float1x2;
    protected Float2Type float2x1;
    protected XmlBoolean bool;
    protected GlesEnumerationType enumValue;
    protected FloatType floatValue;
    protected Float4Type float4;
    protected Float3Type float3;
    protected Float2Type float2;
    protected IntType intValue;
    protected GlesSamplerType sampler2D;

    static {
        ALLOWED_ATTRIBUTES.add("sid");
        REQUIRED_ATTRIBUTES.add("sid");
        try {
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_modifier_enum"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_enumeration_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("1"));
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
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_sampler_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlesNewparamType(XmlComplexType elem) {
        super(elem, GlesNewparamType.class);
    }

    public Bool4Type getBool4()
        throws IOException
    {
        if (bool4 == null) {
            try {
                bool4 = ((Bool4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool4;
    }

    public XmlNCName getSemantic()
        throws IOException
    {
        if (semantic == null) {
            try {
                semantic = ((XmlNCName) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "semantic"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return semantic;
    }

    public FxModifierEnum getModifier()
        throws IOException
    {
        if (modifier == null) {
            try {
                modifier = ((FxModifierEnum) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modifier"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_modifier_enum"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return modifier;
    }

    public FxAnnotateType[] getAnnotate()
        throws IOException
    {
        if (annotate == null) {
            try {
                annotate = ((FxAnnotateType[]) getChildren(new FxAnnotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return annotate;
    }

    public Float4x4Type getFloat4x4()
        throws IOException
    {
        if (float4x4 == null) {
            try {
                float4x4 = ((Float4x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x4;
    }

    public Bool2Type getBool2()
        throws IOException
    {
        if (bool2 == null) {
            try {
                bool2 = ((Bool2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool2;
    }

    public Float2x4Type getFloat2x4()
        throws IOException
    {
        if (float2x4 == null) {
            try {
                float2x4 = ((Float2x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x4_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x4;
    }

    public Float3x3Type getFloat3x3()
        throws IOException
    {
        if (float3x3 == null) {
            try {
                float3x3 = ((Float3x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x3;
    }

    public Float4x2Type getFloat4x2()
        throws IOException
    {
        if (float4x2 == null) {
            try {
                float4x2 = ((Float4x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x2_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x2;
    }

    public Bool3Type getBool3()
        throws IOException
    {
        if (bool3 == null) {
            try {
                bool3 = ((Bool3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"), GlesNewparamType.class));
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
                float3x4 = ((Float3x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x4_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x4;
    }

    public Float4x3Type getFloat4x3()
        throws IOException
    {
        if (float4x3 == null) {
            try {
                float4x3 = ((Float4x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x3_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x3;
    }

    public Float3Type getFloat1x3()
        throws IOException
    {
        if (float1x3 == null) {
            try {
                float1x3 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float1x3;
    }

    public Float2x2Type getFloat2x2()
        throws IOException
    {
        if (float2x2 == null) {
            try {
                float2x2 = ((Float2x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x2;
    }

    public Float3Type getFloat3x1()
        throws IOException
    {
        if (float3x1 == null) {
            try {
                float3x1 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x1;
    }

    public Int2Type getInt2()
        throws IOException
    {
        if (int2 == null) {
            try {
                int2 = ((Int2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int2;
    }

    public Float4Type getFloat1x4()
        throws IOException
    {
        if (float1x4 == null) {
            try {
                float1x4 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float1x4;
    }

    public Float2x3Type getFloat2x3()
        throws IOException
    {
        if (float2x3 == null) {
            try {
                float2x3 = ((Float2x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x3_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x3;
    }

    public Float3x2Type getFloat3x2()
        throws IOException
    {
        if (float3x2 == null) {
            try {
                float3x2 = ((Float3x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x2_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x2;
    }

    public Float4Type getFloat4x1()
        throws IOException
    {
        if (float4x1 == null) {
            try {
                float4x1 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float4x1;
    }

    public Int3Type getInt3()
        throws IOException
    {
        if (int3 == null) {
            try {
                int3 = ((Int3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int3;
    }

    public FloatType getFloat1x1()
        throws IOException
    {
        if (float1x1 == null) {
            try {
                float1x1 = ((FloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float1x1;
    }

    public Int4Type getInt4()
        throws IOException
    {
        if (int4 == null) {
            try {
                int4 = ((Int4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int4;
    }

    public Float2Type getFloat1x2()
        throws IOException
    {
        if (float1x2 == null) {
            try {
                float1x2 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float1x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float1x2;
    }

    public Float2Type getFloat2x1()
        throws IOException
    {
        if (float2x1 == null) {
            try {
                float2x1 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x1"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), GlesNewparamType.class));
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
                bool = ((XmlBoolean) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool;
    }

    public GlesEnumerationType getEnumValue()
        throws IOException
    {
        if (enumValue == null) {
            try {
                enumValue = ((GlesEnumerationType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "enum"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_enumeration_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return enumValue;
    }

    public FloatType getFloatValue()
        throws IOException
    {
        if (floatValue == null) {
            try {
                floatValue = ((FloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return floatValue;
    }

    public Float4Type getFloat4()
        throws IOException
    {
        if (float4 == null) {
            try {
                float4 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), GlesNewparamType.class));
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
                float3 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), GlesNewparamType.class));
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
                float2 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2;
    }

    public IntType getIntValue()
        throws IOException
    {
        if (intValue == null) {
            try {
                intValue = ((IntType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intValue;
    }

    public GlesSamplerType getSampler2D()
        throws IOException
    {
        if (sampler2D == null) {
            try {
                sampler2D = ((GlesSamplerType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler2D"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles_sampler_type"), GlesNewparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler2D;
    }

}
