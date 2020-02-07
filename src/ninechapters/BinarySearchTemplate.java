package ninechapters;

/**
 * @author Haoming Chen
 * Created on 2020/2/7
 */
public class BinarySearchTemplate {

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
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
        //start -> end相邻
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == start) {
            return end;
        }
        return -1;
    }
}
