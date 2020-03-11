package ninechapters.dplession2;

public class EditDistance_72 {

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {

//          i -> word1  j -> word2
//                        insert             delete            replace
//dp[i][j] = Math.min(dp[i][j - 1] + 1,dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
//dp[i][j] = Math.min(dp[i][j - 1] + 1,dp[i - 1][j] + 1, dp[i - 1][j - 1]);
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length + 1][w2.length + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= w2.length; i++){
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for(int i = 1; i <= w1.length; i++){
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for(int i = 1; i <= w1.length; i++){
            for(int j = 1; j <= w2.length; j++){
                if(w1[i - 1] == w2[j - 1]){
                    dp[i][j] = Math
                            .min(Math.min(dp[i - 1][j - 1], dp[i - 1][j] + 1), dp[i][j - 1] + 1);
                }else{
                    dp[i][j] = Math
                            .min(Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
                }
            }
        }
        return dp[w1.length][w2.length];
    }

}
