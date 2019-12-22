package crackingleetcode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x. You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * @author 58212
 * @date 2019-12-22 23:35
 */
public class PartitionList_86 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode smaller = null;
        ListNode shead = null;

        ListNode bigger = null;
        ListNode bhead = null;

        ListNode pointer = head;
        while (pointer != null) {
            if (pointer.val < x) {
                if (smaller == null) {
                    shead = pointer;
                    smaller = pointer;
                    pointer = pointer.next;
                    smaller.next = null;
                } else {
                    smaller.next = pointer;
                    pointer = pointer.next;
                    smaller = smaller.next;
                    smaller.next = null;
                }
            } else {
                if (bigger == null) {
                    bhead = pointer;
                    bigger = pointer;
                    pointer = pointer.next;
                    bigger.next = null;
                } else {
                    bigger.next = pointer;
                    pointer = pointer.next;
                    bigger = bigger.next;
                    bigger.next = null;
                }
            }
        }
        if (smaller != null) {
            smaller.next = bhead;
            return shead;
        }
        return bhead;
    }

}
