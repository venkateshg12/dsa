package Graphs.Representation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}


public class a_02_list {
    public static void main(String[] args) throws IOException {
        // {[1,2],[1,3],[3,4],[2,4],[2,5],[4,5]}
        // where n = nodes |||| m = edges
        // Space Complexity ---> O(2 * E); for undirected
        // Space Complexity ---> O(E); for directed

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(read.readLine().trim());
        int m = Integer.parseInt(read.readLine().trim());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        // ArrayList<ArrayList<Pair>> adj = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            String[] s = read.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            list.get(u).add(v);
            list.get(v).add(u); // for directed remove this line
            // adj.get(u).add(new Pair(v, w));
            // adj.get(v).add(new Pair(u, w));
         }

        for (int i = 1; i <= n; i++) {
            out.print(i + " -> ");
            for (int neighbour : list.get(i)) {
                out.print(neighbour + " ");
            }
            out.println();
        }

        out.flush();
        out.close();
        read.close();
    }
}
