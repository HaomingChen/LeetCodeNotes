package ninechapters.dplession2;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence
 * of "ABCDE" while "AEC" is not).
 *
 * @author Haoming Chen
 * Created on 2020/3/16
 */
public class DistinctSubsequences_115 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int j = 0; j < dp.length; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // aaaccb aab -> 前面更短的字符串匹配上的情况 [i - 1][j - 1] * 1
                    // 匹不上 dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

}
