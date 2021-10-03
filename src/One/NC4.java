package One;

/**
 * @author hdq
 * @create 2021-08-02 11:57
 */

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class NC4 {
    public static boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next = p1;
//        p2.next= p3;
//        p3.next = p2;
        System.out.println(hasCycle(p1));
    }
}
