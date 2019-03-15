import java.util.Arrays;

public class GraphAdjacencyMatrix {

    private int vertices;

    private int[][] matrix;


    public GraphAdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
        this.initMatrix();
    }

    private void initMatrix() {
        for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    /**
     * add edge between (u,v)
     * @param u
     * @param v
     */
    public void addEdge(int u, int v) {
        this.matrix[u][v] = 1;
        this.matrix[v][u] = 1;
    }

    public void deleteEdge(int u, int v) {
        this.matrix[u][v] = 0;
        this.matrix[v][u] = 0;
    }

    public void deleteVertex(int v) {
        this.vertices--;
        int[][] matrix = new int[this.vertices][this.vertices];

        for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                if (i == v || j == v) {
                    continue;
                }
                matrix[i][j] = this.matrix[i][j];
            }
        }
        this.matrix = null;
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void printMatrix() {
        for (int i = 0; i < this.vertices; i++) {
            System.out.print("[");
            Arrays.stream(this.matrix[i]).forEach(x -> System.out.print(x +", "));
            System.out.println("]");
        }
    }

    public int getDegreeOf(int u) {
        return Arrays.stream(this.matrix[u]).sum();
    }

    public int getEdges() {
        int s = 0;
        for (int i = 0; i < this.vertices; i++) {
            s += Arrays.stream(this.matrix[i]).sum();
        }
        return s/2;
    }

    public boolean directPathExist(int u, int v) {
        return this.matrix[u][v] == 1;
    }

    public boolean isIsolated(int u) {
        return Arrays.stream(this.matrix[u]).sum() == 0;
    }
}
