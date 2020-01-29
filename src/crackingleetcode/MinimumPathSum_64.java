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
        int[][] offset = {{0, 1}, {1, 0}};
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                int min = -1;
                for (int m = 0; m < offset.length; m++) {
                    int newX = i + offset[m][0];
                    int newY = j + offset[m][1];
                    if (isValid(newX, newY, dp)) {
                        if (min == -1) {
                            min = dp[newX][newY] + grid[i][j];
                        } else {
                            min = Math.min(dp[newX][newY] + grid[i][j], min);
                        }
                    }
                }
                dp[i][j] = min == -1 ? grid[i][j] : min;
            }
        }
        return dp[0][0];
    }

    private boolean isValid(int newX, int newY, int[][] dp) {
        return newX >= 0 && newY >= 0 && newX < dp.length && newY < dp[0].length;
    }

//    public int minPathSum(int[][] grid) {
//        boundX = grid.length;
//        boundY = grid[0].length;
//        //dp[min] = min(dp[top], dp[left])
//        int[][] dp = new int[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                int min = 0;
//                //go up
//                if (isValid(i - 1, j)) {
//                    min = dp[i - 1][j];
//                }
//                //go left
//                if (isValid(i, j - 1)) {
//                    min = min == 0 ? dp[i][j - 1] : (dp[i][j - 1] > min ? min : dp[i][j - 1]);
//                }
//                dp[i][j] = grid[i][j] + min;
//            }
//        }
//        return dp[grid.length - 1][grid[0].length - 1];
//    }
//
//    private boolean isValid(int x, int y) {
//        return x >= 0 && y >= 0 && x < boundX && y < boundY;
//    }

}
