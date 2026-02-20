import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class a_01_matrix {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        // {[1,2],[1,3],[3,4],[2,4],[2,5],[4,5]}
        // where n = nodes |||| m = edges 
        // Space Complexity ---> O(N * N); -- expensive
        int n = Integer.parseInt(read.readLine().trim());
        int m = Integer.parseInt(read.readLine().trim());
        int[][] adj_matrix = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] s = read.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            adj_matrix[u][v] = 1;
            adj_matrix[v][u] = 1; // for directed remove this line

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                out.print(adj_matrix[i][j] + " ");
            }
            out.println();
        }
        out.flush();
        read.close();
        out.close();
    }

}
