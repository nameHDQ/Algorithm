package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-07 10:14
 */
public class N796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
