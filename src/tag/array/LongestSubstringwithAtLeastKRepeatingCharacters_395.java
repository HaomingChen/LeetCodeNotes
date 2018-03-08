package tag.array;

public class LongestSubstringwithAtLeastKRepeatingCharacters_395 {
    static public int longestSubstring(String s, int k) {
        if (s == null || k < 0) return 0;
        char[] letter = new char[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a']++;
        }

        Character delimiter = null;
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] > 0 && letter[i] < k) {
                delimiter = (char) (i + 'a');
            }
        }
        if (delimiter == null) {
            return s.length();
        }

        int maxlen = 0;
        String[] splits = s.split("" + delimiter);
        for (String str : splits) {
            maxlen = Math.max(maxlen, longestSubstring(str, k));
        }
        return maxlen;
    }

    public static void main(String[] args) {
        longestSubstring("aaabb", 3);
    }
}
