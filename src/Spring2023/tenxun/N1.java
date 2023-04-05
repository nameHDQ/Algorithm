package Spring2023.tenxun;

import Utils.ListNode;

public class N1 {
    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
//        ListNode t5 = new ListNode(5);
//        ListNode t6 = new ListNode(6);
//        ListNode t7 = new ListNode(7);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
//        t4.next = t5;
//        t5.next = t6;
//        t6.next = t7;
        ListNode listNode = reorderList(t1);
        while (listNode!= null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode reorderList (ListNode head) {
        // write code here
        int size = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            size++;
        }
        if (size <= 2){
            return head;
        }
        int index = 0;
        ListNode first = head;
        ListNode second = head.next;
        while (index < size){
            if (size - index <= 2){
                break;
            }
            if (size - index >= 4){
                int tempValue = first.val;
                first.val = second.next.val;
                second.next.val = tempValue;
                tempValue = second.val;
                second.val = second.next.next.val;
                second.next.next.val = tempValue;
            }else {
                int tempValue = first.val;
                first.val = second.next.val;
                second.next.val = tempValue;
                tempValue = second.val;
                second.val = second.next.val;
                second.next.val = tempValue;
                break;
            }
            index +=4;
            if (size - index <= 2){
                break;
            }
            first = second.next.next.next;
            second =second.next.next.next.next;
        }
        return head;
    }
}
