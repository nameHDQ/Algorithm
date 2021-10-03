package DayOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-08-29 13:46
 */
public class N784 {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        dfs(chars,0,chars.length);

        return ans;
    }
    public void dfs(char[] chars,int start,int end){
        ans.add(new String(chars));

        for (int i = start; i < end; i++) {
            if (!Character.isDigit(chars[i])){
                char temp = chars[i];
                if (chars[i] -'a' >= 0){
                    chars[i] = (char) (chars[i]-32);
                }else {
                    chars[i] = (char) (chars[i]+32);
                }
                dfs(chars,i+1,end);
                chars[i] = temp;
            }

        }
    }

    public static void main(String[] args) {
        N784 n784 = new N784();
        List<String> a1b2 = n784.letterCasePermutation("a1b2");
        for (String str :
                a1b2) {
            System.out.println(str);
        }
    }
}
