import java.util.*;

public class ArticulationPoints {
    private int V; // Number of vertices
    private List<Integer>[] adj; // Adjacency list
    private int time = 0; // Timer for discovery times

    public ArticulationPoints(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add undirected edge
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // DFS function
    private void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] isAP) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, isAP);

                // Update low value
                low[u] = Math.min(low[u], low[v]);

                // Articulation point conditions
                if (parent[u] == -1 && children > 1) {
                    isAP[u] = true;
                }
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Main function to find articulation points
    public void findAPs() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] isAP = new boolean[V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                APUtil(i, visited, disc, low, parent, isAP);
            }
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) {
            if (isAP[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example Graph
        /*
              1 --- 0 --- 2
                    |
                    3
                     \
                      4
        */
        ArticulationPoints g = new ArticulationPoints(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.findAPs();  // Expected output: 0 and 3 are articulation points
    }
}
