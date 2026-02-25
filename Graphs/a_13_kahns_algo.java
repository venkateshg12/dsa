import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class a_13_kahns_algo {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = 5;
        int[] indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(5).add(2);

        adj.get(2).add(3);

        adj.get(3).add(1);

        for (int i = 0; i <= n; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }
        int[] order = new int[n + 1];
        int ind = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            order[ind++] = cur;
            for (int nei : adj.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    que.offer(nei);
                }
            }
        }
        System.out.println(Arrays.toString(order));
    }
}
