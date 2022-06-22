package DayOne.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-04-01 9:55
 */
public class N954 {
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new java.util.HashMap<>();
        // 先统计每个数字出现的次数
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // 0的个数是否偶数
        if (map.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> list = new java.util.ArrayList<>();
        // 按照绝对值的大小从小到大排序, 保存的是键值  不重复
        for (Integer x : map.keySet()) {
            list.add(x);
        }
        list.sort((a, b) -> {
            return Math.abs(a) - Math.abs(b);
        });
        // 判断是否满足
        for (Integer x : list) {
            if (map.get(x) > map.getOrDefault(x * 2, 0)) {
                return false;
            }
            map.put(2 * x, map.getOrDefault(2 * x, 0) - map.get(x));
        }
        return true;
    }
}
