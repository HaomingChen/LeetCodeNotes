package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers
 * on the row below.
 *
 * @author 58212
 * @date 2020-01-13 0:40
 */
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[i] = min(dp[i] + dp[i+1])
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> first = triangle.get(triangle.size() - 1);
        dp.add(first);
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> lst = dp.get(i - 1);
            List<Integer> currentArr = triangle.get(triangle.size() - 1 - i);
            List<Integer> curDp = new ArrayList<>();
            //获取dp当前位置和右一位数字的最小值
            for(int j = 0; j < currentArr.size(); j++){
                curDp.add(Math.min(lst.get(j), lst.get(j + 1)) + currentArr.get(j));
            }
            dp.add(curDp);
        }
        return dp.get(dp.size() - 1).get(0);
    }

}
