package tag.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    static public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(f[j] && dict.contains(s.substring(j,i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        ArrayList<String> kkk = new ArrayList<>();
        kkk.add("leet");
        kkk.add("code");
        System.out.println(wordBreak("leetcode",kkk));
    }
}


//***********************Use Recursion but still has Bug*********
//    static boolean wordBreak(String s, List<String> wordDict) {
//        if(s != null && wordDict.isEmpty()){
//            return false;
//        }
//
//        String[] seg = s.split(wordDict.get(0));Us
//        wordDict.remove(0);
//
//        if(seg.length == 0){
//            return true;
//        }
//        boolean n = false;
//        for(String k :seg){
//            if(!k.equals("")) {
//                n = (true && wordBreak(k, wordDict));
//            }
//        }
//        return n;
//    }
