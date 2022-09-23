package DayOne.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N145 {
    // 关键点在于root节点的两次访问中，是压栈还是不压放入结果
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !deque.isEmpty()){

            // 一直往访问左子树
            while (root != null){
                deque.push(root);
                root = root.left;
            }

            // 此时root为空，访问父节点
            root = deque.pop();
            // 右子树为空 或者右子树访问过了
            if (root.right == null || root.right == pre){
                res.add(root.val);
                pre = root;
                // 一个子树访问完成
                root = null;
            }else {
                // 右子树还没访问，先把父节点入对，最后在访问
                deque.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
