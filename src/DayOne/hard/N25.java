package DayOne.hard;

import Utils.ListNode;
import org.w3c.dom.ls.LSInput;

public class N25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode pre = new ListNode(0);
        ListNode hair = pre;
        pre.next = head;
        while (pre != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null){
                    return hair.next;
                }
            }
            ListNode tailNext = tail.next;
            ListNode[] nodes = reverse(pre.next, tail);
            ListNode h = nodes[0];
            ListNode t = nodes[1];
            pre.next = h;
            t.next = tailNext;
            pre = t;
        }
        return hair.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail){

        ListNode prex = tail.next;
        ListNode p = head;

        while (p != tail){
            ListNode next = p.next;
            p.next = prex;
            prex = p;
            p = next;
        }

        p.next = prex;
        return new ListNode[]{p,head};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        ListNode head4 = new ListNode(5);
        head3.next = head4;
        new N25().reverseKGroup(head, 2);
    }

}
