package ninechapters.dplesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */
public class PalindromePartitioning_leetcode131 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        substr(s, 0, new ArrayList<>());
        return res;
    }

    private ArrayList<String> substr(String s, int start, ArrayList<String> lst) {
        if (s.length() == start) {
            res.add(new ArrayList<>(lst));
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String current = s.substring(start, i);
            if (!isPalindrome(current, 0, current.length() - 1)) {
                continue;
            }
            lst.add(current);
            substr(s, i, lst);
            lst.remove(lst.size() - 1);
        }
        return lst;
    }

    public boolean isPalindrome(String str, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
