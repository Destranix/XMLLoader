
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.UpAxisEnum;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlDateTime;
import XmlSimpleTypes.XmlString;
import XmlSimpleTypes.XmlToken;

public final class AssetType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((contributor[ ]+){0,}(coverage[ ]+){0,1}(created[ ]+){1}(keywords[ ]+){0,1}(modified[ ]+){1}(revision[ ]+){0,1}(subject[ ]+){0,1}(title[ ]+){0,1}(unit[ ]+){0,1}(up_axis[ ]+){0,1}(extra[ ]+){0,}){1}";
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
    protected XmlDateTime modified;
    protected ExtraType[] extra;
    protected XmlDateTime created;
    protected UpAxisEnum upAxis;
    protected XmlString revision;
    protected AssetTypeGroupContributor[] contributor;
    protected AssetTypeGroupCoverage coverage;
    protected XmlString subject;
    protected AssetTypeGroupUnit unit;
    protected XmlString title;
    protected XmlToken keywords;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modified"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modified"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "dateTime"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modified"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modified"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "created"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "created"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "dateTime"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "created"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "created"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "up_axis"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "up_axis"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "up_axis_enum"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "up_axis"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "up_axis"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "revision"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "revision"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "revision"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "revision"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "contributor"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "contributor"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/contributor"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "contributor"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "coverage"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "coverage"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/coverage"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "coverage"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "coverage"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "subject"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "subject"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "subject"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "subject"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unit"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unit"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/unit"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unit"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unit"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "title"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "title"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "title"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "title"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "keywords"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "keywords"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "keywords"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "keywords"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public AssetType(XmlComplexType elem) {
        super(elem, AssetType.class);
    }

    public XmlDateTime getModified()
        throws IOException
    {
        if (modified == null) {
            try {
                modified = ((XmlDateTime) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "modified"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "dateTime"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return modified;
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public XmlDateTime getCreated()
        throws IOException
    {
        if (created == null) {
            try {
                created = ((XmlDateTime) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "created"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "dateTime"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return created;
    }

    public UpAxisEnum getUpAxis()
        throws IOException
    {
        if (upAxis == null) {
            try {
                upAxis = ((UpAxisEnum) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "up_axis"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "up_axis_enum"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return upAxis;
    }

    public XmlString getRevision()
        throws IOException
    {
        if (revision == null) {
            try {
                revision = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "revision"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return revision;
    }

    public AssetTypeGroupContributor[] getContributor()
        throws IOException
    {
        if (contributor == null) {
            try {
                contributor = ((AssetTypeGroupContributor[]) getChildren(new AssetTypeGroupContributor[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "contributor"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/contributor"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return contributor;
    }

    public AssetTypeGroupCoverage getCoverage()
        throws IOException
    {
        if (coverage == null) {
            try {
                coverage = ((AssetTypeGroupCoverage) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "coverage"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/coverage"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return coverage;
    }

    public XmlString getSubject()
        throws IOException
    {
        if (subject == null) {
            try {
                subject = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "subject"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return subject;
    }

    public AssetTypeGroupUnit getUnit()
        throws IOException
    {
        if (unit == null) {
            try {
                unit = ((AssetTypeGroupUnit) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unit"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/unit"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return unit;
    }

    public XmlString getTitle()
        throws IOException
    {
        if (title == null) {
            try {
                title = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "title"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return title;
    }

    public XmlToken getKeywords()
        throws IOException
    {
        if (keywords == null) {
            try {
                keywords = ((XmlToken) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "keywords"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"), AssetType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return keywords;
    }

}
