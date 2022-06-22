package DayOne.medium;

/**
 * @author hdq
 * @create 2022-02-25 9:44
 */
public class N537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] s1 = num1.split("\\+");
        String[] s2 = num2.split("\\+");
        int a1 = Integer.parseInt(s1[0]);
        int b1 = Integer.parseInt(s1[1].substring(0, s1[1].length() - 1));
        int a2 = Integer.parseInt(s2[0]);
        int b2 = Integer.parseInt(s2[1].substring(0, s2[1].length() - 1));
        int a = a1 * a2 - b1 * b2;
        int b = a1 * b2 + a2 * b1;
        return a + "+" + b + "i";
    }

    public static void main(String[] args) {
        System.out.println(new N537().complexNumberMultiply("1+1i", "1+1i"));
    }
}
