package crackingleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 58212
 * @date 2019-12-21 0:16
 */
public class WordPattern_290 {

    class Solution {
        public boolean wordPattern(String pattern, String str) {

            Map<Character, String> map = new HashMap<>();
            String[] strArr = str.split(" ");
            char[] patternArr = pattern.toCharArray();
            if (strArr.length != patternArr.length) {
                return false;
            }
            for (int i = 0; i < strArr.length; i++) {
                if (!map.containsKey(patternArr[i])) {
                    if (map.containsValue(strArr[i])) {
                        return false;
                    }
                    map.put(patternArr[i], strArr[i]);
                } else {
                    if (!map.get(patternArr[i]).equals(strArr[i])) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
