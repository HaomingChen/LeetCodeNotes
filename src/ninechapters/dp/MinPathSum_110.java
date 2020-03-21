package ninechapters.dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 */
public class MinPathSum_110 {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                if (i - 1 >= 0) {
                    if (dp[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                    }
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

}
