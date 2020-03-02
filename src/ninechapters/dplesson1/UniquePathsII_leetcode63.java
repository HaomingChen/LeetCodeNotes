package ninechapters.dplesson1;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * @author Haoming Chen
 * Created on 2020/3/2
 */
public class UniquePathsII_leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[dp.length - 1][dp[0].length - 1] = obstacleGrid[dp.length - 1][dp[0].length - 1] == 1 ? 0 : 1;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                int paths = dp[i][j];
                if (i + 1 < dp.length && obstacleGrid[i + 1][j] != 1) {
                    paths += dp[i + 1][j];
                }
                if (j + 1 < dp[0].length && obstacleGrid[i][j + 1] != 1) {
                    paths += dp[i][j + 1];
                }
                dp[i][j] = paths;
            }
        }
        return dp[0][0];
    }

}
