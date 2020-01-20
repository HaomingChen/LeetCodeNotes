package crackingleetcode;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of
 * s is 1000.
 *
 * @author Haoming Chen
 * Created on 2020/1/20
 */
public class LongestPalindromicSubsequence_516 {

    public static void main(String[] args) {
        LongestPalindromicSubsequence_516.longestPalindromeSubseq("axbdba");
    }

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("res: " + dp[0][s.length() - 1]);
        return dp[0][s.length()-1];
    }
}
