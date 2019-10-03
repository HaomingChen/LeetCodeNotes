package tag.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] x) {
        if (x == null || x.length == 0) {
            throw new IllegalArgumentException("The input array can not be null");
        }
        this.val = x[0];
        ListNode temp = this;
        for (int i = 1; i < x.length; i++) {
            temp.next = new ListNode(x[i]);
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val);
            stringBuilder.append(",");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

}