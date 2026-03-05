import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

public class a_21_MST {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        int V = 5;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // 0 — 1 (2)
        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));

        // 0 — 2 (1)
        adj.get(0).add(new Pair(2, 1));
        adj.get(2).add(new Pair(0, 1));

        // 1 — 2 (1)
        adj.get(1).add(new Pair(2, 1));
        adj.get(2).add(new Pair(1, 1));

        // 1 — 4 (2)
        adj.get(1).add(new Pair(4, 2));
        adj.get(4).add(new Pair(1, 2));

        // 2 — 3 (2)
        adj.get(2).add(new Pair(3, 2));
        adj.get(3).add(new Pair(2, 2));

        // 4 — 3 (1)
        adj.get(4).add(new Pair(3, 1));
        adj.get(3).add(new Pair(4, 1));

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.wt == b.wt) {
                return a.node - b.node;
            }
            return a.wt - b.wt;
        });
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0));
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        // E
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int wt = pq.peek().wt;
            // log E
            pq.remove();
            if (visited[node]) {
                continue;
            }
            list.add(node);
            visited[node] = true;
            sum += wt;
            // E log E
            for (Pair p : adj.get(node)) {
                int edgeWeight = p.wt;
                int adjNode = p.node;
                if (!visited[adjNode]) {
                    pq.add(new Pair(adjNode, edgeWeight));
                }
            }
        }
        System.out.println(sum);
        System.out.println(list.toString());
    }
}

// TC --> E.log(E) + E.log(E)