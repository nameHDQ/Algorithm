package DayOne.simple;

import Utils.ListNode;

public class N141 {
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        if (fast == null || fast.next == null ){
            return false;
        }
        fast = fast.next.next;
        slow = slow.next;
        if (fast ==  null){
            return false;
        }
        while (fast != slow){
            if (fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return false;
            }
            if (fast ==  null){
                return false;
            }
        }
        return true;
    }
}
