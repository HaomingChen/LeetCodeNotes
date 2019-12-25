package crackingleetcode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 *
 * @author Haoming Chen
 * Created on 2019/12/25
 */
public class RemoveDuplicatesfromSortedListII_82 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode prev = new ListNode(-1);
            prev.next = head;
            ListNode frontier = prev.next;
            ListNode ehead = prev;
            int count = 0;
            while (prev.next != null && frontier.next != null) {
                if (prev.next.val == frontier.next.val) {
                    frontier = frontier.next;
                    count++;
                } else {
                    if (count == 0) {
                        prev = prev.next;
                        frontier = frontier.next;
                    } else {
                        prev.next = frontier.next;
                        prev = frontier;
                        frontier = frontier.next;
                        count = 0;
                    }
                }
            }
            return ehead.next;
        }
    }
}
