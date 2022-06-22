package weekcmplication.doubleweek79;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author hdq
 * @create 2022-05-28 22:12
 */
public class N1 {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            map.put(num.charAt(i)-'0', map.getOrDefault(num.charAt(i) - '0', 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            // 如果是有这个key个
            if (map.containsKey(i)) {
                if (num.charAt(i) - '0' == map.get(i)) {
                    continue;
                } else {
                    return false;
                }
            }else {
                if (num.charAt(i) - '0' != 0){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String str = "1210";
        System.out.println(new N1().digitCount(str));
    }
}
