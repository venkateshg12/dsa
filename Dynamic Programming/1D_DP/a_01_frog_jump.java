// Frog Jump

/* 
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.
To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, provided it exists.
Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.

Example 1:

Input: heights = [2, 1, 3, 5, 4]
Output: 2

Explanation:
One possible route can be,
0th step -> 2nd Step = abs(2 - 3) = 1
2nd step -> 4th step = abs(3 - 4) = 1
Total = 1 + 1 = 2.

Example 2:
Input: heights = [7, 5, 1, 2, 6]
Output: 9

Explanation:
One possible route can be,
0th step -> 1st Step = abs(7 - 5) = 2
1st step -> 3rd step = abs(5 - 2) = 3
3rd step -> 4th step = abs(2 - 6) = 4
Total = 2 + 3 + 4 = 9.
 */

public class a_01_frog_jump {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 3, 5, 4 };
        int n = heights.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int left = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
            }
            dp[i] = Math.min(left, right);
        }
        System.out.println(dp[n - 1]);
        // System.out.println(ways(n-1, heights));
        // return dp[n-1];
        // return ways(heights.length - 1, heights);
    }

    public static int ways(int n, int[] h) {
        if (n <= 0) {
            return 0;
        }
        int left = Math.abs(h[n] - h[n - 1]) + ways(n - 1, h);
        int right = Integer.MAX_VALUE;
        if (n >= 2) {
            right = Math.abs(h[n] - h[n - 2]) + ways(n - 2, h);
        }
        return Math.min(left, right);
    }
}
