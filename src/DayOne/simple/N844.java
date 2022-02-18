package DayOne.simple;

import java.util.Stack;

/**
 * @author hdq
 * @create 2021-12-07 11:38
 */
public class N844 {
    Stack<Character> c1 = new Stack<>();
    Stack<Character> c2 = new Stack<>();
    public boolean backspaceCompare(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) !='#'){
                c1.add(s.charAt(i));
            }else {
                if (c1.size() == 0){
                    continue;
                }
                c1.pop();
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) !='#'){
                c2.add(t.charAt(i));
            }else {
                if (c2.size() == 0){
                    continue;
                }
                c2.pop();
            }
        }
        while (c1.size() > 0&&c2.size() >0){
            if (c1.pop() != c2.pop()){
                return false;
            }
        }
        if (c1.size()==0 &&c2.size() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        N844 n844 = new N844();
        System.out.println(n844.backspaceCompare("a#c", "b"));
    }
}
