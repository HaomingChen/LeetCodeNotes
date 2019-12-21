package crackingleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the
 * range [-10000, 10000] (inclusive).
 *
 * @author Haoming Chen
 * Created on 2019/12/21
 */
public class NumberofBoomerangs_447 {
    //  Input:
    //  [[0,0],[1,0],[2,0]]
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            //get current point
            int[] cur = points[i];
            //distance, frequency
            Map<Integer, Integer> disFrq = new HashMap<>(points.length);
            for (int j = 0; j < points.length; j++) {
                //get other points and calculate the distance
                int distance = calcDis(cur, points[j]);
                if (disFrq.containsKey(distance)) {
                    disFrq.put(distance, disFrq.get(distance) + 1);
                } else {
                    disFrq.put(distance, 1);
                }
            }
            for (Integer dis : disFrq.keySet()) {
                res = res + disFrq.get(dis) * (disFrq.get(dis) - 1);
            }
        }
        return res;
    }

    /**
     * calculate distance between m and n
     */
    private int calcDis(int[] m, int[] n) {
        return (m[0] - n[0]) * (m[0] - n[0]) + (m[1] - n[1]) * (m[1] - n[1]);
    }

}
