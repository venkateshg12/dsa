/* 
1 1 0 1 1
1 0 0 0 0  total of 4 combined ones are there
0 0 0 1 1
1 1 0 1 0
 */

import java.util.ArrayList;
import java.util.HashSet;

public class a_08_distinct_islands {
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 1, 1, 0, 1, 0 } };
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        HashSet<ArrayList<String>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, visited, grid, list, i, j);
                    st.add(list);
                    count++;
                }
            }
        }
        for (ArrayList<String> island : st) {
            System.out.println(island);
        }
        System.out.println("The number of  Islands: " + count);
        System.out.println("The number of distinct Islands: " + st.size());
    }

    public static void dfs(int i, int j, boolean[][] visited, int[][] grid, ArrayList<String> list, int row0,
            int col0) {
        visited[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        list.add((i - row0) + "," + (j - col0));
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (Math.abs(dc) + Math.abs(dr) != 1) {
                    continue;
                }
                int nrow = i + dr;
                int ncol = j + dc;
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    if (!visited[nrow][ncol] && grid[nrow][ncol] == 1) {
                        dfs(nrow, ncol, visited, grid, list, row0, col0);
                    }
                }
            }
        }
    }
}

// TC ---> O(n × m) + O(log(n × m)) + O(4 × n × m)