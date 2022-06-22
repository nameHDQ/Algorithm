package DayOne.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-04-25 9:18
 */
public class N398 {
    class Solution {
        Map<Integer, List<Integer>> map;
        public Solution(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    List<Integer> list = map.get(nums[i]);
                    list.add(i);
                    map.put(nums[i], list);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(nums[i], list);
                }
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get((int)(Math.random() * list.size()));
        }
    }
}
