
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ProfileCgType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((asset[ ]+){0,1}(code[ ]+){1}|(include[ ]+){1}){0,}(newparam[ ]+){0,}(technique[ ]+){1,}(extra[ ]+){0,}){1}";
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
    protected FxIncludeType[] include;
    protected AssetType[] asset;
    protected FxCodeType[] code;
    protected CgNewparamType[] newparam;
    protected ProfileCgTypeGroupTechnique[] technique;

    static {
        ALLOWED_ATTRIBUTES.add("id");
        try {
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ATTRIBUTES_NAME_MAP.put("platform", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "include"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "include"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_include_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "include"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "code"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "code"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_code_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "code"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_newparam_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_cg_type/group/technique"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("platform");
        ATTRIBUTE_DEFAULT_VALUES.put("platform", "PC");
    }

    public ProfileCgType(XmlComplexType elem) {
        super(elem, ProfileCgType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), ProfileCgType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public FxIncludeType[] getInclude()
        throws IOException
    {
        if (include == null) {
            try {
                include = ((FxIncludeType[]) getChildren(new FxIncludeType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "include"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_include_type"), ProfileCgType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return include;
    }

    public AssetType[] getAsset()
        throws IOException
    {
        if (asset == null) {
            try {
                asset = ((AssetType[]) getChildren(new AssetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"), ProfileCgType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return asset;
    }

    public FxCodeType[] getCode()
        throws IOException
    {
        if (code == null) {
            try {
                code = ((FxCodeType[]) getChildren(new FxCodeType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "code"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_code_type"), ProfileCgType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return code;
    }

    public CgNewparamType[] getNewparam()
        throws IOException
    {
        if (newparam == null) {
            try {
                newparam = ((CgNewparamType[]) getChildren(new CgNewparamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_newparam_type"), ProfileCgType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return newparam;
    }

    public ProfileCgTypeGroupTechnique[] getTechnique()
        throws IOException
    {
        if (technique == null) {
            try {
                technique = ((ProfileCgTypeGroupTechnique[]) getChildren(new ProfileCgTypeGroupTechnique[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_cg_type/group/technique"), ProfileCgType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return technique;
    }

}
