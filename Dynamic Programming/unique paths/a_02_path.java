// TABULATION
// TC ---> O(M * N) |||| SC ---> O(M * N)
/*
Tabulation and memoization are algorithmically equivalent, but computer execution is not equivalent.

when It comes to recursion + memoization
-- Function calls are expensive
-- creates a stack frame, passes parameter, save return address, jump back after return 

when It comes to tabulation
-- no stack, no jump, just arithmetic + array access

***Cache is a small, high-speed memory that stores frequently accessed data to reduce CPU access time to main memory.***

Tabulation:
--- Access pattern is sequential:
--- CPU cache loves sequential access
--- Fewer cache misses
Recursion:
--- Jumps between stack frames
--- Memory access is scattered
--- More cache misses

 */
public class a_02_path {
    public static void main(String[] args) {
        int ans = uniquePaths(3, 3);
        System.out.println(ans);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
         for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                }else {
                    int down = 0;
                    int right = 0;
                    if(i > 0) {
                        down = dp[i - 1][j];
                    }
                    if(j > 0) {
                        right = dp[i][j - 1];
                    }
                    dp[i][j] = down + right;
                }
            }
        }
        return dp[m - 1][n-1];
    }

}
