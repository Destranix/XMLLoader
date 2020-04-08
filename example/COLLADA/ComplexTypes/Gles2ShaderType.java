
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class Gles2ShaderType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((sources[ ]+){1}(compiler[ ]+){0,}(extra[ ]+){0,}){1}";
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
    protected Gles2ShaderTypeGroupSources sources;
    protected FxTargetType[] compiler;

    static {
        ALLOWED_ATTRIBUTES.add("stage");
        REQUIRED_ATTRIBUTES.add("stage");
        try {
            ATTRIBUTES_NAME_MAP.put("stage", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_pipeline_stage_enum"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_shader_type/group/sources"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "compiler"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "compiler"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_target_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "compiler"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public Gles2ShaderType(XmlComplexType elem) {
        super(elem, Gles2ShaderType.class);
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), Gles2ShaderType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public Gles2ShaderTypeGroupSources getSources()
        throws IOException
    {
        if (sources == null) {
            try {
                sources = ((Gles2ShaderTypeGroupSources) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "gles2_shader_type/group/sources"), Gles2ShaderType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sources;
    }

    public FxTargetType[] getCompiler()
        throws IOException
    {
        if (compiler == null) {
            try {
                compiler = ((FxTargetType[]) getChildren(new FxTargetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "compiler"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_target_type"), Gles2ShaderType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return compiler;
    }

}
