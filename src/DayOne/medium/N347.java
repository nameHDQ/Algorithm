package DayOne.medium;

import java.util.*;

public class N347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a , b)->{
            return a[1] - b[1];
        });
        Set<Integer> set = map.keySet();
        for (Integer s : set) {

            if (priorityQueue.size() < k){
                priorityQueue.offer(new int[]{s, map.get(s)});
            }else {
                if (priorityQueue.peek()[1] < map.get(s)){
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{s, map.get(s)});
                }
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int[] ints : priorityQueue) {
            res[idx++] = ints[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nus = {4,1,-1,2,-1,2,3};
        new N347().topKFrequent(nus, 2);
    }
}
