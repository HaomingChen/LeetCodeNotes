package tag.hashtable;

/**
 * @author Haoming Chen
 * Created on 2019/10/11
 */
public class HappyNumber_202 {

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (n == 0) {
            return false;
        }
        int sum = 0;
        while (n != 0) {
            int count = n % 10;
            sum = sum + count * count;
            n = n / 10;
        }
        return isHappy(sum);
    }

    public static void main(String[] args) {
        System.out.println(isHappy(82));
    }

}
