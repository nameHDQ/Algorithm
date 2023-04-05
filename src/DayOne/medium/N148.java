package DayOne.medium;


import java.util.ArrayList;
import java.util.List;

public class N148 {
    public ListNode sortList(ListNode head) {

        ListNode cur = head;
        int count = 0;
        while (cur!= null){
            count++;
            cur = cur.next;
        }
        int[] nums = new int[count];
        cur = head;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cur.val;
            cur = cur.next;
        }
        fastSort(0, nums.length - 1, nums);
        cur = head;
        for (int num : nums) {
            cur.val = num;
            cur = cur.next;
        }
        return head;
    }


    public void fastSort(int left, int right, int[] nums){
        if (left >= right) return;
        int curLeft = left - 1, curRight = right +1, mid = (left + right) >> 1;

        while (curLeft < curRight){
            do {
                curLeft++;
            }while (nums[curLeft] < nums[mid]);
            do {
                curRight--;
            }while (nums[curRight] > nums[mid]);
            if (curLeft < curRight){
                int temp = nums[curLeft];
                nums[curLeft] = nums[curRight];
                nums[curRight] = temp;
            }
        }

        fastSort(left, curRight, nums);
        fastSort(curRight + 1, right, nums);

    }


    public void merge(int left, int right, int[] nums){
        if (left <= right) return;

        int mid = (left + right) >> 1;
        merge(left, mid, nums);
        merge(mid + 1, right, nums);

        List<Integer> temp = new ArrayList<>();

        int startLeft = left, startRight = mid + 1;
        while (startLeft <= mid && startRight <= right){
            if (nums[startLeft] <= nums[startRight]){
                temp.add(nums[startLeft]);
                startLeft++;
            }else {
                temp.add(nums[startRight]);
                startRight++;
            }
        }
        while (startLeft <= mid){
            temp.add(nums[startLeft++]);
        }
        while (startRight <= right){
            temp.add(nums[startRight++]);

        }

        for (int i = left; i < right; i++) {
            nums[i] = temp.get(i - left);
        }
    }

    public static void main(String[] args) {
        //[4,19,14,5,-3,1,8,5,11,15]
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(19);
        head.next = head1;
        ListNode head2 = new ListNode(14);
        head1.next = head2;
        ListNode head3 = new ListNode(5);
        head2.next = head3;
        ListNode head4 = new ListNode(-3);
        head3.next = head4;
        ListNode head5 = new ListNode(1);
        head4.next = head5;
        ListNode head6 = new ListNode(8);
        head5.next = head6;
        ListNode head7 = new ListNode(5);
        head6.next = head7;
        ListNode head8 = new ListNode(11);
        head7.next = head8;
        ListNode head9 = new ListNode(15);
        head8.next = head9;

        new N148().sortList(head);

    }

}
