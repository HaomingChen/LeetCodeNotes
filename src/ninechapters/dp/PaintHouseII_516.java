package ninechapters.dp;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house
 * with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0]
 * is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 */
public class PaintHouseII_516 {

    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        // write your code here
        int[][] dp = new int[costs.length + 1][costs[0].length];
        int[][] color = new int[costs.length + 1][2];
        //initialize
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        //          color
        color[0][0] = 0;
        //   pos
        color[0][1] = 0;
        for (int i = 1; i <= costs.length; i++) {

            color[i][0] = -1;
            color[i][1] = -1;
            for (int j = 0; j < costs[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int colorPos;
                if (j != color[i - 1][0]) {
                    colorPos = color[i - 1][0];
                } else {
                    colorPos = color[i - 1][1];
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][colorPos] + costs[i - 1][j]);
                if (color[i][0] == -1 || dp[i][j] <= dp[i][color[i][0]]) {
                    color[i][1] = color[i][0];
                    color[i][0] = j;
                } else if (color[i][1] == -1 || dp[i][j] <= dp[i][color[i][1]]) {
                    color[i][1] = j;
                }
            }
        }
        return dp[costs.length][color[costs.length][0]];
    }

}
