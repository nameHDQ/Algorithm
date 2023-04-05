package DayOne.simple;

import java.util.*;

public class N2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Set<Integer> resTemp = new HashSet<>();
        for (int i : nums1) {
            map.put(i,1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)){
                resTemp.add(i);
            }
            map2.put(i,1);
        }
        for (int i : nums3) {
            if (map.containsKey(i) || map2.containsKey(i)){
                resTemp.add(i);
            }
        }
        for (Integer integer : resTemp) {
            res.add(integer);
        }
        return res;
    }
}
