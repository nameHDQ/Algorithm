package DayOne.medium;

public class JZ24 {
    public ListNode reverseList(ListNode head) {


        ListNode cur = head.next;
        ListNode pre = head;
        head.next = null;
        if (cur == null) return head;

        while (cur != null){


            ListNode temp  =cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
