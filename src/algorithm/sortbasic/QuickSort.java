package algorithm.sortbasic;

/**
 * @author Haoming Chen
 * Created on 2019/11/1
 */
public class QuickSort<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(10000, 0, 100000);
        Helper.printArray(arr);
        Integer[] arr2 = Helper.copyArray(arr);
        Helper.testSort("algorithm.sortbasic.QuickSort", arr);
        Helper.printArray(arr);
    }

    public E[] sort(E[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //partition
        int boundary = partition(arr, l, r);
        //左边部分排序
        quickSort(arr, l, boundary - 1);
        //右边部分排序
        quickSort(arr, boundary + 1, r);
    }

    private int partition(E[] arr, int l, int r) {
        int boundary = l;
        for (int i = l + 1; i <= r; i++) {
            //mid大于i
            if (arr[l].compareTo(arr[i]) > 0) {
                boundary++;
                swap(boundary, i, arr);
            }
        }
        swap(l, boundary, arr);
        return boundary;
    }

    private void swap(int i, int j, E[] arr) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
