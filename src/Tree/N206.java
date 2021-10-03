package Tree;

/**
 * @author hdq
 * @create 2021-08-28 14:24
 */
public class N206 {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }

        ListNode p = head.next;
        head.next =null;
        ListNode r = null;
        while (p!=null){
            r = p.next;
            p.next = head;
            head = p;
            p = r;
        }
        return head;
    }

    public static void main(String[] args) {
        N206 n206 = new N206();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
//        listNode2.next = listNode4;
        ListNode listNode = n206.reverseList(listNode1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
