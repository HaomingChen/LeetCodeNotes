package crackingleetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * @author Haoming Chen
 * Created on 2019/12/14
 */
public class ValidPalindrome_125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String b = "0A";
        ValidPalindrome_125 validPalindrome_125 = new ValidPalindrome_125();
        System.out.println(validPalindrome_125.isPalindrome(b));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] cs = s.toCharArray();
        int p1 = 0;
        int p2 = cs.length - 1;
        while (p1 < p2) {

            if (!judgeIfCharValid(cs[p1])) {
                p1++;
                continue;
            } else if (!judgeIfCharValid(cs[p2])) {
                p2--;
                continue;
            } else if (cs[p1] != cs[p2]) {
                return false;
            }
            p1++;
            p2--;

        }
        return true;
    }

    private boolean judgeIfCharValid(char p) {
        if (p <= 122 && p >= 97) {
            return true;
        }
        if (p <= 57 && p >= 48) {
            return true;
        }
        return false;
    }
}
