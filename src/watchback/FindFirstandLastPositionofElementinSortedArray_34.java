package watchback;

public class FindFirstandLastPositionofElementinSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = {-1,-1};
        int pos = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                pos = mid;
                break;
            }
        }
        if (pos == -1){
            return res;
        }
        int leftBound = pos;
        int rightBound = pos;
        while ((leftBound > -1 && nums[leftBound] == target)
                || (rightBound < nums.length && nums[rightBound] == target))
        {
            if (leftBound > -1 && nums[leftBound] == target){
                leftBound--;
            }
            if (rightBound < nums.length && nums[rightBound] == target){
                rightBound++;
            }
        }
        res[0] = ++ leftBound;
        res[1] = -- rightBound;
        return res;
    }
}
