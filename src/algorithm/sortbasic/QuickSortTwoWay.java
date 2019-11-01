package algorithm.sortbasic;

/**
 * @author Haoming Chen
 * Created on 2019/11/1
 */
public class QuickSortTwoWay<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(10000, 0, 100000);
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
        int right = r;
        int left = l + 1;
        while (true) {
            while (left <= r && (arr[left].compareTo(arr[l]) <= 0)) {
                left++;
            }
            while (right >= l + 1 && (arr[right].compareTo(arr[l]) >= 0)) {
                right--;
            }
            //左右索引越界
            if (left > right) {
                break;
            }
            swap(left, right, arr);
        }
        swap(left, l, arr);
        return left;
    }

    private void swap(int i, int j, E[] arr) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
