# XMLLoader

## This contains:

  * XMLLoaderCreator: Used for auto-generating classes from .xsd-Files

  * core: Basic classes used for parsing XML-documents

  * example: Examples for auto-generated classes

## Recommended use(e.g.):

'''java
ColladaFile schemaFile = new ColladaFile("Sample.xml");
ExecutorService exec = Executors.newFixedThreadPool(8);
XmlLoader loader = new XmlLoader(schemaFile, exec);
loader.file.index("COLLADA");
double[] values = root.getValuesByPath("::descendant-or-self/ymag", new double[0]);
'''

It's recommended to use the "getValuesByPath" or "createElementsByPath" method, cause it's not sure if the structure of the underlying classes persists.
