import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class a_18_print_dijsktra_algo {
    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

       
        // 1 — 2 (2)
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 2)));

        // 2 — 5 (5)
        adj.get(2).add(new ArrayList<>(Arrays.asList(5, 5)));
        adj.get(5).add(new ArrayList<>(Arrays.asList(2, 5)));

        // 2 — 3 (4)
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 4)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 4)));

        // 5 — 3 (1)
        adj.get(5).add(new ArrayList<>(Arrays.asList(3, 1)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(5, 1)));

        // 1 — 4 (1)
        adj.get(1).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(1, 1)));

        // 4 — 3 (3)
        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 3)));
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist == b.dist) {
                return a.node - b.node;
            }
            return a.dist - b.dist;
        });

        int[] arrival = new int[V + 1];
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        arrival[1] = 1;
        pq.add(new Pair(1, 0));
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);
                if (dist + edgeWeight < distance[adjNode]) {
                    arrival[adjNode] = node;
                    distance[adjNode] = dist + edgeWeight;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int node = 5;
        while (arrival[node] != node) {
            ans.add(node);
            node = arrival[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        System.out.println(ans.toString());
    } 
}
