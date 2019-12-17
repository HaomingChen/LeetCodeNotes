package crackingleetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author 58212
 * @date 2019-12-15 1:24
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int size = 0;
        boolean[] lst = new boolean[128];
        //[lt, rt]
        int lt = 0;
        int rt = 0;
        while (rt < arr.length) {
            //已访问过
            if (lst[(int) arr[rt]]) {
                lst[(int) arr[lt]] = false;
                //左窗口右滑
                lt++;
            } else {
                //第一位必定访问该判断闭包的逻辑
                //更新最大尺寸
                size = rt - lt + 1 > size ? rt - lt + 1 : size;
                //设定已访问
                lst[(int) arr[rt]] = true;
                //右窗右滑
                rt++;
            }
        }
        return size;
    }

}
