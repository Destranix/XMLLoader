
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class LowlimitType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "((((((((cn[ ]+){1}|(ci[ ]+){1}|(csymbol[ ]+){1}){0,1}){1}|(((abs[ ]+){1}|(conjugate[ ]+){1}|(factorial[ ]+){1}|(arg[ ]+){1}|(real[ ]+){1}|(imaginary[ ]+){1}|(floor[ ]+){1}|(ceiling[ ]+){1}|(quotient[ ]+){1}|(divide[ ]+){1}|(rem[ ]+){1}|(minus[ ]+){1}|(plus[ ]+){1}|(times[ ]+){1}|(power[ ]+){1}|(root[ ]+){1}|(max[ ]+){1}|(min[ ]+){1}|(gcd[ ]+){1}|(lcm[ ]+){1}|(sum[ ]+){1}|(product[ ]+){1}){0,1}){1}|(((compose[ ]+){1}|(domain[ ]+){1}|(codomain[ ]+){1}|(image[ ]+){1}|(domainofapplication[ ]+){1}|(ident[ ]+){1}){0,1}){1}|(((and[ ]+){1}|(or[ ]+){1}|(xor[ ]+){1}|(not[ ]+){1}|(exists[ ]+){1}|(forall[ ]+){1}|(implies[ ]+){1}){0,1}){1}|(((naturalnumbers[ ]+){1}|(primes[ ]+){1}|(integers[ ]+){1}|(rationals[ ]+){1}|(reals[ ]+){1}|(complexes[ ]+){1}|(emptyset[ ]+){1}|(exponentiale[ ]+){1}|(imaginaryi[ ]+){1}|(pi[ ]+){1}|(eulergamma[ ]+){1}|(true[ ]+){1}|(false[ ]+){1}|(infinity[ ]+){1}|(notanumber[ ]+){1}){0,1}){1}|(((set[ ]+){1}|(list[ ]+){1}|(union[ ]+){1}|(intersect[ ]+){1}|(in[ ]+){1}|(notin[ ]+){1}|(subset[ ]+){1}|(prsubset[ ]+){1}|(notsubset[ ]+){1}|(notprsubset[ ]+){1}|(setdiff[ ]+){1}|(card[ ]+){1}|(cartesianproduct[ ]+){1}){0,1}){1}|(((eq[ ]+){1}|(neq[ ]+){1}|(leq[ ]+){1}|(lt[ ]+){1}|(geq[ ]+){1}|(gt[ ]+){1}|(equivalent[ ]+){1}|(approx[ ]+){1}|(factorof[ ]+){1}){0,1}){1}|(((exp[ ]+){1}|(ln[ ]+){1}|(log[ ]+){1}|(logbase[ ]+){1}|(sin[ ]+){1}|(cos[ ]+){1}|(tan[ ]+){1}|(sec[ ]+){1}|(csc[ ]+){1}|(cot[ ]+){1}|(arcsin[ ]+){1}|(arccos[ ]+){1}|(arctan[ ]+){1}|(arcsec[ ]+){1}|(arccsc[ ]+){1}|(arccot[ ]+){1}|(sinh[ ]+){1}|(cosh[ ]+){1}|(tanh[ ]+){1}|(sech[ ]+){1}|(csch[ ]+){1}|(coth[ ]+){1}|(arccosh[ ]+){1}|(arccoth[ ]+){1}|(arccsch[ ]+){1}|(arcsech[ ]+){1}|(arcsinh[ ]+){1}|(arctanh[ ]+){1}){0,1}){1}|(((int[ ]+){1}|(diff[ ]+){1}|(partialdiff[ ]+){1}|(limit[ ]+){1}|(lowlimit[ ]+){1}|(uplimit[ ]+){1}|(tendsto[ ]+){1}){0,1}){1}|(((vector[ ]+){1}|(matrix[ ]+){1}|(determinant[ ]+){1}|(transpose[ ]+){1}|(selector[ ]+){1}|(vectorproduct[ ]+){1}|(scalarproduct[ ]+){1}|(outerproduct[ ]+){1}){0,1}){1}|(((divergence[ ]+){1}|(grad[ ]+){1}|(curl[ ]+){1}|(laplacian[ ]+){1}){0,1}){1}|(((mean[ ]+){1}|(sdev[ ]+){1}|(variance[ ]+){1}|(median[ ]+){1}|(mode[ ]+){1}|(moment[ ]+){1}|(momentabout[ ]+){1}){0,1}){1}|(((apply[ ]+){1}|(interval[ ]+){1}|(inverse[ ]+){1}|(condition[ ]+){1}|(declare[ ]+){1}|(lambda[ ]+){1}|(piecewise[ ]+){1}|(bvar[ ]+){1}|(degree[ ]+){1}){0,1}){1}|(semantics[ ]+){1}){0,1}){1}|(((((mi[ ]+){1}|(mo[ ]+){1}|(mn[ ]+){1}|(mtext[ ]+){1}|(ms[ ]+){1}){0,1}){1}|(((mrow[ ]+){1}|(mfrac[ ]+){1}|(msqrt[ ]+){1}|(mroot[ ]+){1}|(mpadded[ ]+){1}|(mphantom[ ]+){1}|(mfenced[ ]+){1}|(menclose[ ]+){1}){0,1}){1}|(((msub[ ]+){1}|(msup[ ]+){1}|(msubsup[ ]+){1}|(munder[ ]+){1}|(mover[ ]+){1}|(munderover[ ]+){1}|(mmultiscripts[ ]+){1}){0,1}){1}|(((mtable[ ]+){1}|(maligngroup[ ]+){1}|(malignmark[ ]+){1}){0,1}){1}|(mspace[ ]+){1}|(maction[ ]+){1}|(merror[ ]+){1}|(mstyle[ ]+){1}){0,1}){1}){0,1}){1}){1}";
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
    protected MspaceType mspace;
    protected ArithType imaginary;
    protected UnionType union;
    protected MatrixType matrix;
    protected ArithType minus;
    protected MaligngroupType maligngroup;
    protected ConstantType primes;
    protected IntersectType intersect;
    protected InType in;
    protected MfencedType mfenced;
    protected RelationsType leq;
    protected VectorType vector;
    protected ArithType floor;
    protected ElementaryFunctionsType exp;
    protected ElementaryFunctionsType arctan;
    protected ConstantType falseValue;
    protected ArithType gcd;
    protected FunctionsType codomain;
    protected ConstantType emptyset;
    protected ConstantType reals;
    protected InverseType inverse;
    protected ArithType product;
    protected ElementaryFunctionsType arcsech;
    protected LogicType exists;
    protected ConstantType pi;
    protected NotinType notin;
    protected CartesianproductType cartesianproduct;
    protected SubsetType subset;
    protected GradType grad;
    protected MrowType mrow;
    protected MerrorType merror;
    protected RelationsType approx;
    protected MtableType mtable;
    protected NotprsubsetType notprsubset;
    protected ArithType abs;
    protected FunctionsType compose;
    protected ConstantType eulergamma;
    protected DegreeType degree;
    protected CnType cn;
    protected MtextType mtext;
    protected ElementaryFunctionsType arcsinh;
    protected MunderType munder;
    protected ArithType ceiling;
    protected FunctionsType image;
    protected MalignmarkType malignmark;
    protected ElementaryFunctionsType sech;
    protected CurlType curl;
    protected SetType set;
    protected DeclareType declare;
    protected ArithType max;
    protected CiType ci;
    protected ArithType divide;
    protected LogicType xor;
    protected ElementaryFunctionsType arccsc;
    protected MomentaboutType momentabout;
    protected ElementaryFunctionsType sec;
    protected ArithType conjugate;
    protected RelationsType geq;
    protected ArithType min;
    protected ArithType arg;
    protected ArithType sum;
    protected DiffType diff;
    protected ElementaryFunctionsType log;
    protected MsqrtType msqrt;
    protected ElementaryFunctionsType arcsin;
    protected CardType card;
    protected LogbaseType logbase;
    protected ElementaryFunctionsType tanh;
    protected DivergenceType divergence;
    protected ArithType times;
    protected ElementaryFunctionsType arccosh;
    protected MactionType maction;
    protected ArithType root;
    protected PiecewiseType piecewise;
    protected MfracType mfrac;
    protected RelationsType eq;
    protected ElementaryFunctionsType coth;
    protected MomentType moment;
    protected ElementaryFunctionsType tan;
    protected MnType mn;
    protected MoType mo;
    protected MsType ms;
    protected LimitType limit;
    protected LaplacianType laplacian;
    protected CsymbolType csymbol;
    protected ArithType rem;
    protected ArithType power;
    protected ConstantType naturalnumbers;
    protected RelationsType neq;
    protected MiType mi;
    protected ArithType quotient;
    protected MencloseType menclose;
    protected MsupType msup;
    protected ElementaryFunctionsType arccoth;
    protected MoverType mover;
    protected MeanType mean;
    protected MpaddedType mpadded;
    protected ScalarproductType scalarproduct;
    protected SdevType sdev;
    protected RelationsType lt;
    protected ElementaryFunctionsType cot;
    protected ConstantType imaginaryi;
    protected ConstantType notanumber;
    protected ElementaryFunctionsType cosh;
    protected MunderoverType munderover;
    protected MstyleType mstyle;
    protected ElementaryFunctionsType arccsch;
    protected PrsubsetType prsubset;
    protected ElementaryFunctionsType ln;
    protected ApplyType apply;
    protected ElementaryFunctionsType cos;
    protected ArithType factorial;
    protected ConstantType infinity;
    protected MrootType mroot;
    protected ElementaryFunctionsType csch;
    protected UplimitType uplimit;
    protected TransposeType transpose;
    protected LogicType implies;
    protected PartialdiffType partialdiff;
    protected DeterminantType determinant;
    protected VectorproductType vectorproduct;
    protected ModeType mode;
    protected ElementaryFunctionsType csc;
    protected ConditionType condition;
    protected LambdaType lambda;
    protected OuterproductType outerproduct;
    protected VarianceType variance;
    protected ArithType real;
    protected ListType list;
    protected NotsubsetType notsubset;
    protected RelationsType gt;
    protected ElementaryFunctionsType arccot;
    protected ArithType plus;
    protected ElementaryFunctionsType arccos;
    protected IntType intValue;
    protected TendstoType tendsto;
    protected ConstantType integers;
    protected MsubType msub;
    protected RelationsType equivalent;
    protected LowlimitType lowlimit;
    protected LogicType or;
    protected FunctionsType ident;
    protected LogicType forall;
    protected MsubsupType msubsup;
    protected ElementaryFunctionsType sin;
    protected SelectorType selector;
    protected RelationsType factorof;
    protected MphantomType mphantom;
    protected ConstantType rationals;
    protected SetdiffType setdiff;
    protected LogicType not;
    protected MedianType median;
    protected ElementaryFunctionsType and;
    protected ArithType lcm;
    protected FunctionsType domain;
    protected ConstantType exponentiale;
    protected ElementaryFunctionsType arctanh;
    protected BvarType bvar;
    protected SemanticsType semantics;
    protected ElementaryFunctionsType arcsec;
    protected ElementaryFunctionsType sinh;
    protected ConstantType trueValue;
    protected IntervalType interval;
    protected DomainofapplicationType domainofapplication;
    protected MmultiscriptsType mmultiscripts;
    protected ConstantType complexes;

    static {
        ALLOWED_ATTRIBUTES.add("class");
        try {
            ATTRIBUTES_NAME_MAP.put("class", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "NMTOKENS"));
            ATTRIBUTES_NAME_MAP.put("xref", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "IDREF"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ATTRIBUTES_NAME_MAP.put("href", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ATTRIBUTES_NAME_MAP.put("style", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("encoding", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "string"));
            ATTRIBUTES_NAME_MAP.put("definitionURL", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "anyURI"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mspace"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mspace"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mspace.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mspace"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mspace"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginary"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginary"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginary"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginary"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "union"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "union"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "union.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "union"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "union"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "matrix"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "matrix"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "matrix.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "matrix"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "matrix"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "minus"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "minus"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "minus"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "minus"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maligngroup"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maligngroup"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maligngroup.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maligngroup"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maligngroup"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "primes"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "primes"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "primes"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "primes"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "intersect"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "intersect"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "intersect.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "intersect"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "intersect"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "in"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "in"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "in.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "in"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "in"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfenced"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfenced"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfenced.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfenced"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfenced"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "leq"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "leq"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "leq"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "leq"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vector"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vector"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vector.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vector"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vector"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "floor"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "floor"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "floor"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "floor"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exp"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exp"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exp"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exp"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctan"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctan"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctan"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctan"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "false"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "false"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "false"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "false"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gcd"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gcd"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gcd"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gcd"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "codomain"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "codomain"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "codomain"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "codomain"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "emptyset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "emptyset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "emptyset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "emptyset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "reals"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "reals"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "reals"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "reals"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "inverse"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "inverse"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "inverse.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "inverse"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "inverse"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "product"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "product"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "product"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "product"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsech"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsech"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsech"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsech"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exists"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exists"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exists"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exists"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "pi"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "pi"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "pi"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "pi"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notin"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notin"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notin.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cartesianproduct"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cartesianproduct"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cartesianproduct.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cartesianproduct"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cartesianproduct"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "subset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "subset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "subset.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "subset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "subset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "grad"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "grad"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "grad.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "grad"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "grad"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mrow"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mrow"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mrow.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mrow"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mrow"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "merror"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "merror"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "merror.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "merror"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "merror"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "approx"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "approx"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "approx"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "approx"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtable"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtable"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtable.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtable"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtable"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notprsubset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notprsubset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notprsubset.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notprsubset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notprsubset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "abs"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "abs"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "abs"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "abs"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "compose"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "compose"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "compose"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "compose"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eulergamma"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eulergamma"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eulergamma"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eulergamma"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "degree"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "degree"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "degree.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "degree"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "degree"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cn"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cn"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cn.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cn"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cn"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtext"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtext"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtext.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtext"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtext"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsinh"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsinh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsinh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsinh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munder"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munder"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munder.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munder"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munder"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ceiling"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ceiling"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ceiling"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ceiling"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "image"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "image"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "image"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "image"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "malignmark"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "malignmark"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "malignmark.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "malignmark"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "malignmark"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sech"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sech"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sech"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sech"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "curl"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "curl"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "curl.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "curl"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "curl"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "set"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "set"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "set.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "set"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "set"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "declare"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "declare"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "declare.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "declare"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "declare"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "max"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "max"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "max"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "max"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ci"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ci"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ci.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ci"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ci"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divide"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divide"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divide"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divide"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "xor"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "xor"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "xor"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "xor"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsc"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsc"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsc"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsc"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "momentabout"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "momentabout"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "momentabout.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "momentabout"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "momentabout"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sec"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sec"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sec"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sec"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "conjugate"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "conjugate"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "conjugate"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "conjugate"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "geq"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "geq"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "geq"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "geq"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "min"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "min"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "min"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "min"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arg"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arg"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arg"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arg"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sum"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sum"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sum"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "diff"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "diff"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "diff.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "diff"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "diff"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "log"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "log"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "log"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "log"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msqrt"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msqrt"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msqrt.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msqrt"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msqrt"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsin"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsin"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "card"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "card"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "card.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "card"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "card"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "logbase"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "logbase"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "logbase.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "logbase"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "logbase"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tanh"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tanh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tanh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tanh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divergence"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divergence"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divergence.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divergence"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divergence"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "times"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "times"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "times"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "times"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccosh"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccosh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccosh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccosh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maction"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maction"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maction.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maction"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maction"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "root"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "root"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "root"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "root"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "piecewise"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "piecewise"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "piecewise.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "piecewise"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "piecewise"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfrac"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfrac"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfrac.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfrac"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfrac"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eq"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eq"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eq"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eq"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "coth"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "coth"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "coth"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "coth"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "moment"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "moment"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "moment.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "moment"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "moment"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tan"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tan"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tan"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tan"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mn"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mn"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mn.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mn"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mn"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mo"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mo"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mo.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mo"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mo"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ms"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ms"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ms.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ms"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ms"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "limit"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "limit"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "limit.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "limit"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "limit"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "laplacian"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "laplacian"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "laplacian.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "laplacian"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "laplacian"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csymbol"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csymbol"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csymbol.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csymbol"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csymbol"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rem"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rem"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rem"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rem"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "power"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "power"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "power"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "power"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "naturalnumbers"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "naturalnumbers"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "naturalnumbers"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "naturalnumbers"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "neq"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "neq"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "neq"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "neq"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mi"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mi"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mi.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mi"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mi"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "quotient"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "quotient"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "quotient"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "quotient"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "menclose"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "menclose"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "menclose.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "menclose"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "menclose"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msup"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msup"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msup.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msup"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msup"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccoth"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccoth"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccoth"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccoth"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mover"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mover"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mover.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mover"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mover"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mean"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mean"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mean.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mean"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mean"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mpadded"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mpadded"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mpadded.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mpadded"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mpadded"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "scalarproduct"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "scalarproduct"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "scalarproduct.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "scalarproduct"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "scalarproduct"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sdev"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sdev"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sdev.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sdev"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sdev"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lt"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lt"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lt"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lt"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cot"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cot"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cot"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cot"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginaryi"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginaryi"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginaryi"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginaryi"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notanumber"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notanumber"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notanumber"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notanumber"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cosh"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cosh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cosh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cosh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munderover"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munderover"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munderover.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munderover"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munderover"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mstyle"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mstyle"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mstyle.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mstyle"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mstyle"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsch"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsch"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsch"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsch"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "prsubset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "prsubset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "prsubset.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "prsubset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "prsubset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ln"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ln"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ln"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ln"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "apply"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "apply"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "apply.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "apply"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "apply"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cos"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cos"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cos"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cos"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorial"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorial"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorial"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorial"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "infinity"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "infinity"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "infinity"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "infinity"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mroot"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mroot"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mroot.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mroot"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mroot"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csch"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csch"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csch"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csch"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "uplimit"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "uplimit"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "uplimit.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "uplimit"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "uplimit"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "transpose"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "transpose"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "transpose.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "transpose"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "transpose"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "implies"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "implies"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "implies"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "implies"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "partialdiff"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "partialdiff"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "partialdiff.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "partialdiff"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "partialdiff"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "determinant"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "determinant"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "determinant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "determinant"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "determinant"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vectorproduct"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vectorproduct"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vectorproduct.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vectorproduct"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vectorproduct"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mode"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mode"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mode.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mode"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mode"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csc"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csc"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csc"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csc"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "condition"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "condition"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "condition.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "condition"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "condition"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lambda"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lambda"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lambda.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lambda"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lambda"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "outerproduct"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "outerproduct"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "outerproduct.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "outerproduct"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "outerproduct"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "variance"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "variance"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "variance.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "variance"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "variance"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "real"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "real"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "real"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "real"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "list"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "list"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "list.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "list"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "list"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notsubset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notsubset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notsubset.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notsubset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notsubset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gt"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gt"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gt"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gt"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccot"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccot"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccot"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccot"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "plus"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "plus"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "plus"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "plus"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccos"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccos"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccos"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccos"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "int"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "int"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "int.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "int"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tendsto"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tendsto"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tendsto.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tendsto"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tendsto"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "integers"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "integers"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "integers"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "integers"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msub"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msub"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msub.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msub"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msub"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "equivalent"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "equivalent"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "equivalent"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "equivalent"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lowlimit"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lowlimit"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lowlimit.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lowlimit"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lowlimit"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "or"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "or"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "or"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "or"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ident"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ident"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ident"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ident"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "forall"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "forall"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "forall"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "forall"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msubsup"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msubsup"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msubsup.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msubsup"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msubsup"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sin"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sin"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sin"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "selector"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "selector"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "selector.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "selector"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "selector"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorof"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorof"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorof"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorof"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mphantom"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mphantom"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mphantom.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mphantom"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mphantom"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rationals"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rationals"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rationals"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rationals"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "setdiff"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "setdiff"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "setdiff.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "setdiff"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "setdiff"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "not"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "not"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "not"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "not"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "median"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "median"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "median.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "median"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "median"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "and"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "and"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "and"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "and"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lcm"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lcm"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lcm"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lcm"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domain"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domain"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domain"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domain"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exponentiale"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exponentiale"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exponentiale"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exponentiale"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctanh"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctanh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctanh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctanh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "bvar"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "bvar"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "bvar.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "bvar"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "bvar"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "semantics"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "semantics"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "semantics.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "semantics"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "semantics"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsec"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsec"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsec"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsec"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sinh"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sinh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sinh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sinh"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "true"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "true"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "true"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "true"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "interval"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "interval"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "interval.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "interval"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "interval"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domainofapplication"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domainofapplication"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domainofapplication.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domainofapplication"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domainofapplication"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mmultiscripts"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mmultiscripts"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mmultiscripts.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mmultiscripts"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mmultiscripts"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "complexes"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "complexes"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "complexes"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "complexes"), Integer.valueOf("1"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("xref");
        ALLOWED_ATTRIBUTES.add("id");
        ALLOWED_ATTRIBUTES.add("href");
        ALLOWED_ATTRIBUTES.add("style");
        ALLOWED_ATTRIBUTES.add("encoding");
        ALLOWED_ATTRIBUTES.add("definitionURL");
        ALLOWED_ATTRIBUTES.add("##other");
    }

    public LowlimitType(XmlComplexType elem) {
        super(elem, LowlimitType.class);
    }

    public MspaceType getMspace()
        throws IOException
    {
        if (mspace == null) {
            try {
                mspace = ((MspaceType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mspace"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mspace.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mspace;
    }

    public ArithType getImaginary()
        throws IOException
    {
        if (imaginary == null) {
            try {
                imaginary = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginary"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return imaginary;
    }

    public UnionType getUnion()
        throws IOException
    {
        if (union == null) {
            try {
                union = ((UnionType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "union"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "union.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return union;
    }

    public MatrixType getMatrix()
        throws IOException
    {
        if (matrix == null) {
            try {
                matrix = ((MatrixType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "matrix"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "matrix.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return matrix;
    }

    public ArithType getMinus()
        throws IOException
    {
        if (minus == null) {
            try {
                minus = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "minus"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return minus;
    }

    public MaligngroupType getMaligngroup()
        throws IOException
    {
        if (maligngroup == null) {
            try {
                maligngroup = ((MaligngroupType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maligngroup"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maligngroup.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return maligngroup;
    }

    public ConstantType getPrimes()
        throws IOException
    {
        if (primes == null) {
            try {
                primes = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "primes"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return primes;
    }

    public IntersectType getIntersect()
        throws IOException
    {
        if (intersect == null) {
            try {
                intersect = ((IntersectType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "intersect"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "intersect.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intersect;
    }

    public InType getIn()
        throws IOException
    {
        if (in == null) {
            try {
                in = ((InType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "in"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "in.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return in;
    }

    public MfencedType getMfenced()
        throws IOException
    {
        if (mfenced == null) {
            try {
                mfenced = ((MfencedType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfenced"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfenced.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mfenced;
    }

    public RelationsType getLeq()
        throws IOException
    {
        if (leq == null) {
            try {
                leq = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "leq"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return leq;
    }

    public VectorType getVector()
        throws IOException
    {
        if (vector == null) {
            try {
                vector = ((VectorType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vector"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vector.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vector;
    }

    public ArithType getFloor()
        throws IOException
    {
        if (floor == null) {
            try {
                floor = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "floor"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return floor;
    }

    public ElementaryFunctionsType getExp()
        throws IOException
    {
        if (exp == null) {
            try {
                exp = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exp"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return exp;
    }

    public ElementaryFunctionsType getArctan()
        throws IOException
    {
        if (arctan == null) {
            try {
                arctan = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctan"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arctan;
    }

    public ConstantType getFalseValue()
        throws IOException
    {
        if (falseValue == null) {
            try {
                falseValue = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "false"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return falseValue;
    }

    public ArithType getGcd()
        throws IOException
    {
        if (gcd == null) {
            try {
                gcd = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gcd"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return gcd;
    }

    public FunctionsType getCodomain()
        throws IOException
    {
        if (codomain == null) {
            try {
                codomain = ((FunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "codomain"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return codomain;
    }

    public ConstantType getEmptyset()
        throws IOException
    {
        if (emptyset == null) {
            try {
                emptyset = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "emptyset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return emptyset;
    }

    public ConstantType getReals()
        throws IOException
    {
        if (reals == null) {
            try {
                reals = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "reals"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return reals;
    }

    public InverseType getInverse()
        throws IOException
    {
        if (inverse == null) {
            try {
                inverse = ((InverseType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "inverse"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "inverse.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return inverse;
    }

    public ArithType getProduct()
        throws IOException
    {
        if (product == null) {
            try {
                product = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "product"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return product;
    }

    public ElementaryFunctionsType getArcsech()
        throws IOException
    {
        if (arcsech == null) {
            try {
                arcsech = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsech"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arcsech;
    }

    public LogicType getExists()
        throws IOException
    {
        if (exists == null) {
            try {
                exists = ((LogicType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exists"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return exists;
    }

    public ConstantType getPi()
        throws IOException
    {
        if (pi == null) {
            try {
                pi = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "pi"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return pi;
    }

    public NotinType getNotin()
        throws IOException
    {
        if (notin == null) {
            try {
                notin = ((NotinType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notin"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notin.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return notin;
    }

    public CartesianproductType getCartesianproduct()
        throws IOException
    {
        if (cartesianproduct == null) {
            try {
                cartesianproduct = ((CartesianproductType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cartesianproduct"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cartesianproduct.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cartesianproduct;
    }

    public SubsetType getSubset()
        throws IOException
    {
        if (subset == null) {
            try {
                subset = ((SubsetType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "subset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "subset.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return subset;
    }

    public GradType getGrad()
        throws IOException
    {
        if (grad == null) {
            try {
                grad = ((GradType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "grad"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "grad.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return grad;
    }

    public MrowType getMrow()
        throws IOException
    {
        if (mrow == null) {
            try {
                mrow = ((MrowType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mrow"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mrow.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mrow;
    }

    public MerrorType getMerror()
        throws IOException
    {
        if (merror == null) {
            try {
                merror = ((MerrorType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "merror"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "merror.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return merror;
    }

    public RelationsType getApprox()
        throws IOException
    {
        if (approx == null) {
            try {
                approx = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "approx"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return approx;
    }

    public MtableType getMtable()
        throws IOException
    {
        if (mtable == null) {
            try {
                mtable = ((MtableType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtable"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtable.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mtable;
    }

    public NotprsubsetType getNotprsubset()
        throws IOException
    {
        if (notprsubset == null) {
            try {
                notprsubset = ((NotprsubsetType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notprsubset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notprsubset.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return notprsubset;
    }

    public ArithType getAbs()
        throws IOException
    {
        if (abs == null) {
            try {
                abs = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "abs"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return abs;
    }

    public FunctionsType getCompose()
        throws IOException
    {
        if (compose == null) {
            try {
                compose = ((FunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "compose"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return compose;
    }

    public ConstantType getEulergamma()
        throws IOException
    {
        if (eulergamma == null) {
            try {
                eulergamma = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eulergamma"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return eulergamma;
    }

    public DegreeType getDegree()
        throws IOException
    {
        if (degree == null) {
            try {
                degree = ((DegreeType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "degree"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "degree.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return degree;
    }

    public CnType getCn()
        throws IOException
    {
        if (cn == null) {
            try {
                cn = ((CnType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cn"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cn.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cn;
    }

    public MtextType getMtext()
        throws IOException
    {
        if (mtext == null) {
            try {
                mtext = ((MtextType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtext"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mtext.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mtext;
    }

    public ElementaryFunctionsType getArcsinh()
        throws IOException
    {
        if (arcsinh == null) {
            try {
                arcsinh = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsinh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arcsinh;
    }

    public MunderType getMunder()
        throws IOException
    {
        if (munder == null) {
            try {
                munder = ((MunderType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munder"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munder.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return munder;
    }

    public ArithType getCeiling()
        throws IOException
    {
        if (ceiling == null) {
            try {
                ceiling = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ceiling"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ceiling;
    }

    public FunctionsType getImage()
        throws IOException
    {
        if (image == null) {
            try {
                image = ((FunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "image"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return image;
    }

    public MalignmarkType getMalignmark()
        throws IOException
    {
        if (malignmark == null) {
            try {
                malignmark = ((MalignmarkType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "malignmark"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "malignmark.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return malignmark;
    }

    public ElementaryFunctionsType getSech()
        throws IOException
    {
        if (sech == null) {
            try {
                sech = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sech"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sech;
    }

    public CurlType getCurl()
        throws IOException
    {
        if (curl == null) {
            try {
                curl = ((CurlType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "curl"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "curl.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return curl;
    }

    public SetType getSet()
        throws IOException
    {
        if (set == null) {
            try {
                set = ((SetType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "set"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "set.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return set;
    }

    public DeclareType getDeclare()
        throws IOException
    {
        if (declare == null) {
            try {
                declare = ((DeclareType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "declare"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "declare.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return declare;
    }

    public ArithType getMax()
        throws IOException
    {
        if (max == null) {
            try {
                max = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "max"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return max;
    }

    public CiType getCi()
        throws IOException
    {
        if (ci == null) {
            try {
                ci = ((CiType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ci"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ci.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ci;
    }

    public ArithType getDivide()
        throws IOException
    {
        if (divide == null) {
            try {
                divide = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divide"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return divide;
    }

    public LogicType getXor()
        throws IOException
    {
        if (xor == null) {
            try {
                xor = ((LogicType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "xor"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return xor;
    }

    public ElementaryFunctionsType getArccsc()
        throws IOException
    {
        if (arccsc == null) {
            try {
                arccsc = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsc"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arccsc;
    }

    public MomentaboutType getMomentabout()
        throws IOException
    {
        if (momentabout == null) {
            try {
                momentabout = ((MomentaboutType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "momentabout"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "momentabout.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return momentabout;
    }

    public ElementaryFunctionsType getSec()
        throws IOException
    {
        if (sec == null) {
            try {
                sec = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sec"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sec;
    }

    public ArithType getConjugate()
        throws IOException
    {
        if (conjugate == null) {
            try {
                conjugate = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "conjugate"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return conjugate;
    }

    public RelationsType getGeq()
        throws IOException
    {
        if (geq == null) {
            try {
                geq = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "geq"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return geq;
    }

    public ArithType getMin()
        throws IOException
    {
        if (min == null) {
            try {
                min = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "min"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return min;
    }

    public ArithType getArg()
        throws IOException
    {
        if (arg == null) {
            try {
                arg = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arg"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arg;
    }

    public ArithType getSum()
        throws IOException
    {
        if (sum == null) {
            try {
                sum = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sum"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sum;
    }

    public DiffType getDiff()
        throws IOException
    {
        if (diff == null) {
            try {
                diff = ((DiffType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "diff"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "diff.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return diff;
    }

    public ElementaryFunctionsType getLog()
        throws IOException
    {
        if (log == null) {
            try {
                log = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "log"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return log;
    }

    public MsqrtType getMsqrt()
        throws IOException
    {
        if (msqrt == null) {
            try {
                msqrt = ((MsqrtType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msqrt"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msqrt.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return msqrt;
    }

    public ElementaryFunctionsType getArcsin()
        throws IOException
    {
        if (arcsin == null) {
            try {
                arcsin = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsin"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arcsin;
    }

    public CardType getCard()
        throws IOException
    {
        if (card == null) {
            try {
                card = ((CardType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "card"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "card.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return card;
    }

    public LogbaseType getLogbase()
        throws IOException
    {
        if (logbase == null) {
            try {
                logbase = ((LogbaseType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "logbase"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "logbase.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return logbase;
    }

    public ElementaryFunctionsType getTanh()
        throws IOException
    {
        if (tanh == null) {
            try {
                tanh = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tanh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return tanh;
    }

    public DivergenceType getDivergence()
        throws IOException
    {
        if (divergence == null) {
            try {
                divergence = ((DivergenceType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divergence"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "divergence.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return divergence;
    }

    public ArithType getTimes()
        throws IOException
    {
        if (times == null) {
            try {
                times = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "times"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return times;
    }

    public ElementaryFunctionsType getArccosh()
        throws IOException
    {
        if (arccosh == null) {
            try {
                arccosh = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccosh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arccosh;
    }

    public MactionType getMaction()
        throws IOException
    {
        if (maction == null) {
            try {
                maction = ((MactionType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maction"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "maction.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return maction;
    }

    public ArithType getRoot()
        throws IOException
    {
        if (root == null) {
            try {
                root = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "root"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return root;
    }

    public PiecewiseType getPiecewise()
        throws IOException
    {
        if (piecewise == null) {
            try {
                piecewise = ((PiecewiseType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "piecewise"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "piecewise.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return piecewise;
    }

    public MfracType getMfrac()
        throws IOException
    {
        if (mfrac == null) {
            try {
                mfrac = ((MfracType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfrac"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mfrac.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mfrac;
    }

    public RelationsType getEq()
        throws IOException
    {
        if (eq == null) {
            try {
                eq = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "eq"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return eq;
    }

    public ElementaryFunctionsType getCoth()
        throws IOException
    {
        if (coth == null) {
            try {
                coth = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "coth"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return coth;
    }

    public MomentType getMoment()
        throws IOException
    {
        if (moment == null) {
            try {
                moment = ((MomentType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "moment"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "moment.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return moment;
    }

    public ElementaryFunctionsType getTan()
        throws IOException
    {
        if (tan == null) {
            try {
                tan = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tan"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return tan;
    }

    public MnType getMn()
        throws IOException
    {
        if (mn == null) {
            try {
                mn = ((MnType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mn"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mn.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mn;
    }

    public MoType getMo()
        throws IOException
    {
        if (mo == null) {
            try {
                mo = ((MoType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mo"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mo.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mo;
    }

    public MsType getMs()
        throws IOException
    {
        if (ms == null) {
            try {
                ms = ((MsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ms"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ms.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ms;
    }

    public LimitType getLimit()
        throws IOException
    {
        if (limit == null) {
            try {
                limit = ((LimitType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "limit"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "limit.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return limit;
    }

    public LaplacianType getLaplacian()
        throws IOException
    {
        if (laplacian == null) {
            try {
                laplacian = ((LaplacianType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "laplacian"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "laplacian.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return laplacian;
    }

    public CsymbolType getCsymbol()
        throws IOException
    {
        if (csymbol == null) {
            try {
                csymbol = ((CsymbolType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csymbol"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csymbol.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return csymbol;
    }

    public ArithType getRem()
        throws IOException
    {
        if (rem == null) {
            try {
                rem = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rem"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rem;
    }

    public ArithType getPower()
        throws IOException
    {
        if (power == null) {
            try {
                power = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "power"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return power;
    }

    public ConstantType getNaturalnumbers()
        throws IOException
    {
        if (naturalnumbers == null) {
            try {
                naturalnumbers = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "naturalnumbers"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return naturalnumbers;
    }

    public RelationsType getNeq()
        throws IOException
    {
        if (neq == null) {
            try {
                neq = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "neq"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return neq;
    }

    public MiType getMi()
        throws IOException
    {
        if (mi == null) {
            try {
                mi = ((MiType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mi"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mi.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mi;
    }

    public ArithType getQuotient()
        throws IOException
    {
        if (quotient == null) {
            try {
                quotient = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "quotient"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return quotient;
    }

    public MencloseType getMenclose()
        throws IOException
    {
        if (menclose == null) {
            try {
                menclose = ((MencloseType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "menclose"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "menclose.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return menclose;
    }

    public MsupType getMsup()
        throws IOException
    {
        if (msup == null) {
            try {
                msup = ((MsupType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msup"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msup.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return msup;
    }

    public ElementaryFunctionsType getArccoth()
        throws IOException
    {
        if (arccoth == null) {
            try {
                arccoth = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccoth"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arccoth;
    }

    public MoverType getMover()
        throws IOException
    {
        if (mover == null) {
            try {
                mover = ((MoverType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mover"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mover.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mover;
    }

    public MeanType getMean()
        throws IOException
    {
        if (mean == null) {
            try {
                mean = ((MeanType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mean"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mean.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mean;
    }

    public MpaddedType getMpadded()
        throws IOException
    {
        if (mpadded == null) {
            try {
                mpadded = ((MpaddedType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mpadded"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mpadded.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mpadded;
    }

    public ScalarproductType getScalarproduct()
        throws IOException
    {
        if (scalarproduct == null) {
            try {
                scalarproduct = ((ScalarproductType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "scalarproduct"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "scalarproduct.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return scalarproduct;
    }

    public SdevType getSdev()
        throws IOException
    {
        if (sdev == null) {
            try {
                sdev = ((SdevType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sdev"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sdev.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sdev;
    }

    public RelationsType getLt()
        throws IOException
    {
        if (lt == null) {
            try {
                lt = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lt"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lt;
    }

    public ElementaryFunctionsType getCot()
        throws IOException
    {
        if (cot == null) {
            try {
                cot = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cot"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cot;
    }

    public ConstantType getImaginaryi()
        throws IOException
    {
        if (imaginaryi == null) {
            try {
                imaginaryi = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "imaginaryi"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return imaginaryi;
    }

    public ConstantType getNotanumber()
        throws IOException
    {
        if (notanumber == null) {
            try {
                notanumber = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notanumber"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return notanumber;
    }

    public ElementaryFunctionsType getCosh()
        throws IOException
    {
        if (cosh == null) {
            try {
                cosh = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cosh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cosh;
    }

    public MunderoverType getMunderover()
        throws IOException
    {
        if (munderover == null) {
            try {
                munderover = ((MunderoverType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munderover"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "munderover.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return munderover;
    }

    public MstyleType getMstyle()
        throws IOException
    {
        if (mstyle == null) {
            try {
                mstyle = ((MstyleType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mstyle"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mstyle.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mstyle;
    }

    public ElementaryFunctionsType getArccsch()
        throws IOException
    {
        if (arccsch == null) {
            try {
                arccsch = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccsch"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arccsch;
    }

    public PrsubsetType getPrsubset()
        throws IOException
    {
        if (prsubset == null) {
            try {
                prsubset = ((PrsubsetType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "prsubset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "prsubset.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return prsubset;
    }

    public ElementaryFunctionsType getLn()
        throws IOException
    {
        if (ln == null) {
            try {
                ln = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ln"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ln;
    }

    public ApplyType getApply()
        throws IOException
    {
        if (apply == null) {
            try {
                apply = ((ApplyType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "apply"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "apply.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return apply;
    }

    public ElementaryFunctionsType getCos()
        throws IOException
    {
        if (cos == null) {
            try {
                cos = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "cos"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return cos;
    }

    public ArithType getFactorial()
        throws IOException
    {
        if (factorial == null) {
            try {
                factorial = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorial"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return factorial;
    }

    public ConstantType getInfinity()
        throws IOException
    {
        if (infinity == null) {
            try {
                infinity = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "infinity"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return infinity;
    }

    public MrootType getMroot()
        throws IOException
    {
        if (mroot == null) {
            try {
                mroot = ((MrootType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mroot"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mroot.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mroot;
    }

    public ElementaryFunctionsType getCsch()
        throws IOException
    {
        if (csch == null) {
            try {
                csch = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csch"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return csch;
    }

    public UplimitType getUplimit()
        throws IOException
    {
        if (uplimit == null) {
            try {
                uplimit = ((UplimitType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "uplimit"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "uplimit.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return uplimit;
    }

    public TransposeType getTranspose()
        throws IOException
    {
        if (transpose == null) {
            try {
                transpose = ((TransposeType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "transpose"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "transpose.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return transpose;
    }

    public LogicType getImplies()
        throws IOException
    {
        if (implies == null) {
            try {
                implies = ((LogicType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "implies"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return implies;
    }

    public PartialdiffType getPartialdiff()
        throws IOException
    {
        if (partialdiff == null) {
            try {
                partialdiff = ((PartialdiffType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "partialdiff"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "partialdiff.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return partialdiff;
    }

    public DeterminantType getDeterminant()
        throws IOException
    {
        if (determinant == null) {
            try {
                determinant = ((DeterminantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "determinant"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "determinant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return determinant;
    }

    public VectorproductType getVectorproduct()
        throws IOException
    {
        if (vectorproduct == null) {
            try {
                vectorproduct = ((VectorproductType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vectorproduct"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "vectorproduct.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return vectorproduct;
    }

    public ModeType getMode()
        throws IOException
    {
        if (mode == null) {
            try {
                mode = ((ModeType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mode"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mode.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mode;
    }

    public ElementaryFunctionsType getCsc()
        throws IOException
    {
        if (csc == null) {
            try {
                csc = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "csc"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return csc;
    }

    public ConditionType getCondition()
        throws IOException
    {
        if (condition == null) {
            try {
                condition = ((ConditionType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "condition"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "condition.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return condition;
    }

    public LambdaType getLambda()
        throws IOException
    {
        if (lambda == null) {
            try {
                lambda = ((LambdaType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lambda"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lambda.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lambda;
    }

    public OuterproductType getOuterproduct()
        throws IOException
    {
        if (outerproduct == null) {
            try {
                outerproduct = ((OuterproductType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "outerproduct"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "outerproduct.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return outerproduct;
    }

    public VarianceType getVariance()
        throws IOException
    {
        if (variance == null) {
            try {
                variance = ((VarianceType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "variance"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "variance.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return variance;
    }

    public ArithType getReal()
        throws IOException
    {
        if (real == null) {
            try {
                real = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "real"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return real;
    }

    public ListType getList()
        throws IOException
    {
        if (list == null) {
            try {
                list = ((ListType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "list"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "list.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return list;
    }

    public NotsubsetType getNotsubset()
        throws IOException
    {
        if (notsubset == null) {
            try {
                notsubset = ((NotsubsetType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notsubset"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "notsubset.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return notsubset;
    }

    public RelationsType getGt()
        throws IOException
    {
        if (gt == null) {
            try {
                gt = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "gt"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return gt;
    }

    public ElementaryFunctionsType getArccot()
        throws IOException
    {
        if (arccot == null) {
            try {
                arccot = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccot"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arccot;
    }

    public ArithType getPlus()
        throws IOException
    {
        if (plus == null) {
            try {
                plus = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "plus"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return plus;
    }

    public ElementaryFunctionsType getArccos()
        throws IOException
    {
        if (arccos == null) {
            try {
                arccos = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arccos"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arccos;
    }

    public IntType getIntValue()
        throws IOException
    {
        if (intValue == null) {
            try {
                intValue = ((IntType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "int"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "int.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return intValue;
    }

    public TendstoType getTendsto()
        throws IOException
    {
        if (tendsto == null) {
            try {
                tendsto = ((TendstoType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tendsto"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "tendsto.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return tendsto;
    }

    public ConstantType getIntegers()
        throws IOException
    {
        if (integers == null) {
            try {
                integers = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "integers"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return integers;
    }

    public MsubType getMsub()
        throws IOException
    {
        if (msub == null) {
            try {
                msub = ((MsubType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msub"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msub.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return msub;
    }

    public RelationsType getEquivalent()
        throws IOException
    {
        if (equivalent == null) {
            try {
                equivalent = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "equivalent"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return equivalent;
    }

    public LowlimitType getLowlimit()
        throws IOException
    {
        if (lowlimit == null) {
            try {
                lowlimit = ((LowlimitType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lowlimit"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lowlimit.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lowlimit;
    }

    public LogicType getOr()
        throws IOException
    {
        if (or == null) {
            try {
                or = ((LogicType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "or"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return or;
    }

    public FunctionsType getIdent()
        throws IOException
    {
        if (ident == null) {
            try {
                ident = ((FunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "ident"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return ident;
    }

    public LogicType getForall()
        throws IOException
    {
        if (forall == null) {
            try {
                forall = ((LogicType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "forall"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return forall;
    }

    public MsubsupType getMsubsup()
        throws IOException
    {
        if (msubsup == null) {
            try {
                msubsup = ((MsubsupType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msubsup"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "msubsup.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return msubsup;
    }

    public ElementaryFunctionsType getSin()
        throws IOException
    {
        if (sin == null) {
            try {
                sin = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sin"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sin;
    }

    public SelectorType getSelector()
        throws IOException
    {
        if (selector == null) {
            try {
                selector = ((SelectorType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "selector"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "selector.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return selector;
    }

    public RelationsType getFactorof()
        throws IOException
    {
        if (factorof == null) {
            try {
                factorof = ((RelationsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "factorof"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Relations.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return factorof;
    }

    public MphantomType getMphantom()
        throws IOException
    {
        if (mphantom == null) {
            try {
                mphantom = ((MphantomType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mphantom"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mphantom.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mphantom;
    }

    public ConstantType getRationals()
        throws IOException
    {
        if (rationals == null) {
            try {
                rationals = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "rationals"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return rationals;
    }

    public SetdiffType getSetdiff()
        throws IOException
    {
        if (setdiff == null) {
            try {
                setdiff = ((SetdiffType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "setdiff"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "setdiff.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return setdiff;
    }

    public LogicType getNot()
        throws IOException
    {
        if (not == null) {
            try {
                not = ((LogicType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "not"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Logic.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return not;
    }

    public MedianType getMedian()
        throws IOException
    {
        if (median == null) {
            try {
                median = ((MedianType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "median"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "median.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return median;
    }

    public ElementaryFunctionsType getAnd()
        throws IOException
    {
        if (and == null) {
            try {
                and = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "and"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return and;
    }

    public ArithType getLcm()
        throws IOException
    {
        if (lcm == null) {
            try {
                lcm = ((ArithType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "lcm"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Arith.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return lcm;
    }

    public FunctionsType getDomain()
        throws IOException
    {
        if (domain == null) {
            try {
                domain = ((FunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domain"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return domain;
    }

    public ConstantType getExponentiale()
        throws IOException
    {
        if (exponentiale == null) {
            try {
                exponentiale = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "exponentiale"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return exponentiale;
    }

    public ElementaryFunctionsType getArctanh()
        throws IOException
    {
        if (arctanh == null) {
            try {
                arctanh = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arctanh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arctanh;
    }

    public BvarType getBvar()
        throws IOException
    {
        if (bvar == null) {
            try {
                bvar = ((BvarType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "bvar"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "bvar.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return bvar;
    }

    public SemanticsType getSemantics()
        throws IOException
    {
        if (semantics == null) {
            try {
                semantics = ((SemanticsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "semantics"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "semantics.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return semantics;
    }

    public ElementaryFunctionsType getArcsec()
        throws IOException
    {
        if (arcsec == null) {
            try {
                arcsec = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "arcsec"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return arcsec;
    }

    public ElementaryFunctionsType getSinh()
        throws IOException
    {
        if (sinh == null) {
            try {
                sinh = ((ElementaryFunctionsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "sinh"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Elementary-functions.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sinh;
    }

    public ConstantType getTrueValue()
        throws IOException
    {
        if (trueValue == null) {
            try {
                trueValue = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "true"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return trueValue;
    }

    public IntervalType getInterval()
        throws IOException
    {
        if (interval == null) {
            try {
                interval = ((IntervalType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "interval"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "interval.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return interval;
    }

    public DomainofapplicationType getDomainofapplication()
        throws IOException
    {
        if (domainofapplication == null) {
            try {
                domainofapplication = ((DomainofapplicationType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domainofapplication"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "domainofapplication.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return domainofapplication;
    }

    public MmultiscriptsType getMmultiscripts()
        throws IOException
    {
        if (mmultiscripts == null) {
            try {
                mmultiscripts = ((MmultiscriptsType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mmultiscripts"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "mmultiscripts.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return mmultiscripts;
    }

    public ConstantType getComplexes()
        throws IOException
    {
        if (complexes == null) {
            try {
                complexes = ((ConstantType) getChild(new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "complexes"), new XmlQName(new URI("http://www.w3.org/1998/Math/MathML"), "Constant.type"), LowlimitType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return complexes;
    }

}
