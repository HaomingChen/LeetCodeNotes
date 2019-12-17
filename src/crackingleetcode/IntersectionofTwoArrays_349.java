package crackingleetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * @author 58212
 * @date 2019-12-18 2:41
 */
public class IntersectionofTwoArrays_349 {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            if (nums1.length == 0 || nums2.length == 0) {
                return new int[]{};
            }
            Set<Integer> charSet = new HashSet<>();
            List<Integer> resList = new ArrayList<>();

            for (int i = 0; i < nums1.length; i++) {
                charSet.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (charSet.contains(nums2[i])) {
                    resList.add(nums2[i]);
                    charSet.remove(nums2[i]);
                }
            }

            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }
    }

}
