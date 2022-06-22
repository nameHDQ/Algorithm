package DayOne.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-06-19 13:52
 */
public class N508 {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount){
                res.add(entry.getKey());
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;

        int cnt = dfs(root.left) + dfs(root.right) + root.val;
        map.put(cnt, map.getOrDefault(cnt, 0) + 1);
        maxCount = Math.max(map.get(cnt), maxCount);
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3);
        node1.left = node2;
        node1.right = node3;
        new N508().findFrequentTreeSum(node1);
    }
}
