
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlFloat;

public final class AssetTypeGroupCoverageGroupGeographicLocation
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((longitude[ ]+){1}(latitude[ ]+){1}(altitude[ ]+){1}){1}";
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
    protected XmlFloat latitude;
    protected XmlFloat longitude;
    protected AssetTypeGroupCoverageGroupGeographicLocationGroupAltitude altitude;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "latitude"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "latitude"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "float"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "latitude"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "latitude"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "longitude"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "longitude"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "float"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "longitude"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "longitude"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "altitude"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "altitude"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/coverage/group/geographic_location/group/altitude"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "altitude"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "altitude"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public AssetTypeGroupCoverageGroupGeographicLocation(XmlComplexType elem) {
        super(elem, AssetTypeGroupCoverageGroupGeographicLocation.class);
    }

    public XmlFloat getLatitude()
        throws IOException
    {
        if (latitude == null) {
            try {
                latitude = ((XmlFloat) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "latitude"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "float"), AssetTypeGroupCoverageGroupGeographicLocation.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return latitude;
    }

    public XmlFloat getLongitude()
        throws IOException
    {
        if (longitude == null) {
            try {
                longitude = ((XmlFloat) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "longitude"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "float"), AssetTypeGroupCoverageGroupGeographicLocation.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return longitude;
    }

    public AssetTypeGroupCoverageGroupGeographicLocationGroupAltitude getAltitude()
        throws IOException
    {
        if (altitude == null) {
            try {
                altitude = ((AssetTypeGroupCoverageGroupGeographicLocationGroupAltitude) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "altitude"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type/group/coverage/group/geographic_location/group/altitude"), AssetTypeGroupCoverageGroupGeographicLocation.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return altitude;
    }

}
