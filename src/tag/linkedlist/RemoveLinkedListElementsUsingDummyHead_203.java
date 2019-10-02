package tag.linkedlist;

/**
 * @author 58212
 * @date 2019-10-02 23:12
 */
public class RemoveLinkedListElementsUsingDummyHead_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
