package crackingleetcode;

/**
 * 有一座高度是n级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 *
 * @author Haoming Chen
 * Created on 2020/1/7
 */
public class BackTracking_souhu01 {


    public static void main(String[] args) {
        System.out.println(findPath(2));
    }

    static int count = 0;

    public static int findPath(int sum) {
        if (sum == 0) {
            return 0;
        }
        countPath(sum);
        return count;
    }

    private static void countPath(int sum) {
        if (sum == 0) {
            count++;
            return;
        }
        //how many steps you want to take
        for (int i = 1; i <= 2; i++) {
            if (sum < i) {
                break;
            }
            countPath(sum - i);
        }
    }
}
