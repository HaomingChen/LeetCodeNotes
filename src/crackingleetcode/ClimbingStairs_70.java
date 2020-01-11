package crackingleetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * @author 58212
 * @date 2020-01-12 0:48
 */
public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[n % 3];
    }
//    public int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for(int i = 2; i <= n; i++){
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }

//    int[] ram;
//    public int climbStairs(int n) {
//        ram = new int[n + 1];
//        return climb(n);
//    }
//    private int climb(int n){
//        if(n == 1){
//            return 1;
//        }
//        if(n == 2){
//            return 2;
//        }
//        if(ram[n] == 0){
//            ram[n] = climb(n - 1) + climb(n - 2);
//        }
//        return ram[n];
//    }


}
