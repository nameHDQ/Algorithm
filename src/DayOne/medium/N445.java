package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class N445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null){
            s1.add(head1);
            head1 = head1.next;
        }
        while (head2 != null){
            s2.add(head2);
            head2 = head2.next;
        }
        int l1Size = s1.size();
        int l2Size = s2.size();
        Deque<Integer> deque = new ArrayDeque<>();
        int jinWei  = 0;
        while (!s1.isEmpty() && !s2.isEmpty()){

            int temp = s1.pop().val + s2.pop().val + jinWei;
            if (temp >= 10){
                jinWei = 1;
            }else {
                jinWei = 0;
            }
            deque.push(temp % 10);
        }
        while (!s1.isEmpty()){
            int temp = s1.pop().val + jinWei;
            if (temp >= 10){
                jinWei = 1;
            }else {
                jinWei = 0;
            }
            deque.push(temp % 10);
        }
        while (!s2.isEmpty()){
            int temp = s2.pop().val + jinWei;
            if (temp >= 10){
                jinWei = 1;
            }else {
                jinWei = 0;
            }
            deque.push(temp % 10);
        }
        ListNode head = null;
        ListNode cur = null;
        if (deque.size() > l1Size &&  deque.size() > l2Size){
            head = new ListNode(deque.pop());
            head.next = l1Size >= l2Size ? l1 : l2;
            cur = head.next;
        }else {
            head = l1Size >= l2Size ? l1 : l2;
            cur = head;
        }
        while (cur != null){

            cur.val = deque.pop();
            cur = cur.next;
        }
        return head;
    }
}
