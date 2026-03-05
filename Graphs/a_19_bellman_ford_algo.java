import java.util.ArrayList;
import java.util.Arrays;

public class a_19_bellman_ford_algo {
    public static void main(String[] args) {
        // int V = 6;
        int V = 4;
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int S = 0;
        distance[S] = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        /*
         * edges.add(new ArrayList<>(Arrays.asList(3, 2, 6)));
         * edges.add(new ArrayList<>(Arrays.asList(5, 3, 1)));
         * edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
         * edges.add(new ArrayList<>(Arrays.asList(1, 5, -3)));
         * edges.add(new ArrayList<>(Arrays.asList(1, 2, -2)));
         * edges.add(new ArrayList<>(Arrays.asList(3, 4, -2)));
         * edges.add(new ArrayList<>(Arrays.asList(2, 4, 3)));
         */

        edges.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, -1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 3, -1)));
        edges.add(new ArrayList<>(Arrays.asList(3, 1, -1)));

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }
        boolean flag = true;
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? Arrays.toString(distance) : "Negative cycle detected");
    }
}

// TC --> O(V x E)

// why n - 1 iterations ?
/*
 * In the worst case, you will take N-1 edges to reach from the first to the
 * last, thereby we iterate for N-1 iterations
 */
// how to detect negative cycles ?
/*
 * on Nth iteration, the relaxation will be done , and and if distance[] still
 * get reduces it means it has negative cycles.
 */