package competition.spring2022.team;


/**
 * @author hdq
 * @create 2022-04-23 15:06
 */
public class N1 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int allTime = 0;
        for (int[] fruit : fruits) {
            int type = fruit[0];
            int num = fruit[1];
            int t = time[type];
            if ( num % limit == 0) {
                allTime += num / limit * t;
            }else {
                allTime += (num / limit + 1) * t;
            }
        }
        return allTime;
    }
}
