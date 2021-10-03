package DayOne.simple;

/**
 * @author hdq
 * @create 2021-09-23 10:09
 */
public class N326 {
    public boolean isPowerOfThree(int n) {
        if (n <3){
            if (n == 1){
                return true;
            }
            return false;
        }
        int temp = n;
        while (temp >=3){
            if (temp%3==0){
                temp /=3;
            }else {
                return false;
            }
        }
        if (temp == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        N326 n326 = new N326();
        System.out.println(n326.isPowerOfThree(1));
    }
}
