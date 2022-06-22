package DayOne.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hdq
 * @create 2022-04-17 12:04
 */
public class N819 {
    public String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> bans = new HashSet<>();
        for (String ban : bans) {
            bans.add(ban);
        }
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        paragraph = paragraph.toLowerCase();
        String[] split = paragraph.split("[ !?',;.:]");
        for (String s : split) {
            if (bans.contains(s)) {
                continue;
            }
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }else {
                map.put(s, 1);
            }
        }
        int max = 0;
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }
        return res;
    }
}
