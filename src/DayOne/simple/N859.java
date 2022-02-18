package DayOne.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hdq
 * @create 2021-11-23 9:49
 */
public class N859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }
        int sum = 0;
        boolean flag = false;
        Map<Integer,Integer> maps = new HashMap<>();
        Map<Integer,Integer>mapGoal = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            maps.put(s.charAt(i)-'a', maps.getOrDefault(s.charAt(i)-'a',0)+1);
            mapGoal.put(goal.charAt(i)-'a', mapGoal.getOrDefault(goal.charAt(i)-'a',0)+1);
            if (s.charAt(i)-'a' != goal.charAt(i)-'a'){
                sum++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (maps.get(s.charAt(i)-'a') != mapGoal.get(goal.charAt(i)-'a')){
                return false;
            }
            if (maps.get(s.charAt(i)-'a') >1){
                flag =true;
            }
        }

        return sum == 2 || (flag && sum == 0);
    }

    public static void main(String[] args) {
        N859 n859 = new N859();
        String s = "abcd";
        String goal = "badc";
        System.out.println(s.hashCode());
        System.out.println(goal.hashCode());
        System.out.println(n859.buddyStrings(s, goal));
    }
}
