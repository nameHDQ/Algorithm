package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class N394 {
    public String decodeString(String s) {

        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        Deque<String> preStrs = new ArrayDeque<>();
        Deque<Integer> preNums = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '['){
                preStrs.push(res.toString());
                res = new StringBuilder();
                preNums.push(count);
                count = 0;
            }else if (chars[i] == ']'){
                StringBuilder tempStr = new StringBuilder();
                int tempCount = preNums.pop();
                for (int j = 0; j < tempCount; j++) {
                    tempStr.append(res);
                }
                res = new StringBuilder(preStrs.pop() + tempStr.toString());

            }else if (chars[i] >= '0' && chars[i] <= '9'){
                count = count * 10 + Integer.parseInt(chars[i] + "");
            }else {
                res.append(chars[i]);
            }
        }
        return res.toString();
    }
}
