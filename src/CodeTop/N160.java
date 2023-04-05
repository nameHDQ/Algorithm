package CodeTop;

import Utils.ListNode;

public class N160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = 1;
        int n = 1;

        ListNode t1 = headA;
        ListNode t2 = headB;

        while (t1.next != null){
            m++;
            t1 = t1.next;
        }
        while (t2.next != null){
            n++;
            t2 = t2.next;
        }

        return null;
    }
}
