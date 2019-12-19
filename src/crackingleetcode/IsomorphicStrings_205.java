package crackingleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * @author 58212
 * @date 2019-12-20 2:25
 */
public class IsomorphicStrings_205 {

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s.length() != t.length()){
                return false;
            }
            return matcher(s, t) && matcher(t, s);
        }

        private boolean matcher(String s, String t){
            Map<Integer,Integer> matcher = new HashMap<>(128);
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            for(int i = 0; i < sArr.length; i++){
                if(!matcher.containsKey((int)sArr[i])){
                    matcher.put((int)sArr[i], (int)tArr[i]);
                }else if(matcher.get((int)sArr[i]) != (int)tArr[i]){
                    return false;
                }
            }
            return true;
        }
    }

}
