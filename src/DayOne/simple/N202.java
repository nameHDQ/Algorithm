package DayOne.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hdq
 * @create 2021-12-23 11:24
 */
public class N202 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n!=1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n==1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n>0){
            int d = n%10;
            n = n/10;
            totalSum += d*d;
        }
        return totalSum;
    }
}
