package DayOne.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hdq
 * @create 2021-12-10 9:45
 */
public class N748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Integer,Integer> map = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        String res = "";
        //统计字母格数
        for (int i = 0; i < licensePlate.length(); i++) {
            if ((licensePlate.charAt(i)  >= 'a' && licensePlate.charAt(i)  <= 'z')){
                map.put(licensePlate.charAt(i)-'a',map.getOrDefault(licensePlate.charAt(i)-'a', 0)+1);
            }
            if ((licensePlate.charAt(i)  >= 'A' && licensePlate.charAt(i)  <= 'Z')){
                map.put(licensePlate.charAt(i)-'A',map.getOrDefault(licensePlate.charAt(i)-'A', 0)+1);
            }
        }
        for (int i = 0; i < words.length; i++) {
            Map<Integer,Integer> temp = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                if ((words[i].charAt(j)  >= 'a' && words[i].charAt(j)  <= 'z')){
                    temp.put(words[i].charAt(j)-'a',temp.getOrDefault(words[i].charAt(j)-'a', 0)+1);
                }
                if ((words[i].charAt(j)  >= 'A' && words[i].charAt(j)  <= 'Z')){
                    temp.put(words[i].charAt(j)-'A',temp.getOrDefault(words[i].charAt(j)-'A', 0)+1);
                }
            }
            Set<Integer> integers = map.keySet();
            boolean isMin = true;
            for (Integer integer : integers) {
                if (temp.get(integer) == null){
                    isMin = false;
                    break;
                }
                if (map.get(integer) > temp.get(integer)){
                    isMin = false;
                    break;
                }
            }
            if (isMin){
                if (minLen > words[i].length()){
                    minLen = words[i].length();
                    res = words[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N748 n748 = new N748();
        String[] nums ={"claim","consumer","student","camera","public","never","wonder","simple","thought","use"};
        String re =  "iMSlpe4";
        System.out.println(n748.shortestCompletingWord(re, nums));
    }
}
