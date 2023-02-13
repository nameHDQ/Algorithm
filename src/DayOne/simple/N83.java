package DayOne.simple;

import Utils.ListNode;

public class N83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode cur = dumy;
        while (cur.next != null){

            while (cur.next.next != null && cur.next.val == cur.next.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dumy.next;
    }
}
