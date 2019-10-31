package algorithm.sortbasic;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author 58212
 * @date 2019-10-29 23:30
 */
public class MergeSort<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(10000, 0, 100000);
        Helper.printArray(arr);
        Integer[] arr2 = Helper.copyArray(arr);
        Helper.testSort("algorithm.sortbasic.MergeSort", arr);
        Helper.printArray(arr);
    }

    public E[] sort(E[] arr) {
        mergeSort(arr, 0, arr.length - 1);
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

    //归并排序
    private void mergeSort(E[] arr, int l, int r) {
        if (r - l <= 15) {
            insertionSort(arr, l, r);
            return;
        }
        int mid = (r + l) / 2;
        //左数组排序
        mergeSort(arr, l, mid);
        //右数组排序
        mergeSort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            //归并
            merge(arr, l, mid, r);
        }
    }

    private void insertionSort(E[] arr, int head, int tail) {
        //外层已排序数组尾
        for (int i = head; i < tail; i++) {
            //内层未排序数组
            for (int j = i + 1; j > head; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(j - 1, j, arr);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int i, int j, E[] arr) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}