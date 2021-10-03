package DayOne;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
/**
 * @author hdq
 * @create 2021-08-23 10:44
 */
public class N876 {
    public ListNode middleNode(ListNode head) {
        int length = 1;
        ListNode p = head;
        while (p.next != null){
            p = p.next;
            length++;
        }
        int mid = length/2+1;
        mid--;
        while (mid!=0){
            mid--;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(6);
        head.next =head1;
        head1.next = head2;
        head2.next = head3;
        head3.next =head4;
        head4.next = head5;
        head5.next = null;
        N876 n876 = new N876();
        System.out.println(n876.middleNode(head).val);
    }
}
