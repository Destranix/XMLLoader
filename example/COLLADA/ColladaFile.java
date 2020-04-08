import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import ComplexTypes.COLLADA;
import Xml.XmlComplexType;
import Xml.XmlFile;

public class ColladaFile
    extends XmlFile
{


    public ColladaFile(XmlFile file)
        throws FileNotFoundException
    {
        super(file);
    }

    public ColladaFile(File file)
        throws FileNotFoundException
    {
        super(file);
    }

    public ColladaFile(String filepath)
        throws FileNotFoundException
    {
        this(new File(filepath));
    }

    @Override
    public COLLADA getRoot()
        throws IOException
    {
        if (XmlComplexType.class.equals(roots[ 0 ].getClass())) {
            roots[ 0 ] = ((XmlComplexType) loader.create(roots[ 0 ]));
        }
        return ((COLLADA) roots[ 0 ]);
    }

}
