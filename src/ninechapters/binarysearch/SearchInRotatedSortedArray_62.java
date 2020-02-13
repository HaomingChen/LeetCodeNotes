package ninechapters.binarysearch;

import java.util.Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * @author Haoming Chen
 * Created on 2020/2/13
 */
public class SearchInRotatedSortedArray_62 {

    /**
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int tgt = A[A.length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= tgt) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int edge = 0;
        if (A[start] <= tgt) {
            edge = start;
        } else {
            edge = end;
        }
        int res1 = binarySearch(Arrays.copyOfRange(A, 0, edge), target);
        int res2 = binarySearch(Arrays.copyOfRange(A, edge, A.length), target);
        if (res1 != -1) {
            return res1;
        } else if (res2 != -1) {
            return res2 + edge;
        }
        return -1;
    }

    private int binarySearch(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        }
        return -1;
    }

}
