package tag.twopointers;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        boolean isPa = true;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                if (Character.isDigit(s.charAt(i))) {
                    return false;
                } else if (s.charAt(i) + 32 != s.charAt(j) && s.charAt(i) - 32 != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            } else {
                i++;
                j--;
            }
        }
        return isPa;
    }
}
