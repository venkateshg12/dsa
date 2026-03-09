import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a_25_bridges {
    private static int timer = 1;

    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();

        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(1, 4));
        connections.add(Arrays.asList(2, 3));
        connections.add(Arrays.asList(4, 3));

        connections.add(Arrays.asList(5, 6));

        connections.add(Arrays.asList(6, 7));
        connections.add(Arrays.asList(7, 8));
        connections.add(Arrays.asList(8, 9));
        connections.add(Arrays.asList(9, 6));

        connections.add(Arrays.asList(8, 10));

        connections.add(Arrays.asList(10, 11));
        connections.add(Arrays.asList(11, 12));
        connections.add(Arrays.asList(12, 10));

        int n = 12;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n + 1];
        int[] tin = new int[n + 1];
        int[] low = new int[n + 1];
        List<List<Integer>> bridges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, adj, tin, low, bridges);
            }
        }
        System.out.println(bridges.toString());
    }

    private static void dfs(int i, int p, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low,
            List<List<Integer>> bridges) {
        vis[i] = true;
        tin[i] = low[i] = timer;
        timer++;
        for (Integer it : adj.get(i)) {
            if (it == p)
                continue;
            if (!vis[it]) {
                dfs(it, i, vis, adj, tin, low, bridges);
                low[i] = Math.min(low[i], low[it]);
                // node --- it
                if (low[it] > tin[i]) {
                    bridges.add(Arrays.asList(i, it));
                }

            } else {
                low[i] = Math.min(low[i], tin[it]);
            }
        }
    }
}
