package crackingleetcode;

/**
 * 翻转一个long类型数字。例如输入123456L，输出654321L。
 *
 * @author 58212
 * @date 2020-01-12 20:14
 */
public class ReverseLong_Ali01 {

    public static void main(String[] args) {
        System.out.println(reverse(123456L));
    }
    public static long reverse(long i){
        long res = 0;
        while(i != 0) {
            long degree = i % 10;
            res = res * 10 + degree;
            i = i / 10;
        }
        return res;
    }
}