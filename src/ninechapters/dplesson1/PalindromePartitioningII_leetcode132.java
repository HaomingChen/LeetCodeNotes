package ninechapters.dplesson1;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII_leetcode132 {

    public static void main(String[] args) {
        System.out.println("ababababababababababababcbabababababababababababa".length());
        PalindromePartitioningII_leetcode132 pa = new PalindromePartitioningII_leetcode132();
        System.out.println(pa.minCut("ababababababababababababcbabababababababababababa"));
    }

    List<List<String>> res = new ArrayList<>();

    int min;

    public int minCut(String s) {
        min = Integer.MAX_VALUE;
        findPali(s, 0, new ArrayList<>());
        return min;
    }

    private void findPali(String s, int start, ArrayList<String> lst) {
        if(lst.size() - 1 > min){
            return;
        }
        if (start == s.length()) {
            min = Math.min(min, lst.size() - 1);
            System.out.println(lst.size());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            lst.add(s.substring(start, i + 1));
            findPali(s, i + 1, lst);
            lst.remove(lst.size() - 1);
        }
        return;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
