package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class N56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);

        Deque<int[]> deque = new ArrayDeque<>();
        deque.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] pop = deque.pop();
            if (intervals[i][0] > pop[1]) {
                deque.push(pop);
                deque.push(intervals[i]);
            } else {
                deque.push(new int[]{pop[0], Math.max(intervals[i][1], pop[1])});
            }
        }
        int[][] res = new int[deque.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.pop();
        }
        return res;
    }
}
