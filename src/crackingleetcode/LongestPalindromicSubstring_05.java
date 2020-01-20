package crackingleetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * @author Haoming Chen
 * Created on 2020/1/20
 */
public class LongestPalindromicSubstring_05 {

    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        for(int i = s.length(); i >= 0; i --){
            //一个字母必为回文
            dp[i][i] = true;
            //该字母向右推
            for(int j = i + 1; j < s.length(); j++){
                if(dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    if(res.length() < j - i + 1){
                        res = s.substring(i, j + 1);
                    }
                    dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return res;
    }

}
