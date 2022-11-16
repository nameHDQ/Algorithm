package DayOne.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N93 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        Stack<String> deque = new Stack<>();
        backTrack(0, s.length(), deque, s, "", 0);
        return res;
    }
    void backTrack(int start, int end, Stack<String> temp, String str, String resStr, int count){
        if (count == 4){
            if (start == end){
                res.add(resStr.substring(0, resStr.length() - 1));
            }
            return;
        }
        for (int i = 1; i <= 3 && start + i <= str.length(); i++) {
            int num = Integer.parseInt(str.substring(start, start + i));
            if (num >=0 && num <= 255){
                temp.push(str.substring(start, start + i));
                backTrack(start + i, end, temp, str, resStr + str.substring(start, start + i) + ".", count + 1);
                temp.pop();
            }else {
                continue;
            }
            if (str.charAt(start) == '0') {
                break;
            }
        }
    }


}
