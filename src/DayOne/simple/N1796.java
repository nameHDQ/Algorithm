package DayOne.simple;

import java.util.*;
import java.util.stream.Stream;

public class N1796 {
    public int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int first = -1;
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (aChar>='0' && aChar <= '9'){
                int temp = aChar - '0';
                map.put(temp,temp);
            }
        }

        Set<Integer> integers = map.keySet();
        int[] nums = new int[integers.size()];
        int index  =0;
        if (integers.size() <= 1) return -1;
        for (Integer integer : integers) {
            nums[index++] = integer;
        }
        Arrays.sort(nums);
        return nums[integers.size() - 2];
    }
}
