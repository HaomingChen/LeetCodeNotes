package bst;

/**
 * @author Haoming Chen
 * Created on 2019/11/27
 */
public class BinarySearch2 {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 13, 24, 34, 44, 44, 56, 78, 99, 102};
//        System.out.println(BinarySearch.binarySearch(arr, 102));
        System.out.println(BinarySearch2.floor(arr, 10));
        System.out.println(BinarySearch2.ceil(arr, 10));
        System.out.println(BinarySearch2.floor(arr, 44));
        System.out.println(BinarySearch2.ceil(arr, 44));
    }

    public static int binarySearch(int[] arr, int target) {

        int head = 0;
        int tail = arr.length - 1;
        int mid = (head + tail) / 2;
        while (head < tail) {
            if (target == arr[mid]) {
                return mid;
            }
            //左子树
            if (target < arr[mid]) {
                tail = mid - 1;
            }
            //右子树
            if (target > arr[mid]) {
                head = mid + 1;
            }
            mid = (head + tail) / 2;
        }
        return -1;
    }

    //思路: 寻找比target小的最大索引
    //重要边界: 若相等, 选取左侧数组搜索
    private static int floor(int[] arr, int target) {
        //结束条件 较小值, target, 较大值
        int head = 0;
        int tail = arr.length - 1;
        while (head < tail) {
            int mid = (head + tail) / 2;
            if (arr[mid] <= mid) {
                tail = mid - 1;
            } else {
                head = tail + 1;
            }
        }
        if (tail + 1 < arr.length && arr[tail + 1] == target) {
            return tail + 1;
        }
        return tail;

    }

    private static int ceil(int[] arr, int target) {
        return -1;
    }
}
