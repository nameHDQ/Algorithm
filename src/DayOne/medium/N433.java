package DayOne.medium;

import java.util.*;

/**
 * @author hdq
 * @create 2022-05-07 9:43
 */
public class N433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> has = new HashSet<>();
        Set<String> isVisited = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            has.add(bank[i]);
        }
        if (start.equals(end)) {
            return 0;
        }
        if (!has.contains(end)) {
            return -1;
        }
        char[] keys = {'A', 'C', 'G', 'T'};
        isVisited.add(start);
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        String next = cur.substring(0, j) + keys[k] + cur.substring(j + 1);
                        if (!isVisited.contains(next) && has.contains(next)) {
                            if (next.equals(end)) {
                                return step + 1;
                            }
                            isVisited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
