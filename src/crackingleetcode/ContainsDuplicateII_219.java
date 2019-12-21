package crackingleetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Using searching list and sliding window simultaneously
 *
 * @author Haoming Chen
 * Created on 2019/12/21
 */
public class ContainsDuplicateII_219 {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums.length <= 1){
                return false;
            }
            //[lt, rt]
            int lt = 0;
            int rt = 0;
            Set<Integer> numSet = new HashSet<>();
            while(rt < nums.length){
                if(numSet.contains(nums[rt])){
                    return true;
                }else{
                    numSet.add(nums[rt]);
                    rt++;
                    if(rt - lt > k){
                        numSet.remove(nums[lt]);
                        lt++;
                    }
                }
            }
            return false;
        }
    }
}
