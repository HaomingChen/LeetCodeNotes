package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 58212
 * @date 2019-10-04 0:18
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    public Node root;
    public int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加元素
    public void add(E e) {
        root = add(root, e);
    }

    //向二分搜索树中添加元素
    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //看二分搜索树中是否包含元素e -> 前序遍历法
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) < 0) {
            return contains(node.right, e);
        }
        if (node.e.compareTo(e) > 0) {
            return contains(node.left, e);
        }
        return true;
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的前序遍历(非递归) depth-first approach
    public void preOrderNR(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);
        while (!nodeStack.isEmpty()) {
            Node top = nodeStack.pop();
            System.out.println(top.e);
            if (top.right != null) {
                nodeStack.push(top.right);
            }
            if (top.left != null) {
                nodeStack.push(top.left);
            }
        }
    }

    //二分搜索树的层序遍历 width-first approach
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        System.out.println("-----------------" + root.e + "------------------");
        while (!nodeQueue.isEmpty()) {
            Node ret = nodeQueue.poll();
            System.out.println(ret.e);
            if (ret.left != null) {
                nodeQueue.add(ret.left);
            }
            if (ret.right != null) {
                nodeQueue.add(ret.right);
            }
        }
    }

    //二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        postOrder(root.right);
    }

    //二分搜索树的后序遍历
    //用处: 释放二叉树内存
    public void postOrder() {
        postOrder(root);
    }

    //寻找二分搜索树最小值所在的节点
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return minimum(root).e;
    }

    public Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    //删除以node为根的二分搜索树中的最小节点
    //返回二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left != null) {
            node.left = removeMin(node.left);
            return node;
        } else {
            size--;
            return node.right == null ? null : node.right;
        }
    }

    //寻找二分搜索树最大值所在的节点
    public E maximum() {
        return maximum(root).e;
    }

    public Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //从二分搜索树中删除最大值所在节点, 返回最大值
    public E removeMax() {
        E ret = maximum(root).e;
        root = removeMax(root);
        return ret;
    }

    //删除以node为根的二分搜索树中的最大节点
    //返回二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right != null) {
            node.right = removeMax(node.right);
            return node;
        } else {
            size--;
            return node.left == null ? null : node.left;
        }
    }

    //删除以node为根的二分搜索树中值为e的节点，递归算法
    public void remove(E e) {
        root = remove(root, e);
    }

    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.e.compareTo(e) > 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (node.e.compareTo(e) < 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            //待删除的节点为叶子节点
            if (node.right == null && node.left == null) {
                return null;
            }
            //该待删除节点的右子树为空
            if (node.right == null && node.left != null) {
                size--;
                Node ret = node.left;
                //删除当前元素
                node.left = null;
                node.right = null;
                return ret;
            }
            //该待删除节点的左子树为空
            if (node.left == null && node.right != null) {
                size--;
                Node ret = node.right;
                //删除当前元素
                node.left = null;
                node.right = null;
                return ret;
            }
            //该待删除节点的左右子树均不为空 Hibbard Deletion
            if (node.left != null && node.right != null) {

                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;

            }
        }
        return node;
    }


    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBSTString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(generateDepthString(depth) + "null\n");
            return;
        }
        stringBuilder.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, stringBuilder);
        generateBSTString(node.right, depth + 1, stringBuilder);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-");
        }
        return res.toString();
    }

    public int getSize() {
        return size;
    }

}