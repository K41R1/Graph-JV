package test;

import main.GraphAdjacencyList;
import org.junit.jupiter.api.Test;

public class GraphAdjacencyListTest {

    @Test
    void listOverflow() {
        GraphAdjacencyList g = new GraphAdjacencyList<Integer>(130);
        for (int i = 0; i < 130; i++) {
            g.addVertex(i);
        }
        g.showNeighbors(127);
    }
}
