
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class KinematicsModelTechniqueType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((newparam[ ]+){0,}(instance_joint[ ]+){1}|(joint[ ]+){1}){0,}(link[ ]+){1,}(formula[ ]+){1}|(instance_formula[ ]+){1}){0,}){1}";
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
    protected LinkType[] link;
    protected FormulaType[] formula;
    protected InstanceFormulaType[] instanceFormula;
    protected JointType[] joint;
    protected InstanceJointType[] instanceJoint;
    protected KinematicsNewparamType[] newparam;

    static {
        try {
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "joint"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "joint"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "joint_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "joint"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_joint"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_joint"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_joint_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_joint"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_newparam_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
    }

    public KinematicsModelTechniqueType(XmlComplexType elem) {
        super(elem, KinematicsModelTechniqueType.class);
    }

    public LinkType[] getLink()
        throws IOException
    {
        if (link == null) {
            try {
                link = ((LinkType[]) getChildren(new LinkType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "link_type"), KinematicsModelTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return link;
    }

    public FormulaType[] getFormula()
        throws IOException
    {
        if (formula == null) {
            try {
                formula = ((FormulaType[]) getChildren(new FormulaType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "formula_type"), KinematicsModelTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return formula;
    }

    public InstanceFormulaType[] getInstanceFormula()
        throws IOException
    {
        if (instanceFormula == null) {
            try {
                instanceFormula = ((InstanceFormulaType[]) getChildren(new InstanceFormulaType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_formula_type"), KinematicsModelTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceFormula;
    }

    public JointType[] getJoint()
        throws IOException
    {
        if (joint == null) {
            try {
                joint = ((JointType[]) getChildren(new JointType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "joint"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "joint_type"), KinematicsModelTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return joint;
    }

    public InstanceJointType[] getInstanceJoint()
        throws IOException
    {
        if (instanceJoint == null) {
            try {
                instanceJoint = ((InstanceJointType[]) getChildren(new InstanceJointType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_joint"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "instance_joint_type"), KinematicsModelTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return instanceJoint;
    }

    public KinematicsNewparamType[] getNewparam()
        throws IOException
    {
        if (newparam == null) {
            try {
                newparam = ((KinematicsNewparamType[]) getChildren(new KinematicsNewparamType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "newparam"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "kinematics_newparam_type"), KinematicsModelTechniqueType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return newparam;
    }

}
