
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ProfileCommonTypeGroupTechnique
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((asset[ ]+){0,1}(constant[ ]+){1}|(lambert[ ]+){1}|(phong[ ]+){1}|(blinn[ ]+){1}){0,1}(extra[ ]+){0,}){1}";
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
    protected ProfileCommonTypeGroupTechniqueGroupGroup1Blinn blinn;
    protected ProfileCommonTypeGroupTechniqueGroupGroup1Lambert lambert;
    protected AssetType asset;
    protected ProfileCommonTypeGroupTechniqueGroupGroup1Phong phong;
    protected ProfileCommonTypeGroupTechniqueGroupGroup1Constant constant;

    static {
        ALLOWED_ATTRIBUTES.add("id");
        try {
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blinn"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blinn"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type/group/technique/group/group1/blinn"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blinn"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blinn"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lambert"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lambert"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type/group/technique/group/group1/lambert"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lambert"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lambert"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "phong"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "phong"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type/group/technique/group/group1/phong"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "phong"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "phong"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type/group/technique/group/group1/constant"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("sid");
        REQUIRED_ATTRIBUTES.add("sid");
    }

    public ProfileCommonTypeGroupTechnique(XmlComplexType elem) {
        super(elem, ProfileCommonTypeGroupTechnique.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), ProfileCommonTypeGroupTechnique.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public ProfileCommonTypeGroupTechniqueGroupGroup1Blinn getBlinn()
        throws IOException
    {
        if (blinn == null) {
            try {
                blinn = ((ProfileCommonTypeGroupTechniqueGroupGroup1Blinn) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "blinn"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type/group/technique/group/group1/blinn"), ProfileCommonTypeGroupTechnique.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return blinn;
    }

    public ProfileCommonTypeGroupTechniqueGroupGroup1Lambert getLambert()
        throws IOException
    {
        if (lambert == null) {
            try {
                lambert = ((ProfileCommonTypeGroupTechniqueGroupGroup1Lambert) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "lambert"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type/group/technique/group/group1/lambert"), ProfileCommonTypeGroupTechnique.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lambert;
    }

    public AssetType getAsset()
        throws IOException
    {
        if (asset == null) {
            try {
                asset = ((AssetType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"), ProfileCommonTypeGroupTechnique.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return asset;
    }

    public ProfileCommonTypeGroupTechniqueGroupGroup1Phong getPhong()
        throws IOException
    {
        if (phong == null) {
            try {
                phong = ((ProfileCommonTypeGroupTechniqueGroupGroup1Phong) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "phong"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type/group/technique/group/group1/phong"), ProfileCommonTypeGroupTechnique.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return phong;
    }

    public ProfileCommonTypeGroupTechniqueGroupGroup1Constant getConstant()
        throws IOException
    {
        if (constant == null) {
            try {
                constant = ((ProfileCommonTypeGroupTechniqueGroupGroup1Constant) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "constant"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "profile_common_type/group/technique/group/group1/constant"), ProfileCommonTypeGroupTechnique.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return constant;
    }

}
