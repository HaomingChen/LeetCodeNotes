package crackingleetcode;

/**
 * @author 58212
 * @date 2019-12-31 23:14
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 9, 4, 2, 4, 7, 4, 0, 4, 2, 6};
        int[] arr2 = new int[]{32, 87, 3, 12, 98, 43, 21, 6459, 54, 2, 2};
        int[] arr3 = new int[]{};
        int[] arr4 = new int[]{22};
        quickSort(arr4);
        for (int i : arr2) {
            System.out.print(i + " ");
        }

    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(0, arr.length - 1, arr);
    }

    public static void quickSort(int start, int end, int[] arr) {
        if (start >= end) {
            return;
        }

        int pivot = partition(start, end, arr);
        quickSort(start, pivot - 1, arr);
        quickSort(pivot + 1, end, arr);
    }

    private static int partition(int start, int end, int[] arr) {
        int lt = start;
        int rt = end + 1;
        int pt = lt + 1;

        while (pt < rt) {
            if (arr[start] > arr[pt]) {
                lt++;
                pt++;
            } else {
                rt--;
                swap(rt, pt, arr);
            }
        }
        swap(lt, start, arr);
        return lt;
    }

    private static void swap(int l, int r, int[] arr) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
