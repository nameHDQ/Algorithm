package DayOne.medium;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class N150 {
    public int evalRPN(String[] tokens) {


        Deque<String> deque = new ArrayDeque<>();

        for (String token : tokens) {
            if ((token.startsWith("-")&& token.length() > 1) || token.substring(0,1).matches("[0-9]")){
                deque.push(token);
            }else {
                int num1 = Integer.parseInt(deque.pop());
                int num2 = Integer.parseInt(deque.pop());
                int result = 0;
                if (token.equals("+")){
                    result = num1 + num2;
                }
                if (token.equals("-")){
                    result = num1 - num2;
                }
                if (token.equals("*")){
                    result = num1 * num2;
                }
                if (token.equals("/")){
                    result = num2 / num1;
                }
                deque.push("" + result);
            }
        }
        return Integer.parseInt(deque.pop());
    }

    public static void main(String[] args) {
        String[] strs = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        new N150().evalRPN(strs);
    }
}
