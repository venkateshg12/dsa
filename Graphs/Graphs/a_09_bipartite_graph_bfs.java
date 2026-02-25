import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class a_09_bipartite_graph_bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int n = 8;

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        list.get(1).add(2);
        list.get(2).add(1);

        list.get(2).add(3);
        list.get(3).add(2);

        list.get(3).add(4);
        list.get(4).add(3);

        list.get(4).add(7);
        list.get(7).add(4);

        list.get(7).add(8);
        list.get(8).add(7);

        list.get(4).add(5);
        list.get(5).add(4);

        list.get(5).add(6);
        list.get(6).add(5);

        list.get(6).add(2);
        list.get(2).add(6);

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        boolean flag = true;
        for (int i = 0; i <= n; i++) {
            if (color[i] == -1) {
                if (!check(i, n, list, color)) {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(flag ? "Bipartite Graph" : "Non-Bipartite Graph");
    }

    public static boolean check(int i, int v, ArrayList<ArrayList<Integer>> list, int[] color) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        while (!que.isEmpty()) {
            int node = que.peek();
            que.remove();

            for (int adjElement : list.get(i)) {
                if (color[adjElement] == -1) {
                    color[adjElement] = 1 - color[node];
                    que.add(adjElement);
                } else if (color[adjElement] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}

// TC ---> O(N) + O(V + 2E)