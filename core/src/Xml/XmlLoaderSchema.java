package Xml;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import XmlComplexTypes.XmlAll;
import XmlComplexTypes.XmlAltType;
import XmlComplexTypes.XmlAnnotation;
import XmlComplexTypes.XmlAny;
import XmlComplexTypes.XmlAnyAttribute;
import XmlComplexTypes.XmlAppinfo;
import XmlComplexTypes.XmlAssertion;
import XmlComplexTypes.XmlAttribute;
import XmlComplexTypes.XmlAttributeGroup;
import XmlComplexTypes.XmlAttributeGroupRef;
import XmlComplexTypes.XmlComplexContent;
import XmlComplexTypes.XmlComplexRestriction;
import XmlComplexTypes.XmlDefaultOpenContent;
import XmlComplexTypes.XmlDocumentation;
import XmlComplexTypes.XmlElement;
import XmlComplexTypes.XmlExplicitGroup;
import XmlComplexTypes.XmlExtension;
import XmlComplexTypes.XmlFacet;
import XmlComplexTypes.XmlField;
import XmlComplexTypes.XmlGroup;
import XmlComplexTypes.XmlGroupRef;
import XmlComplexTypes.XmlImport;
import XmlComplexTypes.XmlInclude;
import XmlComplexTypes.XmlKeybase;
import XmlComplexTypes.XmlKeyref;
import XmlComplexTypes.XmlList;
import XmlComplexTypes.XmlLocalComplexType;
import XmlComplexTypes.XmlLocalElement;
import XmlComplexTypes.XmlLocalSimpleType;
import XmlComplexTypes.XmlNamedAttributeGroup;
import XmlComplexTypes.XmlNamedGroup;
import XmlComplexTypes.XmlNotation;
import XmlComplexTypes.XmlOpenContent;
import XmlComplexTypes.XmlOverride;
import XmlComplexTypes.XmlRedefine;
import XmlComplexTypes.XmlRestriction;
import XmlComplexTypes.XmlSchema;
import XmlComplexTypes.XmlSelector;
import XmlComplexTypes.XmlSimpleContent;
import XmlComplexTypes.XmlSimpleExtension;
import XmlComplexTypes.XmlSimpleRestriction;
import XmlComplexTypes.XmlSimpleType;
import XmlComplexTypes.XmlTopLevelAttribute;
import XmlComplexTypes.XmlTopLevelComplexType;
import XmlComplexTypes.XmlTopLevelElement;
import XmlComplexTypes.XmlTopLevelSimpleType;
import XmlComplexTypes.XmlUnion;
import XmlComplexTypes.XmlWildcard;

/**
 * A loader for Schema documents.
 *
 */
public class XmlLoaderSchema extends XmlLoader{
	
	protected final static Map<XmlQName, Class<? extends XmlType>> NAME_CLASS_MAP = new HashMap<XmlQName, Class<? extends XmlType>>();
	/**
	 * This loaders supported namespaces.
	 */
	public static final Set<URI> SUPPORTED_URIS = new HashSet<URI>();
	
	protected static final URI xs;
	
	static{
		try {
			xs = new URI("http://www.w3.org/2001/XMLSchema");
		} catch (URISyntaxException e) {
			throw new AssertionError("URI not parsable", e);
		}
		SUPPORTED_URIS.add(xs);
		
		Set<XmlQName> supertypes = new HashSet<XmlQName>();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "allNNI", supertypes), XmlSimpleTypes.XmlAllNNI.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "anyURI", supertypes), XmlSimpleTypes.XmlAnyURI.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "base64Binary", supertypes), XmlSimpleTypes.XmlBase64Binary.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "wildcard/basicNamespaceList", supertypes), XmlSimpleTypes.XmlBasicNamespaceListRestricted.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "blockSet"), XmlSimpleTypes.XmlBlock.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "boolean", supertypes), XmlSimpleTypes.XmlBoolean.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "IDREFS", supertypes), XmlSimpleTypes.XmlIDREFS.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "ENTITIES", supertypes), XmlSimpleTypes.XmlENTITIES.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "NMTOKENS", supertypes), XmlSimpleTypes.XmlNMTOKENS.class);
		
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "short"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "byte", supertypes), XmlSimpleTypes.XmlByte.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "date", supertypes), XmlSimpleTypes.XmlDate.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "dateTime", supertypes), XmlSimpleTypes.XmlDateTime.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "decimal", supertypes), XmlSimpleTypes.XmlDecimal.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "double", supertypes), XmlSimpleTypes.XmlDouble.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "duration", supertypes), XmlSimpleTypes.XmlDuration.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "NCName"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "ENTITY", supertypes), XmlSimpleTypes.XmlENTITY.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "fullDerivationSet", supertypes), XmlSimpleTypes.XmlFinal.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "float", supertypes), XmlSimpleTypes.XmlFloat.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "NMToken"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "formChoice", supertypes), XmlSimpleTypes.XmlForm.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "wildcard/processContents", supertypes), XmlSimpleTypes.XmlProcessContents.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "gDay", supertypes), XmlSimpleTypes.XmlGDay.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "gMonth", supertypes), XmlSimpleTypes.XmlGMonth.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "gMonthDay", supertypes), XmlSimpleTypes.XmlGMonthDay.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "gYear", supertypes), XmlSimpleTypes.XmlGYear.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "gYearMonth", supertypes), XmlSimpleTypes.XmlGYearMonth.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "hexBinary", supertypes), XmlSimpleTypes.XmlHexBinary.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "NCName"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "ID", supertypes), XmlSimpleTypes.XmlID.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "IDREF", supertypes), XmlSimpleTypes.XmlIDREF.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "long"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "int", supertypes), XmlSimpleTypes.XmlInt.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "decimal"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "integer", supertypes), XmlSimpleTypes.XmlInteger.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "derivationSet", supertypes), XmlSimpleTypes.XmlDerivationSet.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "token"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "language", supertypes), XmlSimpleTypes.XmlLanguage.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "listQName", supertypes), XmlSimpleTypes.XmlListQName.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "integer"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "long", supertypes), XmlSimpleTypes.XmlLong.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "token"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "Name", supertypes), XmlSimpleTypes.XmlName.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "namespaceList", supertypes), XmlSimpleTypes.XmlNamespaceList.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "Name"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "NCName", supertypes), XmlSimpleTypes.XmlNCName.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "space", supertypes), XmlSimpleTypes.XmlSpace.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "nonPositiveInteger"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "negativeInteger", supertypes), XmlSimpleTypes.XmlNegativeInteger.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "token"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "NMTOKEN", supertypes), XmlSimpleTypes.XmlNMTOKEN.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "integer"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "nonNegativeInteger", supertypes), XmlSimpleTypes.XmlNonNegativeInteger.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "nonPositiveInteger", supertypes), XmlSimpleTypes.XmlNonPositiveInteger.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "string"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "normalizedString", supertypes), XmlSimpleTypes.XmlNormalizedString.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "NOTATION", supertypes), XmlSimpleTypes.XmlNOTATION.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "nonNegativeInteger"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "positiveInteger", supertypes), XmlSimpleTypes.XmlPositiveInteger.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "token"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "public", supertypes), XmlSimpleTypes.XmlPublic.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "QName", supertypes), XmlSimpleTypes.XmlQName.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "qnameList", supertypes), XmlSimpleTypes.XmlQNameList.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "qnameListA", supertypes), XmlSimpleTypes.XmlQNameListA.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "int"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "short", supertypes), XmlSimpleTypes.XmlShort.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "string", supertypes), XmlSimpleTypes.XmlString.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "time", supertypes), XmlSimpleTypes.XmlTime.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "normalizedString"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "token", supertypes), XmlSimpleTypes.XmlToken.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "unsignedShort"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "unsignedByte", supertypes), XmlSimpleTypes.XmlUnsignedByte.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "unsignedLong"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "unsignedInt", supertypes), XmlSimpleTypes.XmlUnsignedInt.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "nonNegativeInteger"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "unsignedLong", supertypes), XmlSimpleTypes.XmlUnsignedLong.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "unsignedInt"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "unsignedShort", supertypes), XmlSimpleTypes.XmlUnsignedShort.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "token"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "xpath", supertypes), XmlSimpleTypes.XmlXpath.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "anySimpleType"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "xpathDefaultNamespace", supertypes), XmlSimpleTypes.XmlXpathDefaultNamespace.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "simpleDerivationSet", supertypes), XmlSimpleTypes.XmlFinal.class);
		
		supertypes.clear();
		NAME_CLASS_MAP.put(new XmlQName(xs, "anyType", supertypes), Xml.XmlComplexType.class);
		
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "annotated"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "localComplexType", supertypes), XmlLocalComplexType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "altType", supertypes), XmlAltType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "facet", supertypes), XmlFacet.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "keybase", supertypes), XmlKeybase.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "include", supertypes), XmlInclude.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "import", supertypes), XmlImport.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "localSimpleType", supertypes), XmlLocalSimpleType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "wildcard", supertypes), XmlWildcard.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "simpleRestrictionType", supertypes), XmlSimpleRestriction.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "complexRestrictionType", supertypes), XmlComplexRestriction.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "simpleExtensionType", supertypes), XmlSimpleExtension.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "extensionType", supertypes), XmlExtension.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "selector", supertypes), XmlSelector.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "field", supertypes), XmlField.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "explicitGroup", supertypes), XmlExplicitGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "element", supertypes), XmlElement.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "topLevelElement", supertypes), XmlTopLevelElement.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "simpleType", supertypes), XmlSimpleType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "topLevelSimpleType", supertypes), XmlTopLevelSimpleType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "complexType", supertypes), XmlComplexType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "topLevelComplexType", supertypes), XmlTopLevelComplexType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "group", supertypes), XmlGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "namedGroup", supertypes), XmlNamedGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "attributeGroup", supertypes), XmlAttributeGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "namedAttributeGroup", supertypes), XmlNamedAttributeGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "attribute", supertypes), XmlAttribute.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "topLevelAttribute", supertypes), XmlTopLevelAttribute.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "attributeGroupRef", supertypes), XmlAttributeGroupRef.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "simpleContent", supertypes), XmlSimpleContent.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "complexContent", supertypes), XmlComplexContent.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "openContent", supertypes), XmlOpenContent.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "assertion", supertypes), XmlAssertion.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "assert", supertypes), XmlAssertion.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "all", supertypes), XmlAll.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "namedGroup/all", supertypes), XmlNamedGroup.XmlAll.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "localElement", supertypes), XmlLocalElement.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "groupRef", supertypes), XmlGroupRef.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "choice", supertypes), XmlExplicitGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "sequence", supertypes), XmlExplicitGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "unique", supertypes), XmlKeybase.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "key", supertypes), XmlKeybase.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "notation", supertypes), XmlNotation.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "defaultOpenContent", supertypes), XmlDefaultOpenContent.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "restriction", supertypes), XmlRestriction.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "list", supertypes), XmlList.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "union", supertypes), XmlUnion.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "openAttrs"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "schema", supertypes), XmlSchema.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "annotation", supertypes), XmlAnnotation.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "appinfo"), XmlAppinfo.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "documentation"), XmlDocumentation.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "redefine", supertypes), XmlRedefine.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "override", supertypes), XmlOverride.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "wildcard"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "anyAttribute", supertypes), XmlAnyAttribute.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "any", supertypes), XmlAny.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "redefinable"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "topLevelSimpleType", supertypes), XmlTopLevelSimpleType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "topLevelComplexType", supertypes), XmlTopLevelComplexType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "namedGroup", supertypes), XmlNamedGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "namedAttributeGroup", supertypes), XmlNamedAttributeGroup.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "attrDecls"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "attribute", supertypes), XmlAttribute.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "attributeGroupRef", supertypes), XmlAttributeGroupRef.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "anyAttribute", supertypes), XmlAnyAttribute.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "complexTypeModel"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "simpleContent", supertypes), XmlSimpleContent.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "complexContent", supertypes), XmlComplexContent.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "openContent", supertypes), XmlOpenContent.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "assertion", supertypes), XmlAssertion.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "assert", supertypes), XmlAssertion.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "particle"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "all", supertypes), XmlAll.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "localElement", supertypes), XmlLocalElement.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "groupRef", supertypes), XmlGroupRef.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "choice", supertypes), XmlExplicitGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "sequence", supertypes), XmlExplicitGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "any", supertypes), XmlAny.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "nestedParticle"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "localElement", supertypes), XmlLocalElement.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "groupRef", supertypes), XmlGroupRef.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "choice", supertypes), XmlExplicitGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "sequence", supertypes), XmlExplicitGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "any", supertypes), XmlAny.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "identityConstraint"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "unique", supertypes), XmlKeybase.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "key", supertypes), XmlKeybase.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "keybase"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "keyref", supertypes), XmlKeyref.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "schemaTop"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "topLevelElement", supertypes), XmlTopLevelElement.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "topLevelAttribute", supertypes), XmlTopLevelAttribute.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "notation", supertypes), XmlNotation.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "composition"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "include", supertypes), XmlInclude.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "import", supertypes), XmlImport.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "redefine", supertypes), XmlRedefine.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "annotation", supertypes), XmlAnnotation.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "override", supertypes), XmlOverride.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "simpleDerivation"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "restriction", supertypes), XmlRestriction.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "list", supertypes), XmlList.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "union", supertypes), XmlUnion.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "simpleRestrictionModel"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "localSimpleType", supertypes), XmlLocalSimpleType.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "facet", supertypes), XmlFacet.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "assertion", supertypes), XmlAssertion.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "assert", supertypes), XmlAssertion.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "typeDefParticle"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "groupRef", supertypes), XmlGroupRef.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "all", supertypes), XmlAll.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "choice", supertypes), XmlExplicitGroup.class);
		NAME_CLASS_MAP.put(new XmlQName(xs, "sequence", supertypes), XmlExplicitGroup.class);
		
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "complexTypeModel"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "typeDefParticle", supertypes), null);
		NAME_CLASS_MAP.put(new XmlQName(xs, "attrDecls", supertypes), null);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "simpleRestrictionModel"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "facet", supertypes), XmlFacet.class);
		supertypes.clear();
		supertypes.add(new XmlQName(xs, "schemaTop"));
		NAME_CLASS_MAP.put(new XmlQName(xs, "redefinable", supertypes), null);
	}
	
	/**
	 * The XmlSchemaFile used to create this loader.
	 */
	public final XmlSchemaFile file;

	public XmlLoaderSchema(XmlSchemaFile file) {
		this(file, null);
	}
	
	public XmlLoaderSchema(XmlSchemaFile file, ExecutorService execService) {
		super(file, execService, SUPPORTED_URIS, NAME_CLASS_MAP, null);
		this.file = file;
	}
	
	/**
	 * Returns the Class associated with {@code qualifiedName}.
	 * 
	 * @param qualifiedName The qualified name, used to retrieve the class.
	 * @return The class associated with {@code qualifiedName} or null, if none exists.
	 */
	public static Class<? extends XmlType> getClassByQualifiedName(XmlQName qualifiedName){
		return NAME_CLASS_MAP.get(qualifiedName);
	}
	
	/**
	 * Returns the nameClassMap of this class.
	 * 
	 * @return The nameClassMap of this class.
	 */
	public static Map<XmlQName, Class<? extends XmlType>> getNameClassMap(){
		return NAME_CLASS_MAP;
	}
	
}
