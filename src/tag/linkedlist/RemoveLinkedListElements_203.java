package tag.linkedlist;

/**
 * @author 58212
 * @date 2019-10-02 23:12
 */
public class RemoveLinkedListElements_203 {
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,6,7,8,6};
        ListNode listNode = new ListNode(intArray);
        removeElements(listNode, 6);
        System.out.println(listNode);
    }
}
