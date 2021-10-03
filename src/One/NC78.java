package One;

/**
 * @author hdq
 * @create 2021-08-02 10:55
 */

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
public class NC78 {
        public static ListNode ReverseList(ListNode head) {
            if (head == null || head.next ==null){
                return head;
            }
            ListNode tmp = null;
            ListNode p = head;
            ListNode q = p.next;
            p.next = null;
            while (q !=null){
                tmp = q.next;
                head = q;
                q.next = p;
                p = q;
                q = tmp;
            }
            return head;
        }

        public static void main(String[] args) {
            ListNode p1 = new ListNode(1);
            ListNode p2 = new ListNode(2);
            ListNode p3 = new ListNode(3);
            p1.next = p2;
            p2.next= p3;
            p1 = ReverseList(p1);
            System.out.println(p1.next.next.val);
        }
}
