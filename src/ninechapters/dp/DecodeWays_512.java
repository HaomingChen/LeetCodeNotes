package ninechapters.dp;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public class DecodeWays_512 {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = 0;
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i - 2 >= 0) {
                int res = (s.charAt(i - 1) - '0') + (s.charAt(i - 2) - '0') * 10;
                if (res >= 10 && res <= 26) {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }

}
