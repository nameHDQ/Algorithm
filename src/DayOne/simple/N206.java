package DayOne.simple;

import Utils.ListNode;

public class N206 {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null){
            return pre;
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = pre;

        return reverse(cur, temp);
    }
}
