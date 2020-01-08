package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
 * used and each combination should be a unique set of numbers.
 * Note:
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author 58212
 * @date 2020-01-09 0:46
 */
public class CombinationSumIII_216 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 0 || n < 0) {
            return res;
        }
        List<Integer> lst = new ArrayList<>();
        comb(k, n, 1, lst);
        return res;
    }

    private void comb(int k, int target, int start, List<Integer> lst) {
        if (k == 0 && target == 0) {
            res.add(new ArrayList(lst));
            return;
        } else if (k == 0 || target <= 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            lst.add(i);
            comb(k - 1, target - i, i + 1, lst);
            lst.remove(lst.size() - 1);
        }
    }

}
