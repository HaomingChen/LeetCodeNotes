package crackingleetcode;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * @author 58212
 * @date 2020-01-20 1:31
 */
public class LongestIncreasingSubsequence_300 {

    public int lengthOfLIS(int[] nums) {
        //dp[i] = max(1 + dp[0, i - 1])
        int[] dp = new int[nums.length];
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

}
