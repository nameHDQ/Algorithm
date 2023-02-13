package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class N402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while ( k > 0 && !deque.isEmpty() && num.charAt(i) < deque.peek()){
                deque.pop();
                k--;
            }
            deque.push(num.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            if (deque.size() != 1){
                deque.pop();
            }else {
                break;
            }

        }

        String res = "";
        while (!deque.isEmpty()){
            res = deque.pop() + res;
        }
        int index = 0;
        while (index < res.length() - 1 && res.charAt(index) == '0'){
            index++;
        }
        return res.substring(index);
    }

    public static void main(String[] args) {
        String str = "10001";
        System.out.println(new N402().removeKdigits(str, 4));
    }
}
