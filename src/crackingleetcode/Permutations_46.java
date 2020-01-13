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

    List<List<Integer>> res;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        getPermute(nums, 0, path);
        return res;
    }

    private void getPermute(int[] nums, int index, List<Integer> lst) {
        if (index == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                lst.add(nums[i]);
                getPermute(nums, index + 1, lst);
                lst.remove(lst.size() - 1);
                visited[i] = false;
            }
        }
    }

}


