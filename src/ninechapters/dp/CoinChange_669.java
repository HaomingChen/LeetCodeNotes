package ninechapters.dp;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * @author Haoming Chen
 * Created on 2020/3/19
 */
public class CoinChange_669 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            dp[i] = -1;
        }
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            if(min == Integer.MAX_VALUE){
                dp[i] = -1;
            }else{
                dp[i] = min;
            }
        }
        return dp[dp.length - 1];
    }

}
