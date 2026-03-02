import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int dist;
    int node;

    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

public class a_16_dijkstras_algo {
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

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> {
            if (a.dist == b.dist) {
                return a.dist - b.dist;
            }
            return a.node - b.node;
        });
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        pq.add(new Pair(0, 0));
        while (pq.size() != 0) {
            int dist = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);
                if (dist + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = edgeWeight + dist;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
}
// TC --> E log(V)
// E --> Total no of edges
// V --> Total no of nodes 
/* 
    Time Complexity:
    O(V x (pop vertex from min heap + no of edges on each vertex  x  push it into PQ))
    O(V x (log(heap size ) + no of edges x log(heap size))
    O(V x (log(heap size)(no of edges + 1))) no of edges = V - 1
    O(V x (log(heap size)(V - 1 + 1)))
    O(V x (log(heap size) x V))
    O(V ^ 2 x log(heap size))
    O(V ^ 2 x log(V ^ 2))
    O(V ^ 2 x 2 x log(V)) where V^2 is [for every V vertices it connects (V - 1) vertices].
    O(E log (V))
 */