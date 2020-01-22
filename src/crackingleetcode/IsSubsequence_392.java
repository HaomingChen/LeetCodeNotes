package crackingleetcode;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~
 * = 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence
 * of "abcde" while "aec" is not).
 *
 * @author 58212
 * @date 2020-01-22 23:06
 */
public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        if(t.length() == 0){
            return false;
        }
        int index = s.length() - 1;
        for(int i = t.length() - 1; i >= 0; i--){
            if(s.charAt(index) == t.charAt(i)){
                index--;
            }
            if(index < 0){
                return true;
            }
        }
        return false;
    }

}
