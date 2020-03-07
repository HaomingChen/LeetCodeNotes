package ninechapters.dplesson1;

public class PalindromePartitioningII_leetcode132 {

    public static void main(String[] args) {
        System.out.println("ababababababababababababcbabababababababababababa".length());
        PalindromePartitioningII_leetcode132 pa = new PalindromePartitioningII_leetcode132();
        System.out.println(pa.minCut("ababababababababababababcbabababababababababababa"));
    }

    public int minCut(String s) {

        char[] c = s.toCharArray();
        int n = c.length;
        //dp
        int[] cut = new int[n];
        //judge if palindrome
        boolean[][] pal = new boolean[n][n];
        //[0, i] <- find min cut
        for (int i = 0; i < n; i++) {
            //in a length of i's array, the maximum cuts are equal to number of items in this array
            int min = i;
            //[0, j, i]
            for (int j = 0; j <= i; j++) {
                //[char[j] ... char[i]]
                if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];

    }

    //    List<List<String>> res = new ArrayList<>();
//
//    int min;
//
//    public int minCut(String s) {
//        min = Integer.MAX_VALUE;
//        findPali(s, 0, new ArrayList<>());
//        return min;
//    }
//
//    private void findPali(String s, int start, ArrayList<String> lst) {
//        if(lst.size() - 1 > min){
//            return;
//        }
//        if (start == s.length()) {
//            min = Math.min(min, lst.size() - 1);
//            System.out.println(lst.size());
//            return;
//        }
//        for (int i = start; i < s.length(); i++) {
//            if (!isPalindrome(s, start, i)) {
//                continue;
//            }
//            lst.add(s.substring(start, i + 1));
//            findPali(s, i + 1, lst);
//            lst.remove(lst.size() - 1);
//        }
//        return;
//    }
//
//    private boolean isPalindrome(String s, int start, int end) {
//        if (start == end) {
//            return true;
//        }
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

}

