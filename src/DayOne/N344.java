package DayOne;

/**
 * @author hdq
 * @create 2021-08-22 12:58
 */
public class N344 {
    public void reverseString(char[] s) {
        for (int i = 0,j = s.length-1; i <j ; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
