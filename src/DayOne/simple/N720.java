package DayOne.simple;

import java.util.Set;

/**
 * @author hdq
 * @create 2022-03-17 10:10
 */
public class N720 {
    public String longestWord(String[] words) {

        Set<String> set = new java.util.HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        String res = "";
        for (String word : words) {
            int n = word.length(), m = res.length();
            // 比现有的结果小  剪枝  排除
            if (n < m) {
                continue;
            }
            if (n == m && word.compareTo(res) > 0) {
                continue;
            }
            boolean flag = true;
            for (int i = 1; i <= n && flag; i++) {
                if (!set.contains(word.substring(0, i))) {
                    flag = false;
                }
            }
            if (flag) {
                res = word;
            }
        }
        return res;
    }
}
