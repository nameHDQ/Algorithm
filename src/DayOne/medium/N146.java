package DayOne.medium;

import java.util.LinkedHashMap;

public class N146 {
    class LRUCache {

        LinkedHashMap<Integer, Integer> map;
        int capacity;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)){
                return -1;
            }
            MakeRecent(key, map.get(key));
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                map.put(key, value);
                MakeRecent(key, map.get(key));
            }else {
                if (map.size() >= capacity){
                    map.remove(map.keySet().iterator().next());
                    map.put(key, value);
                }else {
                    map.put(key, value);
                }

            }
        }

        public void MakeRecent(int key, int value){
            int temp = map.get(key);
            map.remove(key);
            map.put(key, temp);
        }
    }
}
