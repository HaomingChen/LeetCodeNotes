package crackingleetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if
 * every element is distinct.
 *
 * @author Haoming Chen
 * Created on 2019/12/21
 */
public class ContainsDuplicate_217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> intSet = new HashSet<>();
        for (int item : nums) {
            if (intSet.contains(item)) {
                return true;
            }
            intSet.add(item);
        }
        return false;
    }

}
