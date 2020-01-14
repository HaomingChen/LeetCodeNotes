package crackingleetcode;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 * @author 58212
 * @date 2020-01-15 4:05
 */
public class HouseRobber_198 {


    //记忆化搜索 递归
//    int[] store = new int[10000];
//    public int rob(int[] nums) {
//        if(nums.length == 1){
//            return nums[0];
//        }
//        int max = 0;
//        for(int i = 0; i < nums.length; i++){
//            //first, choose the ith house to rub
//            if(i + 2 < nums.length){
//                int res;
//                if(store[nums.length - i - 2] == 0){
//                    res = rob(Arrays.copyOfRange(nums, i + 2, nums.length));
//                    store[nums.length - i - 2] = res;
//                }else{
//                    res = store[nums.length - i - 2];
//                }
//                max = Math.max(max, nums[i] + res);
//            }else{
//                max = Math.max(max, nums[i]);
//            }
//        }
//        return max;
//    }
}
