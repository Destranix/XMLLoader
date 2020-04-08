
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.AssetTypeGroupContributorGroupAuthorEmail;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlAnyURI;
import XmlSimpleTypes.XmlString;

public final class AssetTypeGroupContributor
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((author[ ]+){0,1}(author_email[ ]+){0,1}(author_website[ ]+){0,1}(authoring_tool[ ]+){0,1}(comments[ ]+){0,1}(copyright[ ]+){0,1}(source_data[ ]+){0,1}){1}";
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
    protected XmlAnyURI authorWebsite;
    protected XmlString authoringTool;
    protected XmlAnyURI sourceData;
    protected XmlString copyright;
    protected XmlString author;
    protected XmlString comments;
    protected AssetTypeGroupContributorGroupAuthorEmail authorEmail;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_website"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_website"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_website"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_website"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "authoring_tool"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "authoring_tool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "authoring_tool"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "authoring_tool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_data"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_data"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_data"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_data"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "copyright"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "copyright"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "copyright"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "copyright"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "comments"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "comments"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "comments"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "comments"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_email"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_email"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/contributor/group/author_email"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_email"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_email"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public AssetTypeGroupContributor(XmlComplexType elem) {
        super(elem, AssetTypeGroupContributor.class);
    }

    public XmlAnyURI getAuthorWebsite()
        throws IOException
    {
        if (authorWebsite == null) {
            try {
                authorWebsite = ((XmlAnyURI) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_website"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"), AssetTypeGroupContributor.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return authorWebsite;
    }

    public XmlString getAuthoringTool()
        throws IOException
    {
        if (authoringTool == null) {
            try {
                authoringTool = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "authoring_tool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), AssetTypeGroupContributor.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return authoringTool;
    }

    public XmlAnyURI getSourceData()
        throws IOException
    {
        if (sourceData == null) {
            try {
                sourceData = ((XmlAnyURI) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_data"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"), AssetTypeGroupContributor.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sourceData;
    }

    public XmlString getCopyright()
        throws IOException
    {
        if (copyright == null) {
            try {
                copyright = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "copyright"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), AssetTypeGroupContributor.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return copyright;
    }

    public XmlString getAuthor()
        throws IOException
    {
        if (author == null) {
            try {
                author = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), AssetTypeGroupContributor.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return author;
    }

    public XmlString getComments()
        throws IOException
    {
        if (comments == null) {
            try {
                comments = ((XmlString) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "comments"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), AssetTypeGroupContributor.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return comments;
    }

    public AssetTypeGroupContributorGroupAuthorEmail getAuthorEmail()
        throws IOException
    {
        if (authorEmail == null) {
            try {
                authorEmail = ((AssetTypeGroupContributorGroupAuthorEmail) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "author_email"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/contributor/group/author_email"), AssetTypeGroupContributor.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return authorEmail;
    }

}
