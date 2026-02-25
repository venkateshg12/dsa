import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class a_03_connected {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 10, m = 8;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // for (int i = 0; i < m; i++) {
        //     String[] s = read.readLine().split(" ");
        //     int u = Integer.parseInt(s[0]);
        //     int v = Integer.parseInt(s[1]);
        //     list.get(u).add(v);
        //     list.get(v).add(u);
        // }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(6).add(7);
        adj.get(7).add(6);

        adj.get(5).add(7);
        adj.get(7).add(5);

        adj.get(8).add(9);
        adj.get(9).add(8);

        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }
        
        out.println("Connected Components: " + count);
        out.flush();
        out.close();
        read.close();
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        visited[node] = true;
        for (int neighbour : list.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, list, visited);
            }
        }
    }
}
