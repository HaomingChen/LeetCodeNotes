package crackingleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * @author 58212
 * @date 2019-12-20 1:06
 */
public class ValidAnagram_242 {

    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s == null || t == null){
                return false;
            }
            if(s.length() != t.length()){
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>(128);
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            for(char i : sArr){
                if(map.containsKey((int)i)){
                    map.put((int)i, map.get((int)i) + 1);
                }else{
                    map.put((int)i, 1);
                }
            }

            for(char i : tArr){
                if(map.containsKey((int)i)){
                    if(map.get((int)i) == 0){
                        return false;
                    }else{
                        map.put((int)i, map.get((int)i) - 1);
                    }
                }else{
                    return false;
                }
            }
            return true;
        }
    }

}
