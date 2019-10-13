package tag.string;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 58212
 * @date 2019-10-13 23:49
 */
public class UniqueMorseCodeWords_804 {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        String[] morseCodeTable = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set morseCode = new TreeSet();
        for (String word : words) {
            char[] wordArray = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char chr : wordArray) {
                sb.append(morseCodeTable[chr - 'a']);
            }
            morseCode.add(sb.toString());
        }
        return morseCode.size();
    }
}
