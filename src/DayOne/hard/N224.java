package DayOne.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class N224 {
    public int calculate(String s) {


        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        int len = s.length();
        int sign = 1;
        int start = 0;
        int res = 0;
        while (start < len){
            if (s.charAt(start) == ' '){
                start++;
                continue;
            }else if (s.charAt(start) == '+'){
                sign = deque.peek();
                start++;
            }else if (s.charAt(start) == '-'){
                sign = -deque.peek();
                start++;
            }else if (s.charAt(start) == '('){
                deque.push(sign);
                start++;
            }else if (s.charAt(start) == ')'){
                deque.pop();
                start++;
            }else {
                long temp = 0;
                while (start < len && Character.isDigit(s.charAt(start))){
                    temp = temp *10 + s.charAt(start) - '0';
                    start++;
                }
                res += temp * sign;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N224().calculate("2147483647"));
    }
}
