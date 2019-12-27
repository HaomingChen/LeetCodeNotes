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

    //数组分离
    //arr[head, tail]
    //arr[head, mid, tail]
    //when the sub array is the array of size 1. head = tail -> [head,tail]. In this case, the array no need to be sort
    private void mergeSort(E[] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = (head + tail) / 2;
        mergeSort(arr, head, mid);
        mergeSort(arr, mid + 1, tail);
        merge(arr, head, mid, tail);
    }

    //左右子树归并
    private void merge(E[] arr, int head, int mid, int tail) {
        E[] sortedArr = Arrays.copyOfRange(arr, head, tail + 1);
        int lth = 0;
        int rth = mid - head + 1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (lth > mid - head) {
                arr[head + i] = sortedArr[rth];
                rth++;
            } else if (rth > sortedArr.length - 1) {
                arr[head + i] = sortedArr[lth];
                lth++;
            } else if (sortedArr[rth].compareTo(sortedArr[lth]) < 0) {
                arr[head + i] = sortedArr[rth];
                rth++;
            } else {
                arr[head + i] = sortedArr[lth];
                lth++;
            }
        }
    }

    private void insertionSort(E[] arr, int head, int tail) {
        //外层已排序数组
        for (int i = head; i < tail; i++) {
            //内层待排序数组
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