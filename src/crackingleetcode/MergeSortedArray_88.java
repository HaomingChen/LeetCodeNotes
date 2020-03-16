package crackingleetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * @author 58212
 * @date 2019-12-14 0:52
 */
public class MergeSortedArray_88 {
    //关键: 从大往小放, 后面的空间就会空出来, 避免了数组的整体移动
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptA = m - 1;
        int ptB = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (ptA < 0) {
                nums1[i] = nums2[ptB];
                ptB--;
            } else if (ptB < 0) {
                nums1[i] = nums1[ptA];
                ptA--;
            } else if (nums1[ptA] < nums2[ptB]) {
                nums1[i] = nums2[ptB];
                ptB--;
            } else {
                nums1[i] = nums1[ptA];
                ptA--;
            }
        }
    }

}
