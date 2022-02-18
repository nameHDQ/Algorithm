package DayOne.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author hdq
 * @create 2021-12-14 12:39
 */
public class N22 {
    List<String> res = new LinkedList<>();
    String temp = "";
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        temp +="(";
        left--;
        dfs(left,right);
        return res;
    }
    public void dfs(int left,int right){
        if (left == 0 && right == 0){
            res.add(new String(temp));
            return;
        }
        //取左括号
        if (left > 0 &&right !=0){
            temp +="(";
            dfs(--left, right);
            temp = temp.substring(0, temp.length()-1);
            left++;
        }
        //取右括号
        if (right > 0){
            temp +=")";
            dfs(left, --right);
            temp = temp.substring(0, temp.length()-1);
            right++;
        }
    }

    public static void main(String[] args) {
        N22 n22 = new N22();
        n22.generateParenthesis(3);
    }

}
