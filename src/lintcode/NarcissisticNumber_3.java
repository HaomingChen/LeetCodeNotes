package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 水仙花数
 *
 * @author 58212
 * @date 2020-02-01 19:31
 */
public class NarcissisticNumber_3 {

    public static void main(String[] args) {
        solution(1).stream().forEach(item -> System.out.print(" " + item));
    }

    public static List<Integer> solution(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
            if (isNarc(i, n)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean isNarc(int i, int degree) {
        int ori = i;
        int count = 0;
        while (i != 0) {
            count = count + (int) Math.pow(i % 10, degree);
            i = i / 10;
        }
        return ori == count;
    }

}

