package ninechapters.binarytreedivideconquer;

import java.util.*;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
 * and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * @author Haoming Chen
 * Created on 2020/2/19
 */
public class LowestCommonAncestorofaBinaryTree_88 {
    //Iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack();
        //child, parent
        Map<TreeNode, TreeNode> parent = new HashMap<>(16);
        parent.put(root, null);
        stack.push(root);
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.push(node.right);
                parent.put(node.right, node);
            }
            if(node.left != null){
                stack.push(node.left);
                parent.put(node.left, node);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        //store all p's parent to the set
        while(p != null){
            ancestor.add(p);
            p = parent.get(p);
        }
        //keep finding parent
        while(!ancestor.contains(q)){
            q = parent.get(q);
        }
        return q;
    }

//    private TreeNode res;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
//        res = new TreeNode(-1);
//        traverse(root, A, B);
//        return res;
//    }
//
//    private int traverse(TreeNode root, TreeNode A, TreeNode B){
//        if(root == null){
//            return 0;
//        }
//        int left = traverse(root.left, A, B);
//        int right = traverse(root.right, A, B);
//        int val = 0;
//        if(root == A){
//            val++;
//        }
//        if(root == B){
//            val++;
//        }
//        if(left + right + val >= 2){
//            res = root;
//        }
//        return Math.min(left + right + val, 1);
//    }

}
