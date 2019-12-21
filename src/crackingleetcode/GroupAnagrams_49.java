package crackingleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Haoming Chen
 * Created on 2019/12/21
 */
public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> countMap = new HashMap<>(strs.length);
        for (String item : strs) {
            int[] ascii = new int[26];
            char[] iArr = item.toCharArray();
            for (char i : iArr) {
                ascii[i - 'a']++;
            }
            //rebuild string represents character frequency
            StringBuilder sb = new StringBuilder();
            for (int charFreq : ascii) {
                sb.append('#');
                sb.append(charFreq);
            }
            if (countMap.containsKey(sb.toString())) {
                countMap.get(sb.toString()).add(item);
            } else {
                List<String> list = new ArrayList<>();
                list.add(item);
                countMap.put(sb.toString(), list);
            }
        }
        return new ArrayList(countMap.values());
    }

}
