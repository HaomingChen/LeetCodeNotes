package crackingleetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit. Note that you cannot sell a stock before you buy one.
 *
 * @author 58212
 * @date 2020-01-30 0:04
 */
public class BestTimetoBuyAndSellStock_121 {

    /**
     * finite state machine approach
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            //1. 上一天不持有股票
            //2. 上一天持有股票, 该天卖出
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            //1. 上一天持有股票, 该天不作动作
            //2. 上一天不持有股票, 该天买入股票
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        int[][] dp = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            if (i - 1 == -1) {
//                dp[i][0] = 0;
//                dp[i][1] = -prices[i];
//                continue;
//            }
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//        }
//        return dp[n - 1][0];
//    }

}
