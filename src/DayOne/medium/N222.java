package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class N222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int result = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) deque.add(poll.left);
                if (poll.right != null) deque.add(poll.right);
            }
            result += size;
        }
        return result;
    }
}
