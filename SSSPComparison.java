import java.util.*;

public class SSSPComparison {

    static final int INF = 9999;

    // -------------------- Dijkstra (Adjacency Matrix) --------------------
    static int[] dijkstraMatrix(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // -------------------- Dijkstra (Adjacency List) --------------------
    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int[] dijkstraList(Map<Integer, List<Edge>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }

    // -------------------- MAIN --------------------
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0}
        };

        // Adjacency List
        Map<Integer, List<Edge>> list = new HashMap<>();
        for (int i = 0; i < 5; i++) list.put(i, new ArrayList<>());

        list.get(0).add(new Edge(1, 10));
        list.get(0).add(new Edge(3, 30));
        list.get(0).add(new Edge(4, 100));

        list.get(1).add(new Edge(0, 10));
        list.get(1).add(new Edge(2, 50));

        list.get(2).add(new Edge(1, 50));
        list.get(2).add(new Edge(3, 20));
        list.get(2).add(new Edge(4, 10));

        list.get(3).add(new Edge(0, 30));
        list.get(3).add(new Edge(2, 20));
        list.get(3).add(new Edge(4, 60));

        list.get(4).add(new Edge(0, 100));
        list.get(4).add(new Edge(2, 10));
        list.get(4).add(new Edge(3, 60));

        int[] distMatrix = dijkstraMatrix(matrix, 0);
        int[] distList = dijkstraList(list, 0);

        System.out.println("SSSP using Adjacency Matrix: " + Arrays.toString(distMatrix));
        System.out.println("SSSP using Adjacency List:   " + Arrays.toString(distList));
    }
}
