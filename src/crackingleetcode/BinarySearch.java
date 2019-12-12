package crackingleetcode;

/**
 * @author 58212
 * @date 2019-12-13 1:00
 */
public class BinarySearch<E extends Comparable<E>> {

    int pos = -1;

    public static void main(String[] args) {
        Integer[] arr = {1,3,5,7,9,11};
        Integer target = 1;
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(arr, target));
    }

    public int binarySearch(E[] arr, E target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        binarySearch(arr, start, mid, end, target);
        return pos;
    }

    public void binarySearch(E[] arr, int start, int mid, int end, E target) {
        //递归返回条件
        if (start > end) {
            return;
        }
        if (target.compareTo(arr[mid]) == 0) {
            pos = mid;
            return;
        }
        //target比中值小, 查找左子树
        if (target.compareTo(arr[mid]) < 0) {
            binarySearch(arr, start, (start + mid - 1) / 2, mid - 1, target);
        }
        //target比中值大，查找右子树
        else if (target.compareTo(arr[mid]) > 0) {
            binarySearch(arr, mid + 1, (mid + 1 + end) / 2, end, target);
        }
        return;
    }

}
