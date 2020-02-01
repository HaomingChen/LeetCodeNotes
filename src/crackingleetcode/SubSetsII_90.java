package crackingleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * @author 58212
 * @date 2020-02-01 23:51
 */
public class SubSetsII_90 {

    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        getSubSets(nums, 0, new ArrayList<>());
        return res;
    }

    private void getSubSets(int[] nums, int start, ArrayList<Integer> lst) {
        res.add(new ArrayList<>(lst));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            lst.add(nums[i]);
            getSubSets(nums, i + 1, lst);
            lst.remove(lst.size() - 1);
        }
    }
}
