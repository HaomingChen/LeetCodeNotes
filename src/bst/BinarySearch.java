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
        System.out.println(BinarySearch.binarySearch(arr, 33));
    }

    public static int binarySearch(int[] arr, int target) {
        //左区间[0, mid]
        //右区间[mid + 1, arr.length - 1]
        int lt = 0;
        int mid = arr.length / 2;
        int gt = arr.length - 1;
        //[lt, mid, gt]
        while (lt <= gt) {
            System.out.println("lt：" + lt);
            System.out.println("mid：" + mid);
            System.out.println("gt：" + gt);
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                //mid + 1因mid已经比对过, 不可能与目标元素相等
                lt = mid + 1;
                mid = lt + (gt - lt) / 2;
                mid = gt / 2 + lt / 2;
            } else {
                gt = mid - 1;
                mid = lt + (gt - lt) / 2;
            }
        }
        return -1;
    }


    //元素的左区间[floor, ceil]
    private int floor() {
        return 0;
    }

    //若找不到该元素floor + 1 = ceil
    //元素的右区间
    private int ceil() {
        return 0;
    }
}
