import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class a_02_ninja_training {
     public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(read.readLine().trim());
        int arr[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = read.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++)
                dp[i][j] = 0;
        }
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != j) {
                        int point = arr[i][task] + dp[i - 1][task];
                        dp[i][j] = Math.max(dp[i][j], point);
                    }
                }

            }
        }
        System.out.println(dp[n - 1][3]);
        out.close();
        read.close();
        out.flush();
    }
    /*
     * public static int ways(int day, int last, int arr[][], int[][] dp) {
     * if(dp[day][last] != -1) {
     * return dp[day][last];
     * }
     * if(day == 0) {
     * int max = 0;
     * for(int i = 0;i < 3;i++) {
     * if(i != last) {
     * max = Math.max(max, arr[0][i]);
     * }
     * }
     * return max;
     * }
     * int maxi = 0;
     * for(int i = 0;i < 3;i++) {
     * if(i != last) {
     * int point = arr[day][i] + ways(day-1,i,arr,dp);
     * maxi = Math.max(maxi, point);
     * }
     * }
     * return dp[day][last] = maxi;
     * }
     *      */

}
