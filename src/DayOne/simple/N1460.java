package DayOne.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class N1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            map1.put(target[i], map1.getOrDefault(target[i], 0) + 1);
            map2.put(target[i], map2.getOrDefault(target[i], 0) + 1);
        }
        Set<Integer> integers = map1.keySet();
        for (Integer integer : integers) {
            if (map1.get(integer) != map2.getOrDefault(integer, -1)){
                return false;
            }
        }
        return true;
    }
}
