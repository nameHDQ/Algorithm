package DayOne.simple;

/**
 * @author hdq
 * @create 2021-10-18 9:46
 */
public class N476 {
    public int findComplement(int num) {
        int habbit = 0;
        for (int i = 1; i <= 30 ; i++) {
            if (num >= 1<<i){
                habbit = i;
            }else {
                break;
            }
        }
        int mask = habbit == 30 ? 0x7fffffff : (1<<(habbit+1)) -1;
        return num ^ mask;
    }

    public static void main(String[] args) {
        N476 n476 = new N476();
        System.out.println(n476.findComplement(5));
    }
}
