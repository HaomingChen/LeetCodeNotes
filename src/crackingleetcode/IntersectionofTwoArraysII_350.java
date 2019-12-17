package crackingleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * @author 58212
 * @date 2019-12-18 2:23
 */
public class IntersectionofTwoArraysII_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> inter = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (inter.containsKey(nums1[i])) {
                inter.put(nums1[i], inter.get(nums1[i]) + 1);
            } else {
                inter.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (inter.containsKey(nums2[i]) && inter.get(nums2[2]) >= 1) {
                inter.put(nums2[i], inter.get(nums2[i]) - 1);
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
