package crackingleetcode;

/**
 * @author 58212
 * @date 2019-12-13 22:19
 */
public class RemoveDuplicatedFromSortedArray_26 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        RemoveDuplicatedFromSortedArray_26 res = new RemoveDuplicatedFromSortedArray_26();
        System.out.println("results" + res.removeDuplicates(nums));
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 1;
        }
        int head = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[head] != nums[i]) {
                head++;
                swap(nums, head, i);
            }
        }
        return head + 1;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
