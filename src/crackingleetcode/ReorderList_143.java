package crackingleetcode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * @author Haoming Chen
 * Created on 2019/12/27
 */
public class ReorderList_143 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode rhead = head;
        for(int i = 0; i < 4; i++){
            head.next = new ListNode(i + 2);
            head = head.next;
        }
//        while(rhead != null){
//            System.out.println(rhead.val);
//            rhead = rhead.next;
//        }
        reorderList(rhead);
        while (rhead != null) {
            rhead = rhead.next;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //get the pivot
        //[pivotPrev, frontier]
        ListNode pivotPrev = head;
        ListNode frontier = head;
        while (frontier.next != null && frontier.next.next != null) {
            pivotPrev = pivotPrev.next;
            frontier = frontier.next.next;
        }
        System.out.println("Print Pre Pivot Expected: 2, Real: " + pivotPrev.val);
        //reverse the linkedlist since pivot
        ListNode prev = null;
        ListNode current = pivotPrev.next;
        System.out.println("pivot Prev: " + pivotPrev.val);
        System.out.println("current: " + current.val);
        //1 2 3 4 5
        //1 2 3 5 4
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        pivotPrev.next = prev;
        printCurrentList(head);
        System.out.println("Pivot: " + pivotPrev.val);

        ListNode rstart = pivotPrev.next;
        ListNode lstart = head;
        //make the first node point to the pivot node
        //1 -> 2 - > 3 -> 6 -> 5 -> 4
        //1 -> 6 -> 2 -> 3 -> 5 -> 4
        //1 to 6 -> 3 to 5
        while (lstart != pivotPrev) {
            pivotPrev.next = rstart.next;
            rstart.next = lstart.next;
            lstart.next = rstart;
            lstart = rstart.next;
            rstart = pivotPrev.next;
        }
        System.out.print("result is ");
        printCurrentList(head);
    }

    private static void printCurrentList(ListNode head){
        System.out.print("start: ");
        ListNode rhead = head;
        while(rhead != null){
            System.out.print(" " + rhead.val + " ");
            rhead = rhead.next;
        }
        System.out.println(" end");
    }
}
