package crackingleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that
 * A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the
 * range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * @author Haoming Chen
 * Created on 2019/12/21
 */
public class FourSumII_454 {

    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            if (A.length != B.length || B.length != C.length || C.length != D.length) {
                throw new IllegalArgumentException("please enter some equal length Array");
            }
            int count = 0;
            //sum, num
            Map<Integer, Integer> sumCount = new HashMap<>();
            for (int a : A) {
                for (int b : B) {
                    if (sumCount.containsKey(a + b)) {
                        sumCount.put(a + b, sumCount.get(a + b) + 1);
                    } else {
                        sumCount.put(a + b, 1);
                    }
                }
            }

            for (int c : C) {
                for (int d : D) {
                    if (sumCount.containsKey(0 - c - d)) {
                        count = count + sumCount.get(0 - c - d);
                    }
                }
            }
            return count;
        }
    }

}
