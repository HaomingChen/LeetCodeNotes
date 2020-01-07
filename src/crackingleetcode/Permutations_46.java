package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * @author 58212
 * @date 2020-01-07 23:53
 */
public class Permutations_46 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> lst = new ArrayList<>();
        getPermute(nums, lst);
        return res;
    }

    private void getPermute(int[] nums, List<Integer> lst) {
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>(lst));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            lst.add(nums[i]);
            int count = 0;
            int[] arr = new int[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    arr[count] = nums[j];
                    count++;
                }
            }
            getPermute(arr, lst);
            lst.remove(lst.size() - 1);
        }
    }

}


