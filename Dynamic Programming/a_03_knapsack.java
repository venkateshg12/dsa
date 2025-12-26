public class a_03_knapsack {
    public static void main(String[] args) {
        int[] value = { 30, 40, 70, 50 };
        int[] weight = { 1, 4, 3, 5 };
        int[][] dp = new int[weight.length][10];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(weight, value, dp, weight.length - 1, 9));
        System.out.println(knapsack_tabulation(weight, value, weight.length , 9));
        System.out.println(knapsack_spaceOptimization(weight, value, weight.length , 9));
        System.out.println(knapsack_spaceOptimization_one(weight, value, weight.length , 9));

    }

    public static int knapsack(int[] weight, int[] value, int[][] dp, int n, int maxWeight) {
        if (dp[n][maxWeight] != -1) {
            return dp[n][maxWeight];
        }
        if (n == 0) {
            if (weight[0] <= maxWeight) {
                return value[0];
            }
            return 0;
        }

        int notTake = 0 + knapsack(weight, value, dp, n - 1, maxWeight);
        int take = Integer.MIN_VALUE;
        if (weight[n] <= maxWeight) {
            take = value[n] + knapsack(weight, value, dp, n - 1, maxWeight - weight[n]);
        }
        return dp[n][maxWeight] = Math.max(take, notTake);
    }

    public static int knapsack_tabulation(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[weight.length][maxWeight + 1];
        for (int i = weight[0]; i <= maxWeight; i++) {
            dp[0][i] = value[0];
        }
        for(int i = 1;i < n;i++) {
            for(int w = 0;w <= maxWeight;w++) {
                int notTake = 0 + dp[i - 1][w];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= w) {
                    take = value[i] + dp[i - 1][w - weight[i]];
                }
                dp[i][w] = Math.max(take , notTake);
            }
        }
        return dp[n - 1][maxWeight];
    }

    public static int knapsack_spaceOptimization(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];
        for(int w = weight[0];w<= maxWeight;w++) {
            prev[w] = value[0];
        }
        for(int i = 1;i < n;i++) {
            int[] cur = new int[maxWeight + 1];
            for(int w = 0;w <= maxWeight;w++) {
                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= w) {
                    take = value[i] + prev[w - weight[i]];
                }
                cur[w] = Math.max(take , notTake);
            }
            prev = cur;
        }
        return prev[maxWeight];
    }
    public static int knapsack_spaceOptimization_one(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];
        for(int w = weight[0];w<= maxWeight;w++) {
            prev[w] = value[0];
        }
        for(int i = 1;i < n;i++) {
            for(int w = maxWeight;w >= 0;w--) {
                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= w) {
                    take = value[i] + prev[w - weight[i]];
                }
                prev[w] = Math.max(take , notTake);
            }
        }
        return prev[maxWeight];
    }
}
