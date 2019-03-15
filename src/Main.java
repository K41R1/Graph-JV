public class Main {

    public static void main(String[] args) {
        GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(6);
        g.addEdge(0, 1);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.addEdge(2, 4);
        g.addEdge(1, 2);
        g.printMatrix();
        System.out.println("degree of 0 : " + g.getDegreeOf(0));
        System.out.println("get total edges : " + g.getEdges());
        System.out.println("direct path between : " + g.directPathExist(0,3));
        System.out.println("direct path between : " + g.directPathExist(0,4));
        System.out.println("is isolated 5 : " + g.isIsolated(5));
    }
}
