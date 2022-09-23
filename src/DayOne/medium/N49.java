package DayOne.medium;

import com.sun.applet2.AppletParameters;

import java.util.*;

public class N49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStrs = new String(chars);
            List<String> list = map.getOrDefault(sortStrs, new ArrayList<String>());
            list.add(str);
            map.put(sortStrs, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
