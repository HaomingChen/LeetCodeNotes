package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author 58212
 * @date 2020-01-08 23:48
 */
public class CombinationSum_39 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target < 0 || candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> lst = new ArrayList<>();
        combination(candidates, target, lst, 0);
        return res;
    }

    private void combination(int[] cand, int target, List<Integer> lst, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(lst));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < cand.length; i++) {
            lst.add(cand[i]);
            combination(cand, target - cand[i], lst, i);
            lst.remove(lst.size() - 1);
        }

    }

}
