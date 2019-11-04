package algorithm.sortbasic;

/**
 * @author Haoming Chen
 * Created on 2019/11/1
 */
public class QuickSortThreeWay<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = Helper.generateArray(10000, 0, 100000);
        Helper.printArray(arr);
        Integer[] arr2 = Helper.copyArray(arr);
        Helper.testSort("algorithm.sortbasic.QuickSortThreeWay", arr);
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
        //[l + 1, lt] 小于区间
        //[lt + 1, eb] 等于区间
        //[gt, r] 大于区间
        //eb + 1 -> 下标
        int lt = l;
        int eb = l;
        int gt = r + 1;
        int index = eb + 1;
        while (index < gt) {
            //小于区间
            if (arr[l].compareTo(arr[index]) > 0) {
                lt++;
                eb++;
                index++;
            }
            //大于区间
            else if (arr[l].compareTo(arr[index]) < 0) {
                gt--;
                swap(gt, index, arr);
            }
            //等于区间
            else {
                eb++;
                index++;
            }
        }
        swap(lt, l, arr);
        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);
    }

    private void swap(int i, int j, E[] arr) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
