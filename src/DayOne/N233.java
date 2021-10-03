package DayOne;

import java.util.ArrayList;

/**
 * @author hdq
 * @create 2021-08-13 10:29
 */
public class N233 {
    public static int countDigitOne(int n) {
        if (n == 0){
            return 0;
        }
//        for (int i = 1; i <= n; i++) {

//            String s = new String(new Integer(i).toString());
//            for (int j = 0; j < s.length(); j++) {
//                if (s.charAt(j) == '1'){
//                    count++;
//                }
//            }
//            int temp = i;
//            while (temp > 0){
//                int yushu = temp%10;
//                if (yushu == 1){
//                    count++;
//                }
//                temp = temp/10;
//            }
//        }
        String s = new String(new Integer(n).toString());
        int len  = s.length();
        int temp = n;
        int totalcount = 0;
        for (int i = 0; i < len; i++) {
            int  yushu = temp%10;
            if (yushu == 0){
                totalcount +=(temp/10)*(int) (Math.pow(10,i)) ;
                temp /=10;
                continue;
            }
            //特殊情况
            if (yushu == 1){
                totalcount +=(n%((int) (Math.pow(10,i))))+ 1 + (temp/10)*(int) (Math.pow(10,i));
            }
            if (yushu > 1){
                totalcount += (temp/10 + 1)*(int) (Math.pow(10,i));
            }
            temp /=10;
        }
        return totalcount;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(100));
    }
}
