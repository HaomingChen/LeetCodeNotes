package crackingleetcode;

/**
 * 输入一个double，要求返回与它最接近的.49或.99的数字。例如12.77返回12.99，11.02返回10.99，12.61返回12.49。
 *
 * @author 58212
 * @date 2020-01-12 20:14
 */
public class DoubleCloset_Ali02 {

    public static void main(String[] args) {
        System.out.println(Closest(12.77));
    }

    public static double Closest(double num) {
        double left = num;
        double rt = num;
        while (!judgeIfValid(left)) {
            if (judgeIfValid(rt)) {
                return (double) Math.round(rt * 100) / 100;
            }
            left = left + 0.01;
            rt = rt - 0.01;
        }
        return (double) Math.round(left * 100) / 100;
    }

    private static boolean judgeIfValid(double num) {
        int s = (int) num;
        num = num - s;
        if ((double) Math.round(num * 100) / 100 == 0.49 || (double) Math.round(num * 100) / 100 == 0.99) {
            return true;
        }
        return false;
    }
}
