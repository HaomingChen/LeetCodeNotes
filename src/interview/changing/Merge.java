package interview.changing;

/**
 * 将一个升序、降序、升序的
 * @author Haoming Chen
 * Created on 2020/2/11
 */
public class Merge {

    public static void main(String[] args) {
//        //Test Case 1:
//        int[] asc = {1, 3, 5, 7, 9};
//        int[] asc2 = {2, 3, 6, 10, 13};
//        int[] desc = {13, 9, 7, 4, 2};

//        //Test Case 2:
//        int[] asc = {1, 3, 5, 7, 9};
//        int[] asc2 = {};
//        int[] desc = {13, 9, 7, 4, 2};

//        //Test Case 3:
//        int[] asc = {};
//        int[] asc2 = {2, 3, 6, 10, 13};
//        int[] desc = {13, 9, 7, 4, 2};

//        //Test Case 4:
//        int[] asc = {1};
//        int[] asc2 = {2, 3, 6, 10, 13};
//        int[] desc = {13, 9, 7, 4, 2};

        //Test Case 5:
        int[] asc = {1};
        int[] asc2 = {2, 3, 6, 10, 13};
        int[] desc = {};

        int[] sorted = merge(asc, desc, asc2);
        System.out.println("***** Accumulated Array Size: " + (asc.length + asc2.length + desc.length) + " *****\n");
        checkIfValid(sorted);
        System.out.println("\n***** Sorted Array Size: " + sorted.length + " **********");
    }

    /**
     * 归并升序数组
     */
    static public int[] merge(int[] a, int[] b, int[] c) {
        int indexA = 0;
        int indexC = 0;
        int[] sorted = new int[a.length + c.length];
        //数组ac为升序
        //归并升序数组
        for (int i = 0; i < sorted.length; i++) {
            if (indexA > a.length - 1) {
                sorted[i] = c[indexC];
                indexC++;
            } else if (indexC > c.length - 1) {
                sorted[i] = a[indexA];
                indexA++;
            } else if (a[indexA] > a[indexC]) {
                sorted[i] = a[indexC];
                indexC++;
            } else {
                sorted[i] = a[indexA];
                indexA++;
            }
        }
        //归并降序数组
        return mergeDescending(sorted, b);

    }

    /**
     * 归并升序数组与降序数组
     */
    private static int[] mergeDescending(int[] asc, int[] desc) {
        int[] sorted = new int[asc.length + desc.length];
        //数组ac为升序
        //归并升序/降序数组
        int indexAsc = 0;
        int indexDesc = desc.length - 1;
        for (int i = 0; i < sorted.length; i++) {
            if (indexAsc > asc.length - 1) {
                sorted[i] = desc[indexDesc];
                indexDesc--;
            } else if (indexDesc < 0) {
                sorted[i] = asc[indexAsc];
                indexAsc++;
            } else if (asc[indexAsc] > desc[indexDesc]) {
                sorted[i] = desc[indexDesc];
                indexDesc--;
            } else {
                sorted[i] = asc[indexAsc];
                indexAsc++;
            }
        }
        return sorted;
    }

    /**
     * 将传入数组的每个数与前一个数比对, 若不为递增, 则返回false
     */
    private static boolean checkIfValid(int[] sorted) {
        if (sorted.length == 0) {
            System.out.println("Not An Ascending Array");
            return false;
        }
        int prev = 0;
        System.out.print(sorted[prev] + " ");
        for (int i = 1; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
            if (sorted[prev] > sorted[i]) {
                System.out.println("Not An Ascending Array");
                return false;
            }
            prev = i;
        }
        System.out.println("\nPerfect!");
        return true;
    }
}
