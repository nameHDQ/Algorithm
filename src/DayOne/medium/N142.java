package DayOne.medium;

public class N142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){

                ListNode index1 = head;
                ListNode index2 = fast;

                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;

                }
                return index1;
            }
        }
        return null;
    }
}
