package DayOne.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-06-12 10:06
 */
public class N890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int len = words.length;
        int n = pattern.length();
        List<String> result = new ArrayList<>();
        boolean flag = true;
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            flag = true;
            map.clear();
            map2.clear();
            for (int j = 0; j < n; j++) {
                // 如果包含 看看新的字符 和 旧的是否一致 不然是一对多的映射
                if(map.containsKey(pattern.charAt(j))){
                    Character old = map.get(pattern.charAt(j));
                    // 不相同  不符合
                    if (old != words[i].charAt(j)){
                        flag = false;
                        break;
                    }
                }else {
                    // 多对一的检查
                    if (map2.containsKey(words[i].charAt(j))){
                        Character temp = map2.get(words[i].charAt(j));
                        if (temp != pattern.charAt(j)){
                            flag =false;
                            break;
                        }
                    }
                    map.put(pattern.charAt(j), words[i].charAt(j));
                    map2.put(words[i].charAt(j),pattern.charAt(j));
                }
                // 反方向
//                if (map.containsKey(words[i].charAt(j))){
//                    Character old = map.get(words[i].charAt(j));
//                    if (old != pattern.charAt(j)){
//                        flag = false;
//                        break;
//                    }
//                }else {
//                    map.put(words[i].charAt(j),pattern.charAt(j));
//                }
            }

            if (flag){
                result.add(words[i]);
            }

        }


        return result;
    }

    public static void main(String[] args) {
        String[] str = {"abc","deq","mee","aqq","dkd","ccc"};//"abc","deq","mee","aqq","dkd","ccc"  ,"ef","fq","ao","at","lx"
        String patter = "abb";  //ya
        System.out.println(new N890().findAndReplacePattern(str, patter));
    }
}
