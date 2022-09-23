package DayOne.simple;

import java.util.ArrayList;
import java.util.List;

public class N144 {
    List<Integer> res =new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) return null;

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
