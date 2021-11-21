package DayOne.medium;

/**
 * @author hdq
 * @create 2021-11-15 10:22
 */
public class N319 {
    public int bulbSwitch(int n) {
        int[] state = new int[n+1];
        //初始化为一
        for (int i = 1; i < state.length; i++) {
            state[i] =1;
        }
        for (int i = 2; i <state.length ; i++) {
            for (int j = 2; j <state.length ; j++) {
                if (j%i == 0){
                    state[j]= state[j] == 0 ? 1 : 0;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <state.length ; i++) {
            if (state[i] == 1){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        N319 n319 = new N319();
        System.out.println(n319.bulbSwitch(8));
    }
}
