package crackingleetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
 * nodes of the first two lists.
 *
 * @author 58212
 * @date 2019-12-25 23:39
 */
public class MergeTwoSortedList2_21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ehead = new ListNode(-1);
        ListNode realHead = ehead;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    ehead.next = l2;
                    l2 = l2.next;
                } else {
                    ehead.next = l1;
                    l1 = l1.next;
                }
            } else if (l1 != null) {
                ehead.next = l1;
                l1 = l1.next;
            } else {
                ehead.next = l2;
                l2 = l2.next;
            }
            ehead = ehead.next;
        }
        return realHead.next;
    }
}
