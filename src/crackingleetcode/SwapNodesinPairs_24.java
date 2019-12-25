package crackingleetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * @author 58212
 * @date 2019-12-26 0:55
 */
public class SwapNodesinPairs_24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(-1);
        //dont forget to point the first node to the head node
        prev.next = head;
        ListNode rhead = prev;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;
            ListNode tail = second.next;
            //make the second node point to the first node
            second.next = first;
            //make the first node point to the last node
            first.next = tail;
            //make the previous node point to the second node
            prev.next = second;
            //move previous node to the first node
            prev = first;
        }
        return rhead.next;
    }

}
