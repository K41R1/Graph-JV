package main;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class GraphBuilder {
    private static GraphAdjacencyList graphAdjacencyList;
    private static String type;

    public static void buildVertices(NodeList vertexList) {
        for (int i = 0; i < vertexList.getLength(); i++) {
            graphAdjacencyList.addVertex(vertexList.item(i).getTextContent());
        }
    }

    public static boolean build(String type, int vertices) {
        GraphBuilder.type = type;
        switch (type) {
            case "String":
            {
                 graphAdjacencyList = new GraphAdjacencyList<String>(vertices);
                return true;
            }
            case "int":
            {
                graphAdjacencyList = new GraphAdjacencyList<Integer>(vertices);
                return true;
            }
            case "float":
            {
                graphAdjacencyList = new GraphAdjacencyList<Float>(vertices);
                return true;
            }
            case "object":
            {
                graphAdjacencyList = new GraphAdjacencyList<Object>(vertices);
                return true;
            }
            default: return false;
        }
    }

    public static GraphAdjacencyList buildGraph() {
        return graphAdjacencyList;
    }

    public static void buildEdges(NodeList edgesList) {
        for (int i = 0; i < edgesList.getLength(); i++) {
            Element edge = (org.w3c.dom.Element) edgesList.item(i);
            graphAdjacencyList.addEdge(
                    parseTo(edge.getAttribute("src")),
                    parseTo(edge.getAttribute("dest"))
            );
        }
    }

    private static Object parseTo(String elm) {
        switch (GraphBuilder.type) {
            case "int": return Integer.parseInt(elm);
            case "float": return Float.parseFloat(elm);
        }
        return null;
    }
}
