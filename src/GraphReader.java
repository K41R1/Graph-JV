import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class GraphReader {

    private final Document graphXmlFile;

    private GraphReader(Document graphXmlFile) {
        this.graphXmlFile = graphXmlFile;
    }

    public static GraphReader buildFrom(String file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File xmlDoc = new File(file);
        return new GraphReader(builder.parse(xmlDoc));
    }
}
