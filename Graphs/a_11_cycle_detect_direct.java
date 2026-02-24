import java.util.ArrayList;

public class a_11_cycle_detect_direct {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = 10;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);

        adj.get(2).add(3);

        adj.get(3).add(4);
        adj.get(3).add(7);

        adj.get(4).add(5);

        adj.get(5).add(6);

        adj.get(7).add(5);

        adj.get(8).add(2);
        adj.get(8).add(9);

        adj.get(9).add(10);

        adj.get(10).add(8);

        boolean[] visited = new boolean[n + 1];
        int[] path = new int[n + 1];
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, path)) {
                    flag = true;
                }
            }
        }
        System.out.println(flag ? "Cycle Detected" : "No Cycle Detected");
    }

    public static boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] path) {
        visited[i] = true;
        path[i] = 1;
        for (int adjElement : adj.get(i)) {
            if (!visited[i]) {
                if (dfs(adjElement, adj, visited, path))
                    return true;
            } else if (path[i] == 1) {
                return true;
            }
        }
        path[i] = 0;
        return false;
    }
}
