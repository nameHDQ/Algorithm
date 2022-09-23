package DayOne.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) deque.add(poll.left);
                if (poll.right != null) deque.add(poll.right);
                temp.add(poll.val);
            }
            res.add(temp);
        }
        return res;
    }
}
