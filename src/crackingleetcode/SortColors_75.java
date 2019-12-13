package crackingleetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue Here, we will use the integers 0, 1, and 2 to represent
 * the color red, white, and blue respectively.
 * @author 58212
 * @date 2019-12-14 0:51
 */
public class SortColors_75 {

    public void sortColors(int[] nums) {
        int left = -1;
        int right = nums.length;
        for (int i = 0; i < right; i++) {
            if(nums[i] == 0){
                left++;
                swap(nums, left, i);
            }
            if(nums[i] == 2){
                right--;
                swap(nums, right, i);
                i--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
