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
                return new ArrayList<>();
            }
            //has traveled to the leaf node
            if (root.left == null && root.right == null) {
                res.add(Integer.toString(root.val));
                return res;
            }
            //Link current node to the path
            List<String> pathL = binaryTreePaths(root.left);
            for (int i = 0; i < pathL.size(); i++) {
                res.add(root.val + "->" + pathL.get(i));
            }
            List<String> pathR = binaryTreePaths(root.right);
            for (int i = 0; i < pathR.size(); i++) {
                res.add(root.val + "->" + pathR.get(i));
            }
            return res;
        }
    }

}
