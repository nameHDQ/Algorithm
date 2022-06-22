package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-05-01 14:19
 */
public class N1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        dfs(root1, res1);
        dfs(root2, res2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < res1.size() && j < res2.size()) {
            if (res1.get(i) < res2.get(j)) {
                res.add(res1.get(i++));
            }else {
                res.add(res2.get(j++));
            }
        }
        while (i < res1.size()) {
            res.add(res1.get(i++));
        }
        while (j < res2.size()) {
            res.add(res2.get(j++));
        }
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
