
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class MotionType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((instance_articulated_system[ ]+){1}(technique_common[ ]+){1}(technique[ ]+){0,}(extra[ ]+){0,}){1}";
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
    protected MotionTechniqueType techniqueCommon;
    protected InstanceArticulatedSystemType instanceArticulatedSystem;
    protected TechniqueType[] technique;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "motion_technique_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_articulated_system"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_articulated_system"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_articulated_system_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_articulated_system"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_articulated_system"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public MotionType(XmlComplexType elem) {
        super(elem, MotionType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), MotionType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public MotionTechniqueType getTechniqueCommon()
        throws IOException
    {
        if (techniqueCommon == null) {
            try {
                techniqueCommon = ((MotionTechniqueType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_common"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "motion_technique_type"), MotionType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return techniqueCommon;
    }

    public InstanceArticulatedSystemType getInstanceArticulatedSystem()
        throws IOException
    {
        if (instanceArticulatedSystem == null) {
            try {
                instanceArticulatedSystem = ((InstanceArticulatedSystemType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_articulated_system"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_articulated_system_type"), MotionType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceArticulatedSystem;
    }

    public TechniqueType[] getTechnique()
        throws IOException
    {
        if (technique == null) {
            try {
                technique = ((TechniqueType[]) getChildren(new TechniqueType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "technique_type"), MotionType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return technique;
    }

}
