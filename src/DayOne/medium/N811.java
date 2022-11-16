package DayOne.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int count = 0;
        for (String cpdomain : cpdomains) {

            String[] split = cpdomain.split(" ");
            count = Integer.parseInt(split[0]);
            String[] strs = split[1].split("\\.");
            if (strs.length  == 3){
                map.put(strs[0] + "." + strs[1] + "." + strs[2], map.getOrDefault(strs[0] + "." + strs[1] + "." + strs[2], 0) + count);
                map.put(strs[1] + "." + strs[2], map.getOrDefault(strs[1] + "." + strs[2], 0) + count);
                map.put(strs[2], map.getOrDefault(strs[2], 0) + count);
            }else {
                map.put(strs[0] + "." + strs[1], map.getOrDefault(strs[0] + "." + strs[1], 0) + count);
                map.put(strs[1], map.getOrDefault(strs[1], 0) + count);
            }

        }
        for (String s : map.keySet()) {
            res.add(map.get(s)+ " " + s);
        }
        return res;
    }
}
