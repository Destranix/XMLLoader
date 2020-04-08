
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class LinkType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((rotate[ ]+){1}|(translate[ ]+){1}){0,}(attachment_full[ ]+){1}|(attachment_start[ ]+){1}|(attachment_end[ ]+){1}){0,}){1}";
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
    protected TranslateType[] translate;
    protected LinkTypeGroupGroup1AttachmentEnd[] attachmentEnd;
    protected RotateType[] rotate;
    protected LinkTypeGroupGroup1AttachmentFull[] attachmentFull;
    protected LinkTypeGroupGroup1AttachmentStart[] attachmentStart;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_end"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_end"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link_type/group/group1/attachment_end"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_end"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_full"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_full"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link_type/group/group1/attachment_full"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_full"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_start"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_start"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link_type/group/group1/attachment_start"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_start"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("sid");
    }

    public LinkType(XmlComplexType elem) {
        super(elem, LinkType.class);
    }

    public TranslateType[] getTranslate()
        throws IOException
    {
        if (translate == null) {
            try {
                translate = ((TranslateType[]) getChildren(new TranslateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "translate_type"), LinkType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return translate;
    }

    public LinkTypeGroupGroup1AttachmentEnd[] getAttachmentEnd()
        throws IOException
    {
        if (attachmentEnd == null) {
            try {
                attachmentEnd = ((LinkTypeGroupGroup1AttachmentEnd[]) getChildren(new LinkTypeGroupGroup1AttachmentEnd[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_end"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link_type/group/group1/attachment_end"), LinkType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return attachmentEnd;
    }

    public RotateType[] getRotate()
        throws IOException
    {
        if (rotate == null) {
            try {
                rotate = ((RotateType[]) getChildren(new RotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "rotate_type"), LinkType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rotate;
    }

    public LinkTypeGroupGroup1AttachmentFull[] getAttachmentFull()
        throws IOException
    {
        if (attachmentFull == null) {
            try {
                attachmentFull = ((LinkTypeGroupGroup1AttachmentFull[]) getChildren(new LinkTypeGroupGroup1AttachmentFull[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_full"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link_type/group/group1/attachment_full"), LinkType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return attachmentFull;
    }

    public LinkTypeGroupGroup1AttachmentStart[] getAttachmentStart()
        throws IOException
    {
        if (attachmentStart == null) {
            try {
                attachmentStart = ((LinkTypeGroupGroup1AttachmentStart[]) getChildren(new LinkTypeGroupGroup1AttachmentStart[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "attachment_start"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link_type/group/group1/attachment_start"), LinkType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return attachmentStart;
    }

}
