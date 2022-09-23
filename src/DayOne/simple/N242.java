package DayOne.simple;

import java.util.HashMap;
import java.util.Map;

public class N242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Character key : mapS.keySet()) {
            if (!mapT.get(key).equals(mapS.get(key)))return false;
        }
        return true;
    }
}
