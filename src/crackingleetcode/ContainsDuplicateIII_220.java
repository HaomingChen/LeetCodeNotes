package crackingleetcode;

import java.util.TreeMap;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at
 * most k.
 *
 * @author 58212
 * @date 2019-12-22 1:03
 */
public class ContainsDuplicateIII_220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1 || t < 0) {
            return false;
        }
        //put the integer to map, then count the frequency
        TreeMap<Long, Long> map = new TreeMap<>();
        //[lt, rt]
        int lt = 0;
        int rt = 0;
        //|nums[i] - nums[j]| <= t
        //|i - j| <= k
        while (rt < nums.length) {
            //oversize
            if (rt - lt > k) {
                if(map.get((long) nums[lt]) > 1) {
                    map.put((long) nums[lt], map.get((long) nums[lt]) - 1);
                }else{
                    map.remove((long) nums[lt]);
                }
                lt++;
            } else {
                //floor key ---- k ---- nums[rt]
                if (map.floorKey((long) nums[rt]) != null && map.floorKey((long) nums[rt]) + t >= nums[rt] && map.get(map.floorKey((long) nums[rt])) > 0) {
                    return true;
                }
                //nums[rt] ---- k ---- ceiling key
                else if (map.ceilingKey((long) nums[rt]) != null && map.ceilingKey((long) nums[rt]) - t <= nums[rt] && map.get(map.ceilingKey((long) nums[rt])) > 0) {
                    return true;
                }
                if (map.containsKey((long) nums[rt])) {
                    map.put((long) nums[rt], map.get((long) nums[rt]) + 1);
                } else {
                    map.put((long) nums[rt], 1l);
                }
                rt++;
            }
        }
        return false;
    }
}
