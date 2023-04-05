package niuniu.mediumClass;

import java.util.Scanner;

public class N1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        in.nextLine();
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String temp = str1  + str1;
        if (str1.length() == str2.length() && temp.contains(str2)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
