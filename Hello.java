public class Hello {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3 };
        int diff = 1;
        int n = arr.length;
        int tot = 0;
        for (int i : arr) {
            tot += i;
        }
        if (tot - diff < 0 || (tot - diff) % 2 != 0) System.out.println(0);
        int[][] dp = new int[n][(tot - diff) / 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= (tot - diff) / 2; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println( ways(n - 1, arr, dp, (tot - diff) / 2));
    }

    public static int ways(int i, int[] arr, int[][] dp, int k) {
        if (k == 0) {
            return 1;
        }
        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        if (i == 0) {
            if (arr[0] == k) {
                return 1;
            }
            return 0;
        }
        int notTake = ways(i - 1, arr, dp, k);
        int take = 0;
        if (arr[i] <= k) {
            take = ways(i - 1, arr, dp, k - arr[i]);
        }
        dp[i][k] = notTake + take;
        return dp[i][k];
    }
}