package algorithm.sortbasic;

/**
 * @author Haoming Chen
 * Created on 2019/11/1
 */
public class QuickSortTwoWay<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(9999, 0, 100000);
        Helper.printArray(arr);
        Integer[] arr2 = Helper.copyArray(arr);
        Helper.testSort("algorithm.sortbasic.QuickSortTwoWay", arr);
        Helper.printArray(arr);
    }

    public E[] sort(E[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //[l,r]左闭右闭
        int boundary = partition(arr, l, r);
        quickSort(arr, l, boundary - 1);
        quickSort(arr, boundary + 1, r);
    }

    private int partition(E[] arr, int l, int r) {
        int lt = l;
        int gt = r + 1;
        int less = lt + 1;
        int greater = gt - 1;
        while (true) {
            while (less <= greater && arr[l].compareTo(arr[less]) > 0) {
                less++;
                lt++;
            }
            while (less <= greater && arr[l].compareTo(arr[greater]) < 0) {
                greater--;
                gt--;
            }
            if (less > greater) {
                break;
            }
            swap(less, greater, arr);
            less++;
            lt++;
            greater--;
            gt--;
        }
        swap(lt, l, arr);
        return lt;
    }

    private void swap(int i, int j, E[] arr) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
