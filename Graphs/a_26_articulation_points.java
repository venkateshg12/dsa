import java.util.ArrayList;
import java.util.List;

public class a_26_articulation_points {

    private static int timer = 1;

    public static void main(String[] args) {

        int n = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // graph from the diagram

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(0).add(3);
        adj.get(3).add(0);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] mark = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, adj, tin, low, mark);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mark[i])
                ans.add(i);
        }

        System.out.println(ans);
    }

    private static void dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin,
            int[] low, boolean[] mark) {
        vis[node] = true;

        tin[node] = low[node] = timer;
        timer++;

        int child = 0;

        for (Integer it : adj.get(node)) {

            if (it == parent)
                continue;

            if (!vis[it]) {

                dfs(it, node, vis, adj, tin, low, mark);

                low[node] = Math.min(low[node], low[it]);

                // articulation condition
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }

                child++;

            } else {

                low[node] = Math.min(low[node], tin[it]);

            }
        }

        // root articulation case
        if (child > 1 && parent == -1) {
            mark[node] = true;
        }
    }
}