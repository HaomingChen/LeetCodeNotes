package crackingleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (dp.containsKey(sum)) {
                res = Math.max(res, i - dp.get(sum));
            } else {
                dp.put(sum, i);
            }
        }
        return res;
    }

}
