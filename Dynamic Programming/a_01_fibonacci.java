import java.util.Arrays;

public class a_01_fibonacci {
    public static void main(String[] args) {
        int[] dp;
        int n = 7;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = fibonacci(n,dp);
        int ans2 = fibtabulation(n);
        int ans3 = fibSpaceOpt(n);
        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);
    }
    public static int fibonacci(int n, int[] dp){
        // TC --> O(N) |||| SC --> O(N)(recursion) + O(N)(array)
        if(n <= 1) {
            return n;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fibonacci( n - 1, dp) + fibonacci(n - 2, dp);
    }
    public static int fibtabulation(int n) {
        // TC --> O(N) |||| SC --> O(N)(array)

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i <= n;i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static int fibSpaceOpt(int n) {
        // TC --> O(N) |||| SC --> O(1)
        int prev2 = 0;
        int prev = 1;
        for(int i = 2;i <= n;i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}