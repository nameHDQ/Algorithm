package DayOne.simple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class N104 {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root == null) return 0;
        int depth = 1;
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) deque.add(poll.left);
                if (poll.right != null) deque.add(poll.right);
            }
            depth++;
        }
        return depth;
    }
}
