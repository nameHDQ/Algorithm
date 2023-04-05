package DayOne.simple;

import java.util.HashMap;
import java.util.Map;

public class N2325 {
    public String decodeMessage(String key, String message) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ' && !map.containsKey(key.charAt(i))){
                map.put(key.charAt(i), map.size());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' '){
                sb.append(message.charAt(i));
            }else {
                sb.append( ((char)('a' + map.get(message.charAt(i)))));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new N2325().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    }
}
