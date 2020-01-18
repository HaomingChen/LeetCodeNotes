package crackingleetcode;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *
 * @author 58212
 * @date 2020-01-18 19:22
 */
public class PartitionEqualSubsetSum_416 {

    public boolean canPartition(int[] nums) {
        //memorize if current number can fill all the slots
        //dp[i] = dp[i - 1][sum] || i + dp[i - 1][sum - i]
        if(nums.length <= 1){
            return false;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        for(int i = 0; i <= sum; i++){
            dp[i] = (nums[0] == i);
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
                //剪枝: 如果获得了得到sum的数据集合, 可以直接返回, 因为剩下的元素相加
                //一定等于sum
                if(j == sum && dp[j]){
                    return true;
                }
            }
        }
        return dp[sum];
    }
}
