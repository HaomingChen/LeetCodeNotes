package crackingleetcode;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * @author 58212
 * @date 2020-01-26 20:34
 */
public class FIndFirstAndLastPositionOfElementInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int start = 0;
        int end = nums.length - 1;
        //make the start the first index of target
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                //start target mid target end
                //move left
                end = mid;
            }
        }
        if (nums[start] != target) {
            return res;
        } else {
            res[0] = start;
        }
        //end = nums.length - 1;
        //reset end -> mid target target target end
        //so we dont need to reset start
        //make the end the last index of target
        end = nums.length - 1;
        while (start < end) {
            //to deal with the situation where [start, target, end] where
            //start equals target -> start = mid -> (3 + 4) / 2 = 3
            int mid = (start + end) / 2 + 1;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                //start target mid target end
                //move right
                start = mid;
            }
        }
        res[1] = end;
        return res;
    }
}
