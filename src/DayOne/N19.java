package DayOne;



/**
 * @author hdq
 * @create 2021-08-23 11:25
 */
public class N19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            return null;
        }

        int length = 1;
        ListNode p = head;
        while (p.next != null){
            p = p.next;
            length++;
        }
        int k = length-n+1;
        if (k == 1){
            return head.next;
        }
        p =head;
        ListNode next = p.next;
        for (int i = 2; i < k; i++) {
            p = next;
            next = next.next;

        }
        p.next = next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
//        ListNode head2 = new ListNode(3);
//        ListNode head3 = new ListNode(4);
//        ListNode head4 = new ListNode(5);
//        ListNode head5 = new ListNode(6);
        head.next =head1;
        head1.next = null;
//        head2.next = head3;
//        head3.next =head4;
//        head4.next = head5;
//        head5.next = null;
        N19 n19 = new N19();
        ListNode h;
        h =n19.removeNthFromEnd(head,2);
        while (h!=null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}
