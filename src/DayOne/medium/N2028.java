package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-27 10:13
 */
public class N2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sumAll = mean * (n + m);
        int sumM = 0;
        for (int i = 0; i < m; i++) {
            sumM += rolls[i];
        }
        int sumN = sumAll - sumM;
        int odd = sumN % n;
        int even = sumN / n;
        if (even > 6 || (even == 6 && odd > 0) || sumN <= 0 || even < 1) {
            return new int[0];
        }
        int[] res = new int[n];
        for (int i = 0; i <n; i++) {
            if (odd != 0) {
                res[i] = even + 1;
                odd--;
            }else {
                res[i] = even;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N2028 n2028 = new N2028();
        int[] res = n2028.missingRolls(new int[]{6,1,5,2}, 4, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
