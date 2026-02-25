public class TravellingSalesman {
    static int n; // number of cities
    static int[][] dist; // distance matrix
    static int VISITED_ALL;
    static int[][] dp; // DP memo table

    // Function to solve TSP using DP + Bitmasking
    static int tsp(int mask, int pos) {
        // If all cities are visited, return distance back to starting city (0)
        if (mask == VISITED_ALL) {
            return dist[pos][0];
        }

        // If already computed, return from dp
        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int ans = Integer.MAX_VALUE;

        // Try to go to every other city
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) { // if city is not visited
                int newAns = dist[pos][city] + tsp(mask | (1 << city), city);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        // Hardcoded distance matrix
        dist = new int[][] {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        n = dist.length;
        VISITED_ALL = (1 << n) - 1; // all cities visited mask
        dp = new int[1 << n][n];

        // initialize dp with -1
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int shortestPath = tsp(1, 0); // start with only city 0 visited
        System.out.println("The shortest path cost is: " + shortestPath);
    }
}
