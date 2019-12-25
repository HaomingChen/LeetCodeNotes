package crackingleetcode;

/**
 * 给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，
 * 返回值需要是string类型 否则可能会溢出 30,1 301
 *
 * @author Haoming Chen
 * Created on 2019/12/25
 */
public class BilibiliOnlineAccessment_01 {

    public static void main(String[] args) {
//        int[] argu = new int[]{30};
        int[] argu = new int[]{1,203,20,9,8};
//        int[] argu = new int[]{1,201,20,9,8};
//        int[] argu = new int[]{1,20,23,4,8};
        System.out.println(getMaxiMum(argu));
    }

    public static String getMaxiMum(int[] arr) {
        if(arr == null || arr.length == 0){
            return "";
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (compareInt(arr[j], arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = arr.length - 1; k > -1; k--) {
            sb.append(arr[k]);
        }
        return sb.toString();
    }

    private static int compareInt(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(b);
        sb2.append(a);

        //ab bigger than ba
        if (Integer.parseInt(sb.toString()) > Integer.parseInt(sb2.toString())) {
            return 1;
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
