
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ImageTypeGroupGroup2Create3d
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((size[ ]+){1}(mips[ ]+){1}(array[ ]+){0,1}(format[ ]+){0,1}(init_from[ ]+){0,}){1}";
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
    protected ImageTypeGroupGroup2Create3dGroupSize size;
    protected ImageTypeGroupGroup2Create3dGroupFormat format;
    protected ImageTypeGroupGroup2Create3dGroupInitFrom[] initFrom;
    protected ImageTypeGroupGroup2Create3dGroupArray array;
    protected ImageMipsType mips;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/size"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/format"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/init_from"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/array"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_mips_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ImageTypeGroupGroup2Create3d(XmlComplexType elem) {
        super(elem, ImageTypeGroupGroup2Create3d.class);
    }

    public ImageTypeGroupGroup2Create3dGroupSize getSize()
        throws IOException
    {
        if (size == null) {
            try {
                size = ((ImageTypeGroupGroup2Create3dGroupSize) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/size"), ImageTypeGroupGroup2Create3d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return size;
    }

    public ImageTypeGroupGroup2Create3dGroupFormat getFormat()
        throws IOException
    {
        if (format == null) {
            try {
                format = ((ImageTypeGroupGroup2Create3dGroupFormat) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/format"), ImageTypeGroupGroup2Create3d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return format;
    }

    public ImageTypeGroupGroup2Create3dGroupInitFrom[] getInitFrom()
        throws IOException
    {
        if (initFrom == null) {
            try {
                initFrom = ((ImageTypeGroupGroup2Create3dGroupInitFrom[]) getChildren(new ImageTypeGroupGroup2Create3dGroupInitFrom[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/init_from"), ImageTypeGroupGroup2Create3d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return initFrom;
    }

    public ImageTypeGroupGroup2Create3dGroupArray getArray()
        throws IOException
    {
        if (array == null) {
            try {
                array = ((ImageTypeGroupGroup2Create3dGroupArray) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_3d/group/array"), ImageTypeGroupGroup2Create3d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return array;
    }

    public ImageMipsType getMips()
        throws IOException
    {
        if (mips == null) {
            try {
                mips = ((ImageMipsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_mips_type"), ImageTypeGroupGroup2Create3d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mips;
    }

}
