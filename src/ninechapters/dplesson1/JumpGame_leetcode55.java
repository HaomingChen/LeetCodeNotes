package ninechapters.dplesson1;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * @author Haoming Chen
 * Created on 2020/3/3
 */
public class JumpGame_leetcode55 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        canJump(arr);
    }

    public static boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = 0; j <= nums[i]; j++) {
                    if (i + j < dp.length) {
                        dp[i + j] = true;
                    }
                }
                printDp(dp);
            }
        }
        printDp(dp);
        return dp[dp.length - 1];
    }

    private static void printDp(boolean[] dp) {
        for (boolean item : dp) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
