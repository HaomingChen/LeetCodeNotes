package crackingleetcode;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * @author 58212
 * @date 2019-12-14 0:53
 */
public class KthLargestElementinanArray_215 {

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        KthLargestElementinanArray_215 kthLargestElementinanArray_215 = new KthLargestElementinanArray_215();
        System.out.println(kthLargestElementinanArray_215.findKthLargest(arr, 2));
    }

    int res = -1;
    int k = 0;

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return res;
        }
        this.k = k;
        quickSortBase(nums, 0, nums.length - 1);
        return res;
    }

    private void quickSortBase(int[] nums, int head, int tail) {
        if (head > tail) {
            return;
        }
        int pivot = partition(nums, head, tail);
        if (nums.length - pivot == k) {
            res = nums[pivot];
            return;
        }
        quickSortBase(nums, head, pivot - 1);
        quickSortBase(nums, pivot + 1, tail);
    }

    private int partition(int[] nums, int head, int tail) {
        int lt = head;
        for (int i = head + 1; i <= tail; i++) {
            if (nums[i] < nums[head]) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, head, lt);
        return lt;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
