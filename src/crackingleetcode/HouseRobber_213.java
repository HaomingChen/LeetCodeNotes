package crackingleetcode;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two
 * adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 * @author 58212
 * @date 2020-01-26 17:35
 */
public class HouseRobber_213 {

    public int rob(int[] nums) {
        if (nums.length <= 2) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            } else {
                return Math.max(nums[0], nums[1]);
            }
        }
        //dp[i] = Math.max(dp[i - 1], dp[i - 2] + i)
        return Math.max(robber(nums, true), robber(nums, false));
    }

    //signal = true -> robber the first house
    //signal = false -> dont robber the first house
    private int robber(int[] nums, boolean signal) {
        int[] dp = new int[nums.length];
        if (signal) {
            dp[0] = nums[0];
            dp[1] = nums[0];
        } else {
            dp[0] = 0;
            dp[1] = nums[1];
        }
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        if (signal) {
            return dp[dp.length - 2];
        } else {
            return Math.max(dp[dp.length - 2],
                    dp[dp.length - 3] + nums[nums.length - 1]);
        }
    }

}
