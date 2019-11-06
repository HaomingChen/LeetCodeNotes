package tag.divideandconquer;

import java.util.Arrays;

/**
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * You need to return the number of important reverse pairs in the given array.
 *
 * @author Haoming Chen
 * Created on 2019/11/6
 */
public class ReversePairs_493 {

    int count = 0;

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};
        ReversePairs_493 reversePairs_493 = new ReversePairs_493();
        System.out.println(reversePairs_493.reversePairs(arr));
//        for (int i : arr) {
//            System.out.println(i);
//        }
    }

    public int reversePairs(int[] nums) {
        mergeHelper(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeHelper(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        mergeHelper(nums, l, (r + l) / 2);
        mergeHelper(nums, (r + l) / 2 + 1, r);
        merge(nums, l, (r + l) / 2, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(nums, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                nums[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                nums[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < (aux[j - l])) {  // 左半部分所指元素 < 右半部分所指元素
                nums[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                if (aux[i - l] > 2 * aux[j - l]) {
                    count = count + mid - i + 1;
                }
                nums[k] = aux[j - l];
                j++;
            }
        }
    }

}
