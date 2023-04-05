package JZoffer.I;

import Utils.ListNode;

public class N24 {
    public ListNode reverseList(ListNode head) {
        if (head.next == null || head == null){
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
