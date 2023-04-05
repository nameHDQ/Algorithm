package niuniu.mediumClass;

import java.util.Scanner;

public class N4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        int need = 0;
        for (char aChar : chars) {
            if (aChar == '(' || aChar == ')'){
                if (aChar == '('){
                    need++;
                }else {
                    if (need < 1){
                        System.out.println("NO");
                        return;
                    }else {
                        need--;
                    }
                }
            }else {
                System.out.println("NO");
                return;
            }
        }
        if (need == 0) {

            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
