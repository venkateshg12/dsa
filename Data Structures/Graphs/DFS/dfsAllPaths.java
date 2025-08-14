import java.util.*;

public class dfsAllPaths {
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) {
        n = 5;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).addAll(Arrays.asList(1, 2, 3, 4));
        graph.get(1).addAll(Arrays.asList(0, 2, 4));
        graph.get(2).addAll(Arrays.asList(0, 1, 3));
        graph.get(3).addAll(Arrays.asList(0, 2, 4));
        graph.get(4).addAll(Arrays.asList(0, 1, 3));

        int root = 0;
        int endRoot = 4;

        boolean[] visited = new boolean[n];
        List<Integer> path = new ArrayList<>();
        dfsAllPath(root, endRoot, visited, path);
    }

    public static void dfsAllPath(int current, int endRoot, boolean[] visited, List<Integer> path) {
        if (visited[current]) {
            return;
        }
        visited[current] = true;
        path.add(current);

        if (current == endRoot) {
            System.out.println(new ArrayList<>(path));
        } else {
            for (int neigh : graph.get(current)) {
                dfsAllPath(neigh, endRoot, visited, path);
            }
        }

        visited[current] = false;
        path.remove(path.size() - 1);
    }
}