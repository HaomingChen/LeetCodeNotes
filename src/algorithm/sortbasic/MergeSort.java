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
        int auxMid = mid - l;
        int right = auxMid + 1;
        int left = 0;
        for (int i = 0; i < aux.length; i++) {
            if (left > auxMid) {
                arr[l + i] = aux[right];
                right++;
            } else if (right > aux.length - 1) {
                arr[l + i] = aux[left];
                left++;
            } else if (aux[left].compareTo(aux[right]) < 0) {
                arr[l + i] = aux[left];
                left++;
            } else {
                arr[l + i] = aux[right];
                right++;
            }
        }
    }

    //归并排序
    private void mergeSort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        if(r - l <= 16){
            insertionSort(arr, l, r);
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
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