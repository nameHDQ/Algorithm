package DayOne;

import java.util.Stack;

/**
 * @author hdq
 * @create 2021-09-12 9:13
 */
public class N678 {
    public boolean checkValidString(String s) {
        int countZ = 0;
        int countY = 0;
        int countH = 0;
        int countHY= 0;
        int countHZ = 0;
        boolean isyou = false;
        boolean isxin = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                isyou = true;
                countY++;
            }
            if (s.charAt(i) == '(' && !isyou){
                countZ++;
                if (isxin){
                    countHZ += countH;
                    countH = 0;
                    isxin = false;
                }
            }else if (s.charAt(i) == '*' && isyou){
                countHY++;
            }else if (s.charAt(i) == '*' && !isyou){
                isxin = true;
                countH++;
            }else if (s.charAt(i) == '(' && isyou){
                return false;
            }
        }
        System.out.println(countZ+""+countHZ+""+countH+""+countHY+""+countY);
        if (countZ >=countY){
            if (countY+countHY+countH - countZ >=0){
                return true;
            }
        }else {
            if (countZ +countHZ +countH >=0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N678 n678 = new N678();
        System.out.println(n678.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));

    }
}
