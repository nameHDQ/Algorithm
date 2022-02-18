package DayOne.simple;

import java.util.Map;

/**
 * @author hdq
 * @create 2021-12-31 11:29
 */
public class N507 {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num %i == 0){
                sum+=i;
            }
        }
        if (sum == num){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        N507 n507 = new N507();
        System.out.println(n507.checkPerfectNumber(2));
    }
}
