package crackingleetcode;

/**
 * 背包问题
 *
 * @author 58212
 * @date 2020-01-17 1:40
 */
public class knapsack {
    //i -> index of items j -> rest capacity
    //dp[i] = Math.max(i + dp[i - 1, c - i], dp[i - 1 ,c])

    public int knapsack01(int[] w, int[] v, int C) {
        //dp[i] = Math.max(v[i] + dp[i - 1, c - w[i]], dp[i - 1, c])
        int[][] dp = new int[w.length][C];
        for (int i = 0; i <= C; i++) {
            if (i >= w[0])
                dp[0][i] = v[0];
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j <= C; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(v[i] + dp[i - 1][C - w[i]], dp[i - 1][C]);
                } else {
                    dp[i][j] = dp[i - 1][C];
                }
            }
        }
        return dp[w.length - 1][C];
    }
    //记忆化搜索
//    int[][] value;
//    public int knapsack01(int[] w, int[] v, int C){
//        int n = w.length;
//        value = new int[n][C];
//        return bestValue(w, v, n - 1, C);
//    }
//
//    private int bestValue(int[] w, int[] v, int index, int c) {
//        if(index < 0 || c <= 0){
//            return 0;
//        }
//        if(value[index][c] != 0){
//            return value[index][c];
//        }
//        int res = bestValue(w, v, index - 1, c);
//        if( c >= w[index]){
//            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
//        }
//        value[index][c] = res;
//        return res;
//    }
}
