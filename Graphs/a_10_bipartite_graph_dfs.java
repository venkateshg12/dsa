import java.util.ArrayList;
import java.util.Arrays;

public class a_10_bipartite_graph_dfs {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = 8;   // 1-based indexing

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Manually adding edges (undirected)

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(7);
        adj.get(7).add(4);

        adj.get(7).add(8);
        adj.get(8).add(7);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(6).add(2);
        adj.get(2).add(6);

        // Color array
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        boolean isBipartite = true;

        // Important: check all components
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, adj, color)) {
                    isBipartite = false;
                    break;
                }
            }
        }

        System.out.println("Color array: " + Arrays.toString(color));
        System.out.println(isBipartite ? 
                "Bipartite Graph" : 
                "Non-Bipartite Graph");
    }

    public static boolean dfs(int node, int col,
                              ArrayList<ArrayList<Integer>> adj,
                              int[] color) {

        color[node] = col;

        for (int neighbor : adj.get(node)) {

            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - col, adj, color)) {
                    return false;
                }
            }
            else if (color[neighbor] == col) {
                return false;
            }
        }

        return true;
    }
}