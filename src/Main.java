import main.GraphAdjacencyList;
import main.GraphBuilder;
import main.GraphReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static main.GraphBuilder.*;

public class Main {

    public static void main(String[] args) {
        try {
            GraphReader reader = GraphReader.buildFrom("graph.xml");
            build(reader.getType(), reader.getNumVertices());
            buildVertices(reader.getVertex());
            buildEdges(reader.getEdges());
            GraphAdjacencyList graphAdjacencyList = buildGraph();
            System.out.println(graphAdjacencyList.getDegreeOf(0));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
