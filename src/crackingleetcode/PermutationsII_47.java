package crackingleetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * @author 58212
 * @date 2020-01-08 0:55
 */
public class PermutationsII_47 {

    Set<String> hashSet = new HashSet<>();

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> lst = new ArrayList<>();
        getPermute(nums, lst);
        return res;
    }

    private void getPermute(int[] nums, List<Integer> lst) {
        if (nums.length == 0) {
            StringBuilder sb = new StringBuilder();
            for (Integer item : lst) {
                sb.append(item);
                sb.append("#");
            }
            if (hashSet.contains(sb.toString())) {
                return;
            } else {
                res.add(new ArrayList<>(lst));
                hashSet.add(sb.toString());
                return;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            lst.add(nums[i]);
            int[] newNum = new int[nums.length - 1];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    newNum[count] = nums[j];
                    count++;
                }
            }
            getPermute(newNum, lst);
            lst.remove(lst.size() - 1);
        }

    }

}
