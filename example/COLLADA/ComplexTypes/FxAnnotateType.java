
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
import SimpleTypes.Int2Type;
import SimpleTypes.Int3Type;
import SimpleTypes.Int4Type;
import SimpleTypes.IntType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlBoolean;
import XmlSimpleTypes.XmlString;

public final class FxAnnotateType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((bool[ ]+){1}|(bool2[ ]+){1}|(bool3[ ]+){1}|(bool4[ ]+){1}|(int[ ]+){1}|(int2[ ]+){1}|(int3[ ]+){1}|(int4[ ]+){1}|(float[ ]+){1}|(float2[ ]+){1}|(float3[ ]+){1}|(float4[ ]+){1}|(float2x2[ ]+){1}|(float3x3[ ]+){1}|(float4x4[ ]+){1}|(string[ ]+){1}){0,1}){1}){1}";
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
    protected XmlString string;
    protected Bool4Type bool4;
    protected FloatType floatValue;
    protected Float4Type float4;
    protected Float3Type float3;
    protected Float2Type float2;
    protected IntType intValue;
    protected Float4x4Type float4x4;
    protected Bool2Type bool2;
    protected Float3x3Type float3x3;
    protected Bool3Type bool3;
    protected Float2x2Type float2x2;
    protected Int2Type int2;
    protected Int3Type int3;
    protected Int4Type int4;
    protected XmlBoolean bool;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        REQUIRED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), Integer.valueOf("1"));
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
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), Integer.valueOf("1"));
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
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public FxAnnotateType(XmlComplexType elem) {
        super(elem, FxAnnotateType.class);
    }

    public XmlString getString()
        throws IOException
    {
        if (string == null) {
            try {
                string = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "string"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return string;
    }

    public Bool4Type getBool4()
        throws IOException
    {
        if (bool4 == null) {
            try {
                bool4 = ((Bool4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool4_type"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool4;
    }

    public FloatType getFloatValue()
        throws IOException
    {
        if (floatValue == null) {
            try {
                floatValue = ((FloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), FxAnnotateType.class));
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
                float4 = ((Float4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4_type"), FxAnnotateType.class));
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
                float3 = ((Float3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3_type"), FxAnnotateType.class));
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
                float2 = ((Float2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2_type"), FxAnnotateType.class));
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
                intValue = ((IntType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intValue;
    }

    public Float4x4Type getFloat4x4()
        throws IOException
    {
        if (float4x4 == null) {
            try {
                float4x4 = ((Float4x4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float4x4_type"), FxAnnotateType.class));
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
                bool2 = ((Bool2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool2_type"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool2;
    }

    public Float3x3Type getFloat3x3()
        throws IOException
    {
        if (float3x3 == null) {
            try {
                float3x3 = ((Float3x3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float3x3_type"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float3x3;
    }

    public Bool3Type getBool3()
        throws IOException
    {
        if (bool3 == null) {
            try {
                bool3 = ((Bool3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool3_type"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool3;
    }

    public Float2x2Type getFloat2x2()
        throws IOException
    {
        if (float2x2 == null) {
            try {
                float2x2 = ((Float2x2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float2x2_type"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return float2x2;
    }

    public Int2Type getInt2()
        throws IOException
    {
        if (int2 == null) {
            try {
                int2 = ((Int2Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int2_type"), FxAnnotateType.class));
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
                int3 = ((Int3Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int3_type"), FxAnnotateType.class));
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
                int4 = ((Int4Type) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int4_type"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return int4;
    }

    public XmlBoolean getBool()
        throws IOException
    {
        if (bool == null) {
            try {
                bool = ((XmlBoolean) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"), FxAnnotateType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool;
    }

}
