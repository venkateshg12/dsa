import java.util.ArrayList;
import java.util.List;

public class topSortDfs {

    public static int[] topologicalSort(List<List<Integer>> graph) {
        int numNodes = graph.size();
        boolean[] visited = new boolean[numNodes];
        boolean[] recursionStack = new boolean[numNodes];
        int[] ordering = new int[numNodes];
        int[] index = {numNodes - 1}; 

        for (int node = 0; node < numNodes; node++) {
            if (!visited[node]) {
                if (dfs(node, visited, recursionStack, ordering, index, graph)) {
                    return new int[0]; 
                }
            }
        }
        return ordering;
    }

    private static boolean dfs(int node, boolean[] visited, boolean[] recursionStack, int[] ordering, int[] index, List<List<Integer>> graph) {
        visited[node] = true;
        recursionStack[node] = true; 
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, recursionStack, ordering, index, graph)) {
                    return true; // Propagate cycle detection;
                }
            } else if (recursionStack[neighbor]) {
                return true; // Cycle detected (back edge);
            }
        }

        recursionStack[node] = false; 
        ordering[index[0]--] = node; 
        return false;
    }

    public static void main(String[] args) {
        // Example 1: Acyclic Graph
        List<List<Integer>> acyclicGraph = new ArrayList<>();
        acyclicGraph.add(List.of(1,2));
        acyclicGraph.add(List.of(3));
        acyclicGraph.add(List.of(3,4,6));
        acyclicGraph.add(List.of(5));
        acyclicGraph.add(List.of(5));
        acyclicGraph.add(List.of());
        acyclicGraph.add(List.of(4));

        int[] sorted = topologicalSort(acyclicGraph);
        // System.out.println("Topological Order (Acyclic):");
        if(sorted.length == 0) {
            System.out.println("cycle was detected");
        }else {
            for (int node : sorted) System.out.print(node + " ");
            System.out.println();
        }

        // Example 2: Cyclic Graph
        List<List<Integer>> cyclicGraph = new ArrayList<>();
        cyclicGraph.add(List.of(1));
        cyclicGraph.add(List.of(2));
        cyclicGraph.add(List.of(0)); 
        int[] result = topologicalSort(cyclicGraph);
         if(result.length == 0) {
            System.out.println("cycle was detected");
        }else {
            for (int node : sorted) System.out.print(node + " ");
            System.out.println();
        }
    }
}
