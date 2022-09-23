package DayOne.hard;

import java.util.HashMap;
import java.util.Map;

public class N828 {
    public int uniqueLetterString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = chars.length;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){

                if (map.get(chars[i]) == 1){
                    res -= 2;
                }else {
                    res--;
                }
                map.put(chars[i], map.get(chars[i]) + 1);
            }else {
                map.put(chars[i], 1);
            }
        }
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            temp = 1;
            for (int j = i + 1; j < chars.length; j++) {


            }



        }

        return 0;
    }
}
