package DayOne.simple;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-10-21 8:51
 */
public class N66 {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length-1] < 9){
            digits[digits.length-1]++;
        }else {
            //判断是否全9，改变形状
            boolean isAllNine = true;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == 9){
                    continue;
                }else {
                    isAllNine = false;
                }
            }
            if(isAllNine){
                int[] addDigit = new int[digits.length+1];
                addDigit[0] = 1;
                return addDigit;
            }else {
                for (int i = digits.length-1; i >=0; i--) {
                    if (digits[i] == 9){
                        digits[i] = 0;
                    }else {
                        digits[i] ++;
                        return digits;
                    }
                }
            }
        }
        ;

        return digits;
    }

    public static void main(String[] args) {
        N66 n66 = new N66();
        int[] digits ={989};
        for (int i : n66.plusOne(digits)) {
            System.out.println(i);
        }
    }
}
