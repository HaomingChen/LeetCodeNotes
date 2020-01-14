package crackingleetcode;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of
 * those integers. Return the maximum product you can get.
 *
 * @author 58212
 * @date 2020-01-14 2:35
 */
public class IntegerBreak_343 {

    public int integerBreak(int n) {
        //dp condition dp[n] = Math.max(k * (n - k), k * dp[k])
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, (i - j) * dp[j]));
            }
        }
        return dp[n];
    }

}
