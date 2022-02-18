package DayOne.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-14 13:04
 */
public class N17 {
    String[][] chr = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},
            {"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},
            {"w","x","y","z"}};
    List<String> res = new LinkedList<>();
    String temp = "";
    boolean[] state = new boolean[10];
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return res;
        }
            state[digits.charAt(0)-'0'] = true;
            String[] loc = chr[digits.charAt(0)-'0'];
            for (String s : loc) {
                temp += s;
                dfs(1, digits);
                temp = "";
            }
        return res;
    }
    public void dfs(int curLen,String digits){
        if (curLen == digits.length()){
            res.add(new String(temp));
            return;
        }
            String[] loc = chr[digits.charAt(curLen)-'0'];
            for (String s : loc) {
                temp += s;
                dfs(curLen+1, digits);
                temp = temp.substring(0, temp.length()-1);
            }
        }
}
