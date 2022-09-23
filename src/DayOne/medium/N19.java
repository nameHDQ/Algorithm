package DayOne.medium;

public class N19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode header = new ListNode(0);
        header.next = head;
        ListNode fast = header;
        ListNode slow = header;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast!= null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return header.next;
    }
}
