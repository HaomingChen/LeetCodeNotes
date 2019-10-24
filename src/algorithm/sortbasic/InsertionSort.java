package algorithm.sortbasic;

/**
 * 插入排序: 将有序数组的后一个值插入有序数组中, 直到数组被遍历完成
 * 情景: 当数组近乎有序时-> 时间复杂度为O(n) 因为每个有序数组的后一个元素只需要与前值进行一次比较即可
 *
 * @author Haoming Chen
 * Created on 2019/10/24
 */
public class InsertionSort<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(10, 0, 1000);
        Helper.printArray(arr);
        Integer[] arr2 = Helper.copyArray(arr);
        Helper.testSort("algorithm.sortbasic.InsertionSort", arr);
//        Helper.testSort("algorithm.sortbasic.SelectionSort", arr2);
        Helper.printArray(arr);
    }

    public E[] sort(E[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不可为空");
        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(j, j - 1, arr);
//                } else {
//                    break;
//                }
//            }
//        }
        //优化 -> 一次swap需要做到三次赋值操作 -> 改进为一次赋值操作
        for (int i = 1; i < arr.length; i++) {
            E item = arr[i];
            boolean isSwitched = false;
            for (int j = i; j > 0; j--) {
                if (item.compareTo(arr[j - 1]) > 0) {
                    arr[j] = item;
                    isSwitched = true;
                    break;
                } else {
                    arr[j] = arr[j - 1];
                }
            }
            if (!isSwitched) {
                arr[0] = item;
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
