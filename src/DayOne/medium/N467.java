package DayOne.medium;

import java.util.Map;
import java.util.Set;

/**
 * @author hdq
 * @create 2022-05-25 11:39
 */
public class N467 {
    public int findSubstringInWraproundString(String p) {
        String temp = "^" + p;
        Map<Character, Integer> map = new java.util.HashMap<>();
        int len = temp.length();
        int count = 1;
        int result = 0;
        for (int i = 1; i < len; i++){
            if ( temp.charAt(i) - temp.charAt(i - 1) == 1 || temp.charAt(i) - temp.charAt(i - 1) == -25){
                count++;
            }else {
                count = 1;
            }
            map.put(temp.charAt(i), Math.max(map.getOrDefault(temp.charAt(i), 0), count));
        }
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            result += map.get(key);
        }
        return result;
    }
}
