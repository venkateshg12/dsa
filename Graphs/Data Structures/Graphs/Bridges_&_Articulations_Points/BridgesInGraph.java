    import java.util.*;

    public class BridgesInGraph {
        private int id = 0; // Timer
        private int[] ids, low;
        private boolean[] visited;
        private List<List<Integer>> graph;
        private List<int[]> bridges;

        public  List<int[]> findBridges(int n, List<List<Integer>> graph) {
            this.graph = graph;
            ids = new int[n];
            low = new int[n];
            visited = new boolean[n];
            bridges = new ArrayList<>();

            // Run DFS for each component
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i, -1);
                }
            }
            return bridges;
        }

        private void dfs(int at, int parent) {
            visited[at] = true;
            id++;
            ids[at] = low[at] = id;

            for (int to : graph.get(at)) {
                if (to == parent) continue; // Ignore edge to parent

                if (!visited[to]) {
                    dfs(to, at);
                    low[at] = Math.min(low[at], low[to]);

                    // Check for bridge
                    if (ids[at] < low[to]) {
                        bridges.add(new int[]{at, to});
                    }
                } else {
                    // Back edge
                    low[at] = Math.min(low[at], ids[to]);
                }
            }
        }

        // Example usage
        public static void main(String[] args) {
            int n = 9; // Number of nodes
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

            // Add edges (undirected)
            graph.get(0).add(1);
            graph.get(1).add(2);
            graph.get(2).add(0);
            graph.get(2).add(3);
            graph.get(2).add(5);
            graph.get(3).add(4);
            graph.get(5).add(6);
            graph.get(6).add(7);
            graph.get(7).add(8);
            graph.get(8).add(5);

            BridgesInGraph solver = new BridgesInGraph();
            List<int[]> bridges = solver.findBridges(n, graph);

            
            System.out.println("Bridges found:");
            for (int[] edge : bridges) {
                System.out.println(edge[0] + " - " + edge[1]);
            }
        }
    }
