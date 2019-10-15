package tag.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Haoming Chen
 * Created on 2019/10/15
 */
public class IntersectionOfTwoArraysII_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> eleMap = new TreeMap<>();
        for (int ele : nums1) {
            if (eleMap.containsKey(ele)) {
                eleMap.put(ele, eleMap.get(ele) + 1);
            } else {
                eleMap.put(ele, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int ele : nums2) {
            if (eleMap.containsKey(ele)) {
                list.add(ele);
                if (eleMap.get(ele) == 1) {
                    eleMap.remove(ele);
                } else {
                    eleMap.put(ele, eleMap.get(ele) - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
