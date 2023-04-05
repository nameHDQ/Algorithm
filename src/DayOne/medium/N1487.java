package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

public class N1487 {
    public String[] getFolderNames(String[] names) {


        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0;i < names.length; i++) {
            if (!map.containsKey(names[i])){
                map.put(names[i], 1);
                res[i] = names[i];
                continue;
            }
            Integer integer = map.get(names[i]);
            String temp = names[i] + "(" + integer + ")";
            while (map.containsKey(temp)){
                ++integer;
                temp = names[i] + "(" + integer + ")";
            }
            map.put(names[i],++integer);
            map.put(temp, 1);
            res[i] = temp;
        }
        return res;
    }
}
