 boolean[][] dp = new boolean[n][t + 1];
        for(int i = 0;i < n;i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for(int i = 1;i< n;i++) {
            for(int k = 1;k<=t;k++) {
                boolean notTake = dp[i - 1][k];
                boolean take = false;
                if(arr[i] <= k) {
                    take = dp[i - 1][k- arr[i]];
                }
                dp[i][k] = take || notTake;
            }
        }
        out.println(dp[n-1][t] ? "Yes" : "No");