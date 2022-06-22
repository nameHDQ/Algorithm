package DayOne.simple;

import java.util.Map;
import java.util.Set;

/**
 * @author hdq
 * @create 2022-05-21 10:00
 */
public class N961 {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int n = nums.length;
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            if (map.get(key) >= n / 2) {
                return key;
            }
        }
        return 0;
    }
}
