package niuniu.mediumClass;

import java.util.Scanner;

public class N5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        int needLeft = 0;
        int res = 0;
        for (char aChar : chars) {
            if (aChar == '(' || aChar == ')'){
                if (aChar == '('){
                    needLeft++;
                }else {
                    if (needLeft < 1){
                        res++;
                    }else {
                        needLeft--;
                    }
                }
            }
        }
        System.out.println(Math.abs(res));
    }
}
