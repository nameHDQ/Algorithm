package weekcmplication.week290;

import java.util.*;

/**
 * @author hdq
 * @create 2022-04-24 10:38
 */
public class N1 {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int[] num : nums) {
            for (int i : num) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            if (map.get(key) == len) {
                res.add(key);
            }
        }


        if (res.size() > 0) {
            Collections.sort(res);
        }
        return res;
    }
}
