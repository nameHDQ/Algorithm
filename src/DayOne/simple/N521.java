package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-05 11:20
 */
public class N521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
