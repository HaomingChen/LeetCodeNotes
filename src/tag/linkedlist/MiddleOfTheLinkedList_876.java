package tag.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 58212
 * @date 2019-10-04 23:56
 */
public class MiddleOfTheLinkedList_876 {
    public ListNode middleNodeA(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }

    //Approach 2: Fast and Slow Pointer
    //Intuition and Algorithm
    //
    //When traversing the list with a pointer slow, make another pointer fast that traverses twice as fast.
    // When fast reaches the end of the list, slow must be in the middle.
    public ListNode middleNodeB(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        while (faster != null) {
            if(faster.next == null){
                return slower;
            }
            faster = faster.next.next;
            slower = slower.next;
        }
        return slower;
    }
}
