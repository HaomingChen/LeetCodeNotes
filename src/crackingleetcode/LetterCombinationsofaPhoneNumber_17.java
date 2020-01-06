package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not
 * map to any letters.
 *
 * @author 58212
 * @date 2020-01-06 22:54
 */
public class LetterCombinationsofaPhoneNumber_17 {

    List<String> res = new ArrayList<>();
    private String[] dial = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //str is a string that represents a path from root to the current node
    //this function will try to find all the path down to the child node
    private void findCombination(String digits, int index, String str) {
        if (digits.length() == index) {
            res.add(str);
            return;
        }
        char pos = digits.toCharArray()[index];
        char[] letters = dial[pos - '0'].toCharArray();
        for (int i = 0; i < letters.length; i++) {
            findCombination(digits, index + 1, str + letters[i]);
        }
        return;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }
}
