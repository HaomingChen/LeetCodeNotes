package crackingleetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * @author 58212
 * @date 2019-12-27 1:30
 */
public class RemoveNthNodeFromEndofList_19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0) {
            return head;
        }
        ListNode front = new ListNode(-1);
        front.next = head;
        ListNode tail = front;
        ListNode ehead = front;

        //...head, 1 ,null(tail)] -> head + n + 1 = tail
        for (int i = 0; i < n + 1; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        while (tail != null) {
            front = front.next;
            tail = tail.next;
        }
        front.next = front.next.next;
        return ehead.next;
    }

}
