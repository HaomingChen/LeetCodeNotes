package ninechapters.dp;

/**
 * Given an array prices, which represents the price of a stock in each day.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, if you already have the stock, you must
 * sell it before you buy again). Design an algorithm to find the maximum profit.
 */
public class BestTimetoBuyandSellStockII_150 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int res = 0;
        int price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res = res + prices[i] - prices[i - 1];
            }
            price = prices[i];
        }
        return res;
    }

}
