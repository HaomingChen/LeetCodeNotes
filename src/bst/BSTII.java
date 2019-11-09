package bst;

/**
 * @author 58212
 * @date 2019-11-09 22:38
 */
public class BSTII<E extends Comparable<E>> {

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

    public BSTII() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //新增节点
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            //新增节点
            size++;
            return new Node(e);
        }
        //当前node的值小于e, e去右子树
        if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        //当前node的值大于e, e去左子树
        else if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        }
        //相等时
        return node;
    }

    //看二分搜索树中是否包含某元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) < 0) {
            return contains(node.right, e);
        } else if (node.e.compareTo(e) > 0) {
            return contains(node.left, e);
        }
        return true;
    }

    //删除以node为根的二分搜索树中值为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        //去右子树
        if (node.e.compareTo(e) < 0) {
            node.right = remove(node.right, e);
        }
        //去左子树
        else if (node.e.compareTo(e) > 0) {
            node.left = remove(node.left, e);
        }
        //相等, 找到待删除元素
        else {
            size--;
            //左子树为空, 删除当前节点,右子树的根节点作为当前节点
            if (node.left == null && node.right != null) {
                Node newNode = node.right;
                node.left = node.right = null;
                return newNode;
            }
            //右子树为空， 删除当前节点，左子树的根节点作为当前节点
            else if (node.right == null && node.left != null) {
                Node newNode = node.left;
                node.left = node.right = null;
                return newNode;
            }
            //叶子节点
            else if (node.left == null && node.left == null) {
                return null;
            }
            //Hibbard Deletion
            else {
                //寻找该节点左子树的最大元素
                Node max = maximum(node.left);
                max.left = removeMax(node.left);
                max.right = node.right;
                node.left = node.right = null;
                return max;
            }
        }
        return node;
    }

    //以root为根节点找到该bst的最大节点
    //非递归写法
    private Node maximum(Node root) {
        Node pointer = root;
        while (pointer.right != null) {
            pointer = pointer.right;
        }
        return pointer;
    }

    //删除以node为根的二分搜索树中的最大节点
    //返回二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right != null) {
            node.right = removeMax(node.right);
            return node;
        }
        //该元素为二分搜索树中的最大节点
        else {
            Node newNode = node.left;
            node.left = null;
            size--;
            return newNode;
        }
    }
    //二分搜索树的前序遍历
    //二分搜索树的中序遍历
    //二分搜索树的后序遍历

}
