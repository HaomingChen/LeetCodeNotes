package crackingleetcode;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * @author 58212
 * @date 2020-02-01 21:46
 */
public class Sqrtx_69 {
    public int mySqrt(int x) {
        int up = x;
        int lower = 1;
        while(lower <= up){
            //[low, mid, up]
            int mid = lower + (up - lower) / 2;
            if(mid == x / mid){
                return mid;
            }else if(mid > x / mid){
                up = mid - 1;
            }else{
                lower = mid + 1;
            }
        }
        return up;
    }
}
