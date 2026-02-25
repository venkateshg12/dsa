import java.util.*;

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class DijkstraWithCycle {
    public static void main(String[] args) {
        int V = 4; // 4 nodes: 0,1,2,3
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected)
        graph.get(0).add(new Edge(1, 1));
        graph.get(1).add(new Edge(0, 1));

        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(1, 2));

        graph.get(0).add(new Edge(2, 4));
        graph.get(2).add(new Edge(0, 4));

        graph.get(2).add(new Edge(3, 3));
        graph.get(3).add(new Edge(2, 3));

        // Run Dijkstra
        int[] dist = dijkstra(graph, 0);

        // Print distances
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from 0 to " + i + " = " + dist[i]);
        }
    }

    private  static int[] dijkstra(List<List<Edge>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0}); // {node, distance}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currDist = current[1];

            if (currDist > dist[node]) continue; // Ignore stale entries

            for (Edge edge : graph.get(node)) {
                int neighbor = edge.to;
                int weight = edge.weight;

                if (dist[node] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[node] + weight;
                    pq.add(new int[]{neighbor, dist[neighbor]});
                }
            }
        }

        return dist;
    }
}