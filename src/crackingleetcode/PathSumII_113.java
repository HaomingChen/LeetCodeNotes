package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * @author Haoming Chen
 * Created on 2020/1/4
 */
public class PathSumII_113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    ArrayList<Integer> leafVal = new ArrayList<>();
                    leafVal.add(root.val);
                    res.add(leafVal);
                    return res;
                }
            }
            List<List<Integer>> resL = pathSum(root.left, sum - root.val);
            addListHelper(root.val, resL);
            List<List<Integer>> resR = pathSum(root.right, sum - root.val);
            addListHelper(root.val, resR);
            res.addAll(resL);
            res.addAll(resR);
            return res;
        }

        private void addListHelper(int val, List<List<Integer>> lst) {
            for (int i = 0; i < lst.size(); i++) {
                lst.get(i).add(0, val);
            }
        }
    }
}
