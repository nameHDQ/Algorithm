package DayOne.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-05-17 8:05
 */
public class N953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        // 记录每个字母的位置
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int len1 = word1.length();
            int len2 = word2.length();
            int start = 0;
            while (start < len1 && start < len2) {
                char c1 = word1.charAt(start);
                char c2 = word2.charAt(start);
                // 大于，后面的字母就不用比了
                if (map.get(c1) < map.get(c2)) {
                    break;
                }
                // 小于且前面没有大于的，非字典序
                if (map.get(c1) > map.get(c2)) {
                    return false;
                }
                // 等于，直接过
                start++;
            }
            if (len1 > len2 && start == Math.min(len1, len2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"kuvp","q"};
        String order = "ngxlkthsjuoqcpavbfdermiywz";
        System.out.println(new N953().isAlienSorted(words, order));
    }
}
