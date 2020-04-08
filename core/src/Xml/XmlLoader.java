package Xml;

import java.net.URI;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * A Loader for XML-files.
 *
 */
public class XmlLoader extends XmlLoaderExtension{
	
	public final XmlFile file;

	public XmlLoader(XmlFile file) {
		super(new HashSet<XmlLoaderExtension>());
		this.file = file;
		file.setLoader(this);
	}
	
	public XmlLoader(XmlFile file, ExecutorService execService) {
		this(file, execService, null, null, null);
	}
	
	protected XmlLoader(XmlFile file, ExecutorService execService, Set<URI> supportedURIs, Map<XmlQName, Class<? extends XmlType>> nameClassMap, Map<XmlQName, String> selfrefferingGroupPatternMap) {
		super(new HashSet<XmlLoaderExtension>(), execService, supportedURIs, nameClassMap, selfrefferingGroupPatternMap);
		this.file = file;
		file.setLoader(this);
	}

}
