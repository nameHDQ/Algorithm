package DayOne.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-03-16 12:20
 */
public class N432 {
    class AllOne {
        Map<String, Integer> map;
        public AllOne() {
            map = new HashMap<>();
        }

        public void inc(String key) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }else {
                map.put(key, 1);
            }
        }

        public void dec(String key) {
            if (map.get(key) > 1) {
                map.put(key, map.get(key) - 1);
            }else {
                map.remove(key);
            }
        }

        public String getMaxKey() {
            if (map.isEmpty()) {
                return "";
            }
            return map.keySet().stream().max((a, b) -> map.get(a) - map.get(b)).get();
        }

        public String getMinKey() {
            if (map.isEmpty()) {
                return "";
            }
            return map.keySet().stream().min((a, b) -> map.get(a) - map.get(b)).get();
        }
    }

    public static void main(String[] args) {
        AllOne one = new N432().new AllOne();
        one.inc("a");
        one.inc("b");
        one.inc("b");
        System.out.println(one.getMinKey());
    }
}
