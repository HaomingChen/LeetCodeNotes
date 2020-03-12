package crackingleetcode;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining
 * characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence
 * of two strings is a subsequence that is common to both strings.
 * <p>
 * If there is no common subsequence, return 0.
 *
 * @author Haoming Chen
 * Created on 2020/1/21
 */
public class LongestCommonSubsequence_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
