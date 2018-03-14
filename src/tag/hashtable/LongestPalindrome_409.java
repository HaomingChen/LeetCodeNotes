package tag.hashtable;

import java.util.HashMap;

public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        int size = 0;
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (letters.containsKey(s.charAt(i))) {
                size = size + 1;
                letters.remove(s.charAt(i));
            } else {
                letters.put(s.charAt(i), 1);
            }
        }
        if (size < s.length()) {
            size = size + 1;
        }
        return size;
    }
}
