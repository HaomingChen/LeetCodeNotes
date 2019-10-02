package tag.linkedlist;

/**
 * @author 58212
 * @date 2019-10-02 23:12
 */
public class RemoveLinkedListElementsUsingDummyHead_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev != null) {
            if (prev.next.val == val) {
                //当dummyHead.next与val匹配时
                //以下代码实际上改变的是dummyhead的next指向的节点，而head节点没有变化,head被dummyhead.next替代
                //head在第一次匹配过后即变为loitering objects
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
