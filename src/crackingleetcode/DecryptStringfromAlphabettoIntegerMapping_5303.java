package crackingleetcode;

/**
 * Given a string s formed by digits ('0' - '9') and '#' . We want to maps to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 * It's guaranteed that a unique mapping will always exist.
 * @author 58212
 * @date 2020-01-05 11:26
 */
public class DecryptStringfromAlphabettoIntegerMapping_5303 {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('1'));
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        System.out.println(DecryptStringfromAlphabettoIntegerMapping_5303.freqAlphabets(s));
    }

    public static String freqAlphabets(String s) {
        if (s == null || s == "") {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int head = 0;
        int tail = 0;
        char[] arr = s.toCharArray();
        while (head < arr.length) {
            if (tail < arr.length && arr[tail] != '#') {
                tail++;
            } else if (head < tail - 2 || tail == arr.length) {
                sb.append((char) (Integer.valueOf(arr[head]) + 48));
                head++;
            } else {
                StringBuilder ks = new StringBuilder();
                while (head != tail) {
                    ks.append(arr[head]);
                    head++;
                }
                sb.append((char) (Integer.valueOf(ks.toString()) + 96));
                head++;
                tail++;
            }
        }
        return sb.toString();
    }
}
