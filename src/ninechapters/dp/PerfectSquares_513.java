package ninechapters.dp;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 *
 * @author Haoming Chen
 * Created on 2020/3/26
 */
public class PerfectSquares_513 {

    public int numSquares(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[dp.length - 1];
    }

}
