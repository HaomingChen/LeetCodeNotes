package lintcode;

/**
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n)
 * time complexity.If the target number does not exist in the array, return -1.
 *
 * @author Haoming Chen
 * Created on 2020/2/7
 */
public class FirstPositionOfTarget_14 {

    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

}
