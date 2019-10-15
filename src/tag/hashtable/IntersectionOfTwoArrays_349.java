package tag.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Haoming Chen
 * Created on 2019/10/15
 */
public class IntersectionOfTwoArrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int item : nums1) {
            set.add(item);
        }
        List<Integer> result = new ArrayList<>();
        for (int item : nums2) {
            if (set.contains(item)) {
                result.add(item);
                set.remove(item);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
