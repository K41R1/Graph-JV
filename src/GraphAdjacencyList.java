import java.util.LinkedList;

public class GraphAdjacencyList<T> {

    private int vertices;

    private LinkedList<Vertex> adjacencyList;

    public GraphAdjacencyList(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList<Vertex>();
    }

    /**
     * Add new Vertex
     * @param v
     * @return this
     */
    public GraphAdjacencyList<T> addVertex(T v) {
        this.adjacencyList.push(new Vertex<T>(v));
        return this;
    }
    
    public int getEdges() {
        return 0;
    }

    /**
     * @param v
     * @return boolean
     */
    public boolean isIsolated(T v) {
        return this.getDegreeOf(v) <= 0;
    }

    /**
     * @param v
     * @return int
     */
    public int getDegreeOf(T v) {
        for(Vertex it: this.adjacencyList) {
            if (it.getItem() == v) {
                return it.getNeighbors().size();
            }
        }
        return -1;
    }

    /**
     * Add new Edge
     * @param u
     * @param v
     */
    public void addEdge(T u, T v) {
        int x1 = this.findVertexIndexByValue(u);
        int x2 = this.findVertexIndexByValue(v);
        if ((x1 != -1) && (x2 != -1)) {
            this.adjacencyList.get(x1).addNeighbor(v);
            this.adjacencyList.get(x2).addNeighbor(u);
        }
    }

    /**
     * Check if there is a path between (u,v)
     * @param u
     * @param v
     * @return
     */
    public boolean pathExists(T u, T v) {
        LinkedList<Vertex> temp = (LinkedList<Vertex>) this.adjacencyList.clone();
        int x1 = this.findVertexIndexByValue(u);
        Vertex v1 = temp.get(x1);
        if (v1.hasNeighbors()) {
            if (v1.getNeighbors().contains(v)) {
                return true;
            }
            T next = (T) v1.getNeighbors().element();
            return pathExistsUtil(next, v, temp);
        }
        return false;
    }

    /**
     * Utils for pathExists
     * @param u
     * @param v
     * @param temp
     * @return boolean
     */
    private boolean pathExistsUtil(T u, T v, LinkedList<Vertex> temp) {
        int x1 = this.findVertexIndexByValue(u);
        Vertex v1 = temp.get(x1);
        if (v1.hasNeighbors()) {
            if (v1.getNeighbors().contains(v)) {
                return true;
            }
            T next = (T) v1.getNeighbors().pop();
            return pathExistsUtil(next, v, temp);
        }
        return false;
    }

    /**
     * @param v
     * @return int
     */
    private int findVertexIndexByValue(T v) {
        for (int it = 0; it < this.adjacencyList.size(); it++) {
            if (this.adjacencyList.get(it).getItem() == v) {
                return it;
            }
        }
        return -1;
    }

    /**
     * Check if path (u,v) is direct
     * @param u
     * @param v
     * @return
     */
    public boolean directPathExist(T u, T v) {
        int x1 = this.findVertexIndexByValue(u);
        Vertex v1 = this.adjacencyList.get(x1);
        if (v1.hasNeighbors()) {
            return v1.getNeighbors().contains(v);
        }
        return false;
    }

    public void showNeighbors(T i) {
        int x1 = this.findVertexIndexByValue(i);
        this.adjacencyList.get(x1).showNeighbors();

    }
}
