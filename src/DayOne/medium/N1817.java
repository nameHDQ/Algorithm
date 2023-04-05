package DayOne.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> user = new HashMap<>();
        int[] answer = new int[k];
        for (int[] log : logs) {
            Set<Integer> set = user.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            user.put(log[0], set);
        }
        Map<Integer, Integer> temp = new HashMap<>();
        for (Integer integer : user.keySet()) {
            temp.put(user.get(integer).size(), temp.getOrDefault(user.get(integer).size(), 0) + 1);
        }
        for (Integer integer : temp.keySet()) {
            answer[integer - 1] = temp.get(integer);
        }
        return answer;

    }
}
