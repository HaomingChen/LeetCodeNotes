package bst;

/**
 * 二分查找
 *
 * @author Haoming Chen
 * Created on 2019/11/8
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 13, 24, 34, 44, 44, 56, 78, 99, 102};
//        System.out.println(BinarySearch.binarySearch(arr, 102));
        System.out.println(BinarySearch.floor(arr, 10));
        System.out.println(BinarySearch.ceil(arr, 10));
        System.out.println(BinarySearch.floor(arr, 44));
        System.out.println(BinarySearch.ceil(arr, 44));
    }

    public static int binarySearch(int[] arr, int target) {
        //左区间[head, mid]
        int head = 0;
        //右区间[mid + 1, tail]
        int tail = arr.length - 1;
        int mid = (head + tail) / 2;
        while (head <= tail) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                tail = mid - 1;
                mid = (head + tail) / 2;
            } else {
                head = mid + 1;
                mid = (head + tail) / 2;
            }
        }
        return -1;
    }

    //思路: 寻找比target小的最大索引
    //重要边界: 若相等, 选取左侧数组搜索
    private static int floor(int[] arr, int target) {
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (target <= arr[mid]) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        if (tail + 1 < arr.length && arr[tail + 1] == target) {
            return tail + 1;
        }
        return tail;
    }

    //寻找比target大的最小索引
    //重要边界: 若相等，选取右侧数组搜索
    private static int ceil(int[] arr, int target) {
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (target < arr[mid]) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        if (head - 1 > -1 && arr[head - 1] == target) {
            return head - 1;
        }
        return head;
    }
}
