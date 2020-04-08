
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class CgPassType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((annotate[ ]+){0,}(states[ ]+){0,1}(program[ ]+){0,1}(evaluate[ ]+){0,1}(extra[ ]+){0,}){1}";
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
    protected FxAnnotateType[] annotate;
    protected CgPassTypeGroupProgram program;
    protected CgPassTypeGroupStates states;
    protected CgPassTypeGroupEvaluate evaluate;

    static {
        ALLOWED_ATTRIBUTES.add("sid");
        try {
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "program"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "program"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/program"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "program"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "program"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "states"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "states"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/states"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "states"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "states"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "evaluate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "evaluate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/evaluate"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "evaluate"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "evaluate"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public CgPassType(XmlComplexType elem) {
        super(elem, CgPassType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), CgPassType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public FxAnnotateType[] getAnnotate()
        throws IOException
    {
        if (annotate == null) {
            try {
                annotate = ((FxAnnotateType[]) getChildren(new FxAnnotateType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "annotate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_annotate_type"), CgPassType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return annotate;
    }

    public CgPassTypeGroupProgram getProgram()
        throws IOException
    {
        if (program == null) {
            try {
                program = ((CgPassTypeGroupProgram) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "program"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/program"), CgPassType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return program;
    }

    public CgPassTypeGroupStates getStates()
        throws IOException
    {
        if (states == null) {
            try {
                states = ((CgPassTypeGroupStates) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "states"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/states"), CgPassType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return states;
    }

    public CgPassTypeGroupEvaluate getEvaluate()
        throws IOException
    {
        if (evaluate == null) {
            try {
                evaluate = ((CgPassTypeGroupEvaluate) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "evaluate"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/evaluate"), CgPassType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return evaluate;
    }

}
