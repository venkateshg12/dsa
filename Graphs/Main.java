import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] s = read.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int t = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        String[] arrs = read.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrs[i]);
        }
        /*
         * Boolean[][] dp = new Boolean[n][t + 1];
         * if (subseq(dp, arr, n - 1, t)) {
         * out.println("Yes");
         * } else {
         * out.println("No");
         * }
         */
        // Tabulation
        /*
         * boolean[][] dp = new boolean[n][t + 1];
         * for (int i = 0; i < n; i++) {
         * dp[i][0] = true;
         * }
         * if (arr[0] <= t) {
         * dp[0][arr[0]] = true;
         * }
         * 
         * for (int i = 1; i < n; i++) {
         * for (int k = 1; k <= t; k++) {
         * boolean notTake = dp[i - 1][k];
         * boolean take = false;
         * if (arr[i] <= k) {
         * take = dp[i - 1][k - arr[i]];
         * }
         * dp[i][k] = take || notTake;
         * }
         * }
         * out.println(dp[n - 1][t] ? "Yes" : "No");
         */

        // space Optimization
        boolean[] prev = new boolean[t + 1];
        boolean[] cur = new boolean[t + 1];
        prev[0] = cur[0] = true;
        prev[arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= t; k++) {
                boolean notTake = prev[k];
                boolean take = false;
                if (arr[i] <= k) {
                    take = prev[k - arr[i]];
                }
                cur[k] = take || notTake;
            }
            prev = cur;
        }
        out.println(prev[t] ? "Yes" : "No");

        out.close();
        read.close();
        out.flush();
    }

    public static boolean subseq(Boolean[][] dp, int[] arr, int i, int t) {
        if (t == 0) {
            return true;
        }
        if (i < 0)
            return false;
        if (dp[i][t] != null) {
            return dp[i][t];
        }
        boolean notTake = subseq(dp, arr, i - 1, t);
        boolean take = false;
        if (arr[i] <= t) {
            take = subseq(dp, arr, i - 1, t - arr[i]);
        }
        return dp[i][t] = take || notTake;
    }
}