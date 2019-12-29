package crackingleetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * @author Haoming Chen
 * Created on 2019/12/28
 */
public class BinaryTreePreorderTraversal_144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode top = stk.pop();
            if (top.right != null) {
                stk.push(top.right);
            }
            if (top.left != null) {
                stk.push(top.left);
            }
            res.add(top.val);
        }
        return res;
    }
}
