import java.util.*;

public class shortPathDAG {
    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }

    public static void main(String[] args) {
        int n = 6;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        graph.get(0).add(new Edge(0, 1, 3));
        graph.get(0).add(new Edge(0, 2, 2));
        graph.get(0).add(new Edge(0, 5, 3));
        graph.get(1).add(new Edge(1, 3, 1));
        graph.get(1).add(new Edge(1, 2, 6));
        graph.get(2).add(new Edge(2, 3, 1));
        graph.get(2).add(new Edge(2, 4, 10));
        graph.get(3).add(new Edge(3, 4, 5));
        graph.get(5).add(new Edge(5, 4, 7));
        int[] order = topSort(graph, n);
        System.out.println("Topological Order: " + Arrays.toString(order));
        
        // Get shortest paths from node 0
        Integer[] distances = dagShortestPath(graph, 0, n);
        System.out.println("Shortest distance to node 4: " + distances[4]);
        System.out.println("Shortest distance to node 6: " + distances[6]);
    }
    private static Integer[] dagShortestPath(Map<Integer, List<Edge>> graph, int s, int n) {

        int[] topOrder = topSort(graph, n);
        Integer[] dist = new Integer[n];
        dist[s] = 0;

        for(int node : topOrder) {
            if(dist[node] != null) {
                List<Edge> edges = graph.get(node);
                if(edges != null) {
                    for(Edge edge : edges) {
                        int newDist = dist[node] + edge.weight;
                        System.out.println(node + " " + edge.to);
                        if(dist[edge.to] == null || newDist < dist[edge.to]) {
                            dist[edge.to] = newDist;
                        } 
                        System.out.println("dist: " + dist[edge.to]);
                    }
                }
            }
        }
        return dist;
    }


    private static int[] topSort(Map<Integer, List<Edge>> graph, int n) {

        int[] ordering = new int[n];
        boolean [] visited = new boolean[n];
        int index = n - 1;

        for(int i = 0;i < n;i++) {
            if(!visited[i]) {
               index =  dfs(i, index, visited, ordering, graph );
            }
        }
        return ordering;
    }
    private static  int dfs(int node, int index, boolean[] visited , int[] ordering, Map<Integer, List<Edge>> graph) {
        visited[node] = true;
        List<Edge> edges = graph.get(node);
        if (edges != null) {
            for(Edge edge : edges) {
                if(!visited[edge.to]) {
                    index = dfs(edge.to, index, visited, ordering, graph);
                }
            }
        }
        ordering[index] = node;
        return index - 1;
    }

}
