package crackingleetcode;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers
 * on the row below.
 *
 * @author 58212
 * @date 2020-01-13 0:40
 */
public class Triangle_120 {

    //Rewrite by 2020-01-29
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.get(triangle.size() - 1).size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> degree = triangle.get(i);
            for (int j = 0; j < degree.size(); j++) {
                if (i == triangle.size() - 1) {
                    sum[j] = degree.get(j);
                } else {
                    sum[j] = degree.get(j) + Math.min(sum[j], sum[j + 1]);
                }
            }
        }
        return sum[0];
    }

}
