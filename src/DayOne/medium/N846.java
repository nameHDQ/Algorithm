package DayOne.medium;

import java.util.*;

/**
 * @author hdq
 * @create 2021-12-30 10:08
 */
public class N846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> a-b);
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0)+1);
            q.add(i);
        }
        while (!q.isEmpty()){
            int temp = q.poll();
            if (map.get(temp) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int next = map.getOrDefault(temp + i, 0);
                if (next == 0) return false;
                map.put(temp+i, next-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N846 n846 = new N846();
        int[] hand = {1,2,3,6,2,3,4,7,8};
        n846.isNStraightHand(hand, 3);
    }
}
