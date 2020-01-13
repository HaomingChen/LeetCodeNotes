package crackingleetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * @author Haoming Chen
 * Created on 2020/1/13
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            //skip first string compare
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
//    //dp solution
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        //dp[n] = dp[n - 1];
//        String[] dp = new String[strs.length];
//        dp[0] = strs[0];
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = getPrefix(dp[i - 1], strs[i]);
//        }
//        return dp[dp.length - 1];
//    }
//
//    private String getPrefix(String pre, String now) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < (pre.length() < now.length() ? pre.length() : now.length()); i++) {
//            if (pre.charAt(i) == now.charAt(i)) {
//                sb.append(pre.charAt(i));
//            } else {
//                return sb.toString();
//            }
//        }
//        return sb.toString();
//    }
}
