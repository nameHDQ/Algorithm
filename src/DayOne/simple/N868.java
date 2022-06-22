package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-24 9:42
 */
public class N868 {
    public int binaryGap(int n) {

        int left = 0;
        int right = 0;
        int max = 0;
        boolean flag = false;
        while(n > 0){
            if ((n & 1) == 1){
                if (flag){
                    max = Math.max(max, right - left);
                }
                left = right;
                flag = true;
            }
            right++;
            n >>= 1;
        }
        return max;
    }

    public static void main(String[] args) {
        N868 n868 = new N868();
        System.out.println(n868.binaryGap(22));
    }
}
