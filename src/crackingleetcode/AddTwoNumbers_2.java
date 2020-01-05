package crackingleetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @author 58212
 * @date 2019-12-23 2:16
 */
public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        String s = "10";
        System.out.println((char)(Integer.valueOf(s) + 96));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (l1 != null || l2 != null) {
            int num;
            if (l1 != null && l2 != null) {
                num = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                num = l1.val + carry;
                l1 = l1.next;
            } else {
                num = l2.val + carry;
                l2 = l2.next;
            }
            pointer.next = new ListNode(num % 10);
            pointer = pointer.next;
            carry = num / 10;
        }
        if (carry != 0) {
            pointer.next = new ListNode(carry);
        }
        return head.next;
    }

}
