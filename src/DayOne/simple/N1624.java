package DayOne.simple;

import java.util.HashMap;
import java.util.Map;

public class N1624 {
    public int maxLengthBetweenEqualCharacters(String s) {

        int result = -1;
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                result = Math.max(i - map.get(chars[i]) - 1, result);
            }else {
                map.put(chars[i], i);
            }
        }
        return result;
    }
}
