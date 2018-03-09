package tag.linkedlist;

public class IntersectionOfTwoLinkedLists_160 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        int sizeA = 0;
        ListNode pB = headB;
        int sizeB = 0;
        while (pA != null) {
            pA = pA.next;
            sizeA++;
        }
        while (pB != null) {
            pB = pB.next;
            sizeB++;
        }

        pA = headA;
        pB = headB;
        int i = sizeA > sizeB ? sizeA - sizeB : 0;
        int j = sizeB > sizeA ? sizeB - sizeA : 0;

        while (pA != null && pB != null) {
            if (i > 0) {
                pA = pA.next;
                i--;
                continue;
            } else if (j > 0) {
                pB = pB.next;
                j--;
                continue;
            } else if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        b.next = a;
        System.out.println(getIntersectionNode(a, b));
    }
}
