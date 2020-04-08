
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlString;

public final class CgPassTypeGroupProgramGroupShaderGroupSources
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((inline[ ]+){1}|(import[ ]+){1}){0,}){1})(())";
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
    protected XmlString[] inline;
    protected FxSourcesTypeGroupGroup0Import[] importValue;

    static {
        ALLOWED_ATTRIBUTES.add("entry");
        REQUIRED_ATTRIBUTES.add("entry");
        try {
            ATTRIBUTES_NAME_MAP.put("entry", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inline"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inline"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inline"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "import"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "import"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sources_type/group/group0/import"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "import"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public CgPassTypeGroupProgramGroupShaderGroupSources(XmlComplexType elem) {
        super(elem, CgPassTypeGroupProgramGroupShaderGroupSources.class);
    }

    public XmlString[] getInline()
        throws IOException
    {
        if (inline == null) {
            try {
                inline = ((XmlString[]) getChildren(new XmlString[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "inline"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"), CgPassTypeGroupProgramGroupShaderGroupSources.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return inline;
    }

    public FxSourcesTypeGroupGroup0Import[] getImportValue()
        throws IOException
    {
        if (importValue == null) {
            try {
                importValue = ((FxSourcesTypeGroupGroup0Import[]) getChildren(new FxSourcesTypeGroupGroup0Import[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "import"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_sources_type/group/group0/import"), CgPassTypeGroupProgramGroupShaderGroupSources.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return importValue;
    }

}
