
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class KinematicsAxisInfoType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((newparam[ ]+){0,}(active[ ]+){0,1}(locked[ ]+){0,1}(index[ ]+){0,}(limits[ ]+){0,1}(formula[ ]+){1}|(instance_formula[ ]+){1}){0,}){1}";
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
    protected CommonBoolOrParamType[] active;
    protected KinematicsIndexType[] index;
    protected FormulaType[] formula;
    protected CommonBoolOrParamType[] locked;
    protected InstanceFormulaType[] instanceFormula;
    protected KinematicsLimitsType[] limits;
    protected KinematicsNewparamType[] newparam;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("sid", new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sid_type"));
            ATTRIBUTES_NAME_MAP.put("axis", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "active"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "active"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_bool_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "active"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_index_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "locked"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "locked"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_bool_or_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "locked"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_limits_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_newparam_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("sid");
        ALLOWED_ATTRIBUTES.add("axis");
        REQUIRED_ATTRIBUTES.add("axis");
    }

    public KinematicsAxisInfoType(XmlComplexType elem) {
        super(elem, KinematicsAxisInfoType.class);
    }

    public CommonBoolOrParamType[] getActive()
        throws IOException
    {
        if (active == null) {
            try {
                active = ((CommonBoolOrParamType[]) getChildren(new CommonBoolOrParamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "active"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_bool_or_param_type"), KinematicsAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return active;
    }

    public KinematicsIndexType[] getIndex()
        throws IOException
    {
        if (index == null) {
            try {
                index = ((KinematicsIndexType[]) getChildren(new KinematicsIndexType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "index"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_index_type"), KinematicsAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return index;
    }

    public FormulaType[] getFormula()
        throws IOException
    {
        if (formula == null) {
            try {
                formula = ((FormulaType[]) getChildren(new FormulaType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula_type"), KinematicsAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return formula;
    }

    public CommonBoolOrParamType[] getLocked()
        throws IOException
    {
        if (locked == null) {
            try {
                locked = ((CommonBoolOrParamType[]) getChildren(new CommonBoolOrParamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "locked"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "common_bool_or_param_type"), KinematicsAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return locked;
    }

    public InstanceFormulaType[] getInstanceFormula()
        throws IOException
    {
        if (instanceFormula == null) {
            try {
                instanceFormula = ((InstanceFormulaType[]) getChildren(new InstanceFormulaType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula_type"), KinematicsAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceFormula;
    }

    public KinematicsLimitsType[] getLimits()
        throws IOException
    {
        if (limits == null) {
            try {
                limits = ((KinematicsLimitsType[]) getChildren(new KinematicsLimitsType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "limits"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_limits_type"), KinematicsAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return limits;
    }

    public KinematicsNewparamType[] getNewparam()
        throws IOException
    {
        if (newparam == null) {
            try {
                newparam = ((KinematicsNewparamType[]) getChildren(new KinematicsNewparamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_newparam_type"), KinematicsAxisInfoType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return newparam;
    }

}
