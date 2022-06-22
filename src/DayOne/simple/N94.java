package DayOne.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-02-25 10:45
 */
public class N94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            medium(root, result);
        }
        return result;
    }

    private void medium(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        medium(root.left, result);
        result.add(root.val);
        medium(root.right, result);
    }
}
