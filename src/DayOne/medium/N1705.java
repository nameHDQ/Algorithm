package DayOne.medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author hdq
 * @create 2021-12-24 10:33
 */
public class N1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> maxDay = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        int n = apples.length,time = 0,ans = 0;
        while (time < n || !maxDay.isEmpty()){
            //苹果进队列,若是进完了 跳过
            if (time < n && apples[time] > 0){
                maxDay.add(new int[]{time+days[time]-1,apples[time]});
            }
            //过期苹果去除
            while (!maxDay.isEmpty() && maxDay.peek()[0] < time){
                maxDay.poll();
            }
            if (!maxDay.isEmpty()){
                int[] cur = maxDay.poll();
                //快过期的有苹果可吃，减一吃掉再加入
                if (--cur[1] > 0 && cur[0] > time){
                    maxDay.add(cur);
                }
                //吃掉一个
                ans++;
            }
            time++;
        }
        return ans;
    }

    public static void main(String[] args) {
        N1705 n1705 = new N1705();
        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};
        System.out.println(n1705.eatenApples(apples, days));
    }
}
