// Frog jump with K distances
/* 
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step, and an integer k.
To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from the ith step to any step in the range [i + 1, i + k], provided it exists.
Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.

Example 1:
Input: heights = [10, 5, 20, 0, 15], k = 2
Output: 15

Explanation:
0th step -> 2nd step, cost = abs(10 - 20) = 10
2nd step -> 4th step, cost = abs(20 - 15) = 5
Total cost = 10 + 5 = 15.

Example 2:
Input: heights = [15, 4, 1, 14, 15], k = 3
Output: 2

Explanation:
0th step -> 3rd step, cost = abs(15 - 14) = 1
3rd step -> 4th step, cost = abs(14 - 15) = 1
Total cost = 1 + 1 = 2.

 */
public class a_02_frog_jump_k_dist {
    public static void main(String[] args) {
        int[] heights = { 10, 5, 20, 0, 15 };
        // int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        int n = heights.length;
        int[] dp = new int[n];
        for(int i = 1;i < n;i++) {
            int ans = Integer.MAX_VALUE;
            for(int j = 1;j <=k;j++) {
                if(i - j >= 0) {
                    int way = Math.abs(heights[i]- heights[i - j]) + dp[i-j];
                    ans = Math.min(ans, way);
                }
            }
            dp[i] = ans;
        }
        System.out.println(dp[n-1]);
        System.out.println(ways(n - 1, heights, k));
        // return ways(n-1,heights,k);
    }
     public static int ways(int n, int[] heights, int k) {
        if(n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++) {
            if(n - i >= 0){
                int way = Math.abs(heights[n] - heights[n-i]) + ways(n-i,heights,k);
                ans = Math.min(ans,way);
            }
        }
        return ans;
    }
}
