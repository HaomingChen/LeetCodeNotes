package crackingleetcode;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * @author 58212
 * @date 2019-12-14 0:53
 */
public class KthLargestElementinanArray_215 {

    int ret = -1;

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, k, 0, nums.length - 1);
        return ret;
    }

    private void quickSort(int[] nums, int l, int r, int k) {
        if (l > r) {
            return;
        }
        int pivot = partition(nums, l, r);
        if (nums.length - pivot == k) {
            ret = nums[pivot];
            return;
        }
        quickSort(nums, l, pivot - 1, k);
        quickSort(nums, pivot + 1, r, k);
    }

    private int partition(int[] nums, int head, int tail) {
        int lt = head;
        for (int i = head + 1; i <= tail; i++) {
            if (nums[head] > nums[i]) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, lt, head);
        return lt;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
