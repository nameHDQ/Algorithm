package DayOne;

/**
 * @author hdq
 * @create 2021-09-02 10:28
 */
public class N22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode listNode = head;
        while (listNode !=null){
            len++;
            listNode = listNode.next;
        }
        int i = len - k+1;
        int j = 1;
        listNode = head;
        while (listNode != null){
            if (i == j){
                return listNode;
            }
            listNode = listNode.next;
            j++;

        }
        return null;
    }

    public static void main(String[] args) {
        N22 n22 = new N22();
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        head.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        System.out.println(n22.getKthFromEnd(head, 2).val);
    }
}
