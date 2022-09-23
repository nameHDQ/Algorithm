package weekcmplication.week311;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class N3 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root.left == null && root.right == null) return root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root.left);
        deque.offer(root.right);
        int level = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode left = deque.poll();
                TreeNode right = deque.poll();
                if (level %2 == 0) {
                    int tem = left.val;
                    left.val = right.val;
                    right.val = tem;
                }
                if (left.left != null) deque.offer(left.left);
                if (left.right != null) deque.offer(left.right);
                if (right.left != null) deque.offer(right.left);
                if (right.right != null) deque.offer(right.right);
            }
            level++;
        }
        return root;
    }
}
