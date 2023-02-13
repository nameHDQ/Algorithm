package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

public class N128 {
    Map<Integer, Integer> map = new HashMap<>();
    public int longestConsecutive(int[] nums) {


        for (int num : nums) {
            map.put(num, num);
        }
        for (int num : nums) {
            if (find(num + 1) != null){
                union(num, num + 1);
            }
        }
        int maxLen = 0;
        for (int num : nums) {
            int right = find(num);
            maxLen = Math.max(maxLen, right - num + 1);

        }
        return maxLen;
    }

    public Integer find(int cur){
        if (!map.containsKey(cur)){
            return null;
        }
        while (cur != map.get(cur)){
            map.put(cur, map.get(map.get(cur)));
            cur = map.get(cur);
        }
        return cur;
    }
    public void union(Integer a, Integer b){
        int parentA = map.get(a);
        int parentB = map.get(b);
        if (parentB == parentA){
            return;
        }
        if (parentB > parentA){
            map.put(a, parentB);
        }else {
            map.put(b, parentA);
        }
    }
}
