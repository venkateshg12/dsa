import java.util.ArrayList;

public class a_07_cycle_detect_dfs {
    public static void main(String[] args) {
        int n = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(5);

        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(6);

        adj.get(4).add(3);

        adj.get(5).add(2);
        adj.get(5).add(7);

        adj.get(6).add(3);
        adj.get(6).add(7);

        adj.get(7).add(5);
        adj.get(7).add(6);

        boolean[] visited = new boolean[n + 1];

        boolean isCycle = dfs(1, -1, visited, adj);
        System.out.println(isCycle ? "Cycle detected" : "No Cycle was detected");
    }

    public static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> list) {
        visited[node] = true;
        for (Integer adjElement : list.get(node)) {
            if (!visited[adjElement]) {
                if (dfs(adjElement, node, visited, list)) {
                    return true;
                }
            } else if (parent != adjElement) {
                return true;
            }
        }
        return false;
    }
}
// TC ---> O(N) + o(N)
// SC ---> o(N + 2E) + O(N)-(for loop connected components)
