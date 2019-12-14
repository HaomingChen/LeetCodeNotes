package crackingleetcode;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray
 * of which the sum ≥ s. If there isn't one, return 0 instead.
 * @author 58212
 * @date 2019-12-15 2:00
 */
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        //[i,j]
        int i = 0;
        int j = -1;
        int res = nums.length + 1;
        int sum = 0;
        while (i < nums.length) {
            //当前数组元素的和小于s
            if (sum < s) {
                //窗口右侧向右滑窗, 增大数组，增大数组sum
                if (j + 1 < nums.length) {
                    j++;
                    sum = sum + nums[j];
                } else {
                    //无法向右滑窗, 返回
                    break;
                }
            } else {
                //当前数组元素的和大于等于s
                res = j - i + 1 < res ? j - i + 1 : res;
                //窗口左侧向左滑窗,减小数组,减小数组sum
                sum = sum - nums[i];
                i++;
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
