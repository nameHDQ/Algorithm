package DayOne;

/**
 * @author hdq
 * @create 2021-09-11 11:25
 */
public class N600 {
    public int findIntegers(int n) {
        int pre = 1;
        int now = 0;
        int all = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count = 0;
            int temp = i;
            while (temp != 0){
                if (temp % 2 == 1){
                    count++;
                    temp = temp/2;
                    if (count >=2){
                        break;
                    }
                }else {
                    if (count <2){
                        count = 0;
                        temp /=2;
                    }
                }
            }
            now = 0;
            if (count < 2){
                now = 1;
            }
            all =pre + now;
            pre =all;
        }
        return all;
    }

    public static void main(String[] args) {
        N600 n600 = new N600();
        System.out.println(n600.findIntegers(35));
    }
}
