package ninechapters.binarysearch;

/**
 * Suppose a sorted array in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 *
 * @author Haoming Chen
 * Created on 2020/2/10
 */
public class FindMinimuminRotatedSortedArray_159 {

    // critical point : find the first number less than the target
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int target = nums[nums.length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] < target) {
            return nums[start];
        }
        return nums[end];
    }

}
