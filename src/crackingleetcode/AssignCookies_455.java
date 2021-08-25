package crackingleetcode;

import java.util.Arrays;

/**
 *
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most
 * one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content
 * with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will
 * be content. Your goal is to maximize the number of your content children and output the maximum number.
 * <p>
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 *
 * @author 58212
 * @date 2020-01-22 21:15
 */
public class AssignCookies_455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            for (int j = index; j >= 0; j--) {
                if (g[i] <= s[j]) {
                    index--;
                    res++;
                    break;
                }
            }
            if (index < 0) {
                break;
            }
        }
        return res;
    }

}
