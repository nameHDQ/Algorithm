package DayOne.simple;

/**
 * @author hdq
 * @create 2022-01-07 12:00
 */
public class N1614 {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int maxNum = 0;
        int temp = 0;
        for (char aChar : chars) {
            if (aChar == '('){
                temp ++;
                if (temp > maxNum){
                    maxNum = temp;
                }
            }
            if (aChar == ')'){
                temp--;
            }
        }
        return maxNum;
    }
}
