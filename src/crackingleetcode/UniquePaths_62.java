package crackingleetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below). How many possible unique paths are there?
 *
 * @author 58212
 * @date 2020-01-14 3:58
 */
public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

//    int boundX;
//    int boundY;
//
//    public int uniquePaths(int m, int n) {
//        boundX = n;
//        boundY = m;
//        //dp[robot]  = dp[rightPath] + dp[downPath]
//        //stores the paths to go to that point
//        int[][] dp = new int[n][m];
//        //origin
//        dp[n - 1][m - 1] = 1;
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = m - 1; j >= 0; j--) {
//                //from bot from right
//                int bot = 0;
//                int right = 0;
//                if (isValid(i + 1, j)) {
//                    bot = dp[i + 1][j];
//                }
//                if (isValid(i, j + 1)) {
//                    right = dp[i][j + 1];
//                }
//                dp[i][j] = bot + right + dp[i][j];
//            }
//        }
//        return dp[0][0];
//    }
//
//    private boolean isValid(int x, int y) {
//        return x >= 0 && y >= 0 && x < boundX && y < boundY;
//    }

}
