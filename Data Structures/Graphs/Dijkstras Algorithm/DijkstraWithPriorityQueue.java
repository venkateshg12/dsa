import java.util.*;

public class DijkstraWithPriorityQueue {
    
    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static int[] dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // Priority queue: (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[1];
            int currentDist = current[0];

            // Skip if we already found a better path
            if (currentDist > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int newDist = dist[u] + edge.weight;

                // Relaxation step
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{newDist, v});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        // Example graph (adjacency list)
        int n = 5; // Number of nodes
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (directed graph)
        graph.get(0).add(new Edge(1, 4)); 
        graph.get(0).add(new Edge(2, 1)); 
        graph.get(1).add(new Edge(3, 1)); 
        graph.get(2).add(new Edge(1, 2)); 
        graph.get(2).add(new Edge(3, 5)); 
        graph.get(3).add(new Edge(4, 3)); 

        int start = 0;
        int[] shortestDistances = dijkstra(graph, start);

        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + shortestDistances[i]);
        }
    }
}