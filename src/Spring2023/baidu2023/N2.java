package Spring2023.baidu2023;

import java.util.Scanner;

public class N2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if(n == 1){
            System.out.println("r");
            return;
        }else if (n == 2){
            System.out.println("re");
        }else {
            int sum = 0;

            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
                if (sum > n){
                    sum -= i;
                    break;
                }else {
                    index = i;
                }
            }
            for (int i = 0; i < index; i++) {
                sb.append("d");
            }
            int son = n % sum;
            int num = son / 3;
            int num_son = son % 3;
            for (int i = 0; i < num; i++) {
                sb.append("red");
            }
            sb.append("red".substring(0, num_son));
            System.out.println(sb.toString());
        }

    }
}
