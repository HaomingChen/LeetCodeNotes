package tag.divideandconquer;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * @author Haoming Chen
 * Created on 2019/11/6
 */
public class KthLargestElementInAnArray_215 {

    public int ret;
    public int k;

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        KthLargestElementInAnArray_215 kthLargestElementInAnArray_215 = new KthLargestElementInAnArray_215();
        System.out.println(kthLargestElementInAnArray_215.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {

        this.k = k;
        quickSortBase(nums, 0, nums.length - 1);
        return ret;

    }

    private void quickSortBase(int[] nums, int l, int r) {

        if (l > r) {
            return;
        }
        int pivot = getPivot(nums, l, r);
        if (nums.length - pivot == k) {
            ret = nums[pivot];
            return;
        }
        quickSortBase(nums, l, pivot - 1);
        quickSortBase(nums, pivot + 1, r);
    }

    private int getPivot(int[] nums, int l, int r) {
        int lt = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < nums[l]) {
                lt++;
                swap(lt, i, nums);
            }
        }
        swap(lt, l, nums);
        return lt;
    }

    private void swap(int l, int r, int[] arr) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
