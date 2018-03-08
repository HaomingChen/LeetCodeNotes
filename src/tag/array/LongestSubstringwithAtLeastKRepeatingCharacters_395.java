package tag.array;

public class LongestSubstringwithAtLeastKRepeatingCharacters_395 {
    static public int longestSubstring(String s, int k) {
        if(s == null || k < 0){
            return 0;
        }
        char[] letter = new char[26];
        for(int i = 0;i<s.length();i++){
            letter[s.charAt(i)-'a']++;
        }
        Character spliter = null;
        for(int i = 0;i<letter.length;i++){
            if(letter[i]>0 && letter[i]<k){
                spliter = (char)(i + 'a');
            }
        }
        if(spliter == null){
            return s.length();
        }
        int maxLen = 0;
        String[] subString = s.split("" + spliter);
        for(String n:subString){
            maxLen = Math.max(maxLen,longestSubstring(n,k));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        longestSubstring("aaabb", 3);
    }
}
