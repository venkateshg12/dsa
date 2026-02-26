import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class a_15_short_path_undirected {
    public static void main(String[] args) {
        int N = 8;
        int M = 10;
        // int[][] edges = { { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 },{ 6, 8 } };
        int[][] edges = {{1,0},{2,1},{0,3},{3,7},{3,4},{7,4},{7,6},{4,5},{4,6},{6,5}};
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!que.isEmpty()) {
            int u = que.remove();
            for (int v : adj.get(u)) {
                if (dist[v] > dist[u] + 1) {
                    dist[v] = dist[u] +  1;
                    que.add(v); 
                }
                
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
