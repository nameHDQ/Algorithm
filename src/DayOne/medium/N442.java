package DayOne.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-05-08 11:33
 */
public class N442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new java.util.ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                list.add(nums[i]);
            }else {
                map.put(nums[i], 1);
            }
        }
        return list;
    }
}
