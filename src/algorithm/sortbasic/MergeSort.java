package algorithm.sortbasic;

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
//        Helper.testSort("algorithm.sortbasic.SelectionSort", arr2);
        Helper.printArray(arr);
    }

    public void sort(E[] arr, int n) {
        mergeSort(arr, 0, arr.length - 1);
    }

    //归并当前数组
    private void merge(E[] arr, int l, int mid, int r) {
        E[] newArr = (E[]) new Object[r - l];
        int lIndex = l;
        int rIndex = mid;
        for (int i = 0; i < newArr.length; i++) {
            if (lIndex == mid) {
                newArr[i] = arr[lIndex];
                lIndex++;
            } else if (rIndex == r) {
                newArr[i] = arr[rIndex];
                rIndex++;
            } else if (arr[rIndex].compareTo(arr[lIndex]) > 0) {
                newArr[i] = arr[lIndex];
                lIndex++;
            } else {
                newArr[i] = arr[rIndex];
                rIndex++;
            }
        }
    }

    //归并排序
    private void mergeSort(E[] arr, int l, int r) {
        if (arr == null) {
            return;
        }
        mergeSort(arr, l, r / 2);
        mergeSort(arr, (r / 2) + 1, r);
        merge(arr, l, r / 2, r);
    }

}