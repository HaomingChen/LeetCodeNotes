package crackingleetcode;

/**
 * Reverse a singly linked list.
 *
 * @author 58212
 * @date 2019-12-22 19:44
 */
public class ReverseLinkedList_206 {

    public static void main(String[] args) {
        String[] srt = "123#456".split("#");
        System.out.println(srt[0]);
        System.out.println(srt[1]);

    }

    //iteratively
    public ListNode reverseList(ListNode head){

        ListNode node = null;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = node;
            node = temp;
        }
        return node;

    }

    //1->2->3->4->5->NULL
    //A linked list can be reversed either iteratively or recursively. Could you implement both?]
    //recursively
//    public ListNode reverseList(ListNode head) {
//        return reverseList(null, head);
//    }
//    private ListNode reverseList(ListNode prev, ListNode curr) {
//        if (curr == null) {
//            return prev;
//        }
//        ListNode next = curr.next;
//        curr.next = prev;
//        prev = curr;
//        curr = next;
//        return reverseList(prev, curr);
//    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
