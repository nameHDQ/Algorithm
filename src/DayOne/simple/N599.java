package DayOne.simple;

import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-03-14 13:07
 */
public class N599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> list = new java.util.ArrayList<>();
        Map<String, Integer> map2 = new java.util.HashMap<>();
        int minSUm = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                map2.put(list2[i], sum);
                if (sum < minSUm) {
                    minSUm = sum;
                }
            }
        }

        for (String key : map2.keySet()) {
            if (map2.get(key) == minSUm) {
                list.add(key);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
