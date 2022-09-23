package DayOne.medium;

import java.lang.reflect.Member;

public class N24 {
    public ListNode swapPairs(ListNode head) {

        ListNode pre = head;
        ListNode cur = head;
        ListNode next = head.next;
        if (next == null){
            return cur;
        }
        ListNode temp = next.next;
        next.next = cur;
        cur.next = temp;

        // 更新
        head = next;
        pre = cur;
        cur = temp;
        if (cur == null){
            return head;
        }
        next = cur.next;

        while (next != null){
            temp = next.next;
            next.next = cur;
            cur.next = temp;
            pre.next = next;
            pre = cur;
            cur = temp;
            if (cur == null){
                return head;
            }
            next = cur.next;
        }
        return head;
    }
}
