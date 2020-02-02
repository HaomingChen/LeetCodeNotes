package lintcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 58212
 * @date 2020-02-02 18:32
 */
public class SingleNumber_82 {

    public static void main(String[] args) {
        int A = 4;
        A = A >> 1;
        int B = 16;
        System.out.println(A + B >> 1);
        System.out.println(A);
    }
    public boolean isLegalIdentifier(String str) {
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return str.length() == m.replaceAll("").trim().length();
    }
    public int singleNumber(int[] A) {
        int res = 0;
        for(int i = 0; i < A.length; i++){
            res ^= A[i];
        }
        return res;
    }
}
