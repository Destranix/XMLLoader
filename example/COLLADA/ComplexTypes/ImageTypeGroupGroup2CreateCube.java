
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ImageTypeGroupGroup2CreateCube
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
    protected ImageTypeGroupGroup2CreateCubeGroupSize size;
    protected ImageTypeGroupGroup2CreateCubeGroupFormat format;
    protected ImageTypeGroupGroup2CreateCubeGroupInitFrom[] initFrom;
    protected ImageTypeGroupGroup2CreateCubeGroupArray array;
    protected ImageMipsType mips;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_cube/group/size"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_cube/group/format"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_cube/group/init_from"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_cube/group/array"));
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

    public ImageTypeGroupGroup2CreateCube(XmlComplexType elem) {
        super(elem, ImageTypeGroupGroup2CreateCube.class);
    }

    public ImageTypeGroupGroup2CreateCubeGroupSize getSize()
        throws IOException
    {
        if (size == null) {
            try {
                size = ((ImageTypeGroupGroup2CreateCubeGroupSize) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_cube/group/size"), ImageTypeGroupGroup2CreateCube.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return size;
    }

    public ImageTypeGroupGroup2CreateCubeGroupFormat getFormat()
        throws IOException
    {
        if (format == null) {
            try {
                format = ((ImageTypeGroupGroup2CreateCubeGroupFormat) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_cube/group/format"), ImageTypeGroupGroup2CreateCube.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return format;
    }

    public ImageTypeGroupGroup2CreateCubeGroupInitFrom[] getInitFrom()
        throws IOException
    {
        if (initFrom == null) {
            try {
                initFrom = ((ImageTypeGroupGroup2CreateCubeGroupInitFrom[]) getChildren(new ImageTypeGroupGroup2CreateCubeGroupInitFrom[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_cube/group/init_from"), ImageTypeGroupGroup2CreateCube.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return initFrom;
    }

    public ImageTypeGroupGroup2CreateCubeGroupArray getArray()
        throws IOException
    {
        if (array == null) {
            try {
                array = ((ImageTypeGroupGroup2CreateCubeGroupArray) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_cube/group/array"), ImageTypeGroupGroup2CreateCube.class));
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
                mips = ((ImageMipsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_mips_type"), ImageTypeGroupGroup2CreateCube.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mips;
    }

}
