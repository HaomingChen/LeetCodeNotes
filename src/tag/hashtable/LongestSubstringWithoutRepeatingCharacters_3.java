package tag.hashtable;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    static public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> charIndex = new HashMap<Character,Integer>();
        int leftBound = 0;
        int maxLen = 1;

        for(int i = 0;i<s.length();i++){
            if(charIndex.containsKey(s.charAt(i))){
                leftBound = leftBound > charIndex.get(s.charAt(i))? leftBound:charIndex.get(s.charAt(i)) + 1;
                charIndex.remove(s.charAt(i),charIndex.get(s.charAt(i)));
            }
            maxLen = Math.max(maxLen,i - leftBound+1);
            charIndex.put(s.charAt(i),i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
