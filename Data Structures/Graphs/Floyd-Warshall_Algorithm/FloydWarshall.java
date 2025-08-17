import java.util.Arrays;

public class FloydWarshall {

    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0; // Distance to self is 0
                } else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j];
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // No edge
                }
            }
        }

        // Floyd-Warshall DP update
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && 
                        dist[k][j] != Integer.MAX_VALUE && 
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the result
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 2, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 2, 0, 0, 3},
            {0, 0, 0, 0, 6},
            {0, 0, 0, 0, 0}
        };

        floydWarshall(graph);

          int [][] g = {
            {0,   1,   0, 0},
            {0, 0,   -2,  0},
            {0, -2,  0,   2},
            {0, 0, 0, 0}
        };
        floydWarshall(g);
    }
}