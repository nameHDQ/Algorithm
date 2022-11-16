package DayOne.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N817 {
    public int numComponents(ListNode head, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (head != null){
            if (map.containsKey(head.val)){
                while (head.next != null && map.containsKey(head.next.val)) head = head.next;
                maxLen++;
            }else {
                head = head.next;
            }
        }
        return maxLen;
    }
}
