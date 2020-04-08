
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class ImageTypeGroupGroup2Create2d
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((size_exact[ ]+){1}|(size_ratio[ ]+){1}){0,1}(mips[ ]+){1}|(unnormalized[ ]+){1}){0,1}(array[ ]+){0,1}(format[ ]+){0,1}(init_from[ ]+){0,}){1}";
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
    protected ImageTypeGroupGroup2Create2dGroupGroup0SizeExact sizeExact;
    protected XmlComplexType unnormalized;
    protected ImageTypeGroupGroup2Create2dGroupFormat format;
    protected ImageTypeGroupGroup2Create2dGroupInitFrom[] initFrom;
    protected ImageTypeGroupGroup2Create2dGroupArray array;
    protected ImageTypeGroupGroup2Create2dGroupGroup0SizeRatio sizeRatio;
    protected ImageMipsType mips;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_exact"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_exact"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/group0/size_exact"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_exact"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_exact"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unnormalized"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unnormalized"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyType"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unnormalized"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unnormalized"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/format"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/init_from"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/array"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_ratio"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_ratio"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/group0/size_ratio"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_ratio"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_ratio"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_mips_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public ImageTypeGroupGroup2Create2d(XmlComplexType elem) {
        super(elem, ImageTypeGroupGroup2Create2d.class);
    }

    public ImageTypeGroupGroup2Create2dGroupGroup0SizeExact getSizeExact()
        throws IOException
    {
        if (sizeExact == null) {
            try {
                sizeExact = ((ImageTypeGroupGroup2Create2dGroupGroup0SizeExact) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_exact"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/group0/size_exact"), ImageTypeGroupGroup2Create2d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sizeExact;
    }

    public XmlComplexType getUnnormalized()
        throws IOException
    {
        if (unnormalized == null) {
            try {
                unnormalized = ((XmlComplexType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "unnormalized"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyType"), ImageTypeGroupGroup2Create2d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return unnormalized;
    }

    public ImageTypeGroupGroup2Create2dGroupFormat getFormat()
        throws IOException
    {
        if (format == null) {
            try {
                format = ((ImageTypeGroupGroup2Create2dGroupFormat) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "format"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/format"), ImageTypeGroupGroup2Create2d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return format;
    }

    public ImageTypeGroupGroup2Create2dGroupInitFrom[] getInitFrom()
        throws IOException
    {
        if (initFrom == null) {
            try {
                initFrom = ((ImageTypeGroupGroup2Create2dGroupInitFrom[]) getChildren(new ImageTypeGroupGroup2Create2dGroupInitFrom[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "init_from"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/init_from"), ImageTypeGroupGroup2Create2d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return initFrom;
    }

    public ImageTypeGroupGroup2Create2dGroupArray getArray()
        throws IOException
    {
        if (array == null) {
            try {
                array = ((ImageTypeGroupGroup2Create2dGroupArray) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "array"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/array"), ImageTypeGroupGroup2Create2d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return array;
    }

    public ImageTypeGroupGroup2Create2dGroupGroup0SizeRatio getSizeRatio()
        throws IOException
    {
        if (sizeRatio == null) {
            try {
                sizeRatio = ((ImageTypeGroupGroup2Create2dGroupGroup0SizeRatio) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "size_ratio"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_type/group/group2/create_2d/group/group0/size_ratio"), ImageTypeGroupGroup2Create2d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sizeRatio;
    }

    public ImageMipsType getMips()
        throws IOException
    {
        if (mips == null) {
            try {
                mips = ((ImageMipsType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "mips"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "image_mips_type"), ImageTypeGroupGroup2Create2d.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mips;
    }

}
