package lintcode;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where
 * it would be if it were inserted in order. You may assume NO duplicates in the array.
 *
 * @author Haoming Chen
 * Created on 2020/2/7
 */
public class SearchInsertPosition_60 {

    public int searchInsert(int[] A, int target) {
        //[start, mid, end]
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}
