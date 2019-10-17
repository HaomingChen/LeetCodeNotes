package tag.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Haoming Chen
 * Created on 2019/10/17
 */
public class BinaryTreePreorderTraversal_144 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderRes = new ArrayList<>();
        if (root == null) {
            return preOrderRes;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preOrderRes.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preOrderRes;
    }

}
