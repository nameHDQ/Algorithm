package DayOne.medium;

public class N1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list2;
        ListNode end = list2;

        ListNode pre = list2;
        ListNode temp  = list1;
        int index = 0;
        while (temp != null){
            if (index == a){
                start = pre;
            }
            if (index == b){
                end = temp.next;
                break;
            }
            pre = temp;
            temp = temp.next;
            index++;
        }
        temp = list2;
        ListNode end2 = list2;
        while (temp != null){
            end2 = temp;
            temp = temp.next;
        }
        if (start == list2){
            end2.next = end;
        }else {
            start.next = list2;
            end2.next = end;
        }
        return list1;
    }
}
