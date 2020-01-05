package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 *
 * @author Haoming Chen
 * Created on 2020/1/4
 */
public class BinaryTreePaths_257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            if (root.left == null && root.right == null) {
                res.add(root.val + "");
                return res;
            }
            String s = Integer.toString(root.val);
            List<String> left = binaryTreePaths(root.left);
            List<String> right = binaryTreePaths(root.right);
            res.addAll(left);
            res.addAll(right);
            for (int i = 0; i < res.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append("->");
                sb.append(res.get(i));
                res.set(i, sb.toString());
            }
            return res;
        }
    }

}
