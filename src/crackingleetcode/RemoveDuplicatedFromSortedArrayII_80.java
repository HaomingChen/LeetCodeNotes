package crackingleetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return
 * the new length. Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * @author 58212
 * @date 2019-12-13 22:20
 */
public class RemoveDuplicatedFromSortedArrayII_80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        int pointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[pointer] && count == 1) {
                continue;
            }
            if (nums[i] != nums[pointer]) {
                count = 0;
            } else {
                count++;
            }
            pointer++;
            nums[pointer] = nums[i];
        }
        return pointer + 1;
    }
}
