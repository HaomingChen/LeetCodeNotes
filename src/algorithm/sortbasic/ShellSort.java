package algorithm.sortbasic;

/**
 * 希尔排序
 *
 * @author Haoming Chen
 * Created on 2019/10/29
 */
public class ShellSort<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(39997, 0, 100000);
        Helper.printArray(arr);
        Integer[] arr2 = Helper.copyArray(arr);
        Helper.testSort("algorithm.sortbasic.ShellSort", arr);
        Helper.printArray(arr);
    }

    public E[] sort(E[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("传入的数组不可为空");
        }
        int scope = arr.length / 2;
        while (scope != 0) {
            for (int i = 0; i < scope; i++) {
                insertionSort(arr, scope, i);
            }
            scope = scope / 2;
        }
        return arr;
    }

    private E[] insertionSort(E[] arr, int scope, int head) {
        for (int i = head; i < arr.length - scope; i = i + scope) {
            for (int j = i + scope; j > head; j = j - scope) {
                if (arr[j].compareTo(arr[j - scope]) < 0) {
                    swap(j, j - scope, arr);
                }else{
                    break;
                }
            }
        }
        return arr;
    }

    private void swap(int i, int j, E[] arr) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
