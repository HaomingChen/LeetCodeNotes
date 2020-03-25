package ninechapters.dp;

import java.util.Arrays;

/**
 * Give a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into \
 * another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * Find the maximum number of nested layers of envelopes.
 *
 * @author Haoming Chen
 * Created on 2020/3/25
 */
public class RussianDollEnvelopes_602 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        int[] dp = new int[envelopes.length + 1];
        sort(envelopes);
        dp[0] = 0;
        for (int i = 1; i <= envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (envelopes[i - 1][1] > envelopes[j - 1][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private void sort(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[1] > o2[1]) {
                return -1;
            } else {
                return 1;
            }
        });
    }
}
