package DayOne;

import java.util.logging.Level;

/**
 * @author hdq
 * @create 2021-08-19 12:32
 */
public class N278 {
    public int firstBadVersion(int n) {
        int left =1;
        int right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (1 > 0){
                right = mid;
            }else{
                left =mid;
            }
        }
        return left;
    }
}
