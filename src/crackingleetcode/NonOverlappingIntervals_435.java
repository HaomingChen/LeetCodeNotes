package crackingleetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest
 * of the intervals non-overlapping.
 *
 * @author 58212
 * @date 2020-01-23 3:34
 */
public class NonOverlappingIntervals_435 {

    //dp methods very slow
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0){
            return 0;
        }
        Comparator cp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((int[])o1)[0] - ((int[])o2)[0];
            }
        };
        Arrays.sort(intervals, cp);
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        for(int i = 1; i < intervals.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(intervals[i][0] >= intervals[j][1]){
                    dp[i] = dp[i] > dp[j] + 1? dp[i] : dp[j] + 1;
                }else{
                    dp[i] = dp[i] > dp[j]? dp[i] : dp[j];
                }
            }
        }
        return intervals.length - dp[dp.length - 1];
    }

}
