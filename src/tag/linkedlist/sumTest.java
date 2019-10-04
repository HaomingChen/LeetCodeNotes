package tag.linkedlist;

/**
 * @author 58212
 * @date 2019-10-03 22:04
 */
public class sumTest {

    public static int sum(int[] arr, int i) {
        if(arr.length == i){
            return 0;
        }
        return arr[i] + sum(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        sum(arr, 0);
        System.out.println(sum(arr, 0));
    }
}
