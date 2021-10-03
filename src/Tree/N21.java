package Tree;

/**
 * @author hdq
 * @create 2021-08-28 13:56
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class N21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val>=l2.val){
            head = l2;
            l2=l2.next;
        }else {
            head=l1;
            l1 = l1.next;
        }
        ListNode pre = head;
        while (l1!=null&&l2!=null){
            if (l1.val>=l2.val){
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }else {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            }
        }
        if (l1 == null){
            pre.next = l2;
        }
        if (l2 == null){
            pre.next = l1;
        }
        return head;
    }

    public static void main(String[] args) {
        N21 n21 = new N21();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        ListNode listNode11 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode44 = new ListNode(4);
        listNode11.next = listNode23;
        listNode23.next = listNode44;
        ListNode listNode = n21.mergeTwoLists(listNode1, listNode11);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
