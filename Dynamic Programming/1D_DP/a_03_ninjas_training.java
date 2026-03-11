// Ninja's training
/* 
A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.
Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.

Example 1:
Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]
Output: 210

Explanation:

Day 1: fighting practice = 70
Day 2: stealth training = 50
Day 3: fighting practice = 90
Total = 70 + 50 + 90 = 210
This gives the optimal points.

Example 2:

Input: matrix = [[70, 40, 10], [180, 20, 5], [200, 60, 30]]
Output: 290

Explanation:

Day 1: running = 70
Day 2: stealth training = 20
Day 3: running = 200
Total = 70 + 20 + 200 = 290
This gives the optimal points.

 */

public class a_03_ninjas_training {
    public static void main(String[] args) {
        int[][] matrix = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
        // int[][] matrix = {{70, 40, 10},{180, 20, 5},{200, 60, 30}};
        int n = matrix.length;

        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for (int day = 1; day < n; day++) {

            for (int last = 0; last < 4; last++) {

                int maxi = 0;

                for (int task = 0; task < 3; task++) {

                    if (task != last) {

                        int point = matrix[day][task] + dp[day - 1][task];

                        maxi = Math.max(maxi, point);
                    }
                }

                dp[day][last] = maxi;
            }
        }
        System.out.println(dp[n - 1][3]);
        // int ans = ways(-1, 0, matrix, n);
        // System.out.println(ans);

    }

    public static int ways(int skip, int i, int[][] matrix, int len) {
        if (i >= matrix.length) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < 3; j++) {
            if (j == skip) {
                continue;
            }
            int way = matrix[i][j] + ways(j, i + 1, matrix, len);
            ans = Math.max(ans, way);
        }

        return ans;
    }
}
