package weekcmplication.week297;

import java.time.Period;

/**
 * @author hdq
 * @create 2022-06-12 10:03
 */
public class N1 {

    public double calculateTax(int[][] brackets, int income) {
        if (income == 0){
            return 0;
        }
        int len = brackets.length;
        double result = 0;
        for (int i = 0; i < len; i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            int tax = i == 0 ? brackets[i][0] : brackets[i][0] -brackets[i - 1][0];
            if (income >= upper){
                result += tax * percent;
            }else {
                if (i == 0){
                    result += income * percent;
                }else {
                    result += (income - brackets[i - 1][0]) * percent;
                }
                break;
            }
        }
        return result / 100;
    }
}
