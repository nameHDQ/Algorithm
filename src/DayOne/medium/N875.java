package DayOne.medium;

/**
 * @author hdq
 * @create 2022-06-14 15:21
 */
public class N875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int res = high;
        while (low < high){
            int speed = (low + high) >> 1;
            long time = 0;
            for (int pile : piles) {
                int curTime = (pile + speed - 1) / speed;   // 这个技巧一定要学 实现向上取整
                time +=curTime;
            }
            if (time <= h){
                res = speed;
                high = speed;
            }else {
                low = speed + 1;
            }
        }
        return res;
    }
}
