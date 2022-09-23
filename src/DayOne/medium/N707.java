package DayOne.medium;

import Utils.ListNode;

public class N707 {
    class MyLinkedList {

        private int size;
        private ListNode head;

        public MyLinkedList() {
            this.size = 0;
            head = new ListNode(0);

        }

        public int get(int index) {
            if (index < 0 || index >= this.size){
                return -1;
            }
            ListNode temp = head;
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            return temp.val;

        }

        public void addAtHead(int val) {
            ListNode temp = new ListNode(val);
            temp.next = head.next;
            head.next = temp;
            this.size++;
        }

        public void addAtTail(int val) {
            ListNode temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListNode(val);
            this.size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > this.size){
                return;
            }else if (index == this.size){
                addAtTail(val);
            }else if (index <= 0){
                addAtHead(val);
            }else {
                ListNode pre =  head;
                ListNode cur = head.next;

                for (int i = 0; i < index; i++) {
                    pre = cur;
                    cur = cur.next;
                }
                ListNode temp = new ListNode(val);
                temp.next = cur;
                pre.next = temp;
                this.size++;
            }

        }

        public void deleteAtIndex(int index) {
            if (index <0 || index >=this.size){
                return;
            }
            ListNode pre =  head;
            ListNode cur = head.next;

            for (int i = 0; i < index; i++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            this.size--;
        }
    }
}
