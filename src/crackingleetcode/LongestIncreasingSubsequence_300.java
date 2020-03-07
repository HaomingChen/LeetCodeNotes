package crackingleetcode;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * @author 58212
 * @date 2020-01-20 1:31
 */
public class LongestIncreasingSubsequence_300 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int res = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    res = Math.max(res, dp[j] + 1);
                    max = Math.max(res, max);
                }
            }
            dp[i] = res;
        }
        return max;
    }

}
