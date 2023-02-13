package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class N43 {
    public String multiply(String num1, String num2) {

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        String zero2 = "";
        for (int i = 0; i < chars2.length; i++) {
            zero2 += "0";
        }
        Deque<String> deque = new ArrayDeque<>();
        for (int j = chars1.length - 1; j >= 0; j--) {
            if (chars1[j] == '0'){
                deque.add(zero2);
                continue;
            }
            String temp = "";
            int next = 0;
            for (int i = chars2.length - 1; i >= 0 ; i--) {
                int cur = (chars2[i] - '0') * (chars1[j] - '0') + next;
                next = cur / 10;
                temp = (cur % 10)+ "" + temp;
            }
            if (next > 0) temp = next + "" + temp;
            deque.add(temp);
        }
        String pre = deque.remove();
        int bit = 1;
        while (!deque.isEmpty()){
            String nex = deque.remove();
            char[] charP = pre.toCharArray();
            char[] charN = nex.toCharArray();
            int index = 1;
            int next = 0;
            String temp = "";
            for (int i = 0; i < bit; i++) {
                temp = "" + charP[charP.length - index] + temp;
                index++;
            }
            int indexN = charN.length - 1;
            while (charP.length - index >= 0 && indexN >= 0){
                int cur = charP[charP.length - index] - '0' + charN[indexN] - '0' + next;
                next = cur /10;
                temp = (cur % 10) + "" + temp;
                index++;
                indexN--;
            }
            while (charP.length - index >= 0){
                int cur = charP[charP.length - index] - '0' + next;
                next = cur /10;
                temp = (cur % 10) + "" + temp;
                index++;
            }
            while (indexN >= 0){
                int cur = charN[indexN] - '0' + next;
                next = cur /10;
                temp = (cur % 10) + "" + temp;
                indexN--;
            }
            if (next > 0){
                temp = next + "" + temp;
            }
            pre = temp;
            bit++;
        }
        return pre.charAt(0) == '0' ? "0" : pre;
    }

    public static void main(String[] args) {
        new N43().multiply("123", "456");
    }
}
