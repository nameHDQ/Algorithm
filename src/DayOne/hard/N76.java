package DayOne.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class N76 {

    Map<Character, Integer> mapT = new HashMap<>();
    Map<Character, Integer> mapS = new HashMap<>();
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        char[] charT = t.toCharArray();
        for (char aChar : charT) {
            mapT.put(aChar, mapT.getOrDefault(aChar, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int begin = -1;
        int distance = s.length() + 1;
        char[] chars = s.toCharArray();
        while (right < s.length()){
            if (mapT.containsKey(chars[right])){
                mapS.put(chars[right], mapS.getOrDefault(chars[right], 0) + 1);
            }
            while (check()){
                while (!mapT.containsKey(chars[left])){
                    left++;
                }
                int tempLen = right - left + 1;
                if (tempLen < distance){
                    distance = tempLen;
                    begin = left;
                }
                if (mapT.containsKey(chars[left])){
                    mapS.put(chars[left], mapS.get(chars[left]) - 1);
                }
                left++;
            }
            right++;
        }
        return begin == -1 ? "" : s.substring(begin, begin + distance);
    }

    public boolean check(){
        for (Character character : mapT.keySet()) {
            if (mapS.getOrDefault(character, 0) < mapT.get(character)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
