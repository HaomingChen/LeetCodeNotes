package tag.array;

public class PlusOne_66 {
    static public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = 0;

        for (int i = digits.length - 1; i > -1; i--) {
            carry = (digits[i] + carry) / 10;
            digits[i] = (digits[i] + carry) % 10;
        }
        if (carry == 1) {
            int[] s = new int[digits.length + 1];
            s[0] = 1;
            return s;
        } else {
            return digits;
        }
    }
}
