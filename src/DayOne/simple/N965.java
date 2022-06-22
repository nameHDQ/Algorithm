package DayOne.simple;

import java.util.Deque;
import java.util.List;

/**
 * @author hdq
 * @create 2022-05-24 12:13
 */
public class N965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val != root.val) return false;
        Deque<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.val != node.val) return false;
                if (node.right != null && node.right.val != node.val) return false;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return true;
    }
}
