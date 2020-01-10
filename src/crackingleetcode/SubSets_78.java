package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * @author 58212
 * @date 2020-01-09 1:12
 */
public class SubSets_78 {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> lst = new ArrayList<>();
        sub(nums, 0, lst);
        return res;
    }

    private void sub(int[] nums, int start, List<Integer> lst) {
        res.add(new ArrayList<>(lst));
        for (int i = start; i < nums.length; i++) {
            lst.add(nums[i]);
            sub(nums, i + 1, lst);
            lst.remove(lst.size() - 1);
        }
    }
}
