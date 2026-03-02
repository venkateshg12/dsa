import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class a_17_dijkstra_usingSet {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // 0 — 1 (4)
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 4)));

        // 0 — 2 (4)
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 4)));

        // 1 — 2 (2)
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 2)));

        // 2 — 3 (3)
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 3)));

        // 2 — 4 (1)
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 1)));

        // 2 — 5 (6)
        adj.get(2).add(new ArrayList<>(Arrays.asList(5, 6)));
        adj.get(5).add(new ArrayList<>(Arrays.asList(2, 6)));

        // 3 — 5 (2)
        adj.get(3).add(new ArrayList<>(Arrays.asList(5, 2)));
        adj.get(5).add(new ArrayList<>(Arrays.asList(3, 2)));

        // 4 — 5 (3)
        adj.get(4).add(new ArrayList<>(Arrays.asList(5, 3)));
        adj.get(5).add(new ArrayList<>(Arrays.asList(4, 3)));

        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.dist == b.dist)
                return a.node - b.node;
            return a.dist - b.dist;
        });

        int[] dist = new int[V];
        int S = 0;
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        set.add(new Pair(S, 0));

        while (!set.isEmpty()) {

            Pair curr = set.pollFirst();
            int node = curr.node;
            int dis = curr.dist;

            for (ArrayList<Integer> it : adj.get(node)) {

                int adjNode = it.get(0);
                int weight = it.get(1);

                if (dis + weight < dist[adjNode]) {

                    // remove old value if exists
                    if (dist[adjNode] != (int) 1e9) {
                        set.remove(new Pair(adjNode,dist[adjNode]));
                    }

                    dist[adjNode] = dis + weight;
                    set.add(new Pair(adjNode, dist[adjNode]));
                }
            }

        }
        System.out.println(Arrays.toString(dist));
    }
}
