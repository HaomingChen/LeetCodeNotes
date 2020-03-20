package ninechapters.dp;

public class MaximumProductSubarray_152 {

    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max[0] = nums[0];
                min[0] = nums[0];
                continue;
            }
            if (nums[i] < 0) {
                max[i] = Math.max(nums[i], nums[i] * min[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
            } else {
                max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < max.length; i++) {
            maxVal = Math.max(maxVal, max[i]);
        }
        return maxVal;
    }

}
