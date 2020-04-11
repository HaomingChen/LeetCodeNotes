package crackingleetcode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in
 * the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Note: Do not modify the linked list.
 *
 * @author Haoming Chen
 * Created on 2020/4/3
 */
public class LinkedListCycleII_142 {

    public ListNode detectCycle(ListNode head) {

        boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
