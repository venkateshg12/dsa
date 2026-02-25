import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class a_06_cycle_detect_bfs {
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

        boolean flag = false;
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (!visited[i]) {
                if (checkForCycle(i, n, adj, visited)) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(flag);
    }

    public static boolean checkForCycle(int src, int n, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> que = new LinkedList<>();
        visited[src] = true;
        que.add(new Pair(src, -1));
        while (!que.isEmpty()) {
            int node = que.peek().node;
            int parent = que.peek().parent;
            que.remove();

            for (int adjElement : adj.get(node)) {
                if (!visited[adjElement]) {
                    visited[adjElement] = true;
                    que.add(new Pair(adjElement, node));
                } else {
                    if (parent != adjElement) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// TC ---> O(V + V + 2E);
// SC ---> O(N) + O(N) |||| que + visited 