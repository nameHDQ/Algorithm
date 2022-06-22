package weekcmplication.doubleweek79;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author hdq
 * @create 2022-05-28 22:12
 */
public class N2 {
    public String largestWordCount(String[] messages, String[] senders) {
        int len = messages.length;
        Map<String, Integer> map  = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        for (int i = 0; i < len; i++) {
            int count = messages[i].split(" ").length;
            if (map.containsKey(senders[i])){
                int temp = map.get(senders[i]);
                map.put(senders[i], count + temp);
            }else {
                map.put(senders[i], count);
            }
        }
        Set<String> keySet = map.keySet();
        map.put(" ", Integer.MIN_VALUE);
        String max = " ";
        for (String s : keySet) {
            if (map.get(s) > map.get(max)){
                max = s;
            }
        }

        return max;
    }
}
