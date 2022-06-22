package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-07 13:33
 */
public class N504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean flag = false;
        if (num < 0) {
            flag = true;
        }
        StringBuilder sb = new StringBuilder();
        int n = Math.abs(num);
        while (n > 0) {
            sb.append(n % 7);
            n /= 7;
        }
        if (flag) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
