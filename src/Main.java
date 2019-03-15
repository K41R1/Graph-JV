public class Main {

    public static void main(String[] args) {
        GraphAdjacencyList<Integer> g = new GraphAdjacencyList<>(5000);
        for (int i = 1; i <= 50; i++) {
            g.addVertex(i);
        }

        for (int i = 1; i <= 50; i++) {
            int count = (int) (1 + Math.random() * (1 + 25));
            for (int j = 0; j < count; j++) {
                int x = (int) (1 + Math.random()* ((1 + 50)));
                if (x == i) {
                    // Ignore (u,u) and repeat the operation
                    j--;
                    continue;
                }
                g.addEdge(i,x);
            }
        }
        System.out.println("finish seeding !!");

        for (int i = 1; i <= 5; i++) {
            long start = System.currentTimeMillis();
            int d = g.getDegreeOf(i);
            long end = System.currentTimeMillis();
            System.out.println("Degree of " + i + " == " + d);
            System.out.println("time : " + (end - start));
            System.out.println("Neighbors :");
            g.showNeighbors(i);
        }
    }
}
