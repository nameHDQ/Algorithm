package DayOne.medium;

import java.util.*;

public class N131 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        Stack<String> deque = new Stack<>();

        backTrack(0, s.length(), deque, s);
        return res;
    }
    void backTrack(int start, int end, Stack<String> temp, String str){
        if (start == end){
            res.add(new ArrayList<>(temp));
            return;
        }
        int len = end - start;
        for (int i = 1; i <= len; i++) {
            if (isChar(str.substring(start, start + i))){
                temp.push(str.substring(start, start + i));
                backTrack(start + i, end, temp, str);
                temp.pop();
            }
        }
    }
    public boolean isChar(String str){
        if (str.length() == 1){
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left <= right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        new N131().partition("aab");
    }
}
