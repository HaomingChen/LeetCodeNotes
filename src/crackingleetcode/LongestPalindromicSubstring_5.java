package crackingleetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * @author 58212
 * @date 2020-01-21 0:47
 */
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = s.substring(0, 1);
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            for(int j = i + 1; j < s.length(); j++){
                //note：when the size of substring is 2 it wont have a dp[i + 1][j - 1]
                //but when its char[i] equals to char[j] its exactly a palindromic substring
                if((j - i < 3|| dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)){
                    res = res.length() > j - i + 1? res : s.substring(i, j + 1);
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }
}
