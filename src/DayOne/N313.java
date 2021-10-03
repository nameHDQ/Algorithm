package DayOne;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author hdq
 * @create 2021-08-09 18:38
 */
public class N313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //Set集合 不重复，无序，用来去重，避免重复的数据加入堆中
        Set<Long> uglyset = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        uglyset.add(1L);
        heap.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur =heap.poll();
            ugly = (int)cur;
            for (int prime:primes) {
                long next = cur*prime;
                //判断是否重复
                if (uglyset.add(next)){
                    heap.add(next);
                }
            }
        }
        return ugly;
    }
}
