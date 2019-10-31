package algorithm.sortbasic;

import java.util.Arrays;

/**
 * @author Haoming Chen
 * Created on 2019/10/31
 */
public class MergeSortBU<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(10000, 0, 100000);
        Helper.printArray(arr);
        Integer[] arr2 = Helper.copyArray(arr);
        Helper.testSort("algorithm.sortbasic.MergeSortBU", arr);
        Helper.printArray(arr);
    }

    public E[] sort(E[] arr) {
        for (int scope = 1; scope <= arr.length; scope = 2 * scope) {
            for (int j = 0; j < arr.length - scope; j = j + 2 * scope) {
                int right = j + 2 * scope - 1 > arr.length - 1 ? arr.length - 1 : j + 2 * scope - 1;
                merge(arr, j, j + scope - 1, right);
            }
        }
        return arr;
    }

    //归并当前数组
    private void merge(E[] arr, int l, int mid, int r) {
        E[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

}
