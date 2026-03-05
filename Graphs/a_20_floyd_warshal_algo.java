import java.util.Arrays;

public class a_20_floyd_warshal_algo {
    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        /*
         * int[][] graph = {
         * { 0, 2, INF, INF },
         * { 1, 0, 3, INF },
         * { INF, INF, 0, INF },
         * { 3, 5, 4, 0 }
         * };
         */

        int[][] graph = {
                { 0, 1, INF, INF },
                { INF, 0, -1, INF },
                { INF, INF, 0, -1 },
                { INF, -1, INF, 0 }
        };

        int n = graph.length;
        int m = graph[0].length;

        for (int thr = 0; thr < n; thr++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][thr] != INF && graph[thr][j] != INF) {
                        graph[i][j] = Math.min(
                                graph[i][j],
                                graph[i][thr] + graph[thr][j]);
                    }
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == Integer.MAX_VALUE) {
                    graph[i][j] = -1;
                }
                if (i == j) {
                    if (graph[i][j] < 0) {
                        flag = false;
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("Negative cycle detected");
        } else {
            for (int[] row : graph) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}
// TC --> O(N * 3)
/*
 * How to detect a negative cycle ?
 * if cost[i][i] < 0 then it is a negative cycle.
 */