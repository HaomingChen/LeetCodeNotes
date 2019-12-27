package crackingleetcode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 * @author 58212
 * @date 2019-12-26 0:28
 */
public class DeleteNodeinaLinkedList_237 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        ListNode temp = node.next;
        node.next = node.next.next;
        temp.next = null;
    }

}
