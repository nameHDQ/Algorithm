package DayOne.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hdq
 * @create 2022-01-14 10:51
 */
public class N373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k,(a,b)->{
            int sumA = a[0] + a[1];
            int sumB = b[0] + b[1];
            return sumA-sumB;
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                priorityQueue.add(new int[]{nums1[i],nums2[j]});
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k && priorityQueue.size() > 0; i++) {
            List<Integer> temp = new ArrayList<>();
            int[] poll = priorityQueue.poll();
            temp.add(poll[0]);
            temp.add(poll[1]);
            res.add(temp);
        }
        return res;
    }
}
