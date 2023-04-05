package Spring2023.redcompus;

import java.util.Scanner;

public class N1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int str1 = Integer.parseInt(in.nextLine());
        String str2 = in.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chars ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
        'p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i < str2.length(); i++) {
            char temp = str2.charAt(i);
            if (temp - 'a'- 3 < 0){
                sb.append(chars[temp - 3 - 'a' + 26]);
            }else {
                sb.append(chars[temp - 'a' -3]);
            }
        }
        System.out.println(sb.toString());
    }
}
//
//import java.io.*;
//        import java.util.*;
//class Solution {
//    public int addab(int a, int b) {
//        return a+b;
//    }
//}
//public class Main
//{
//    public static void main(String args[])
//    {
//        Scanner cin = new Scanner(System.in);
//        int a, b;
//        while(cin.hasNextInt())
//        {
//            a = cin.nextInt();
//            b = cin.nextInt();
//            Solution s = new Solution();
//            int c = s.addab(a, b);
//            System.out.println(c);
//        }
//    }
//}