package DayOne.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hdq
 * @create 2021-12-27 10:42
 */
public class N825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int total = 0;
        for (int i = ages.length-1; i >=0 ; i--) {
            for (int j = i-1; j >=0 ; j--) {
                if (ages[j] > 100  && ages[i] < 100){
                    continue;
                }
                if (ages[j] <= ages[i]/2+7){
                    continue;
                }
                if (ages[j] == ages[i]){
                    total+=2;
                }else {
                    total++;
                }

            }
        }
        return total;
    }
}
