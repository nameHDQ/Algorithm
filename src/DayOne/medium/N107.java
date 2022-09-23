package DayOne.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> deque = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> cur = new ArrayDeque<>();
        cur.add(root);
        while (!cur.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = cur.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = cur.poll();
                if (poll.left != null) cur.add(poll.left);
                if (poll.right != null) cur.add(poll.right);
                temp.add(poll.val);
            }
            deque.push(temp);
        }
        while (!deque.isEmpty()){
            res.add(deque.pop());
        }
        return res;
    }
}
