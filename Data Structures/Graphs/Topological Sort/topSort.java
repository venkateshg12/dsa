import java.util.ArrayList;
import java.util.List;

public class topSort {

    public static int[] topologicalSort(List<List<Integer>> graph) {
        int numNodes = graph.size();
        boolean[] visited = new boolean[numNodes];
        boolean[] recursionStack = new boolean[numNodes];
        int[] ordering = new int[numNodes];
        int[] index = {numNodes - 1}; // Using array to pass by reference

        for (int node = 0; node < numNodes; node++) {
            if (!visited[node]) {
                if (dfs(node, visited, recursionStack, ordering, index, graph)) {
                    return new int[0]; // Cycle detected
                }
            }
        }
        return ordering;
    }

    private static boolean dfs(int node, boolean[] visited, boolean[] recursionStack, int[] ordering, int[] index, List<List<Integer>> graph) {
        visited[node] = true;
        recursionStack[node] = true; // Mark as in current DFS path

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, recursionStack, ordering, index, graph)) {
                    return true; // Propagate cycle detection
                }
            } else if (recursionStack[neighbor]) {
                return true; // Cycle detected (back edge)
            }
        }

        recursionStack[node] = false; // Backtrack
        ordering[index[0]--] = node; // Store in reverse post-order
        return false;
    }

    public static void main(String[] args) {
        // Example 1: Acyclic Graph
        List<List<Integer>> acyclicGraph = new ArrayList<>();
        acyclicGraph.add(List.of(1,2));
        acyclicGraph.add(List.of(3));
        acyclicGraph.add(List.of(3, 4));
        acyclicGraph.add(List.of(5));
        acyclicGraph.add(List.of(5));
        acyclicGraph.add(List.of());

        int[] sorted = topologicalSort(acyclicGraph);
        System.out.println("Topological Order (Acyclic):");
        for (int node : sorted) System.out.print(node + " ");

        // Example 2: Cyclic Graph
        List<List<Integer>> cyclicGraph = new ArrayList<>();
        cyclicGraph.add(List.of(1));
        cyclicGraph.add(List.of(2));
        cyclicGraph.add(List.of(0)); // Creates cycle 0 → 1 → 2 → 0

        int[] result = topologicalSort(cyclicGraph);
        System.out.println("\nTopological Order (Cyclic):");
        if (result.length == 0) {
            System.out.println("Cycle detected!");
        }
    }
}
