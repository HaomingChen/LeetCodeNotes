package tag.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Haoming Chen
 * Created on 2019/10/18
 */
public class BinaryTreeInorderTraversal_94 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        //当前节点=根节点
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            //向该节点的左子树遍历, 将左子树均压入栈中, 作前序遍历
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}
