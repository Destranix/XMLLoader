
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class CgPassTypeGroupProgramGroupShader
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((sources[ ]+){1}(compiler[ ]+){0,}(bind_uniform[ ]+){0,}){1}";
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
    protected CgPassTypeGroupProgramGroupShaderGroupSources sources;
    protected CgPassTypeGroupProgramGroupShaderGroupBindUniform[] bindUniform;
    protected FxTargetType[] compiler;

    static {
        ALLOWED_ATTRIBUTES.add("stage");
        REQUIRED_ATTRIBUTES.add("stage");
        try {
            ATTRIBUTES_NAME_MAP.put("stage", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_pipeline_stage_enum"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/program/group/shader/group/sources"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_uniform"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_uniform"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/program/group/shader/group/bind_uniform"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_uniform"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "compiler"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "compiler"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_target_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "compiler"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public CgPassTypeGroupProgramGroupShader(XmlComplexType elem) {
        super(elem, CgPassTypeGroupProgramGroupShader.class);
    }

    public CgPassTypeGroupProgramGroupShaderGroupSources getSources()
        throws IOException
    {
        if (sources == null) {
            try {
                sources = ((CgPassTypeGroupProgramGroupShaderGroupSources) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sources"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/program/group/shader/group/sources"), CgPassTypeGroupProgramGroupShader.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sources;
    }

    public CgPassTypeGroupProgramGroupShaderGroupBindUniform[] getBindUniform()
        throws IOException
    {
        if (bindUniform == null) {
            try {
                bindUniform = ((CgPassTypeGroupProgramGroupShaderGroupBindUniform[]) getChildren(new CgPassTypeGroupProgramGroupShaderGroupBindUniform[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_uniform"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "cg_pass_type/group/program/group/shader/group/bind_uniform"), CgPassTypeGroupProgramGroupShader.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bindUniform;
    }

    public FxTargetType[] getCompiler()
        throws IOException
    {
        if (compiler == null) {
            try {
                compiler = ((FxTargetType[]) getChildren(new FxTargetType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "compiler"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "fx_target_type"), CgPassTypeGroupProgramGroupShader.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return compiler;
    }

}
