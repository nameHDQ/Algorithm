package DayOne.simple;

import Utils.ListNode;

public class MS0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null){
            return null;
        }
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb){

            ha = ha == null ? headB:ha.next;
            hb = hb == null ? headA:hb.next;
        }


        return ha;
    }
}
