package crackingleetcode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * @author 58212
 * @date 2019-12-24 1:01
 */
public class RemoveLinkedListElements_203 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode ehead = prev;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode temp = prev.next;
                prev.next = prev.next.next;
                temp.next = null;
            } else {
                prev = prev.next;
            }
        }
        return ehead.next;
    }
}
