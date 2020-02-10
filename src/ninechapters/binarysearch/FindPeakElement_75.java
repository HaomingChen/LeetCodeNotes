package ninechapters.binarysearch;

/**
 * There is an integer array which has the following features:
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peak if:
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 *
 * @author Haoming Chen
 * Created on 2020/2/11
 */
public class FindPeakElement_75 {

    public int findPeak(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
                //ascending, answer must at the right side of the array
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                start = mid;
                //descending, answer must at the left side of the array
            } else {
                end = mid;
            }
        }
        return -1;
    }

}
