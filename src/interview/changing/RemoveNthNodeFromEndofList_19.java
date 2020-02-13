package interview.changing;

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
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        dummyHead.next = head;
        ListNode ehead = dummyHead;
        int count = n + 1;
        while(dummyHead != null){
            dummyHead = dummyHead.next;
            if(count != 0){
                count--;
            }else{
                prev = prev.next;
            }
        }
        prev.next = prev.next.next;
        return ehead.next;
    }

}
