package main;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class GraphReader {

    private final Document graphXmlFile;
    private final Element root;

    private GraphReader(Document graphXmlFile) {
        this.graphXmlFile = graphXmlFile;
        this.root = graphXmlFile.getDocumentElement();
    }



    public static GraphReader buildFrom(String file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return new GraphReader(builder.parse(new File(file)));
    }

    public String getType() {
        return this.root.getAttribute("type");
    }

    public NodeList getVertex() {
        return this.root.getElementsByTagName("item");
    }

    public NodeList getEdges() {
        return this.root.getElementsByTagName("edge");
    }

    public int getNumVertices() {
        return Integer.parseInt(this.root.getAttribute("vertices"));
    }
}
