package DayOne.hard;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-12-14 11:34
 */
public class N630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b)->{
            return a[1] - b[1];
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        int total = 0;
        for (int[] cours : courses) {
            int ti = cours[0],di = cours[1];
            if (total + ti <= di){
                total +=ti;
                priorityQueue.add(ti);
            }else if (!priorityQueue.isEmpty() &&  priorityQueue.peek() > ti){
                Integer poll = priorityQueue.poll();
                total -= poll-ti;
                priorityQueue.add(ti);
            }
        }
        return priorityQueue.size();
    }

    public static void main(String[] args) {
        int[][] grid = { {100, 200},{200, 1300}, {1000, 1250}, {2000, 3200}};
        N630 n630 = new N630();

        System.out.println(n630.scheduleCourse(grid));
    }
}
