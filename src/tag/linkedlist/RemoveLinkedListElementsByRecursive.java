package tag.linkedlist;

/**
 * @author 58212
 * @date 2019-10-03 22:31
 */
public class RemoveLinkedListElementsByRecursive {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 6, 7, 8, 6};
        ListNode listNode = new ListNode(intArray);
        removeElements(listNode, 6);
        System.out.println(listNode);
    }

}
