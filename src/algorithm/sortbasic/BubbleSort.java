package algorithm.sortbasic;

/**
 * @author Haoming Chen
 * Created on 2019/10/24
 */
public class BubbleSort<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(10, 0, 1000);
        Helper.printArray(arr);
        Integer[] arr2 = Helper.copyArray(arr);
        Helper.testSort("algorithm.sortbasic.BubbleSort", arr);
//        Helper.testSort("algorithm.sortbasic.SelectionSort", arr2);
        Helper.printArray(arr);
    }

    public E[] sort(E[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(j, j + 1, arr);
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
