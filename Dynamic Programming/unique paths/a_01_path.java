// RECURSION + MEMOIZATION
// TC ---> O(M * N) |||| SC ----> O(M * N)
public class a_01_path {
    public static void main(String[] args) {
        int ans = uniquePaths(3,3);
        System.out.println(ans);
        
    }
     public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
       for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return path(m - 1, n-1, dp);
    }

    public static int path(int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (m == 0 && n == 0) {
            return 1;
        }
        int down = path(m - 1, n, dp);
        int right = path(m, n - 1, dp);
        return dp[m][n] = down + right;
    }
}
