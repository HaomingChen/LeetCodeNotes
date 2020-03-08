package crackingleetcode;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * @author 58212
 * @date 2020-01-20 1:31
 */
public class LongestIncreasingSubsequence_300 {

    //bst + dp -> nlogn
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int size = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[size - 1]) {
                dp[size] = nums[i];
                size++;
                continue;
            }
            int l = 0;
            int r = size - 1;
            while (l < r - 1) {
                int mid = (l + r) / 2;
                if (nums[i] < dp[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            if (dp[l] < nums[i] && dp[l + 1] > nums[i]) {
                dp[l + 1] = nums[i];
            } else if (dp[l] >= nums[i]) {
                dp[l] = nums[i];
            } else {
                dp[r] = nums[i];
            }
        }
        return size;

    }

//    public int lengthOfLIS(int[] nums) {
//        if(nums.length == 0){
//            return 0;
//        }
//        int max = 1;
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        for(int i = 1; i < nums.length; i++){
//            int res = 1;
//            for(int j = 0; j < i; j++){
//                if(nums[j] < nums[i]){
//                    res = Math.max(res, dp[j] + 1);
//                    max = Math.max(res, max);
//                }
//            }
//            dp[i] = res;
//        }
//        return max;
//    }

}
