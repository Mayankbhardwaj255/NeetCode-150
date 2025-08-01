public class FloydWarshall {
    static final int INF = Integer.MAX_VALUE;

    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Step 1: Copy the input graph to dist matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Step 2: Floyd-Warshall core logic
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Only update if both paths are not INF
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 3: Print the shortest path matrix
        System.out.println("All-pairs shortest path matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;

        int[][] graph = {
            {0,     3,     INF,   5},
            {2,     0,     INF,   4},
            {INF,   1,     0,     INF},
            {INF,   INF,   2,     0}
        };

        floydWarshall(graph);
    }
}
