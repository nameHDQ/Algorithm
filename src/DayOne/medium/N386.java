package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-03-18 20:44
 */
public class N386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(n, i, res);
        }
        return res;
    }

    private void dfs(int n, int i, List<Integer> res) {
        if (i > n) return;
        res.add(i);
        // i * 10 + j 表示i相同的情况下比较i + 1 位置是否相同 字典序比较是按照字符串比较的
        for (int j = 0; j < 10; j++) {
            dfs(n, i * 10 + j, res);
        }
    }

    public static void main(String[] args) {
        for (Integer integer : new N386().lexicalOrder(13)) {
            System.out.println(integer);
        }
    }
}
