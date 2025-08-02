import java.util.*;

public class a {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of(1, 2));
        graph.add(List.of(3));
        graph.add(List.of(3, 4));
        graph.add(List.of(5));
        graph.add(List.of(5));
        graph.add(List.of());
        int[] topsort = topSort(graph);
        if (topsort.length == 0) {
            System.out.println("Cycle detected!");
        } else {
            for (int num : topsort) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static int[] topSort(List<List<Integer>> graph) {
        int numNodes = graph.size();
        boolean[] visited = new boolean[numNodes];
        boolean[] recursionStack = new boolean[numNodes];
        int[] ordering = new int[numNodes];
        int[] index = { numNodes - 1 };
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recursionStack, ordering, index, graph)) {
                    return new int[0];
                }
            } 
        }
        return ordering;
    }

    public static boolean dfs(int node, boolean[] visited, boolean[] recursionStack, int[] ordering, int[] index,List<List<Integer>> graph) {
        visited[node] = true;
        recursionStack[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, recursionStack, ordering, index, graph)) {
                    return true; // Propagate cycle detection
                } else if (recursionStack[neighbour]) {
                    return true; // Cycle detected (back edge)
                }
            }
        }
        recursionStack[node] = false;
        ordering[index[0]--] = node;
        return false;
    }
}
