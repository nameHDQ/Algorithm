package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-06 11:14
 */
public class N82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //呀节点  即新的头指针
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while (cur.next !=null && cur.next.next!=null){
            if (cur.next.val ==cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head31 = new ListNode(3);
        ListNode head32 = new ListNode(3);
        ListNode head41 = new ListNode(4);
        ListNode head42 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next=head31;
        head31.next=head32;
        head32.next=head41;
        head41.next=head42;
        head42.next=head5;
        N82 n82 = new N82();
        ListNode listNode = n82.deleteDuplicates(head);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
