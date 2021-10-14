package DayOne.medium;

import java.util.*;

/**
 * @author hdq
 * @create 2021-10-08 9:29
 */
public class N187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> okSon = new ArrayList<>();
        int len = s.length();
        if (len < 10){
            return okSon;
        }
        Map<String,Integer> SonList = new HashMap<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String str = s.substring(i, i+10);
            if (SonList.containsKey(str)){
                SonList.put(str, SonList.get(str)+1);
            }else {
                SonList.put(str, 1);
            }
        }

        Set<String> keySet = SonList.keySet();
        for (String s1 : keySet) {
            if (SonList.get(s1) >1){
                okSon.add(s1);
            }
        }
        return okSon;
    }

    public static void main(String[] args) {
        N187 n187 = new N187();
        List<String> strs = n187.findRepeatedDnaSequences("A");
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
