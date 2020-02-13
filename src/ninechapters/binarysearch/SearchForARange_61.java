package ninechapters.binarysearch;

/**
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 *
 * @author Haoming Chen
 * Created on 2020/2/13
 */
public class SearchForARange_61 {

    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        if (A.length == 0) {
            return res;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int leftBound;
        if (A[start] == target) {
            leftBound = start;
        } else if (A[end] == target) {
            leftBound = end;
        } else {
            return res;
        }
        res[0] = leftBound;
        start = leftBound;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            res[1] = end;
        } else {
            res[1] = start;
        }
        return res;
    }

}
