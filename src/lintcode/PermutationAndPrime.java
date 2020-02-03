package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 58212
 * @date 2020-02-03 17:05
 */
public class PermutationAndPrime {

    static List<Integer> sum = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {3, 7, 12, 19};
        System.out.println(PermutationAndPrime.getWays(a, 3));
    }

    public static int getWays(int[] a, int k) {
        int res = 0;

        getSum(a, 0, k, 0);

        for (Integer item : sum) {
            System.out.println(item);
            if (isPrime(item)) {
                res++;
            }
        }
        return res;
    }

    private static void getSum(int[] a, int start, int degree, int count) {
        if (degree == 0) {
            sum.add(count);
            return;
        }
        for (int i = start; i < a.length; i++) {
            //degree = 2
            getSum(a, i + 1, degree - 1, count + a[i]);
        }
        return;
    }

    public static boolean isPrime(int n) {
        if (n < 3) {
            return n > 1;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
