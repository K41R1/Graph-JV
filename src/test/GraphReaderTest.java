package test;

import main.GraphReader;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphReaderTest {

    final String filePath = "graph.example.xml";
    final GraphReader gr = GraphReader.buildFrom(this.filePath);

    GraphReaderTest() throws IOException, SAXException, ParserConfigurationException {
    }

    @Test
    void getNumVertex() {
        int n = gr.getNumVertices();
        assertEquals(5, n);
    }

    @Test
    void graphType() {
        String type = gr.getType();
        assertEquals("int",type);
    }

    @Test
    void getAllVertex() {
        NodeList vertices = this.gr.getVertex();
        assertEquals(5, vertices.getLength());
    }

    @Test
    void getAllEdges() {
        NodeList edges = this.gr.getEdges();
        assertEquals(4, edges.getLength());
    }
}