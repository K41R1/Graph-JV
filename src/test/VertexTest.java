package test;

import main.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VertexTest {

    @Test
    void item() {
        Vertex v = new Vertex<Integer>(45);
        assertEquals(45,v.getItem());
    }

    @Test
    void hasNeighbors() {
        Vertex v = new Vertex<Integer>(12);
        assertFalse(v.hasNeighbors());
        Vertex v1 = new Vertex<Integer>(12);
        v1.addNeighbor(2);
        v1.addNeighbor(32);
        assertTrue(v1.hasNeighbors());
    }

    @Test
    void hasNeighbor() {
        Vertex v1 = new Vertex<Integer>(12);
        v1.addNeighbor(2);
        v1.addNeighbor(32);
        assertTrue(v1.hasNeighbor(2));
        assertFalse(v1.hasNeighbor(25));
    }

    @Test
    void removeNeighbor() {
        Vertex v1 = new Vertex<Integer>(12);
        v1.addNeighbor(2);
        v1.addNeighbor(32);
        v1.addNeighbor(25);
        assertTrue(v1.hasNeighbor(2));
        v1.removeNeighbor(2);
        assertFalse(v1.hasNeighbor(2));
    }
}
