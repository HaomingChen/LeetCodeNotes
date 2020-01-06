package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * @author 58212
 * @date 2020-01-07 0:07
 */
public class RestoreIPAddresses_93 {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        helper(s, "", 0);
        return res;
    }

    public void helper(String s, String tmp, int n) {
        if (n == 4) {
            //only of the length of s is zero which means the s is in the IP address totally.
            if(s.length() == 0){
                res.add(tmp.substring(0, tmp.length() - 1));
            }
            //depth cant be more than 4
            return;
        }
        //the length of a segment of ip address
        for (int i = 1; i <=3; i++) {
            //the size of remaining of the string too small
            if (s.length() < i) {
                return;
            }
            int val = Integer.parseInt(s.substring(0, i));
            //too big or start by 0
            if (val > 255 || i != String.valueOf(val).length()) {
                return;
            }
            //turn to the next recursive
            helper(s.substring(i), tmp + s.substring(0, i) + ".", n + 1);
        }
    }
}
