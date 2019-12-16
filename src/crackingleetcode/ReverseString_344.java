package crackingleetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * @author Haoming Chen
 * Created on 2019/12/14
 */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int head = 0;
        int tail = s.length - 1;
        while (head < tail) {
            swap(s, head, tail);
            head++;
            tail--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
