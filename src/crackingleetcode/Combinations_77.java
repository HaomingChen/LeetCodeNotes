package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * @author 58212
 * @date 2020-01-08 1:23
 */
public class Combinations_77 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n < k || n <= 0 || k <= 0){
            return res;
        }
        List<Integer> lst = new ArrayList<>();
        getCombine(n, k, 1, lst);
        return res;
    }

    private void getCombine(int n, int k, int start, List<Integer> lst){
        if(k == lst.size()){
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i = start; i <= n - (k - lst.size()) + 1; i++){
            lst.add(i);
            getCombine(n, k, i + 1, lst);
            lst.remove(lst.size() - 1);
        }
    }

}
