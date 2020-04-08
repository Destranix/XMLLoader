
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class SourceType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((asset[ ]+){0,1}(token_array[ ]+){1}|(IDREF_array[ ]+){1}|(Name_array[ ]+){1}|(bool_array[ ]+){1}|(float_array[ ]+){1}|(int_array[ ]+){1}|(SIDREF_array[ ]+){1}){0,1}(technique_common[ ]+){0,1}(technique[ ]+){0,}){1}";
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
    protected IntArrayType intArray;
    protected SourceTypeGroupTechniqueCommon techniqueCommon;
    protected TokenArrayType tokenArray;
    protected NameArrayType nameArray;
    protected FloatArrayType floatArray;
    protected AssetType asset;
    protected IdrefArrayType iDREFArray;
    protected TechniqueType[] technique;
    protected BoolArrayType boolArray;
    protected SidrefArrayType sIDREFArray;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type/group/technique_common"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "token_array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "token_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "token_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "token_array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "token_array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "Name_array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "Name_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "name_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "Name_array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "Name_array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "IDREF_array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "IDREF_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "idref_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "IDREF_array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "IDREF_array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool_array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool_array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool_array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF_array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sidref_array_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF_array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF_array"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("id");
        REQUIRED_ATTRIBUTES.add("id");
    }

    public SourceType(XmlComplexType elem) {
        super(elem, SourceType.class);
    }

    public IntArrayType getIntArray()
        throws IOException
    {
        if (intArray == null) {
            try {
                intArray = ((IntArrayType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_array_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intArray;
    }

    public SourceTypeGroupTechniqueCommon getTechniqueCommon()
        throws IOException
    {
        if (techniqueCommon == null) {
            try {
                techniqueCommon = ((SourceTypeGroupTechniqueCommon) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type/group/technique_common"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return techniqueCommon;
    }

    public TokenArrayType getTokenArray()
        throws IOException
    {
        if (tokenArray == null) {
            try {
                tokenArray = ((TokenArrayType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "token_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "token_array_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return tokenArray;
    }

    public NameArrayType getNameArray()
        throws IOException
    {
        if (nameArray == null) {
            try {
                nameArray = ((NameArrayType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "Name_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "name_array_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return nameArray;
    }

    public FloatArrayType getFloatArray()
        throws IOException
    {
        if (floatArray == null) {
            try {
                floatArray = ((FloatArrayType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_array_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return floatArray;
    }

    public AssetType getAsset()
        throws IOException
    {
        if (asset == null) {
            try {
                asset = ((AssetType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return asset;
    }

    public IdrefArrayType getIDREFArray()
        throws IOException
    {
        if (iDREFArray == null) {
            try {
                iDREFArray = ((IdrefArrayType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "IDREF_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "idref_array_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return iDREFArray;
    }

    public TechniqueType[] getTechnique()
        throws IOException
    {
        if (technique == null) {
            try {
                technique = ((TechniqueType[]) getChildren(new TechniqueType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return technique;
    }

    public BoolArrayType getBoolArray()
        throws IOException
    {
        if (boolArray == null) {
            try {
                boolArray = ((BoolArrayType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool_array_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return boolArray;
    }

    public SidrefArrayType getSIDREFArray()
        throws IOException
    {
        if (sIDREFArray == null) {
            try {
                sIDREFArray = ((SidrefArrayType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF_array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sidref_array_type"), SourceType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sIDREFArray;
    }

}
