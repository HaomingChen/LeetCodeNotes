package crackingleetcode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * @author 58212
 * @date 2020-01-13 2:00
 */
public class MinimumPathSum_64 {

    int boundX;
    int boundY;

    public int minPathSum(int[][] grid) {
        boundX = grid.length;
        boundY = grid[0].length;
        //dp[min] = min(dp[top], dp[left])
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int min = 0;
                //go up
                if (isValid(i - 1, j)) {
                    min = dp[i - 1][j];
                }
                //go left
                if (isValid(i, j - 1)) {
                    min = min == 0 ? dp[i][j - 1] : (dp[i][j - 1] > min ? min : dp[i][j - 1]);
                }
                dp[i][j] = grid[i][j] + min;
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < boundX && y < boundY;
    }

}
