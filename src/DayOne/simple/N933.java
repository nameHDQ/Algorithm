package DayOne.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-05-06 9:38
 */
public class N933 {
    static class RecentCounter {
        List<Integer> list;
        int size;

        public RecentCounter() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            int count = 0;
            list.add(t);
            size = list.size();
            while (size > 0 && list.get(size - 1)  > t - 3000) {
                count++;
                size--;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
       recentCounter.ping(1);
       recentCounter.ping(100);
       recentCounter.ping(3001);
       recentCounter.ping(3002);
    }
}
