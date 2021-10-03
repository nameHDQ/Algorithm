package DayOne.medium;



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }



/**
 * @author hdq
 * @create 2021-09-22 9:11
 */
public class N725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        int lenSon = 0;
        boolean isZ = false;
        int ounlen = 0;
        ListNode temp = head;
        while (temp !=null){
            temp = temp.next;
            len++;
        }
        if (len / k <1){
            lenSon = 1;
        }else if (len /k >= 1 && len %k !=0){
            ounlen = len%k;
            lenSon =len/k;
            isZ=true;
        }else {
            lenSon =len/k;
        }
        ListNode[] listNodes = new ListNode[k];
        ListNode nextN = head;
        for (int i = 0; i < k; i++) {
            if (nextN == null){
                break;
            }
            int lentmp = lenSon;
            if (ounlen-- >0 &&isZ){
                lentmp++;
            }

            for (int j = 0; j < lentmp-1; j++) {
                nextN = nextN.next;

            }
            temp = nextN.next;
            listNodes[i] = head;
            nextN.next = null;
            nextN = temp;
            head = temp;

        }


        return listNodes;
    }

    public static void main(String[] args) {
        N725 n725 = new N725();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        n725.splitListToParts(listNode,5);
    }
}
