
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ProfileGles2Type
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((asset[ ]+){0,1}(include[ ]+){1}|(code[ ]+){1}){0,}(newparam[ ]+){0,}(technique[ ]+){1,}(extra[ ]+){0,}){1}";
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
    protected ProfileGles2TypeGroupNewparam[] newparam;
    protected ProfileGles2TypeGroupTechnique[] technique;

    static {
        ALLOWED_ATTRIBUTES.add("platforms");
        try {
            ATTRIBUTES_NAME_MAP.put("platforms", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "list_of_names_type"));
            ATTRIBUTES_NAME_MAP.put("language", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NCName"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
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
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_gles2_type/group/newparam"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_gles2_type/group/technique"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("language");
        REQUIRED_ATTRIBUTES.add("language");
        ALLOWED_ATTRIBUTES.add("id");
    }

    public ProfileGles2Type(XmlComplexType elem) {
        super(elem, ProfileGles2Type.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), ProfileGles2Type.class));
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
                include = ((FxIncludeType[]) getChildren(new FxIncludeType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "include"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_include_type"), ProfileGles2Type.class));
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
                asset = ((AssetType[]) getChildren(new AssetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"), ProfileGles2Type.class));
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
                code = ((FxCodeType[]) getChildren(new FxCodeType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "code"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_code_type"), ProfileGles2Type.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return code;
    }

    public ProfileGles2TypeGroupNewparam[] getNewparam()
        throws IOException
    {
        if (newparam == null) {
            try {
                newparam = ((ProfileGles2TypeGroupNewparam[]) getChildren(new ProfileGles2TypeGroupNewparam[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_gles2_type/group/newparam"), ProfileGles2Type.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return newparam;
    }

    public ProfileGles2TypeGroupTechnique[] getTechnique()
        throws IOException
    {
        if (technique == null) {
            try {
                technique = ((ProfileGles2TypeGroupTechnique[]) getChildren(new ProfileGles2TypeGroupTechnique[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_gles2_type/group/technique"), ProfileGles2Type.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return technique;
    }

}
