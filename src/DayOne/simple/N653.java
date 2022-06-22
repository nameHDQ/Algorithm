package DayOne.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-03-21 13:17
 */
public class N653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Map<Integer, Integer> map = new HashMap<>();
        return find(root, k, map);
    }

    private boolean find(TreeNode root, int k, Map<Integer, Integer> map) {
        if (root == null) return false;
        if (map.containsKey(k - root.val)) return true;
        map.put(root.val, root.val);
        return find(root.left, k, map) || find(root.right, k, map);
    }
}
