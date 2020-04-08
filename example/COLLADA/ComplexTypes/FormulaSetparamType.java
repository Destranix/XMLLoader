
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import SimpleTypes.FloatType;
import SimpleTypes.IntType;
import SimpleTypes.SidrefType;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;
import XmlSimpleTypes.XmlBoolean;

public final class FormulaSetparamType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((float[ ]+){1}|(int[ ]+){1}|(SIDREF[ ]+){1}|(bool[ ]+){1}|(connect_param[ ]+){1}){0,1}";
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
    protected IntType intValue;
    protected FloatType floatValue;
    protected SidrefType sIDREF;
    protected XmlBoolean bool;
    protected KinematicsConnectParamType connectParam;

    static {
        ALLOWED_ATTRIBUTES.add("ref");
        REQUIRED_ATTRIBUTES.add("ref");
        try {
            ATTRIBUTES_NAME_MAP.put("ref", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sidref_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "connect_param"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "connect_param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_connect_param_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "connect_param"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "connect_param"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public FormulaSetparamType(XmlComplexType elem) {
        super(elem, FormulaSetparamType.class);
    }

    public IntType getIntValue()
        throws IOException
    {
        if (intValue == null) {
            try {
                intValue = ((IntType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "int_type"), FormulaSetparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intValue;
    }

    public FloatType getFloatValue()
        throws IOException
    {
        if (floatValue == null) {
            try {
                floatValue = ((FloatType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "float_type"), FormulaSetparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return floatValue;
    }

    public SidrefType getSIDREF()
        throws IOException
    {
        if (sIDREF == null) {
            try {
                sIDREF = ((SidrefType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "SIDREF"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sidref_type"), FormulaSetparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sIDREF;
    }

    public XmlBoolean getBool()
        throws IOException
    {
        if (bool == null) {
            try {
                bool = ((XmlBoolean) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "bool"), new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "boolean"), FormulaSetparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bool;
    }

    public KinematicsConnectParamType getConnectParam()
        throws IOException
    {
        if (connectParam == null) {
            try {
                connectParam = ((KinematicsConnectParamType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "connect_param"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_connect_param_type"), FormulaSetparamType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return connectParam;
    }

}
