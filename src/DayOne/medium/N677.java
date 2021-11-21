package DayOne.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hdq
 * @create 2021-11-14 10:40
 */
public class N677 {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));

    }

}
class MapSum {
    Map<String,Integer> map = null;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int num = 0;
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            if (s.startsWith(prefix)){
                num +=map.get(s);
            }
        }
        return num;
    }
}
