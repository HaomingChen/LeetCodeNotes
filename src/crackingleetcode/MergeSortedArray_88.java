package crackingleetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * @author 58212
 * @date 2019-12-14 0:52
 */
public class MergeSortedArray_88 {

    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pta = 0;
        int ptb = 0;

        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = nums1[i];
        }
        for(int i = 0; i < m + n; i++){
            if(pta >= m){
                nums1[i] = nums2[ptb];
                ptb++;
            }else if(ptb >= n){
                nums1[i] = arr[pta];
                pta++;
            }else if(arr[pta] > nums2[ptb]){
                nums1[i] = nums2[ptb];
                ptb++;
            }else{
                nums1[i] = arr[pta];
                pta++;
            }
        }
    }

}
