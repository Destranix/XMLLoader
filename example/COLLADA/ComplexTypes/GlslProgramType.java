
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class GlslProgramType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((shader[ ]+){0,}(bind_attribute[ ]+){0,}(bind_uniform[ ]+){0,}){1}";
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
    protected GlslProgramTypeGroupBindUniform[] bindUniform;
    protected GlslProgramTypeGroupBindAttribute[] bindAttribute;
    protected GlslShaderType[] shader;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_uniform"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_uniform"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "glsl_program_type/group/bind_uniform"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_uniform"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_attribute"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_attribute"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "glsl_program_type/group/bind_attribute"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_attribute"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shader"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shader"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "glsl_shader_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shader"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public GlslProgramType(XmlComplexType elem) {
        super(elem, GlslProgramType.class);
    }

    public GlslProgramTypeGroupBindUniform[] getBindUniform()
        throws IOException
    {
        if (bindUniform == null) {
            try {
                bindUniform = ((GlslProgramTypeGroupBindUniform[]) getChildren(new GlslProgramTypeGroupBindUniform[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_uniform"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "glsl_program_type/group/bind_uniform"), GlslProgramType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bindUniform;
    }

    public GlslProgramTypeGroupBindAttribute[] getBindAttribute()
        throws IOException
    {
        if (bindAttribute == null) {
            try {
                bindAttribute = ((GlslProgramTypeGroupBindAttribute[]) getChildren(new GlslProgramTypeGroupBindAttribute[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bind_attribute"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "glsl_program_type/group/bind_attribute"), GlslProgramType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bindAttribute;
    }

    public GlslShaderType[] getShader()
        throws IOException
    {
        if (shader == null) {
            try {
                shader = ((GlslShaderType[]) getChildren(new GlslShaderType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "shader"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "glsl_shader_type"), GlslProgramType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return shader;
    }

}
