package crackingleetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number
 * by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or
 * it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy
 * numbers.
 * @author 58212
 * @date 2019-12-20 1:08
 */
public class HappyNumber_202 {

    class Solution {
        public boolean isHappy(int n) {

            Set<Integer> res = new HashSet<>(1);
            while(true){
                int sum = 0;
                while(n != 0){
                    sum = sum + (n % 10) * (n % 10);
                    n = n / 10;
                }
                if(res.contains(sum)){
                    return false;
                }else if(sum == 1){
                    return true;
                }
                n = sum;
                //put sum to the hash set to detect if it loops endlessly
                res.add(sum);
            }

        }
    }

}
