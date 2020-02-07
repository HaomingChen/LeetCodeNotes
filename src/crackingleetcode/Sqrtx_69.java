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

    //利用模板解决开平方
    public int sqrt(int x) {
        int end = x;
        int start = 0;
        //start, mid, end
        //...start,end...
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start * start == x) {
            return start;
        }
        if (end * end == x) {
            return end;
        }
        return start;
    }
//    public int mySqrt(int x) {
//        int up = x;
//        int low = 1;
//        while(low <= up){
//            int mid = low + (up - low) / 2;
//            //[low, mid, up]
//            if(mid == x / mid){
//                return mid;
//            }else if(mid > x / mid){
//                up = mid - 1;
//            }else{
//                low = mid + 1;
//            }
//        }
//        return up;
//    }
}
