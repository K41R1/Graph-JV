package test;

import main.GraphAdjacencyList;
import main.GraphBuilder;
import main.GraphReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GraphBuilderTest {

    GraphReader gr;
    private GraphAdjacencyList graphAdjacencyList;

    @BeforeAll
    public void init() throws IOException, SAXException, ParserConfigurationException {
        this.gr = GraphReader.buildFrom("graph.example.xml");
    }

    @Test
    void build() {
        boolean t =  GraphBuilder.build(gr.getType(), gr.getNumVertices());
        assertTrue(t);
    }

    @Test
    void vertexExists() {
        GraphBuilder.build(gr.getType(), gr.getNumVertices());
        GraphBuilder.buildVertices(gr.getVertex());
        assertNotNull(GraphBuilder.buildGraph());
    }

    @Test
    void EdgesExists() {
        GraphBuilder.build(gr.getType(), gr.getNumVertices());
        GraphBuilder.buildVertices(gr.getVertex());
        GraphBuilder.buildEdges(gr.getEdges());
        assertNotNull(GraphBuilder.buildGraph());
        assertTrue(GraphBuilder.buildGraph().directPathExist(0,3));
        assertTrue(GraphBuilder.buildGraph().directPathExist(1,4));
    }
}
