import java.util.*;
class Edge {
    int from, to, weight;
    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class bellmanFordAlgo {
     private static void bellmanFord(List<Edge> edges, int V, int source) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge e : edges) {
                if (distance[e.from] != Integer.MAX_VALUE && distance[e.to] > distance[e.from] + e.weight) {
                    distance[e.to] = distance[e.from] + e.weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge e : edges) {
            if (distance[e.from] != Integer.MAX_VALUE && 
                distance[e.to] > distance[e.from] + e.weight) {
                System.out.println("Negative cycle detected!");
                return;
            }
        }

        System.out.println("Shortest distances: " + Arrays.toString(distance));
    }

    public static void main(String[] args) {
        int V = 6;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 5, 3));
        edges.add(new Edge(2, 3, -5));
        edges.add(new Edge(3, 4, 2));
        edges.add(new Edge(4, 2, 1)); // Negative cycle: 2 → 3 → 4 → 2 (total weight = -2)

        bellmanFord(edges, V, 0);
    }
}