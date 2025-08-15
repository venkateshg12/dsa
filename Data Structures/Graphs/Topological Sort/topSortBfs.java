import java.util.*;

public class topSortBfs {
    public static void main(String[] args) {
        List<List<Integer>> acyclicGraph = new ArrayList<>();
        acyclicGraph.add(List.of(1,2));
        acyclicGraph.add(List.of(3));
        acyclicGraph.add(List.of(3,4,6));
        acyclicGraph.add(List.of(5));
        acyclicGraph.add(List.of(5));
        acyclicGraph.add(List.of());
        acyclicGraph.add(List.of(4));

        int[] sorted = topologicalSort(7, acyclicGraph);
        System.out.println("Topological Order (Acyclic):");
        for (int node : sorted)
            System.out.print(node + " ");
    }

    public static int[] topologicalSort(int v, List<List<Integer>> graph) {
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : graph.get(i)) {
                indegree[it]++;
            }
        }
 
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] topo = new int[v];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            topo[i++] = node;

            for (int it : graph.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        return topo;
    }
}
