package DayOne.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0),strings.get(1));
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                i++;
                String temp = "";
                while (i < chars.length && chars[i] != ')'){
                    temp += chars[i];
                    i++;
                }
                if (map.containsKey(temp)){
                    sb.append(map.get(temp));
                }else {
                    sb.append("?");
                }
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
